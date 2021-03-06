package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        //just my empty main method
    }

    static String regex = "([\\wА-Яа-я]{3,})";
    static String input = Util.getInput("part3.txt");

    public static String convert(String input) {
        StringBuilder str = new StringBuilder();
        char[] ch;
        char tempFirstChar;
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        String s = input;
        String[] temp = s.split("\\b");
        for (int i = 0; i < temp.length; i = i + 2) {
            if (temp[i].length() >= 3) {
                tempFirstChar = temp[i].charAt(0);
                if (Character.isUpperCase(tempFirstChar)) {
                    ch = temp[i].toCharArray();
                    ch[0] = Character.toLowerCase(tempFirstChar);
                    temp[i] = String.valueOf(ch);
                } else {
                    ch = temp[i].toCharArray();
                    ch[0] = Character.toUpperCase(tempFirstChar);
                    temp[i] = String.valueOf(ch);
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            str.append(temp[i]);
        }
        return str.toString();
    }
}
