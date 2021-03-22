package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class Selection4_4 extends AppCompatActivity {

    int standardSize_X, standardSize_Y;
    float density;

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

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",1);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",2);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",3);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",4);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",5);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",6);
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",7);
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",8);
                startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",9);
                startActivity(intent);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",10);
                startActivity(intent);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",11);
                startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",12);
                startActivity(intent);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",13);
                startActivity(intent);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",14);
                startActivity(intent);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",15);
                startActivity(intent);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",16);
                startActivity(intent);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",17);
                startActivity(intent);
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",18);
                startActivity(intent);
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",19);
                startActivity(intent);
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",20);
                startActivity(intent);
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",21);
                startActivity(intent);
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",22);
                startActivity(intent);
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",23);
                startActivity(intent);
            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",24);
                startActivity(intent);
            }
        });
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",25);
                startActivity(intent);
            }
        });
        button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",26);
                startActivity(intent);
            }
        });
        button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",27);
                startActivity(intent);
            }
        });
        button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",28);
                startActivity(intent);
            }
        });
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",29);
                startActivity(intent);
            }
        });
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",30);
                startActivity(intent);
            }
        });
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",31);
                startActivity(intent);
            }
        });
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",32);
                startActivity(intent);
            }
        });
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",33);
                startActivity(intent);
            }
        });
        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",34);
                startActivity(intent);
            }
        });
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",35);
                startActivity(intent);
            }
        });
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",36);
                startActivity(intent);
            }
        });
        button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",37);
                startActivity(intent);
            }
        });
        button38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",38);
                startActivity(intent);
            }
        });
        button39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",39);
                startActivity(intent);
            }
        });
        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",40);
                startActivity(intent);
            }
        });
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",41);
                startActivity(intent);
            }
        });
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",42);
                startActivity(intent);
            }
        });
        button43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",43);
                startActivity(intent);
            }
        });
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",44);
                startActivity(intent);
            }
        });
        button45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",45);
                startActivity(intent);
            }
        });
        button46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",46);
                startActivity(intent);
            }
        });
        button47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",47);
                startActivity(intent);
            }
        });
        button48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",48);
                startActivity(intent);
            }
        });
        button49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",49);
                startActivity(intent);
            }
        });
        button50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",50);
                startActivity(intent);
            }
        });

    }

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
