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
import java.util.Random;

public class InfinityPlusMenu extends AppCompatActivity {

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

        //lock check text
        TextView textView7 = (TextView) findViewById(R.id.InfinityPlus7coinText);
        TextView textView8 = (TextView) findViewById(R.id.InfinityPlus8coinText);
        TextView textView13 = (TextView) findViewById(R.id.InfinityPlus13coinText);
        TextView textView16 = (TextView) findViewById(R.id.InfinityPlus16coinText);
        TextView textView17 = (TextView) findViewById(R.id.InfinityPlus17coinText);
        TextView textView6_9 = (TextView) findViewById(R.id.InfinityPlus6_9coinText);
        TextView textView13_17 = (TextView) findViewById(R.id.InfinityPlus13_17coinText);
        TextView textView6_17 = (TextView) findViewById(R.id.InfinityPlus6_17coinText);

        if(lock7 == 1)
            textView7.setText("");
        if(lock8 == 1)
            textView8.setText("");
        if(lock13 == 1)
            textView13.setText("");
        if(lock16 == 1)
            textView16.setText("");
        if(lock17 == 1)
            textView17.setText("");
        if(lock6_9 == 1)
            textView6_9.setText("");
        if(lock13_17 == 1)
            textView13_17.setText("");
        if(lock6_17 == 1)
            textView6_17.setText("");

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

