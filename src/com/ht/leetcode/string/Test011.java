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

    /**
     * 二
     * @param x
     * @return
     * 构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出
     * 反转整数的方法可以与反转字符串进行类比。
     *
     * 我们想重复“弹出” xx 的最后一位数字，并将它“推入”到 \text{rev}rev 的后面。最后，\text{rev}rev 将与 xx 相反。
     *
     * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
     * pop operation:
     * pop = x % 10;
     * x /= 10;
     *
     * push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     *
     *
     */
    private static int reverse2(int x){

        int result = 0;

        while (x!=0){
            int pop = x%10;
            x /= 10;
            if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE&&pop>7))return 0;
            if(result<Integer.MIN_VALUE/10||(result==Integer.MAX_VALUE&&pop<-8))return 0;
            result = result*10+pop;
        }

        return result;

    }



    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse2(123456));
        System.out.println();
    }
}
