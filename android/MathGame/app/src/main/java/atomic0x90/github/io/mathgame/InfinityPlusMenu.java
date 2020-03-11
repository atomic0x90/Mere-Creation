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
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;
import java.util.Random;

public class InfinityPlusMenu extends AppCompatActivity {

    //Coin
    int nowCoin = 0;
    int nowUpDateCoin = 0;

    //Sound
    SoundPool soundPool;
    int soundID;

    //AD
    private AdView mAdView;

    //DB
    SQLiteDatabase sqLiteDatabase;
    int lock7 = 0;
    int lock8 = 0;
    int lock13 = 0;
    int lock16 = 0;
    int lock17 = 0;
    int lock6_9 = 0;
    int lock13_17 = 0;
    int lock6_17 = 0;

    //Double click check
    private long mLastClickTime = 0;


    //lock check: lock == 0 -> lock, lock == 1 -> unlock

    //intent


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinity_plus_menu);

        //DB
        sqLiteDatabase = init_database();
        load_lock7();
        load_lock8();
        load_lock13();
        load_lock16();
        load_lock17();
        load_lock6_9();
        load_lock13_17();
        load_lock6_17();

        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound01,1);


        //AD
        mAdView = findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Coin
        Button coinNowButton = (Button)findViewById(R.id.coinNowInfinityPlusButton);
        load_coin();
        coinNowButton.setText(String.valueOf(nowCoin));

        //6
        Button plus6Button = (Button)findViewById(R.id.InfinityPlus6);
        plus6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                long seed = System.currentTimeMillis();
                Random random = new Random(seed);
                int rand = random.nextInt(5)+1;

                Intent intent = new Intent(getApplicationContext(),InfinityChallenge_Plus_6.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Answer_state",0);
                intent.putExtra("Init_num",rand);
                intent.putExtra("Now_time",61000);
                startActivity(intent);

            }
        });

        //7
        Button plus7Button = (Button)findViewById(R.id.InfinityPlus7);
        plus7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);


                if(lock7 == 1){
                    long seed = System.currentTimeMillis();
                    Random random = new Random(seed);
                    int rand = random.nextInt(5)+1;

                    /*
                    Intent intent = new Intent(getApplicationContext(),InfinityChallenge_Plus_6.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Answer_state",0);
                    intent.putExtra("Init_num",rand);
                    intent.putExtra("Now_time",61000);
                    startActivity(intent);
                    */
                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(InfinityPlusMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("3000 Coin을 소모하여 '+7' 잠금 해제를 하시겠습니까?");

                    //EditText editText = new EditText(InfinityPlusMenu.this);

                   // alertBuilder.setView(editText);

                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    alertBuilder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    alertBuilder.show();
                }
            }
        });

    }

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

    private void load_coin(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM Coin";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                nowCoin = cursor.getInt(0);
            }
        }
    }

    private void UpdateCoin(){
        if(sqLiteDatabase != null){
            nowCoin -= nowUpDateCoin;
            String sqlUpdateCoin = "UPDATE Coin SET coin=" + nowCoin;
            sqLiteDatabase.execSQL(sqlUpdateCoin);
        }
    }

    private void load_lock7(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiP7";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                lock7 = cursor.getInt(0);
            }
        }
    }

    private void load_lock8(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiP8";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                lock8 = cursor.getInt(0);
            }
        }
    }

    private void load_lock13(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiP13";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                lock13 = cursor.getInt(0);
            }
        }
    }

    private void load_lock16(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiP16";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                lock16 = cursor.getInt(0);
            }
        }
    }

    private void load_lock17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiP17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                lock17 = cursor.getInt(0);
            }
        }
    }

    private void load_lock6_9(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiPR6_9";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                lock6_9 = cursor.getInt(0);
            }
        }
    }

    private void load_lock13_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiPR13_17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                lock13_17 = cursor.getInt(0);
            }
        }
    }

    private void load_lock6_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiPR6_17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                lock6_17 = cursor.getInt(0);
            }
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
