package com.ht.leetcode.string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Test005 {
    //暴力破解
    public String longestPalindrome(String s) {
        if("".equals(s)||s==" ")return s;
        if(s.length()==1)return s;
        int max = 1;
        int start = 0;//最大回文开始
        int end = 1;//最大回文结束
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isHuiWen(s.substring(i,j))){
                    if(max<(j-i)){
                        max = j-i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end);
    }

    public boolean isHuiWen(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test005 t = new Test005();
        String str = t.longestPalindrome("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        System.out.print(str);
    }
}
