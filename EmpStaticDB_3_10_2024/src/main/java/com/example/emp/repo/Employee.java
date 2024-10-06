package com.example.emp.repo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Employee {

    private long id;
    private String name;
    private String salary;
    private String hireDate="2002";

    public String toString() {
        return "\nEmployee{\n\tid=" + id + ",\n\t name='" + name + "',\n\t salary='" + salary + "',\n\t hireDate='" +hireDate+ "'\n}\n";
    }

}
