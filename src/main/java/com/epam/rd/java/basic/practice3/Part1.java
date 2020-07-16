package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        //just my empty main class
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
        int index = 0;
        String[] strArr = new String[4];
        StringBuilder test = new StringBuilder();
        StringBuilder str = new StringBuilder();
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
        String regex6 = "[\\wа-яА-Я]+\\s[\\wа-яА-Я]+\\s";
        String regex7 = "([\\wа-яА-Я]+(?=\\s[\\wа-яА-Я]))";
        String regex8 = "((?<=\\s)[\\wа-яА-Я]+(?=\\s\\())";
        Pattern p1 = Pattern.compile(regex8);
        Matcher m1 = p1.matcher(input);
        Pattern p2 = Pattern.compile(regex7);
        Matcher m2 = p2.matcher(input);
        while (m1.find() && m2.find()) {
            test.append(m1.group());
            strArr[index] = m1.group() + " " + m2.group();
            index++;
        }
        String[] emails = input.split(regex6);
        for (int i = 0, j = 1; i < strArr.length; i++, j++) {
            str = str.append(strArr[i]).append(' ').append(emails[j]);
        }
        return str.toString();
    }

    public static String convert3(String input) {
        return null;
    }

    public static String convert4(String input) {
        return null;
    }
}