package com.lagou.tack09.task;

//手机卡枚举
public enum modular02_third_cardClass {
    LARGE("大卡"), SMALL("小卡"), MINI("微型卡");

    private final String card_class;

    private modular02_third_cardClass(String card_class) {
        this.card_class = card_class;
    }

    public String getCard_class() {
        return card_class;
    }
}
