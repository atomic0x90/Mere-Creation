package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Locale;
import java.util.Random;

public class InfinityChallenge_Plus extends AppCompatActivity {
    long checkTime;

    //Sound
    SoundPool soundPool;
    int soundID;

    //AD
    private AdView mAdView;

    //DB
    SQLiteDatabase sqLiteDatabase;

    //Double click check
    private long mLastClickTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinity_challenge_plus);
        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound01,1);


        //AD
        mAdView = findViewById(R.id.adView8);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final TextView infiPTime = (TextView)findViewById(R.id.infiPTime);

        Intent initIntent = getIntent();
        final long nowMilli = initIntent.getLongExtra("Now_time", 61000);
        final int firstNum = initIntent.getIntExtra("Init_num",1);
        final int clearNum = initIntent.getIntExtra("Answer_state",0);
        final String typeString = initIntent.getStringExtra("Type");




        final CountDownTimer countDownTimer = new CountDownTimer(nowMilli, 1000) {
            public void onTick(long millisUntilFinished) {
                infiPTime.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                checkTime = millisUntilFinished;
            }
            public void onFinish() {
                infiPTime.setText("Time Over");


                Intent Endintent = new Intent(getApplicationContext(), CustomDialog.class);

                if(typeString.equals("Plus7"))
                    Endintent.putExtra("Result_type","InfiP7");
                else if(typeString.equals("Plus8"))
                    Endintent.putExtra("Result_type","InfiP8");
                else if(typeString.equals("Plus13"))
                    Endintent.putExtra("Result_type","InfiP13");
                else if(typeString.equals("Plus16"))
                    Endintent.putExtra("Result_type","InfiP16");
                else if(typeString.equals("Plus17"))
                    Endintent.putExtra("Result_type","InfiP17");
                else if(typeString.equals("Plus6_9"))
                    Endintent.putExtra("Result_type","InfiP6_9");
                else if(typeString.equals("Plus13_17"))
                    Endintent.putExtra("Result_type","InfiP13_17");
                else if(typeString.equals("Plus6_17"))
                    Endintent.putExtra("Result_type","InfiP6_17");

                Endintent.putExtra("Answer_num",clearNum);
                Endintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Endintent);

            }
        }.start();

        TextView nowAnswer = (TextView) findViewById(R.id.infinityPnowAnswerText);
        nowAnswer.setText(String.format(Locale.getDefault(),"정답 개수 : %d",clearNum));

        TextView firstText = (TextView) findViewById(R.id.infiPProblemText1);
        firstText.setText(String.valueOf(firstNum));

        TextView secondText = (TextView)findViewById(R.id.infiPProblemText2);

        if(typeString.equals("Plus7"))
            secondText.setText("7");
        else if(typeString.equals("Plus8"))
            secondText.setText("8");
        else if(typeString.equals("Plus13"))
            secondText.setText("13");
        else if(typeString.equals("Plus16"))
            secondText.setText("16");
        else if(typeString.equals("Plus17"))
            secondText.setText("17");
        else if(typeString.equals("Plus6_9")){

            long tmpSeed = System.currentTimeMillis();
            Random tmpRandom = new Random(tmpSeed);
            tmpRandom.setSeed(System.currentTimeMillis());

            int tmpValue = tmpRandom.nextInt(4)+6;

            secondText.setText(String.valueOf(tmpValue));
        }
        else if(typeString.equals("Plus13_17")){

            long tmpSeed = System.currentTimeMillis();
            Random tmpRandom = new Random(tmpSeed);
            tmpRandom.setSeed(System.currentTimeMillis());

            int tmpValue = tmpRandom.nextInt(5)+13;

            secondText.setText(String.valueOf(tmpValue));
        }
        else if(typeString.equals("Plus6_17")){

            long tmpSeed = System.currentTimeMillis();
            Random tmpRandom = new Random(tmpSeed);
            tmpRandom.setSeed(System.currentTimeMillis());

            int tmpValue = tmpRandom.nextInt(11)+6;

            secondText.setText(String.valueOf(tmpValue));
        }

        String stringValue = secondText.getText().toString();
        int Textint = Integer.parseInt(stringValue);

        //Button text
        final int result = firstNum + Textint;
        int fakeResult1 = firstNum + Textint - 1;
        int fakeResult2 = firstNum + Textint + 1;
        int fakeResult3 = firstNum + Textint + 2;
        int fakeResult4 = firstNum + Textint - 2;
        int fakeResult5 = firstNum + Textint + 10;
        int fakeResult6 = firstNum + Textint - 10;

        int[] tmpResult1 = {result,fakeResult1,fakeResult6,fakeResult3};
        int[] tmpResult2 = {fakeResult3,result,fakeResult2,fakeResult4};
        int[] tmpResult3 = {fakeResult5,fakeResult3,result,fakeResult2};
        int[] tmpResult4 = {fakeResult4,fakeResult1,fakeResult3,result};
        int[] tmpResult5 = {result,fakeResult2,fakeResult1,fakeResult4};
        int[] tmpResult6 = {fakeResult5,result,fakeResult2,fakeResult3};
        int[] tmpResult7 = {fakeResult4,fakeResult2,result,fakeResult6};
        int[] tmpResult8 = {fakeResult3,fakeResult1,fakeResult5,result};

        //번호 랜덤 설정
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        random.setSeed(System.currentTimeMillis());
        int randValue = random.nextInt(8)+1;

        final TextView resultText1 = (TextView)findViewById(R.id.InfiPlus_1);
        final TextView resultText2 = (TextView)findViewById(R.id.InfiPlus_2);
        final TextView resultText3 = (TextView)findViewById(R.id.InfiPlus_3);
        final TextView resultText4 = (TextView)findViewById(R.id.InfiPlus_4);

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

        //Button
        Button button1 = (Button)findViewById(R.id.InfiPlus_1);
        Button button2 = (Button)findViewById(R.id.InfiPlus_2);
        Button button3 = (Button)findViewById(R.id.InfiPlus_3);
        Button button4 = (Button)findViewById(R.id.InfiPlus_4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);

                String tmp = resultText1.getText().toString();
                if(result == Integer.parseInt(tmp)) {
                    //정답
                    intent.putExtra("Now_time", nowMilli - (nowMilli - checkTime));
                    intent.putExtra("Init_num",result);
                    intent.putExtra("Answer_state",clearNum + 1);
                    intent.putExtra("Type",typeString);
                }
                else{
                    intent.putExtra("Now_time",nowMilli - 5000 - (nowMilli - checkTime));
                    intent.putExtra("Init_num",firstNum);
                    intent.putExtra("Answer_state",clearNum);
                    intent.putExtra("Type",typeString);
                }
                countDownTimer.cancel();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);

                String tmp = resultText2.getText().toString();
                if(result == Integer.parseInt(tmp)) {
                    //정답
                    intent.putExtra("Now_time", nowMilli - (nowMilli - checkTime));
                    intent.putExtra("Init_num",result);
                    intent.putExtra("Answer_state",clearNum + 1);
                    intent.putExtra("Type",typeString);
                }
                else{
                    intent.putExtra("Now_time",nowMilli - 5000 - (nowMilli - checkTime));
                    intent.putExtra("Init_num",firstNum);
                    intent.putExtra("Answer_state",clearNum);
                    intent.putExtra("Type",typeString);
                }
                countDownTimer.cancel();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);

                String tmp = resultText3.getText().toString();
                if(result == Integer.parseInt(tmp)) {
                    //정답
                    intent.putExtra("Now_time", nowMilli - (nowMilli - checkTime));
                    intent.putExtra("Init_num",result);
                    intent.putExtra("Answer_state",clearNum + 1);
                    intent.putExtra("Type",typeString);
                }
                else{
                    intent.putExtra("Now_time",nowMilli - 5000 - (nowMilli - checkTime));
                    intent.putExtra("Init_num",firstNum);
                    intent.putExtra("Answer_state",clearNum);
                    intent.putExtra("Type",typeString);
                }
                countDownTimer.cancel();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(getApplicationContext(), InfinityChallenge_Plus.class);

                String tmp = resultText4.getText().toString();
                if(result == Integer.parseInt(tmp)) {
                    //정답
                    intent.putExtra("Now_time", nowMilli - (nowMilli - checkTime));
                    intent.putExtra("Init_num",result);
                    intent.putExtra("Answer_state",clearNum + 1);
                    intent.putExtra("Type",typeString);
                }
                else{
                    intent.putExtra("Now_time",nowMilli - 5000 - (nowMilli - checkTime));
                    intent.putExtra("Init_num",firstNum);
                    intent.putExtra("Answer_state",clearNum);
                    intent.putExtra("Type",typeString);
                }
                countDownTimer.cancel();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
        //ActivityCompat.finishAffinity(this);
        System.exit(0);
        //finish();

        //android.os.Process.killProcess(android.os.Process.myPid());
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        // 2500 milliseconds = 2.5 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 메뉴 화면으로 이동합니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {

            //countDownTimer.cancel();
            Intent intent = new Intent(getApplicationContext(),InfinityPlusMenu.class);
            System.exit(0);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
