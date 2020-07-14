package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        //just my empty main class

    }

    static String input = Util.getInput("part2.txt");
    public static String convert(String input) {
        StringBuilder str = new StringBuilder();
        Pattern pattern = Pattern.compile("\\b[A-Za-z]\\b");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            str.append(input.substring(matcher.start(), matcher.end()));
        }


        return null;
    }
}
