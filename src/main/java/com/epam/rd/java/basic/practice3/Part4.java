package com.epam.rd.java.basic.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Part4 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        //just my empty main class
        System.out.println(hash("asdf", "MD5"));

        System.out.println(hash("asdf", "SHA-256"));
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xFF & hash[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
