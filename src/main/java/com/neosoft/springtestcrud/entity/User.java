package com.neosoft.springtestcrud.entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    private int id;
    private String name;
    private int age;
    private String address;

}