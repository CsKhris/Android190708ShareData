package com.cs.android190708sharedata;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    // 모든 곳에서 사용할 Database 변수
    SQLiteDatabase db;

    public MyContentProvider() {
    }

    // Data를 삭제하는 Method
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int row = db.delete("tb_data", selection, selectionArgs);
        return row;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // Data를 삽입하는 Method
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        db.insert("tb_data", null, values);
        return uri;
    }

    // 맨 처음 한번만 호출되는 Method로 가장 먼저 호출 됩니다.
    @Override
    public boolean onCreate() {
        // Database 사용을 위한 Instance 생성
        DBHelper helper = new DBHelper(getContext());
        db = helper.getWritableDatabase();
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor = db.query("tb_data", projection, selection, selectionArgs, null, null, sortOrder);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int row = db.update("tb_data", values, selection, selectionArgs);
        return row;
    }
}
