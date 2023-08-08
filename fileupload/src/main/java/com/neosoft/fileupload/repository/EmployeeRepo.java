package com.neosoft.fileupload.repository;

import com.neosoft.fileupload.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
