/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */


package com.example.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

// Do not modify the below code

public class EmployeeService implements EmployeeRepository {

    private static HashMap<Integer, Employee> employeeList = new HashMap<>();
    int employeeId = 7;

    public EmployeeService() {
        employeeList.put(1, new Employee(1, "John Doe", "johndoe@example.com", "Marketing"));
        employeeList.put(2, new Employee(2, "Jane Smith", "janesmith@example.com", "Human Resources"));
        employeeList.put(3, new Employee(3, "Bob Johnson", "bjohnson@example.com", "Sales"));
        employeeList.put(4, new Employee(4, "Alice Lee", "alee@example.com", "IT"));
        employeeList.put(5, new Employee(5, "Mike Brown", "mbrown@example.com", "Finance"));
        employeeList.put(6, new Employee(6, "Sara Lee", "slee@example.com", "Operations"));

    }

    // Do not modify the above code

    // Write your code here
    @Override
    public ArrayList<Employee> getEmployees() {
        Collection<Employee> empList = employeeList.values();
        ArrayList<Employee> emp = new ArrayList<>(empList);
        return emp;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee emp = employeeList.get(employeeId);
        if (emp == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            return emp;
        }
    }

    @Override
    public Employee addEmployee(Employee emp) {
        emp.setEmployeeId(employeeId);
        employeeList.put(employeeId, emp);
        employeeId += 1;
        return emp;
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee emp) {
        Employee newEmp = employeeList.get(employeeId);
        if (newEmp == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (emp.getEmployeeName() != null) {
            newEmp.setEmployeeName(emp.getEmployeeName());
        }
        if (emp.getEmail() != null) {
            newEmp.setEmail(emp.getEmail());
        }
        if (emp.getDepartment() != null) {
            newEmp.setDepartment(emp.getDepartment());
        }
        return newEmp;
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee emp = employeeList.get(employeeId);
        if (emp != null) {
            employeeList.remove(employeeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}