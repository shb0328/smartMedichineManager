package com.example.hyebeen.myapplication;

import io.realm.RealmObject;

public class AllMediDatas extends RealmObject {

    private MediData mediData_1;
    private MediData mediData_2;
    private MediData mediData_3;
    private MediData mediData_4;

    public MediData getMediData_1() {
        return mediData_1;
    }

    public void setMediData_1(MediData mediData_1) {
        this.mediData_1 = mediData_1;
    }

    public MediData getMediData_2() {
        return mediData_2;
    }

    public void setMediData_2(MediData mediData_2) {
        this.mediData_2 = mediData_2;
    }

    public MediData getMediData_3() {
        return mediData_3;
    }

    public void setMediData_3(MediData mediData_3) {
        this.mediData_3 = mediData_3;
    }

    public MediData getMediData_4() {
        return mediData_4;
    }

    public void setMediData_4(MediData mediData_4) {
        this.mediData_4 = mediData_4;
    }

}
