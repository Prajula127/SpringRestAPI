// Write your code here
package com.example.employee;
import java.util.*;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();
    Employee getEmployeeById(int employeeId);
    Employee addEmployee(Employee emp);
    Employee updateEmployee(int employeeId, Employee emp);
    void deleteEmployee(int employeeId);
}