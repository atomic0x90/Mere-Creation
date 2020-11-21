package atomic0x90.github.io.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Tutorial extends AppCompatActivity {

    //Sound
    SoundPool soundPool;
    int soundID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        Intent intent = new Intent(Tutorial.this, CustomTutorial.class);
        startActivity(intent);

//Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound,1);

        final Button TopButton = (Button) findViewById(R.id.TutorialTopButton);
        final Button MiddleButton1 = (Button) findViewById(R.id.TutorialMiddleButton1);
        final Button MiddleButton2 = (Button) findViewById(R.id.TutorialMiddleButton2);
        final Button BottomButton = (Button) findViewById(R.id.TutorialBottomButton);
        final Button RetryButton = (Button) findViewById(R.id.TutorialRetryButton);

        //int MaxNum = Integer.parseInt(SMaxNum);
        int[] IntAnswer = null;
        final int[] AnswerNow = {0};
        final int[] Mid1Arr = new int[100];
        final int[] Mid2Arr = new int[100];

        final int[] Mid1Tail = {0};
        final int[] Mid2Tail = {0};

        IntAnswer = new int[]{3,1,2};
        BottomButton.setText("3,1,2");

        TopButton.setText("1");
        MiddleButton1.setText("");
        MiddleButton2.setText("");


        RetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(soundID,1f,1f,0,0,1f);

                TopButton.setText("1");
                MiddleButton1.setText("");
                MiddleButton2.setText("");
                //bottom button 색깔 돌려놓기
                AnswerNow[0] = 0;
                Mid1Tail[0] = 0;
                Mid2Tail[0] = 0;
                for(int i = 0;i < 100;i++){
                    Mid1Arr[i] = 0;
                    Mid2Arr[i] = 0;
                }
                String content = BottomButton.getText().toString();

                SpannableStringBuilder spannableString = new SpannableStringBuilder(content);

                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")),0,content.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(new StyleSpan(Typeface.NORMAL),0,content.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                BottomButton.setText(spannableString);

                TopButton.setSelected(false);
                MiddleButton1.setSelected(false);
                MiddleButton2.setSelected(false);
                BottomButton.setSelected(false);
                TopButton.setEnabled(true);
                MiddleButton1.setEnabled(true);
                MiddleButton2.setEnabled(true);
                BottomButton.setEnabled(true);
            }
        });

        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(soundID,1f,1f,0,0,1f);

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
                soundPool.play(soundID,1f,1f,0,0,1f);

                if(TopButton.isSelected()){
                    //Top에서 선택 후 Middle로 옮길 때

                    //숫자 이동 알고리즘
                    int tmpNum = Integer.parseInt((String) TopButton.getText());

                    Mid1Arr[Mid1Tail[0]] = tmpNum;
                    Mid1Tail[0]++;
                    tmpNum++;
                    if(tmpNum <= 3)
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
                soundPool.play(soundID,1f,1f,0,0,1f);

                if(TopButton.isSelected()){
                    //Top에서 선택 후 Middle로 옮길 때

                    //숫자 이동 알고리즘
                    int tmpNum = Integer.parseInt((String) TopButton.getText());

                    Mid2Arr[Mid2Tail[0]] = tmpNum;
                    Mid2Tail[0]++;
                    tmpNum++;
                    if(tmpNum <= 3)
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
                soundPool.play(soundID,1f,1f,0,0,1f);

                if(!MiddleButton1.isSelected() && !MiddleButton2.isSelected()){
                    //아무것도 안누르고 bottomButton 먼저 누른 경우
                }
                else{

                    if(MiddleButton1.isSelected()){
                        //1번 줄에서 내려온 경우
                        if(Mid1Arr[0] == finalIntAnswer[AnswerNow[0]]){
                            //숫자가 맞을 경우
                            //text
                            String nowAnswer = String.valueOf(finalIntAnswer[AnswerNow[0]]);


                            //
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

                            //text 설정
                            String content = BottomButton.getText().toString();

                            SpannableStringBuilder spannableString = new SpannableStringBuilder(content);

                            int start = content.indexOf(nowAnswer);
                            int end = start + nowAnswer.length();
                            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")),0,end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            spannableString.setSpan(new StyleSpan(Typeface.BOLD),0,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                            BottomButton.setText(spannableString);

                            if(AnswerNow[0] == 3) {
                                CustomDialog customDialog = new CustomDialog(Tutorial.this);
                                customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                                customDialog.setCancelable(false);
                                customDialog.show();
                            }
                        }
                    }
                    else{
                        //2번 줄에서 내려온 경우
                        if(Mid2Arr[0] == finalIntAnswer[AnswerNow[0]]) {
                            //숫자가 맞을 경우
                            //text
                            String nowAnswer = String.valueOf(finalIntAnswer[AnswerNow[0]]);


                            //
                            for (int i = 0; i < Mid2Tail[0]; i++) {
                                Mid2Arr[i] = Mid2Arr[i + 1];
                            }
                            Mid2Arr[Mid2Tail[0]] = 0;

                            Mid2Tail[0]--;

                            String tmpString = "";
                            for (int i = Mid2Tail[0] - 1; i >= 0; i--) {
                                tmpString += "\n" + Mid2Arr[i];
                            }
                            MiddleButton2.setText(tmpString);

                            AnswerNow[0]++;


                            //버튼 상태
                            MiddleButton2.setSelected(false);

                            TopButton.setEnabled(true);
                            MiddleButton1.setEnabled(true);

                            //text 설정
                            String content = BottomButton.getText().toString();

                            SpannableString spannableString = new SpannableString(content);

                            int start = content.indexOf(nowAnswer);
                            int end = start + nowAnswer.length();
                            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                            BottomButton.setText(spannableString);

                            if(AnswerNow[0] == 3){
                                CustomDialog customDialog = new CustomDialog(Tutorial.this);
                                customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                                customDialog.setCancelable(false);
                                customDialog.show();
                            }
                        }
                    }

                }

            }

        });
    }




    @Override
    public void onBackPressed(){
        CustomDialogBackKey costomDialog = new CustomDialogBackKey(Tutorial.this);
        costomDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        costomDialog.setCancelable(false);
        costomDialog.show();
    }
}
