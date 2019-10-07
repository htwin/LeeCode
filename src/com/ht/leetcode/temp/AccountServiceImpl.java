package com.ht.leetcode.temp;

public class AccountServiceImpl implements AccountService {

    @Override
    public void transfer(String source, String target, int money) {
        System.out.println(source+" 转给 "+target+" "+money+"元");


        System.out.println(target+" 收到 "+source+"转的 "+money+"元");
    }
}
