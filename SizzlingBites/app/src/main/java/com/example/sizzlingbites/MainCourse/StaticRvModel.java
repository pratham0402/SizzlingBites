package com.example.sizzlingbites.MainCourse;

public class StaticRvModel {

    private int n;
    private String text;

    public StaticRvModel(int n, String text) {
        this.n = n;
        this.text = text;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
