package com.restful.demo.service;

import com.restful.demo.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        for (Employee e : employees) {
            if (e.getId() == id) { // Changed to '=='
                e.setName(employee.getName());
                e.setAge(employee.getAge());
                return e;
            }
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employees.removeIf(e -> e.getId() == id); // Changed to '=='
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employees.stream()
                .filter(e -> e.getId() == id) // Use '==' for comparing primitive types
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
