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


public class Game_5_5 extends AppCompatActivity implements View.OnTouchListener {
    float oldXvalue, oldYvalue;
    int standardSize_X, standardSize_Y;
    float density;
    float saveX = -1;
    float saveY = -1;

    float saveLastLine;
    float[] buttonLayoutX = new float[26];
    float[] buttonLayoutY = new float[26];
    float buttonLength;

    public Point getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        System.out.println("size "+size);
        return size;
    }

    public void getStandardSize() {
        Point ScreenSize = getScreenSize(this);
        density = getResources().getDisplayMetrics().density;

        standardSize_X = (int) (ScreenSize.x / density);
        standardSize_Y = (int) (ScreenSize.y / density);

        System.out.println("den "+density+" "+standardSize_X+" "+standardSize_Y);
    }


    public void scaleAnimation(final float x, final float y, final Button button) {
        final Button button1 = (Button) findViewById(R.id.button1_5_5);
        final Button button2 = (Button) findViewById(R.id.button2_5_5);
        final Button button3 = (Button) findViewById(R.id.button3_5_5);
        final Button button4 = (Button) findViewById(R.id.button4_5_5);
        final Button button5 = (Button) findViewById(R.id.button5_5_5);
        final Button button6 = (Button) findViewById(R.id.button6_5_5);
        final Button button7 = (Button) findViewById(R.id.button7_5_5);
        final Button button8 = (Button) findViewById(R.id.button8_5_5);
        final Button button9 = (Button) findViewById(R.id.button9_5_5);
        final Button button10 = (Button) findViewById(R.id.button10_5_5);
        final Button button11 = (Button) findViewById(R.id.button11_5_5);
        final Button button12 = (Button) findViewById(R.id.button12_5_5);
        final Button button13 = (Button) findViewById(R.id.button13_5_5);
        final Button button14 = (Button) findViewById(R.id.button14_5_5);
        final Button button15 = (Button) findViewById(R.id.button15_5_5);
        final Button button16 = (Button) findViewById(R.id.button16_5_5);
        final Button button17 = (Button) findViewById(R.id.button17_5_5);
        final Button button18 = (Button) findViewById(R.id.button18_5_5);
        final Button button19 = (Button) findViewById(R.id.button19_5_5);
        final Button button20 = (Button) findViewById(R.id.button20_5_5);
        final Button button21 = (Button) findViewById(R.id.button21_5_5);
        final Button button22 = (Button) findViewById(R.id.button22_5_5);
        final Button button23 = (Button) findViewById(R.id.button23_5_5);
        final Button button24 = (Button) findViewById(R.id.button24_5_5);
        final Button button25 = (Button) findViewById(R.id.button25_5_5);

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
        button17.setEnabled(false);
        button18.setEnabled(false);
        button19.setEnabled(false);
        button20.setEnabled(false);
        button21.setEnabled(false);
        button22.setEnabled(false);
        button23.setEnabled(false);
        button24.setEnabled(false);
        button25.setEnabled(false);


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
                        button17.setEnabled(true);
                        button18.setEnabled(true);
                        button19.setEnabled(true);
                        button20.setEnabled(true);
                        button21.setEnabled(true);
                        button22.setEnabled(true);
                        button23.setEnabled(true);
                        button24.setEnabled(true);
                        button25.setEnabled(true);
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

        final int[] saveX = new int[26];
        final int[] saveY = new int[26];

        for (int i = 1; i < 26; i++) {
            if (1 <= i && i <= 5) {
                saveY[i] = 0;
            } else if (i <= 10) {
                saveY[i] = (int) buttonLength;
            } else if (i <= 15) {
                saveY[i] = (int) buttonLength * 2;
            } else if (i <= 20) {
                saveY[i] = (int) buttonLength * 3;
            } else if(i <= 25){
                saveY[i] = (int) buttonLength * 4;
            }

            if (i % 5 == 1)
                saveX[i] = 0;
            else if (i % 5 == 2)
                saveX[i] = (int) buttonLength;
            else if (i % 5 == 3)
                saveX[i] = (int) buttonLength * 2;
            else if (i % 5 == 4)
                saveX[i] = (int) buttonLength * 3;
            else if (i % 5 == 0)
                saveX[i] = (int) buttonLength * 4;
        }

        Random random = new Random();
        int tmp = 1;
        int tmpX, tmpY;
        for (int i = 1; i < 26; i++) {
            tmp = random.nextInt(24) + 1;
            tmpX = saveX[tmp];
            tmpY = saveY[tmp];

            saveX[tmp] = saveX[i];
            saveY[tmp] = saveY[i];
            saveX[i] = tmpX;
            saveY[i] = tmpY;
        }


        Button button1 = (Button) findViewById(R.id.button1_5_5);
        Button button2 = (Button) findViewById(R.id.button2_5_5);
        Button button3 = (Button) findViewById(R.id.button3_5_5);
        Button button4 = (Button) findViewById(R.id.button4_5_5);
        Button button5 = (Button) findViewById(R.id.button5_5_5);
        Button button6 = (Button) findViewById(R.id.button6_5_5);
        Button button7 = (Button) findViewById(R.id.button7_5_5);
        Button button8 = (Button) findViewById(R.id.button8_5_5);
        Button button9 = (Button) findViewById(R.id.button9_5_5);
        Button button10 = (Button) findViewById(R.id.button10_5_5);
        Button button11 = (Button) findViewById(R.id.button11_5_5);
        Button button12 = (Button) findViewById(R.id.button12_5_5);
        Button button13 = (Button) findViewById(R.id.button13_5_5);
        Button button14 = (Button) findViewById(R.id.button14_5_5);
        Button button15 = (Button) findViewById(R.id.button15_5_5);
        Button button16 = (Button) findViewById(R.id.button16_5_5);
        Button button17 = (Button) findViewById(R.id.button17_5_5);
        Button button18 = (Button) findViewById(R.id.button18_5_5);
        Button button19 = (Button) findViewById(R.id.button19_5_5);
        Button button20 = (Button) findViewById(R.id.button20_5_5);
        Button button21 = (Button) findViewById(R.id.button21_5_5);
        Button button22 = (Button) findViewById(R.id.button22_5_5);
        Button button23 = (Button) findViewById(R.id.button23_5_5);
        Button button24 = (Button) findViewById(R.id.button24_5_5);
        Button button25 = (Button) findViewById(R.id.button25_5_5);

        button1.setX(0);
        button1.setY(0);

        button2.setX((int) buttonLength);
        button2.setY(0);

        button3.setX(((int) buttonLength) * 2);
        button3.setY(0);

        button4.setX(((int) buttonLength) * 3);
        button4.setY(0);

        button5.setX((int) buttonLength*4);
        button5.setY(0);

        button6.setX(0);
        button6.setY((int) buttonLength);

        button7.setX(((int) buttonLength));
        button7.setY((int) buttonLength);

        button8.setX(((int) buttonLength) * 2);
        button8.setY((int) buttonLength);

        button9.setX((int) buttonLength*3);
        button9.setY(((int) buttonLength));

        button10.setX((int) buttonLength*4);
        button10.setY(((int) buttonLength));

        button11.setX(0);
        button11.setY(((int) buttonLength)*2);

        button12.setX((int) buttonLength);
        button12.setY(((int) buttonLength) * 2);

        button13.setX((int) buttonLength*2);
        button13.setY(((int) buttonLength) * 2);

        button14.setX((int) buttonLength*3);
        button14.setY(((int) buttonLength) * 2);

        button15.setX(((int) buttonLength) * 4);
        button15.setY(((int) buttonLength) * 2);

        button16.setX(0);
        button16.setY(((int) buttonLength) * 3);

        button17.setX((int) buttonLength);
        button17.setY((int) buttonLength*3);

        button18.setX((int) buttonLength*2);
        button18.setY((int) buttonLength*3);

        button19.setX((int) buttonLength*3);
        button19.setY((int) buttonLength*3);

        button20.setX((int) buttonLength*4);
        button20.setY((int) buttonLength*3);

        button21.setX(0);
        button21.setY((int) buttonLength*4);

        button22.setX((int) buttonLength);
        button22.setY((int) buttonLength*4);

        button23.setX((int) buttonLength*2);
        button23.setY((int) buttonLength*4);

        button24.setX((int) buttonLength*3);
        button24.setY((int) buttonLength*4);

        button25.setX((int) buttonLength*4);
        button25.setY((int) buttonLength*4);


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
        button17.setEnabled(false);
        button18.setEnabled(false);
        button19.setEnabled(false);
        button20.setEnabled(false);
        button21.setEnabled(false);
        button22.setEnabled(false);
        button23.setEnabled(false);
        button24.setEnabled(false);
        button25.setEnabled(false);


        class startHandler implements Runnable {
            Button button1 = (Button) findViewById(R.id.button1_5_5);
            Button button2 = (Button) findViewById(R.id.button2_5_5);
            Button button3 = (Button) findViewById(R.id.button3_5_5);
            Button button4 = (Button) findViewById(R.id.button4_5_5);
            Button button5 = (Button) findViewById(R.id.button5_5_5);
            Button button6 = (Button) findViewById(R.id.button6_5_5);
            Button button7 = (Button) findViewById(R.id.button7_5_5);
            Button button8 = (Button) findViewById(R.id.button8_5_5);
            Button button9 = (Button) findViewById(R.id.button9_5_5);
            Button button10 = (Button) findViewById(R.id.button10_5_5);
            Button button11 = (Button) findViewById(R.id.button11_5_5);
            Button button12 = (Button) findViewById(R.id.button12_5_5);
            Button button13 = (Button) findViewById(R.id.button13_5_5);
            Button button14 = (Button) findViewById(R.id.button14_5_5);
            Button button15 = (Button) findViewById(R.id.button15_5_5);
            Button button16 = (Button) findViewById(R.id.button16_5_5);
            Button button17 = (Button) findViewById(R.id.button17_5_5);
            Button button18 = (Button) findViewById(R.id.button18_5_5);
            Button button19 = (Button) findViewById(R.id.button19_5_5);
            Button button20 = (Button) findViewById(R.id.button20_5_5);
            Button button21 = (Button) findViewById(R.id.button21_5_5);
            Button button22 = (Button) findViewById(R.id.button22_5_5);
            Button button23 = (Button) findViewById(R.id.button23_5_5);
            Button button24 = (Button) findViewById(R.id.button24_5_5);
            Button button25 = (Button) findViewById(R.id.button25_5_5);

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
                button17.setEnabled(true);
                button18.setEnabled(true);
                button19.setEnabled(true);
                button20.setEnabled(true);
                button21.setEnabled(true);
                button22.setEnabled(true);
                button23.setEnabled(true);
                button24.setEnabled(true);
                button25.setEnabled(true);

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
                scaleAnimation(saveX[17], saveY[17], button17);
                scaleAnimation(saveX[18], saveY[18], button18);
                scaleAnimation(saveX[19], saveY[19], button19);
                scaleAnimation(saveX[20], saveY[20], button20);
                scaleAnimation(saveX[21], saveY[21], button21);
                scaleAnimation(saveX[22], saveY[22], button22);
                scaleAnimation(saveX[23], saveY[23], button23);
                scaleAnimation(saveX[24], saveY[24], button24);
                scaleAnimation(saveX[25], saveY[25], button25);

                TextView start = (TextView) findViewById(R.id.startText5_5);
                alphaAnimation(start, 1250);
            }
        }

        Handler h = new Handler();
        TextView ready = (TextView) findViewById(R.id.readyText5_5);
        alphaAnimation(ready, 3000);
        h.postDelayed(new startHandler(), 3100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_5_5);

        final Button button1 = (Button) findViewById(R.id.button1_5_5);
        final Button button2 = (Button) findViewById(R.id.button2_5_5);
        final Button button3 = (Button) findViewById(R.id.button3_5_5);
        final Button button4 = (Button) findViewById(R.id.button4_5_5);
        final Button button5 = (Button) findViewById(R.id.button5_5_5);
        final Button button6 = (Button) findViewById(R.id.button6_5_5);
        final Button button7 = (Button) findViewById(R.id.button7_5_5);
        final Button button8 = (Button) findViewById(R.id.button8_5_5);
        final Button button9 = (Button) findViewById(R.id.button9_5_5);
        final Button button10 = (Button) findViewById(R.id.button10_5_5);
        final Button button11 = (Button) findViewById(R.id.button11_5_5);
        final Button button12 = (Button) findViewById(R.id.button12_5_5);
        final Button button13 = (Button) findViewById(R.id.button13_5_5);
        final Button button14 = (Button) findViewById(R.id.button14_5_5);
        final Button button15 = (Button) findViewById(R.id.button15_5_5);
        final Button button16 = (Button) findViewById(R.id.button16_5_5);
        final Button button17 = (Button) findViewById(R.id.button17_5_5);
        final Button button18 = (Button) findViewById(R.id.button18_5_5);
        final Button button19 = (Button) findViewById(R.id.button19_5_5);
        final Button button20 = (Button) findViewById(R.id.button20_5_5);
        final Button button21 = (Button) findViewById(R.id.button21_5_5);
        final Button button22 = (Button) findViewById(R.id.button22_5_5);
        final Button button23 = (Button) findViewById(R.id.button23_5_5);
        final Button button24 = (Button) findViewById(R.id.button24_5_5);
        final Button button25 = (Button) findViewById(R.id.button25_5_5);

        Button finishButton1 = (Button) findViewById(R.id.finishButton5_5);

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
                if (button17.getX() == buttonLayoutX[17] && button17.getY() == buttonLayoutY[17])
                    checkAnswer++;
                if (button18.getX() == buttonLayoutX[18] && button18.getY() == buttonLayoutY[18])
                    checkAnswer++;
                if (button19.getX() == buttonLayoutX[19] && button19.getY() == buttonLayoutY[19])
                    checkAnswer++;
                if (button20.getX() == buttonLayoutX[20] && button20.getY() == buttonLayoutY[20])
                    checkAnswer++;
                if (button21.getX() == buttonLayoutX[21] && button21.getY() == buttonLayoutY[21])
                    checkAnswer++;
                if (button22.getX() == buttonLayoutX[22] && button22.getY() == buttonLayoutY[22])
                    checkAnswer++;
                if (button23.getX() == buttonLayoutX[23] && button23.getY() == buttonLayoutY[23])
                    checkAnswer++;
                if (button24.getX() == buttonLayoutX[24] && button24.getY() == buttonLayoutY[24])
                    checkAnswer++;
                if (button25.getX() == buttonLayoutX[25] && button25.getY() == buttonLayoutY[25])
                    checkAnswer++;

                if (checkAnswer == 25) {
                    finish();
                }
            }
        });

        getStandardSize();

        buttonLength = (density*standardSize_X)/5;//standardSize_X / 5;
        saveLastLine = ((density*standardSize_X)/5) * 5;//(standardSize_X / 5) * 5;

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

        button17.setWidth((int) buttonLength);
        button17.setHeight((int) buttonLength);

        button18.setWidth((int) buttonLength);
        button18.setHeight((int) buttonLength);

        button19.setWidth((int) buttonLength);
        button19.setHeight((int) buttonLength);

        button20.setWidth((int) buttonLength);
        button20.setHeight((int) buttonLength);

        button21.setWidth((int) buttonLength);
        button21.setHeight((int) buttonLength);

        button22.setWidth((int) buttonLength);
        button22.setHeight((int) buttonLength);

        button23.setWidth((int) buttonLength);
        button23.setHeight((int) buttonLength);

        button24.setWidth((int) buttonLength);
        button24.setHeight((int) buttonLength);

        button25.setWidth((int) buttonLength);
        button25.setHeight((int) buttonLength);

        for (int i = 1; i <= 25; i++) {
            if (i < 6)
                buttonLayoutY[i] = 0;
            else if (6 <= i && i < 11)
                buttonLayoutY[i] = buttonLength;
            else if (11 <= i && i < 16)
                buttonLayoutY[i] = buttonLength * 2;
            else if (16 <= i && i < 21)
                buttonLayoutY[i] = buttonLength * 3;
            else if(21 <= i && i < 26)
                buttonLayoutY[i] = buttonLength*4;

            if (i % 5 == 1)
                buttonLayoutX[i] = 0;
            else if (i % 5 == 2)
                buttonLayoutX[i] = buttonLength;
            else if (i % 5 == 3)
                buttonLayoutX[i] = buttonLength * 2;
            else if (i % 5 == 4)
                buttonLayoutX[i] = buttonLength * 3;
            else if(i % 5 == 0)
                buttonLayoutX[i] = buttonLength * 4;

            System.out.println(buttonLayoutX[i] + " " + buttonLayoutY[i]);
        }

        button1.setBackgroundColor(getResources().getColor(R.color.c5_5_1_1));
        button2.setBackgroundColor(getResources().getColor(R.color.c5_5_1_2));
        button3.setBackgroundColor(getResources().getColor(R.color.c5_5_1_3));
        button4.setBackgroundColor(getResources().getColor(R.color.c5_5_1_4));
        button5.setBackgroundColor(getResources().getColor(R.color.c5_5_1_5));
        button6.setBackgroundColor(getResources().getColor(R.color.c5_5_2_1));
        button7.setBackgroundColor(getResources().getColor(R.color.c5_5_2_2));
        button8.setBackgroundColor(getResources().getColor(R.color.c5_5_2_3));
        button9.setBackgroundColor(getResources().getColor(R.color.c5_5_2_4));
        button10.setBackgroundColor(getResources().getColor(R.color.c5_5_2_5));
        button11.setBackgroundColor(getResources().getColor(R.color.c5_5_3_1));
        button12.setBackgroundColor(getResources().getColor(R.color.c5_5_3_2));
        button13.setBackgroundColor(getResources().getColor(R.color.c5_5_3_3));
        button14.setBackgroundColor(getResources().getColor(R.color.c5_5_3_4));
        button15.setBackgroundColor(getResources().getColor(R.color.c5_5_3_5));
        button16.setBackgroundColor(getResources().getColor(R.color.c5_5_4_1));
        button17.setBackgroundColor(getResources().getColor(R.color.c5_5_4_2));
        button18.setBackgroundColor(getResources().getColor(R.color.c5_5_4_3));
        button19.setBackgroundColor(getResources().getColor(R.color.c5_5_4_4));
        button20.setBackgroundColor(getResources().getColor(R.color.c5_5_4_5));
        button21.setBackgroundColor(getResources().getColor(R.color.c5_5_5_1));
        button22.setBackgroundColor(getResources().getColor(R.color.c5_5_5_2));
        button23.setBackgroundColor(getResources().getColor(R.color.c5_5_5_3));
        button24.setBackgroundColor(getResources().getColor(R.color.c5_5_5_4));
        button25.setBackgroundColor(getResources().getColor(R.color.c5_5_5_5));

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
        button17.setOnTouchListener(this);
        button18.setOnTouchListener(this);
        button19.setOnTouchListener(this);
        button20.setOnTouchListener(this);
        button21.setOnTouchListener(this);
        button22.setOnTouchListener(this);
        button23.setOnTouchListener(this);
        button24.setOnTouchListener(this);
        button25.setOnTouchListener(this);
        System.out.println("CREATE button1 getX : " + button1.getX() + " getY : " + button1.getY());

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int parentWidth = ((ViewGroup) v.getParent()).getWidth();    // 부모 View 의 Width
        int parentHeight = ((ViewGroup) v.getParent()).getHeight();    // 부모 View 의 Height

        Button button1 = (Button) findViewById(R.id.button1_5_5);
        Button button2 = (Button) findViewById(R.id.button2_5_5);
        Button button3 = (Button) findViewById(R.id.button3_5_5);
        Button button4 = (Button) findViewById(R.id.button4_5_5);
        Button button5 = (Button) findViewById(R.id.button5_5_5);
        Button button6 = (Button) findViewById(R.id.button6_5_5);
        Button button7 = (Button) findViewById(R.id.button7_5_5);
        Button button8 = (Button) findViewById(R.id.button8_5_5);
        Button button9 = (Button) findViewById(R.id.button9_5_5);
        Button button10 = (Button) findViewById(R.id.button10_5_5);
        Button button11 = (Button) findViewById(R.id.button11_5_5);
        Button button12 = (Button) findViewById(R.id.button12_5_5);
        Button button13 = (Button) findViewById(R.id.button13_5_5);
        Button button14 = (Button) findViewById(R.id.button14_5_5);
        Button button15 = (Button) findViewById(R.id.button15_5_5);
        Button button16 = (Button) findViewById(R.id.button16_5_5);
        Button button17 = (Button) findViewById(R.id.button17_5_5);
        Button button18 = (Button) findViewById(R.id.button18_5_5);
        Button button19 = (Button) findViewById(R.id.button19_5_5);
        Button button20 = (Button) findViewById(R.id.button20_5_5);
        Button button21 = (Button) findViewById(R.id.button21_5_5);
        Button button22 = (Button) findViewById(R.id.button22_5_5);
        Button button23 = (Button) findViewById(R.id.button23_5_5);
        Button button24 = (Button) findViewById(R.id.button24_5_5);
        Button button25 = (Button) findViewById(R.id.button25_5_5);

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

            System.out.println("view "+v.getX()+" "+v.getY());
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
            } else if (buttonLayoutX[17] <= v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[17] + buttonLength &&
                    buttonLayoutY[17] <= v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[17] + buttonLength &&
                    (saveX != buttonLayoutX[17] || saveY != buttonLayoutY[17])) {
                check = 17;
            } else if (buttonLayoutX[18] <= v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[18] + buttonLength &&
                    buttonLayoutY[18] <= v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[18] + buttonLength &&
                    (saveX != buttonLayoutX[18] || saveY != buttonLayoutY[18])) {
                check = 18;
            } else if (buttonLayoutX[19] <= v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[19] + buttonLength &&
                    buttonLayoutY[19] <= v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[19] + buttonLength &&
                    (saveX != buttonLayoutX[19] || saveY != buttonLayoutY[19])) {
                check = 19;
            } else if (buttonLayoutX[20] <= v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[20] + buttonLength &&
                    buttonLayoutY[20] <= v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[20] + buttonLength &&
                    (saveX != buttonLayoutX[20] || saveY != buttonLayoutY[20])) {
                check = 20;
            } else if (buttonLayoutX[21] <= v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[21] + buttonLength &&
                    buttonLayoutY[21] <= v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[21] + buttonLength &&
                    (saveX != buttonLayoutX[21] || saveY != buttonLayoutY[21])) {
                check = 21;
            } else if (buttonLayoutX[22] <= v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[22] + buttonLength &&
                    buttonLayoutY[22] <= v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[22] + buttonLength &&
                    (saveX != buttonLayoutX[22] || saveY != buttonLayoutY[22])) {
                check = 22;
            } else if (buttonLayoutX[23] <= v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[23] + buttonLength &&
                    buttonLayoutY[23] <= v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[23] + buttonLength &&
                    (saveX != buttonLayoutX[23] || saveY != buttonLayoutY[23])) {
                check = 23;
            } else if (buttonLayoutX[24] <= v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[24] + buttonLength &&
                    buttonLayoutY[24] <= v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[24] + buttonLength &&
                    (saveX != buttonLayoutX[24] || saveY != buttonLayoutY[24])) {
                check = 24;
            } else if (buttonLayoutX[25] <= v.getX() + v.getWidth() / 2 &&
                    v.getX() + v.getWidth() / 2 < buttonLayoutX[25] + buttonLength &&
                    buttonLayoutY[25] <= v.getY() + v.getHeight() / 2 &&
                    v.getY() + v.getHeight() / 2 < buttonLayoutY[25] + buttonLength &&
                    (saveX != buttonLayoutX[25] || saveY != buttonLayoutY[25])) {
                check = 25;
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
            } else if (button17.getX() == buttonLayoutX[check] && button17.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button17);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button18.getX() == buttonLayoutX[check] && button18.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button18);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button19.getX() == buttonLayoutX[check] && button19.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button19);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button20.getX() == buttonLayoutX[check] && button20.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button20);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button21.getX() == buttonLayoutX[check] && button21.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button21);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button22.getX() == buttonLayoutX[check] && button22.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button22);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button23.getX() == buttonLayoutX[check] && button23.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button23);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button24.getX() == buttonLayoutX[check] && button24.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button24);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            } else if (button25.getX() == buttonLayoutX[check] && button25.getY() == buttonLayoutY[check]) {
                scaleAnimation(saveX, saveY, button25);
                scaleAnimation(buttonLayoutX[check], buttonLayoutY[check], (Button) v);
            }

            saveX = saveY = -1;

            System.out.println("OUT button1 getX : " + button1.getX() + " getY : " + button1.getY());
        }


        return true;
    }
}
