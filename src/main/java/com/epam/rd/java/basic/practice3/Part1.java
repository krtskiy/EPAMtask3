package com.epam.rd.java.basic.practice3;

import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        //just my empty main class

    }

    static String input = Util.getInput("part1.txt");

    public static String convert1(String input) {
        String regex1 = "^[A-Z][a-z]+;[A-Z][a-z]+;[A-Z][a-z]+\\s";
        Pattern p1 = Pattern.compile(regex1);
        StringBuilder str = new StringBuilder();
        String[] inputWithoutFirst = p1.split(input);
        for (int i = 0; i < inputWithoutFirst.length; i++) {
            str.append(inputWithoutFirst[i]);
        }
        String str1 = str.toString();
        String regex2 = ";[^;]*;";
        str1 = str1.replaceAll(regex2, ": ");
        String regex3 = "$";
        str1 = str1.replaceAll(regex3, "\n");
        return str1;
    }

    public static String convert2(String input) {
        return null;
    }

    public static String convert3(String input) {
        return null;
    }

    public static String convert4(String input) {
        return null;
    }
}