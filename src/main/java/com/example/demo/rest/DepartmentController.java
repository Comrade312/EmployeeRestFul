package com.example.demo.rest;

import com.example.demo.dto.Department;
import com.example.demo.dto.Employee;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getEmployeeById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<Department> updateEmployee(@RequestBody Department department, @PathVariable Long departmentId) {
        departmentService.updateDepartment(department);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Department> createEmployee(@RequestBody Department department) {
        departmentService.createDepartment(department);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}