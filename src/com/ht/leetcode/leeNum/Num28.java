package com.ht.leetcode.leeNum;

public class Num28 {
    public static int strStr(String haystack, String needle) {

        if(needle==null||"".equals(needle))return 0;

        if(haystack==null||"".equals(haystack))return -1;




        return haystack.indexOf(needle);
       /* for(int i = 0;i<haystack.length();i++){

            if(haystack.charAt(i)==s){

                return i;

            }

        }

        return -1;*/


    }


    public static void main(String[] args) {
        System.out.println(strStr("aaa","aaaa"));
    }

}
