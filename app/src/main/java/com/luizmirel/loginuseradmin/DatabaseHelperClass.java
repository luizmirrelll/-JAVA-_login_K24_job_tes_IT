package com.luizmirel.loginuseradmin;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.luizmirel.loginuseradmin.UserModelClass;
import com.luizmirel.loginuseradmin.EmployeeModelClass;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "employee_database";
    //Database Table name
    private static final String TABLE_NAME = "EMPLOYEE";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASS = "pass";
    public static final String USERNAME = "username";
    public static final String JK = "jk";
    public static final String TTL = "ttl";
    public static final String ALAMAT = "alamat";
    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
        " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL,"+PASS+" TEXT NOT NULL,"+USERNAME+" TEXT NOT NULL,"+JK+" TEXT NOT NULL,"+TTL+" TEXT NOT NULL,"+ALAMAT+" TEXT NOT NULL);";
    //Constructor
    public DatabaseHelperClass (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add Employee Data
    public void addEmployee(EmployeeModelClass employeeModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME, employeeModelClass.getName());
        contentValues.put(DatabaseHelperClass.EMAIL, employeeModelClass.getEmail());
        contentValues.put(DatabaseHelperClass.PASS, employeeModelClass.getPass());
        contentValues.put(DatabaseHelperClass.USERNAME, employeeModelClass.getUsername());
        contentValues.put(DatabaseHelperClass.JK, employeeModelClass.getJk());
        contentValues.put(DatabaseHelperClass.TTL, employeeModelClass.getTtl());
        contentValues.put(DatabaseHelperClass.ALAMAT, employeeModelClass.getAlamat());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null,contentValues);
    }

    public List<EmployeeModelClass> getEmployeeList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<EmployeeModelClass> storeEmployee = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String pass = cursor.getString(3);
                String username = cursor.getString(4);
                String jk = cursor.getString(5);
                String ttl = cursor.getString(6);
                String alamat = cursor.getString(7);
                storeEmployee.add(new EmployeeModelClass(id,name,email,pass,username,jk,ttl,alamat));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeEmployee;
    }

    public void updateEmployee(EmployeeModelClass employeeModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME,employeeModelClass.getName());
        contentValues.put(DatabaseHelperClass.EMAIL,employeeModelClass.getEmail());
        contentValues.put(DatabaseHelperClass.PASS, employeeModelClass.getPass());
        contentValues.put(DatabaseHelperClass.USERNAME, employeeModelClass.getUsername());
        contentValues.put(DatabaseHelperClass.JK, employeeModelClass.getJk());
        contentValues.put(DatabaseHelperClass.TTL, employeeModelClass.getTtl());
        contentValues.put(DatabaseHelperClass.ALAMAT, employeeModelClass.getAlamat());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(employeeModelClass.getId())});
    }

    public void deleteEmployee(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

    //LOGIN USER


    public boolean checkUser(String username, String pass){
        String[] columns = {ID};
        SQLiteDatabase db = getReadableDatabase();
        String selection = USERNAME + "=?" + " and " + PASS + "=?";
        String[] selectionArgs = {username,pass};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count>0)
            return true;
        else
            return false;
    }
    //USER
    public List<UserModelClass> getUserList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<UserModelClass> storeUser = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String pass = cursor.getString(3);
                String username = cursor.getString(4);
                String jk = cursor.getString(5);
                String ttl = cursor.getString(6);
                String alamat = cursor.getString(7);
                storeUser.add(new UserModelClass(id,name,email,pass,username,jk,ttl,alamat));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeUser;
    }
    //USER UPDATE
//    public void updateUser(UserModelClass usereModelClass){
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHelperClass.NAME,usereModelClass.getName());
//        contentValues.put(DatabaseHelperClass.EMAIL,usereModelClass.getEmail());
//        contentValues.put(DatabaseHelperClass.PASS, usereModelClass.getPass());
//        contentValues.put(DatabaseHelperClass.USERNAME, usereModelClass.getUsername());
//        contentValues.put(DatabaseHelperClass.JK, usereModelClass.getJk());
//        contentValues.put(DatabaseHelperClass.TTL, usereModelClass.getTtl());
//        contentValues.put(DatabaseHelperClass.ALAMAT, usereModelClass.getAlamat());
//        sqLiteDatabase = this.getWritableDatabase();
//        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
//                {String.valueOf(usereModelClass.getId())});
//    }

}
