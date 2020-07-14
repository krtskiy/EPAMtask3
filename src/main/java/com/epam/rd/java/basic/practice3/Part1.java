package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        //just my empty main class

        System.out.println(convert1(input));
    }

    static String input = Util.getInput("part1.txt");

    public static String convert1(String input) {
//        String regex1 = "\\s([a-z]+|[а-я]+)|(\\b([a-z]+)@(google|mail)\\.([a-z]+))";
//        String regex1 = ";[A-Z].+;|;[а-я].+;|[A-Z].+\\s";
        String regex1 = "^[A-Z][a-z]+;[A-Z][a-z]+;[A-Z][a-z]+\\s";  // убирает первую строку
        Pattern p1 = Pattern.compile(regex1);
        StringBuilder str = new StringBuilder();
        String[] test = p1.split(input);
        for (int i = 0; i < test.length; i++) {
            str.append(test[i]);
        }
        String str1 = str.toString();
        String regex2 = ";[^;]*;";
        Pattern p2 = Pattern.compile(regex2);
        str1 = str1.replaceAll(regex2, ": ");
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