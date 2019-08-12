package com.ht.leetcode.string;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Test008 {

    /*
    失败--------------
    private static boolean isValid(String s) {

        //长度为1返回false
        if (s.length() == 1||"".equals(s)) return false;

        //状态 0：左右括号闭合   出现'('：+1   出现')':-1
        int xStatus = 0;


        int zStatus = 0;


        int dStatus = 0;


        //字符串包括 (] (} [) [} {) {] 返回false
        if(s.contains("(]")||s.contains("(}")||s.contains("[)")||
                s.contains("[}")||s.contains("{)")||s.contains("{]")){
            return false;
        }

        char[] chars = s.toCharArray();

        int len = chars.length;


        for (int i = 0; i < len; i++) {

            if (chars[i] == '(') {
                xStatus += 1;
            }
            //如果（）已经闭合，针对([)]等类似情况
            if (chars[i] == ')') {
                xStatus -= 1;
            }
            if (chars[i] == '[') {
                zStatus += 1;
            }
            if (chars[i] == ']') {

                zStatus -= 1;
            }
            if (chars[i] == '{') {
                dStatus += 1;
            }
            if (chars[i] == '}') {

                dStatus -= 1;
            }
        }
        return (xStatus == 0 && zStatus == 0 && dStatus == 0);
    }*/

    /**
     * 成功----------
     * @param s
     * @return
     */
    private static boolean isValid(String s) {

        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');

        //([{ 方向的括号放入栈中
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            //如果hashMap中有 ([{
            if(hashMap.containsKey(c)){
                //判断栈中是否为空  为空用#代替
                char c1 = stack.isEmpty()?'#':stack.pop();

                //弹出栈的括号 是否匹配
                if(c1 != hashMap.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //"[({(())}[()])]" true
        //()] false
        //([)] false
        //([) false
        //() true
        //"{}{{}}" true
        //{}[{}]((){})(){} true
        //"([)]" false
        //"{}([{}{}][])[{}]" true
        //[()] true
        //"{[}]" false
        //"[([]])" false
        String s = "[({(())}[()])]";
        boolean valid = isValid(s);
        System.out.println(valid);

    }
}
