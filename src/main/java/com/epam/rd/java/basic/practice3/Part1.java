package com.epam.rd.java.basic.practice3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        //just my empty main method

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
        String result = str.toString();
        result = result.replaceAll("$", "\n");
        return result;
    }

    public static String convert3(String input) {
        boolean addComa1 = true;
        boolean addComa2 = true;
        StringBuilder sbMail = new StringBuilder("mail.com ==> ");
        StringBuilder sbGoogle = new StringBuilder("google.com ==> ");
        int index = 0;
        String[] logins = new String[4];
        input = input.replaceAll("(^\\w+;\\w+;\\w+\\s)", "");
        String[] users = input.split("(?<=com)\\s");
        Pattern p = Pattern.compile("\\b[a-zа-я]+\\b(?=;)");
        Matcher m = p.matcher(input);
        while (m.find()) {
            logins[index] = m.group();
            index++;
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i].contains("mail.com")) {
                if (addComa1) {
                    sbMail.append(logins[i]).append(", ");
                    addComa1 = false;
                } else {
                    sbMail.append(logins[i]);
                }
            } else if (users[i].contains("google.com")) {
                if (addComa2) {
                    sbGoogle.append(logins[i]).append(", ");
                    addComa2 = false;
                } else {
                    sbGoogle.append(logins[i]);
                }
            }
        }
        return sbMail.append('\n').append(sbGoogle).append('\n').toString();
    }

    public static String convert4(String input) {
        StringBuilder sb = new StringBuilder();
        String pswd = ";Password";
        String[] users = input.split("((?<=\\w\\w\\w\\w\\w;\\w\\w\\w\\w;\\w\\w\\w\\w\\w)\\s)|((?<=com)\\s)");
        users[0] = users[0] + pswd;
        for (int i = 0; i < users.length; i++) {
            if (i == 0) {
                sb = sb.append(users[i]);
            } else {
                SecureRandom r = new SecureRandom();
                int x = r.nextInt(10000);
                if (x < 1000) {
                    x = x + 1000;
                }
                users[i] = users[i] + ';' + x;
                sb = sb.append(users[i]).append('\n');
            }
        }
        return sb.toString();
    }
}