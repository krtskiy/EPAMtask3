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
        int indexF = 0;
        int indexS = 0;
        String[] strArrF = new String[10];
        String[] strArrF2 = new String[10];
        String[] strArrS = new String[10];
        String[] strArrS2 = new String[10];
        StringBuilder strMin = new StringBuilder("Min: ");
        StringBuilder strMax = new StringBuilder("Max: ");
        Pattern patternF = Pattern.compile("\\b[A-Za-z]\\b");
        Matcher matcherF = patternF.matcher(input);
        while (matcherF.find()) {
            strArrF[indexF] = matcherF.group();
            indexF++;
        }
        for (int i = 0; i < indexF; i++) {
            if (i == 0) {
            strMin.append(strArrF[0]).append(", ");
            strArrF2[0] = strArrF[0];
            } else {
                for (int j = 0; j < strArrF2.length; ) {
                    if (strArrF2[j].equals(strArrF[i])) {
                        break;
                    } else {
                        if (i < indexF - 5) {
                        strMin.append(strArrF[i]).append(", ");
                        strArrF2[j + 1] = strArrF[i];
                        j++;
                        } else {
                            strMin.append(strArrF[i]);
                            strArrF2[j + 1] = strArrF[i];
                            j++;
                        }
                    }
                }
            }
        }
        Pattern patternS = Pattern.compile("\\b[A-Za-z]{7}\\b");
        Matcher matcherS = patternS.matcher(input);
        while (matcherS.find()) {
            strArrS[indexS] = matcherS.group();
            indexS++;
        }
        for (int i = 0; i < indexS; i++) {
            if (i == 0) {
                strMax.append(strArrS[0]).append(", ");
                strArrS2[0] = strArrS[0];
            } else {
                for (int j = 0; j < strArrS2.length; ) {
                    if (strArrS2[j].equals(strArrS[i])) {
                        break;
                    } else {
                        if (i < indexS - 1) {
                        strMax.append(strArrS[i]).append(", ");
                        strArrS2[j + 1] = strArrS[i];
                        j++;
                        } else {
                            strMax.append(strArrS[i]);
                            strArrS2[j + 1] = strArrS[i];
                            j++;
                        }
                    }
                }
            }
        }
        return strMin.append('\n').append(strMax).toString();
    }
}
