package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Employee> employees;
}
