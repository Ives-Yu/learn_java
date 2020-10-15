package com.lagou.model;

import java.io.Serializable;

public class Subject implements Serializable {

    private static final long serialVersionUID = -6315030234496819530L;
    private String subject;
    private SubjectAnswer subjectAnswer;
    private String answer;

    public Subject () {}

    public Subject (String subject, String answer, SubjectAnswer subjectAnswer) {
        setSubject(subject);
        setAnswer(answer);
        setSubjectAnswer(subjectAnswer);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public SubjectAnswer getSubjectAnswer() {
        return subjectAnswer;
    }

    public void setSubjectAnswer(SubjectAnswer subjectAnswer) {
        this.subjectAnswer = subjectAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject='" + subject + '\'' +
                ", subjectAnswer=" + subjectAnswer +
                ", answer=" + answer +
                '}';
    }
}
