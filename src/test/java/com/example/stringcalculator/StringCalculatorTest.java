package com.example.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void returnZeroForEmptyString() {
        int result = StringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void returnOneWithOneAsInput() {
        int result = StringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void returnThreeWithOneAndTwoAsInput() {
        int result = StringCalculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }
}
