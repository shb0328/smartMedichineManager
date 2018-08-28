package com.example.hyebeen.myapplication;

import android.util.Log;

import java.io.Serializable;

import io.realm.Realm;


public class MediDataControler implements Serializable{


    Realm realm;
    private int num;

    private String returnInfo ="";
    private String returnName ="";
    private String returnCaution ="";
    private String returnDonot = "";
    private int returnAll = 0;
    private int returnOne = 0;
    private int returnCnt = 0;

    public MediDataControler(Realm realm) {
        this.realm = realm;
    }
    //DB생성!
    public void createMediData(final int num, final String name, final String info, final String caution, final String donot, final int all, final int one) {
        Log.d("테스트","DB생성");

        realm.executeTransaction(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.createObject(MediData.class);
                mediData.setNum(num);
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
    public boolean isCheckClassFile() {
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

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.where(MediData.class).findFirst();
                returnName = mediData.getMember_name();

            }
        });

        return returnName;

    }

    public String getMediInfo(Realm realm) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.where(MediData.class).findFirst();
                returnInfo = mediData.getMember_info();

            }
        });

        return returnInfo;

    }

    public String getMediCaution(Realm realm) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.where(MediData.class).findFirst();
                returnCaution = mediData.getMember_caution();

            }
        });

        return returnCaution;

    }

    public String getMediDonot(Realm realm) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.where(MediData.class).findFirst();
                returnDonot = mediData.getMember_donot();

            }
        });

        return returnDonot;

    }

    public int getMediAll(Realm realm) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.where(MediData.class).findFirst();
                returnAll = mediData.getMember_all();

            }
        });

        return returnAll;
    }

    public int getMediOne(Realm realm) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.where(MediData.class).findFirst();
                returnOne = mediData.getMember_one();

            }
        });

        return returnOne;
    }

    public int getMediCnt(Realm realm) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.where(MediData.class).findFirst();
                returnCnt = mediData.getCnt();

            }
        });

        return returnCnt;
    }

    public int getMediNum(Realm realm) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MediData mediData = realm.where(MediData.class).findFirst();
                num = mediData.getNum();

            }
        });

        return num;
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
//
//public class MediDataControler implements Serializable{
//
//    private MediData returnNum1 =null;
//    private MediData returnNum2 =null;
//    private MediData returnNum3 =null;
//    private MediData returnNum4 =null;
//
//
//    //DB생성!
//    public void createMediDB(Realm realm) {
//        Log.d("테스트","DB생성");
//
//        realm.executeTransaction(new Realm.Transaction() {
//
//            @Override
//            public void execute(Realm realm) {
//                MediDB mediDB = realm.createObject(MediDB.class);
////                mediData.setMember_name(name);
////                mediData.setMember_info(info);
////                mediData.setMember_caution(caution);
////                mediData.setMember_donot(donot);
////                mediData.setMember_all(all);
////                mediData.setMember_one(one);
////                mediData.setCnt(all/one);
//            }
//        });
//    }
//
//
//
//    //DB 에 내용이 있는지 체크 (파일이 존재하는지 확인)
//    public boolean isCheckClassFile(Realm realm) {
//        final Boolean[] result = {false};
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                //db의 첫번째 값을 가져와라
//                MediDB currentMediDB = realm.where(MediDB.class).findFirst();
//
//                if(currentMediDB == null) { //값이 없으면
//                    result[0] = false;
//                }
//                else { //값이 있으면
//                    result[0] = true;
//                }
//            }
//        });
//
//        return  result[0];
//    }
//
//
//
//    //DB에 있는 정보 가져오기
//    public MediData getMediData_num1(Realm realm) {
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                MediDB mediDB = realm.where(MediDB.class).findFirst();
//                returnNum1 = mediDB.getNum1();
//
//            }
//        });
//
//        return returnNum1;
//    }
//
//    public MediData getMediData_num2(Realm realm) {
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                MediDB mediDB = realm.where(MediDB.class).findFirst();
//                returnNum2 = mediDB.getNum2();
//
//            }
//        });
//
//        return returnNum2;
//    }
//
//    public MediData getMediData_num3(Realm realm) {
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                MediDB mediDB = realm.where(MediDB.class).findFirst();
//                returnNum3 = mediDB.getNum3();
//
//            }
//        });
//
//        return returnNum3;
//    }
//
//    public MediData getMediData_num4(Realm realm) {
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                MediDB mediDB = realm.where(MediDB.class).findFirst();
//                returnNum4 = mediDB.getNum4();
//
//            }
//        });
//
//        return returnNum4;
//    }
//
//    //DB에 정보 셋팅
//    public void setMediData_num1(Realm realm, final String name, final String info, final String caution, final String donot, final int all, final int one) {
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                MediDB mediDB = realm.where(MediDB.class).findFirst();
//
//                returnNum1 = mediDB.getNum1();
//                returnNum1.setMember_name(name);
//                returnNum1.setMember_info(info);
//                returnNum1.setMember_caution(caution);
//                returnNum1.setMember_donot(donot);
//                returnNum1.setMember_all(all);
//                returnNum1.setMember_one(one);
//                returnNum1.setCnt(all/one);
//
//                mediDB.setNum1(returnNum1);
//
//            }
//        });
//
//    }
//
//    public void setMediData_num2(Realm realm, final String name, final String info, final String caution, final String donot, final int all, final int one) {
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                MediDB mediDB = realm.where(MediDB.class).findFirst();
//
//                returnNum2 = mediDB.getNum2();
//                returnNum2.setMember_name(name);
//                returnNum2.setMember_info(info);
//                returnNum2.setMember_caution(caution);
//                returnNum2.setMember_donot(donot);
//                returnNum2.setMember_all(all);
//                returnNum2.setMember_one(one);
//                returnNum2.setCnt(all/one);
//
//                mediDB.setNum2(returnNum2);
//
//            }
//        });
//
//    }
//
//    public void setMediData_num3(Realm realm, final String name, final String info, final String caution, final String donot, final int all, final int one) {
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                MediDB mediDB = realm.where(MediDB.class).findFirst();
//
//                returnNum3 = mediDB.getNum3();
//                returnNum3.setMember_name(name);
//                returnNum3.setMember_info(info);
//                returnNum3.setMember_caution(caution);
//                returnNum3.setMember_donot(donot);
//                returnNum3.setMember_all(all);
//                returnNum3.setMember_one(one);
//                returnNum3.setCnt(all/one);
//
//                mediDB.setNum3(returnNum3);
//
//            }
//        });
//
//    }
//
//    public void setMediData_num4(Realm realm, final String name, final String info, final String caution, final String donot, final int all, final int one) {
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                MediDB mediDB = realm.where(MediDB.class).findFirst();
//
//                returnNum4 = mediDB.getNum4();
//                returnNum4.setMember_name(name);
//                returnNum4.setMember_info(info);
//                returnNum4.setMember_caution(caution);
//                returnNum4.setMember_donot(donot);
//                returnNum4.setMember_all(all);
//                returnNum4.setMember_one(one);
//                returnNum4.setCnt(all/one);
//
//                mediDB.setNum4(returnNum4);
//
//            }
//        });
//
//    }
//
//
//
//    //DB삭제
//    public void clear(Realm realm) {
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                realm.delete(MediDB.class);
//            }
//        });
//    }
//
//
//
//}
