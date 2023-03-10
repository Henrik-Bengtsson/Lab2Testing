package com.example.stringcalculator;

import org.junit.jupiter.api.Test;

import static com.example.stringcalculator.StringCalculator.add;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void returnZeroForEmptyString() {
        int result = add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void returnOneWithOneAsInput() {
        int result = add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void returnThreeWithOneAndTwoAsInput() {
        int result = add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void returnNineWithFourAndFiveAsInput() {
        int result = add("4,5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    void inputFourNumbersAndReturnSum18() {
        int result = add("3,4,5,6");
        assertThat(result).isEqualTo(18);
    }

    @Test
    void shouldReturn6WhenInputContainsNewLine() {
        int result = add("1\n2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldReturn5WithDifferentDelimiters() {
        int result = add("//;\\n2;3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void shouldThrowExceptionIfEnteringNegativeNumber() {
        assertThatThrownBy(() -> add("-1")).hasMessageContaining("Negatives not allowed [-1]");
    }

    @Test
    void shouldThrowExceptionWithMultipleNegativeNumbers() {
        assertThatThrownBy(() -> add("-1,2,-3,-4")).hasMessageContaining("Negatives not allowed [-1, -3, -4]");
    }

    @Test
    void shouldIgnoreNumbersBiggerThanThreeDigits() {
        int result = add("3,1000,2000,5");
        assertThat(result).isEqualTo(8);
    }

    @Test
    void testForDelimitersOfAnyLength() {
        int result = add("//[***]\n1***2***3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void testForMultipleDelimitersInARow() {
        int result = add("//[*][%]\\n1*2%3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void testForMultipleDelimitersAndAnyLength() {
        int result = add("//[*****][%%%%]\\n1****2%%%%3");
        assertThat(result).isEqualTo(6);
    }
}
