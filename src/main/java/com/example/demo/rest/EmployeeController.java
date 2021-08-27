package com.example.demo.rest;

import com.example.demo.dto.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/main")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/main/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/main")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/main")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long employeeId) {
        employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/main/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
