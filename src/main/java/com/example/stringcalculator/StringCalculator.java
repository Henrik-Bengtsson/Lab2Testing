package com.example.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    public static int add(String numbers) {
        String[] strings = numbers.split("[^-\\d]");
        var numberList = Arrays.stream(strings).filter(x -> x.matches("\\d{1,3}")).toList();
        var negativeList = Arrays.stream(strings).filter(n -> n.matches("(-\\d+)")).toList();
        int result = 0;

        if(numbers.isEmpty())
            return 0;
        else if(negativeList.size() > 0)
            throw new RuntimeException("Negatives not allowed " + negativeList);
        else{
            for (int i = 0; i < numberList.size(); i++) {
                result = result + Integer.parseInt(numberList.get(i));
            }
            return result;
        }
    }
}
