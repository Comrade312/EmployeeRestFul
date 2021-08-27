package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void createEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public void updateEmployee(Long employeeId, Employee employee) {
        if (employee != null && employeeId.equals(employee.getEmployeeId())) {
            if (!employeeDao.findById(employee.getEmployeeId()).isPresent()) {
                //throw new EmployeeNotFound(employee.getEmployeeId());
            }
        } else {
            //throw new BadRequestParametersException("Error in data: path variable id must be not null and equal city id");
        }
        employeeDao.save(employee);
    }

    public void deleteEmployeeById(Long employeeId) {
        if (!employeeDao.findById(employeeId).isPresent()) {
            //throw new EmployeeNotFound(employeeId);
        }
        employeeDao.deleteById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeDao.findById(id);
    }

}
