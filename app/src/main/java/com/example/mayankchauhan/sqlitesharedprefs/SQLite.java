package com.example.mayankchauhan.sqlitesharedprefs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mayankchauhan on 03/03/17.
 */

public class SQLite extends SQLiteOpenHelper {

    private static final String DB_NAME = "STUDENT" ;
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "STUDENT";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME" ;
    private static final String COL_PHONE = "PHONE" ;

    SQLiteDatabase mSqliteDatabase;

    public SQLite(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME+"("+COL_ID+ " INTEGER PRIMARY KEY,"
                +COL_NAME+ " TEXT,"+COL_PHONE +" TEXT)";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertStudent(String name , String phone)
    {
        mSqliteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME,name);
        values.put(COL_PHONE,phone);

        mSqliteDatabase.insert(TABLE_NAME , null , values);
        mSqliteDatabase.close();
    }

    public void getAllStudents()
    {
        mSqliteDatabase = this.getReadableDatabase();

        String select_all = "Select * from "+ TABLE_NAME;
        Cursor cursor = mSqliteDatabase.rawQuery(select_all,null);
        if (cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
                String phone = cursor.getString(cursor.getColumnIndex(COL_PHONE));
            }while (cursor.moveToNext());
        }

        mSqliteDatabase.close();
    }

}
