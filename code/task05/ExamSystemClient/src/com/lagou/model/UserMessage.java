package com.lagou.model;

public class UserMessage implements java.io.Serializable{


    private static final long serialVersionUID = -6959890717912112180L;
    private String message;
    private User user;
    private Student student;
    private Subject subject;

    public UserMessage () {}

    public UserMessage (String message) {
        setMessage(message);
    }

    public UserMessage (String message, User user) {
        setMessage(message);
        setUser(user);
    }

    public UserMessage (String message, Student student, User user) {
        setMessage(message);
        setStudent(student);
        setUser(user);
    }

    public UserMessage (String message, Subject subject) {
        setMessage(message);
        setSubject(subject);
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Subject getSubject1() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
