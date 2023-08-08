package com.neosoft.fileupload.service;

import com.neosoft.fileupload.model.Employee;
import com.neosoft.fileupload.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public Page<Employee> getAllEmployee(Pageable pageable)
    {
        //Page<Employee> posts = employeeRepo.findAll(pageable);
        return employeeRepo.findAll(pageable);

    }

}
