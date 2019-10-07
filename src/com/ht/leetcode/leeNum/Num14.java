package com.ht.leetcode.leeNum;

import java.util.Stack;

/**
 * 最长公共前缀
 */
public class Num14 {

    /**
     * 思路
     *
     * 1、以第一个字符数组中第一个元素为基准，截取字串（0-n）放入栈中  n初始为1 n<length-1
     * 2、循环后面的字符数组，依次截取跟第一个元素的字串长度，
     * 3、截取的当前元素字串与栈中的字串是否相等，相等则为公共前缀，否则不是，弹栈，剩下的字串则为最长公共前缀。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {


        if(strs.length==1)return strs[0];
        if(strs.length<1||strs==null)return "";

        Stack<String> stack = new Stack<>();

        //以第一个字符串为基准
        t:for(int i=1;i<=strs[0].length();i++){
            //将第一个元素的字串加入栈中
            stack.push(strs[0].substring(0,i));
            for(int j=1;j<strs.length;j++){

                //后面元素长度小于第一个
                if(i>strs[j].length()){
                    stack.pop();
                    break t;
                }

                String other= strs[j].substring(0, i);

                //比较后面元素的字串是否在栈中，如果在就继续比较下一个元素，否则字串不匹配，结束，将栈中元素弹出，栈栈中剩下的即为最长公共前缀
                if(stack.peek().equals(other)){
                    continue;
                }else{
                    stack.pop();
                    break t;
                }

            }

        }

        return stack.isEmpty()?"":stack.pop();

    }

    public static void main(String[] args) {
        String strs [] = {"ab","ab","abbbb"};
        System.out.println(longestCommonPrefix(strs));
    }
}
