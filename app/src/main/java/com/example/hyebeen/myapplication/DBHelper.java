package com.example.hyebeen.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        /* 이름은 MONEYBOOK이고, 자동으로 값이 증가하는 _id 정수형 기본키 컬럼과
        item 문자열 컬럼, price 정수형 컬럼, create_at 문자열 컬럼으로 구성된 테이블을 생성. */
        //db.execSQL("drop table MONEYBOOKS;");
        db.execSQL("CREATE TABLE MONEYBOOKS (num INTEGER, name TEXT, info TEXT, caution TEXT, donot TEXT, allnum INTEGER, one INTEGER, cnt INTEGER, img TEXT);");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(int num, String name, String info, String caution, String donot, int allnum, int one, int cnt,String img) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        cnt=allnum/one;
        db.execSQL("INSERT INTO MONEYBOOKS VALUES(" + num + ", '" + name + "', '" + info + "', '" + caution + "', '" + donot + "', " + allnum + ", " + one + ", " + cnt + ", '" + img + "');");
        db.close();
    }

    public void update(String item, int price) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행의 가격 정보 수정
        db.execSQL("UPDATE MONEYBOOKS SET price=" + price + " WHERE item='" + item + "';");
        db.close();
    }

    public void delete(int num) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        db.execSQL("DELETE FROM MONEYBOOKS WHERE num = num;");
        db.close();
    }

    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOKS", null);
        while (cursor.moveToNext()) {
            result += cursor.getInt(0)
                    + " : "
                    + cursor.getString(1)
                    + " : "
                    + cursor.getString(2)
                    + " : "
                    + cursor.getString(3)
                    + " : "
                    + cursor.getString(4)
                    + " : "
                    + cursor.getInt(5)
                    + " : "
                    + cursor.getInt(6)
                    + " : "
                    + cursor.getInt(7)
                    + " : "
                    + cursor.getString(8) +"\n";

        }

        return result;
    }
    public boolean isExist(int buttonNum) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOKS", null);


        while (cursor.moveToNext()){
            if(cursor.getInt(0)==buttonNum){
                return true;
            }
        }
        return false;
    }

    public String findinfo(int num){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOKS", null);
        while (cursor.moveToNext()){
            if(cursor.getInt(0)==num)
                return cursor.getString(2);
        }
        return "찾을 수 없습니다.";
    }

    public String findcaution(int num){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOKS", null);
        while (cursor.moveToNext()){
            if(cursor.getInt(0)==num)
                return cursor.getString(3);
        }
        return "찾을 수 없습니다.";
    }

    public String finddonot(int num){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOKS", null);
        while (cursor.moveToNext()){
            if(cursor.getInt(0)==num)
                return cursor.getString(4);
        }
        return "찾을 수 없습니다.";
    }

    public String findname(int num){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOKS", null);
        while (cursor.moveToNext()){
            if(cursor.getInt(0)==num)
                return cursor.getString(1);
        }
        return "찾을 수 없습니다.";
    }

    public int findall(int num){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOKS", null);
        while (cursor.moveToNext()){
            if(cursor.getInt(0)==num)
                return cursor.getInt(5);
        }
        return 0000;
    }

    public String findimg(int num){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOKS", null);
        while (cursor.moveToNext()){
            if(cursor.getInt(0)==num)
                return cursor.getString(8);
        }
        return "찾을 수 없습니다.";
    }

    public int findone(int num){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOKS", null);
        while (cursor.moveToNext()){
            if(cursor.getInt(0)==num)
                return cursor.getInt(6);
        }
        return 0000;
    }
}