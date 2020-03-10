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




