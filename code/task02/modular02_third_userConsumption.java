package com.lagou.tack09.task;

//用户消费类
public class modular02_third_userConsumption {

    private int time_num;
    private int flow_num;
    private int rates_num;

    modular02_third_userConsumption () {}
    modular02_third_userConsumption (int conversation_time, int card_flow, int monthly_rates) {
        setTime_num(conversation_time);
        setFlow_num(card_flow);
        setRates_num(monthly_rates);
    }

    public void setFlow_num(int flow_num) {
        this.flow_num += flow_num;
    }

    public void setRates_num(int rates_num) {
        this.rates_num += rates_num;
    }

    public void setTime_num(int time_num) {
        this.time_num += time_num;
    }

    public int getFlow_num() {
        return flow_num;
    }

    public int getRates_num() {
        return rates_num;
    }

    public int getTime_num() {
        return time_num;
    }

    public void show() {
        System.out.println("");
    }
}
