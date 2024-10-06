package com.example.emp.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    private long id;
    private String name;
    private String salary;
    private String startDate;
    private String endDate;


}
