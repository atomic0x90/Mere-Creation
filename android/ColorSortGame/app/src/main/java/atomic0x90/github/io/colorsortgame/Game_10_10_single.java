package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Game_10_10_single extends AppCompatActivity {
    float oldXvalue, oldYvalue;
    int standardSize_X, standardSize_Y;
    float density;
    float saveX = -1;
    float saveY = -1;

    float saveLastLine;
    float[] buttonLayoutX = new float[101];
    float[] buttonLayoutY = new float[101];
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
        final Button button1 =  (Button) findViewById(R.id.button1_10_10_s);
        final Button button2 =  (Button) findViewById(R.id.button2_10_10_s);
        final Button button3 =  (Button) findViewById(R.id.button3_10_10_s);
        final Button button4 =  (Button) findViewById(R.id.button4_10_10_s);
        final Button button5 =  (Button) findViewById(R.id.button5_10_10_s);
        final Button button6 =  (Button) findViewById(R.id.button6_10_10_s);
        final Button button7 =  (Button) findViewById(R.id.button7_10_10_s);
        final Button button8 =  (Button) findViewById(R.id.button8_10_10_s);
        final Button button9 =  (Button) findViewById(R.id.button9_10_10_s);
        final Button button10 =  (Button) findViewById(R.id.button10_10_10_s);
        final Button button11 =  (Button) findViewById(R.id.button11_10_10_s);
        final Button button12 =  (Button) findViewById(R.id.button12_10_10_s);
        final Button button13 =  (Button) findViewById(R.id.button13_10_10_s);
        final Button button14 =  (Button) findViewById(R.id.button14_10_10_s);
        final Button button15 =  (Button) findViewById(R.id.button15_10_10_s);
        final Button button16 =  (Button) findViewById(R.id.button16_10_10_s);
        final Button button17 =  (Button) findViewById(R.id.button17_10_10_s);
        final Button button18 =  (Button) findViewById(R.id.button18_10_10_s);
        final Button button19 =  (Button) findViewById(R.id.button19_10_10_s);
        final Button button20 =  (Button) findViewById(R.id.button20_10_10_s);
        final Button button21 =  (Button) findViewById(R.id.button21_10_10_s);
        final Button button22 =  (Button) findViewById(R.id.button22_10_10_s);
        final Button button23 =  (Button) findViewById(R.id.button23_10_10_s);
        final Button button24 =  (Button) findViewById(R.id.button24_10_10_s);
        final Button button25 =  (Button) findViewById(R.id.button25_10_10_s);
        final Button button26 =  (Button) findViewById(R.id.button26_10_10_s);
        final Button button27 =  (Button) findViewById(R.id.button27_10_10_s);
        final Button button28 =  (Button) findViewById(R.id.button28_10_10_s);
        final Button button29 =  (Button) findViewById(R.id.button29_10_10_s);
        final Button button30 =  (Button) findViewById(R.id.button30_10_10_s);
        final Button button31 =  (Button) findViewById(R.id.button31_10_10_s);
        final Button button32 =  (Button) findViewById(R.id.button32_10_10_s);
        final Button button33 =  (Button) findViewById(R.id.button33_10_10_s);
        final Button button34 =  (Button) findViewById(R.id.button34_10_10_s);
        final Button button35 =  (Button) findViewById(R.id.button35_10_10_s);
        final Button button36 =  (Button) findViewById(R.id.button36_10_10_s);
        final Button button37 =  (Button) findViewById(R.id.button37_10_10_s);
        final Button button38 =  (Button) findViewById(R.id.button38_10_10_s);
        final Button button39 =  (Button) findViewById(R.id.button39_10_10_s);
        final Button button40 =  (Button) findViewById(R.id.button40_10_10_s);
        final Button button41 =  (Button) findViewById(R.id.button41_10_10_s);
        final Button button42 =  (Button) findViewById(R.id.button42_10_10_s);
        final Button button43 =  (Button) findViewById(R.id.button43_10_10_s);
        final Button button44 =  (Button) findViewById(R.id.button44_10_10_s);
        final Button button45 =  (Button) findViewById(R.id.button45_10_10_s);
        final Button button46 =  (Button) findViewById(R.id.button46_10_10_s);
        final Button button47 =  (Button) findViewById(R.id.button47_10_10_s);
        final Button button48 =  (Button) findViewById(R.id.button48_10_10_s);
        final Button button49 =  (Button) findViewById(R.id.button49_10_10_s);
        final Button button50 =  (Button) findViewById(R.id.button50_10_10_s);
        final Button button51 =  (Button) findViewById(R.id.button51_10_10_s);
        final Button button52 =  (Button) findViewById(R.id.button52_10_10_s);
        final Button button53 =  (Button) findViewById(R.id.button53_10_10_s);
        final Button button54 =  (Button) findViewById(R.id.button54_10_10_s);
        final Button button55 =  (Button) findViewById(R.id.button55_10_10_s);
        final Button button56 =  (Button) findViewById(R.id.button56_10_10_s);
        final Button button57 =  (Button) findViewById(R.id.button57_10_10_s);
        final Button button58 =  (Button) findViewById(R.id.button58_10_10_s);
        final Button button59 =  (Button) findViewById(R.id.button59_10_10_s);
        final Button button60 =  (Button) findViewById(R.id.button60_10_10_s);
        final Button button61 =  (Button) findViewById(R.id.button61_10_10_s);
        final Button button62 =  (Button) findViewById(R.id.button62_10_10_s);
        final Button button63 =  (Button) findViewById(R.id.button63_10_10_s);
        final Button button64 =  (Button) findViewById(R.id.button64_10_10_s);
        final Button button65 =  (Button) findViewById(R.id.button65_10_10_s);
        final Button button66 =  (Button) findViewById(R.id.button66_10_10_s);
        final Button button67 =  (Button) findViewById(R.id.button67_10_10_s);
        final Button button68 =  (Button) findViewById(R.id.button68_10_10_s);
        final Button button69 =  (Button) findViewById(R.id.button69_10_10_s);
        final Button button70 =  (Button) findViewById(R.id.button70_10_10_s);
        final Button button71 =  (Button) findViewById(R.id.button71_10_10_s);
        final Button button72 =  (Button) findViewById(R.id.button72_10_10_s);
        final Button button73 =  (Button) findViewById(R.id.button73_10_10_s);
        final Button button74 =  (Button) findViewById(R.id.button74_10_10_s);
        final Button button75 =  (Button) findViewById(R.id.button75_10_10_s);
        final Button button76 =  (Button) findViewById(R.id.button76_10_10_s);
        final Button button77 =  (Button) findViewById(R.id.button77_10_10_s);
        final Button button78 =  (Button) findViewById(R.id.button78_10_10_s);
        final Button button79 =  (Button) findViewById(R.id.button79_10_10_s);
        final Button button80 =  (Button) findViewById(R.id.button80_10_10_s);
        final Button button81 =  (Button) findViewById(R.id.button81_10_10_s);
        final Button button82 =  (Button) findViewById(R.id.button82_10_10_s);
        final Button button83 =  (Button) findViewById(R.id.button83_10_10_s);
        final Button button84 =  (Button) findViewById(R.id.button84_10_10_s);
        final Button button85 =  (Button) findViewById(R.id.button85_10_10_s);
        final Button button86 =  (Button) findViewById(R.id.button86_10_10_s);
        final Button button87 =  (Button) findViewById(R.id.button87_10_10_s);
        final Button button88 =  (Button) findViewById(R.id.button88_10_10_s);
        final Button button89 =  (Button) findViewById(R.id.button89_10_10_s);
        final Button button90 =  (Button) findViewById(R.id.button90_10_10_s);
        final Button button91 =  (Button) findViewById(R.id.button91_10_10_s);
        final Button button92 =  (Button) findViewById(R.id.button92_10_10_s);
        final Button button93 =  (Button) findViewById(R.id.button93_10_10_s);
        final Button button94 =  (Button) findViewById(R.id.button94_10_10_s);
        final Button button95 =  (Button) findViewById(R.id.button95_10_10_s);
        final Button button96 =  (Button) findViewById(R.id.button96_10_10_s);
        final Button button97 =  (Button) findViewById(R.id.button97_10_10_s);
        final Button button98 =  (Button) findViewById(R.id.button98_10_10_s);
        final Button button99 =  (Button) findViewById(R.id.button99_10_10_s);
        final Button button100 =  (Button) findViewById(R.id.button100_10_10_s);

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
        button26.setEnabled(false);
        button27.setEnabled(false);
        button28.setEnabled(false);
        button29.setEnabled(false);
        button30.setEnabled(false);
        button31.setEnabled(false);
        button32.setEnabled(false);
        button33.setEnabled(false);
        button34.setEnabled(false);
        button35.setEnabled(false);
        button36.setEnabled(false);
        button37.setEnabled(false);
        button38.setEnabled(false);
        button39.setEnabled(false);
        button40.setEnabled(false);
        button41.setEnabled(false);
        button42.setEnabled(false);
        button43.setEnabled(false);
        button44.setEnabled(false);
        button45.setEnabled(false);
        button46.setEnabled(false);
        button47.setEnabled(false);
        button48.setEnabled(false);
        button49.setEnabled(false);
        button50.setEnabled(false);
        button51.setEnabled(false);
        button52.setEnabled(false);
        button53.setEnabled(false);
        button54.setEnabled(false);
        button55.setEnabled(false);
        button56.setEnabled(false);
        button57.setEnabled(false);
        button58.setEnabled(false);
        button59.setEnabled(false);
        button60.setEnabled(false);
        button61.setEnabled(false);
        button62.setEnabled(false);
        button63.setEnabled(false);
        button64.setEnabled(false);
        button65.setEnabled(false);
        button66.setEnabled(false);
        button67.setEnabled(false);
        button68.setEnabled(false);
        button69.setEnabled(false);
        button70.setEnabled(false);
        button71.setEnabled(false);
        button72.setEnabled(false);
        button73.setEnabled(false);
        button74.setEnabled(false);
        button75.setEnabled(false);
        button76.setEnabled(false);
        button77.setEnabled(false);
        button78.setEnabled(false);
        button79.setEnabled(false);
        button80.setEnabled(false);
        button81.setEnabled(false);
        button82.setEnabled(false);
        button83.setEnabled(false);
        button84.setEnabled(false);
        button85.setEnabled(false);
        button86.setEnabled(false);
        button87.setEnabled(false);
        button88.setEnabled(false);
        button89.setEnabled(false);
        button90.setEnabled(false);
        button91.setEnabled(false);
        button92.setEnabled(false);
        button93.setEnabled(false);
        button94.setEnabled(false);
        button95.setEnabled(false);
        button96.setEnabled(false);
        button97.setEnabled(false);
        button98.setEnabled(false);
        button99.setEnabled(false);
        button100.setEnabled(false);


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
                        button26.setEnabled(true);
                        button27.setEnabled(true);
                        button28.setEnabled(true);
                        button29.setEnabled(true);
                        button30.setEnabled(true);
                        button31.setEnabled(true);
                        button32.setEnabled(true);
                        button33.setEnabled(true);
                        button34.setEnabled(true);
                        button35.setEnabled(true);
                        button36.setEnabled(true);
                        button37.setEnabled(true);
                        button38.setEnabled(true);
                        button39.setEnabled(true);
                        button40.setEnabled(true);
                        button41.setEnabled(true);
                        button42.setEnabled(true);
                        button43.setEnabled(true);
                        button44.setEnabled(true);
                        button45.setEnabled(true);
                        button46.setEnabled(true);
                        button47.setEnabled(true);
                        button48.setEnabled(true);
                        button49.setEnabled(true);
                        button50.setEnabled(true);
                        button51.setEnabled(true);
                        button52.setEnabled(true);
                        button53.setEnabled(true);
                        button54.setEnabled(true);
                        button55.setEnabled(true);
                        button56.setEnabled(true);
                        button57.setEnabled(true);
                        button58.setEnabled(true);
                        button59.setEnabled(true);
                        button60.setEnabled(true);
                        button61.setEnabled(true);
                        button62.setEnabled(true);
                        button63.setEnabled(true);
                        button64.setEnabled(true);
                        button65.setEnabled(true);
                        button66.setEnabled(true);
                        button67.setEnabled(true);
                        button68.setEnabled(true);
                        button69.setEnabled(true);
                        button70.setEnabled(true);
                        button71.setEnabled(true);
                        button72.setEnabled(true);
                        button73.setEnabled(true);
                        button74.setEnabled(true);
                        button75.setEnabled(true);
                        button76.setEnabled(true);
                        button77.setEnabled(true);
                        button78.setEnabled(true);
                        button79.setEnabled(true);
                        button80.setEnabled(true);
                        button81.setEnabled(true);
                        button82.setEnabled(true);
                        button83.setEnabled(true);
                        button84.setEnabled(true);
                        button85.setEnabled(true);
                        button86.setEnabled(true);
                        button87.setEnabled(true);
                        button88.setEnabled(true);
                        button89.setEnabled(true);
                        button90.setEnabled(true);
                        button91.setEnabled(true);
                        button92.setEnabled(true);
                        button93.setEnabled(true);
                        button94.setEnabled(true);
                        button95.setEnabled(true);
                        button96.setEnabled(true);
                        button97.setEnabled(true);
                        button98.setEnabled(true);
                        button99.setEnabled(true);
                        button100.setEnabled(true);
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
    protected void onStart(){
        super.onStart();

        final int[] saveX = new int[101];
        final int[] saveY = new int[101];

        for (int i = 1; i < 101; i++) {
            if (1 <= i && i <= 10) {
                saveY[i] = 0;
            } else if (i <= 20) {
                saveY[i] = (int) buttonLength;
            } else if (i <= 30) {
                saveY[i] = (int) buttonLength * 2;
            } else if (i <= 40) {
                saveY[i] = (int) buttonLength * 3;
            } else if(i <= 50){
                saveY[i] = (int) buttonLength * 4;
            } else if(i <= 60){
                saveY[i] = (int) buttonLength * 5;
            } else if(i <= 70){
                saveY[i] = (int) buttonLength * 6;
            } else if(i <= 80){
                saveY[i] = (int) buttonLength * 7;
            } else if(i <= 90){
                saveY[i] = (int) buttonLength * 8;
            } else if(i <= 100){
                saveY[i] = (int) buttonLength * 9;
            }

            if (i % 10 == 1)
                saveX[i] = 0;
            else if (i % 10 == 2)
                saveX[i] = (int) buttonLength;
            else if (i % 10 == 3)
                saveX[i] = (int) buttonLength * 2;
            else if (i % 10 == 4)
                saveX[i] = (int) buttonLength * 3;
            else if (i % 10 == 5)
                saveX[i] = (int) buttonLength * 4;
            else if (i % 10 == 6)
                saveX[i] = (int) buttonLength * 5;
            else if (i % 10 == 7)
                saveX[i] = (int) buttonLength * 6;
            else if (i % 10 == 8)
                saveX[i] = (int) buttonLength * 7;
            else if (i % 10 == 9)
                saveX[i] = (int) buttonLength * 8;
            else if (i % 10 == 0)
                saveX[i] = (int) buttonLength * 9;
        }

        Random random = new Random();
        int tmp = 1;
        int tmpX, tmpY;
        for (int i = 1; i < 101; i++) {
            tmp = random.nextInt(99) + 1;
            tmpX = saveX[tmp];
            tmpY = saveY[tmp];

            saveX[tmp] = saveX[i];
            saveY[tmp] = saveY[i];
            saveX[i] = tmpX;
            saveY[i] = tmpY;
        }
        Button button1 =  (Button) findViewById(R.id.button1_10_10_s);
        Button button2 =  (Button) findViewById(R.id.button2_10_10_s);
        Button button3 =  (Button) findViewById(R.id.button3_10_10_s);
        Button button4 =  (Button) findViewById(R.id.button4_10_10_s);
        Button button5 =  (Button) findViewById(R.id.button5_10_10_s);
        Button button6 =  (Button) findViewById(R.id.button6_10_10_s);
        Button button7 =  (Button) findViewById(R.id.button7_10_10_s);
        Button button8 =  (Button) findViewById(R.id.button8_10_10_s);
        Button button9 =  (Button) findViewById(R.id.button9_10_10_s);
        Button button10 =  (Button) findViewById(R.id.button10_10_10_s);
        Button button11 =  (Button) findViewById(R.id.button11_10_10_s);
        Button button12 =  (Button) findViewById(R.id.button12_10_10_s);
        Button button13 =  (Button) findViewById(R.id.button13_10_10_s);
        Button button14 =  (Button) findViewById(R.id.button14_10_10_s);
        Button button15 =  (Button) findViewById(R.id.button15_10_10_s);
        Button button16 =  (Button) findViewById(R.id.button16_10_10_s);
        Button button17 =  (Button) findViewById(R.id.button17_10_10_s);
        Button button18 =  (Button) findViewById(R.id.button18_10_10_s);
        Button button19 =  (Button) findViewById(R.id.button19_10_10_s);
        Button button20 =  (Button) findViewById(R.id.button20_10_10_s);
        Button button21 =  (Button) findViewById(R.id.button21_10_10_s);
        Button button22 =  (Button) findViewById(R.id.button22_10_10_s);
        Button button23 =  (Button) findViewById(R.id.button23_10_10_s);
        Button button24 =  (Button) findViewById(R.id.button24_10_10_s);
        Button button25 =  (Button) findViewById(R.id.button25_10_10_s);
        Button button26 =  (Button) findViewById(R.id.button26_10_10_s);
        Button button27 =  (Button) findViewById(R.id.button27_10_10_s);
        Button button28 =  (Button) findViewById(R.id.button28_10_10_s);
        Button button29 =  (Button) findViewById(R.id.button29_10_10_s);
        Button button30 =  (Button) findViewById(R.id.button30_10_10_s);
        Button button31 =  (Button) findViewById(R.id.button31_10_10_s);
        Button button32 =  (Button) findViewById(R.id.button32_10_10_s);
        Button button33 =  (Button) findViewById(R.id.button33_10_10_s);
        Button button34 =  (Button) findViewById(R.id.button34_10_10_s);
        Button button35 =  (Button) findViewById(R.id.button35_10_10_s);
        Button button36 =  (Button) findViewById(R.id.button36_10_10_s);
        Button button37 =  (Button) findViewById(R.id.button37_10_10_s);
        Button button38 =  (Button) findViewById(R.id.button38_10_10_s);
        Button button39 =  (Button) findViewById(R.id.button39_10_10_s);
        Button button40 =  (Button) findViewById(R.id.button40_10_10_s);
        Button button41 =  (Button) findViewById(R.id.button41_10_10_s);
        Button button42 =  (Button) findViewById(R.id.button42_10_10_s);
        Button button43 =  (Button) findViewById(R.id.button43_10_10_s);
        Button button44 =  (Button) findViewById(R.id.button44_10_10_s);
        Button button45 =  (Button) findViewById(R.id.button45_10_10_s);
        Button button46 =  (Button) findViewById(R.id.button46_10_10_s);
        Button button47 =  (Button) findViewById(R.id.button47_10_10_s);
        Button button48 =  (Button) findViewById(R.id.button48_10_10_s);
        Button button49 =  (Button) findViewById(R.id.button49_10_10_s);
        Button button50 =  (Button) findViewById(R.id.button50_10_10_s);
        Button button51 =  (Button) findViewById(R.id.button51_10_10_s);
        Button button52 =  (Button) findViewById(R.id.button52_10_10_s);
        Button button53 =  (Button) findViewById(R.id.button53_10_10_s);
        Button button54 =  (Button) findViewById(R.id.button54_10_10_s);
        Button button55 =  (Button) findViewById(R.id.button55_10_10_s);
        Button button56 =  (Button) findViewById(R.id.button56_10_10_s);
        Button button57 =  (Button) findViewById(R.id.button57_10_10_s);
        Button button58 =  (Button) findViewById(R.id.button58_10_10_s);
        Button button59 =  (Button) findViewById(R.id.button59_10_10_s);
        Button button60 =  (Button) findViewById(R.id.button60_10_10_s);
        Button button61 =  (Button) findViewById(R.id.button61_10_10_s);
        Button button62 =  (Button) findViewById(R.id.button62_10_10_s);
        Button button63 =  (Button) findViewById(R.id.button63_10_10_s);
        Button button64 =  (Button) findViewById(R.id.button64_10_10_s);
        Button button65 =  (Button) findViewById(R.id.button65_10_10_s);
        Button button66 =  (Button) findViewById(R.id.button66_10_10_s);
        Button button67 =  (Button) findViewById(R.id.button67_10_10_s);
        Button button68 =  (Button) findViewById(R.id.button68_10_10_s);
        Button button69 =  (Button) findViewById(R.id.button69_10_10_s);
        Button button70 =  (Button) findViewById(R.id.button70_10_10_s);
        Button button71 =  (Button) findViewById(R.id.button71_10_10_s);
        Button button72 =  (Button) findViewById(R.id.button72_10_10_s);
        Button button73 =  (Button) findViewById(R.id.button73_10_10_s);
        Button button74 =  (Button) findViewById(R.id.button74_10_10_s);
        Button button75 =  (Button) findViewById(R.id.button75_10_10_s);
        Button button76 =  (Button) findViewById(R.id.button76_10_10_s);
        Button button77 =  (Button) findViewById(R.id.button77_10_10_s);
        Button button78 =  (Button) findViewById(R.id.button78_10_10_s);
        Button button79 =  (Button) findViewById(R.id.button79_10_10_s);
        Button button80 =  (Button) findViewById(R.id.button80_10_10_s);
        Button button81 =  (Button) findViewById(R.id.button81_10_10_s);
        Button button82 =  (Button) findViewById(R.id.button82_10_10_s);
        Button button83 =  (Button) findViewById(R.id.button83_10_10_s);
        Button button84 =  (Button) findViewById(R.id.button84_10_10_s);
        Button button85 =  (Button) findViewById(R.id.button85_10_10_s);
        Button button86 =  (Button) findViewById(R.id.button86_10_10_s);
        Button button87 =  (Button) findViewById(R.id.button87_10_10_s);
        Button button88 =  (Button) findViewById(R.id.button88_10_10_s);
        Button button89 =  (Button) findViewById(R.id.button89_10_10_s);
        Button button90 =  (Button) findViewById(R.id.button90_10_10_s);
        Button button91 =  (Button) findViewById(R.id.button91_10_10_s);
        Button button92 =  (Button) findViewById(R.id.button92_10_10_s);
        Button button93 =  (Button) findViewById(R.id.button93_10_10_s);
        Button button94 =  (Button) findViewById(R.id.button94_10_10_s);
        Button button95 =  (Button) findViewById(R.id.button95_10_10_s);
        Button button96 =  (Button) findViewById(R.id.button96_10_10_s);
        Button button97 =  (Button) findViewById(R.id.button97_10_10_s);
        Button button98 =  (Button) findViewById(R.id.button98_10_10_s);
        Button button99 =  (Button) findViewById(R.id.button99_10_10_s);
        Button button100 =  (Button) findViewById(R.id.button100_10_10_s);

        button1.setX(0);
        button1.setY(0);

        button2.setX((int) buttonLength);
        button2.setY(0);

        button3.setX((int) buttonLength * 2);
        button3.setY(0);

        button4.setX((int) buttonLength * 3);
        button4.setY(0);

        button5.setX((int) buttonLength * 4);
        button5.setY(0);

        button6.setX((int) buttonLength * 5);
        button6.setY(0);

        button7.setX((int) buttonLength * 6);
        button7.setY(0);

        button8.setX((int) buttonLength * 7);
        button8.setY(0);

        button9.setX((int) buttonLength * 8);
        button9.setY(0);

        button10.setX((int) buttonLength * 9);
        button10.setY(0);

        button11.setX(0);
        button11.setY((int) buttonLength);

        button12.setX((int) buttonLength);
        button12.setY((int) buttonLength);

        button13.setX((int) buttonLength * 2);
        button13.setY((int) buttonLength);

        button14.setX((int) buttonLength * 3);
        button14.setY((int) buttonLength);

        button15.setX((int) buttonLength * 4);
        button15.setY((int) buttonLength);

        button16.setX((int) buttonLength * 5);
        button16.setY((int) buttonLength);

        button17.setX((int) buttonLength * 6);
        button17.setY((int) buttonLength);

        button18.setX((int) buttonLength * 7);
        button18.setY((int) buttonLength);

        button19.setX((int) buttonLength * 8);
        button19.setY((int) buttonLength);

        button20.setX((int) buttonLength * 9);
        button20.setY((int) buttonLength);

        button21.setX(0);
        button21.setY((int) buttonLength * 2);

        button22.setX((int) buttonLength);
        button22.setY((int) buttonLength * 2);

        button23.setX((int) buttonLength * 2);
        button23.setY((int) buttonLength * 2);

        button24.setX((int) buttonLength * 3);
        button24.setY((int) buttonLength * 2);

        button25.setX((int) buttonLength * 4);
        button25.setY((int) buttonLength * 2);

        button26.setX((int) buttonLength * 5);
        button26.setY((int) buttonLength * 2);

        button27.setX((int) buttonLength * 6);
        button27.setY((int) buttonLength * 2);

        button28.setX((int) buttonLength * 7);
        button28.setY((int) buttonLength * 2);

        button29.setX((int) buttonLength * 8);
        button29.setY((int) buttonLength * 2);

        button30.setX((int) buttonLength * 9);
        button30.setY((int) buttonLength * 2);

        button31.setX(0);
        button31.setY((int) buttonLength * 3);

        button32.setX((int) buttonLength);
        button32.setY((int) buttonLength * 3);

        button33.setX((int) buttonLength * 2);
        button33.setY((int) buttonLength * 3);

        button34.setX((int) buttonLength * 3);
        button34.setY((int) buttonLength * 3);

        button35.setX((int) buttonLength * 4);
        button35.setY((int) buttonLength * 3);

        button36.setX((int) buttonLength * 5);
        button36.setY((int) buttonLength * 3);

        button37.setX((int) buttonLength * 6);
        button37.setY((int) buttonLength * 3);

        button38.setX((int) buttonLength * 7);
        button38.setY((int) buttonLength * 3);

        button39.setX((int) buttonLength * 8);
        button39.setY((int) buttonLength * 3);

        button40.setX((int) buttonLength * 9);
        button40.setY((int) buttonLength * 3);

        button41.setX(0);
        button41.setY((int) buttonLength * 4);

        button42.setX((int) buttonLength);
        button42.setY((int) buttonLength * 4);

        button43.setX((int) buttonLength * 2);
        button43.setY((int) buttonLength * 4);

        button44.setX((int) buttonLength * 3);
        button44.setY((int) buttonLength * 4);

        button45.setX((int) buttonLength * 4);
        button45.setY((int) buttonLength * 4);

        button46.setX((int) buttonLength * 5);
        button46.setY((int) buttonLength * 4);

        button47.setX((int) buttonLength * 6);
        button47.setY((int) buttonLength * 4);

        button48.setX((int) buttonLength * 7);
        button48.setY((int) buttonLength * 4);

        button49.setX((int) buttonLength * 8);
        button49.setY((int) buttonLength * 4);

        button50.setX((int) buttonLength * 9);
        button50.setY((int) buttonLength * 4);

        button51.setX(0);
        button51.setY((int) buttonLength * 5);

        button52.setX((int) buttonLength);
        button52.setY((int) buttonLength * 5);

        button53.setX((int) buttonLength * 2);
        button53.setY((int) buttonLength * 5);

        button54.setX((int) buttonLength * 3);
        button54.setY((int) buttonLength * 5);

        button55.setX((int) buttonLength * 4);
        button55.setY((int) buttonLength * 5);

        button56.setX((int) buttonLength * 5);
        button56.setY((int) buttonLength * 5);

        button57.setX((int) buttonLength * 6);
        button57.setY((int) buttonLength * 5);

        button58.setX((int) buttonLength * 7);
        button58.setY((int) buttonLength * 5);

        button59.setX((int) buttonLength * 8);
        button59.setY((int) buttonLength * 5);

        button60.setX((int) buttonLength * 9);
        button60.setY((int) buttonLength * 5);

        button61.setX(0);
        button61.setY((int) buttonLength * 6);

        button62.setX((int) buttonLength);
        button62.setY((int) buttonLength * 6);

        button63.setX((int) buttonLength * 2);
        button63.setY((int) buttonLength * 6);

        button64.setX((int) buttonLength * 3);
        button64.setY((int) buttonLength * 6);

        button65.setX((int) buttonLength * 4);
        button65.setY((int) buttonLength * 6);

        button66.setX((int) buttonLength * 5);
        button66.setY((int) buttonLength * 6);

        button67.setX((int) buttonLength * 6);
        button67.setY((int) buttonLength * 6);

        button68.setX((int) buttonLength * 7);
        button68.setY((int) buttonLength * 6);

        button69.setX((int) buttonLength * 8);
        button69.setY((int) buttonLength * 6);

        button70.setX((int) buttonLength * 9);
        button70.setY((int) buttonLength * 6);

        button71.setX(0);
        button71.setY((int) buttonLength * 7);

        button72.setX((int) buttonLength);
        button72.setY((int) buttonLength * 7);

        button73.setX((int) buttonLength * 2);
        button73.setY((int) buttonLength * 7);

        button74.setX((int) buttonLength * 3);
        button74.setY((int) buttonLength * 7);

        button75.setX((int) buttonLength * 4);
        button75.setY((int) buttonLength * 7);

        button76.setX((int) buttonLength * 5);
        button76.setY((int) buttonLength * 7);

        button77.setX((int) buttonLength * 6);
        button77.setY((int) buttonLength * 7);

        button78.setX((int) buttonLength * 7);
        button78.setY((int) buttonLength * 7);

        button79.setX((int) buttonLength * 8);
        button79.setY((int) buttonLength * 7);

        button80.setX((int) buttonLength * 9);
        button80.setY((int) buttonLength * 7);

        button81.setX(0);
        button81.setY((int) buttonLength * 8);

        button82.setX((int) buttonLength);
        button82.setY((int) buttonLength * 8);

        button83.setX((int) buttonLength * 2);
        button83.setY((int) buttonLength * 8);

        button84.setX((int) buttonLength * 3);
        button84.setY((int) buttonLength * 8);

        button85.setX((int) buttonLength * 4);
        button85.setY((int) buttonLength * 8);

        button86.setX((int) buttonLength * 5);
        button86.setY((int) buttonLength * 8);

        button87.setX((int) buttonLength * 6);
        button87.setY((int) buttonLength * 8);

        button88.setX((int) buttonLength * 7);
        button88.setY((int) buttonLength * 8);

        button89.setX((int) buttonLength * 8);
        button89.setY((int) buttonLength * 8);

        button90.setX((int) buttonLength * 9);
        button90.setY((int) buttonLength * 8);

        button91.setX(0);
        button91.setY((int) buttonLength * 9);

        button92.setX((int) buttonLength);
        button92.setY((int) buttonLength * 9);

        button93.setX((int) buttonLength * 2);
        button93.setY((int) buttonLength * 9);

        button94.setX((int) buttonLength * 3);
        button94.setY((int) buttonLength * 9);

        button95.setX((int) buttonLength * 4);
        button95.setY((int) buttonLength * 9);

        button96.setX((int) buttonLength * 5);
        button96.setY((int) buttonLength * 9);

        button97.setX((int) buttonLength * 6);
        button97.setY((int) buttonLength * 9);

        button98.setX((int) buttonLength * 7);
        button98.setY((int) buttonLength * 9);

        button99.setX((int) buttonLength * 8);
        button99.setY((int) buttonLength * 9);

        button100.setX((int) buttonLength * 9);
        button100.setY((int) buttonLength * 9);

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
        button26.setEnabled(false);
        button27.setEnabled(false);
        button28.setEnabled(false);
        button29.setEnabled(false);
        button30.setEnabled(false);
        button31.setEnabled(false);
        button32.setEnabled(false);
        button33.setEnabled(false);
        button34.setEnabled(false);
        button35.setEnabled(false);
        button36.setEnabled(false);
        button37.setEnabled(false);
        button38.setEnabled(false);
        button39.setEnabled(false);
        button40.setEnabled(false);
        button41.setEnabled(false);
        button42.setEnabled(false);
        button43.setEnabled(false);
        button44.setEnabled(false);
        button45.setEnabled(false);
        button46.setEnabled(false);
        button47.setEnabled(false);
        button48.setEnabled(false);
        button49.setEnabled(false);
        button50.setEnabled(false);
        button51.setEnabled(false);
        button52.setEnabled(false);
        button53.setEnabled(false);
        button54.setEnabled(false);
        button55.setEnabled(false);
        button56.setEnabled(false);
        button57.setEnabled(false);
        button58.setEnabled(false);
        button59.setEnabled(false);
        button60.setEnabled(false);
        button61.setEnabled(false);
        button62.setEnabled(false);
        button63.setEnabled(false);
        button64.setEnabled(false);
        button65.setEnabled(false);
        button66.setEnabled(false);
        button67.setEnabled(false);
        button68.setEnabled(false);
        button69.setEnabled(false);
        button70.setEnabled(false);
        button71.setEnabled(false);
        button72.setEnabled(false);
        button73.setEnabled(false);
        button74.setEnabled(false);
        button75.setEnabled(false);
        button76.setEnabled(false);
        button77.setEnabled(false);
        button78.setEnabled(false);
        button79.setEnabled(false);
        button80.setEnabled(false);
        button81.setEnabled(false);
        button82.setEnabled(false);
        button83.setEnabled(false);
        button84.setEnabled(false);
        button85.setEnabled(false);
        button86.setEnabled(false);
        button87.setEnabled(false);
        button88.setEnabled(false);
        button89.setEnabled(false);
        button90.setEnabled(false);
        button91.setEnabled(false);
        button92.setEnabled(false);
        button93.setEnabled(false);
        button94.setEnabled(false);
        button95.setEnabled(false);
        button96.setEnabled(false);
        button97.setEnabled(false);
        button98.setEnabled(false);
        button99.setEnabled(false);
        button100.setEnabled(false);


        class startHandler implements Runnable {
            Button button1 =  (Button) findViewById(R.id.button1_10_10_s);
            Button button2 =  (Button) findViewById(R.id.button2_10_10_s);
            Button button3 =  (Button) findViewById(R.id.button3_10_10_s);
            Button button4 =  (Button) findViewById(R.id.button4_10_10_s);
            Button button5 =  (Button) findViewById(R.id.button5_10_10_s);
            Button button6 =  (Button) findViewById(R.id.button6_10_10_s);
            Button button7 =  (Button) findViewById(R.id.button7_10_10_s);
            Button button8 =  (Button) findViewById(R.id.button8_10_10_s);
            Button button9 =  (Button) findViewById(R.id.button9_10_10_s);
            Button button10 =  (Button) findViewById(R.id.button10_10_10_s);
            Button button11 =  (Button) findViewById(R.id.button11_10_10_s);
            Button button12 =  (Button) findViewById(R.id.button12_10_10_s);
            Button button13 =  (Button) findViewById(R.id.button13_10_10_s);
            Button button14 =  (Button) findViewById(R.id.button14_10_10_s);
            Button button15 =  (Button) findViewById(R.id.button15_10_10_s);
            Button button16 =  (Button) findViewById(R.id.button16_10_10_s);
            Button button17 =  (Button) findViewById(R.id.button17_10_10_s);
            Button button18 =  (Button) findViewById(R.id.button18_10_10_s);
            Button button19 =  (Button) findViewById(R.id.button19_10_10_s);
            Button button20 =  (Button) findViewById(R.id.button20_10_10_s);
            Button button21 =  (Button) findViewById(R.id.button21_10_10_s);
            Button button22 =  (Button) findViewById(R.id.button22_10_10_s);
            Button button23 =  (Button) findViewById(R.id.button23_10_10_s);
            Button button24 =  (Button) findViewById(R.id.button24_10_10_s);
            Button button25 =  (Button) findViewById(R.id.button25_10_10_s);
            Button button26 =  (Button) findViewById(R.id.button26_10_10_s);
            Button button27 =  (Button) findViewById(R.id.button27_10_10_s);
            Button button28 =  (Button) findViewById(R.id.button28_10_10_s);
            Button button29 =  (Button) findViewById(R.id.button29_10_10_s);
            Button button30 =  (Button) findViewById(R.id.button30_10_10_s);
            Button button31 =  (Button) findViewById(R.id.button31_10_10_s);
            Button button32 =  (Button) findViewById(R.id.button32_10_10_s);
            Button button33 =  (Button) findViewById(R.id.button33_10_10_s);
            Button button34 =  (Button) findViewById(R.id.button34_10_10_s);
            Button button35 =  (Button) findViewById(R.id.button35_10_10_s);
            Button button36 =  (Button) findViewById(R.id.button36_10_10_s);
            Button button37 =  (Button) findViewById(R.id.button37_10_10_s);
            Button button38 =  (Button) findViewById(R.id.button38_10_10_s);
            Button button39 =  (Button) findViewById(R.id.button39_10_10_s);
            Button button40 =  (Button) findViewById(R.id.button40_10_10_s);
            Button button41 =  (Button) findViewById(R.id.button41_10_10_s);
            Button button42 =  (Button) findViewById(R.id.button42_10_10_s);
            Button button43 =  (Button) findViewById(R.id.button43_10_10_s);
            Button button44 =  (Button) findViewById(R.id.button44_10_10_s);
            Button button45 =  (Button) findViewById(R.id.button45_10_10_s);
            Button button46 =  (Button) findViewById(R.id.button46_10_10_s);
            Button button47 =  (Button) findViewById(R.id.button47_10_10_s);
            Button button48 =  (Button) findViewById(R.id.button48_10_10_s);
            Button button49 =  (Button) findViewById(R.id.button49_10_10_s);
            Button button50 =  (Button) findViewById(R.id.button50_10_10_s);
            Button button51 =  (Button) findViewById(R.id.button51_10_10_s);
            Button button52 =  (Button) findViewById(R.id.button52_10_10_s);
            Button button53 =  (Button) findViewById(R.id.button53_10_10_s);
            Button button54 =  (Button) findViewById(R.id.button54_10_10_s);
            Button button55 =  (Button) findViewById(R.id.button55_10_10_s);
            Button button56 =  (Button) findViewById(R.id.button56_10_10_s);
            Button button57 =  (Button) findViewById(R.id.button57_10_10_s);
            Button button58 =  (Button) findViewById(R.id.button58_10_10_s);
            Button button59 =  (Button) findViewById(R.id.button59_10_10_s);
            Button button60 =  (Button) findViewById(R.id.button60_10_10_s);
            Button button61 =  (Button) findViewById(R.id.button61_10_10_s);
            Button button62 =  (Button) findViewById(R.id.button62_10_10_s);
            Button button63 =  (Button) findViewById(R.id.button63_10_10_s);
            Button button64 =  (Button) findViewById(R.id.button64_10_10_s);
            Button button65 =  (Button) findViewById(R.id.button65_10_10_s);
            Button button66 =  (Button) findViewById(R.id.button66_10_10_s);
            Button button67 =  (Button) findViewById(R.id.button67_10_10_s);
            Button button68 =  (Button) findViewById(R.id.button68_10_10_s);
            Button button69 =  (Button) findViewById(R.id.button69_10_10_s);
            Button button70 =  (Button) findViewById(R.id.button70_10_10_s);
            Button button71 =  (Button) findViewById(R.id.button71_10_10_s);
            Button button72 =  (Button) findViewById(R.id.button72_10_10_s);
            Button button73 =  (Button) findViewById(R.id.button73_10_10_s);
            Button button74 =  (Button) findViewById(R.id.button74_10_10_s);
            Button button75 =  (Button) findViewById(R.id.button75_10_10_s);
            Button button76 =  (Button) findViewById(R.id.button76_10_10_s);
            Button button77 =  (Button) findViewById(R.id.button77_10_10_s);
            Button button78 =  (Button) findViewById(R.id.button78_10_10_s);
            Button button79 =  (Button) findViewById(R.id.button79_10_10_s);
            Button button80 =  (Button) findViewById(R.id.button80_10_10_s);
            Button button81 =  (Button) findViewById(R.id.button81_10_10_s);
            Button button82 =  (Button) findViewById(R.id.button82_10_10_s);
            Button button83 =  (Button) findViewById(R.id.button83_10_10_s);
            Button button84 =  (Button) findViewById(R.id.button84_10_10_s);
            Button button85 =  (Button) findViewById(R.id.button85_10_10_s);
            Button button86 =  (Button) findViewById(R.id.button86_10_10_s);
            Button button87 =  (Button) findViewById(R.id.button87_10_10_s);
            Button button88 =  (Button) findViewById(R.id.button88_10_10_s);
            Button button89 =  (Button) findViewById(R.id.button89_10_10_s);
            Button button90 =  (Button) findViewById(R.id.button90_10_10_s);
            Button button91 =  (Button) findViewById(R.id.button91_10_10_s);
            Button button92 =  (Button) findViewById(R.id.button92_10_10_s);
            Button button93 =  (Button) findViewById(R.id.button93_10_10_s);
            Button button94 =  (Button) findViewById(R.id.button94_10_10_s);
            Button button95 =  (Button) findViewById(R.id.button95_10_10_s);
            Button button96 =  (Button) findViewById(R.id.button96_10_10_s);
            Button button97 =  (Button) findViewById(R.id.button97_10_10_s);
            Button button98 =  (Button) findViewById(R.id.button98_10_10_s);
            Button button99 =  (Button) findViewById(R.id.button99_10_10_s);
            Button button100 =  (Button) findViewById(R.id.button100_10_10_s);


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
                button26.setEnabled(true);
                button27.setEnabled(true);
                button28.setEnabled(true);
                button29.setEnabled(true);
                button30.setEnabled(true);
                button31.setEnabled(true);
                button32.setEnabled(true);
                button33.setEnabled(true);
                button34.setEnabled(true);
                button35.setEnabled(true);
                button36.setEnabled(true);
                button37.setEnabled(true);
                button38.setEnabled(true);
                button39.setEnabled(true);
                button40.setEnabled(true);
                button41.setEnabled(true);
                button42.setEnabled(true);
                button43.setEnabled(true);
                button44.setEnabled(true);
                button45.setEnabled(true);
                button46.setEnabled(true);
                button47.setEnabled(true);
                button48.setEnabled(true);
                button49.setEnabled(true);
                button50.setEnabled(true);
                button51.setEnabled(true);
                button52.setEnabled(true);
                button53.setEnabled(true);
                button54.setEnabled(true);
                button55.setEnabled(true);
                button56.setEnabled(true);
                button57.setEnabled(true);
                button58.setEnabled(true);
                button59.setEnabled(true);
                button60.setEnabled(true);
                button61.setEnabled(true);
                button62.setEnabled(true);
                button63.setEnabled(true);
                button64.setEnabled(true);
                button65.setEnabled(true);
                button66.setEnabled(true);
                button67.setEnabled(true);
                button68.setEnabled(true);
                button69.setEnabled(true);
                button70.setEnabled(true);
                button71.setEnabled(true);
                button72.setEnabled(true);
                button73.setEnabled(true);
                button74.setEnabled(true);
                button75.setEnabled(true);
                button76.setEnabled(true);
                button77.setEnabled(true);
                button78.setEnabled(true);
                button79.setEnabled(true);
                button80.setEnabled(true);
                button81.setEnabled(true);
                button82.setEnabled(true);
                button83.setEnabled(true);
                button84.setEnabled(true);
                button85.setEnabled(true);
                button86.setEnabled(true);
                button87.setEnabled(true);
                button88.setEnabled(true);
                button89.setEnabled(true);
                button90.setEnabled(true);
                button91.setEnabled(true);
                button92.setEnabled(true);
                button93.setEnabled(true);
                button94.setEnabled(true);
                button95.setEnabled(true);
                button96.setEnabled(true);
                button97.setEnabled(true);
                button98.setEnabled(true);
                button99.setEnabled(true);
                button100.setEnabled(true);

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
                scaleAnimation(saveX[26], saveY[26], button26);
                scaleAnimation(saveX[27], saveY[27], button27);
                scaleAnimation(saveX[28], saveY[28], button28);
                scaleAnimation(saveX[29], saveY[29], button29);
                scaleAnimation(saveX[30], saveY[30], button30);
                scaleAnimation(saveX[31], saveY[31], button31);
                scaleAnimation(saveX[32], saveY[32], button32);
                scaleAnimation(saveX[33], saveY[33], button33);
                scaleAnimation(saveX[34], saveY[34], button34);
                scaleAnimation(saveX[35], saveY[35], button35);
                scaleAnimation(saveX[36], saveY[36], button36);
                scaleAnimation(saveX[37], saveY[37], button37);
                scaleAnimation(saveX[38], saveY[38], button38);
                scaleAnimation(saveX[39], saveY[39], button39);
                scaleAnimation(saveX[40], saveY[40], button40);
                scaleAnimation(saveX[41], saveY[41], button41);
                scaleAnimation(saveX[42], saveY[42], button42);
                scaleAnimation(saveX[43], saveY[43], button43);
                scaleAnimation(saveX[44], saveY[44], button44);
                scaleAnimation(saveX[45], saveY[45], button45);
                scaleAnimation(saveX[46], saveY[46], button46);
                scaleAnimation(saveX[47], saveY[47], button47);
                scaleAnimation(saveX[48], saveY[48], button48);
                scaleAnimation(saveX[49], saveY[49], button49);
                scaleAnimation(saveX[50], saveY[50], button50);
                scaleAnimation(saveX[51], saveY[51], button51);
                scaleAnimation(saveX[52], saveY[52], button52);
                scaleAnimation(saveX[53], saveY[53], button53);
                scaleAnimation(saveX[54], saveY[54], button54);
                scaleAnimation(saveX[55], saveY[55], button55);
                scaleAnimation(saveX[56], saveY[56], button56);
                scaleAnimation(saveX[57], saveY[57], button57);
                scaleAnimation(saveX[58], saveY[58], button58);
                scaleAnimation(saveX[59], saveY[59], button59);
                scaleAnimation(saveX[60], saveY[60], button60);
                scaleAnimation(saveX[61], saveY[61], button61);
                scaleAnimation(saveX[62], saveY[62], button62);
                scaleAnimation(saveX[63], saveY[63], button63);
                scaleAnimation(saveX[64], saveY[64], button64);
                scaleAnimation(saveX[65], saveY[65], button65);
                scaleAnimation(saveX[66], saveY[66], button66);
                scaleAnimation(saveX[67], saveY[67], button67);
                scaleAnimation(saveX[68], saveY[68], button68);
                scaleAnimation(saveX[69], saveY[69], button69);
                scaleAnimation(saveX[70], saveY[70], button70);
                scaleAnimation(saveX[71], saveY[71], button71);
                scaleAnimation(saveX[72], saveY[72], button72);
                scaleAnimation(saveX[73], saveY[73], button73);
                scaleAnimation(saveX[74], saveY[74], button74);
                scaleAnimation(saveX[75], saveY[75], button75);
                scaleAnimation(saveX[76], saveY[76], button76);
                scaleAnimation(saveX[77], saveY[77], button77);
                scaleAnimation(saveX[78], saveY[78], button78);
                scaleAnimation(saveX[79], saveY[79], button79);
                scaleAnimation(saveX[80], saveY[80], button80);
                scaleAnimation(saveX[81], saveY[81], button81);
                scaleAnimation(saveX[82], saveY[82], button82);
                scaleAnimation(saveX[83], saveY[83], button83);
                scaleAnimation(saveX[84], saveY[84], button84);
                scaleAnimation(saveX[85], saveY[85], button85);
                scaleAnimation(saveX[86], saveY[86], button86);
                scaleAnimation(saveX[87], saveY[87], button87);
                scaleAnimation(saveX[88], saveY[88], button88);
                scaleAnimation(saveX[89], saveY[89], button89);
                scaleAnimation(saveX[90], saveY[90], button90);
                scaleAnimation(saveX[91], saveY[91], button91);
                scaleAnimation(saveX[92], saveY[92], button92);
                scaleAnimation(saveX[93], saveY[93], button93);
                scaleAnimation(saveX[94], saveY[94], button94);
                scaleAnimation(saveX[95], saveY[95], button95);
                scaleAnimation(saveX[96], saveY[96], button96);
                scaleAnimation(saveX[97], saveY[97], button97);
                scaleAnimation(saveX[98], saveY[98], button98);
                scaleAnimation(saveX[99], saveY[99], button99);
                scaleAnimation(saveX[100], saveY[100], button100);


                //TextView start = (TextView) findViewById(R.id.startText5_5);
                //alphaAnimation(start, 1250);
            }
        }

        Handler h = new Handler();
        //TextView ready = (TextView) findViewById(R.id.readyText5_5);
        //alphaAnimation(ready, 3000);
        h.postDelayed(new startHandler(), 3100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_10_10_single);

        final Button button1 =  (Button) findViewById(R.id.button1_10_10_s);
        final Button button2 =  (Button) findViewById(R.id.button2_10_10_s);
        final Button button3 =  (Button) findViewById(R.id.button3_10_10_s);
        final Button button4 =  (Button) findViewById(R.id.button4_10_10_s);
        final Button button5 =  (Button) findViewById(R.id.button5_10_10_s);
        final Button button6 =  (Button) findViewById(R.id.button6_10_10_s);
        final Button button7 =  (Button) findViewById(R.id.button7_10_10_s);
        final Button button8 =  (Button) findViewById(R.id.button8_10_10_s);
        final Button button9 =  (Button) findViewById(R.id.button9_10_10_s);
        final Button button10 =  (Button) findViewById(R.id.button10_10_10_s);
        final Button button11 =  (Button) findViewById(R.id.button11_10_10_s);
        final Button button12 =  (Button) findViewById(R.id.button12_10_10_s);
        final Button button13 =  (Button) findViewById(R.id.button13_10_10_s);
        final Button button14 =  (Button) findViewById(R.id.button14_10_10_s);
        final Button button15 =  (Button) findViewById(R.id.button15_10_10_s);
        final Button button16 =  (Button) findViewById(R.id.button16_10_10_s);
        final Button button17 =  (Button) findViewById(R.id.button17_10_10_s);
        final Button button18 =  (Button) findViewById(R.id.button18_10_10_s);
        final Button button19 =  (Button) findViewById(R.id.button19_10_10_s);
        final Button button20 =  (Button) findViewById(R.id.button20_10_10_s);
        final Button button21 =  (Button) findViewById(R.id.button21_10_10_s);
        final Button button22 =  (Button) findViewById(R.id.button22_10_10_s);
        final Button button23 =  (Button) findViewById(R.id.button23_10_10_s);
        final Button button24 =  (Button) findViewById(R.id.button24_10_10_s);
        final Button button25 =  (Button) findViewById(R.id.button25_10_10_s);
        final Button button26 =  (Button) findViewById(R.id.button26_10_10_s);
        final Button button27 =  (Button) findViewById(R.id.button27_10_10_s);
        final Button button28 =  (Button) findViewById(R.id.button28_10_10_s);
        final Button button29 =  (Button) findViewById(R.id.button29_10_10_s);
        final Button button30 =  (Button) findViewById(R.id.button30_10_10_s);
        final Button button31 =  (Button) findViewById(R.id.button31_10_10_s);
        final Button button32 =  (Button) findViewById(R.id.button32_10_10_s);
        final Button button33 =  (Button) findViewById(R.id.button33_10_10_s);
        final Button button34 =  (Button) findViewById(R.id.button34_10_10_s);
        final Button button35 =  (Button) findViewById(R.id.button35_10_10_s);
        final Button button36 =  (Button) findViewById(R.id.button36_10_10_s);
        final Button button37 =  (Button) findViewById(R.id.button37_10_10_s);
        final Button button38 =  (Button) findViewById(R.id.button38_10_10_s);
        final Button button39 =  (Button) findViewById(R.id.button39_10_10_s);
        final Button button40 =  (Button) findViewById(R.id.button40_10_10_s);
        final Button button41 =  (Button) findViewById(R.id.button41_10_10_s);
        final Button button42 =  (Button) findViewById(R.id.button42_10_10_s);
        final Button button43 =  (Button) findViewById(R.id.button43_10_10_s);
        final Button button44 =  (Button) findViewById(R.id.button44_10_10_s);
        final Button button45 =  (Button) findViewById(R.id.button45_10_10_s);
        final Button button46 =  (Button) findViewById(R.id.button46_10_10_s);
        final Button button47 =  (Button) findViewById(R.id.button47_10_10_s);
        final Button button48 =  (Button) findViewById(R.id.button48_10_10_s);
        final Button button49 =  (Button) findViewById(R.id.button49_10_10_s);
        final Button button50 =  (Button) findViewById(R.id.button50_10_10_s);
        final Button button51 =  (Button) findViewById(R.id.button51_10_10_s);
        final Button button52 =  (Button) findViewById(R.id.button52_10_10_s);
        final Button button53 =  (Button) findViewById(R.id.button53_10_10_s);
        final Button button54 =  (Button) findViewById(R.id.button54_10_10_s);
        final Button button55 =  (Button) findViewById(R.id.button55_10_10_s);
        final Button button56 =  (Button) findViewById(R.id.button56_10_10_s);
        final Button button57 =  (Button) findViewById(R.id.button57_10_10_s);
        final Button button58 =  (Button) findViewById(R.id.button58_10_10_s);
        final Button button59 =  (Button) findViewById(R.id.button59_10_10_s);
        final Button button60 =  (Button) findViewById(R.id.button60_10_10_s);
        final Button button61 =  (Button) findViewById(R.id.button61_10_10_s);
        final Button button62 =  (Button) findViewById(R.id.button62_10_10_s);
        final Button button63 =  (Button) findViewById(R.id.button63_10_10_s);
        final Button button64 =  (Button) findViewById(R.id.button64_10_10_s);
        final Button button65 =  (Button) findViewById(R.id.button65_10_10_s);
        final Button button66 =  (Button) findViewById(R.id.button66_10_10_s);
        final Button button67 =  (Button) findViewById(R.id.button67_10_10_s);
        final Button button68 =  (Button) findViewById(R.id.button68_10_10_s);
        final Button button69 =  (Button) findViewById(R.id.button69_10_10_s);
        final Button button70 =  (Button) findViewById(R.id.button70_10_10_s);
        final Button button71 =  (Button) findViewById(R.id.button71_10_10_s);
        final Button button72 =  (Button) findViewById(R.id.button72_10_10_s);
        final Button button73 =  (Button) findViewById(R.id.button73_10_10_s);
        final Button button74 =  (Button) findViewById(R.id.button74_10_10_s);
        final Button button75 =  (Button) findViewById(R.id.button75_10_10_s);
        final Button button76 =  (Button) findViewById(R.id.button76_10_10_s);
        final Button button77 =  (Button) findViewById(R.id.button77_10_10_s);
        final Button button78 =  (Button) findViewById(R.id.button78_10_10_s);
        final Button button79 =  (Button) findViewById(R.id.button79_10_10_s);
        final Button button80 =  (Button) findViewById(R.id.button80_10_10_s);
        final Button button81 =  (Button) findViewById(R.id.button81_10_10_s);
        final Button button82 =  (Button) findViewById(R.id.button82_10_10_s);
        final Button button83 =  (Button) findViewById(R.id.button83_10_10_s);
        final Button button84 =  (Button) findViewById(R.id.button84_10_10_s);
        final Button button85 =  (Button) findViewById(R.id.button85_10_10_s);
        final Button button86 =  (Button) findViewById(R.id.button86_10_10_s);
        final Button button87 =  (Button) findViewById(R.id.button87_10_10_s);
        final Button button88 =  (Button) findViewById(R.id.button88_10_10_s);
        final Button button89 =  (Button) findViewById(R.id.button89_10_10_s);
        final Button button90 =  (Button) findViewById(R.id.button90_10_10_s);
        final Button button91 =  (Button) findViewById(R.id.button91_10_10_s);
        final Button button92 =  (Button) findViewById(R.id.button92_10_10_s);
        final Button button93 =  (Button) findViewById(R.id.button93_10_10_s);
        final Button button94 =  (Button) findViewById(R.id.button94_10_10_s);
        final Button button95 =  (Button) findViewById(R.id.button95_10_10_s);
        final Button button96 =  (Button) findViewById(R.id.button96_10_10_s);
        final Button button97 =  (Button) findViewById(R.id.button97_10_10_s);
        final Button button98 =  (Button) findViewById(R.id.button98_10_10_s);
        final Button button99 =  (Button) findViewById(R.id.button99_10_10_s);
        final Button button100 =  (Button) findViewById(R.id.button100_10_10_s);

        Button finishButton1 = (Button) findViewById(R.id.finishButton10_10_s);

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
                if (button26.getX() == buttonLayoutX[26] && button26.getY() == buttonLayoutY[26])
                    checkAnswer++;
                if (button27.getX() == buttonLayoutX[27] && button27.getY() == buttonLayoutY[27])
                    checkAnswer++;
                if (button28.getX() == buttonLayoutX[28] && button28.getY() == buttonLayoutY[28])
                    checkAnswer++;
                if (button29.getX() == buttonLayoutX[29] && button29.getY() == buttonLayoutY[29])
                    checkAnswer++;
                if (button30.getX() == buttonLayoutX[30] && button30.getY() == buttonLayoutY[30])
                    checkAnswer++;
                if (button31.getX() == buttonLayoutX[31] && button31.getY() == buttonLayoutY[31])
                    checkAnswer++;
                if (button32.getX() == buttonLayoutX[32] && button32.getY() == buttonLayoutY[32])
                    checkAnswer++;
                if (button33.getX() == buttonLayoutX[33] && button33.getY() == buttonLayoutY[33])
                    checkAnswer++;
                if (button34.getX() == buttonLayoutX[34] && button34.getY() == buttonLayoutY[34])
                    checkAnswer++;
                if (button35.getX() == buttonLayoutX[35] && button35.getY() == buttonLayoutY[35])
                    checkAnswer++;
                if (button36.getX() == buttonLayoutX[36] && button36.getY() == buttonLayoutY[36])
                    checkAnswer++;
                if (button37.getX() == buttonLayoutX[37] && button37.getY() == buttonLayoutY[37])
                    checkAnswer++;
                if (button38.getX() == buttonLayoutX[38] && button38.getY() == buttonLayoutY[38])
                    checkAnswer++;
                if (button39.getX() == buttonLayoutX[39] && button39.getY() == buttonLayoutY[39])
                    checkAnswer++;
                if (button40.getX() == buttonLayoutX[40] && button40.getY() == buttonLayoutY[40])
                    checkAnswer++;
                if (button41.getX() == buttonLayoutX[41] && button41.getY() == buttonLayoutY[41])
                    checkAnswer++;
                if (button42.getX() == buttonLayoutX[42] && button42.getY() == buttonLayoutY[42])
                    checkAnswer++;
                if (button43.getX() == buttonLayoutX[43] && button43.getY() == buttonLayoutY[43])
                    checkAnswer++;
                if (button44.getX() == buttonLayoutX[44] && button44.getY() == buttonLayoutY[44])
                    checkAnswer++;
                if (button45.getX() == buttonLayoutX[45] && button45.getY() == buttonLayoutY[45])
                    checkAnswer++;
                if (button46.getX() == buttonLayoutX[46] && button46.getY() == buttonLayoutY[46])
                    checkAnswer++;
                if (button47.getX() == buttonLayoutX[47] && button47.getY() == buttonLayoutY[47])
                    checkAnswer++;
                if (button48.getX() == buttonLayoutX[48] && button48.getY() == buttonLayoutY[48])
                    checkAnswer++;
                if (button49.getX() == buttonLayoutX[49] && button49.getY() == buttonLayoutY[49])
                    checkAnswer++;
                if (button50.getX() == buttonLayoutX[50] && button50.getY() == buttonLayoutY[50])
                    checkAnswer++;
                if (button51.getX() == buttonLayoutX[51] && button51.getY() == buttonLayoutY[51])
                    checkAnswer++;
                if (button52.getX() == buttonLayoutX[52] && button52.getY() == buttonLayoutY[52])
                    checkAnswer++;
                if (button53.getX() == buttonLayoutX[53] && button53.getY() == buttonLayoutY[53])
                    checkAnswer++;
                if (button54.getX() == buttonLayoutX[54] && button54.getY() == buttonLayoutY[54])
                    checkAnswer++;
                if (button55.getX() == buttonLayoutX[55] && button55.getY() == buttonLayoutY[55])
                    checkAnswer++;
                if (button56.getX() == buttonLayoutX[56] && button56.getY() == buttonLayoutY[56])
                    checkAnswer++;
                if (button57.getX() == buttonLayoutX[57] && button57.getY() == buttonLayoutY[57])
                    checkAnswer++;
                if (button58.getX() == buttonLayoutX[58] && button58.getY() == buttonLayoutY[58])
                    checkAnswer++;
                if (button59.getX() == buttonLayoutX[59] && button59.getY() == buttonLayoutY[59])
                    checkAnswer++;
                if (button60.getX() == buttonLayoutX[60] && button60.getY() == buttonLayoutY[60])
                    checkAnswer++;
                if (button61.getX() == buttonLayoutX[61] && button61.getY() == buttonLayoutY[61])
                    checkAnswer++;
                if (button62.getX() == buttonLayoutX[62] && button62.getY() == buttonLayoutY[62])
                    checkAnswer++;
                if (button63.getX() == buttonLayoutX[63] && button63.getY() == buttonLayoutY[63])
                    checkAnswer++;
                if (button64.getX() == buttonLayoutX[64] && button64.getY() == buttonLayoutY[64])
                    checkAnswer++;
                if (button65.getX() == buttonLayoutX[65] && button65.getY() == buttonLayoutY[65])
                    checkAnswer++;
                if (button66.getX() == buttonLayoutX[66] && button66.getY() == buttonLayoutY[66])
                    checkAnswer++;
                if (button67.getX() == buttonLayoutX[67] && button67.getY() == buttonLayoutY[67])
                    checkAnswer++;
                if (button68.getX() == buttonLayoutX[68] && button68.getY() == buttonLayoutY[68])
                    checkAnswer++;
                if (button69.getX() == buttonLayoutX[69] && button69.getY() == buttonLayoutY[69])
                    checkAnswer++;
                if (button70.getX() == buttonLayoutX[70] && button70.getY() == buttonLayoutY[70])
                    checkAnswer++;
                if (button71.getX() == buttonLayoutX[71] && button71.getY() == buttonLayoutY[71])
                    checkAnswer++;
                if (button72.getX() == buttonLayoutX[72] && button72.getY() == buttonLayoutY[72])
                    checkAnswer++;
                if (button73.getX() == buttonLayoutX[73] && button73.getY() == buttonLayoutY[73])
                    checkAnswer++;
                if (button74.getX() == buttonLayoutX[74] && button74.getY() == buttonLayoutY[74])
                    checkAnswer++;
                if (button75.getX() == buttonLayoutX[75] && button75.getY() == buttonLayoutY[75])
                    checkAnswer++;
                if (button76.getX() == buttonLayoutX[76] && button76.getY() == buttonLayoutY[76])
                    checkAnswer++;
                if (button77.getX() == buttonLayoutX[77] && button77.getY() == buttonLayoutY[77])
                    checkAnswer++;
                if (button78.getX() == buttonLayoutX[78] && button78.getY() == buttonLayoutY[78])
                    checkAnswer++;
                if (button79.getX() == buttonLayoutX[79] && button79.getY() == buttonLayoutY[79])
                    checkAnswer++;
                if (button80.getX() == buttonLayoutX[80] && button80.getY() == buttonLayoutY[80])
                    checkAnswer++;
                if (button81.getX() == buttonLayoutX[81] && button81.getY() == buttonLayoutY[81])
                    checkAnswer++;
                if (button82.getX() == buttonLayoutX[82] && button82.getY() == buttonLayoutY[82])
                    checkAnswer++;
                if (button83.getX() == buttonLayoutX[83] && button83.getY() == buttonLayoutY[83])
                    checkAnswer++;
                if (button84.getX() == buttonLayoutX[84] && button84.getY() == buttonLayoutY[84])
                    checkAnswer++;
                if (button85.getX() == buttonLayoutX[85] && button85.getY() == buttonLayoutY[85])
                    checkAnswer++;
                if (button86.getX() == buttonLayoutX[86] && button86.getY() == buttonLayoutY[86])
                    checkAnswer++;
                if (button87.getX() == buttonLayoutX[87] && button87.getY() == buttonLayoutY[87])
                    checkAnswer++;
                if (button88.getX() == buttonLayoutX[88] && button88.getY() == buttonLayoutY[88])
                    checkAnswer++;
                if (button89.getX() == buttonLayoutX[89] && button89.getY() == buttonLayoutY[89])
                    checkAnswer++;
                if (button90.getX() == buttonLayoutX[90] && button90.getY() == buttonLayoutY[90])
                    checkAnswer++;
                if (button91.getX() == buttonLayoutX[91] && button91.getY() == buttonLayoutY[91])
                    checkAnswer++;
                if (button92.getX() == buttonLayoutX[92] && button92.getY() == buttonLayoutY[92])
                    checkAnswer++;
                if (button93.getX() == buttonLayoutX[93] && button93.getY() == buttonLayoutY[93])
                    checkAnswer++;
                if (button94.getX() == buttonLayoutX[94] && button94.getY() == buttonLayoutY[94])
                    checkAnswer++;
                if (button95.getX() == buttonLayoutX[95] && button95.getY() == buttonLayoutY[95])
                    checkAnswer++;
                if (button96.getX() == buttonLayoutX[96] && button96.getY() == buttonLayoutY[96])
                    checkAnswer++;
                if (button97.getX() == buttonLayoutX[97] && button97.getY() == buttonLayoutY[97])
                    checkAnswer++;
                if (button98.getX() == buttonLayoutX[98] && button98.getY() == buttonLayoutY[98])
                    checkAnswer++;
                if (button99.getX() == buttonLayoutX[99] && button99.getY() == buttonLayoutY[99])
                    checkAnswer++;
                if (button100.getX() == buttonLayoutX[100] && button100.getY() == buttonLayoutY[100])
                    checkAnswer++;

                if (checkAnswer == 100) {
                    finish();
                }
            }
        });

        getStandardSize();

        buttonLength = standardSize_X / 10;
        saveLastLine = (standardSize_X / 10) * 10;
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

        button26.setWidth((int) buttonLength);
        button26.setHeight((int) buttonLength);

        button27.setWidth((int) buttonLength);
        button27.setHeight((int) buttonLength);

        button28.setWidth((int) buttonLength);
        button28.setHeight((int) buttonLength);

        button29.setWidth((int) buttonLength);
        button29.setHeight((int) buttonLength);

        button30.setWidth((int) buttonLength);
        button30.setHeight((int) buttonLength);

        button31.setWidth((int) buttonLength);
        button31.setHeight((int) buttonLength);

        button32.setWidth((int) buttonLength);
        button32.setHeight((int) buttonLength);

        button33.setWidth((int) buttonLength);
        button33.setHeight((int) buttonLength);

        button34.setWidth((int) buttonLength);
        button34.setHeight((int) buttonLength);

        button35.setWidth((int) buttonLength);
        button35.setHeight((int) buttonLength);

        button36.setWidth((int) buttonLength);
        button36.setHeight((int) buttonLength);

        button37.setWidth((int) buttonLength);
        button37.setHeight((int) buttonLength);

        button38.setWidth((int) buttonLength);
        button38.setHeight((int) buttonLength);

        button39.setWidth((int) buttonLength);
        button39.setHeight((int) buttonLength);

        button40.setWidth((int) buttonLength);
        button40.setHeight((int) buttonLength);

        button41.setWidth((int) buttonLength);
        button41.setHeight((int) buttonLength);

        button42.setWidth((int) buttonLength);
        button42.setHeight((int) buttonLength);

        button43.setWidth((int) buttonLength);
        button43.setHeight((int) buttonLength);

        button44.setWidth((int) buttonLength);
        button44.setHeight((int) buttonLength);

        button45.setWidth((int) buttonLength);
        button45.setHeight((int) buttonLength);

        button46.setWidth((int) buttonLength);
        button46.setHeight((int) buttonLength);

        button47.setWidth((int) buttonLength);
        button47.setHeight((int) buttonLength);

        button48.setWidth((int) buttonLength);
        button48.setHeight((int) buttonLength);

        button49.setWidth((int) buttonLength);
        button49.setHeight((int) buttonLength);

        button50.setWidth((int) buttonLength);
        button50.setHeight((int) buttonLength);

        button51.setWidth((int) buttonLength);
        button51.setHeight((int) buttonLength);

        button52.setWidth((int) buttonLength);
        button52.setHeight((int) buttonLength);

        button53.setWidth((int) buttonLength);
        button53.setHeight((int) buttonLength);

        button54.setWidth((int) buttonLength);
        button54.setHeight((int) buttonLength);

        button55.setWidth((int) buttonLength);
        button55.setHeight((int) buttonLength);

        button56.setWidth((int) buttonLength);
        button56.setHeight((int) buttonLength);

        button57.setWidth((int) buttonLength);
        button57.setHeight((int) buttonLength);

        button58.setWidth((int) buttonLength);
        button58.setHeight((int) buttonLength);

        button59.setWidth((int) buttonLength);
        button59.setHeight((int) buttonLength);

        button60.setWidth((int) buttonLength);
        button60.setHeight((int) buttonLength);

        button61.setWidth((int) buttonLength);
        button61.setHeight((int) buttonLength);

        button62.setWidth((int) buttonLength);
        button62.setHeight((int) buttonLength);

        button63.setWidth((int) buttonLength);
        button63.setHeight((int) buttonLength);

        button64.setWidth((int) buttonLength);
        button64.setHeight((int) buttonLength);

        button65.setWidth((int) buttonLength);
        button65.setHeight((int) buttonLength);

        button66.setWidth((int) buttonLength);
        button66.setHeight((int) buttonLength);

        button67.setWidth((int) buttonLength);
        button67.setHeight((int) buttonLength);

        button68.setWidth((int) buttonLength);
        button68.setHeight((int) buttonLength);

        button69.setWidth((int) buttonLength);
        button69.setHeight((int) buttonLength);

        button70.setWidth((int) buttonLength);
        button70.setHeight((int) buttonLength);

        button71.setWidth((int) buttonLength);
        button71.setHeight((int) buttonLength);

        button72.setWidth((int) buttonLength);
        button72.setHeight((int) buttonLength);

        button73.setWidth((int) buttonLength);
        button73.setHeight((int) buttonLength);

        button74.setWidth((int) buttonLength);
        button74.setHeight((int) buttonLength);

        button75.setWidth((int) buttonLength);
        button75.setHeight((int) buttonLength);

        button76.setWidth((int) buttonLength);
        button76.setHeight((int) buttonLength);

        button77.setWidth((int) buttonLength);
        button77.setHeight((int) buttonLength);

        button78.setWidth((int) buttonLength);
        button78.setHeight((int) buttonLength);

        button79.setWidth((int) buttonLength);
        button79.setHeight((int) buttonLength);

        button80.setWidth((int) buttonLength);
        button80.setHeight((int) buttonLength);

        button81.setWidth((int) buttonLength);
        button81.setHeight((int) buttonLength);

        button82.setWidth((int) buttonLength);
        button82.setHeight((int) buttonLength);

        button83.setWidth((int) buttonLength);
        button83.setHeight((int) buttonLength);

        button84.setWidth((int) buttonLength);
        button84.setHeight((int) buttonLength);

        button85.setWidth((int) buttonLength);
        button85.setHeight((int) buttonLength);

        button86.setWidth((int) buttonLength);
        button86.setHeight((int) buttonLength);

        button87.setWidth((int) buttonLength);
        button87.setHeight((int) buttonLength);

        button88.setWidth((int) buttonLength);
        button88.setHeight((int) buttonLength);

        button89.setWidth((int) buttonLength);
        button89.setHeight((int) buttonLength);

        button90.setWidth((int) buttonLength);
        button90.setHeight((int) buttonLength);

        button91.setWidth((int) buttonLength);
        button91.setHeight((int) buttonLength);

        button92.setWidth((int) buttonLength);
        button92.setHeight((int) buttonLength);

        button93.setWidth((int) buttonLength);
        button93.setHeight((int) buttonLength);

        button94.setWidth((int) buttonLength);
        button94.setHeight((int) buttonLength);

        button95.setWidth((int) buttonLength);
        button95.setHeight((int) buttonLength);

        button96.setWidth((int) buttonLength);
        button96.setHeight((int) buttonLength);

        button97.setWidth((int) buttonLength);
        button97.setHeight((int) buttonLength);

        button98.setWidth((int) buttonLength);
        button98.setHeight((int) buttonLength);

        button99.setWidth((int) buttonLength);
        button99.setHeight((int) buttonLength);

        button100.setWidth((int) buttonLength);
        button100.setHeight((int) buttonLength);

        for (int i = 1; i < 101; i++) {
            if (i < 11)
                buttonLayoutY[i] = 0;
            else if (i < 21)
                buttonLayoutY[i] = buttonLength;
            else if (i < 31)
                buttonLayoutY[i] = buttonLength * 2;
            else if (i < 41)
                buttonLayoutY[i] = buttonLength * 3;
            else if (i < 51)
                buttonLayoutY[i] = buttonLength * 4;
            else if (i < 61)
                buttonLayoutY[i] = buttonLength * 5;
            else if (i < 71)
                buttonLayoutY[i] = buttonLength * 6;
            else if (i < 81)
                buttonLayoutY[i] = buttonLength * 7;
            else if (i < 91)
                buttonLayoutY[i] = buttonLength * 8;
            else if (i < 101)
                buttonLayoutY[i] = buttonLength * 9;

            if (i % 10 == 1)
                buttonLayoutX[i] = 0;
            else if (i % 10 == 2)
                buttonLayoutX[i] = buttonLength;
            else if (i % 10 == 3)
                buttonLayoutX[i] = buttonLength * 2;
            else if (i % 10 == 4)
                buttonLayoutX[i] = buttonLength * 3;
            else if(i % 10 == 5)
                buttonLayoutX[i] = buttonLength * 4;
            else if(i % 10 == 6)
                buttonLayoutX[i] = buttonLength * 5;
            else if(i % 10 == 7)
                buttonLayoutX[i] = buttonLength * 6;
            else if(i % 10 == 8)
                buttonLayoutX[i] = buttonLength * 7;
            else if(i % 10 == 9)
                buttonLayoutX[i] = buttonLength * 8;
            else if(i % 10 == 0)
                buttonLayoutX[i] = buttonLength * 9;

            System.out.println(buttonLayoutX[i] + " " + buttonLayoutY[i]);
        }
    }
}
