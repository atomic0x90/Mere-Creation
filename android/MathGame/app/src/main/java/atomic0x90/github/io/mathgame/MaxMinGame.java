package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Locale;
import java.util.Random;

public class MaxMinGame extends AppCompatActivity {

    double remainTime;
    //Sound
    SoundPool soundPool;
    int soundID;

    //Double click check
    private long mLastClickTime = 0;
    //AD
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_min_game);

        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound01,1);


        //AD

        mAdView = findViewById(R.id.adView10);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        final TextView timetextView = (TextView)findViewById(R.id.MaxMinText);

        final CountDownTimer countDownTimer = new CountDownTimer(61000, 1000) {
            public void onTick(long millisUntilFinished) {
                remainTime = millisUntilFinished/1000L;
                timetextView.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
            }
            public void onFinish() {
                timetextView.setText("Time Over");

                Intent Finishintent = getIntent();
                int tmpNumber = Finishintent.getIntExtra("Number_of_time",0);
                int[] tmparr = Finishintent.getIntArrayExtra("Answer_state");
                double avtime = Finishintent.getDoubleExtra("Average_time",0);
                String tmpResultType = Finishintent.getStringExtra("Result_type");
                if(tmpNumber == 5) {
                    //Need Fix
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), MaxMinGame.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    tmparr[tmpNumber] = -1;

                    avtime = ((avtime * tmpNumber) + (60))/(tmpNumber + 1);

                    intent.putExtra("Number_of_time",tmpNumber+1);
                    intent.putExtra("Answer_state",tmparr);
                    intent.putExtra("Average_time",avtime);
                    intent.putExtra("Result_type",tmpResultType);

                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
            }
        }.start();

        Intent intent = getIntent();

        int tmpNumber = intent.getIntExtra("Number_of_time",0);
        int[] arr = intent.getIntArrayExtra("Answer_state");
        double avtime = intent.getDoubleExtra("Average_time",0);
        String ResultType = intent.getStringExtra("Result_type");

        if(tmpNumber == 5){
            countDownTimer.cancel();

            int num = 0;
            for(int i = 0;i < 5;i++)
            {
                if(arr[i] == 1)
                    num++;
            }

            Intent Endintent = new Intent(getApplicationContext(), CustomDialog.class);
            Endintent.putExtra("Result_type",ResultType);
            Endintent.putExtra("Average_time",avtime);
            Endintent.putExtra("Answer_num",num);
            Endintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(Endintent);
        }
        else{
            ImageView imageView0 = (ImageView)findViewById(R.id.MaxMinState0);
            ImageView imageView1 = (ImageView)findViewById(R.id.MaxMinState1);
            ImageView imageView2 = (ImageView)findViewById(R.id.MaxMinState2);
            ImageView imageView3 = (ImageView)findViewById(R.id.MaxMinState3);
            ImageView imageView4 = (ImageView)findViewById(R.id.MaxMinState4);

            // 0번 state img
            if(arr[0] == 1)
                imageView0.setImageResource(R.drawable.green_dot);
            else if(arr[0] == -1)
                imageView0.setImageResource(R.drawable.red_dot);
            else
                imageView0.setImageResource(R.drawable.gray_dot);

            // 1번 state img
            if(arr[1] == 1)
                imageView1.setImageResource(R.drawable.green_dot);
            else if(arr[1] == -1)
                imageView1.setImageResource(R.drawable.red_dot);
            else
                imageView1.setImageResource(R.drawable.gray_dot);

            // 2번 state img
            if(arr[2] == 1)
                imageView2.setImageResource(R.drawable.green_dot);
            else if(arr[2] == -1)
                imageView2.setImageResource(R.drawable.red_dot);
            else
                imageView2.setImageResource(R.drawable.gray_dot);

            // 3번 state img
            if(arr[3] == 1)
                imageView3.setImageResource(R.drawable.green_dot);
            else if(arr[3] == -1)
                imageView3.setImageResource(R.drawable.red_dot);
            else
                imageView3.setImageResource(R.drawable.gray_dot);

            // 4번 state img
            if(arr[4] == 1)
                imageView4.setImageResource(R.drawable.green_dot);
            else if(arr[4] == -1)
                imageView4.setImageResource(R.drawable.red_dot);
            else
                imageView4.setImageResource(R.drawable.gray_dot);

        }

        TextView textViewMiddle = (TextView)findViewById(R.id.MaxMinMiddleText);

        Button button1 = (Button)findViewById(R.id.MaxMinB1);
        Button button2 = (Button)findViewById(R.id.MaxMinB2);
        Button button3 = (Button)findViewById(R.id.MaxMinB3);
        Button button4 = (Button)findViewById(R.id.MaxMinB4);

        int max = 0,min = 0;
        int randType;   //+- or */
        int randSequence;
        int randNum1 = 0,randNum2 = 0,randNum3 = 0,randNum4 = 0;    //result value
        int Bresult1 = 0,Bresult2 = 0,Bresult3 = 0,Bresult4 = 0;

        int tmp;
        int check;

        String save1 = null,save2 = null,save3 = null,save4 = null;     //save text

        long seed = System.currentTimeMillis();
        Random random = new Random(seed);

        final int textRandom = random.nextInt(2);
        if(textRandom == 0){
            textViewMiddle.setText("최댓값은?");
        }
        else{
            textViewMiddle.setText("최솟값은?");
        }

        random.setSeed(System.currentTimeMillis());

        if(ResultType.equals("MaxMin1_10")){
            randNum1 = random.nextInt(3)+1;  //1 <=  <= 3
            randNum2 = random.nextInt(3)+4;  //4 <=  <= 6
            randNum3 = random.nextInt(2)+7;  //7 <=  <= 8
            randNum4 = random.nextInt(2)+9;  //9 <=  <= 10

            min = randNum1;
            max = randNum4;
            random.setSeed(System.currentTimeMillis());

            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());

            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(12)+1;

            check = 0;
            for(double i = 2;i <= 60;i++){
                for(double j = 3;j <= 60;j++){
                    for(double l = 2;l <= 60;l++){
                        if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }

            random.setSeed(System.currentTimeMillis());
            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(10)+1;

            check = 0;

            for(double i = 3;i <= 60;i++){
                for(double j = 4;j <= 60;j++){
                    for(double l = 3;l <= 60;l++){
                        if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }


            random.setSeed(System.currentTimeMillis());
            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(15)+1;

            check = 0;

            for(double i = 2;i <= 60;i++){
                for(double j = 5;j <= 60;j++){
                    for(double l = 5;l <= 60;l++){
                        if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }


            random.setSeed(System.currentTimeMillis());
            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(13)+1;

            check = 0;

            for(double i = 6;i <= 60;i++){
                for(double j = 2;j <= 60;j++){
                    for(double l = 8;l <= 60;l++){
                        if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }


        }
        else if(ResultType.equals("MaxMin10_20")){
            randNum1 = random.nextInt(3)+10;  //10 <=  <= 13
            randNum2 = random.nextInt(3)+14;  //14 <=  <= 16
            randNum3 = random.nextInt(2)+17;  //17 <=  <= 18
            randNum4 = random.nextInt(2)+19;  //19 <=  <= 20

            min = randNum1;
            max = randNum4;
            random.setSeed(System.currentTimeMillis());

            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());

            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(12)+1;

            check = 0;
            for(double i = 3;i <= 60;i++){
                for(double j = 3;j <= 60;j++){
                    for(double l = 2;l <= 60;l++){
                        if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }

            random.setSeed(System.currentTimeMillis());
            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(20)+1;

            check = 0;

            for(double i = 3;i <= 60;i++){
                for(double j = 4;j <= 60;j++){
                    for(double l = 3;l <= 60;l++){
                        if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }


            random.setSeed(System.currentTimeMillis());
            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(11)+1;

            check = 0;

            for(double i = 2;i <= 60;i++){
                for(double j = 5;j <= 60;j++){
                    for(double l = 7;l <= 60;l++){
                        if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }


            random.setSeed(System.currentTimeMillis());
            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(13)+1;

            check = 0;

            for(double i = 6;i <= 60;i++){
                for(double j = 2;j <= 60;j++){
                    for(double l = 8;l <= 60;l++){
                        if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }
        }
        else if(ResultType.equals("MaxMin20_30")){
            randNum1 = random.nextInt(3)+20;  //20 <=  <= 23
            randNum2 = random.nextInt(3)+24;  //24 <=  <= 26
            randNum3 = random.nextInt(2)+27;  //27 <=  <= 28
            randNum4 = random.nextInt(2)+29;  //29 <=  <= 30

            min = randNum1;
            max = randNum4;
            random.setSeed(System.currentTimeMillis());

            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());

            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(12)+1;

            check = 0;
            for(double i = 6;i <= 60;i++){
                for(double j = 7;j <= 60;j++){
                    for(double l = 3;l <= 60;l++){
                        if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum1){
                                    check++;
                                    if(check == tmp){
                                        save1 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }

            random.setSeed(System.currentTimeMillis());
            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(14)+1;

            check = 0;

            for(double i = 5;i <= 60;i++){
                for(double j = 4;j <= 60;j++){
                    for(double l = 3;l <= 60;l++){
                        if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum2){
                                    check++;
                                    if(check == tmp){
                                        save2 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }


            random.setSeed(System.currentTimeMillis());
            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(15)+1;

            check = 0;

            for(double i = 2;i <= 60;i++){
                for(double j = 5;j <= 60;j++){
                    for(double l = 6;l <= 60;l++){
                        if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum3){
                                    check++;
                                    if(check == tmp){
                                        save3 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }


            random.setSeed(System.currentTimeMillis());
            randType = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            randSequence = random.nextInt(2);

            random.setSeed(System.currentTimeMillis());
            tmp = random.nextInt(13)+1;

            check = 0;

            for(double i = 9;i <= 60;i++){
                for(double j = 2;j <= 60;j++){
                    for(double l = 4;l <= 60;l++){
                        if(randType == 1 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i - j + l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " - " + (int)j + " + " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i + j - l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " + " + (int)j + " - " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(randType == 0 && i != j && j != l && i != l){
                            if(randSequence == 0){
                                if(i * j / l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " X " + (int)j + " ÷ " + (int)l;
                                        break;
                                    }
                                }
                            }
                            else{
                                if(i / j * l == randNum4){
                                    check++;
                                    if(check == tmp){
                                        save4 = (int)i + " ÷ " + (int)j + " X " + (int)l;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(check == tmp)
                        break;
                }
                if(check == tmp)
                    break;
            }
        }

        int setText = random.nextInt(8);

        if(setText == 0){
            button1.setText(save1);
            Bresult1 = randNum1;
            button2.setText(save3);
            Bresult2 = randNum3;
            button3.setText(save2);
            Bresult3 = randNum2;
            button4.setText(save4);
            Bresult4 = randNum4;
        }
        else if(setText == 1){
            button1.setText(save2);
            Bresult1 = randNum2;
            button2.setText(save3);
            Bresult2 = randNum3;
            button3.setText(save1);
            Bresult3 = randNum1;
            button4.setText(save4);
            Bresult4 = randNum4;
        }
        else if(setText == 2){
            button1.setText(save2);
            Bresult1 = randNum2;
            button2.setText(save1);
            Bresult2 = randNum1;
            button3.setText(save4);
            Bresult3 = randNum4;
            button4.setText(save3);
            Bresult4 = randNum3;
        }
        else if(setText == 3){
            button1.setText(save1);
            Bresult1 = randNum1;
            button2.setText(save4);
            Bresult2 = randNum4;
            button3.setText(save2);
            Bresult3 = randNum2;
            button4.setText(save3);
            Bresult4 = randNum3;
        }
        else if(setText == 4){
            button1.setText(save3);
            Bresult1 = randNum3;
            button2.setText(save1);
            Bresult2 = randNum1;
            button3.setText(save4);
            Bresult3 = randNum4;
            button4.setText(save2);
            Bresult4 = randNum2;
        }
        else if(setText == 5){
            button1.setText(save3);
            Bresult1 = randNum3;
            button2.setText(save2);
            Bresult2 = randNum2;
            button3.setText(save1);
            Bresult3 = randNum1;
            button4.setText(save4);
            Bresult4 = randNum4;
        }
        else if(setText == 6){
            button1.setText(save4);
            Bresult1 = randNum4;
            button2.setText(save1);
            Bresult2 = randNum1;
            button3.setText(save2);
            Bresult3 = randNum2;
            button4.setText(save3);
            Bresult4 = randNum3;
        }
        else if(setText == 7){
            button1.setText(save4);
            Bresult1 = randNum4;
            button2.setText(save3);
            Bresult2 = randNum3;
            button3.setText(save1);
            Bresult3 = randNum1;
            button4.setText(save2);
            Bresult4 = randNum2;
        }

        final int RV1 = Bresult1;
        final int RV2 = Bresult2;
        final int RV3 = Bresult3;
        final int RV4 = Bresult4;
        final int Rmax = max;
        final int Rmin = min;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                int check = 0;
                if(textRandom == 0){
                    if(Rmax == RV1)
                        check = 1;
                }
                else{
                    if(Rmin == RV1)
                        check = 1;
                }

                Intent intent1 = getIntent();

                int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                int[] answerResult = intent1.getIntArrayExtra("Answer_state");
                double avtime = intent1.getDoubleExtra("Average_time", 0);
                String ResultType = intent1.getStringExtra("Result_type");

                avtime = ((avtime * problemNumber) + (60 - remainTime)) / (problemNumber + 1);

                countDownTimer.cancel();
                Intent intent = new Intent(getApplicationContext(), MaxMinGame.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                if (check == 1)
                    answerResult[problemNumber] = 1;
                else
                    answerResult[problemNumber] = -1;

                soundPool.play(soundID,1f,1f,0,0,1f);

                intent.putExtra("Number_of_time", problemNumber + 1);
                intent.putExtra("Answer_state", answerResult);
                intent.putExtra("Average_time", avtime);
                intent.putExtra("Result_type",ResultType);

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                int check = 0;
                if(textRandom == 0){
                    if(Rmax == RV2)
                        check = 1;
                }
                else{
                    if(Rmin == RV2)
                        check = 1;
                }

                Intent intent1 = getIntent();

                int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                int[] answerResult = intent1.getIntArrayExtra("Answer_state");
                double avtime = intent1.getDoubleExtra("Average_time", 0);
                String ResultType = intent1.getStringExtra("Result_type");

                avtime = ((avtime * problemNumber) + (60 - remainTime)) / (problemNumber + 1);

                countDownTimer.cancel();
                Intent intent = new Intent(getApplicationContext(), MaxMinGame.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                if (check == 1)
                    answerResult[problemNumber] = 1;
                else
                    answerResult[problemNumber] = -1;

                soundPool.play(soundID,1f,1f,0,0,1f);

                intent.putExtra("Number_of_time", problemNumber + 1);
                intent.putExtra("Answer_state", answerResult);
                intent.putExtra("Average_time", avtime);
                intent.putExtra("Result_type",ResultType);

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                int check = 0;
                if(textRandom == 0){
                    if(Rmax == RV3)
                        check = 1;
                }
                else{
                    if(Rmin == RV3)
                        check = 1;
                }

                Intent intent1 = getIntent();

                int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                int[] answerResult = intent1.getIntArrayExtra("Answer_state");
                double avtime = intent1.getDoubleExtra("Average_time", 0);
                String ResultType = intent1.getStringExtra("Result_type");

                avtime = ((avtime * problemNumber) + (60 - remainTime)) / (problemNumber + 1);

                countDownTimer.cancel();
                Intent intent = new Intent(getApplicationContext(), MaxMinGame.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                if (check == 1)
                    answerResult[problemNumber] = 1;
                else
                    answerResult[problemNumber] = -1;

                soundPool.play(soundID,1f,1f,0,0,1f);

                intent.putExtra("Number_of_time", problemNumber + 1);
                intent.putExtra("Answer_state", answerResult);
                intent.putExtra("Average_time", avtime);
                intent.putExtra("Result_type",ResultType);

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                int check = 0;
                if(textRandom == 0){
                    if(Rmax == RV4)
                        check = 1;
                }
                else{
                    if(Rmin == RV4)
                        check = 1;
                }

                Intent intent1 = getIntent();

                int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                int[] answerResult = intent1.getIntArrayExtra("Answer_state");
                double avtime = intent1.getDoubleExtra("Average_time", 0);
                String ResultType = intent1.getStringExtra("Result_type");

                avtime = ((avtime * problemNumber) + (60 - remainTime)) / (problemNumber + 1);

                countDownTimer.cancel();
                Intent intent = new Intent(getApplicationContext(), MaxMinGame.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                if (check == 1)
                    answerResult[problemNumber] = 1;
                else
                    answerResult[problemNumber] = -1;

                soundPool.play(soundID,1f,1f,0,0,1f);

                intent.putExtra("Number_of_time", problemNumber + 1);
                intent.putExtra("Answer_state", answerResult);
                intent.putExtra("Average_time", avtime);
                intent.putExtra("Result_type",ResultType);

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

    }
    // 마지막으로 뒤로 가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    private Toast toast;

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        System.exit(0);

        //android.os.Process.killProcess(android.os.Process.myPid());
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //startActivity(intent);
        // 2500 milliseconds = 2.5 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 메뉴 화면으로 이동합니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {

            //countDownTimer.cancel();
            Intent intent = new Intent(getApplicationContext(),MaxMinGameMenu.class);
            System.exit(0);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
