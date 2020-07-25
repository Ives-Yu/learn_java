package com.lagou.tack09.task;

public abstract class modular02_third_abstract_package {

    private int monthly_rates;


    public int getMonthly_rates() {
        return monthly_rates;
    }

    public void setMonthly_rates(int monthly_rates) {
        this.monthly_rates = monthly_rates;
    }

    public abstract int show(int monthly_rates);
}
