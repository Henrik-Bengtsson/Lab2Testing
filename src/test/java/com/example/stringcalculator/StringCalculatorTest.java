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

    @Test
    void returnNineWithFourAndFiveAsInput() {
        int result = StringCalculator.add("4,5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    void inputFourNumbersAndReturnSum18() {
        int result = StringCalculator.add("3,4,5,6");
        assertThat(result).isEqualTo(18);
    }

    @Test
    void shouldReturn6WhenInputContainsNewLine() {
        int result = StringCalculator.add("1\n2,3");
        assertThat(result).isEqualTo(6);
    }
}
