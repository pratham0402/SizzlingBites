package com.example.sizzlingbites.Login_AND_SignUp;

public class UserInfo {

    String email, pass, con_pass, mob;
    long num;

    public UserInfo(String email, String pass, String con_pass, long num) {
        this.email = email;
        this.pass = pass;
        this.con_pass = con_pass;
        this.num = num;
    }

    public UserInfo(String email, String pass, String mob) {
        this.email = email;
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

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }


}
