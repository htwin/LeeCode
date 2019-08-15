package com.ht.leetcode.string;


/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 */
public class Test012 {


    private static int myAtoi(String str) {


        if(str==null||str.trim().length()<1)return 0;

        //去首尾空格
        str  = str.trim();

        //新字符串
        StringBuffer newStr = new StringBuffer();

        //判断第一个元素是否为非有效字符  - + 0-9
        char c0 = str.charAt(0);

        if(c0>='0'&&c0<='9'||c0=='-'||c0=='+'){
            newStr.append(c0);
        }else{
            return 0;
        }

        //判断是否加入了数字

        //遇到非有效字符 break
        for(int i =1;i<str.length();i++){
            char cI = str.charAt(i);

            //遇到空格
            if(cI ==' ')break;

            //其他非有效字符
            if(!(cI>='0'&&cI<='9')){
                break;
            }

            newStr.append(cI);

        }



        //将字符串中前面无效0去除
        int i = 0;
        for(;i<newStr.length();i++){
            if(newStr.charAt(i)>='1'&&newStr.charAt(i)<='9'){
                break;
            }
        }
        if(i>1){
            newStr.delete(1,i);
        }

        //新字符串长度为小于1时
        if(newStr.length()<1)return 0;
        //新字符串长度为1时
        if(newStr.length()==1){

            if(newStr.charAt(0)=='-'||newStr.charAt(0)=='+'){
                return 0;
            }
            else{
                return Integer.parseInt(newStr.toString());
            }
        }


        //判断字符串长度是否大于12
        if(newStr.charAt(0)=='-'&&newStr.length()>12)return Integer.MIN_VALUE;
        if(newStr.charAt(0)!='-'&&newStr.length()>12)return Integer.MAX_VALUE;

        long l = Long.parseLong(newStr.toString());

        if(l<Integer.MIN_VALUE) l = Integer.MIN_VALUE;
        if(l>Integer.MAX_VALUE) l = Integer.MAX_VALUE;

        return (int)l;
    }

    public static void main(String[] args) {
        //-2147483648
        //2147483647
        System.out.println("000000000015060465ca;-->"+myAtoi("000000000015060465ca;"));
        System.out.println("null-->"+myAtoi(null));
        System.out.println("+1-->"+myAtoi("+1"));
        System.out.println(".1-->"+myAtoi(".1"));
        System.out.println("   +0 123-->"+myAtoi("   +0 123"));
        System.out.println("-   234-->"+myAtoi("-   234"));
        System.out.println("  -->"+myAtoi("  "));
        System.out.println("--->"+myAtoi("-"));
        System.out.println("-+156465ca;-->"+myAtoi("-+156465ca;"));
        System.out.println("5646--->"+myAtoi("5646-"));
        System.out.println("-5646-->"+myAtoi("-5646-"));
        System.out.println("+5646--->"+myAtoi("+5646-"));
        System.out.println("------>"+myAtoi("----"));
        System.out.println("----999a-->"+myAtoi("----999a"));
        System.out.println("-2147483648-->"+myAtoi("-2147483648"));
        System.out.println("-2147483649-->"+myAtoi("-2147483649"));
        System.out.println("+a5544-->"+myAtoi("+a5544"));
        System.out.println("+2147483647-->"+myAtoi("+2147483647"));
        System.out.println("+2147483648-->"+myAtoi("+2147483648"));
        System.out.println("+2000000000000000000000000000000000000000000000000000000000-->"+myAtoi("+2000000000000000000000000000000000000000000000000000000000"));
        System.out.println("  0000000000012345678-->"+myAtoi("  0000000000012345678"));
        System.out.println("  -0012345678-->"+myAtoi("  -0012345678"));
        System.out.println("  00a-->"+myAtoi("  00a"));
        System.out.println("  -0-0000000000010a-->"+myAtoi("  -0-0000000000010a"));
        System.out.println("    +-0a32-->"+myAtoi("    +-0a32"));
        System.out.println("  -0012345678-->"+myAtoi("  -0012345678"));
        System.out.println("  -000000000000000000000000000000000000000000000000000000012345678-->"+myAtoi("  000000000000000000000000000000l000000000000000000000000012345678"));
        //System.out.println('9'==9);"    +0a32"
    }
}
