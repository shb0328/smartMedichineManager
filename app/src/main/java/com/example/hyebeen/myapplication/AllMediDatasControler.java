package com.example.hyebeen.myapplication;

import android.util.Log;

import io.realm.Realm;

public class AllMediDatasControler {

    private MediData returnMediData_1;
    private MediData returnMediData_2;
    private MediData returnMediData_3;
    private MediData returnMediData_4;

    //DB생성!
    public void createMediData(Realm realm, final String name, final String info, final String caution, final String donot, final int all, final int one) {
        Log.d("테스트","DB생성");

        realm.executeTransaction(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.createObject(MediData.class);
                mediData.setMember_name(name);
                mediData.setMember_info(info);
                mediData.setMember_caution(caution);
                mediData.setMember_donot(donot);
                mediData.setMember_all(all);
                mediData.setMember_one(one);
                mediData.setCnt(all/one);
            }
        });
    }



    //DB 에 내용이 있는지 체크 (파일이 존재하는지 확인)
    public boolean isCheckClassFile(Realm realm) {
        final Boolean[] result = {false};
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //db의 첫번째 값을 가져와라
                MediData currentMediData = realm.where(MediData.class).findFirst();

                if(currentMediData == null) { //값이 없으면
                    result[0] = false;
                }
                else { //값이 있으면
                    result[0] = true;
                }
            }
        });

        return  result[0];
    }



    //DB에 있는 정보 가져오기
    public String getMediName(Realm realm) {

        //TODO:isCheckClassFile 이용해서 예외처리해주면 좋을 것 같음

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.where(MediData.class).findFirst();
                returnName = mediData.getMember_name();

            }
        });

        return returnName;

    }

    //DB삭제
    public void clear(Realm realm) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(MediData.class);
            }
        });
    }

}
