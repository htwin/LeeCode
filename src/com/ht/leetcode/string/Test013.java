package com.ht.leetcode.string;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Test013 {


    private static boolean isPalindrome(int x) {
        //临时变量
        int temp = x;

        int result = 0;
        //根据数学的方法 每次回去原数字倒数第一个数作为拼接在result中
        while(temp!=0){
            int pop = temp%10;
            result = result*10+pop;
            temp /= 10;
        }

        if(result<0){
            return false;
        }

        return x==result;

    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(+121));
    }
}
