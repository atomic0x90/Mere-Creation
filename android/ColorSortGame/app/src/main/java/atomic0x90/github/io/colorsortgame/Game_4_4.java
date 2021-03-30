package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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

public class Game_4_4 extends AppCompatActivity implements View.OnTouchListener {

    float oldXvalue, oldYvalue;
    int standardSize_X, standardSize_Y;
    float density;
    float saveX = -1;
    float saveY = -1;

    float saveLastLine;
    float[] buttonLayoutX = new float[17];
    float[] buttonLayoutY = new float[17];
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
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button6 = (Button) findViewById(R.id.button6);
        final Button button7 = (Button) findViewById(R.id.button7);
        final Button button8 = (Button) findViewById(R.id.button8);
        final Button button9 = (Button) findViewById(R.id.button9);
        final Button button10 = (Button) findViewById(R.id.button10);
        final Button button11 = (Button) findViewById(R.id.button11);
        final Button button12 = (Button) findViewById(R.id.button12);
        final Button button13 = (Button) findViewById(R.id.button13);
        final Button button14 = (Button) findViewById(R.id.button14);
        final Button button15 = (Button) findViewById(R.id.button15);
        final Button button16 = (Button) findViewById(R.id.button16);

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
        button16.setEnabled(false);

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
                        button16.setEnabled(true);
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

        final int[] saveX = new int[17];
        final int[] saveY = new int[17];

        for (int i = 1; i < 17; i++) {
            if (1 <= i && i <= 4) {
                saveY[i] = 0;
            } else if (i <= 8) {
                saveY[i] = (int) buttonLength;
            } else if (i <= 12) {
                saveY[i] = (int) buttonLength * 2;
            } else if (i <= 16) {
                saveY[i] = (int) buttonLength * 3;
            }

            if (i % 4 == 1)
                saveX[i] = 0;
            else if (i % 4 == 2)
                saveX[i] = (int) buttonLength;
            else if (i % 4 == 3)
                saveX[i] = (int) buttonLength * 2;
            else if (i % 4 == 0)
                saveX[i] = (int) buttonLength * 3;
        }

        Random random = new Random();
        int tmp = 1;
        int tmpX, tmpY;
        for (int i = 1; i < 17; i++) {
            tmp = random.nextInt(15) + 1;
            tmpX = saveX[tmp];
            tmpY = saveY[tmp];

            saveX[tmp] = saveX[i];
            saveY[tmp] = saveY[i];
            saveX[i] = tmpX;
            saveY[i] = tmpY;
        }


        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button10 = (Button) findViewById(R.id.button10);
        Button button11 = (Button) findViewById(R.id.button11);
        Button button12 = (Button) findViewById(R.id.button12);
        Button button13 = (Button) findViewById(R.id.button13);
        Button button14 = (Button) findViewById(R.id.button14);
        Button button15 = (Button) findViewById(R.id.button15);
        Button button16 = (Button) findViewById(R.id.button16);

        button1.setX(0);
        button1.setY(0);

        button2.setX((int) buttonLength);
        button2.setY(0);

        button3.setX(((int) buttonLength) * 2);
        button3.setY(0);

        button4.setX(((int) buttonLength) * 3);
        button4.setY(0);

        button5.setX(0);
        button5.setY((int) buttonLength);

        button6.setX((int) buttonLength);
        button6.setY((int) buttonLength);

        button7.setX(((int) buttonLength) * 2);
        button7.setY((int) buttonLength);

        button8.setX(((int) buttonLength) * 3);
        button8.setY((int) buttonLength);

        button9.setX(0);
        button9.setY(((int) buttonLength) * 2);

        button10.setX((int) buttonLength);
        button10.setY(((int) buttonLength) * 2);

        button11.setX(((int) buttonLength) * 2);
        button11.setY(((int) buttonLength) * 2);

        button12.setX(((int) buttonLength) * 3);
        button12.setY(((int) buttonLength) * 2);

        button13.setX(0);
        button13.setY(((int) buttonLength) * 3);

        button14.setX((int) buttonLength);
        button14.setY(((int) buttonLength) * 3);

        button15.setX(((int) buttonLength) * 2);
        button15.setY(((int) buttonLength) * 3);

