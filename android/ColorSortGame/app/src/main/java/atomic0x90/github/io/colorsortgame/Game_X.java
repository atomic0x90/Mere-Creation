package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Game_X extends AppCompatActivity implements View.OnTouchListener {
    float oldXvalue, oldYvalue;
    int standardSize_X, standardSize_Y;
    float density;
    float saveX = -1;
    float saveY = -1;

    float saveLastLine;
    float[] buttonLayoutX = new float[16];
    float[] buttonLayoutY = new float[16];
    float buttonLength;

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


    public void scaleAnimation(final float x, final float y, final Button button) {
        final Button button1 = (Button) findViewById(R.id.button1_x);
        final Button button2 = (Button) findViewById(R.id.button2_x);
        final Button button3 = (Button) findViewById(R.id.button3_x);
        final Button button4 = (Button) findViewById(R.id.button4_x);
        final Button button5 = (Button) findViewById(R.id.button5_x);
        final Button button6 = (Button) findViewById(R.id.button6_x);
        final Button button7 = (Button) findViewById(R.id.button7_x);
        final Button button8 = (Button) findViewById(R.id.button8_x);
        final Button button9 = (Button) findViewById(R.id.button9_x);
        final Button button10 = (Button) findViewById(R.id.button10_x);
        final Button button11 = (Button) findViewById(R.id.button11_x);
        final Button button12 = (Button) findViewById(R.id.button12_x);
        final Button button13 = (Button) findViewById(R.id.button13_x);
        final Button button14 = (Button) findViewById(R.id.button14_x);
        final Button button15 = (Button) findViewById(R.id.button15_x);

        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
        button10.setEnabled(false);
        button11.setEnabled(false);
        button12.setEnabled(false);
        button13.setEnabled(false);
        button14.setEnabled(false);
        button15.setEnabled(false);


        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1.2f, 0, 1.2f, x + button.getWidth() / 2, y + button.getHeight() / 2);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(350);
        button.bringToFront();
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setX(x);
                button.setY(y);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation s = new ScaleAnimation(1.2f, 1, 1.2f, 1, x + button.getWidth() / 2, y + button.getHeight() / 2);
                s.setFillAfter(true);
                s.setDuration(150);
                s.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        button1.setEnabled(true);
                        button2.setEnabled(true);
                        button3.setEnabled(true);
                        button4.setEnabled(true);
                        button5.setEnabled(true);
                        button6.setEnabled(true);
                        button7.setEnabled(true);
                        button8.setEnabled(true);
                        button9.setEnabled(true);
                        button10.setEnabled(true);
                        button11.setEnabled(true);
                        button12.setEnabled(true);
                        button13.setEnabled(true);
                        button14.setEnabled(true);
                        button15.setEnabled(true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                button.startAnimation(s);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        button.startAnimation(scaleAnimation);

    }

    public void alphaAnimation(TextView textView, int duration) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        textView.startAnimation(alphaAnimation);
    }


    @Override
    protected void onStart() {
        super.onStart();

        final int[] saveX = new int[16];
        final int[] saveY = new int[16];

        saveX[1] = 0;
        saveY[1] = 0;

        saveX[2] = (int)buttonLength;
        saveY[2] = 0;

        saveX[3] = (int)buttonLength*3;
        saveY[3] = 0;

        saveX[4] = (int)buttonLength*4;
        saveY[4] = 0;

        saveX[5] = (int)buttonLength;
        saveY[5] = (int)buttonLength;

        saveX[6] = (int)buttonLength*2;
        saveY[6] = (int)buttonLength;

        saveX[7] = (int)buttonLength*3;
        saveY[7] = (int)buttonLength;

        saveX[8] = (int)buttonLength*2;
        saveY[8] = (int)buttonLength*2;

        saveX[9] = (int)buttonLength;
        saveY[9] = (int)buttonLength*3;

        saveX[10] = (int)buttonLength*2;
        saveY[10] = (int)buttonLength*3;

        saveX[11] = (int)buttonLength*3;
        saveY[11] = (int)buttonLength*3;

        saveX[12] = 0;
        saveY[12] = (int)buttonLength*4;

        saveX[13] = (int)buttonLength;
        saveY[13] = (int)buttonLength*4;

        saveX[14] = (int)buttonLength*3;
        saveY[14] = (int)buttonLength*4;

        saveX[15] = (int)buttonLength*4;
        saveY[15] = (int)buttonLength*4;

        Button button1 = (Button) findViewById(R.id.button1_x);
        Button button2 = (Button) findViewById(R.id.button2_x);
        Button button3 = (Button) findViewById(R.id.button3_x);
        Button button4 = (Button) findViewById(R.id.button4_x);
        Button button5 = (Button) findViewById(R.id.button5_x);
        Button button6 = (Button) findViewById(R.id.button6_x);
        Button button7 = (Button) findViewById(R.id.button7_x);
        Button button8 = (Button) findViewById(R.id.button8_x);
        Button button9 = (Button) findViewById(R.id.button9_x);
        Button button10 = (Button) findViewById(R.id.button10_x);
        Button button11 = (Button) findViewById(R.id.button11_x);
        Button button12 = (Button) findViewById(R.id.button12_x);
        Button button13 = (Button) findViewById(R.id.button13_x);
        Button button14 = (Button) findViewById(R.id.button14_x);
        Button button15 = (Button) findViewById(R.id.button15_x);

        button1.setX(saveX[1]);
        button1.setY(saveY[1]);

        button2.setX(saveX[2]);
        button2.setY(saveY[2]);

        button3.setX(saveX[3]);
        button3.setY(saveY[3]);

        button4.setX(saveX[4]);
        button4.setY(saveY[4]);

        button5.setX(saveX[5]);
        button5.setY(saveY[5]);

        button6.setX(saveX[6]);
        button6.setY(saveY[6]);

        button7.setX(saveX[7]);
        button7.setY(saveY[7]);

        button8.setX(saveX[8]);
        button8.setY(saveY[8]);

        button9.setX(saveX[9]);
        button9.setY(saveY[9]);

        button10.setX(saveX[10]);
        button10.setY(saveY[10]);

        button11.setX(saveX[11]);
        button11.setY(saveY[11]);

        button12.setX(saveX[12]);
        button12.setY(saveY[12]);

        button13.setX(saveX[13]);
        button13.setY(saveY[13]);

        button14.setX(saveX[14]);
        button14.setY(saveY[14]);

        button15.setX(saveX[15]);
        button15.setY(saveY[15]);

        Random random = new Random();
        int tmp = 1;
        int tmpX, tmpY;
        for (int i = 1; i < 16; i++) {
            tmp = random.nextInt(14) + 1;
            tmpX = saveX[tmp];
            tmpY = saveY[tmp];

            saveX[tmp] = saveX[i];
            saveY[tmp] = saveY[i];
            saveX[i] = tmpX;
            saveY[i] = tmpY;
        }

        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
        button10.setEnabled(false);
        button11.setEnabled(false);
        button12.setEnabled(false);
        button13.setEnabled(false);
        button14.setEnabled(false);
        button15.setEnabled(false);


        class startHandler implements Runnable {
            Button button1 = (Button) findViewById(R.id.button1_x);
            Button button2 = (Button) findViewById(R.id.button2_x);
            Button button3 = (Button) findViewById(R.id.button3_x);
            Button button4 = (Button) findViewById(R.id.button4_x);
            Button button5 = (Button) findViewById(R.id.button5_x);
            Button button6 = (Button) findViewById(R.id.button6_x);
            Button button7 = (Button) findViewById(R.id.button7_x);
            Button button8 = (Button) findViewById(R.id.button8_x);
            Button button9 = (Button) findViewById(R.id.button9_x);
            Button button10 = (Button) findViewById(R.id.button10_x);
            Button button11 = (Button) findViewById(R.id.button11_x);
            Button button12 = (Button) findViewById(R.id.button12_x);
            Button button13 = (Button) findViewById(R.id.button13_x);
            Button button14 = (Button) findViewById(R.id.button14_x);
            Button button15 = (Button) findViewById(R.id.button15_x);

            public void run() {
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button5.setEnabled(true);
                button6.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                button9.setEnabled(true);
                button10.setEnabled(true);
                button11.setEnabled(true);
                button12.setEnabled(true);
                button13.setEnabled(true);
                button14.setEnabled(true);
                button15.setEnabled(true);

                scaleAnimation(saveX[1], saveY[1], button1);
                scaleAnimation(saveX[2], saveY[2], button2);
                scaleAnimation(saveX[3], saveY[3], button3);
                scaleAnimation(saveX[4], saveY[4], button4);
                scaleAnimation(saveX[5], saveY[5], button5);
                scaleAnimation(saveX[6], saveY[6], button6);
                scaleAnimation(saveX[7], saveY[7], button7);
                scaleAnimation(saveX[8], saveY[8], button8);
                scaleAnimation(saveX[9], saveY[9], button9);
                scaleAnimation(saveX[10], saveY[10], button10);
                scaleAnimation(saveX[11], saveY[11], button11);
                scaleAnimation(saveX[12], saveY[12], button12);
                scaleAnimation(saveX[13], saveY[13], button13);
                scaleAnimation(saveX[14], saveY[14], button14);
                scaleAnimation(saveX[15], saveY[15], button15);

                TextView start = (TextView) findViewById(R.id.startTextX);
                alphaAnimation(start, 1250);
            }
        }

        Handler h = new Handler();
        TextView ready = (TextView) findViewById(R.id.readyTextX);
        alphaAnimation(ready, 3000);
        h.postDelayed(new startHandler(), 3100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__x);

        final Button button1 = (Button) findViewById(R.id.button1_x);
        final Button button2 = (Button) findViewById(R.id.button2_x);
        final Button button3 = (Button) findViewById(R.id.button3_x);
        final Button button4 = (Button) findViewById(R.id.button4_x);
        final Button button5 = (Button) findViewById(R.id.button5_x);
        final Button button6 = (Button) findViewById(R.id.button6_x);
        final Button button7 = (Button) findViewById(R.id.button7_x);
        final Button button8 = (Button) findViewById(R.id.button8_x);
        final Button button9 = (Button) findViewById(R.id.button9_x);
        final Button button10 = (Button) findViewById(R.id.button10_x);
        final Button button11 = (Button) findViewById(R.id.button11_x);
        final Button button12 = (Button) findViewById(R.id.button12_x);
        final Button button13 = (Button) findViewById(R.id.button13_x);
        final Button button14 = (Button) findViewById(R.id.button14_x);
        final Button button15 = (Button) findViewById(R.id.button15_x);

        Button finishButton1 = (Button) findViewById(R.id.finishButtonX);

        finishButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkAnswer = 0;

                if (button1.getX() == buttonLayoutX[1] && button1.getY() == buttonLayoutY[1])
                    checkAnswer++;
                if (button2.getX() == buttonLayoutX[2] && button2.getY() == buttonLayoutY[2])
                    checkAnswer++;
                if (button3.getX() == buttonLayoutX[3] && button3.getY() == buttonLayoutY[3])
                    checkAnswer++;
                if (button4.getX() == buttonLayoutX[4] && button4.getY() == buttonLayoutY[4])
                    checkAnswer++;
                if (button5.getX() == buttonLayoutX[5] && button5.getY() == buttonLayoutY[5])
                    checkAnswer++;
                if (button6.getX() == buttonLayoutX[6] && button6.getY() == buttonLayoutY[6])
                    checkAnswer++;
                if (button7.getX() == buttonLayoutX[7] && button7.getY() == buttonLayoutY[7])
                    checkAnswer++;
                if (button8.getX() == buttonLayoutX[8] && button8.getY() == buttonLayoutY[8])
                    checkAnswer++;
                if (button9.getX() == buttonLayoutX[9] && button9.getY() == buttonLayoutY[9])
                    checkAnswer++;
                if (button10.getX() == buttonLayoutX[10] && button10.getY() == buttonLayoutY[10])
                    checkAnswer++;
                if (button11.getX() == buttonLayoutX[11] && button11.getY() == buttonLayoutY[11])
                    checkAnswer++;
                if (button12.getX() == buttonLayoutX[12] && button12.getY() == buttonLayoutY[12])
                    checkAnswer++;
                if (button13.getX() == buttonLayoutX[13] && button13.getY() == buttonLayoutY[13])
                    checkAnswer++;
                if (button14.getX() == buttonLayoutX[14] && button14.getY() == buttonLayoutY[14])
                    checkAnswer++;
                if (button15.getX() == buttonLayoutX[15] && button15.getY() == buttonLayoutY[15])
                    checkAnswer++;

                if (checkAnswer == 15) {
                    finish();
                }
            }
        });

        getStandardSize();

        buttonLength = standardSize_X / 5;
        saveLastLine = (standardSize_X / 5) * 5;

        button1.setWidth((int) buttonLength);
        button1.setHeight((int) buttonLength);

        button2.setWidth((int) buttonLength);
        button2.setHeight((int) buttonLength);

        button3.setWidth((int) buttonLength);
        button3.setHeight((int) buttonLength);

        button4.setWidth((int) buttonLength);
        button4.setHeight((int) buttonLength);

        button5.setWidth((int) buttonLength);
        button5.setHeight((int) buttonLength);

        button6.setWidth((int) buttonLength);
        button6.setHeight((int) buttonLength);

        button7.setWidth((int) buttonLength);
        button7.setHeight((int) buttonLength);

        button8.setWidth((int) buttonLength);
        button8.setHeight((int) buttonLength);

        button9.setWidth((int) buttonLength);
        button9.setHeight((int) buttonLength);

        button10.setWidth((int) buttonLength);
        button10.setHeight((int) buttonLength);

        button11.setWidth((int) buttonLength);
        button11.setHeight((int) buttonLength);

        button12.setWidth((int) buttonLength);
        button12.setHeight((int) buttonLength);

        button13.setWidth((int) buttonLength);
        button13.setHeight((int) buttonLength);

        button14.setWidth((int) buttonLength);
        button14.setHeight((int) buttonLength);

        button15.setWidth((int) buttonLength);
        button15.setHeight((int) buttonLength);

        buttonLayoutX[1] = 0;
        buttonLayoutY[1] = 0;

        buttonLayoutX[2] = (int)buttonLength;
        buttonLayoutY[2] = 0;

        buttonLayoutX[3] = (int)buttonLength*3;
        buttonLayoutY[3] = 0;

        buttonLayoutX[4] = (int)buttonLength*4;
        buttonLayoutY[4] = 0;

        buttonLayoutX[5] = (int)buttonLength;
        buttonLayoutY[5] = (int)buttonLength;

        buttonLayoutX[6] = (int)buttonLength*2;
        buttonLayoutY[6] = (int)buttonLength;

        buttonLayoutX[7] = (int)buttonLength*3;
        buttonLayoutY[7] = (int)buttonLength;

        buttonLayoutX[8] = (int)buttonLength*2;
        buttonLayoutY[8] = (int)buttonLength*2;

        buttonLayoutX[9] = (int)buttonLength;
        buttonLayoutY[9] = (int)buttonLength*3;

        buttonLayoutX[10] = (int)buttonLength*2;
        buttonLayoutY[10] = (int)buttonLength*3;

        buttonLayoutX[11] = (int)buttonLength*3;
        buttonLayoutY[11] = (int)buttonLength*3;

        buttonLayoutX[12] = 0;
        buttonLayoutY[12] = (int)buttonLength*4;

        buttonLayoutX[13] = (int)buttonLength;
        buttonLayoutY[13] = (int)buttonLength*4;

        buttonLayoutX[14] = (int)buttonLength*3;
        buttonLayoutY[14] = (int)buttonLength*4;

        buttonLayoutX[15] = (int)buttonLength*4;
        buttonLayoutY[15] = (int)buttonLength*4;

        button1.setBackgroundColor(getResources().getColor(R.color.cx_1_1));
        button2.setBackgroundColor(getResources().getColor(R.color.cx_1_2));
        button3.setBackgroundColor(getResources().getColor(R.color.cx_1_3));
        button4.setBackgroundColor(getResources().getColor(R.color.cx_1_4));
        button5.setBackgroundColor(getResources().getColor(R.color.cx_1_5));
        button6.setBackgroundColor(getResources().getColor(R.color.cx_1_6));
        button7.setBackgroundColor(getResources().getColor(R.color.cx_1_7));
        button8.setBackgroundColor(getResources().getColor(R.color.cx_1_8));
        button9.setBackgroundColor(getResources().getColor(R.color.cx_1_9));
        button10.setBackgroundColor(getResources().getColor(R.color.cx_1_10));
        button11.setBackgroundColor(getResources().getColor(R.color.cx_1_11));
        button12.setBackgroundColor(getResources().getColor(R.color.cx_1_12));
        button13.setBackgroundColor(getResources().getColor(R.color.cx_1_13));
        button14.setBackgroundColor(getResources().getColor(R.color.cx_1_14));
        button15.setBackgroundColor(getResources().getColor(R.color.cx_1_15));


        button1.setOnTouchListener(this);
        button2.setOnTouchListener(this);
        button3.setOnTouchListener(this);
        button4.setOnTouchListener(this);
        button5.setOnTouchListener(this);
        button6.setOnTouchListener(this);
        button7.setOnTouchListener(this);
        button8.setOnTouchListener(this);
        button9.setOnTouchListener(this);
        button10.setOnTouchListener(this);
        button11.setOnTouchListener(this);
        button12.setOnTouchListener(this);
        button13.setOnTouchListener(this);
        button14.setOnTouchListener(this);
        button15.setOnTouchListener(this);
        System.out.println("CREATE button1 getX : " + button1.getX() + " getY : " + button1.getY());

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int parentWidth = ((ViewGroup) v.getParent()).getWidth();    // 부모 View 의 Width
        int parentHeight = ((ViewGroup) v.getParent()).getHeight();    // 부모 View 의 Height

        Button button1 = (Button) findViewById(R.id.button1_x);
        Button button2 = (Button) findViewById(R.id.button2_x);
        Button button3 = (Button) findViewById(R.id.button3_x);
        Button button4 = (Button) findViewById(R.id.button4_x);
        Button button5 = (Button) findViewById(R.id.button5_x);
        Button button6 = (Button) findViewById(R.id.button6_x);
        Button button7 = (Button) findViewById(R.id.button7_x);
        Button button8 = (Button) findViewById(R.id.button8_x);
        Button button9 = (Button) findViewById(R.id.button9_x);
        Button button10 = (Button) findViewById(R.id.button10_x);
        Button button11 = (Button) findViewById(R.id.button11_x);
        Button button12 = (Button) findViewById(R.id.button12_x);
        Button button13 = (Button) findViewById(R.id.button13_x);
        Button button14 = (Button) findViewById(R.id.button14_x);
        Button button15 = (Button) findViewById(R.id.button15_x);

        if (saveX == -1)
            saveX = v.getX();
        if (saveY == -1)
            saveY = v.getY();

        v.bringToFront();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            System.out.println("button1 getX : " + button1.getX() + " getY : " + button1.getY());
            // 뷰 누름
            oldXvalue = event.getX();
            oldYvalue = event.getY();
            Log.d("viewTest", "oldXvalue : " + oldXvalue + " oldYvalue : " + oldYvalue);    // View 내부에서 터치한 지점의 상대 좌표값.
            Log.d("viewTest", "v.getX() : " + v.getX());    // View 의 좌측 상단이 되는 지점의 절대 좌표값.
            Log.d("viewTest", "RawX : " + event.getRawX() + " RawY : " + event.getRawY());    // View 를 터치한 지점의 절대 좌표값.
            Log.d("viewTest", "v.getHeight : " + v.getHeight() + " v.getWidth : " + v.getWidth());    // View 의 Width, Height
            Log.d("save", "saveX : " + saveX + " saveY : " + saveY + "  buttonX : " + buttonLayoutX[1] + " buttonY : " + buttonLayoutY[1]);


        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            // 뷰 이동 중
            v.setX(v.getX() + (event.getX()) - (v.getWidth() / 2));
            v.setY(v.getY() + (event.getY()) - (v.getHeight() / 2));

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            System.out.println("button1 getX : " + button1.getX() + " getY : " + button1.getY());
            // 뷰에서 손을 뗌
            System.out.println("X : " + v.getX() + " Y : " + v.getY());
            if (v.getY() > saveLastLine) {
                v.setX(saveX);
                v.setY(saveY);
                saveX = saveY = -1;
                return true;
            }
            int check = -1;
            if (buttonLayoutX[1] <= v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[1] + buttonLength &&
                    buttonLayoutY[1] <= v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[1] + buttonLength &&
                    (saveX != buttonLayoutX[1] || saveY != buttonLayoutY[1])) {
                check = 1;
            } else if (buttonLayoutX[2] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[2] + buttonLength &&
                    buttonLayoutY[2] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[2] + buttonLength &&
                    (saveX != buttonLayoutX[2] || saveY != buttonLayoutY[2])) {
                check = 2;
            } else if (buttonLayoutX[3] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[3] + buttonLength &&
                    buttonLayoutY[3] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[3] + buttonLength &&
                    (saveX != buttonLayoutX[3] || saveY != buttonLayoutY[3])) {
                check = 3;
            } else if (buttonLayoutX[4] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 <= buttonLayoutX[4] + buttonLength &&
                    buttonLayoutY[4] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[4] + buttonLength &&
                    (saveX != buttonLayoutX[4] || saveY != buttonLayoutY[4])) {
                check = 4;
            } else if (buttonLayoutX[5] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[5] + buttonLength &&
                    buttonLayoutY[5] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[5] + buttonLength &&
                    (saveX != buttonLayoutX[5] || saveY != buttonLayoutY[5])) {
                check = 5;
            } else if (buttonLayoutX[6] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[6] + buttonLength &&
                    buttonLayoutY[6] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[6] + buttonLength &&
                    (saveX != buttonLayoutX[6] || saveY != buttonLayoutY[6])) {
                check = 6;
            } else if (buttonLayoutX[7] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[7] + buttonLength &&
                    buttonLayoutY[7] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[7] + buttonLength &&
                    (saveX != buttonLayoutX[7] || saveY != buttonLayoutY[7])) {
                check = 7;
            } else if (buttonLayoutX[8] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[8] + buttonLength &&
                    buttonLayoutY[8] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[8] + buttonLength &&
                    (saveX != buttonLayoutX[8] || saveY != buttonLayoutY[8])) {
                check = 8;
            } else if (buttonLayoutX[9] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[9] + buttonLength &&
                    buttonLayoutY[9] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[9] + buttonLength &&
                    (saveX != buttonLayoutX[9] || saveY != buttonLayoutY[9])) {
                check = 9;
            } else if (buttonLayoutX[10] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[10] + buttonLength &&
                    buttonLayoutY[10] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[10] + buttonLength &&
                    (saveX != buttonLayoutX[10] || saveY != buttonLayoutY[10])) {
                check = 10;
            } else if (buttonLayoutX[11] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[11] + buttonLength &&
                    buttonLayoutY[11] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[11] + buttonLength &&
                    (saveX != buttonLayoutX[11] || saveY != buttonLayoutY[11])) {
                check = 11;
            } else if (buttonLayoutX[12] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[12] + buttonLength &&
                    buttonLayoutY[12] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[12] + buttonLength &&
                    (saveX != buttonLayoutX[12] || saveY != buttonLayoutY[12])) {
                check = 12;
            } else if (buttonLayoutX[13] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[13] + buttonLength &&
                    buttonLayoutY[13] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[13] + buttonLength &&
                    (saveX != buttonLayoutX[13] || saveY != buttonLayoutY[13])) {
                check = 13;
            } else if (buttonLayoutX[14] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[14] + buttonLength &&
                    buttonLayoutY[14] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[14] + buttonLength &&
                    (saveX != buttonLayoutX[14] || saveY != buttonLayoutY[14])) {
                check = 14;
            } else if (buttonLayoutX[15] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[15] + buttonLength &&
                    buttonLayoutY[15] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[15] + buttonLength &&
                    (saveX != buttonLayoutX[15] || saveY != buttonLayoutY[15])) {
                check = 15;
            }


            System.out.println("check : " + check);

            if (check == -1) {
                v.setX(saveX);
                v.setY(saveY);
                saveX = saveY = -1;
            } else if (button1.getX() == buttonLayoutX[check] && button1.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button1);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button2.getX() == buttonLayoutX[check] && button2.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button2);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button3.getX() == buttonLayoutX[check] && button3.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button3);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button4.getX() == buttonLayoutX[check] && button4.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button4);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button5.getX() == buttonLayoutX[check] && button5.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button5);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button6.getX() == buttonLayoutX[check] && button6.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button6);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button7.getX() == buttonLayoutX[check] && button7.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button7);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button8.getX() == buttonLayoutX[check] && button8.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button8);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button9.getX() == buttonLayoutX[check] && button9.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button9);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button10.getX() == buttonLayoutX[check] && button10.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button10);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button11.getX() == buttonLayoutX[check] && button11.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button11);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button12.getX() == buttonLayoutX[check] && button12.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button12);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button13.getX() == buttonLayoutX[check] && button13.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button13);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button14.getX() == buttonLayoutX[check] && button14.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button14);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button15.getX() == buttonLayoutX[check] && button15.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button15);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            }

            saveX = saveY = -1;

            System.out.println("OUT button1 getX : " + button1.getX() + " getY : " + button1.getY());
        }


        return true;
    }
}
