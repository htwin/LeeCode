package com.ht.leetcode.string;


import java.util.Map;
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


    /**
     * 方法一 暴力破解
     * @param s
     * @return
     */
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


    /**
     * 方法二
     * 官方题解  ---中心扩展法
     * @param s
     * @return
     *
     * 一共 2n-1个中心
     */
    private static String longestPalindrome2(String s){

        if(s==null||s.length()<1)return "";

        int max = 0;
        int start = 0;
        int end = 0;
        for (int i=0;i<s.length();i++){

            int len1 = expandAroundCenter(s,i,i);//自身扩展 abba 如从 a向两边扩展
            int len2 = expandAroundCenter(s,i,i+1);//两字符之间扩展 如 abba 从第两个b之间扩展

            int len = Math.max(len1,len2);

            if(max < len){
                start = i-(len-1)/2;
                end = i+len/2;
                max = len;
            }

        }


        return s.substring(start,end+1);
    }

    private static int expandAroundCenter(String s, int l, int r) {

        while(r<s.length()&&l>=0&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;

    }

    public static void main(String[] args) {


        System.out.println("-------方法一 暴力破解----------");
        long begin = System.currentTimeMillis();
        String max1 = longestPalindrome("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123");
        System.out.println("结果1："+max1);
        System.out.println(System.currentTimeMillis() - begin);

        System.out.println("-------方法二 中心扩展----------");
        long begin2 = System.currentTimeMillis();
        String max2 = longestPalindrome2("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123");
        System.out.println("结果2："+max2);
        System.out.println(System.currentTimeMillis() - begin2);

    }

}