                Intent intent = new Intent(getApplicationContext(),InfinityChallenge_Plus.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Answer_state",0);
                intent.putExtra("Init_num",rand);
                intent.putExtra("Now_time",61000);
                intent.putExtra("Type","Plus6");
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

                    Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Answer_state",0);
                    intent.putExtra("Init_num",rand);
                    intent.putExtra("Now_time",61000);
                    intent.putExtra("Type","Plus7");
                    startActivity(intent);

                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(InfinityPlusMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("3000 Coin을 소모하여 '+7' 잠금 해제를 하시겠습니까?");



                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(nowCoin >= 3000){
                                nowUpDateCoin = 3000;
                                UpdateCoin();
                                Update_lock7();

                                toast = Toast.makeText(getApplicationContext(),"잠금 해제 완료",Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(),InfinityPlusMenu.class);
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

        //8
        Button plus8Button = (Button)findViewById(R.id.InfinityPlus8);
        plus8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);


                if(lock8 == 1){
                    long seed = System.currentTimeMillis();
                    Random random = new Random(seed);
                    int rand = random.nextInt(6)+1;


                    Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Type","Plus8");
                    intent.putExtra("Answer_state",0);
                    intent.putExtra("Init_num",rand);
                    intent.putExtra("Now_time",61000);
                    startActivity(intent);

                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(InfinityPlusMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("3000 Coin을 소모하여 '+8' 잠금 해제를 하시겠습니까?");



                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(nowCoin >= 3000){
                                nowUpDateCoin = 3000;
                                UpdateCoin();
                                Update_lock8();

                                toast = Toast.makeText(getApplicationContext(),"잠금 해제 완료",Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(),InfinityPlusMenu.class);
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

        //13
        Button plus13Button = (Button) findViewById(R.id.InfinityPlus13);
        plus13Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);


                if(lock13 == 1){
                    long seed = System.currentTimeMillis();
                    Random random = new Random(seed);
                    int rand = random.nextInt(6)+1;


                    Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Type","Plus13");
                    intent.putExtra("Answer_state",0);
                    intent.putExtra("Init_num",rand);
                    intent.putExtra("Now_time",61000);
                    startActivity(intent);

                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(InfinityPlusMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("4000 Coin을 소모하여 '+13' 잠금 해제를 하시겠습니까?");



                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(nowCoin >= 4000){
                                nowUpDateCoin = 4000;
                                UpdateCoin();
                                Update_lock13();

                                toast = Toast.makeText(getApplicationContext(),"잠금 해제 완료",Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(),InfinityPlusMenu.class);
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

        //16
        Button plus16Button = (Button) findViewById(R.id.InfinityPlus16);
        plus16Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);


                if(lock16 == 1){
                    long seed = System.currentTimeMillis();
                    Random random = new Random(seed);
                    int rand = random.nextInt(6)+1;


                    Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Type","Plus16");
                    intent.putExtra("Answer_state",0);
                    intent.putExtra("Init_num",rand);
                    intent.putExtra("Now_time",61000);
                    startActivity(intent);

                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(InfinityPlusMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("4000 Coin을 소모하여 '+16' 잠금 해제를 하시겠습니까?");



                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(nowCoin >= 4000){
                                nowUpDateCoin = 4000;
                                UpdateCoin();
                                Update_lock16();

                                toast = Toast.makeText(getApplicationContext(),"잠금 해제 완료",Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(),InfinityPlusMenu.class);
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

        //17
        Button plus17Button = (Button) findViewById(R.id.InfinityPlus17);
        plus17Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);


                if(lock17 == 1){
                    long seed = System.currentTimeMillis();
                    Random random = new Random(seed);
                    int rand = random.nextInt(6)+1;


                    Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Type","Plus17");
                    intent.putExtra("Answer_state",0);
                    intent.putExtra("Init_num",rand);
                    intent.putExtra("Now_time",61000);
                    startActivity(intent);

                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(InfinityPlusMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("4000 Coin을 소모하여 '+17' 잠금 해제를 하시겠습니까?");



                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(nowCoin >= 4000){
                                nowUpDateCoin = 4000;
                                UpdateCoin();
                                Update_lock17();

                                toast = Toast.makeText(getApplicationContext(),"잠금 해제 완료",Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(),InfinityPlusMenu.class);
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


        //6_9
        Button plus6_9Button = (Button) findViewById(R.id.InfinityPlusRandom6_9);
        plus6_9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);


                if(lock6_9 == 1){
                    long seed = System.currentTimeMillis();
                    Random random = new Random(seed);
                    int rand = random.nextInt(6)+1;


                    Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Type","Plus6_9");
                    intent.putExtra("Answer_state",0);
                    intent.putExtra("Init_num",rand);
                    intent.putExtra("Now_time",61000);
                    startActivity(intent);

                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(InfinityPlusMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("5500 Coin을 소모하여 '+6~9' 잠금 해제를 하시겠습니까?");



                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(nowCoin >= 5500){
                                nowUpDateCoin = 5500;
                                UpdateCoin();
                                Update_lock6_9();

                                toast = Toast.makeText(getApplicationContext(),"잠금 해제 완료",Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(),InfinityPlusMenu.class);
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

        //13_17
        Button plus13_17Button = (Button) findViewById(R.id.InfinityPlusRandom13_17);
        plus13_17Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);


                if(lock13_17 == 1){
                    long seed = System.currentTimeMillis();
                    Random random = new Random(seed);
                    int rand = random.nextInt(6)+1;


                    Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Type","Plus13_17");
                    intent.putExtra("Answer_state",0);
                    intent.putExtra("Init_num",rand);
                    intent.putExtra("Now_time",61000);
                    startActivity(intent);

                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(InfinityPlusMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("5500 Coin을 소모하여 '+13~17' 잠금 해제를 하시겠습니까?");



                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(nowCoin >= 5500){
                                nowUpDateCoin = 5500;
                                UpdateCoin();
                                Update_lock13_17();

                                toast = Toast.makeText(getApplicationContext(),"잠금 해제 완료",Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(),InfinityPlusMenu.class);
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

        //6_17
        Button plus6_17Button = (Button) findViewById(R.id.InfinityPlusRandom6_17);
        plus6_17Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);


                if(lock6_17 == 1){
                    long seed = System.currentTimeMillis();
                    Random random = new Random(seed);
                    int rand = random.nextInt(6)+1;


                    Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Type","Plus6_17");
                    intent.putExtra("Answer_state",0);
                    intent.putExtra("Init_num",rand);
                    intent.putExtra("Now_time",61000);
                    startActivity(intent);

                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(InfinityPlusMenu.this);
                    alertBuilder.setIcon(R.drawable.math_game_logo_black);
                    alertBuilder.setTitle("잠겨있음");
                    alertBuilder.setMessage("5500 Coin을 소모하여 '+6~17' 잠금 해제를 하시겠습니까?");



                    alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(nowCoin >= 5500){
                                nowUpDateCoin = 5500;
                                UpdateCoin();
                                Update_lock6_17();

                                toast = Toast.makeText(getApplicationContext(),"잠금 해제 완료",Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(),InfinityPlusMenu.class);
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

    private void Update_lock7(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE InfiP7 SET lock=" + 1;
            sqLiteDatabase.execSQL(sqlQuery);
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

    private void Update_lock8(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE InfiP8 SET lock=" + 1;
            sqLiteDatabase.execSQL(sqlQuery);
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

    private void Update_lock13(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE InfiP13 SET lock=" + 1;
            sqLiteDatabase.execSQL(sqlQuery);
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

    private void Update_lock16(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE InfiP16 SET lock=" + 1;
            sqLiteDatabase.execSQL(sqlQuery);
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

    private void Update_lock17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE InfiP17 SET lock=" + 1;
            sqLiteDatabase.execSQL(sqlQuery);
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

    private void Update_lock6_9(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE InfiPR6_9 SET lock=" + 1;
            sqLiteDatabase.execSQL(sqlQuery);
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

    private void Update_lock13_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE InfiPR13_17 SET lock=" + 1;
            sqLiteDatabase.execSQL(sqlQuery);
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

    private void Update_lock6_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE InfiPR6_17 SET lock=" + 1;
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
