package com.example.demo.rest;

import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployeesLimitedList(25));
        model.addAttribute("departments", departmentService.getAllDepartmentsLimitedList(10));
        return "main";
    }

    @GetMapping("/employee/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "addEmployee";
    }

    @GetMapping("/employee/view/{id}")
    public String employeePage(Model model, @PathVariable Long id) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "viewEmployee";
    }

    @GetMapping("/employee/view/all")
    public String allEmployeesPage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "viewAllEmployees";
    }

    @GetMapping("/department/add")
    public String addDepartmentForm() {
        return "addDepartment";
    }

    @GetMapping("/department/view/{id}")
    public String departmentPage(@PathVariable Long id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "viewDepartment";
    }

    @GetMapping("/department/view/all")
    public String allDepartmentPage(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "viewAllDepartments";
    }

}
