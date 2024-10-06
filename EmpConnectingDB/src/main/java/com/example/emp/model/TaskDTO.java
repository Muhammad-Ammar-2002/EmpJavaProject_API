package com.example.emp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private long id;
    private String name;
    private String salary;
    private String startDate="DTO/2002";
    private String endDate="DTO/2024";

    public String toString() {
        return "\nTask{\n\tid=" + id + ",\n\t Task name='" + name + "',\n\t salary='" + salary + "',\n\t Start Date='" +startDate+ "',\n\t End Date='" +endDate+ "'\n}\n";
    }
}
