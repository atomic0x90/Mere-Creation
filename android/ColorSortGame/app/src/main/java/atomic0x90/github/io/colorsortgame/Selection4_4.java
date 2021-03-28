package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.File;

public class Selection4_4 extends AppCompatActivity {

    int standardSize_X, standardSize_Y;
    float density;

    SQLiteDatabase sqliteDB;

    int lock1 = -1;
    int lock2 = -1;
    int lock3 = -1;
    int lock4 = -1;
    int lock5 = -1;
    int lock6 = -1;
    int lock7 = -1;
    int lock8 = -1;
    int lock9 = -1;
    int lock10 = -1;
    int lock11 = -1;
    int lock12 = -1;
    int lock13 = -1;
    int lock14 = -1;
    int lock15 = -1;
    int lock16 = -1;
    int lock17 = -1;
    int lock18 = -1;
    int lock19 = -1;
    int lock20 = -1;
    int lock21 = -1;
    int lock22 = -1;
    int lock23 = -1;
    int lock24 = -1;
    int lock25 = -1;
    int lock26 = -1;
    int lock27 = -1;
    int lock28 = -1;
    int lock29 = -1;
    int lock30 = -1;
    int lock31 = -1;
    int lock32 = -1;
    int lock33 = -1;
    int lock34 = -1;
    int lock35 = -1;
    int lock36 = -1;
    int lock37 = -1;
    int lock38 = -1;
    int lock39 = -1;
    int lock40 = -1;
    int lock41 = -1;
    int lock42 = -1;
    int lock43 = -1;
    int lock44 = -1;
    int lock45 = -1;
    int lock46 = -1;
    int lock47 = -1;
    int lock48 = -1;
    int lock49 = -1;
    int lock50 = -1;

