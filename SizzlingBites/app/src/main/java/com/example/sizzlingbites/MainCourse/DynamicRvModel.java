package com.example.sizzlingbites.MainCourse;

public class DynamicRvModel {


    String name;
    private int image, pos;

    public DynamicRvModel(String name, int image, int pos) {
        this.name = name;
        this.image = image;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getPos() {
        return pos;
    }
}
