package com.neosoft.springtestcrud;

import com.neosoft.springtestcrud.entity.User;
import com.neosoft.springtestcrud.repository.UserRepository;
import com.neosoft.springtestcrud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@SpringBootTest
class SpringtestcrudApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new User(376, "Danile", 31, "USA"), new User(958, "Huy", 35, "UK")).collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}

	@Test
	public void getUserbyAddressTest()
	{
		String address="Badlapur";
		when(repository.findByAddress(address)).thenReturn(Stream.of(new User(123,"Kajal",32,"Badlapur")).collect(Collectors.toList()));
		assertEquals(1,service.getUserbyAddress(address).size());
	}


	@Test
	public void saveUserTest(){
		User user = new User(122,"anugya",10,"kharghar");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,service.addUser(user));
	}

	@Test
	public void deleteUserTest() {
		User user = new User(999, "Pranya", 33, "Pune");
		service.deleteUser(user);
		verify(repository, times(1)).delete(user);
	}



}
