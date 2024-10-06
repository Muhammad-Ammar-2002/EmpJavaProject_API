package com.example.emp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class EmployeeDTO {

    private long id;
    private String name;
    private String salary;
    //private String hireDate="DTO/2024";//+ "',\n\t hireDate='" +hireDate

    public String toString() {
        return "\nEmployee{\n\tid=" + id + ",\n\t name='" + name + "',\n\t salary='" + salary + "'\n}\n";
    }

}
