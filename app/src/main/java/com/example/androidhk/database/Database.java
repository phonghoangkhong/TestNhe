package com.example.androidhk.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidhk.model.User;

import com.example.androidhk.model.Info;


public class Database extends SQLiteOpenHelper {
 private static String DB_NAME="qlnv";
 private String User_table="User";
 private String ID="id";
 private String Username="username";
 private  String Password="password";
 Context context;
    public Database(Context context) {



           super(context,DB_NAME,null,1);
         this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreate1=String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY,%s TEXT)",User_table,Username,Password);
        String queryCreate2="CREATE TABLE info(id INTEGER PRIMARY KEY AUTOINCREMENT,ten TEXT, tuoi INTEGER, phongban TEXT," +
                "username TEXT ,trangthai TEXT,quequan TEXT,hocvan TEXT, quaTrinhDaoTao TEXT, quaTrinhLamviec TEXT, " +
                "date TEXT,ngaysinh text,FOREIGN KEY(username) references User(username))";
        String inserQuery="INSERT INTO User(username,password) values('phongkh','phongkh123')";

        db.execSQL(queryCreate1);
        db.execSQL(inserQuery);
        db.execSQL(queryCreate2);
    }
    public void addUser(User user ){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Username,user.getUsername());
        contentValues.put(Password,user.getPassword());
        database.insert(User_table,null,contentValues);
        database.close();
    }
    public User findUserByName(String username ){
        SQLiteDatabase database=getReadableDatabase();
        User user=new User();
        String [] cot={Username,Password};
        String clause=Username + "=?";
        String args[]=new String[]{username};
        Cursor cursor=database.query(User_table,cot,clause,args,null,null,null);
        if(cursor.moveToFirst()){
                user.setUsername(cursor.getString(0));
                user.setPassword(cursor.getString(1));
        }
        database.close();
        return user;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String drop_user_table = String.format("drop table if exist %s", User_table);
        onCreate(db);
        db.close();
    }

    public void addInfo(Info info){
         SQLiteDatabase database=getWritableDatabase();
         ContentValues contentValues=new ContentValues();
         contentValues.put("ten",info.getTen());
         contentValues.put("tuoi",info.getTuoi());
         contentValues.put("phongban",info.getPhongban());
         contentValues.put("username",info.getUsername());
         contentValues.put("trangthai",info.getTrangthai());
         contentValues.put("quequan",info.getQuequan());
         contentValues.put("hocvan",info.getHocvan());
         contentValues.put("quaTrinhDaoTao",info.getQuaTrinhDaoTao());
         contentValues.put("quaTrinhLamViec",info.getQuaTrinhLamViec());
        contentValues.put("date",info.getDate());
         contentValues.put("ngaysinh",info.getNgaysinh());
         database.insert("info",null,contentValues);
         database.close();
    }
    public Info getInfo(String username){
        SQLiteDatabase database=getReadableDatabase();
        String [] cot={"id","ten","tuoi","phongban","trangThai","quequan","hocvan" ,"quaTrinhDaoTao" ,"quaTrinhLamviec" ,
                "date","username","ngaysinh"};
         String clause="username= ?";
         String args[]=new String[]{username};
         Cursor cursor=database.query("info",cot,clause,args,null,null,null);
         Info info=new Info();
         if(cursor.moveToFirst()){
             info.setId(cursor.getInt(0));
             info.setTen(cursor.getString(1));
             info.setTuoi(cursor.getString(2));
             info.setPhongban(cursor.getString(3));
             info.setTrangthai(cursor.getString(4));
             info.setQuequan(cursor.getString(5));
             info.setHocvan(cursor.getString(6));
             info.setQuaTrinhDaoTao(cursor.getString(7));
             info.setQuaTrinhLamViec(cursor.getString(8));
             info.setDate(cursor.getString(9));
             info.setUsername(cursor.getString(10));
             info.setNgaysinh(cursor.getString(11));
             System.out.println(info);
             return info;
         }else{
             return null;

         }

    }
    public void updateInfo(Info info){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ten",info.getTen());
        contentValues.put("tuoi",info.getTuoi());
        contentValues.put("phongban",info.getPhongban());
        contentValues.put("username",info.getUsername());
        contentValues.put("trangthai",info.getTrangthai());
        contentValues.put("quequan",info.getQuequan());
        contentValues.put("hocvan",info.getHocvan());
        contentValues.put("quaTrinhDaoTao",info.getQuaTrinhDaoTao());
        contentValues.put("quaTrinhLamViec",info.getQuaTrinhLamViec());
        contentValues.put("ngaysinh",info.getNgaysinh());
        String clause="username = ?";
        String []args=new String[]{info.getUsername()};
      int a=  database.update("info",contentValues,clause,args);
        System.out.println(a);
        database.close();
    }

}

