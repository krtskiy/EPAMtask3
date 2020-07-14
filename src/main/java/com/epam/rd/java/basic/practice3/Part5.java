package com.epam.rd.java.basic.practice3;

public class Part5 {

    public static void main(String[] args) {
        //just my empty main class
        System.out.println(roman2Decimal("XVII"));
    }

    public static String decimal2Roman(int dec) {
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
        int[] decim = {1, 4, 5, 9, 10, 40, 50, 90, 100};
        StringBuilder str = new StringBuilder();
        int x = decim.length - 1;
        while (dec > 0) {
            if (decim[x] > dec) {
                x--;
            } else {
                str.append(roman[x]);
                dec -= decim[x];
            }
        }
        return str.toString();
    }

    public static int roman2Decimal(char roman) {
        switch (roman) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            default: return -1;
        }
    }

    public static int roman2Decimal(String roman) {
        if (roman.length() == 0) {
            return 0;
        }
        int result = 0;
        int prevNumber = roman2Decimal(roman.charAt(0));
        for (int i = 1; i < roman.length(); i++) {
            int number = roman2Decimal(roman.charAt(i));
            if (number <= prevNumber) {
                result += prevNumber;
            } else {
                result -= prevNumber;
            }
                prevNumber = number;
        }
        result += prevNumber;
        return result;
    }


}
