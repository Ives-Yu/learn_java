package com.lagou.tack09.task;

public class modular02_third {


    public static void main(String[] args) {

        modular02_third_card car = new modular02_third_card();
        modular02_third_conversation on = new modular02_third_conversation();
        on.call_ser(180, car);
        modular02_third_netPlay net = new modular02_third_netPlay();
        net.internet_ser(290, car);
    }
}
