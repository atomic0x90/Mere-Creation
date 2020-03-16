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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;

public class MaxMinGameMenu extends AppCompatActivity {
    Toast toast;

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

    //Double click check
    private long mLastClickTime = 0;


    //lock check: lock == 0 -> lock, lock == 1 -> unlock
    int lock10_20 = 0;
    int lock20_30 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_min_game_menu);

        //DB
        sqLiteDatabase = init_database();
        load_lock10_20();
        load_lock20_30();

        //lock check text
        TextView textView10_20 = (TextView)findViewById(R.id.MaxMin10_20coinText);
        TextView textView20_30 = (TextView)findViewById(R.id.MaxMin20_30coinText);

        if(lock10_20 == 1)
            textView10_20.setText("");
        if(lock20_30 == 1)
            textView20_30.setText("");

        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound01,1);


        //AD
        mAdView = findViewById(R.id.adView6);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Coin
        Button coinNowButton = (Button)findViewById(R.id.coinNowMaxMinButton);
        load_coin();
        coinNowButton.setText(String.valueOf(nowCoin));

        final int[] stateArr = {0,0,0,0,0};

        //1_10
        Button button1_10 = (Button)findViewById(R.id.MaxMin1_10);
        button1_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(getApplicationContext(),MaxMinGame.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Number_of_time",0);
                intent.putExtra("Answer_state",stateArr);
                intent.putExtra("Average_time",0);
                intent.putExtra("Result_type","MaxMin1_10");

                startActivity(intent);
            }
        });

        //10_20 TEST
        Button button10_20 = (Button)findViewById(R.id.MaxMin10_20);
        button10_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                if(lock10_20 == 1){
                    Intent intent = new Intent(getApplicationContext(),MaxMinGame.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Number_of_time",0);
                    intent.putExtra("Answer_state",stateArr);
                    intent.putExtra("Average_time",0);
                    intent.putExtra("Result_type","MaxMin10_20");

                    startActivity(intent);
                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MaxMinGameMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("3000 Coin을 소모하여 '10 ~ 20' 잠금 해제를 하시겠습니까?");



                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(nowCoin >= 3000){
                                nowUpDateCoin = 3000;
                                UpdateCoin();
                                Update_lock10_20();

                                toast = Toast.makeText(getApplicationContext(),"잠금 해제 완료",Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(),MaxMinGameMenu.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                overridePendingTransition(0, 0);
                            }
                            else{
                                toast = Toast.makeText(getApplicationContext(),"Coin이 부족합니다.",Toast.LENGTH_SHORT);
                                toast.show();
                            }

                        }
                    });

                    alertBuilder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            toast = Toast.makeText(getApplicationContext(),"잠금 해제 취소",Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });

                    alertBuilder.show();
                }
            }
        });

        //20_30 TEST
        Button button20_30 = (Button)findViewById(R.id.MaxMin20_30);
        button20_30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                if(lock20_30 == 1) {
                    Intent intent = new Intent(getApplicationContext(), MaxMinGame.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Number_of_time", 0);
                    intent.putExtra("Answer_state", stateArr);
                    intent.putExtra("Average_time", 0);
                    intent.putExtra("Result_type", "MaxMin20_30");

                    startActivity(intent);
                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MaxMinGameMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("3000 Coin을 소모하여 '20 ~ 30' 잠금 해제를 하시겠습니까?");



                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(nowCoin >= 3000){
                                nowUpDateCoin = 3000;
                                UpdateCoin();
                                Update_lock20_30();

                                toast = Toast.makeText(getApplicationContext(),"잠금 해제 완료",Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(),MaxMinGameMenu.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                overridePendingTransition(0, 0);
                            }
                            else{
                                toast = Toast.makeText(getApplicationContext(),"Coin이 부족합니다.",Toast.LENGTH_SHORT);
                                toast.show();
                            }

                        }
                    });

                    alertBuilder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            toast = Toast.makeText(getApplicationContext(),"잠금 해제 취소",Toast.LENGTH_SHORT);
                            toast.show();
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

    private void load_lock10_20(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM MaxMinLock10_20";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                lock10_20 = cursor.getInt(0);
            }
        }
    }

    private void Update_lock10_20(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE MaxMinLock10_20 SET lock=" + 1;
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void load_lock20_30(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM MaxMinLock20_30";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                lock20_30 = cursor.getInt(0);
            }
        }
    }

    private void Update_lock20_30(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE MaxMinLock20_30 SET lock=" + 1;
            sqLiteDatabase.execSQL(sqlQuery);
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
