package com.example.demo.service;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.Department;
import com.example.demo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public void createDepartment(Department department){
        departmentDao.save(department);
    }

    public void updateDepartment(Department department){
        departmentDao.save(department);
    }

    public void deleteDepartmentById(Long departmentId){
        departmentDao.deleteById(departmentId);
    }

    public List<Department> getAllDepartments(){
        return departmentDao.findAll();
    }

    public Optional<Department> getDepartmentById(Long id){
        return departmentDao.findById(id);
    }
}
