package com.lagou.tack09.task;

//上网套餐类
public class modular02_third_netPlay extends modular02_third_abstract_package implements modular02_third_internet_service {

    private int netflow;
    public int getNetflow() {
        return netflow;
    }

    public void setNetflow(int netflow) {
        this.netflow = netflow;
    }

    @Override
    public int show (int netflow) {
        setMonthly_rates(netflow);
        return getMonthly_rates();
    }
    @Override
    public void internet_ser(int netflow, modular02_third_card card_class) {
        setNetflow(netflow);
        System.out.println("上网流量：" + getNetflow() + "，每月资费：" + show(netflow));
    }

}
