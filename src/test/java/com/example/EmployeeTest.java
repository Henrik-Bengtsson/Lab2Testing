package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

    Employee employee;

    @BeforeEach
    void setEmployee(){
        employee = new Employee("1", 50000);
    }

    @Test
    void callGetIdAndReturnCorrectId() {
        assertThat(employee.getId()).isEqualTo("1");
    }

    @Test
    void callSetIdAndChangeId() {
        employee.setId("2");

        assertThat(employee.getId()).isEqualTo("2");
    }

    @Test
    void callGetSalaryAndReturnCorrectId() {
        assertThat(employee.getSalary()).isEqualTo(50000);
    }

    @Test
    void callSetSalaryAndChangeSalary() {
        employee.setSalary(70000);

        assertThat(employee.getSalary()).isEqualTo(70000);
    }

    @Test
    void callIsPaidAndCheckNewEmployeeAreCreatedWithFalsePaid() {
        assertThat(employee.isPaid()).isFalse();
    }

    @Test
    void callSetPaidAndChangeStatusToPaid() {
        employee.setPaid(true);

        assertThat(employee.isPaid()).isTrue();
    }

    @Test
    void testToString() {
        String testEmployee = "Employee [id=1, salary=50000.0]";

        assertThat(employee.toString()).isEqualTo(testEmployee);
    }
}