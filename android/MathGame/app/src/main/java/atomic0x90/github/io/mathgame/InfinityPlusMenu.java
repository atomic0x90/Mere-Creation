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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;
import java.util.Random;

public class InfinityPlusMenu extends AppCompatActivity {

    //Coin
    int nowCoin = 0;

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

    //intent


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinity_plus_menu);

        //DB
        sqLiteDatabase = init_database();

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

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
