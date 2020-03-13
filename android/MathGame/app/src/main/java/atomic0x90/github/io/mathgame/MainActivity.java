package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.AudioManager;
import android.media.SoundPool;

import android.os.Bundle;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.File;



public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqliteDB ;
    int nowCoin = 10;
    String coinDateTime;
    int[] resultarr = {0,0,0,0,0,0,0,0,0,0};

    //AD
    private AdView mAdView;



    //Double click check
    private long mLastClickTime = 0;

    //Sound
    SoundPool soundPool;
    int soundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AD
        MobileAds.initialize(this, String.valueOf(R.string.TEST_AD_BANNER_ID));
        MobileAds.initialize(this, String.valueOf(R.string.TEST_AD_REWARD_ID));
        MobileAds.initialize(this,String.valueOf(R.string.TEST_AD_FULL_ID));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        //Sound
        soundPool = new SoundPool(5,AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound01,1);


        //DB
        sqliteDB = init_database() ;
        init_tables();
        load_coin();

        //Coin
        Button coinbutton = (Button) findViewById(R.id.coinNowButton);

        coinbutton.setText(String.valueOf(nowCoin));

        //더하기 도전 버튼
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick (View v){
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(MainActivity.this,Challenge_add.class);
                intent.putExtra("Number_of_time",0);
                intent.putExtra("Answer_state",resultarr);
                intent.putExtra("Average_time",(double)0);
                startActivity(intent);
            }
        });

        //빼기 도전 버튼
        Button subButton = (Button) findViewById(R.id.subButton);
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(MainActivity.this,Challenge_sub.class);
                intent.putExtra("Number_of_time",0);
                intent.putExtra("Answer_state",resultarr);
                intent.putExtra("Average_time",(double)0);
                startActivity(intent);
            }
        });

        //곱하기 도전 버튼
        Button mulButton = (Button) findViewById(R.id.multiButton);
        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(MainActivity.this,Challenge_multi.class);
                intent.putExtra("Number_of_time",0);
                intent.putExtra("Answer_state",resultarr);
                intent.putExtra("Average_time",(double)0);
                startActivity(intent);
            }
        });

        //나누기 도전 버튼
        Button divideButton = (Button) findViewById(R.id.divideButton);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(MainActivity.this,Challenge_divide.class);
                intent.putExtra("Number_of_time",0);
                intent.putExtra("Answer_state",resultarr);
                intent.putExtra("Average_time",(double)0);
                startActivity(intent);
            }
        });

        //1분 무한 더하기 도전 버튼
        Button infinityPlusButton = (Button)findViewById(R.id.infiaddButton);
        infinityPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(MainActivity.this,InfinityPlusMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        //나가기 버튼
        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("정말로 종료 하시겠습니까?");
                builder.setTitle("종료 버튼");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("수학 게임 - 두뇌 트레이닝");
                alertDialog.show();
            }
        });

        //사용자 통계 버튼
        Button statsButton = (Button)findViewById(R.id.statsButton);
        statsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);


                Intent intent = new Intent(MainActivity.this,SplashScreen.class);
                intent.putExtra("Text","Statistics");
                startActivity(intent);

                //FULL_AD();
                
            }
        });

        //설정 버튼
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

        if (sqliteDB != null) {
            //Coin table
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS Coin (" +
                    "coin "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            System.out.println(sqlCreateTbl) ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            String sqlQuery = "SELECT * FROM Coin";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
            //coin 값이 없는 경우
            if(!cursor.moveToNext()){
                String sqlInsert = "INSERT INTO Coin " + "(coin)" + "VALUES (" + 0 +");";
                System.out.println("TEST Insert : " + sqlInsert);
                sqliteDB.execSQL(sqlInsert);
            }}catch (Exception e){
                System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFF "+e);
            }

            //Add table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS ChAdd (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "AVtime " + "REAL NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";
            System.out.println(sqlCreateTbl);

            sqliteDB.execSQL(sqlCreateTbl);

            //Sub table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS ChSub (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "AVtime " + "REAL NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);

            //Multi table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS ChMul (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "AVtime " + "REAL NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);

            //Divide table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS ChDiv (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "AVtime " + "REAL NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);

            /*
            //Infinity Plus 6 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiP6 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiP6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiP6 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiP6 table : "+e);
            }
*/

            //Infinity Plus 6 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP6 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);



            //Infinity Plus 7 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiP7 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiP7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiP7 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiP7 table : "+e);
            }

            //Infinity Plus 7 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP7 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);



            //Infinity Plus 8 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiP8 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiP8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiP8 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiP8 table : "+e);
            }

            //Infinity Plus 8 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP8 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);




            //Infinity Plus 13 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiP13 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiP13";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiP13 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiP13 table : "+e);
            }

            //Infinity Plus 13 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP13 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);




            //Infinity Plus 16 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiP16 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiP16";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiP16 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiP16 table : "+e);
            }

            //Infinity Plus 16 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP16 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);



            //Infinity Plus 17 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiP17 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiP17";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiP17 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiP17 table : "+e);
            }

            //Infinity Plus 17 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP17 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);




            //Infinity Plus 6~9 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiPR6_9 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiPR6_9";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiPR6_9 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiPR6_9 table : "+e);
            }

            //Infinity Plus 6~9 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChPR6_9 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);



            //Infinity Plus 13~17 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiPR13_17 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiPR13_17";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiPR13_17 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiPR13_17 table : "+e);
            }

            //Infinity Plus 13~17 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChPR13_17 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);





            //Infinity Plus 6~17 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiPR6_17 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiPR6_17";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiPR6_17 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiPR6_17 table : "+e);
            }

            //Infinity Plus 6~17 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChPR6_17 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);


            //Minus
            //Infinity Minus 6 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM6 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);


            //Infinity Minus 7 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiM7 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiM7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiM7 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiM7 table : "+e);
            }

            //Infinity Minus 7 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM7 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);



            //Infinity Minus 8 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiM8 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiM8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiM8 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiM8 table : "+e);
            }

            //Infinity Minus 8 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM8 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);





            //Infinity Minus 13 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiM13 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiM13";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiM13 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiM13 table : "+e);
            }

            //Infinity Minus 13 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM13 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);




            //Infinity Minus 16 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiM16 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiM16";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiM16 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiM16 table : "+e);
            }

            //Infinity Minus 16 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM16 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);






            //Infinity Minus 17 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiM17 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiM17";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiM17 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiM17 table : "+e);
            }

            //Infinity Minus 17 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM17 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);






            //Infinity Minus 6_9 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiMR6_9 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiMR6_9";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiMR6_9 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiMR6_9 table : "+e);
            }

            //Infinity Minus 6_9 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChMR6_9 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);




            //Infinity Minus 13_17 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiMR13_17 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiMR13_17";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiMR13_17 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiMR13_17 table : "+e);
            }

            //Infinity Minus 13_17 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChMR13_17 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);



            //Infinity Minus 6_17 lock check table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiMR6_17 (" +
                    "lock "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            sqlQuery = "SELECT * FROM InfiMR6_17";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO InfiMR6_17 " + "(lock)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("InfiMR6_17 table : "+e);
            }

            //Infinity Minus 6_17 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChMR6_17 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqliteDB.execSQL(sqlCreateTbl);


        }
    }

    private void load_coin(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM Coin";
            Cursor cursor = null;

            cursor = sqliteDB.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                nowCoin = cursor.getInt(0);
                System.out.println(nowCoin + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");

                coinDateTime = cursor.getString(1);
                System.out.println(coinDateTime);
            }
            else
                System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        }
    }





    // 마지막으로 뒤로 가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    // 첫 번째 뒤로 가기 버튼을 누를 때 표시
    private Toast toast;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        // 기존 뒤로 가기 버튼의 기능을 막기 위해 주석 처리 또는 삭제

        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지났으면 Toast 출력
        // 2500 milliseconds = 2.5 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지나지 않았으면 종료
        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            finish();
            toast.cancel();
            toast = Toast.makeText(this,"이용해 주셔서 감사합니다.",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}




