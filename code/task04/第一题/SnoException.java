package com.lagou.task20.task;

public class SnoException extends Exception {

    static final long serialVersionUID = 7825616993124229948L;

    public SnoException () {}

    public SnoException(String message) {
        super(message);
    }
}
