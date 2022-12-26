package com.example.queue.model;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

//        char[] numbers = {'9', '8', '7', '6', '5', '4', '3', '2', '1', '0'};
//        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//
//        String numbersString = Arrays.toString(numbers);
//        String alphabetsString = Arrays.toString(alphabets);
//
//        String current = "a0a0";
//
//        char[] currentChar = current.toCharArray();
//        for (int i = currentChar.length - 1; i >= 0 ; i--) {
//            System.out.print(currentChar[i]);
//            for (int j = 0; j < ; j++) {
//
//            }
//        }

        int numberMin = 48;
        int numberMax = 57;

        int letterMin = 97;
        int letterMax = 122;

        String current = "a0b9";
        int[] currentToIntArray = new int[current.length()];
        boolean isAllMax = true;
        char[] result;
        for (int i = 0; i < current.length(); i++) {
            currentToIntArray[i] = current.charAt(i);
            if (i % 2 == 0) {
                if (currentToIntArray[i] != letterMax) {
                    isAllMax = false;
                }
            } else {
                if (currentToIntArray[i] != numberMax) {
                    isAllMax = false;
                }
            }
        }

        if (isAllMax) {
            result = new char[currentToIntArray.length + 2];
            for (int i = 0; i < result.length; i++) {
                if (i % 2 == 0) {
                    result[i] = (char) letterMin;
                } else {
                    result[i] = (char) numberMin;
                }
            }
        } else {
            result = new char[currentToIntArray.length];
            for (int i = currentToIntArray.length - 1; i >= 0; i--) {
                if (i % 2 != 0) {
                    if (currentToIntArray[i] < numberMax) {
                        currentToIntArray[i] += 1;
                        break;
                    }
                    if (currentToIntArray[i] == numberMax) {
                        currentToIntArray[i] = numberMin;
                    }
                } else {
                    if (currentToIntArray[i] < letterMax) {
                        currentToIntArray[i] += 1;
                        break;
                    }
                    if (currentToIntArray[i] == letterMax) {
                        currentToIntArray[i] = letterMin;
                    }
                }
            }
            for (int i = 0; i < currentToIntArray.length; i++) {
                result[i] = (char) currentToIntArray[i];
            }
        }

    }


}
