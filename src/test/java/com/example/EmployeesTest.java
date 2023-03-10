package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeesTest {

    BankService bankService = Mockito.mock(BankService.class);
    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
    Employees employees = new Employees(employeeRepository, bankService);
    Employee employee1, employee2;

    @BeforeEach
    void setUp() {
        employee1 = new Employee("1", 50000);
        employee2 = new Employee("2", 70000);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }

    @Test
    void TestNumberOfPaidEmployeesShouldReturnTwo() {
        assertThat(employees.payEmployees()).isEqualTo(2);
    }

    @Test
    void testNumberDecreasingWhenThrowException() {
        Mockito.doThrow(RuntimeException.class).when(bankService).pay("2", 70000);
        assertThat(employees.payEmployees()).isEqualTo(1);
    }

    @Test
    void testEmployee1IsPaidSetToFalseWhenThrowException() {
        Mockito.doThrow(RuntimeException.class).when(bankService).pay("1", 50000);
        employees.payEmployees();
        assertThat(employeeRepository.findAll().get(0).isPaid()).isFalse();
    }
}