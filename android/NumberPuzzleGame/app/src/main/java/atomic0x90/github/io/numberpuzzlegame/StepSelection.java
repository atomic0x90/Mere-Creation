package atomic0x90.github.io.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;

public class StepSelection extends AppCompatActivity {

    SQLiteDatabase sqliteDB ;

    int lock1_1 = -1;
    int lock1_2 = -1;
    int lock1_3 = -1;
    int lock1_4 = -1;
    int lock1_5 = -1;
    int lock1_6 = -1;
    int lock1_7 = -1;
    int lock1_8 = -1;

    int lock2_1 = -1;
    int lock2_2 = -1;
    int lock2_3 = -1;
    int lock2_4 = -1;
    int lock2_5 = 0;
    int lock2_6 = 0;
    int lock2_7 = 0;
    int lock2_8 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_selection);

        sqliteDB = init_database();

        loadGameLock1_1();
        loadGameLock1_2();
        loadGameLock1_3();
        loadGameLock1_4();
        loadGameLock1_5();
        loadGameLock1_6();
        loadGameLock1_7();
        loadGameLock1_8();

        loadGameLock2_1();
        loadGameLock2_2();
        loadGameLock2_3();
        loadGameLock2_4();

        System.out.println("load 1_1 : "+lock1_1);
        System.out.println("load 1_2 : "+lock1_2);
        System.out.println("load 1_3 : "+lock1_3);
        System.out.println("load 1_4 : "+lock1_4);
        System.out.println("load 1_5 : "+lock1_5);
        System.out.println("load 1_6 : "+lock1_6);
        System.out.println("load 1_7 : "+lock1_7);
        System.out.println("load 1_8 : "+lock1_8);

        System.out.println("load 2_1 : "+lock2_1);
        System.out.println("load 2_2 : "+lock2_2);
        System.out.println("load 2_3 : "+lock2_3);
        System.out.println("load 2_4 : "+lock2_4);
        final Button Step1Button = (Button) findViewById(R.id.Step1Button);
        final Button Step2Button = (Button) findViewById(R.id.Step2Button);

        Button Step1_1Button = (Button) findViewById(R.id.Step1_1);
        Button Step1_2Button = (Button) findViewById(R.id.Step1_2);
        Button Step1_3Button = (Button) findViewById(R.id.Step1_3);
        Button Step1_4Button = (Button) findViewById(R.id.Step1_4);
        Button Step1_5Button = (Button) findViewById(R.id.Step1_5);
        Button Step1_6Button = (Button) findViewById(R.id.Step1_6);
        Button Step1_7Button = (Button) findViewById(R.id.Step1_7);
        Button Step1_8Button = (Button) findViewById(R.id.Step1_8);

        Button Step2_1Button = (Button) findViewById(R.id.Step2_1);
        Button Step2_2Button = (Button) findViewById(R.id.Step2_2);
        Button Step2_3Button = (Button) findViewById(R.id.Step2_3);
        Button Step2_4Button = (Button) findViewById(R.id.Step2_4);
        Button Step2_5Button = (Button) findViewById(R.id.Step2_5);
        Button Step2_6Button = (Button) findViewById(R.id.Step2_6);
        Button Step2_7Button = (Button) findViewById(R.id.Step2_7);
        Button Step2_8Button = (Button) findViewById(R.id.Step2_8);

        final LinearLayout Step1Ver = (LinearLayout) findViewById(R.id.Step1Ver);
        final LinearLayout Step2Ver = (LinearLayout) findViewById(R.id.Step2Ver);

        Step1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step1Ver.getVisibility() == View.GONE)
                    Step1Ver.setVisibility(View.VISIBLE);
                else
                    Step1Ver.setVisibility(View.GONE);
            }
        });

        Step2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Step2Ver.getVisibility() == View.GONE)
                    Step2Ver.setVisibility(View.VISIBLE);
                else
                    Step2Ver.setVisibility(View.GONE);
            }
        });


        Step1_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StepSelection.this,GameLine2.class);
                intent.putExtra("Max",4);
                intent.putExtra("Answer","1_1");
                startActivity(intent);
            }
        });

        Step1_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_2");
                    startActivity(intent);
                }
            }
        });

        Step1_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_3");
                    startActivity(intent);
                }
            }
        });

        Step1_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_4");
                    startActivity(intent);
                }
            }
        });

        Step1_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_5");
                    startActivity(intent);
                }
            }
        });

        Step1_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_6");
                    startActivity(intent);
                }
            }
        });

        Step2_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Step2_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock2_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
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

    private void loadGameLock1_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock2_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_4 = cursor.getInt(0);
            }
        }
    }
}
