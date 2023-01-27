package com.example.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void returnZeroForEmptyString() {
        int result = StringCalculator.add("");

        assertThat(result).isEqualTo(0);
    }
}
