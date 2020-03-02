package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
                timetextView.setText("Time Over");

                Intent Finishintent = getIntent();
                int tmpNumber = Finishintent.getIntExtra("Number_of_time",0);
                int[] tmparr = Finishintent.getIntArrayExtra("Answer_state");
                if(tmpNumber == 10) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), Challenge_add.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    tmparr[tmpNumber] = -1;

                    intent.putExtra("Number_of_time",tmpNumber+1);
                    intent.putExtra("Answer_state",tmparr);

                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
            }
        }.start();

        Intent intent = getIntent();

        int tmpNumber = intent.getIntExtra("Number_of_time",0);
        int[] arr = intent.getIntArrayExtra("Answer_state");
       // int avtime = intent.getIntExtra("Average_time",0);

       // TextView averageText = (TextView)findViewById(R.id.AverageText);
        //averageText.setText(avtime);


        if(tmpNumber == 10)
        {
            countDownTimer.cancel();
            Intent Endintent = new Intent(Challenge_add.this, MainActivity.class);
            Endintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(Endintent);
        }
        else
        {
            ImageView imageView0 = (ImageView)findViewById(R.id.state0);
            ImageView imageView1 = (ImageView)findViewById(R.id.state1);
            ImageView imageView2 = (ImageView)findViewById(R.id.state2);
            ImageView imageView3 = (ImageView)findViewById(R.id.state3);
            ImageView imageView4 = (ImageView)findViewById(R.id.state4);
            ImageView imageView5 = (ImageView)findViewById(R.id.state5);
            ImageView imageView6 = (ImageView)findViewById(R.id.state6);
            ImageView imageView7 = (ImageView)findViewById(R.id.state7);
            ImageView imageView8 = (ImageView)findViewById(R.id.state8);
            ImageView imageView9 = (ImageView)findViewById(R.id.state9);

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

        int rand1 = random.nextInt(80)+11;

        random.setSeed(System.currentTimeMillis());

        int randseed = random.nextInt(70)+11;
        int rand2 = random.nextInt(randseed)+10;

        random.setSeed(System.currentTimeMillis());
        //Button text
        final int result = rand1 + rand2;
        int fakeResult1 = rand1 + rand2 - random.nextInt(4)-1;
        int fakeResult2 = rand1 + rand2 + random.nextInt(8)+1;
        int fakeResult3 = rand1 + rand2 - random.nextInt(4)-5;
        int fakeResult4 = rand1 + rand2 - 10;

        int[] tmpResult1 = {result,fakeResult1,fakeResult2,fakeResult3};
        int[] tmpResult2 = {fakeResult3,result,fakeResult2,fakeResult4};
        int[] tmpResult3 = {fakeResult1,fakeResult3,result,fakeResult2};
        int[] tmpResult4 = {fakeResult4,fakeResult1,fakeResult3,result};
        int[] tmpResult5 = {result,fakeResult2,fakeResult1,fakeResult4};
        int[] tmpResult6 = {fakeResult1,result,fakeResult2,fakeResult3};
        int[] tmpResult7 = {fakeResult4,fakeResult2,result,fakeResult3};
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


        //버튼 눌렀을 경우
        Button button1 = (Button)findViewById(R.id.cadd1);
        Button button2 = (Button)findViewById(R.id.cadd2);
        Button button3 = (Button)findViewById(R.id.cadd3);
        Button button4 = (Button)findViewById(R.id.cadd4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();

                int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                int[] answerResult = intent1.getIntArrayExtra("Answer_state");
           //     double avtime = intent1.getIntExtra("Average_time",0);



                countDownTimer.cancel();
                Intent intent = new Intent(getApplicationContext(), Challenge_add.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                TextView resultText = (TextView)findViewById(R.id.cadd1);
                String tmp = resultText.getText().toString();
                if(result == Integer.parseInt(tmp))
                    answerResult[problemNumber] = 1;
                else
                    answerResult[problemNumber] = -1;



                intent.putExtra("Number_of_time",problemNumber+1);
                intent.putExtra("Answer_state",answerResult);


                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();

                int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                int[] answerResult = intent1.getIntArrayExtra("Answer_state");

                countDownTimer.cancel();
                Intent intent = new Intent(getApplicationContext(), Challenge_add.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                TextView resultText = (TextView)findViewById(R.id.cadd2);
                String tmp = resultText.getText().toString();
                if(result == Integer.parseInt(tmp))
                    answerResult[problemNumber] = 1;
                else
                    answerResult[problemNumber] = -1;

                intent.putExtra("Number_of_time",problemNumber+1);
                intent.putExtra("Answer_state",answerResult);

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();

                int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                int[] answerResult = intent1.getIntArrayExtra("Answer_state");

                countDownTimer.cancel();
                Intent intent = new Intent(getApplicationContext(), Challenge_add.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                TextView resultText = (TextView)findViewById(R.id.cadd3);
                String tmp = resultText.getText().toString();
                if(result == Integer.parseInt(tmp))
                    answerResult[problemNumber] = 1;
                else
                    answerResult[problemNumber] = -1;

                intent.putExtra("Number_of_time",problemNumber+1);
                intent.putExtra("Answer_state",answerResult);

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();

                int problemNumber = intent1.getIntExtra("Number_of_time", 0);
                int[] answerResult = intent1.getIntArrayExtra("Answer_state");

                countDownTimer.cancel();
                Intent intent = new Intent(getApplicationContext(), Challenge_add.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                TextView resultText = (TextView)findViewById(R.id.cadd4);
                String tmp = resultText.getText().toString();
                if(result == Integer.parseInt(tmp))
                    answerResult[problemNumber] = 1;
                else
                    answerResult[problemNumber] = -1;

                intent.putExtra("Number_of_time",problemNumber+1);
                intent.putExtra("Answer_state",answerResult);

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
