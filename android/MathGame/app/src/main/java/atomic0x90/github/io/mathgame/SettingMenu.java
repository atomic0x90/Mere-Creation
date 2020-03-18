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
import android.widget.Toast;

import java.io.File;

public class SettingMenu extends AppCompatActivity {
    Toast toast;

    //Coin
    int nowCoin = 0;
    int nowUpDateCoin = 0;

    //Sound
    SoundPool soundPool;
    int soundID;

    //DB
    SQLiteDatabase sqLiteDatabase;

    //Double click check
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_menu);

        //DB
        sqLiteDatabase = init_database();

        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound01,1);

        //Coin
        Button coinNowButton = (Button)findViewById(R.id.coinNowButtonSet);
        load_coin();
        coinNowButton.setText(String.valueOf(nowCoin));

        //Add
        Button addinitButton = (Button)findViewById(R.id.addInitTable);
        addinitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '더하기 도전' 통계를 초기화 하시겠습니까?");



                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            addInitTable();
                            addCreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Sub
        Button subinitButton = (Button)findViewById(R.id.subInitTable);
        subinitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '빼기 도전' 통계를 초기화 하시겠습니까?");



                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            subInitTable();
                            subCreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //mul
        Button mulinitButton = (Button)findViewById(R.id.mulInitTable);
        mulinitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '곱하기 도전' 통계를 초기화 하시겠습니까?");



                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            mulInitTable();
                            mulCreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //div
        Button divinitButton = (Button)findViewById(R.id.divInitTable);
        divinitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '나누기 도전' 통계를 초기화 하시겠습니까?");



                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            divInitTable();
                            divCreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Plus 6
        Button infiP6initButton = (Button)findViewById(R.id.infiP6InitTable);
        infiP6initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 +6' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiP6InitTable();
                            InfiP6CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Plus 7
        Button infiP7initButton = (Button)findViewById(R.id.infiP7InitTable);
        infiP7initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 +7' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiP7InitTable();
                            InfiP7CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Plus 8
        Button infiP8initButton = (Button)findViewById(R.id.infiP8InitTable);
        infiP8initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 +8' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiP8InitTable();
                            InfiP8CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Plus 13
        Button infiP13initButton = (Button)findViewById(R.id.infiP13InitTable);
        infiP13initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 +13' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiP13InitTable();
                            InfiP13CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Plus 16
        Button infiP16initButton = (Button)findViewById(R.id.infiP16InitTable);
        infiP16initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 +16' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiP16InitTable();
                            InfiP16CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Plus 17
        Button infiP17initButton = (Button)findViewById(R.id.infiP17InitTable);
        infiP17initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 +17' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiP17InitTable();
                            InfiP17CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Plus 6_9
        Button infiP6_9initButton = (Button)findViewById(R.id.infiP6_9InitTable);
        infiP6_9initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 +6~9' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiP6_9InitTable();
                            InfiP6_9CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Plus 13_17
        Button infiP13_17initButton = (Button)findViewById(R.id.infiP13_17InitTable);
        infiP13_17initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 +13~17' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiP13_17InitTable();
                            InfiP13_17CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Plus 6_17
        Button infiP6_17initButton = (Button)findViewById(R.id.infiP6_17InitTable);
        infiP6_17initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 +6~17' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiP6_17InitTable();
                            InfiP6_17CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Minus 6
        Button infiM6initButton = (Button)findViewById(R.id.infiM6InitTable);
        infiM6initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 -6' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiM6InitTable();
                            InfiM6CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Minus 7
        Button infiM7initButton = (Button)findViewById(R.id.infiM7InitTable);
        infiM7initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 -7' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiM7InitTable();
                            InfiM7CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Minus 8
        Button infiM8initButton = (Button)findViewById(R.id.infiM8InitTable);
        infiM8initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 -8' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiM8InitTable();
                            InfiM8CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Minus 13
        Button infiM13initButton = (Button)findViewById(R.id.infiM13InitTable);
        infiM13initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 -13' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiM13InitTable();
                            InfiM13CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Minus 16
        Button infiM16initButton = (Button)findViewById(R.id.infiM16InitTable);
        infiM16initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 -16' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiM16InitTable();
                            InfiM16CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Minus 17
        Button infiM17initButton = (Button)findViewById(R.id.infiM17InitTable);
        infiM17initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 -17' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiM17InitTable();
                            InfiM17CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Minus 6_9
        Button infiM6_9initButton = (Button)findViewById(R.id.infiM6_9InitTable);
        infiM6_9initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 -6~9' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiM6_9InitTable();
                            InfiM6_9CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Minus 13_17
        Button infiM13_17initButton = (Button)findViewById(R.id.infiM13_17InitTable);
        infiM13_17initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 -13~17' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiM13_17InitTable();
                            InfiM13_17CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //Infi Minus 6_17
        Button infiM6_17initButton = (Button)findViewById(R.id.infiM6_17InitTable);
        infiM6_17initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '1분 무한 -6~17' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            InfiM6_17InitTable();
                            InfiM6_17CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //MaxMin 1_10
        Button mm1_10Button = (Button)findViewById(R.id.mm1_10InitTable);
        mm1_10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '최대 최소 1~10' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            MaxMin1_10InitTable();
                            MaxMin1_10CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //MaxMin 10_20
        Button mm10_20Button = (Button)findViewById(R.id.mm10_20InitTable);
        mm10_20Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '최대 최소 10~20' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            MaxMin10_20InitTable();
                            MaxMin10_20CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
            }
        });

        //MaxMin 20_30
        Button mm20_30Button = (Button)findViewById(R.id.mm20_30InitTable);
        mm20_30Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SettingMenu.this);
                alertBuilder.setIcon(R.drawable.math_game_logo_black);
                alertBuilder.setTitle("초기화 확인 알림 창");
                alertBuilder.setMessage("1500 Coin을 소모하여 '최대 최소 20~30' 통계를 초기화 하시겠습니까?");

                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(nowCoin >= 1500){
                            nowUpDateCoin = 1500;
                            UpdateCoin();

                            MaxMin20_30InitTable();
                            MaxMin20_30CreateTable();

                            toast = Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(),SettingMenu.class);
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
                        toast = Toast.makeText(getApplicationContext(),"초기화 취소",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                alertBuilder.show();
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

    //Add
    private void addInitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS ChAdd";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void addCreateTable(){
        if(sqLiteDatabase != null){
            //Add table
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS ChAdd (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "AVtime " + "REAL NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Minus
    private void subInitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS ChSub";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void subCreateTable(){
        if(sqLiteDatabase != null){
            //Add table
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS ChSub (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "AVtime " + "REAL NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Multiplication
    private void mulInitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS ChMul";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void mulCreateTable(){
        if(sqLiteDatabase != null){
            //Add table
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS ChMul (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "AVtime " + "REAL NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Divide
    private void divInitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS ChDiv";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void divCreateTable(){
        if(sqLiteDatabase != null){
            //Add table
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS ChDiv (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "AVtime " + "REAL NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Plus 6 table
    private void InfiP6InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChP6";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiP6CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP6 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Plus 7
    private void InfiP7InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChP7";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiP7CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP7 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Plus 8
    private void InfiP8InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChP8";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiP8CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP8 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Plus 13
    private void InfiP13InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChP13";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiP13CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP13 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Plus 16
    private void InfiP16InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChP16";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiP16CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP16 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Plus 17
    private void InfiP17InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChP17";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiP17CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChP17 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Plus 6_9
    private void InfiP6_9InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChPR6_9";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiP6_9CreateTable() {
        String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChPR6_9 (" +
                "IDX " + "INTEGER PRIMARY KEY," +
                "result " + "INTEGER NOT NULL," +
                "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

        sqLiteDatabase.execSQL(sqlCreateTbl);
    }

    //Infinity Plus 13_17
    private void InfiP13_17InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChPR13_17";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiP13_17CreateTable() {
        String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChPR13_17 (" +
                "IDX " + "INTEGER PRIMARY KEY," +
                "result " + "INTEGER NOT NULL," +
                "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

        sqLiteDatabase.execSQL(sqlCreateTbl);
    }

    //Infinity Plus 6_17
    private void InfiP6_17InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChPR6_17";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiP6_17CreateTable() {
        String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChPR6_17 (" +
                "IDX " + "INTEGER PRIMARY KEY," +
                "result " + "INTEGER NOT NULL," +
                "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

        sqLiteDatabase.execSQL(sqlCreateTbl);
    }

    //Infinity Minus 6
    private void InfiM6InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChM6";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiM6CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM6 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Minus 7
    private void InfiM7InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChM7";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiM7CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM7 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Minus 8
    private void InfiM8InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChM8";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiM8CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM8 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Minus 13
    private void InfiM13InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChM13";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiM13CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM13 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Minus 16
    private void InfiM16InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChM16";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiM16CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM16 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Minus 17
    private void InfiM17InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChM17";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiM17CreateTable() {
        if(sqLiteDatabase != null){
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChM17 (" +
                    "IDX " + "INTEGER PRIMARY KEY," +
                    "result " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

            sqLiteDatabase.execSQL(sqlCreateTbl);
        }
    }

    //Infinity Minus 6_9
    private void InfiM6_9InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChMR6_9";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiM6_9CreateTable() {
        String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChMR6_9 (" +
                "IDX " + "INTEGER PRIMARY KEY," +
                "result " + "INTEGER NOT NULL," +
                "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

        sqLiteDatabase.execSQL(sqlCreateTbl);
    }

    //Infinity Minus 13_17
    private void InfiM13_17InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChMR13_17";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiM13_17CreateTable() {
        String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChMR13_17 (" +
                "IDX " + "INTEGER PRIMARY KEY," +
                "result " + "INTEGER NOT NULL," +
                "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

        sqLiteDatabase.execSQL(sqlCreateTbl);
    }

    //Infinity Minus 6_17
    private void InfiM6_17InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS InfiChMR6_17";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void InfiM6_17CreateTable() {
        String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS InfiChMR6_17 (" +
                "IDX " + "INTEGER PRIMARY KEY," +
                "result " + "INTEGER NOT NULL," +
                "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

        sqLiteDatabase.execSQL(sqlCreateTbl);
    }

    //MaxMin 1_10
    private void MaxMin1_10InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS MaxMin1_10";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void MaxMin1_10CreateTable() {
        String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS MaxMin1_10 (" +
                "IDX " + "INTEGER PRIMARY KEY," +
                "result " + "INTEGER NOT NULL," +
                "AVtime " + "REAL NOT NULL," +
                "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

        sqLiteDatabase.execSQL(sqlCreateTbl);
    }

    //MaxMin 10_20
    private void MaxMin10_20InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS MaxMin10_20";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void MaxMin10_20CreateTable() {
        String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS MaxMin10_20 (" +
                "IDX " + "INTEGER PRIMARY KEY," +
                "result " + "INTEGER NOT NULL," +
                "AVtime " + "REAL NOT NULL," +
                "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

        sqLiteDatabase.execSQL(sqlCreateTbl);
    }

    //MaxMin 20_30
    private void MaxMin20_30InitTable(){
        if(sqLiteDatabase != null){
            String sqlDropTbl = "DROP TABLE IF EXISTS MaxMin20_30";

            sqLiteDatabase.execSQL(sqlDropTbl);
        }
    }

    private void MaxMin20_30CreateTable() {
        String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS MaxMin20_30 (" +
                "IDX " + "INTEGER PRIMARY KEY," +
                "result " + "INTEGER NOT NULL," +
                "AVtime " + "REAL NOT NULL," +
                "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";

        sqLiteDatabase.execSQL(sqlCreateTbl);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
