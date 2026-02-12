package com.prac;

public class Calculator {

    public static void add(int a, int b) {
        System.out.println(a + b);
    }

    public static String reverseString(String data) {
        String rev = "";

        for (int i = data.length() - 1; i >= 0; i--) {
            rev = rev + data.charAt(i);
        }
        return rev;
    }
    
    public static boolean palindrome(String a) {
        if (a == null) {
            return false;
        }

        String rev = reverseString(a);
        return a.equals(rev);
    }
}
