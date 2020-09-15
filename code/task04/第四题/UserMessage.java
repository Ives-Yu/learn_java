package com.lagou.task14;

public class UserMessage implements java.io.Serializable {

    private static final long serialVersionUID = -5814716593800822421L;
    private String clas;
    private User us;

    public UserMessage() {
    }

    public UserMessage(String clas, User us) {
        setClas(clas);
        setUs(us);
    }

    public void setUs(User us) {
        this.us = us;
    }

    public User getUs() {
        return us;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getClas() {
        return clas;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "clas='" + clas + '\'' +
                ", us=" + us +
                '}';
    }
}
