package com.example.sizzlingbites.Login_AND_SignUp;

import android.net.Uri;

public class UserInfo {

    String email, pass, con_pass, mob;
    Uri img;

    public UserInfo(){}

//    public UserInfo(String email, String pass, String mob) {
//        this.email = email;
//        this.pass = pass;
//        this.mob = mob;
//    }

    public UserInfo(String email, String pass, String mob, Uri img){
        this.email = email;
        this.img = img;
        this.pass = pass;
        this.mob = mob;
    }



    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCon_pass() {
        return con_pass;
    }

    public void setCon_pass(String con_pass) {
        this.con_pass = con_pass;
    }

    public Uri getImg() {
        return img;
    }

    public void setImg(Uri img) {
        this.img = img;
    }
}
