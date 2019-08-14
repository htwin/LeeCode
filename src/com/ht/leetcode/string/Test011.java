package com.ht.leetcode.string;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 */
public class Test011 {

    public static int reverse(int x) {

        //数字转换成字符串
        String s = new String(x+"");

        StringBuffer sb = new StringBuffer();

        //倒序插入stringbuffer
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }

        //判断是否为负数
        if(sb.lastIndexOf("-")>0){
            sb.deleteCharAt(sb.lastIndexOf("-"));
            sb.insert(0,"-");
        }

        //转换成long
        long result = Long.parseLong(sb.toString());

        //判断是否溢出
        if(result<Integer.MIN_VALUE||result>Integer.MAX_VALUE){
            result = 0;
        }
        return (int)result;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(1534236469));
        System.out.println();
    }
}
