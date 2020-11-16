package atomic0x90.github.io.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GameLine2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_line2);

        final Button TopButton = (Button) findViewById(R.id.Line2TopButton);
        final Button MiddleButton1 = (Button) findViewById(R.id.Line2MiddleButton1);
        final Button MiddleButton2 = (Button) findViewById(R.id.Line2MiddleButton2);
        final Button BottomButton = (Button) findViewById(R.id.Line2BottomButton);

        Intent nowIntent = getIntent();
        final int MaxNum = nowIntent.getIntExtra("Max",0);    //최대 숫자
        String StrAnswer = nowIntent.getStringExtra("Answer");  //어떤 stage

        //int MaxNum = Integer.parseInt(SMaxNum);
        int[] IntAnswer = null;
        final int[] AnswerNow = {0};
        final int[] Mid1Arr = new int[100];
        final int[] Mid2Arr = new int[100];

        final int[] Mid1Tail = {0};
        final int[] Mid2Tail = {0};

        if(StrAnswer.equals("1_1")){
            IntAnswer = new int[]{1, 2, 4, 3};
            BottomButton.setText("1|2|4|3");
        }
        else if(StrAnswer.equals("1_2")){
            IntAnswer = new int[]{1, 3, 2, 4};
            BottomButton.setText("1|3|2|4");
        }
        else if(StrAnswer.equals("1_3")){
            IntAnswer = new int[]{2, 1, 3, 4};
            BottomButton.setText("2|1|3|4");
        }
        else if(StrAnswer.equals("1_4")){
            IntAnswer = new int[]{2, 3, 1, 4};
            BottomButton.setText("2|3|1|4");
        }
        else if(StrAnswer.equals("1_5")){
            IntAnswer = new int[]{3, 1, 2, 4};
            BottomButton.setText("3|1|2|4");
        }
        else if(StrAnswer.equals("1_6")){
            IntAnswer = new int[]{3, 4, 1, 2};
            BottomButton.setText("3|4|1|2");
        }



        TopButton.setText("1");
        MiddleButton1.setText("");
        MiddleButton2.setText("");


        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TopButton.isSelected()) //선택 안됐을 때
                {
                    if (!TopButton.getText().equals("-")) {
                        TopButton.setSelected(true);
                        BottomButton.setEnabled(false);
                    }
                }
                else
                {
                    TopButton.setSelected(false);
                    BottomButton.setEnabled(true);
                }
            }
        });

        MiddleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TopButton.isSelected()){
                    //Top에서 선택 후 Middle로 옮길 때

                    //숫자 이동 알고리즘
                    int tmpNum = Integer.parseInt((String) TopButton.getText());

                    Mid1Arr[Mid1Tail[0]] = tmpNum;
                    Mid1Tail[0]++;
                    tmpNum++;
                    if(tmpNum <= MaxNum)
                        TopButton.setText(Integer.toString(tmpNum));
                    else
                        TopButton.setText("-");

                    String tmpString = "";
                    for(int i = Mid1Tail[0]-1 ;i >= 0; i--){
                        tmpString += "\n" + Mid1Arr[i];
                    }
                    MiddleButton1.setText(tmpString);

                    //Top 버튼 선택 해제
                    TopButton.setSelected(false);

                    BottomButton.setEnabled(true);
                }
                else{
                    //Middle에서 선택 후 Bottom으로 옮길 때
                    if(!MiddleButton1.isSelected()){
                        //선택 안됐을 때
                        MiddleButton1.setSelected(true);

                        TopButton.setEnabled(false);
                        MiddleButton2.setEnabled(false);
                    }
                    else{
                        MiddleButton1.setSelected(false);

                        TopButton.setEnabled(true);
                        MiddleButton2.setEnabled(true);
                    }
                }
            }
        });

        MiddleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TopButton.isSelected()){
                    //Top에서 선택 후 Middle로 옮길 때

                    //숫자 이동 알고리즘
                    int tmpNum = Integer.parseInt((String) TopButton.getText());

                    Mid2Arr[Mid2Tail[0]] = tmpNum;
                    Mid2Tail[0]++;
                    tmpNum++;
                    if(tmpNum <= MaxNum)
                        TopButton.setText(Integer.toString(tmpNum));
                    else
                        TopButton.setText("-");

                    String tmpString = "";
                    for(int i = Mid2Tail[0]-1 ;i >= 0; i--){
                        tmpString += "\n" + Mid2Arr[i];
                    }
                    MiddleButton2.setText(tmpString);

                    //Top 버튼 선택 해제
                    TopButton.setSelected(false);

                    BottomButton.setEnabled(true);
                }
                else{
                    //Middle에서 선택 후 Bottom으로 옮길 때
                    if(!MiddleButton2.isSelected()){
                        //선택 안됐을 때
                        MiddleButton2.setSelected(true);

                        TopButton.setEnabled(false);
                        MiddleButton1.setEnabled(false);
                    }
                    else{
                        MiddleButton2.setSelected(false);

                        TopButton.setEnabled(true);
                        MiddleButton1.setEnabled(true);
                    }
                }
            }
        });


        final int[] finalIntAnswer = IntAnswer;

        BottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!MiddleButton1.isSelected() && !MiddleButton2.isSelected()){
                    //아무것도 안누르고 bottomButton 먼저 누른 경우
                }
                else{

                    if(MiddleButton1.isSelected()){
                        //1번 줄에서 내려온 경우
                        if(Mid1Arr[0] == finalIntAnswer[AnswerNow[0]]){
                            //숫자가 맞을 경우

                            for(int i = 0;i < Mid1Tail[0];i++)
                            {
                                Mid1Arr[i] = Mid1Arr[i+1];
                            }
                            Mid1Arr[Mid1Tail[0]] = 0;

                            Mid1Tail[0]--;

                            String tmpString = "";
                            for(int i = Mid1Tail[0]-1 ;i >= 0; i--){
                                tmpString += "\n" + Mid1Arr[i];
                            }
                            MiddleButton1.setText(tmpString);

                            AnswerNow[0]++;


                            //버튼 상태
                            MiddleButton1.setSelected(false);

                            TopButton.setEnabled(true);
                            MiddleButton2.setEnabled(true);
                            //다 맞을 경우 AnswerNow[0]++ == MaxNum

                            if(AnswerNow[0] == MaxNum)
                                finish();
                        }

                        //숫자가 틀린 경우
                    }
                    else{
                        //2번 줄에서 내려온 경우
                        if(Mid2Arr[0] == finalIntAnswer[AnswerNow[0]]){
                            //숫자가 맞을 경우

                            for(int i = 0;i < Mid2Tail[0];i++)
                            {
                                Mid2Arr[i] = Mid2Arr[i+1];
                            }
                            Mid2Arr[Mid2Tail[0]] = 0;

                            Mid2Tail[0]--;

                            String tmpString = "";
                            for(int i = Mid2Tail[0]-1 ;i >= 0; i--){
                                tmpString += "\n" + Mid2Arr[i];
                            }
                            MiddleButton2.setText(tmpString);

                            AnswerNow[0]++;


                            //버튼 상태
                            MiddleButton2.setSelected(false);

                            TopButton.setEnabled(true);
                            MiddleButton1.setEnabled(true);
                            //다 맞을 경우 AnswerNow[0]++ == MaxNum
                            if(AnswerNow[0] == MaxNum)
                                finish();
                        }

                        //숫자가 틀린 경우
                    }

                }
            }
        });
    }
}
