package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        //just my empty main class
        convert2(input);
    }

    static String input = Util.getInput("part1.txt");

    public static String convert1(String input) {
        StringBuilder str = new StringBuilder();
        String regex1 = "^[A-Z][a-z]+;[A-Z][a-z]+;[A-Z][a-z]+\\s";
        Pattern p1 = Pattern.compile(regex1);
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
        StringBuilder str = new StringBuilder();
//        String regex1 = "(^\\w+;\\w+;\\w+\\s)|((?<=\\s)[a-zа-я]+)|([A-ZА-Я][a-zа-я]+(?=\\s))|((?<=\\s)[A-ZА-Я][a-zа-я]+)|((?<=;)[a-zа-я]+@[a-zа-я]+\\.[a-zа-я]+)";
        String regex1 = "(^\\w+;\\w+;\\w+\\s)";
        input = input.replaceAll(regex1, "");
        String regex2 = "((?<=\\s)[a-zа-я]+;)";
        input = input.replaceAll(regex2, "");
        String regex3 = ";";
        input = input.replaceAll(regex3, " (email: ");
        String regex4 = "(\\.com)";
        input = input.replaceAll(regex4, ".com)");
        String regex5 = "^\\s";
        input = input.replaceAll(regex5, "");
        System.out.println(input);
        return null;
    }

    public static String convert3(String input) {
        return null;
    }

    public static String convert4(String input) {
        return null;
    }
}