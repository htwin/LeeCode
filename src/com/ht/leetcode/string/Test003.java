package com.ht.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class Test003 {
    //meth;two   暴力破解  O(n3)
    public  static  int lengthOfLongestSubstring(String s){
        int max=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){

                if( isUnique(i,j,s)){
                    max=Math.max(max,j-i);
                }else{
                    i++;
                }
            }
        }
        return max;
    }

    /*
     * 判断字串中字符是否唯一
     * @param start
     * @param end
     * @return
    */
    public static boolean isUnique(int start,int end,String s){
        Set<Character> set = new HashSet<>();
        for(int i =start;i<end;i++){
            if(set.contains(s.charAt(i))){
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    //meth;two   滑动窗口  O(n)
   /* public static int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int n=s.length();
        int max=0;
        HashSet<Character> set = new HashSet<>();
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return max;

    }*/

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        System.out.println(count);
        long end = System.currentTimeMillis();
        System.out.println(end-start+"ms");
    }
}
