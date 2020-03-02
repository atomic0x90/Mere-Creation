package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Locale;

import java.util.Random;


public class Challenge_add extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_add);



        final TextView timetextView = (TextView)findViewById(R.id.timeText1);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            public void onTick(long millisUntilFinished) {
                timetextView.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
            }

            public void onFinish() {
                timetextView.setText("Done.");
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

            }
        }.start();


        Intent intent1 = getIntent();

        int problemNumber = intent1.getIntExtra("Number_of_time",0);
        int[] answerResult = intent1.getIntArrayExtra("Answer_state");

        long seed = System.currentTimeMillis();
        Random random = new Random(seed);

        int rand1 = random.nextInt(80)+10;

        random.setSeed(System.currentTimeMillis());

        int randseed = random.nextInt(70)+8;
        int rand2 = random.nextInt(randseed)+10;

        random.setSeed(System.currentTimeMillis());
        //Button text
        int result = rand1 + rand2;
        int fakeResult1 = rand1 + rand2 - random.nextInt(4)-1;
        int fakeResult2 = rand1 + rand2 + random.nextInt(8)+1;
        int fakeResult3 = rand1 + rand2 - random.nextInt(5)-5;

        int[] tmpResult1 = {result,fakeResult1,fakeResult2,fakeResult3};
        int[] tmpResult2 = {fakeResult3,result,fakeResult2,fakeResult1};
        int[] tmpResult3 = {fakeResult1,fakeResult3,result,fakeResult2};
        int[] tmpResult4 = {fakeResult2,fakeResult1,fakeResult3,result};
        int[] tmpResult5 = {result,fakeResult2,fakeResult1,fakeResult3};
        int[] tmpResult6 = {fakeResult1,result,fakeResult2,fakeResult3};
        int[] tmpResult7 = {fakeResult1,fakeResult2,result,fakeResult3};
        int[] tmpResult8 = {fakeResult3,fakeResult1,fakeResult2,result};

        random.setSeed(System.currentTimeMillis());
        int randValue = random.nextInt(8)+1;

        if(randValue == 1){
            TextView resultText1 = (TextView)findViewById(R.id.cadd1);
            resultText1.setText(String.valueOf(tmpResult1[0]));
            TextView resultText2 = (TextView)findViewById(R.id.cadd2);
            resultText2.setText(String.valueOf(tmpResult1[1]));
            TextView resultText3 = (TextView)findViewById(R.id.cadd3);
            resultText3.setText(String.valueOf(tmpResult1[2]));
            TextView resultText4 = (TextView)findViewById(R.id.cadd4);
            resultText4.setText(String.valueOf(tmpResult1[3]));
        }
        else if(randValue == 2){
            TextView resultText1 = (TextView)findViewById(R.id.cadd1);
            resultText1.setText(String.valueOf(tmpResult2[0]));
            TextView resultText2 = (TextView)findViewById(R.id.cadd2);
            resultText2.setText(String.valueOf(tmpResult2[1]));
            TextView resultText3 = (TextView)findViewById(R.id.cadd3);
            resultText3.setText(String.valueOf(tmpResult2[2]));
            TextView resultText4 = (TextView)findViewById(R.id.cadd4);
            resultText4.setText(String.valueOf(tmpResult2[3]));
        }
        else if(randValue == 3){
            TextView resultText1 = (TextView)findViewById(R.id.cadd1);
            resultText1.setText(String.valueOf(tmpResult3[0]));
            TextView resultText2 = (TextView)findViewById(R.id.cadd2);
            resultText2.setText(String.valueOf(tmpResult3[1]));
            TextView resultText3 = (TextView)findViewById(R.id.cadd3);
            resultText3.setText(String.valueOf(tmpResult3[2]));
            TextView resultText4 = (TextView)findViewById(R.id.cadd4);
            resultText4.setText(String.valueOf(tmpResult3[3]));
        }
        else if(randValue == 4){
            TextView resultText1 = (TextView)findViewById(R.id.cadd1);
            resultText1.setText(String.valueOf(tmpResult4[0]));
            TextView resultText2 = (TextView)findViewById(R.id.cadd2);
            resultText2.setText(String.valueOf(tmpResult4[1]));
            TextView resultText3 = (TextView)findViewById(R.id.cadd3);
            resultText3.setText(String.valueOf(tmpResult4[2]));
            TextView resultText4 = (TextView)findViewById(R.id.cadd4);
            resultText4.setText(String.valueOf(tmpResult4[3]));
        }
        else if(randValue == 5){
            TextView resultText1 = (TextView)findViewById(R.id.cadd1);
            resultText1.setText(String.valueOf(tmpResult5[0]));
            TextView resultText2 = (TextView)findViewById(R.id.cadd2);
            resultText2.setText(String.valueOf(tmpResult5[1]));
            TextView resultText3 = (TextView)findViewById(R.id.cadd3);
            resultText3.setText(String.valueOf(tmpResult5[2]));
            TextView resultText4 = (TextView)findViewById(R.id.cadd4);
            resultText4.setText(String.valueOf(tmpResult5[3]));
        }
        else if(randValue == 6){
            TextView resultText1 = (TextView)findViewById(R.id.cadd1);
            resultText1.setText(String.valueOf(tmpResult6[0]));
            TextView resultText2 = (TextView)findViewById(R.id.cadd2);
            resultText2.setText(String.valueOf(tmpResult6[1]));
            TextView resultText3 = (TextView)findViewById(R.id.cadd3);
            resultText3.setText(String.valueOf(tmpResult6[2]));
            TextView resultText4 = (TextView)findViewById(R.id.cadd4);
            resultText4.setText(String.valueOf(tmpResult6[3]));
        }
        else if(randValue == 7){
            TextView resultText1 = (TextView)findViewById(R.id.cadd1);
            resultText1.setText(String.valueOf(tmpResult7[0]));
            TextView resultText2 = (TextView)findViewById(R.id.cadd2);
            resultText2.setText(String.valueOf(tmpResult7[1]));
            TextView resultText3 = (TextView)findViewById(R.id.cadd3);
            resultText3.setText(String.valueOf(tmpResult7[2]));
            TextView resultText4 = (TextView)findViewById(R.id.cadd4);
            resultText4.setText(String.valueOf(tmpResult7[3]));
        }
        else if(randValue == 8){
            TextView resultText1 = (TextView)findViewById(R.id.cadd1);
            resultText1.setText(String.valueOf(tmpResult8[0]));
            TextView resultText2 = (TextView)findViewById(R.id.cadd2);
            resultText2.setText(String.valueOf(tmpResult8[1]));
            TextView resultText3 = (TextView)findViewById(R.id.cadd3);
            resultText3.setText(String.valueOf(tmpResult8[2]));
            TextView resultText4 = (TextView)findViewById(R.id.cadd4);
            resultText4.setText(String.valueOf(tmpResult8[3]));
        }


        TextView  problemView1 = (TextView)findViewById(R.id.addproblemText1);
        problemView1.setText(String.valueOf(rand1));

        TextView problemView2 = (TextView)findViewById(R.id.addproblemText2);
        problemView2.setText(String.valueOf(rand2));

        Button button1 = (Button)findViewById(R.id.cadd1);
        Button button2 = (Button)findViewById(R.id.cadd2);
        Button button3 = (Button)findViewById(R.id.cadd3);
        Button button4 = (Button)findViewById(R.id.cadd4);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                Intent intent = new Intent(getApplicationContext(), Challenge_add.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });


    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }




}
