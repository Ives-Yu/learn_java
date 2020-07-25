package com.lagou.tack09.task;

//通话套餐类
public class modular02_third_conversation extends modular02_third_abstract_package implements modular02_third_call_service {

    private int conversation_time;
    private int node_num;

    public void setConversation_time(int conversation_time) {
        this.conversation_time = conversation_time;
    }

    public int getConversation_time() {
        return conversation_time;
    }

    public int getNode_num() {
        return node_num;
    }

    @Override
    public int show(int conversation_num) {
        setMonthly_rates(conversation_num);
        return getMonthly_rates();
    }

    @Override
    public void call_ser(int conversation_num, modular02_third_card card_class) {
        setConversation_time(conversation_num);
        System.out.println("通话时长：" + getConversation_time() + "，短信条数：" + getNode_num() + "，每月资费：" + show(conversation_num));
    }
}
