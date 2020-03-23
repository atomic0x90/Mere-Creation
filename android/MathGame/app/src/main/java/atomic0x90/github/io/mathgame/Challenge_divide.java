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

public class Challenge_divide extends AppCompatActivity {

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
        setContentView(R.layout.activity_challenge_divide);

        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound01,1);


        //AD

        mAdView = findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        final TextView timetextView = (TextView)findViewById(R.id.divideTimeText);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
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
                if(tmpNumber == 10) {
                    //Need Fix
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), Challenge_divide.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    tmparr[tmpNumber] = -1;

                    avtime = ((avtime * tmpNumber) + (10))/(tmpNumber + 1);

                    intent.putExtra("Number_of_time",tmpNumber+1);
                    intent.putExtra("Answer_state",tmparr);
                    intent.putExtra("Average_time",avtime);

                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
            }
        }.start();

        Intent intent = getIntent();

        final int tmpNumber = intent.getIntExtra("Number_of_time",0);
        int[] arr = intent.getIntArrayExtra("Answer_state");
        double avtime = intent.getDoubleExtra("Average_time",0);

        TextView averageText = (TextView)findViewById(R.id.divideAverageTime);

        String tmpTime = String.format("%.1f",avtime);
        averageText.setText(String.format(Locale.getDefault(),"Average Time\n        %s s",tmpTime));



        if(tmpNumber == 10)
        {
            countDownTimer.cancel();

            int num = 0;
            for(int i = 0;i < 10;i++)
            {
                if(arr[i] == 1)
                    num++;
            }

            Intent Endintent = new Intent(Challenge_divide.this, CustomDialog.class);
            Endintent.putExtra("Result_type","Divide");
            Endintent.putExtra("Average_time",avtime);
            Endintent.putExtra("Answer_num",num);
            Endintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(Endintent);
        }
        else
        {
            ImageView imageView0 = (ImageView)findViewById(R.id.divideState0);
            ImageView imageView1 = (ImageView)findViewById(R.id.divideState1);
            ImageView imageView2 = (ImageView)findViewById(R.id.divideState2);
            ImageView imageView3 = (ImageView)findViewById(R.id.divideState3);
            ImageView imageView4 = (ImageView)findViewById(R.id.divideState4);
            ImageView imageView5 = (ImageView)findViewById(R.id.divideState5);
            ImageView imageView6 = (ImageView)findViewById(R.id.divideState6);
            ImageView imageView7 = (ImageView)findViewById(R.id.divideState7);
            ImageView imageView8 = (ImageView)findViewById(R.id.divideState8);
            ImageView imageView9 = (ImageView)findViewById(R.id.divideState9);

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

            // 5번 state img
            if(arr[5] == 1)
                imageView5.setImageResource(R.drawable.green_dot);
            else if(arr[5] == -1)
                imageView5.setImageResource(R.drawable.red_dot);
            else
                imageView5.setImageResource(R.drawable.gray_dot);

            // 6번 state img
            if(arr[6] == 1)
                imageView6.setImageResource(R.drawable.green_dot);
            else if(arr[6] == -1)
                imageView6.setImageResource(R.drawable.red_dot);
            else
                imageView6.setImageResource(R.drawable.gray_dot);

            // 7번 state img
            if(arr[7] == 1)
                imageView7.setImageResource(R.drawable.green_dot);
            else if(arr[7] == -1)
                imageView7.setImageResource(R.drawable.red_dot);
            else
                imageView7.setImageResource(R.drawable.gray_dot);

            // 8번 state img
            if(arr[8] == 1)
                imageView8.setImageResource(R.drawable.green_dot);
            else if(arr[8] == -1)
                imageView8.setImageResource(R.drawable.red_dot);
            else
                imageView8.setImageResource(R.drawable.gray_dot);

            // 9번 state img
            if(arr[9] == 1)
                imageView9.setImageResource(R.drawable.green_dot);
            else if(arr[9] == -1)
                imageView9.setImageResource(R.drawable.red_dot);
            else
                imageView9.setImageResource(R.drawable.gray_dot);
        }

        //번호 랜덤 설정
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);


        int rand2 = random.nextInt(8)+3;

        random.setSeed(System.currentTimeMillis());
        int randseed = random.nextInt(20)+3;
        int rand1 = rand2*randseed;

        random.setSeed(System.currentTimeMillis());
        if(rand2 % 4 == 0 && (random.nextInt(1))%2 == 0)
            rand2 *= 2;

        random.setSeed(System.currentTimeMillis());
        //Button text
        final double result = (double)rand1 / (double)rand2;
        double fakeResult1 = ((double)rand1 / (double)rand2) - 1;
        double fakeResult2 = ((double)rand1 / (double)rand2) + 1;
        double fakeResult3 = ((double)rand1 / (double)rand2) + 2;
        double fakeResult4 = ((double)rand1 / (double)rand2) - 0.5;
        double fakeResult5 = ((double)rand1 / (double)rand2) + 1.5;

        double[] tmpResult1 = {result,fakeResult1,fakeResult2,fakeResult3};
        double[] tmpResult2 = {fakeResult3,result,fakeResult2,fakeResult4};
        double[] tmpResult3 = {fakeResult5,fakeResult3,result,fakeResult2};
        double[] tmpResult4 = {fakeResult4,fakeResult1,fakeResult3,result};
        double[] tmpResult5 = {result,fakeResult2,fakeResult1,fakeResult4};
        double[] tmpResult6 = {fakeResult5,result,fakeResult2,fakeResult3};
        double[] tmpResult7 = {fakeResult4,fakeResult2,result,fakeResult3};
        double[] tmpResult8 = {fakeResult3,fakeResult1,fakeResult5,result};

        random.setSeed(System.currentTimeMillis());
        int randValue = random.nextInt(8)+1;

        TextView resultText1 = (TextView)findViewById(R.id.cdiv1);
        TextView resultText2 = (TextView)findViewById(R.id.cdiv2);
        TextView resultText3 = (TextView)findViewById(R.id.cdiv3);
        TextView resultText4 = (TextView)findViewById(R.id.cdiv4);

        if(randValue == 1){
            resultText1.setText(String.valueOf(tmpResult1[0]));
            resultText2.setText(String.valueOf(tmpResult1[1]));
            resultText3.setText(String.valueOf(tmpResult1[2]));
            resultText4.setText(String.valueOf(tmpResult1[3]));
        }
        else if(randValue == 2){
            resultText1.setText(String.valueOf(tmpResult2[0]));
            resultText2.setText(String.valueOf(tmpResult2[1]));
            resultText3.setText(String.valueOf(tmpResult2[2]));
            resultText4.setText(String.valueOf(tmpResult2[3]));
        }
        else if(randValue == 3){
            resultText1.setText(String.valueOf(tmpResult3[0]));
            resultText2.setText(String.valueOf(tmpResult3[1]));
            resultText3.setText(String.valueOf(tmpResult3[2]));
            resultText4.setText(String.valueOf(tmpResult3[3]));
        }
        else if(randValue == 4){
            resultText1.setText(String.valueOf(tmpResult4[0]));
            resultText2.setText(String.valueOf(tmpResult4[1]));
            resultText3.setText(String.valueOf(tmpResult4[2]));
            resultText4.setText(String.valueOf(tmpResult4[3]));
        }
        else if(randValue == 5){
            resultText1.setText(String.valueOf(tmpResult5[0]));
            resultText2.setText(String.valueOf(tmpResult5[1]));
            resultText3.setText(String.valueOf(tmpResult5[2]));
            resultText4.setText(String.valueOf(tmpResult5[3]));
        }
        else if(randValue == 6){
            resultText1.setText(String.valueOf(tmpResult6[0]));
            resultText2.setText(String.valueOf(tmpResult6[1]));
            resultText3.setText(String.valueOf(tmpResult6[2]));
            resultText4.setText(String.valueOf(tmpResult6[3]));
        }
        else if(randValue == 7){
            resultText1.setText(String.valueOf(tmpResult7[0]));
            resultText2.setText(String.valueOf(tmpResult7[1]));
            resultText3.setText(String.valueOf(tmpResult7[2]));
            resultText4.setText(String.valueOf(tmpResult7[3]));
        }
        else if(randValue == 8){
            resultText1.setText(String.valueOf(tmpResult8[0]));
            resultText2.setText(String.valueOf(tmpResult8[1]));
            resultText3.setText(String.valueOf(tmpResult8[2]));
            resultText4.setText(String.valueOf(tmpResult8[3]));
        }


        TextView  problemView1 = (TextView)findViewById(R.id.divideProblemText1);
        problemView1.setText(String.valueOf(rand1));

        TextView problemView2 = (TextView)findViewById(R.id.divideProblemText2);
        problemView2.setText(String.valueOf(rand2));


        //버튼 눌렀을 경우
        Button button1 = (Button)findViewById(R.id.cdiv1);
        Button button2 = (Button)findViewById(R.id.cdiv2);
        Button button3 = (Button)findViewById(R.id.cdiv3);
        Button button4 = (Button)findViewById(R.id.cdiv4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if(tmpNumber != 10) {
                    Intent intent1 = getIntent();

                    int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                    int[] answerResult = intent1.getIntArrayExtra("Answer_state");
                    double avtime = intent1.getDoubleExtra("Average_time", 0);

                    avtime = ((avtime * problemNumber) + (10 - remainTime)) / (problemNumber + 1);

                    countDownTimer.cancel();
                    Intent intent = new Intent(getApplicationContext(), Challenge_divide.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    TextView resultText = (TextView) findViewById(R.id.cdiv1);
                    String tmp = resultText.getText().toString();
                    if (result == Double.valueOf(tmp))
                        answerResult[problemNumber] = 1;
                    else
                        answerResult[problemNumber] = -1;

                    soundPool.play(soundID,1f,1f,0,0,1f);

                    intent.putExtra("Number_of_time", problemNumber + 1);
                    intent.putExtra("Answer_state", answerResult);
                    intent.putExtra("Average_time", avtime);

                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
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

                if (tmpNumber != 10) {
                    Intent intent1 = getIntent();

                    int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                    int[] answerResult = intent1.getIntArrayExtra("Answer_state");
                    double avtime = intent1.getDoubleExtra("Average_time", 0);

                    avtime = ((avtime * problemNumber) + (10 - remainTime)) / (problemNumber + 1);

                    countDownTimer.cancel();
                    Intent intent = new Intent(getApplicationContext(), Challenge_divide.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    TextView resultText = (TextView) findViewById(R.id.cdiv2);
                    String tmp = resultText.getText().toString();
                    if (result == Double.valueOf(tmp))
                        answerResult[problemNumber] = 1;
                    else
                        answerResult[problemNumber] = -1;

                    soundPool.play(soundID,1f,1f,0,0,1f);

                    intent.putExtra("Number_of_time", problemNumber + 1);
                    intent.putExtra("Answer_state", answerResult);
                    intent.putExtra("Average_time", avtime);

                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
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
                if (tmpNumber != 10){
                    Intent intent1 = getIntent();

                    int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                    int[] answerResult = intent1.getIntArrayExtra("Answer_state");
                    double avtime = intent1.getDoubleExtra("Average_time", 0);

                    avtime = ((avtime * problemNumber) + (10 - remainTime)) / (problemNumber + 1);

                    countDownTimer.cancel();
                    Intent intent = new Intent(getApplicationContext(), Challenge_divide.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    TextView resultText = (TextView) findViewById(R.id.cdiv3);
                    String tmp = resultText.getText().toString();
                    if (result == Double.valueOf(tmp))
                        answerResult[problemNumber] = 1;
                    else
                        answerResult[problemNumber] = -1;

                    intent.putExtra("Number_of_time", problemNumber + 1);
                    intent.putExtra("Answer_state", answerResult);
                    intent.putExtra("Average_time", avtime);

                    soundPool.play(soundID,1f,1f,0,0,1f);

                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
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
                if(tmpNumber != 10) {
                    Intent intent1 = getIntent();

                    int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                    int[] answerResult = intent1.getIntArrayExtra("Answer_state");
                    double avtime = intent1.getDoubleExtra("Average_time", 0);

                    avtime = ((avtime * problemNumber) + (10 - remainTime)) / (problemNumber + 1);

                    countDownTimer.cancel();
                    Intent intent = new Intent(getApplicationContext(), Challenge_divide.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    TextView resultText = (TextView) findViewById(R.id.cdiv4);
                    String tmp = resultText.getText().toString();
                    if (result == Double.valueOf(tmp))
                        answerResult[problemNumber] = 1;
                    else
                        answerResult[problemNumber] = -1;

                    intent.putExtra("Number_of_time", problemNumber + 1);
                    intent.putExtra("Answer_state", answerResult);
                    intent.putExtra("Average_time", avtime);

                    soundPool.play(soundID,1f,1f,0,0,1f);

                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
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
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 메뉴 화면으로 이동합니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            System.exit(0);
            startActivity(intent);
        }
    }

}
