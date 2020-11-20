package atomic0x90.github.io.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;
import java.io.StringReader;

public class GameLine2 extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_line2);

        //DB
        sqliteDB = init_database();

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

        final Button TopButton = (Button) findViewById(R.id.Line2TopButton);
        final Button MiddleButton1 = (Button) findViewById(R.id.Line2MiddleButton1);
        final Button MiddleButton2 = (Button) findViewById(R.id.Line2MiddleButton2);
        final Button BottomButton = (Button) findViewById(R.id.Line2BottomButton);

        Button RetryButton = (Button) findViewById(R.id.Line2RetryButton);

        Intent nowIntent = getIntent();
        final int MaxNum = nowIntent.getIntExtra("Max",0);    //최대 숫자
        final String StrAnswer = nowIntent.getStringExtra("Answer");  //어떤 stage

        //int MaxNum = Integer.parseInt(SMaxNum);
        int[] IntAnswer = null;
        final int[] AnswerNow = {0};
        final int[] Mid1Arr = new int[100];
        final int[] Mid2Arr = new int[100];

        final int[] Mid1Tail = {0};
        final int[] Mid2Tail = {0};

        if(StrAnswer.equals("1_1")){
            IntAnswer = new int[]{1, 2, 4, 3};
            BottomButton.setText("1,2,4,3");
        }
        else if(StrAnswer.equals("1_2")){
            IntAnswer = new int[]{1, 3, 2, 4};
            BottomButton.setText("1,3,2,4");
        }
        else if(StrAnswer.equals("1_3")){
            IntAnswer = new int[]{2, 1, 3, 4};
            BottomButton.setText("2,1,3,4");
        }
        else if(StrAnswer.equals("1_4")){
            IntAnswer = new int[]{2, 3, 1, 4};
            BottomButton.setText("2,3,1,4");
        }
        else if(StrAnswer.equals("1_5")){
            IntAnswer = new int[]{3, 1, 2, 4};
            BottomButton.setText("3,1,2,4");
        }
        else if(StrAnswer.equals("1_6")){
            IntAnswer = new int[]{3, 4, 1, 2};
            BottomButton.setText("3,4,1,2");
        }
        else if(StrAnswer.equals("1_7")){
            IntAnswer = new int[]{3,4,2,1};
            BottomButton.setText("3,4,2,1");
        }
        else if(StrAnswer.equals("1_8")){
            IntAnswer = new int[]{4,2,3,1};
            BottomButton.setText("4,2,3,1");
        }
        else if(StrAnswer.equals("2_1")){
            IntAnswer = new int[]{2,4,1,5,3};
            BottomButton.setText("2,4,1,5,3");
        }
        else if(StrAnswer.equals("2_2")){
            IntAnswer = new int[]{3,1,4,2,5};
            BottomButton.setText("3,1,4,2,5");
        }
        else if(StrAnswer.equals("2_3")){
            IntAnswer = new int[]{3,2,4,5,1};
            BottomButton.setText("3,2,4,5,1");
        }
        else if(StrAnswer.equals("2_4")){
            IntAnswer = new int[]{4,1,3,2,5};
            BottomButton.setText("4,1,3,2,5");
        }
        else if(StrAnswer.equals("2_5")){
            IntAnswer = new int[]{5,2,4,1,3};
            BottomButton.setText("5,2,4,1,3");
        }
        else if(StrAnswer.equals("2_6")){
            IntAnswer = new int[]{1,4,3,5,2};
            BottomButton.setText("1,4,3,5,2");
        }
        else if(StrAnswer.equals("2_7")){
            IntAnswer = new int[]{2,5,1,4,3};
            BottomButton.setText("2,5,1,4,3");
        }
        else if(StrAnswer.equals("2_8")){
            IntAnswer = new int[]{4,3,5,2,1};
            BottomButton.setText("4,3,5,2,1");
        }
        else if(StrAnswer.equals("3_1")){
            IntAnswer = new int[]{1,5,2,3,6,4};
            BottomButton.setText("1,5,2,3,6,4");
        }
        else if(StrAnswer.equals("3_2")){
            IntAnswer = new int[]{2,4,5,1,6,3};
            BottomButton.setText("2,4,5,1,6,3");
        }
        else if(StrAnswer.equals("3_3")){
            IntAnswer = new int[]{3,1,6,4,2,5};
            BottomButton.setText("3,1,6,4,2,5");
        }
        else if(StrAnswer.equals("3_4")){
            IntAnswer = new int[]{4,2,5,3,6,1};
            BottomButton.setText("4,2,5,3,6,1");
        }
        else if(StrAnswer.equals("3_5")){
            IntAnswer = new int[]{4,1,3,2,5,6};
            BottomButton.setText("4,1,3,2,5,6");
        }
        else if(StrAnswer.equals("3_6")){
            IntAnswer = new int[]{5,2,4,3,1,6};
            BottomButton.setText("5,2,4,3,1,6");
        }
        else if(StrAnswer.equals("3_7")){
            IntAnswer = new int[]{6,2,4,3,5,1};
            BottomButton.setText("6,2,4,3,5,1");
        }
        else if(StrAnswer.equals("3_8")){
            IntAnswer = new int[]{3,5,4,6,2,1};
            BottomButton.setText("3,5,4,6,2,1");
        }
        else if(StrAnswer.equals("4_1")){
            IntAnswer = new int[]{1,5,3,6,4,2,7};
            BottomButton.setText("1,5,3,6,4,2,7");
        }
        else if(StrAnswer.equals("4_2")){
            IntAnswer = new int[]{2,5,6,3,4,7,1};
            BottomButton.setText("2,5,6,3,4,7,1");
        }
        else if(StrAnswer.equals("4_3")){
            IntAnswer = new int[]{3,5,6,2,7,4,1};
            BottomButton.setText("3,5,6,2,7,4,1");
        }
        else if(StrAnswer.equals("4_4")){
            IntAnswer = new int[]{7,1,3,5,2,6,4};
            BottomButton.setText("7,1,3,5,2,6,4");
        }
        else if(StrAnswer.equals("4_5")){
            IntAnswer = new int[]{2,4,3,5,1,7,6};
            BottomButton.setText("2,4,3,5,1,7,6");
        }
        else if(StrAnswer.equals("4_6")){
            IntAnswer = new int[]{6,1,3,2,4,5,7};
            BottomButton.setText("6,1,3,2,4,5,7");
        }
        else if(StrAnswer.equals("4_7")){
            IntAnswer = new int[]{3,5,7,6,1,4,2};
            BottomButton.setText("3,5,7,6,1,4,2");
        }
        else if(StrAnswer.equals("4_8")){
            IntAnswer = new int[]{5,7,1,6,3,2,4};
            BottomButton.setText("5,7,1,6,3,2,4");
        }
        else if(StrAnswer.equals("5_1")){
            IntAnswer = new int[]{2,4,1,6,3,5,7,8};
            BottomButton.setText("2,4,1,6,3,5,7,8");
        }
        else if(StrAnswer.equals("5_2")){
            IntAnswer = new int[]{4,2,6,3,7,1,5,8};
            BottomButton.setText("4,2,6,3,7,1,5,8");
        }
        else if(StrAnswer.equals("5_3")){
            IntAnswer = new int[]{5,2,6,1,8,4,3,7};
            BottomButton.setText("5,2,6,1,8,4,3,7");
        }
        else if(StrAnswer.equals("5_4")){
            IntAnswer = new int[]{6,2,7,1,4,8,3,5};
            BottomButton.setText("6,2,7,1,4,8,3,5");
        }
        else if(StrAnswer.equals("5_5")){
            IntAnswer = new int[]{7,3,4,1,6,8,2,5};
            BottomButton.setText("7,3,4,1,6,8,2,5");
        }
        else if(StrAnswer.equals("5_6")){
            IntAnswer = new int[]{3,6,7,1,4,2,8,5};
            BottomButton.setText("3,6,7,1,4,2,8,5");
        }
        else if(StrAnswer.equals("5_7")){
            IntAnswer = new int[]{4,7,2,8,6,3,5,1};
            BottomButton.setText("4,7,2,8,6,3,5,1");
        }
        else if(StrAnswer.equals("5_8")){
            IntAnswer = new int[]{3,6,4,7,8,2,5,1};
            BottomButton.setText("3,6,4,7,8,2,5,1");
        }
        else if(StrAnswer.equals("6_1")){
            IntAnswer = new int[]{3,7,2,8,9,4,1,5,6};
            BottomButton.setText("3,7,2,8,9,4,1,5,6");
        }
        else if(StrAnswer.equals("6_2")){
            IntAnswer = new int[]{4,2,6,3,5,1,7,9,8};
            BottomButton.setText("4,2,6,3,5,1,7,9,8");
        }
        else if(StrAnswer.equals("6_3")){
            IntAnswer = new int[]{6,2,8,3,1,4,9,5,7};
            BottomButton.setText("6,2,8,3,1,4,9,5,7");
        }
        else if(StrAnswer.equals("6_4")){
            IntAnswer = new int[]{2,5,8,3,1,9,6,4,7};
            BottomButton.setText("2,5,8,3,1,9,6,4,7");
        }
        else if(StrAnswer.equals("6_5")){
            IntAnswer = new int[]{6,5,9,2,1,3,8,4,7};
            BottomButton.setText("6,5,9,2,1,3,8,4,7");
        }
        else if(StrAnswer.equals("6_6")){
            IntAnswer = new int[]{5,3,2,8,1,9,4,6,7};
            BottomButton.setText("5,3,2,8,1,9,4,6,7");
        }
        else if(StrAnswer.equals("6_7")){
            IntAnswer = new int[]{7,2,6,3,8,9,4,1,5};
            BottomButton.setText("7,2,6,3,8,9,4,1,5");
        }
        else if(StrAnswer.equals("6_8")){
            IntAnswer = new int[]{7,3,4,9,8,5,2,1,6};
            BottomButton.setText("7,3,4,9,8,5,2,1,6");
        }
        else if(StrAnswer.equals("7_1")){
            IntAnswer = new int[]{2,5,3,8,4,9,10,1,6,7};
            BottomButton.setText("2,5,3,8,4,9,10,1,6,7");
        }
        else if(StrAnswer.equals("7_2")){
            IntAnswer = new int[]{3,6,8,4,1,10,2,5,7,9};
            BottomButton.setText("3,6,8,4,1,10,2,5,7,9");
        }
        else if(StrAnswer.equals("7_3")){
            IntAnswer = new int[]{5,3,8,1,2,9,10,4,6,7};
            BottomButton.setText("5,3,8,1,2,9,10,4,6,7");
        }
        else if(StrAnswer.equals("7_4")){
            IntAnswer = new int[]{6,9,10,2,4,1,8,3,5,7};
            BottomButton.setText("6,9,10,2,4,1,8,3,5,7");
        }
        else if(StrAnswer.equals("7_5")){
            IntAnswer = new int[]{4,3,8,5,7,1,9,10,2,5};
            BottomButton.setText("4,3,8,5,7,1,9,10,2,5");
        }
        else if(StrAnswer.equals("7_6")){
            IntAnswer = new int[]{5,7,10,3,8,9,2,6,1,4};
            BottomButton.setText("5,7,10,3,8,9,2,6,1,4");
        }
        else if(StrAnswer.equals("7_7")){
            IntAnswer = new int[]{3,7,4,10,9,1,2,5,8,6};
            BottomButton.setText("3,7,4,10,9,1,2,5,8,6");
        }
        else if(StrAnswer.equals("7_8")){
            IntAnswer = new int[]{4,2,5,8,10,9,1,3,7,6};
            BottomButton.setText("4,2,5,8,10,9,1,3,7,6");
        }
        else if(StrAnswer.equals("8_1")){
            IntAnswer = new int[]{4,3,7,5,9,1,2,10,11,8,6};
            BottomButton.setText("4,3,7,5,9,1,2,10,11,8,6");
        }
        else if(StrAnswer.equals("8_2")){
            IntAnswer = new int[]{4,5,8,3,1,10,2,6,7,11,9};
            BottomButton.setText("4,5,8,3,1,10,2,6,7,11,9");
        }
        else if(StrAnswer.equals("8_3")){
            IntAnswer = new int[]{5,2,3,11,8,6,7,10,1,4,9};
            BottomButton.setText("5,2,3,11,8,6,7,10,1,4,9");
        }
        else if(StrAnswer.equals("8_4")){
            IntAnswer = new int[]{5,8,3,2,1,9,10,4,11,7,6};
            BottomButton.setText("5,8,3,2,1,9,10,4,11,7,6");
        }
        else if(StrAnswer.equals("8_5")){
            IntAnswer = new int[]{4,6,5,8,2,1,11,9,10,7,3};
            BottomButton.setText("4,6,5,8,2,1,11,9,10,7,3");
        }
        else if(StrAnswer.equals("8_6")){
            IntAnswer = new int[]{6,5,2,8,10,11,9,1,3,7,4};
            BottomButton.setText("6,5,2,8,10,11,9,1,3,7,4");
        }
        else if(StrAnswer.equals("8_7")){
            IntAnswer = new int[]{6,9,10,7,11,4,1,3,8,5,2};
            BottomButton.setText("6,9,10,7,11,4,1,3,8,5,2");
        }
        else if(StrAnswer.equals("8_8")){
            IntAnswer = new int[]{5,2,10,3,8,9,7,4,1,6,11};
            BottomButton.setText("5,2,10,3,8,9,7,4,1,6,11");
        }
        else if(StrAnswer.equals("9_1")){
            IntAnswer = new int[]{3,5,1,4,8,10,2,6,9,11,12,7};
            BottomButton.setText("3,5,1,4,8,10,2,6,9,11,12,7");
        }
        else if(StrAnswer.equals("9_2")){
            IntAnswer = new int[]{4,3,1,8,6,9,12,2,10,11,7,5};
            BottomButton.setText("4,3,1,8,6,9,12,2,10,11,7,5");
        }
        else if(StrAnswer.equals("9_3")){
            IntAnswer = new int[]{5,2,4,8,1,9,10,3,12,11,7,6};
            BottomButton.setText("5,2,4,8,1,9,10,3,12,11,7,6");
        }
        else if(StrAnswer.equals("9_4")){
            IntAnswer = new int[]{5,6,4,7,2,1,11,9,10,8,12,3};
            BottomButton.setText("5,6,4,7,2,1,11,9,10,8,12,3");
        }
        else if(StrAnswer.equals("9_5")){
            IntAnswer = new int[]{6,1,2,4,10,11,9,5,3,12,7,8};
            BottomButton.setText("6,1,2,4,10,11,9,5,3,12,7,8");
        }
        else if(StrAnswer.equals("9_6")){
            IntAnswer = new int[]{6,2,1,7,11,4,10,3,12,8,5,9};
            BottomButton.setText("6,2,1,7,11,4,10,3,12,8,5,9");
        }
        else if(StrAnswer.equals("9_7")){
            IntAnswer = new int[]{5,2,1,3,8,7,12,7,4,10,9,11};
            BottomButton.setText("5,2,1,3,8,7,12,7,4,10,9,11");
        }
        else if(StrAnswer.equals("9_8")){
            IntAnswer = new int[]{5,2,4,11,9,7,6,12,10,1,3,8};
            BottomButton.setText("5,2,4,11,9,7,6,12,10,1,3,8");
        }
        else if(StrAnswer.equals("10_1")){
            IntAnswer = new int[]{5,2,7,3,8,9,11,1,4,13,10,7,12};
            BottomButton.setText("5,2,7,3,8,9,11,1,4,13,10,7,12");
        }
        else if(StrAnswer.equals("10_2")){
            IntAnswer = new int[]{3,5,1,7,2,12,8,6,13,9,11,10,4};
            BottomButton.setText("3,5,1,7,2,12,8,6,13,9,11,10,4");
        }
        else if(StrAnswer.equals("10_3")){
            IntAnswer = new int[]{4,2,1,8,6,7,12,3,13,10,11,9,5};
            BottomButton.setText("4,2,1,8,6,7,12,3,13,10,11,9,5");
        }
        else if(StrAnswer.equals("10_4")){
            IntAnswer = new int[]{5,2,9,7,1,4,10,3,12,11,8,13,6};
            BottomButton.setText("5,2,9,7,1,4,10,3,12,11,8,13,6");
        }
        else if(StrAnswer.equals("10_5")){
            IntAnswer = new int[]{6,4,2,1,11,10,5,13,9,3,12,7,8};
            BottomButton.setText("6,4,2,1,11,10,5,13,9,3,12,7,8");
        }
        else if(StrAnswer.equals("10_6")){
            IntAnswer = new int[]{4,2,1,7,11,6,13,10,5,8,12,3,9};
            BottomButton.setText("4,2,1,7,11,6,13,10,5,8,12,3,9");
        }
        else if(StrAnswer.equals("10_7")){
            IntAnswer = new int[]{3,2,4,12,1,13,7,6,8,10,9,5,11};
            BottomButton.setText("3,2,4,12,1,13,7,6,8,10,9,5,11");
        }
        else if(StrAnswer.equals("10_8")){
            IntAnswer = new int[]{5,1,4,7,12,6,11,13,3,10,8,2,9};
            BottomButton.setText("5,1,4,7,12,6,11,13,3,10,8,2,9");
        }



        TopButton.setText("1");
        MiddleButton1.setText("");
        MiddleButton2.setText("");

        RetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TopButton.setText("1");
                MiddleButton1.setText("");
                MiddleButton2.setText("");
                //bottom button 색깔 돌려놓기
                AnswerNow[0] = 0;
                Mid1Tail[0] = 0;
                Mid2Tail[0] = 0;
                for(int i = 0;i < 100;i++){
                    Mid1Arr[i] = 0;
                    Mid2Arr[i] = 0;
                }
                String content = BottomButton.getText().toString();

                SpannableStringBuilder spannableString = new SpannableStringBuilder(content);

                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")),0,content.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(new StyleSpan(Typeface.NORMAL),0,content.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                BottomButton.setText(spannableString);

                TopButton.setSelected(false);
                MiddleButton1.setSelected(false);
                MiddleButton2.setSelected(false);
                BottomButton.setSelected(false);
                TopButton.setEnabled(true);
                MiddleButton1.setEnabled(true);
                MiddleButton2.setEnabled(true);
                BottomButton.setEnabled(true);
            }
        });

        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TopButton.isSelected()) //선택 안됐을 때
                {
                    if (!TopButton.getText().equals("-")) {
                        TopButton.setSelected(true);
                        BottomButton.setEnabled(false);
                    }
                }
                else
                {
                    TopButton.setSelected(false);
                    BottomButton.setEnabled(true);
                }
            }
        });

        MiddleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TopButton.isSelected()){
                    //Top에서 선택 후 Middle로 옮길 때

                    //숫자 이동 알고리즘
                    int tmpNum = Integer.parseInt((String) TopButton.getText());

                    Mid1Arr[Mid1Tail[0]] = tmpNum;
                    Mid1Tail[0]++;
                    tmpNum++;
                    if(tmpNum <= MaxNum)
                        TopButton.setText(Integer.toString(tmpNum));
                    else
                        TopButton.setText("-");

                    String tmpString = "";
                    for(int i = Mid1Tail[0]-1 ;i >= 0; i--){
                        tmpString += "\n" + Mid1Arr[i];
                    }
                    MiddleButton1.setText(tmpString);

                    //Top 버튼 선택 해제
                    TopButton.setSelected(false);

                    BottomButton.setEnabled(true);
                }
                else{
                    //Middle에서 선택 후 Bottom으로 옮길 때
                    if(!MiddleButton1.isSelected()){
                        //선택 안됐을 때
                        MiddleButton1.setSelected(true);

                        TopButton.setEnabled(false);
                        MiddleButton2.setEnabled(false);
                    }
                    else{
                        MiddleButton1.setSelected(false);

                        TopButton.setEnabled(true);
                        MiddleButton2.setEnabled(true);
                    }
                }
            }
        });

        MiddleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TopButton.isSelected()){
                    //Top에서 선택 후 Middle로 옮길 때

                    //숫자 이동 알고리즘
                    int tmpNum = Integer.parseInt((String) TopButton.getText());

                    Mid2Arr[Mid2Tail[0]] = tmpNum;
                    Mid2Tail[0]++;
                    tmpNum++;
                    if(tmpNum <= MaxNum)
                        TopButton.setText(Integer.toString(tmpNum));
                    else
                        TopButton.setText("-");

                    String tmpString = "";
                    for(int i = Mid2Tail[0]-1 ;i >= 0; i--){
                        tmpString += "\n" + Mid2Arr[i];
                    }
                    MiddleButton2.setText(tmpString);

                    //Top 버튼 선택 해제
                    TopButton.setSelected(false);

                    BottomButton.setEnabled(true);
                }
                else{
                    //Middle에서 선택 후 Bottom으로 옮길 때
                    if(!MiddleButton2.isSelected()){
                        //선택 안됐을 때
                        MiddleButton2.setSelected(true);

                        TopButton.setEnabled(false);
                        MiddleButton1.setEnabled(false);
                    }
                    else{
                        MiddleButton2.setSelected(false);

                        TopButton.setEnabled(true);
                        MiddleButton1.setEnabled(true);
                    }
                }
            }
        });


        final int[] finalIntAnswer = IntAnswer;

        BottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!MiddleButton1.isSelected() && !MiddleButton2.isSelected()){
                    //아무것도 안누르고 bottomButton 먼저 누른 경우
                }
                else{

                    if(MiddleButton1.isSelected()){
                        //1번 줄에서 내려온 경우
                        if(Mid1Arr[0] == finalIntAnswer[AnswerNow[0]]){
                            //숫자가 맞을 경우
                            //text
                            String nowAnswer = String.valueOf(finalIntAnswer[AnswerNow[0]]);


                            //
                            for(int i = 0;i < Mid1Tail[0];i++)
                            {
                                Mid1Arr[i] = Mid1Arr[i+1];
                            }
                            Mid1Arr[Mid1Tail[0]] = 0;

                            Mid1Tail[0]--;

                            String tmpString = "";
                            for(int i = Mid1Tail[0]-1 ;i >= 0; i--){
                                tmpString += "\n" + Mid1Arr[i];
                            }
                            MiddleButton1.setText(tmpString);

                            AnswerNow[0]++;


                            //버튼 상태
                            MiddleButton1.setSelected(false);

                            TopButton.setEnabled(true);
                            MiddleButton2.setEnabled(true);

                            //text 설정
                            String content = BottomButton.getText().toString();

                            SpannableStringBuilder spannableString = new SpannableStringBuilder(content);

                            int start = content.indexOf(nowAnswer);
                            int end = start + nowAnswer.length();
                            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")),0,end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            spannableString.setSpan(new StyleSpan(Typeface.BOLD),0,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                            BottomButton.setText(spannableString);

                            //다 맞을 경우 AnswerNow[0]++ == MaxNum
                            if(AnswerNow[0] == MaxNum){
                                if(StrAnswer.equals("1_1")){
                                    if(lock1_2 == 1)
                                        updateGameLock1_2();
                                }
                                else if(StrAnswer.equals("1_2")){
                                    if(lock1_3 == 1)
                                        updateGameLock1_3();
                                }
                                else if(StrAnswer.equals("1_3")){
                                    if(lock1_4 == 1)
                                        updateGameLock1_4();
                                }
                                else if(StrAnswer.equals("1_4")){
                                    if(lock1_5 == 1)
                                        updateGameLock1_5();
                                }
                                else if(StrAnswer.equals("1_5")){
                                    if(lock1_6 == 1)
                                        updateGameLock1_6();
                                }
                                else if(StrAnswer.equals("1_6")){
                                    if(lock1_7 == 1)
                                        updateGameLock1_7();
                                }
                                else if(StrAnswer.equals("1_7")){
                                    if(lock1_8 == 1)
                                        updateGameLock1_8();
                                }
                                else if(StrAnswer.equals("1_8")){
                                    if(lock2_1 == 1)
                                        updateGameLock2_1();
                                }
                                else if(StrAnswer.equals("2_1")){
                                    if(lock2_2 == 1)
                                        updateGameLock2_2();
                                }
                                else if(StrAnswer.equals("2_2")){
                                    if(lock2_3 == 1)
                                        updateGameLock2_3();
                                }
                                else if(StrAnswer.equals("2_3")){
                                    if(lock2_4 == 1)
                                        updateGameLock2_4();
                                }
                                else if(StrAnswer.equals("2_4")){
                                    if(lock2_5 == 1)
                                        updateGameLock2_5();
                                }
                                else if(StrAnswer.equals("2_5")){
                                    if(lock2_6 == 1)
                                        updateGameLock2_6();
                                }
                                else if(StrAnswer.equals("2_6")){
                                    if(lock2_7 == 1)
                                        updateGameLock2_7();
                                }
                                else if(StrAnswer.equals("2_7")){
                                    if(lock2_8 == 1)
                                        updateGameLock2_8();
                                }
                                else if(StrAnswer.equals("2_8")){
                                    if(lock3_1 == 1)
                                        updateGameLock3_1();
                                }
                                else if(StrAnswer.equals("3_1")){
                                    if(lock3_2 == 1)
                                        updateGameLock3_2();
                                }
                                else if(StrAnswer.equals("3_2")){
                                    if(lock3_3 == 1)
                                        updateGameLock3_3();
                                }
                                else if(StrAnswer.equals("3_3")){
                                    if(lock3_4 == 1)
                                        updateGameLock3_4();
                                }
                                else if(StrAnswer.equals("3_4")){
                                    if(lock3_5 == 1)
                                        updateGameLock3_5();
                                }
                                else if(StrAnswer.equals("3_5")){
                                    if(lock3_6 == 1)
                                        updateGameLock3_6();
                                }
                                else if(StrAnswer.equals("3_6")){
                                    if(lock3_7 == 1)
                                        updateGameLock3_7();
                                }
                                else if(StrAnswer.equals("3_7")){
                                    if(lock3_8 == 1)
                                        updateGameLock3_8();
                                }
                                else if(StrAnswer.equals("3_8")){
                                    if(lock4_1 == 1)
                                        updateGameLock4_1();
                                }
                                else if(StrAnswer.equals("4_1")){
                                    if(lock4_2 == 1)
                                        updateGameLock4_2();
                                }
                                else if(StrAnswer.equals("4_2")){
                                    if(lock4_3 == 1)
                                        updateGameLock4_3();
                                }
                                else if(StrAnswer.equals("4_3")){
                                    if(lock4_4 == 1)
                                        updateGameLock4_4();
                                }
                                else if(StrAnswer.equals("4_4")){
                                    if(lock4_5 == 1)
                                        updateGameLock4_5();
                                }
                                else if(StrAnswer.equals("4_5")){
                                    if(lock4_6 == 1)
                                        updateGameLock4_6();
                                }
                                else if(StrAnswer.equals("4_6")){
                                    if(lock4_7 == 1)
                                        updateGameLock4_7();
                                }
                                else if(StrAnswer.equals("4_7")){
                                    if(lock4_8 == 1)
                                        updateGameLock4_8();
                                }
                                else if(StrAnswer.equals("4_8")){
                                    if(lock5_1 == 1)
                                        updateGameLock5_1();
                                }
                                else if(StrAnswer.equals("5_1")){
                                    if(lock5_2 == 1)
                                        updateGameLock5_2();
                                }
                                else if(StrAnswer.equals("5_2")){
                                    if(lock5_3 == 1)
                                        updateGameLock5_3();
                                }
                                else if(StrAnswer.equals("5_3")){
                                    if(lock5_4 == 1)
                                        updateGameLock5_4();
                                }
                                else if(StrAnswer.equals("5_4")){
                                    if(lock5_5 == 1)
                                        updateGameLock5_5();
                                }
                                else if(StrAnswer.equals("5_5")){
                                    if(lock5_6 == 1)
                                        updateGameLock5_6();
                                }
                                else if(StrAnswer.equals("5_6")){
                                    if(lock5_7 == 1)
                                        updateGameLock5_7();
                                }
                                else if(StrAnswer.equals("5_7")){
                                    if(lock5_8 == 1)
                                        updateGameLock5_8();
                                }
                                else if(StrAnswer.equals("5_8")){
                                    if(lock6_1 == 1)
                                        updateGameLock6_1();
                                }
                                else if(StrAnswer.equals("6_1")){
                                    if(lock6_2 == 1)
                                        updateGameLock6_2();
                                }
                                else if(StrAnswer.equals("6_2")){
                                    if(lock6_3 == 1)
                                        updateGameLock6_3();
                                }
                                else if(StrAnswer.equals("6_3")){
                                    if(lock6_4 == 1)
                                        updateGameLock6_4();
                                }
                                else if(StrAnswer.equals("6_4")){
                                    if(lock6_5 == 1)
                                        updateGameLock6_5();
                                }
                                else if(StrAnswer.equals("6_5")){
                                    if(lock6_6 == 1)
                                        updateGameLock6_6();
                                }
                                else if(StrAnswer.equals("6_6")){
                                    if(lock6_7 == 1)
                                        updateGameLock6_7();
                                }
                                else if(StrAnswer.equals("6_7")){
                                    if(lock6_8 == 1)
                                        updateGameLock6_8();
                                }
                                else if(StrAnswer.equals("6_8")){
                                    if(lock7_1 == 1)
                                        updateGameLock7_1();
                                }
                                else if(StrAnswer.equals("7_1")){
                                    if(lock7_2 == 1)
                                        updateGameLock7_2();
                                }
                                else if(StrAnswer.equals("7_2")){
                                    if(lock7_3 == 1)
                                        updateGameLock7_3();
                                }
                                else if(StrAnswer.equals("7_3")){
                                    if(lock7_4 == 1)
                                        updateGameLock7_4();
                                }
                                else if(StrAnswer.equals("7_4")){
                                    if(lock7_5 == 1)
                                        updateGameLock7_5();
                                }
                                else if(StrAnswer.equals("7_5")){
                                    if(lock7_6 == 1)
                                        updateGameLock7_6();
                                }
                                else if(StrAnswer.equals("7_6")){
                                    if(lock7_7 == 1)
                                        updateGameLock7_7();
                                }
                                else if(StrAnswer.equals("7_7")){
                                    if(lock7_8 == 1)
                                        updateGameLock7_8();
                                }
                                else if(StrAnswer.equals("7_8")){
                                    if(lock8_1 == 1)
                                        updateGameLock8_1();
                                }
                                else if(StrAnswer.equals("8_1")){
                                    if(lock8_2 == 1)
                                        updateGameLock8_2();
                                }
                                else if(StrAnswer.equals("8_2")){
                                    if(lock8_3 == 1)
                                        updateGameLock8_3();
                                }
                                else if(StrAnswer.equals("8_3")){
                                    if(lock8_4 == 1)
                                        updateGameLock8_4();
                                }
                                else if(StrAnswer.equals("8_4")){
                                    if(lock8_5 == 1)
                                        updateGameLock8_5();
                                }
                                else if(StrAnswer.equals("8_5")){
                                    if(lock8_6 == 1)
                                        updateGameLock8_6();
                                }
                                else if(StrAnswer.equals("8_6")){
                                    if(lock8_7 == 1)
                                        updateGameLock8_7();
                                }
                                else if(StrAnswer.equals("8_7")){
                                    if(lock8_8 == 1)
                                        updateGameLock8_8();
                                }
                                else if(StrAnswer.equals("8_8")){
                                    if(lock9_1 == 1)
                                        updateGameLock9_1();
                                }
                                else if(StrAnswer.equals("9_1")){
                                    if(lock9_2 == 1)
                                        updateGameLock9_2();
                                }
                                else if(StrAnswer.equals("9_2")){
                                    if(lock9_3 == 1)
                                        updateGameLock9_3();
                                }
                                else if(StrAnswer.equals("9_3")){
                                    if(lock9_4 == 1)
                                        updateGameLock9_4();
                                }
                                else if(StrAnswer.equals("9_4")){
                                    if(lock9_5 == 1)
                                        updateGameLock9_5();
                                }
                                else if(StrAnswer.equals("9_5")){
                                    if(lock9_6 == 1)
                                        updateGameLock9_6();
                                }
                                else if(StrAnswer.equals("9_6")){
                                    if(lock9_7 == 1)
                                        updateGameLock9_7();
                                }
                                else if(StrAnswer.equals("9_7")){
                                    if(lock9_8 == 1)
                                        updateGameLock9_8();
                                }
                                else if(StrAnswer.equals("9_8")){
                                    if(lock10_1 == 1)
                                        updateGameLock10_1();
                                }
                                else if(StrAnswer.equals("10_1")){
                                    if(lock10_2 == 1)
                                        updateGameLock10_2();
                                }
                                else if(StrAnswer.equals("10_2")){
                                    if(lock10_3 == 1)
                                        updateGameLock10_3();
                                }
                                else if(StrAnswer.equals("10_3")){
                                    if(lock10_4 == 1)
                                        updateGameLock10_4();
                                }
                                else if(StrAnswer.equals("10_4")){
                                    if(lock10_5 == 1)
                                        updateGameLock10_5();
                                }
                                else if(StrAnswer.equals("10_5")){
                                    if(lock10_6 == 1)
                                        updateGameLock10_6();
                                }
                                else if(StrAnswer.equals("10_6")){
                                    if(lock10_7 == 1)
                                        updateGameLock10_7();
                                }
                                else if(StrAnswer.equals("10_7")){
                                    if(lock10_8 == 1)
                                        updateGameLock10_8();
                                }
                                CostomDialog costomDialog = new CostomDialog(GameLine2.this);
                                costomDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                                costomDialog.setCancelable(false);
                                costomDialog.show();
                            }
                        }

                        //숫자가 틀린 경우
                    }
                    else{
                        //2번 줄에서 내려온 경우
                        if(Mid2Arr[0] == finalIntAnswer[AnswerNow[0]]) {
                            //숫자가 맞을 경우
                            //text
                            String nowAnswer = String.valueOf(finalIntAnswer[AnswerNow[0]]);


                            //
                            for (int i = 0; i < Mid2Tail[0]; i++) {
                                Mid2Arr[i] = Mid2Arr[i + 1];
                            }
                            Mid2Arr[Mid2Tail[0]] = 0;

                            Mid2Tail[0]--;

                            String tmpString = "";
                            for (int i = Mid2Tail[0] - 1; i >= 0; i--) {
                                tmpString += "\n" + Mid2Arr[i];
                            }
                            MiddleButton2.setText(tmpString);

                            AnswerNow[0]++;


                            //버튼 상태
                            MiddleButton2.setSelected(false);

                            TopButton.setEnabled(true);
                            MiddleButton1.setEnabled(true);

                            //text 설정
                            String content = BottomButton.getText().toString();

                            SpannableString spannableString = new SpannableString(content);

                            int start = content.indexOf(nowAnswer);
                            int end = start + nowAnswer.length();
                            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                            BottomButton.setText(spannableString);

                            //다 맞을 경우 AnswerNow[0]++ == MaxNum
                            if (AnswerNow[0] == MaxNum) {
                                if(StrAnswer.equals("1_1")){
                                    if(lock1_2 == 1)
                                        updateGameLock1_2();
                                }
                                else if(StrAnswer.equals("1_2")){
                                    if(lock1_3 == 1)
                                        updateGameLock1_3();
                                }
                                else if(StrAnswer.equals("1_3")){
                                    if(lock1_4 == 1)
                                        updateGameLock1_4();
                                }
                                else if(StrAnswer.equals("1_4")){
                                    if(lock1_5 == 1)
                                        updateGameLock1_5();
                                }
                                else if(StrAnswer.equals("1_5")){
                                    if(lock1_6 == 1)
                                        updateGameLock1_6();
                                }
                                else if(StrAnswer.equals("1_6")){
                                    if(lock1_7 == 1)
                                        updateGameLock1_7();
                                }
                                else if(StrAnswer.equals("1_7")){
                                    if(lock1_8 == 1)
                                        updateGameLock1_8();
                                }
                                else if(StrAnswer.equals("1_8")){
                                    if(lock2_1 == 1)
                                        updateGameLock2_1();
                                }
                                else if(StrAnswer.equals("2_1")){
                                    if(lock2_2 == 1)
                                        updateGameLock2_2();
                                }
                                else if(StrAnswer.equals("2_2")){
                                    if(lock2_3 == 1)
                                        updateGameLock2_3();
                                }
                                else if(StrAnswer.equals("2_3")){
                                    if(lock2_4 == 1)
                                        updateGameLock2_4();
                                }
                                else if(StrAnswer.equals("2_4")){
                                    if(lock2_5 == 1)
                                        updateGameLock2_5();
                                }
                                else if(StrAnswer.equals("2_5")){
                                    if(lock2_6 == 1)
                                        updateGameLock2_6();
                                }
                                else if(StrAnswer.equals("2_6")){
                                    if(lock2_7 == 1)
                                        updateGameLock2_7();
                                }
                                else if(StrAnswer.equals("2_7")){
                                    if(lock2_8 == 1)
                                        updateGameLock2_8();
                                }
                                else if(StrAnswer.equals("2_8")){
                                    if(lock3_1 == 1)
                                        updateGameLock3_1();
                                }
                                else if(StrAnswer.equals("3_1")){
                                    if(lock3_2 == 1)
                                        updateGameLock3_2();
                                }
                                else if(StrAnswer.equals("3_2")){
                                    if(lock3_3 == 1)
                                        updateGameLock3_3();
                                }
                                else if(StrAnswer.equals("3_3")){
                                    if(lock3_4 == 1)
                                        updateGameLock3_4();
                                }
                                else if(StrAnswer.equals("3_4")){
                                    if(lock3_5 == 1)
                                        updateGameLock3_5();
                                }
                                else if(StrAnswer.equals("3_5")){
                                    if(lock3_6 == 1)
                                        updateGameLock3_6();
                                }
                                else if(StrAnswer.equals("3_6")){
                                    if(lock3_7 == 1)
                                        updateGameLock3_7();
                                }
                                else if(StrAnswer.equals("3_7")){
                                    if(lock3_8 == 1)
                                        updateGameLock3_8();
                                }
                                else if(StrAnswer.equals("3_8")){
                                    if(lock4_1 == 1)
                                        updateGameLock4_1();
                                }
                                else if(StrAnswer.equals("4_1")){
                                    if(lock4_2 == 1)
                                        updateGameLock4_2();
                                }
                                else if(StrAnswer.equals("4_2")){
                                    if(lock4_3 == 1)
                                        updateGameLock4_3();
                                }
                                else if(StrAnswer.equals("4_3")){
                                    if(lock4_4 == 1)
                                        updateGameLock4_4();
                                }
                                else if(StrAnswer.equals("4_4")){
                                    if(lock4_5 == 1)
                                        updateGameLock4_5();
                                }
                                else if(StrAnswer.equals("4_5")){
                                    if(lock4_6 == 1)
                                        updateGameLock4_6();
                                }
                                else if(StrAnswer.equals("4_6")){
                                    if(lock4_7 == 1)
                                        updateGameLock4_7();
                                }
                                else if(StrAnswer.equals("4_7")){
                                    if(lock4_8 == 1)
                                        updateGameLock4_8();
                                }
                                else if(StrAnswer.equals("4_8")){
                                    if(lock5_1 == 1)
                                        updateGameLock5_1();
                                }
                                else if(StrAnswer.equals("5_1")){
                                    if(lock5_2 == 1)
                                        updateGameLock5_2();
                                }
                                else if(StrAnswer.equals("5_2")){
                                    if(lock5_3 == 1)
                                        updateGameLock5_3();
                                }
                                else if(StrAnswer.equals("5_3")){
                                    if(lock5_4 == 1)
                                        updateGameLock5_4();
                                }
                                else if(StrAnswer.equals("5_4")){
                                    if(lock5_5 == 1)
                                        updateGameLock5_5();
                                }
                                else if(StrAnswer.equals("5_5")){
                                    if(lock5_6 == 1)
                                        updateGameLock5_6();
                                }
                                else if(StrAnswer.equals("5_6")){
                                    if(lock5_7 == 1)
                                        updateGameLock5_7();
                                }
                                else if(StrAnswer.equals("5_7")){
                                    if(lock5_8 == 1)
                                        updateGameLock5_8();
                                }
                                else if(StrAnswer.equals("5_8")){
                                    if(lock6_1 == 1)
                                        updateGameLock6_1();
                                }
                                else if(StrAnswer.equals("6_1")){
                                    if(lock6_2 == 1)
                                        updateGameLock6_2();
                                }
                                else if(StrAnswer.equals("6_2")){
                                    if(lock6_3 == 1)
                                        updateGameLock6_3();
                                }
                                else if(StrAnswer.equals("6_3")){
                                    if(lock6_4 == 1)
                                        updateGameLock6_4();
                                }
                                else if(StrAnswer.equals("6_4")){
                                    if(lock6_5 == 1)
                                        updateGameLock6_5();
                                }
                                else if(StrAnswer.equals("6_5")){
                                    if(lock6_6 == 1)
                                        updateGameLock6_6();
                                }
                                else if(StrAnswer.equals("6_6")){
                                    if(lock6_7 == 1)
                                        updateGameLock6_7();
                                }
                                else if(StrAnswer.equals("6_7")){
                                    if(lock6_8 == 1)
                                        updateGameLock6_8();
                                }
                                else if(StrAnswer.equals("6_8")){
                                    if(lock7_1 == 1)
                                        updateGameLock7_1();
                                }
                                else if(StrAnswer.equals("7_1")){
                                    if(lock7_2 == 1)
                                        updateGameLock7_2();
                                }
                                else if(StrAnswer.equals("7_2")){
                                    if(lock7_3 == 1)
                                        updateGameLock7_3();
                                }
                                else if(StrAnswer.equals("7_3")){
                                    if(lock7_4 == 1)
                                        updateGameLock7_4();
                                }
                                else if(StrAnswer.equals("7_4")){
                                    if(lock7_5 == 1)
                                        updateGameLock7_5();
                                }
                                else if(StrAnswer.equals("7_5")){
                                    if(lock7_6 == 1)
                                        updateGameLock7_6();
                                }
                                else if(StrAnswer.equals("7_6")){
                                    if(lock7_7 == 1)
                                        updateGameLock7_7();
                                }
                                else if(StrAnswer.equals("7_7")){
                                    if(lock7_8 == 1)
                                        updateGameLock7_8();
                                }
                                else if(StrAnswer.equals("7_8")){
                                    if(lock8_1 == 1)
                                        updateGameLock8_1();
                                }
                                else if(StrAnswer.equals("8_1")){
                                    if(lock8_2 == 1)
                                        updateGameLock8_2();
                                }
                                else if(StrAnswer.equals("8_2")){
                                    if(lock8_3 == 1)
                                        updateGameLock8_3();
                                }
                                else if(StrAnswer.equals("8_3")){
                                    if(lock8_4 == 1)
                                        updateGameLock8_4();
                                }
                                else if(StrAnswer.equals("8_4")){
                                    if(lock8_5 == 1)
                                        updateGameLock8_5();
                                }
                                else if(StrAnswer.equals("8_5")){
                                    if(lock8_6 == 1)
                                        updateGameLock8_6();
                                }
                                else if(StrAnswer.equals("8_6")){
                                    if(lock8_7 == 1)
                                        updateGameLock8_7();
                                }
                                else if(StrAnswer.equals("8_7")){
                                    if(lock8_8 == 1)
                                        updateGameLock8_8();
                                }
                                else if(StrAnswer.equals("8_8")){
                                    if(lock9_1 == 1)
                                        updateGameLock9_1();
                                }
                                else if(StrAnswer.equals("9_1")){
                                    if(lock9_2 == 1)
                                        updateGameLock9_2();
                                }
                                else if(StrAnswer.equals("9_2")){
                                    if(lock9_3 == 1)
                                        updateGameLock9_3();
                                }
                                else if(StrAnswer.equals("9_3")){
                                    if(lock9_4 == 1)
                                        updateGameLock9_4();
                                }
                                else if(StrAnswer.equals("9_4")){
                                    if(lock9_5 == 1)
                                        updateGameLock9_5();
                                }
                                else if(StrAnswer.equals("9_5")){
                                    if(lock9_6 == 1)
                                        updateGameLock9_6();
                                }
                                else if(StrAnswer.equals("9_6")){
                                    if(lock9_7 == 1)
                                        updateGameLock9_7();
                                }
                                else if(StrAnswer.equals("9_7")){
                                    if(lock9_8 == 1)
                                        updateGameLock9_8();
                                }
                                else if(StrAnswer.equals("9_8")){
                                    if(lock10_1 == 1)
                                        updateGameLock10_1();
                                }
                                else if(StrAnswer.equals("10_1")){
                                    if(lock10_2 == 1)
                                        updateGameLock10_2();
                                }
                                else if(StrAnswer.equals("10_2")){
                                    if(lock10_3 == 1)
                                        updateGameLock10_3();
                                }
                                else if(StrAnswer.equals("10_3")){
                                    if(lock10_4 == 1)
                                        updateGameLock10_4();
                                }
                                else if(StrAnswer.equals("10_4")){
                                    if(lock10_5 == 1)
                                        updateGameLock10_5();
                                }
                                else if(StrAnswer.equals("10_5")){
                                    if(lock10_6 == 1)
                                        updateGameLock10_6();
                                }
                                else if(StrAnswer.equals("10_6")){
                                    if(lock10_7 == 1)
                                        updateGameLock10_7();
                                }
                                else if(StrAnswer.equals("10_7")){
                                    if(lock10_8 == 1)
                                        updateGameLock10_8();
                                }
                                CostomDialog costomDialog = new CostomDialog(GameLine2.this);
                                costomDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                                costomDialog.setCancelable(false);
                                costomDialog.show();
                            }
                        }

                        //숫자가 틀린 경우
                    }

                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        CostomDialogBackKey costomDialog = new CostomDialogBackKey(GameLine2.this);
        costomDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        costomDialog.setCancelable(false);
        costomDialog.show();
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


    ///////////////////////////////////////////////////////////////////////////////////////////////////////



    private void updateGameLock1_2(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock1_2 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock1_3(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock1_3 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock1_4(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock1_4 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock1_5(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock1_5 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock1_6(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock1_6 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock1_7(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock1_7 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock1_8(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock1_8 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock2_1(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock2_1 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock2_2(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock2_2 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock2_3(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock2_3 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock2_4(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock2_4 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock2_5(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock2_5 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock2_6(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock2_6 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock2_7(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock2_7 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock2_8(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock2_8 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock3_1(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock3_1 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock3_2(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock3_2 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock3_3(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock3_3 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock3_4(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock3_4 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock3_5(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock3_5 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock3_6(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock3_6 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock3_7(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock3_7 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock3_8(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock3_8 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock4_1(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock4_1 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock4_2(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock4_2 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock4_3(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock4_3 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock4_4(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock4_4 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock4_5(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock4_5 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock4_6(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock4_6 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock4_7(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock4_7 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock4_8(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock4_8 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock5_1(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock5_1 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock5_2(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock5_2 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock5_3(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock5_3 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock5_4(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock5_4 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock5_5(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock5_5 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock5_6(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock5_6 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock5_7(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock5_7 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock5_8(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock5_8 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock6_1(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock6_1 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock6_2(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock6_2 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock6_3(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock6_3 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock6_4(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock6_4 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock6_5(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock6_5 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock6_6(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock6_6 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock6_7(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock6_7 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock6_8(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock6_8 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock7_1(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock7_1 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock7_2(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock7_2 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock7_3(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock7_3 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock7_4(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock7_4 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock7_5(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock7_5 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock7_6(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock7_6 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock7_7(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock7_7 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock7_8(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock7_8 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock8_1(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock8_1 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock8_2(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock8_2 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock8_3(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock8_3 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock8_4(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock8_4 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock8_5(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock8_5 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock8_6(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock8_6 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock8_7(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock8_7 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock8_8(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock8_8 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock9_1(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock9_1 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock9_2(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock9_2 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock9_3(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock9_3 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock9_4(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock9_4 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock9_5(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock9_5 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock9_6(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock9_6 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock9_7(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock9_7 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock9_8(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock9_8 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock10_1(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock10_1 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock10_2(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock10_2 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }

    private void updateGameLock10_3(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock10_3 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock10_4(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock10_4 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock10_5(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock10_5 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock10_6(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock10_6 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock10_7(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock10_7 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
    private void updateGameLock10_8(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE GameLock10_8 SET Lock = " + 0;
            sqliteDB.execSQL(sqlQuery);
        }
    }
}
