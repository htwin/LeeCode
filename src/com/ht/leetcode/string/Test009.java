package com.ht.leetcode.string;


import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Test009 {



    private static String longestPalindrome(String s) {
        int len = s.length();
        if("".equals(s)||len==1)return s;
        int max = 0;
        String maxStr = "";
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String subString = s.substring(i, j);
                //如果该字串为回文，则加入到map中
                if(isHuiWen(subString)){
                    int subLen = subString.length();
                    if(subLen>max){
                        max = subLen;
                        maxStr = subString;
                    }

                }

            }
        }

        return maxStr;
    }

    /**
     * 判断字符串是否为回文串
     * @param str
     * @return
     */
    private static boolean isHuiWen(String str) {

        int len = str.length();

        for (int i = 0; i < len / 2; i++) {

            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        long begin = System.currentTimeMillis();

        String max = longestPalindrome("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123");
        System.out.println(max);

        System.out.println(System.currentTimeMillis()-begin);

    }

}