    public Point getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size;
    }

    public void getStandardSize() {
        Point ScreenSize = getScreenSize(this);
        density = getResources().getDisplayMetrics().density;

        standardSize_X = (int) (ScreenSize.x / density);
        standardSize_Y = (int) (ScreenSize.y / density);
    }
    @Override
    protected void onStart(){
        super.onStart();

        final Button button1 = (Button) findViewById(R.id.selection4_4_1);
        button1.setEnabled(false);
        class startHandler implements Runnable{
            public void run(){
                button1.setEnabled(true);
            }
        }

        Handler h = new Handler();
        h.postDelayed(new startHandler(),250);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection4_4);

        sqliteDB = init_database();
        loadGameLock1();
        loadGameLock2();
        loadGameLock3();
        loadGameLock4();
        loadGameLock5();
        loadGameLock6();
        loadGameLock7();
        loadGameLock8();
        loadGameLock9();
        loadGameLock10();
        loadGameLock11();
        loadGameLock12();
        loadGameLock13();
        loadGameLock14();
        loadGameLock15();
        loadGameLock16();
        loadGameLock17();
        loadGameLock18();
        loadGameLock19();
        loadGameLock20();
        loadGameLock21();
        loadGameLock22();
        loadGameLock23();
        loadGameLock24();
        loadGameLock25();
        loadGameLock26();
        loadGameLock27();
        loadGameLock28();
        loadGameLock29();
        loadGameLock30();
        loadGameLock31();
        loadGameLock32();
        loadGameLock33();
        loadGameLock34();
        loadGameLock35();
        loadGameLock36();
        loadGameLock37();
        loadGameLock38();
        loadGameLock39();
        loadGameLock40();
        loadGameLock41();
        loadGameLock42();
        loadGameLock43();
        loadGameLock44();
        loadGameLock45();
        loadGameLock46();
        loadGameLock47();
        loadGameLock48();
        loadGameLock49();
        loadGameLock50();

        getStandardSize();

        ScrollView scrollView = (ScrollView) findViewById(R.id.selection4_4ScrollView);

        scrollView.setX(0);
        scrollView.setY(0);
        scrollView.setMinimumWidth(standardSize_X);
        scrollView.setMinimumHeight(standardSize_Y);

        Button button1 = (Button) findViewById(R.id.selection4_4_1);
        Button button2 = (Button) findViewById(R.id.selection4_4_2);
        Button button3 = (Button) findViewById(R.id.selection4_4_3);
        Button button4 = (Button) findViewById(R.id.selection4_4_4);
        Button button5 = (Button) findViewById(R.id.selection4_4_5);
        Button button6 = (Button) findViewById(R.id.selection4_4_6);
        Button button7 = (Button) findViewById(R.id.selection4_4_7);
        Button button8 = (Button) findViewById(R.id.selection4_4_8);
        Button button9 = (Button) findViewById(R.id.selection4_4_9);
        Button button10 = (Button) findViewById(R.id.selection4_4_10);
        Button button11 = (Button) findViewById(R.id.selection4_4_11);
        Button button12 = (Button) findViewById(R.id.selection4_4_12);
        Button button13 = (Button) findViewById(R.id.selection4_4_13);
        Button button14 = (Button) findViewById(R.id.selection4_4_14);
        Button button15 = (Button) findViewById(R.id.selection4_4_15);
        Button button16 = (Button) findViewById(R.id.selection4_4_16);
        Button button17 = (Button) findViewById(R.id.selection4_4_17);
        Button button18 = (Button) findViewById(R.id.selection4_4_18);
        Button button19 = (Button) findViewById(R.id.selection4_4_19);
        Button button20 = (Button) findViewById(R.id.selection4_4_20);
        Button button21 = (Button) findViewById(R.id.selection4_4_21);
        Button button22 = (Button) findViewById(R.id.selection4_4_22);
        Button button23 = (Button) findViewById(R.id.selection4_4_23);
        Button button24 = (Button) findViewById(R.id.selection4_4_24);
        Button button25 = (Button) findViewById(R.id.selection4_4_25);
        Button button26 = (Button) findViewById(R.id.selection4_4_26);
        Button button27 = (Button) findViewById(R.id.selection4_4_27);
        Button button28 = (Button) findViewById(R.id.selection4_4_28);
        Button button29 = (Button) findViewById(R.id.selection4_4_29);
        Button button30 = (Button) findViewById(R.id.selection4_4_30);
        Button button31 = (Button) findViewById(R.id.selection4_4_31);
        Button button32 = (Button) findViewById(R.id.selection4_4_32);
        Button button33 = (Button) findViewById(R.id.selection4_4_33);
        Button button34 = (Button) findViewById(R.id.selection4_4_34);
        Button button35 = (Button) findViewById(R.id.selection4_4_35);
        Button button36 = (Button) findViewById(R.id.selection4_4_36);
        Button button37 = (Button) findViewById(R.id.selection4_4_37);
        Button button38 = (Button) findViewById(R.id.selection4_4_38);
        Button button39 = (Button) findViewById(R.id.selection4_4_39);
        Button button40 = (Button) findViewById(R.id.selection4_4_40);
        Button button41 = (Button) findViewById(R.id.selection4_4_41);
        Button button42 = (Button) findViewById(R.id.selection4_4_42);
        Button button43 = (Button) findViewById(R.id.selection4_4_43);
        Button button44 = (Button) findViewById(R.id.selection4_4_44);
        Button button45 = (Button) findViewById(R.id.selection4_4_45);
        Button button46 = (Button) findViewById(R.id.selection4_4_46);
        Button button47 = (Button) findViewById(R.id.selection4_4_47);
        Button button48 = (Button) findViewById(R.id.selection4_4_48);
        Button button49 = (Button) findViewById(R.id.selection4_4_49);
        Button button50 = (Button) findViewById(R.id.selection4_4_50);

        button1.setWidth(standardSize_X/4);
        button2.setWidth(standardSize_X/4);
        button3.setWidth(standardSize_X/4);
        button4.setWidth(standardSize_X/4);
        button5.setWidth(standardSize_X/4);
        button6.setWidth(standardSize_X/4);
        button7.setWidth(standardSize_X/4);
        button8.setWidth(standardSize_X/4);
        button9.setWidth(standardSize_X/4);
        button10.setWidth(standardSize_X/4);
        button11.setWidth(standardSize_X/4);
        button12.setWidth(standardSize_X/4);
        button13.setWidth(standardSize_X/4);
        button14.setWidth(standardSize_X/4);
        button15.setWidth(standardSize_X/4);
        button16.setWidth(standardSize_X/4);
        button17.setWidth(standardSize_X/4);
        button18.setWidth(standardSize_X/4);
        button19.setWidth(standardSize_X/4);
        button20.setWidth(standardSize_X/4);
        button21.setWidth(standardSize_X/4);
        button22.setWidth(standardSize_X/4);
        button23.setWidth(standardSize_X/4);
        button24.setWidth(standardSize_X/4);
        button25.setWidth(standardSize_X/4);
        button26.setWidth(standardSize_X/4);
        button27.setWidth(standardSize_X/4);
        button28.setWidth(standardSize_X/4);
        button29.setWidth(standardSize_X/4);
        button30.setWidth(standardSize_X/4);
        button31.setWidth(standardSize_X/4);
        button32.setWidth(standardSize_X/4);
        button33.setWidth(standardSize_X/4);
        button34.setWidth(standardSize_X/4);
        button35.setWidth(standardSize_X/4);
        button36.setWidth(standardSize_X/4);
        button37.setWidth(standardSize_X/4);
        button38.setWidth(standardSize_X/4);
        button39.setWidth(standardSize_X/4);
        button40.setWidth(standardSize_X/4);
        button41.setWidth(standardSize_X/4);
        button42.setWidth(standardSize_X/4);
        button43.setWidth(standardSize_X/4);
        button44.setWidth(standardSize_X/4);
        button45.setWidth(standardSize_X/4);
        button46.setWidth(standardSize_X/4);
        button47.setWidth(standardSize_X/4);
        button48.setWidth(standardSize_X/4);
        button49.setWidth(standardSize_X/4);
        button50.setWidth(standardSize_X/4);

        button1.setHeight(standardSize_X/4);
        button2.setHeight(standardSize_X/4);
        button3.setHeight(standardSize_X/4);
        button4.setHeight(standardSize_X/4);
        button5.setHeight(standardSize_X/4);
        button6.setHeight(standardSize_X/4);
        button7.setHeight(standardSize_X/4);
        button8.setHeight(standardSize_X/4);
        button9.setHeight(standardSize_X/4);
        button10.setHeight(standardSize_X/4);
        button11.setHeight(standardSize_X/4);
        button12.setHeight(standardSize_X/4);
        button13.setHeight(standardSize_X/4);
        button14.setHeight(standardSize_X/4);
        button15.setHeight(standardSize_X/4);
        button16.setHeight(standardSize_X/4);
        button17.setHeight(standardSize_X/4);
        button18.setHeight(standardSize_X/4);
        button19.setHeight(standardSize_X/4);
        button20.setHeight(standardSize_X/4);
        button21.setHeight(standardSize_X/4);
        button22.setHeight(standardSize_X/4);
        button23.setHeight(standardSize_X/4);
        button24.setHeight(standardSize_X/4);
        button25.setHeight(standardSize_X/4);
        button26.setHeight(standardSize_X/4);
        button27.setHeight(standardSize_X/4);
        button28.setHeight(standardSize_X/4);
        button29.setHeight(standardSize_X/4);
        button30.setHeight(standardSize_X/4);
        button31.setHeight(standardSize_X/4);
        button32.setHeight(standardSize_X/4);
        button33.setHeight(standardSize_X/4);
        button34.setHeight(standardSize_X/4);
        button35.setHeight(standardSize_X/4);
        button36.setHeight(standardSize_X/4);
        button37.setHeight(standardSize_X/4);
        button38.setHeight(standardSize_X/4);
        button39.setHeight(standardSize_X/4);
        button40.setHeight(standardSize_X/4);
        button41.setHeight(standardSize_X/4);
        button42.setHeight(standardSize_X/4);
        button43.setHeight(standardSize_X/4);
        button44.setHeight(standardSize_X/4);
        button45.setHeight(standardSize_X/4);
        button46.setHeight(standardSize_X/4);
        button47.setHeight(standardSize_X/4);
        button48.setHeight(standardSize_X/4);
        button49.setHeight(standardSize_X/4);
        button50.setHeight(standardSize_X/4);

        System.out.println("sssssssssssssssss : " + lock1 + " " + lock2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock1 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",1);
                    startActivity(intent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock2 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock2 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",2);
                    startActivity(intent);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock3 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock3 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",3);
                    startActivity(intent);
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock4 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock4 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",4);
                    startActivity(intent);
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock5 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock5 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",5);
                    startActivity(intent);
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock6 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock6 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",6);
                    startActivity(intent);
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock7 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock7 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",7);
                    startActivity(intent);
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock8 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock8 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",8);
                    startActivity(intent);
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock9 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock9 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",9);
                    startActivity(intent);
                }
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock10 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock10 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",10);
                    startActivity(intent);
                }
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock11 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock11 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",11);
                    startActivity(intent);
                }
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock12 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock12 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",12);
                    startActivity(intent);
                }
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock13 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock13 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",13);
                    startActivity(intent);
                }
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock14 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock14 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",14);
                    startActivity(intent);
                }
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock15 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock15 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",15);
                    startActivity(intent);
                }
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock16 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock16 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",16);
                    startActivity(intent);
                }
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock17 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock17 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",17);
                    startActivity(intent);
                }
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock18 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock18 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",18);
                    startActivity(intent);
                }
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock19 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock19 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",19);
                    startActivity(intent);
                }
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock20 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock20 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",20);
                    startActivity(intent);
                }
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock21 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock21 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",21);
                    startActivity(intent);
                }
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock22 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock22 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",22);
                    startActivity(intent);
                }
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock23 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock23 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",23);
                    startActivity(intent);
                }
            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock24 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock24 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",24);
                    startActivity(intent);
                }
            }
        });
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock25 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock25 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",25);
                    startActivity(intent);
                }
            }
        });
        button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock26 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock26 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",26);
                    startActivity(intent);
                }
            }
        });
        button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock27 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock27 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",27);
                    startActivity(intent);
                }
            }
        });
        button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock28 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock28 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",28);
                    startActivity(intent);
                }
            }
        });
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock29 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock29 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",29);
                    startActivity(intent);
                }
            }
        });
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock30 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock30 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",30);
                    startActivity(intent);
                }
            }
        });
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock31 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock31 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",31);
                    startActivity(intent);
                }
            }
        });
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock32 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock32 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",32);
                    startActivity(intent);
                }
            }
        });
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock33 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock33 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",33);
                    startActivity(intent);
                }
            }
        });
        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock34 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock34 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",34);
                    startActivity(intent);
                }
            }
        });
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock35 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock35 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",35);
                    startActivity(intent);
                }
            }
        });
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock36 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock36 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",36);
                    startActivity(intent);
                }
            }
        });
        button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock37 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock37 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",37);
                    startActivity(intent);
                }
            }
        });
        button38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock38 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock38 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",38);
                    startActivity(intent);
                }
            }
        });
        button39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock39 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock39 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",39);
                    startActivity(intent);
                }
            }
        });
        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock40 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock40 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",40);
                    startActivity(intent);
                }
            }
        });
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock41 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock41 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",41);
                    startActivity(intent);
                }
            }
        });
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock42 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock42 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",42);
                    startActivity(intent);
                }
            }
        });
        button43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock43 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock43 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",43);
                    startActivity(intent);
                }
            }
        });
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock44 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock44 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",44);
                    startActivity(intent);
                }
            }
        });
        button45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock45 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock45 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",45);
                    startActivity(intent);
                }
            }
        });
        button46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock46 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock46 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",46);
                    startActivity(intent);
                }
            }
        });
        button47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock47 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock47 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",47);
                    startActivity(intent);
                }
            }
        });
        button48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock48 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock48 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",48);
                    startActivity(intent);
                }
            }
        });
        button49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock49 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock49 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",49);
                    startActivity(intent);
                }
            }
        });
        button50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock50 == 1){
                    Toast.makeText(Selection4_4.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock50 == 0){
                    Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                    intent.putExtra("LV",50);
                    startActivity(intent);
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
    private void loadGameLock1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1 = cursor.getInt(0);
                System.out.println("aaaaaaaaaaaaaaaa " + cursor.getInt(0) + " " + lock1);
            }
        }
    }

    private void loadGameLock2(){
        if(sqliteDB != null){
            System.out.println("IN LOADGAMELOCK2");
            String sqlQuery = "SELECT * FROM GameLock4_4_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            System.out.println(cursor);
            if(cursor.moveToNext()){
                lock2 = cursor.getInt(0);
                System.out.println("aaaaaaaaaaaaaaaa " + cursor.getInt(0) + " " + lock2);
            }
        }
    }

    private void loadGameLock3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock9(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_9";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock10(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_10";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock11(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_11";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock11 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock12(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_12";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock12 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock13(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_13";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock13 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock14(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_14";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock14 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock15(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_15";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock15 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock16(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_16";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock16 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock17(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_17";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock17 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock18(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_18";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock18 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock19(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_19";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock19 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock20(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_20";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock20 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock21(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_21";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock21 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock22(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_22";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock22 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock23(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_23";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock23 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock24(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_24";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock24 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock25(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_25";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock25 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock26(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_26";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock26 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock27(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_27";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock27 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock28(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_28";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock28 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock29(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_29";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock29 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock30(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_30";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock30 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock31(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_31";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock31 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock32(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_32";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock32 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock33(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_33";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock33 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock34(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_34";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock34 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock35(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_35";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock35 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock36(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_36";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock36 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock37(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_37";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock37 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock38(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_38";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock38 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock39(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_39";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock39 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock40(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_40";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock40 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock41(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_41";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock41 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock42(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_42";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock42 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock43(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_43";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock43 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock44(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_44";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock44 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock45(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_45";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock45 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock46(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_46";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock46 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock47(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_47";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock47 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock48(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_48";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock48 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock49(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_49";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock49 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock50(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4_50";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock50 = cursor.getInt(0);
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////



    @Override
    protected void onUserLeaveHint(){
        super.onUserLeaveHint();
        finish();
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
