package com.practice.employee.controller;

import com.practice.employee.model.Employee;
import com.practice.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @RequestMapping(value="/employees", method= RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp) {
        return empService.createEmployee(emp);
    }

    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public List<Employee> readEmployees() {
        return empService.getEmployees();
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
    public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
        return empService.updateEmployee(id, empDetails);
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
        empService.deleteEmployee(id);
    }
}
