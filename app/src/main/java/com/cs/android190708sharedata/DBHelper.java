package com.cs.android190708sharedata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    // 생성자 - Context를 호출하여 상위 Class의 생성자 호출
    public DBHelper(Context context){
        super(context, "datadb", null,1);
    }

    // 처음 사용할 때 한번 호출되는 Method
    @Override
    public void onCreate(SQLiteDatabase db){
        // Table을 생성하고 Data를 초기화 하는 작업
        // Server에서 호출할 Data가 있으면 가져와서 저장
        String tableSql = "create table tb_data(" + "_id integer primary key autoincrement, " + "name text, phone text)";

        // SQL 실행
        db.execSQL(tableSql);

        // 기본 Data 삽입
        db.execSQL("insert into tb_data(name, phone) " + "values( '차범근', '01011111111')");
        db.execSQL("insert into tb_data(name, phone) " + "values( '손흥민', '01011112222')");
        db.execSQL("insert into tb_data(name, phone) " + "values( '황의조', '01011113333')");
    }

    // Database Version이 변경된 경우 호출되는 Method
    // 기존 Data를 삭제하고 Table을 다시 생성 합니다.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table tb_data");
        onCreate(db);
    }
}
