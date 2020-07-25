package com.lagou.tack09.task;

//手机卡类
public class modular02_third_card {
    private String card_class;
    private int card_number;
    private String card_name;
    private String card_password;
    private int card_balance;
    private int card_conversation;
    public int card_flow;

    public int getCard_number() {
        return card_number;
    }

    public String getCard_name() {
        return card_name;
    }

    public int getCard_balance() {
        return card_balance;
    }

    public void show() {
        System.out.println("卡号为：" + getCard_name() + "，用户名为：" + getCard_name() + "，当前余额：" + getCard_balance());
    }
}
