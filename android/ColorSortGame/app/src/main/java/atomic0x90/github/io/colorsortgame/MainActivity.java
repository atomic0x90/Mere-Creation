package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqliteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqliteDB = init_database();
        init_tables();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Game_X.class);
                startActivity(intent);
            }
        });

        Button button1 = (Button) findViewById(R.id.button17);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Game_5_5.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.GameStartButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StepSelection.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }

    //DB
    private SQLiteDatabase init_database() {

        SQLiteDatabase db = null ;
        // File file = getDatabasePath("contact.db") ;
        File file = new File(getFilesDir(), "contact.db") ;

        System.out.println("PATH : " + file.toString()) ;
        try {
            db = SQLiteDatabase.openOrCreateDatabase(file, null) ;
        } catch (SQLiteException e) {
            e.printStackTrace() ;
        }

        if (db == null) {
            System.out.println("DB creation failed. " + file.getAbsolutePath()) ;
        }

        return db ;
    }

    private void init_tables() {
        if(sqliteDB != null){
            //Game Lock table 4-4-1
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            String sqlQuery = "SELECT * FROM GameLock4_4_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_1" + "(Lock)" + "VALUES (" + 0 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }
            //Game Lock table 4-4-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-9
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_9 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_9";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_9" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-10
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_10 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_10";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_10" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-11
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_11 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_11";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_11" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-12
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_12 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_12";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_12" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-13
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_13 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_13";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_13" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-14
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_14 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_14";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_14" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-15
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_15 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_15";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_15" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-16
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_16 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_16";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_16" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-17
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_17 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_17";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_17" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-18
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_18 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_18";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_18" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-19
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_19 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_19";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_19" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-20
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_20 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_20";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_20" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-21
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_21 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_21";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_21" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-22
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_22 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_22";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_22" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-23
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_23 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_23";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_23" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-24
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_24 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_24";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_24" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-25
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_25 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_25";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_25" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-26
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_26 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_26";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_26" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-27
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_27 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_27";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_27" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-28
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_28 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_28";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_28" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-29
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_29 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_29";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_29" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-30
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_30 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_30";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_30" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-31
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_31 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_31";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_31" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-32
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_32 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_32";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_32" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-33
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_33 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_33";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_33" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-34
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_34 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_34";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_34" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-35
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_35 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_35";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_35" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-36
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_36 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_36";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_36" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-37
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_37 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_37";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_37" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-38
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_38 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_38";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_38" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-39
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_39 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_39";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_39" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-40
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_40 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_40";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_40" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-41
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_41 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_41";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_41" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-42
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_42 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_42";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_42" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-43
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_43 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_43";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_43" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-44
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_44 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_44";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_44" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-45
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_45 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_45";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_45" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-46
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_46 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_46";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_46" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-47
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_47 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_47";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_47" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-48
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_48 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_48";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_48" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-49
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_49 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_49";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_49" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4-50
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_50 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4_50";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_50" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_1" + "(Lock)" + "VALUES (" + 0 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-9
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_9 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_9";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_9" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-10
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_10 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_10";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_10" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-11
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_11 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_11";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_11" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-12
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_12 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_12";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_12" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-13
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_13 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_13";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_13" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-14
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_14 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_14";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_14" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-15
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_15 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_15";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_15" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-16
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_16 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_16";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_16" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-17
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_17 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_17";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_17" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-18
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_18 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_18";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_18" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-19
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_19 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_19";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_19" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-20
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_20 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_20";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_20" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-21
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_21 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_21";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_21" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-22
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_22 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_22";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_22" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-23
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_23 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_23";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_23" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-24
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_24 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_24";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_24" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-25
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_25 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_25";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_25" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-26
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_26 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_26";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_26" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-27
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_27 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_27";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_27" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-28
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_28 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_28";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_28" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-29
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_29 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_29";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_29" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-30
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_30 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_30";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_30" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-31
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_31 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_31";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_31" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-32
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_32 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_32";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_32" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-33
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_33 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_33";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_33" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-34
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_34 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_34";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_34" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-35
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_35 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_35";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_35" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-36
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_36 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_36";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_36" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-37
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_37 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_37";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_37" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-38
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_38 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_38";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_38" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-39
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_39 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_39";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_39" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-40
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_40 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_40";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_40" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-41
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_41 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_41";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_41" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-42
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_42 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_42";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_42" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-43
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_43 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_43";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_43" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-44
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_44 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_44";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_44" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-45
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_45 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_45";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_45" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-46
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_46 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_46";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_46" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-47
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_47 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_47";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_47" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-48
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_48 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_48";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_48" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-49
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_49 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_49";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_49" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5-50
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5_50 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5_50";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5_50" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch ( Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


        }
    }
}
