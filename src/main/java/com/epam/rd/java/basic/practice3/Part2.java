package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        //just my empty main class
        System.out.println(convert(input));
    }

    static String input = Util.getInput("part2.txt");
    public static String convert(String input) {
        String result;
        StringBuilder strMin = new StringBuilder("Min: ");
        StringBuilder strMax = new StringBuilder("Max: ");
        Pattern pattern1 = Pattern.compile("\\b[A-Za-z]\\b");
        Matcher matcher1 = pattern1.matcher(input);
        while (matcher1.find()) {
            strMin.append(input.substring(matcher1.start(), matcher1.end())).append(", ");
        }
        Pattern pattern2 = Pattern.compile("\\b\\w{7}\\b");
        Matcher matcher2 = pattern2.matcher(input);
        while (matcher2.find()) {
            strMax.append(input.substring(matcher2.start(), matcher2.end())).append(", ");
        }
        result = strMin.append('\n').append(strMax).toString();
        return result;
    }
}
