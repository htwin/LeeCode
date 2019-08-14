package com.ht.leetcode.string;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class Test010 {




    //按照行打印

    /**
     *
     * 依次遍历字符串，很好确定每个字符串在哪一行
     * 有当前行与当前方向
     *
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {

        if(numRows == 1) return s;

        boolean goingDown = false;//是否向下

        int curRow = 0;//当前行

        //行数
        int row = Math.min(numRows,s.length());

        List<StringBuffer> rows = new ArrayList<>();

        //每一行为一个StringBuffer
        for(int i=0;i<row;i++)
            rows.add(new StringBuffer());

        for(char c : s.toCharArray()){
            rows.get(curRow).append(c);
            //到达最顶部以及最下行时方向转变
            if(curRow==numRows-1||curRow==0)goingDown = !goingDown;

            //向上 当前行减一 反之
            curRow += goingDown?1:-1;
        }


        StringBuffer sb = new StringBuffer();

        for(StringBuffer ss : rows){

            sb.append(ss);

        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",3));
    }
}
