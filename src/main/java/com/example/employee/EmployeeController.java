/*
 * You can use the following import statements
 * 
 * 
 * 
 */
package com.example.employee;

import org.springframework.web.bind.annotation.*;
import java.util.*;
// Write your code here
@RestController
public class EmployeeController {
    EmployeeService empService = new EmployeeService();
    
    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees() {
        return empService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
        return empService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        return empService.addEmployee(emp);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee emp) {
        return empService.updateEmployee(employeeId, emp);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
        empService.deleteEmployee(employeeId);
    }
}