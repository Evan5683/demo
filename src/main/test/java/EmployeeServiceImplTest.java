package com.restful.demo.test;

import com.restful.demo.Employee;
import com.restful.demo.service.EmployeeServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        // 在每个测试开始前初始化
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee(1L, "Test Employee", 30);
        Employee savedEmployee = employeeService.addEmployee(employee);

        assertNotNull(savedEmployee);
        assertEquals("Test Employee", savedEmployee.getName());
    }

    @Test
    void getEmployeeById() {
        Employee employee = new Employee(1L, "Test Employee", 30);
        employeeService.addEmployee(employee);

        Employee foundEmployee = employeeService.getEmployeeById(1L);
        assertNotNull(foundEmployee);
        assertEquals(1L, foundEmployee.getId());
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee(1L, "Test Employee", 30);
        employeeService.addEmployee(employee);

        Employee updatedEmployee = new Employee(1L, "Updated Employee", 35);
        Employee result = employeeService.updateEmployee(1L, updatedEmployee);

        assertNotNull(result);
        assertEquals("Updated Employee", result.getName());
        assertEquals(35, result.getAge());
    }

    @Test
    void deleteEmployee() {
        Employee employee = new Employee(1L, "Test Employee", 30);
        employeeService.addEmployee(employee);

        employeeService.deleteEmployee(1L);
        assertNull(employeeService.getEmployeeById(1L));
    }

    @Test
    void getAllEmployees() {
        employeeService.addEmployee(new Employee(1L, "Test Employee 1", 30));
        employeeService.addEmployee(new Employee(2L, "Test Employee 2", 40));

        assertEquals(2, employeeService.getAllEmployees().size());
    }
}
