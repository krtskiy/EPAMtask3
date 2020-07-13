package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        //just my empty main class
    }

    static String input = Util.getInput("part1.txt");

    public static String convert1(String input) {
//        String regex1 = "\\s([a-z]+|[а-я]+)|(\\b([a-z]+)@(google|mail)\\.([a-z]+))";
        String regex1 = ";[A-Z].+;|;[а-я].+;|[A-Z].+\\s";
        Pattern p1 = Pattern.compile(regex1);
        String[] test = p1.split(input);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < test.length; i++) {
            if (i < test.length - 1) {
                str.append(test[i] + ": ");
            } else {
                str.append(test[i]);
            }
        }
        return str.toString();
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