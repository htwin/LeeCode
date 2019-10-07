package com.ht.leetcode.temp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        final AccountServiceImpl accountService = new AccountServiceImpl();

        AccountService proxyService = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        String name = method.getName();

                        Object invoke = null;


                        int money = (int) args[2];

                        if ("transfer".equals(name)) {
                            System.out.println("开启事务");

                             invoke = method.invoke(accountService, args[0],args[1],money);

                            System.out.println("提交事务");
                        }

                        return invoke;
                    }
                });
        proxyService.transfer("黄通","夏未央",2000);

    }
}
