package com.lagou.task14;

public class User implements java.io.Serializable {
    private static final long serialVersionUID = -5804716593800822421L;

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        setPassword(password);
        setUsername(username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
