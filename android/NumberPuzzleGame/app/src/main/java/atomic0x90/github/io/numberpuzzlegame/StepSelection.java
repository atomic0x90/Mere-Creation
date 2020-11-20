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
    int lock2_5 = -1;
    int lock2_6 = -1;
    int lock2_7 = -1;
    int lock2_8 = -1;

    int lock3_1 = -1;
    int lock3_2 = -1;
    int lock3_3 = -1;
    int lock3_4 = -1;
    int lock3_5 = -1;
    int lock3_6 = -1;
    int lock3_7 = -1;
    int lock3_8 = -1;

    int lock4_1 = -1;
    int lock4_2 = -1;
    int lock4_3 = -1;
    int lock4_4 = -1;
    int lock4_5 = -1;
    int lock4_6 = -1;
    int lock4_7 = -1;
    int lock4_8 = -1;

    int lock5_1 = -1;
    int lock5_2 = -1;
    int lock5_3 = -1;
    int lock5_4 = -1;
    int lock5_5 = -1;
    int lock5_6 = -1;
    int lock5_7 = -1;
    int lock5_8 = -1;

    int lock6_1 = -1;
    int lock6_2 = -1;
    int lock6_3 = -1;
    int lock6_4 = -1;
    int lock6_5 = -1;
    int lock6_6 = -1;
    int lock6_7 = -1;
    int lock6_8 = -1;

    int lock7_1 = -1;
    int lock7_2 = -1;
    int lock7_3 = -1;
    int lock7_4 = -1;
    int lock7_5 = -1;
    int lock7_6 = -1;
    int lock7_7 = -1;
    int lock7_8 = -1;

    int lock8_1 = -1;
    int lock8_2 = -1;
    int lock8_3 = -1;
    int lock8_4 = -1;
    int lock8_5 = -1;
    int lock8_6 = -1;
    int lock8_7 = -1;
    int lock8_8 = -1;

    int lock9_1 = -1;
    int lock9_2 = -1;
    int lock9_3 = -1;
    int lock9_4 = -1;
    int lock9_5 = -1;
    int lock9_6 = -1;
    int lock9_7 = -1;
    int lock9_8 = -1;

    int lock10_1 = -1;
    int lock10_2 = -1;
    int lock10_3 = -1;
    int lock10_4 = -1;
    int lock10_5 = -1;
    int lock10_6 = -1;
    int lock10_7 = -1;
    int lock10_8 = -1;

    @Override
    protected void onStart() {
        super.onStart();

        loadGameLockALL();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_selection);
        sqliteDB = init_database();
        loadGameLockALL();

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

    private void loadGameLockALL(){
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
        loadGameLock2_5();
        loadGameLock2_6();
        loadGameLock2_7();
        loadGameLock2_8();

        loadGameLock3_1();
        loadGameLock3_2();
        loadGameLock3_3();
        loadGameLock3_4();
        loadGameLock3_5();
        loadGameLock3_6();
        loadGameLock3_7();
        loadGameLock3_8();

        loadGameLock4_1();
        loadGameLock4_2();
        loadGameLock4_3();
        loadGameLock4_4();
        loadGameLock4_5();
        loadGameLock4_6();
        loadGameLock4_7();
        loadGameLock4_8();

        loadGameLock5_1();
        loadGameLock5_2();
        loadGameLock5_3();
        loadGameLock5_4();
        loadGameLock5_5();
        loadGameLock5_6();
        loadGameLock5_7();
        loadGameLock5_8();

        loadGameLock6_1();
        loadGameLock6_2();
        loadGameLock6_3();
        loadGameLock6_4();
        loadGameLock6_5();
        loadGameLock6_6();
        loadGameLock6_7();
        loadGameLock6_8();

        loadGameLock7_1();
        loadGameLock7_2();
        loadGameLock7_3();
        loadGameLock7_4();
        loadGameLock7_5();
        loadGameLock7_6();
        loadGameLock7_7();
        loadGameLock7_8();

        loadGameLock8_1();
        loadGameLock8_2();
        loadGameLock8_3();
        loadGameLock8_4();
        loadGameLock8_5();
        loadGameLock8_6();
        loadGameLock8_7();
        loadGameLock8_8();

        loadGameLock9_1();
        loadGameLock9_2();
        loadGameLock9_3();
        loadGameLock9_4();
        loadGameLock9_5();
        loadGameLock9_6();
        loadGameLock9_7();
        loadGameLock9_8();

        loadGameLock10_1();
        loadGameLock10_2();
        loadGameLock10_3();
        loadGameLock10_4();
        loadGameLock10_5();
        loadGameLock10_6();
        loadGameLock10_7();
        loadGameLock10_8();
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
    private void loadGameLock2_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock3_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock4_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock5_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock6_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock7_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock8_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock9_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock10_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_8 = cursor.getInt(0);
            }
        }
    }
}
