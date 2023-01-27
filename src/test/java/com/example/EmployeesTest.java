package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeesTest {

    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
    BankService bankService = Mockito.mock(BankService.class);
    
    Employees employees = new Employees(employeeRepository, bankService);

    @Test
    void TestNumberOfPaidEmployeesShouldReturnTwo() {
        Employee employee1 = new Employee("1", 50000);
        Employee employee2 = new Employee("2", 70000);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        assertThat(employees.payEmployees()).isEqualTo(2);
    }
}