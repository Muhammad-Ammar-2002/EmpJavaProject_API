package com.example.emp.model;

import com.example.emp.Entity.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String fname;
    private String lname;
    private Double salary;
    private Double phone;
    private Double socialId;
    private String department;
    private ProjectDTO projectDto;

//    public String toString() {
//        return "\nEmployee{\n\tid=" + id + ",\n\t name='" + fname + "',\n\t salary='" + salary + "'\n}\n";
//    }

}
