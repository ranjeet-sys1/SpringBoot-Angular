package com.app.model;

public class Student {
    private long stdId;
    private String stdName;
    private String stdCourse;
    private double stdFee;
    private String stdEmail;
    private String password;

    public long getStdId() {
        return stdId;
    }

    public void setStdId(long stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdCourse() {
        return stdCourse;
    }

    public void setStdCourse(String stdCourse) {
        this.stdCourse = stdCourse;
    }

    public double getStdFee() {
        return stdFee;
    }

    public void setStdFee(double stdFee) {
        this.stdFee = stdFee;
    }

    public String getStdEmail() {
        return stdEmail;
    }

    public void setStdEmail(String stdEmail) {
        this.stdEmail = stdEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
