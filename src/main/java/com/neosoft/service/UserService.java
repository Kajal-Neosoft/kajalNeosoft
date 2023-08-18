package com.neosoft.service;

import com.neosoft.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class UserService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public User createUser(User user) {
        hibernateTemplate.save(user);
        return user;
    }

    public User getUserById(Long userId) {
        return hibernateTemplate.get(User.class, userId);
    }




    public User updateUser(User user) {
         log.info("user name {}",user.getEmail());
        try {
            hibernateTemplate.persist(user);
        }catch (Exception e){
            e.printStackTrace();
        }
         return user;
    }


    public void deleteUser(Long userId) {
        User user = hibernateTemplate.get(User.class, userId);
        if (user != null) {
            hibernateTemplate.delete(user);
        }
    }
}
