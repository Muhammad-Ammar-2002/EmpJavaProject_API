package com.example.emp.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor

public class EmployeeEntity {

    private long id;
    private String name;
    private String salary;
    private String hireDate="2002";



}
