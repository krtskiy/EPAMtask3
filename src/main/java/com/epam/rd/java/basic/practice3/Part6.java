package com.epam.rd.java.basic.practice3;



public class Part6 {

    public static void main(String[] args) {
        //just my empty main class
    }

    static String input = Util.getInput("part6.txt");

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        String[] temp = input.split("\\b");
        for (int i = 0; i < temp.length; i = i + 2) {
            int x = i + 2;
            int y = i + 4;
            while (x < temp.length) {
                if (temp[i].equals(temp[x])) {
                    while (y < temp.length) {
                        if (temp[i].equals(temp[y])) {
                            temp[y] = "_" + temp[x];
                        }
                        y = y + 2;
                    }
                    temp[i] = "_" + temp[i];
                }
                x = x + 2;
            }

        }
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i]);
        }
        String tempStr = sb.toString();
        tempStr = tempStr.replaceAll("__", "_");
        return tempStr;
    }
}
