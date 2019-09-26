package com.ht.leetcode.leeNum;

/**
 * 13.罗马转整数
 */
public class Num13 {

    public static int romanToInt(String s) {

        if(s.length()<1||s==null)return 0;

        int sum = 0;

        //将罗马数字一个一个转成整数，存放在数组中
        int [] arr = new int[s.length()];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            switch (c){
                case 'I':arr[i]=1;break;
                case 'V':arr[i]=5;break;
                case 'X':arr[i]=10;break;
                case 'L':arr[i]=50;break;
                case 'C':arr[i]=100;break;
                case 'D':arr[i]=500;break;
                case 'M':arr[i]=1000;break;
            }
        }

        //只有一个罗马，返回第1个
        if(arr.length==1)sum = arr[0];

        for(int i=0;i<arr.length-1;i++){

            if(arr[i]>=arr[i+1]){
                sum = sum == 0?arr[i]+arr[i+1]:sum+arr[i+1];
            }else{
                sum = sum == 0?arr[i+1]-arr[i]:sum+arr[i+1]-2*arr[i];
            }

        }

    return sum;

    }

    public static void main(String[] args) {
         int sum = romanToInt("V");
        System.out.println(sum);
    }

}
