package com.ht.leetcode.string;

public class Test007 {

    //1.
    /*private static String toLowerCase(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A'  && chars[i] <= 'Z') {
                chars[i] += 32;
            }
        }
        str = new String(chars);
        return str;
    }*/

    //2
    private static  String toLowerCase(String str){

        return str.toLowerCase();

    }

    public static void main(String[] args) {
        String str = "Zello";
        String s = toLowerCase(str);
        System.out.println(s);

    }
}
