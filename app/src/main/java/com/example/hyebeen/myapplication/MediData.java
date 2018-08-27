package com.example.hyebeen.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class MediData implements Parcelable {

    private String name;
    private String info;
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







    //intent로 객체 전달 하기 위해서

    public static final Creator<MediData> CREATOR = new Creator<MediData>() {
        @Override
        public MediData createFromParcel(Parcel in) {
            return new MediData(in);
        }

        @Override
        public MediData[] newArray(int size) {
            return new MediData[size];
        }
    };


    private MediData(Parcel in) {
        this.name = in.readString();
        this.info = in.readString();
        this.caution = in.readString();
        this.donot = in.readString();
        this.all = in.readInt();
        this.one = in.readInt();
        this.cnt = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.info);
        dest.writeString(this.caution);
        dest.writeString(this.donot);
        dest.writeInt(this.all);
        dest.writeInt(this.one);
        dest.writeInt(this.cnt);

    }
}
