package com.ht.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 *
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * 返回我们可以获得所有词不同单词翻译的数量。
 *
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 *  
 *
 * 注意:
 *
 * 单词列表words 的长度不会超过 100。
 * 每个单词 words[i]的长度范围为 [1, 12]。
 * 每个单词 words[i]只包含小写字母。
 *
 *
 */
public class Test014 {

    public static int uniqueMorseRepresentations(String[] words) {
        //摩斯密码
        String mosi [] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        //key:字母  value：摩斯密码
        HashMap<Character,String> map = new HashMap<>();

        //用来装单词组成的摩斯密码 set自动过滤重复的
        HashSet<String> set = new HashSet<>();

        //a的ascii码为97
        int i = 97;
        //将字母与摩斯密码对应
        for(String s : mosi){
            map.put((char) i++,s);
        }

        for (String word :words){
            String moStr = "";
            for(Character c : word.toCharArray()){
                moStr +=map.get(c);
            }
            set.add(moStr);
        }

        return set.size();
    }

    public static void main(String[] args) {
        String words [] = {"gin", "zen", "gig", "msg"};
        uniqueMorseRepresentations(words);
    }
}
