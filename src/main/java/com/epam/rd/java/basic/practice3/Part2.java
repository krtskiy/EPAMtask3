package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        //just my empty main class
    }

    static String input = Util.getInput("part2.txt");

    public static String convert(String input) {
        int indexLarge = 0;
        int indexSmall = 0;
        String[] arrLarge = new String[50];
        String[] arrSmall = new String[50];
        StringBuilder sbLarge = new StringBuilder("Max: ");
        StringBuilder sbSmall = new StringBuilder("Min: ");
        int size = 0;
        String[] words = new String[input.length()];
        String regex = "\\b\\w+?\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while (m.find()) {
            words[size] = m.group();
            size++;
        }
        String small = "";
        String large = "";
        int smallLength = 0;
        int largeLength = 0;
        small = large = words[0];
        smallLength = small.length();
        largeLength = large.length();
        for (int i = 0; i < size; i++) {
            if (small.length() > words[i].length()) {
                small = words[i];
                smallLength = small.length();
            }
            if (large.length() < words[i].length()) {
                large = words[i];
                largeLength = large.length();
            }
        }
        String regexLarge = "\\b\\w{" + largeLength + "}?\\b";
        String regexSmall = "\\b\\w{" + smallLength + "}?\\b";

        indexLarge = findDuplicates(input, indexLarge, arrLarge, regexLarge);
        indexSmall = findDuplicates(input, indexSmall, arrSmall, regexSmall);

        for (int k = 0; k < indexLarge; k++) {
            if (k < indexLarge - 1) {
                sbLarge.append(arrLarge[k]).append(", ");
            } else {
                sbLarge.append(arrLarge[k]);
            }
        }
        for (int l = 0; l < indexSmall; l++) {
            if (l < indexSmall - 1) {
                sbSmall.append(arrSmall[l]).append(", ");
            } else {
                sbSmall.append(arrSmall[l]);
            }
        }

        return sbSmall.append("\n").append(sbLarge).toString();
    }

    private static int findDuplicates(String input, int indexLarge, String[] arrLarge, String regexLarge) {
        Pattern pLarge = Pattern.compile(regexLarge);
        Matcher mLarge = pLarge.matcher(input);
        while (mLarge.find()) {
            if (indexLarge == 0) {
                arrLarge[indexLarge] = mLarge.group();
                indexLarge++;
            }
            for (int i = 0; i < indexLarge; i++) {
                if (!arrLarge[i].equals(mLarge.group())) {
                    arrLarge[indexLarge] = mLarge.group();
                    indexLarge++;
                }
                break; //NOSONAR
            }
        }
        return indexLarge;
    }
}
