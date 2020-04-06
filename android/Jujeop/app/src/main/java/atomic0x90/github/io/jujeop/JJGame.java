package atomic0x90.github.io.jujeop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JJGame extends AppCompatActivity {

    //Double click check
    private long mLastClickTime = 0;

    String[] topText = {"",
            "밖에 비가 많이 내리네요"
    };

    String[] resultText = {"",
            "심장마비"
    };

    String[] endText = {"",
            ""
    };

    String[] String1 = {
            "가","각","간","갈","감","갑","강","개","거","건",
            "걸","검","겁","것","게","격","경","고","곡","곤",
            "골","곰","곱","공","과","곽","관","광","교","구",
            "국","군","굳","굼","굽","궁","권","귤","그","글",
            "금","기","긴","길","김"
    };

    String[] String2 = {
            "나","난","날","남","납","낭","낳","내","너","넌",
            "널","네","넵","노","녹","놀","놈","누","눈","눕",
            "는"
    };

    String[] String3 = {
            "다","단","달","담","답","당","대","댐","더","던",
            "덤","데","도","독","돈","돌","돔","돕","동","돼",
            "됐","두","둠","들","디","딜"
    };

    String[] String4 = {
            "라","락","란","람","랑","램","랩","러","런","려",
            "로","록","론","롤","롬","롭","루","룬","룰","름",
            "를","릅","리","린","림","링"
    };

    String[] String5 = {
            "마","막","만","말","맘","맛","망","매","맨","맴",
            "맵","맹","먹","먼","멍","메","멜","면","모","목",
            "몸","몹","묘","무","묵","문","물","뭍","뭐","미",
            "민","밀"
    };

    String[] String6 = {
            "바","박","밖","반","발","밤","밥","방","밭","배",
            "백","밴","밸","뱀","버","벅","번","벌","벼","변",
            "별","병","보","복","본","볼","봄","부","북","분",
            "불","붕","브","비","빈","빌","빔","빗","빙","빚",
            "빛"
    };

    String[] String7 = {
            "사","삭","산","살","삼","삽","상","새","색","샘",
            "생","서","석","선","설","섬","섭","성","세","센",
            "셈","소","속","손","솔","솜","송","쇠","수","순",
            "술","숨","숭","숲","쉬","쉰","쉼","스","슥","슬",
            "슴","습","승","시","식","신","실","심","십","싱"
    };

    String[] String8 = {
            "아","악","안","알","앎","암","았","앞","애","액",
            "앱","약","양","어","억","엄","업","없","었","에",
            "역","연","열","염","엽","영","예","오","옥","온",
            "올","옴","옷","와","완","왕","왜","왠","왼","요",
            "용","원","우","운","울","움","웁","월","웬","위",
            "유","윤","은","을","음","읍","응","의","이","인",
            "일","임","입","잉"
    };

    String[] String9 = {
            "자","잔","잘","잠","장","재","잼","잽","쟁","쟤",
            "저","적","전","절","점","정","제","조","족","존",
            "좀","종","좌","죄","주","죽","준","줄","줌","중",
            "쥐","즐","즙","지","진","질","짐","집"
    };

    String[] String10 = {
            "차","찬","참","찹","창","채","책","챙","처","척",
            "천","철","첩","청","체","쳐","초","촉","총","최",
            "추","축","춘","춤","층","츤","치","친","칠","침"
    };

    String[] String11 = {
            "카","칸","칼","캉","캔","캡","컴","컵","컸","컬",
            "코","콕","콘","콜","콩","콸","키","킹"
    };

    String[] String12 = {
            "타","탁","탄","탈","탐","탕","태","터","털","템",
            "토","톡","톱","툭","툴","틀","틈","팀","팁"
    };

    String[] String13 = {
            "파","판","팔","팜","팡","퍼","퍽","펀","펌","펍",
            "펑","펜","편","포","폰","폴","폼","퐁","표","푸",
            "푼","풀","품","풍","피","핀","핑"
    };

    String[] String14 = {
            "하","학","한","할","함","항","해","햄","행","허",
            "헐","헝","헤","헬","혀","현","혈","혐","형","호",
            "혹","혼","홀","홈","홍","화","확","환","활","황",
            "회","효","후","훅","훈","휘","휠","휨","휴","흑",
            "흙","흠","흥","흰","히","힌","힐","힘","힙"
    };

    String[] String15 = {
            "까","강","꼴","꽃","꽝","꿀","꿈","끈","끌","끝",
            "딱","딸","땀","땅","때","땡","떡","떨","또","똥",
            "뚜","뜸","뜻","빠","빡","빨","빵","뺨","뻑","뻔",
            "뻘","뻥","뼈","뽀","뿔","뿜","뿡","싹","쌀","쌈",
            "쏘","쏙","쏜","쏠","쑥","씀","씨","짝","짤","짬",
            "짱","짹","쨍","쪽","찜","찢"
    };

    String[] textString = new String[23];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_j_game);



        long seed = System.currentTimeMillis();
        Random random = new Random(seed);



        //22 23
        //21
        //26
        //26
        //16 16
        //20 21
        //25 25
        //32 32
        //19 19
        //30
        //18
        //19
        //27
        //24 25
        //56

        int rand = random.nextInt(22);
        textString[1] = String1[rand];

        random = new Random(seed);
        rand = random.nextInt(23)+22;
        textString[2] = String1[rand];

        random = new Random(seed);
        rand = random.nextInt(21);
        textString[3] = String2[rand];

        random = new Random(seed);
        rand = random.nextInt(26);
        textString[4] = String3[rand];

        random = new Random(seed);
        rand = random.nextInt(26);
        textString[5] = String4[rand];

        random = new Random(seed);
        rand = random.nextInt(16);
        textString[6] = String5[rand];

        random = new Random(seed);
        rand = random.nextInt(16)+16;
        textString[7] = String5[rand];

        random = new Random(seed);
        rand = random.nextInt(20);
        textString[8] = String6[rand];

        random = new Random(seed);
        rand = random.nextInt(21)+20;
        textString[9] = String6[rand];

        random = new Random(seed);
        rand = random.nextInt(25);
        textString[10] = String7[rand];

        random = new Random(seed);
        rand = random.nextInt(25)+25;
        textString[11] = String7[rand];

        random = new Random(seed);
        rand = random.nextInt(32);
        textString[12] = String8[rand];

        random = new Random(seed);
        rand = random.nextInt(32)+32;
        textString[13] = String8[rand];

        random = new Random(seed);
        rand = random.nextInt(19);
        textString[14] = String9[rand];

        random = new Random(seed);
        rand = random.nextInt(19)+19;
        textString[15] = String9[rand];

        random = new Random(seed);
        rand = random.nextInt(30);
        textString[16] = String10[rand];

        random = new Random(seed);
        rand = random.nextInt(18);
        textString[17] = String11[rand];

        random = new Random(seed);
        rand = random.nextInt(19);
        textString[18] = String12[rand];

        random = new Random(seed);
        rand = random.nextInt(27);
        textString[19] = String13[rand];

        random = new Random(seed);
        rand = random.nextInt(24);
        textString[20] = String14[rand];

        random = new Random(seed);
        rand = random.nextInt(25)+24;
        textString[21] = String14[rand];

        random = new Random(seed);
        rand = random.nextInt(56);
        textString[22] = String15[rand];


        Intent tmpintent = getIntent();

        int getType = tmpintent.getIntExtra("LV",0);

        TextView topTextView = (TextView)findViewById(R.id.TopText);
        TextView endTextView = (TextView)findViewById(R.id.idea_endText);

        if(getType == 1) {
            topTextView.setText(topText[1]);
            endTextView.setText(endText[1]);
        }




        final TextView inputTextView = (TextView)findViewById(R.id.inputText);




        Button DelButton = (Button)findViewById(R.id.DelButton);
        DelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 100){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                String tmpString = (String) inputTextView.getText();
                if(tmpString.length() <= 1)
                    inputTextView.setText("");
                else {
                    String delString = tmpString.substring(0,tmpString.length()-1);
                    inputTextView.setText(delString);
                }
            }
        });

        Button textButton1 = (Button)findViewById(R.id.TextButton1);
        Button textButton2 = (Button)findViewById(R.id.TextButton2);
        Button textButton3 = (Button)findViewById(R.id.TextButton3);
        Button textButton4 = (Button)findViewById(R.id.TextButton4);
        Button textButton5 = (Button)findViewById(R.id.TextButton5);
        Button textButton6 = (Button)findViewById(R.id.TextButton6);
        Button textButton7 = (Button)findViewById(R.id.TextButton7);
        Button textButton8 = (Button)findViewById(R.id.TextButton8);
        Button textButton9 = (Button)findViewById(R.id.TextButton9);
        Button textButton10 = (Button)findViewById(R.id.TextButton10);
        Button textButton11 = (Button)findViewById(R.id.TextButton11);
        Button textButton12 = (Button)findViewById(R.id.TextButton12);
        Button textButton13 = (Button)findViewById(R.id.TextButton13);
        Button textButton14 = (Button)findViewById(R.id.TextButton14);
        Button textButton15 = (Button)findViewById(R.id.TextButton15);
        Button textButton16 = (Button)findViewById(R.id.TextButton16);
        Button textButton17 = (Button)findViewById(R.id.TextButton17);
        Button textButton18 = (Button)findViewById(R.id.TextButton18);
        Button textButton19 = (Button)findViewById(R.id.TextButton19);
        Button textButton20 = (Button)findViewById(R.id.TextButton20);
        Button textButton21 = (Button)findViewById(R.id.TextButton21);
        Button textButton22 = (Button)findViewById(R.id.TextButton22);


        //check result?

        int check1 = -1;
        int check2 = -1;
        int check3 = -1;
        int check4 = -1;

        if(getType == 1) {
            for(int i = 1;i < 23;i++) {
                if(textString[i] == "심")
                    check1 = i;
                if(textString[i] == "장")
                    check2 = i;
                if(textString[i] == "마")
                    check3 = i;
                if(textString[i] == "비")
                    check4 = i;
            }

            System.out.println("fffffffffffffffffffffff"+check1+" "+check2+" "+check3+" "+check4);
            if(check1 == -1){
                for(int i = 1;i < 23;i++){
                    if(check2 != i && check3 != i && check4 != i){
                        textString[i] = "심";
                        check1 = i;
                        break;
                    }
                }
            }

            if(check2 == -1){
                for(int i = 5;i < 23;i++){
                    if(check1 != i && check3 != i && check4 != i){
                        textString[i] = "장";
                        check2 = i;
                        break;
                    }
                }
            }

            if(check3 == -1){
                for(int i = 10;i < 23;i++){
                    if(check1 != i && check2 != i && check4 != i){
                        textString[i] = "마";
                        check3 = i;
                        break;
                    }
                }
            }

            if(check4 == -1){
                for(int i = 22;i > 0;i--){
                    if(check1 != i && check2 != i && check3 != i){
                        textString[i] = "비";
                        check4 = i;
                        break;
                    }
                }
            }
        }


        //rand text

        random = new Random(seed);
        rand = random.nextInt(30)+100;
        for(int i = 10;i < rand;i++){

            int j = random.nextInt(22)+1;
            int k = random.nextInt(22)+1;

            System.out.println("AAAAAA " + j+" "+k);
            String tmp = textString[j];
            textString[j] = textString[k];
            textString[k] = tmp;

        }

        //Text set
        textButton1.setText(textString[1]);
        textButton2.setText(textString[2]);
        textButton3.setText(textString[3]);
        textButton4.setText(textString[4]);
        textButton5.setText(textString[5]);
        textButton6.setText(textString[6]);
        textButton7.setText(textString[7]);
        textButton8.setText(textString[8]);
        textButton9.setText(textString[9]);
        textButton10.setText(textString[10]);
        textButton11.setText(textString[11]);
        textButton12.setText(textString[12]);
        textButton13.setText(textString[13]);
        textButton14.setText(textString[14]);
        textButton15.setText(textString[15]);
        textButton16.setText(textString[16]);
        textButton17.setText(textString[17]);
        textButton18.setText(textString[18]);
        textButton19.setText(textString[19]);
        textButton20.setText(textString[20]);
        textButton21.setText(textString[21]);
        textButton22.setText(textString[22]);


        //Button set
        textButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 100){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                String tmpString = (String) inputTextView.getText();
                tmpString += textString[1];
                inputTextView.setText(tmpString);
            }
        });
    }

    // 마지막으로 뒤로 가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    private Toast toast;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        // 2500 milliseconds = 2.5 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 메인 화면으로 이동합니다.", Toast.LENGTH_SHORT);
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
