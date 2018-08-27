package com.example.hyebeen.myapplication;

import io.realm.RealmObject;

public class MediData extends RealmObject {

    private String info;
    private String name;
    private String caution;
    private  String donot;
    private int all;
    private int one;
    private int cnt;


    public String getMember_info() {
        return info;
    }

    public String getMember_name() {
        return name;
    }

    public String getMember_caution() {
        return caution;
    }

    public int getMember_one(){return one;}

    public int getMember_all(){return all;}

    public void setMember_info(String member_info) {
        this.info = member_info;
    }

    public void setMember_name(String member_name) {
        this.name = member_name;
    }

    public void setMember_caution(String member_take) {
        this.caution = member_take;
    }

    public String getMember_donot() {
        return donot;
    }

    public void setMember_donot(String donot) {
        this.donot = donot;
    }


    public void setMember_one(int member_one){this.one =  member_one;}

    public void setMember_all(int member_all){this.all=  member_all;}

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

}
