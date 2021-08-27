package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "department_id", nullable = true)
    private Department department;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    private Calendar birthDate;
}
