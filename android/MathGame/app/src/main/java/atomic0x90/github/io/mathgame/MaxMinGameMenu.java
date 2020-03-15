package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_min_game_menu);

        //DB
        sqLiteDatabase = init_database();

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

                Intent intent = new Intent(getApplicationContext(),MaxMinGame.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Number_of_time",0);
                intent.putExtra("Answer_state",stateArr);
                intent.putExtra("Average_time",0);
                intent.putExtra("Result_type","MaxMin10_20");

                startActivity(intent);
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

                Intent intent = new Intent(getApplicationContext(),MaxMinGame.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Number_of_time",0);
                intent.putExtra("Answer_state",stateArr);
                intent.putExtra("Average_time",0);
                intent.putExtra("Result_type","MaxMin20_30");

                startActivity(intent);
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


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
