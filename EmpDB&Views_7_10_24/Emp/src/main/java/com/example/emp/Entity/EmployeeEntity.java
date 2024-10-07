package com.example.emp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name="employees")

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name="fname")
    private String fname;
//    @Column(name="lname")
    private String lname;
    private Double salary;
    private Double phone;
    private Double socialid;
    private String department;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity projectEntity;



}