        button16.setX(((int) buttonLength) * 3);
        button16.setY(((int) buttonLength) * 3);

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
        button16.setEnabled(false);

        class startHandler implements Runnable {
            Button button1 = (Button) findViewById(R.id.button1);
            Button button2 = (Button) findViewById(R.id.button2);
            Button button3 = (Button) findViewById(R.id.button3);
            Button button4 = (Button) findViewById(R.id.button4);
            Button button5 = (Button) findViewById(R.id.button5);
            Button button6 = (Button) findViewById(R.id.button6);
            Button button7 = (Button) findViewById(R.id.button7);
            Button button8 = (Button) findViewById(R.id.button8);
            Button button9 = (Button) findViewById(R.id.button9);
            Button button10 = (Button) findViewById(R.id.button10);
            Button button11 = (Button) findViewById(R.id.button11);
            Button button12 = (Button) findViewById(R.id.button12);
            Button button13 = (Button) findViewById(R.id.button13);
            Button button14 = (Button) findViewById(R.id.button14);
            Button button15 = (Button) findViewById(R.id.button15);
            Button button16 = (Button) findViewById(R.id.button16);

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
                button16.setEnabled(true);
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

                scaleAnimation(saveX[16], saveY[16], button16);
                TextView start = (TextView) findViewById(R.id.startText);
                alphaAnimation(start, 1250);
            }
        }

        Handler h = new Handler();
        TextView ready = (TextView) findViewById(R.id.readyText);
        alphaAnimation(ready, 3000);
        h.postDelayed(new startHandler(), 3100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_4_4);

        Intent nowIntent = getIntent();
        int LV = nowIntent.getIntExtra("LV",0);

        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button6 = (Button) findViewById(R.id.button6);
        final Button button7 = (Button) findViewById(R.id.button7);
        final Button button8 = (Button) findViewById(R.id.button8);
        final Button button9 = (Button) findViewById(R.id.button9);
        final Button button10 = (Button) findViewById(R.id.button10);
        final Button button11 = (Button) findViewById(R.id.button11);
        final Button button12 = (Button) findViewById(R.id.button12);
        final Button button13 = (Button) findViewById(R.id.button13);
        final Button button14 = (Button) findViewById(R.id.button14);
        final Button button15 = (Button) findViewById(R.id.button15);
        final Button button16 = (Button) findViewById(R.id.button16);

        Button finishButton1 = (Button) findViewById(R.id.finishButton1);

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
                if (button16.getX() == buttonLayoutX[16] && button16.getY() == buttonLayoutY[16])
                    checkAnswer++;
                
                if (checkAnswer == 16) {
                    finish();
                }
            }
        });

        getStandardSize();

        buttonLength = standardSize_X / 4;
        saveLastLine = (standardSize_X / 4) * 4;

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

        button16.setWidth((int) buttonLength);
        button16.setHeight((int) buttonLength);

        for (int i = 1; i <= 16; i++) {
            if (i < 5)
                buttonLayoutY[i] = 0;
            else if (5 <= i && i < 9)
                buttonLayoutY[i] = buttonLength;
            else if (9 <= i && i < 13)
                buttonLayoutY[i] = buttonLength * 2;
            else if (13 <= i && i < 17)
                buttonLayoutY[i] = buttonLength * 3;

            if (i % 4 == 1)
                buttonLayoutX[i] = 0;
            else if (i % 4 == 2)
                buttonLayoutX[i] = buttonLength;
            else if (i % 4 == 3)
                buttonLayoutX[i] = buttonLength * 2;
            else if (i % 4 == 0)
                buttonLayoutX[i] = buttonLength * 3;

            System.out.println(buttonLayoutX[i] + " " + buttonLayoutY[i]);
        }

        if(LV == 1) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_1_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_1_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_1_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_1_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_1_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_1_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_1_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_1_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_1_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_1_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_1_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_1_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_1_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_1_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_1_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_1_4_4));
        }
        else if(LV == 2) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_2_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_2_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_2_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_2_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_2_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_2_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_2_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_2_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_2_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_2_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_2_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_2_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_2_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_2_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_2_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_2_4_4));
        }
        else if(LV == 3) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_3_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_3_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_3_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_3_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_3_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_3_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_3_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_3_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_3_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_3_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_3_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_3_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_3_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_3_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_3_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_3_4_4));
        }
        else if(LV == 4) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_4_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_4_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_4_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_4_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_4_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_4_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_4_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_4_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_4_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_4_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_4_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_4_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_4_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_4_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_4_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_4_4_4));
        }
        else if(LV == 5) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_5_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_5_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_5_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_5_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_5_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_5_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_5_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_5_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_5_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_5_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_5_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_5_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_5_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_5_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_5_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_5_4_4));
        }
        else if(LV == 6) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_6_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_6_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_6_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_6_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_6_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_6_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_6_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_6_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_6_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_6_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_6_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_6_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_6_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_6_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_6_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_6_4_4));
        }
        else if(LV == 7) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_7_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_7_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_7_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_7_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_7_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_7_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_7_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_7_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_7_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_7_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_7_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_7_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_7_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_7_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_7_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_7_4_4));
        }
        else if(LV == 8) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_8_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_8_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_8_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_8_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_8_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_8_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_8_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_8_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_8_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_8_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_8_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_8_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_8_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_8_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_8_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_8_4_4));
        }
        else if(LV == 9) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_9_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_9_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_9_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_9_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_9_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_9_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_9_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_9_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_9_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_9_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_9_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_9_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_9_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_9_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_9_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_9_4_4));
        }
        else if(LV == 10) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_10_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_10_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_10_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_10_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_10_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_10_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_10_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_10_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_10_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_10_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_10_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_10_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_10_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_10_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_10_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_10_4_4));
        }
        else if(LV == 11) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_11_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_11_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_11_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_11_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_11_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_11_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_11_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_11_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_11_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_11_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_11_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_11_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_11_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_11_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_11_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_11_4_4));
        }
        else if(LV == 12) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_12_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_12_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_12_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_12_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_12_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_12_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_12_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_12_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_12_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_12_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_12_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_12_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_12_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_12_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_12_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_12_4_4));
        }
        else if(LV == 13) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_13_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_13_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_13_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_13_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_13_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_13_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_13_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_13_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_13_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_13_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_13_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_13_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_13_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_13_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_13_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_13_4_4));
        }
        else if(LV == 14) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_14_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_14_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_14_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_14_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_14_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_14_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_14_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_14_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_14_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_14_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_14_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_14_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_14_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_14_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_14_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_14_4_4));
        }
        else if(LV == 15) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_15_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_15_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_15_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_15_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_15_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_15_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_15_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_15_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_15_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_15_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_15_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_15_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_15_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_15_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_15_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_15_4_4));
        }
        else if(LV == 16) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_16_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_16_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_16_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_16_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_16_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_16_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_16_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_16_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_16_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_16_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_16_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_16_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_16_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_16_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_16_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_16_4_4));
        }
        else if(LV == 17) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_17_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_17_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_17_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_17_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_17_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_17_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_17_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_17_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_17_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_17_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_17_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_17_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_17_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_17_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_17_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_17_4_4));
        }
        else if(LV == 18) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_18_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_18_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_18_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_18_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_18_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_18_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_18_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_18_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_18_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_18_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_18_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_18_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_18_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_18_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_18_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_18_4_4));
        }
        else if(LV == 19) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_19_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_19_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_19_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_19_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_19_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_19_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_19_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_19_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_19_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_19_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_19_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_19_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_19_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_19_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_19_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_19_4_4));
        }
        else if(LV == 20) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_20_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_20_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_20_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_20_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_20_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_20_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_20_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_20_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_20_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_20_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_20_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_20_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_20_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_20_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_20_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_20_4_4));
        }
        else if(LV == 21) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_21_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_21_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_21_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_21_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_21_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_21_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_21_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_21_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_21_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_21_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_21_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_21_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_21_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_21_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_21_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_21_4_4));
        }
        else if(LV == 22) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_22_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_22_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_22_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_22_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_22_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_22_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_22_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_22_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_22_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_22_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_22_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_22_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_22_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_22_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_22_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_22_4_4));
        }
        else if(LV == 23) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_23_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_23_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_23_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_23_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_23_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_23_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_23_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_23_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_23_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_23_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_23_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_23_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_23_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_23_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_23_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_23_4_4));
        }
        else if(LV == 24) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_24_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_24_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_24_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_24_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_24_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_24_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_24_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_24_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_24_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_24_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_24_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_24_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_24_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_24_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_24_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_24_4_4));
        }
        else if(LV == 25) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_25_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_25_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_25_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_25_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_25_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_25_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_25_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_25_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_25_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_25_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_25_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_25_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_25_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_25_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_25_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_25_4_4));
        }
        else if(LV == 26) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_26_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_26_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_26_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_26_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_26_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_26_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_26_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_26_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_26_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_26_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_26_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_26_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_26_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_26_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_26_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_26_4_4));
        }
        else if(LV == 27) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_27_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_27_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_27_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_27_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_27_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_27_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_27_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_27_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_27_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_27_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_27_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_27_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_27_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_27_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_27_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_27_4_4));
        }
        else if(LV == 28) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_28_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_28_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_28_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_28_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_28_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_28_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_28_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_28_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_28_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_28_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_28_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_28_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_28_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_28_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_28_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_28_4_4));
        }
        else if(LV == 29) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_29_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_29_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_29_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_29_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_29_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_29_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_29_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_29_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_29_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_29_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_29_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_29_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_29_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_29_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_29_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_29_4_4));
        }
        else if(LV == 30) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_30_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_30_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_30_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_30_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_30_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_30_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_30_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_30_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_30_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_30_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_30_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_30_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_30_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_30_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_30_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_30_4_4));
        }
        else if(LV == 31) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_31_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_31_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_31_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_31_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_31_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_31_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_31_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_31_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_31_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_31_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_31_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_31_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_31_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_31_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_31_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_31_4_4));
        }
        else if(LV == 32) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_32_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_32_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_32_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_32_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_32_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_32_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_32_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_32_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_32_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_32_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_32_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_32_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_32_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_32_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_32_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_32_4_4));
        }
        else if(LV == 33) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_33_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_33_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_33_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_33_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_33_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_33_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_33_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_33_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_33_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_33_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_33_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_33_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_33_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_33_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_33_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_33_4_4));
        }
        else if(LV == 34) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_34_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_34_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_34_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_34_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_34_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_34_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_34_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_34_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_34_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_34_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_34_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_34_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_34_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_34_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_34_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_34_4_4));
        }
        else if(LV == 35) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_35_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_35_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_35_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_35_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_35_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_35_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_35_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_35_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_35_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_35_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_35_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_35_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_35_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_35_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_35_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_35_4_4));
        }
        else if(LV == 36) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_36_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_36_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_36_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_36_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_36_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_36_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_36_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_36_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_36_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_36_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_36_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_36_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_36_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_36_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_36_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_36_4_4));
        }
        else if(LV == 37) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_37_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_37_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_37_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_37_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_37_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_37_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_37_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_37_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_37_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_37_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_37_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_37_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_37_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_37_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_37_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_37_4_4));
        }
        else if(LV == 38) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_38_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_38_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_38_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_38_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_38_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_38_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_38_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_38_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_38_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_38_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_38_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_38_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_38_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_38_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_38_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_38_4_4));
        }
        else if(LV == 39) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_39_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_39_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_39_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_39_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_39_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_39_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_39_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_39_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_39_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_39_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_39_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_39_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_39_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_39_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_39_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_39_4_4));
        }
        else if(LV == 40) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_40_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_40_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_40_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_40_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_40_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_40_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_40_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_40_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_40_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_40_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_40_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_40_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_40_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_40_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_40_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_40_4_4));
        }
        else if(LV == 41) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_41_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_41_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_41_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_41_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_41_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_41_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_41_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_41_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_41_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_41_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_41_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_41_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_41_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_41_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_41_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_41_4_4));
        }
        else if(LV == 42) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_42_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_42_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_42_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_42_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_42_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_42_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_42_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_42_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_42_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_42_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_42_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_42_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_42_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_42_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_42_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_42_4_4));
        }
        else if(LV == 43) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_43_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_43_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_43_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_43_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_43_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_43_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_43_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_43_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_43_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_43_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_43_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_43_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_43_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_43_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_43_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_43_4_4));
        }
        else if(LV == 44) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_44_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_44_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_44_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_44_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_44_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_44_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_44_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_44_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_44_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_44_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_44_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_44_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_44_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_44_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_44_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_44_4_4));
        }
        else if(LV == 45) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_45_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_45_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_45_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_45_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_45_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_45_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_45_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_45_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_45_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_45_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_45_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_45_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_45_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_45_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_45_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_45_4_4));
        }
        else if(LV == 46) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_46_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_46_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_46_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_46_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_46_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_46_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_46_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_46_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_46_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_46_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_46_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_46_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_46_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_46_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_46_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_46_4_4));
        }
        else if(LV == 47) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_47_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_47_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_47_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_47_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_47_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_47_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_47_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_47_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_47_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_47_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_47_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_47_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_47_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_47_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_47_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_47_4_4));
        }
        else if(LV == 48) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_48_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_48_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_48_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_48_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_48_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_48_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_48_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_48_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_48_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_48_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_48_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_48_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_48_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_48_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_48_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_48_4_4));
        }
        else if(LV == 49) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_49_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_49_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_49_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_49_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_49_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_49_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_49_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_49_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_49_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_49_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_49_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_49_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_49_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_49_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_49_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_49_4_4));
        }
        else if(LV == 50) {
            button1.setBackgroundColor(getResources().getColor(R.color.c4_4_50_1_1));
            button2.setBackgroundColor(getResources().getColor(R.color.c4_4_50_1_2));
            button3.setBackgroundColor(getResources().getColor(R.color.c4_4_50_1_3));
            button4.setBackgroundColor(getResources().getColor(R.color.c4_4_50_1_4));
            button5.setBackgroundColor(getResources().getColor(R.color.c4_4_50_2_1));
            button6.setBackgroundColor(getResources().getColor(R.color.c4_4_50_2_2));
            button7.setBackgroundColor(getResources().getColor(R.color.c4_4_50_2_3));
            button8.setBackgroundColor(getResources().getColor(R.color.c4_4_50_2_4));
            button9.setBackgroundColor(getResources().getColor(R.color.c4_4_50_3_1));
            button10.setBackgroundColor(getResources().getColor(R.color.c4_4_50_3_2));
            button11.setBackgroundColor(getResources().getColor(R.color.c4_4_50_3_3));
            button12.setBackgroundColor(getResources().getColor(R.color.c4_4_50_3_4));
            button13.setBackgroundColor(getResources().getColor(R.color.c4_4_50_4_1));
            button14.setBackgroundColor(getResources().getColor(R.color.c4_4_50_4_2));
            button15.setBackgroundColor(getResources().getColor(R.color.c4_4_50_4_3));
            button16.setBackgroundColor(getResources().getColor(R.color.c4_4_50_4_4));
        }

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
        button16.setOnTouchListener(this);
        System.out.println("CREATE button1 getX : " + button1.getX() + " getY : " + button1.getY());

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int parentWidth = ((ViewGroup) v.getParent()).getWidth();    // 부모 View 의 Width
        int parentHeight = ((ViewGroup) v.getParent()).getHeight();    // 부모 View 의 Height

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button10 = (Button) findViewById(R.id.button10);
        Button button11 = (Button) findViewById(R.id.button11);
        Button button12 = (Button) findViewById(R.id.button12);
        Button button13 = (Button) findViewById(R.id.button13);
        Button button14 = (Button) findViewById(R.id.button14);
        Button button15 = (Button) findViewById(R.id.button15);
        Button button16 = (Button) findViewById(R.id.button16);

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
            } else if (buttonLayoutX[16] < v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[16] + buttonLength &&
                    buttonLayoutY[16] < v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[16] + buttonLength &&
                    (saveX != buttonLayoutX[16] || saveY != buttonLayoutY[16])) {
                check = 16;
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
            } else if (button16.getX() == buttonLayoutX[check] && button16.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button16);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            }

            saveX = saveY = -1;

            System.out.println("OUT button1 getX : " + button1.getX() + " getY : " + button1.getY());
        }


        return true;
    }
}