package com.epam.rd.java.basic.practice3;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        //just my empty main class
        convert(input);
    }

    static String input = Util.getInput("part6.txt");

    public static String convert(String input) {
        String[] temp = input.split("\\b");
        String[] temp2 = input.split("\\b");
        for (int i = 0; i < temp.length; i = i + 2) {
            int x = i + 2;
            while (x < temp.length) {
                if (temp[i].equals(temp[x])) {
                    temp[i] = "_" + temp[i];
                    temp[x] = "_" + temp[x];
                }
                x = x + 2;
            }

        }
        for (String t : temp) {
            System.out.print(t);
        }
        return null;
    }
}
