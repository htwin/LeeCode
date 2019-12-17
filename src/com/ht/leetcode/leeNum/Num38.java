package com.ht.leetcode.leeNum;

public class Num38 {


    public static String countAndSay(int n) {

        if(n==1)return "1";

        String result = "1";
        String temp = "";
        int last = 0;
        for(int i = 2;i<=n;i++){ //11
            last = 0;
            for (int j = 0;j<=result.length();j++){
                if(j>0){
                    if(j==result.length()||result.charAt(j)!=result.charAt(j-1)){
                        if(last>0){
                            temp += ""+(j-last)+result.charAt(j-1);
                        }else{
                            temp = ""+(j-last)+result.charAt(j-1);
                        }
                        last = j;

                    }

                }

            }
            result = temp;
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(countAndSay(30));
    }
}
