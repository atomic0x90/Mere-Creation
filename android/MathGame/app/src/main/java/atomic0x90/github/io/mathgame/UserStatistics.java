package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;
import java.util.Locale;

public class UserStatistics extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;

    //AD
    private AdView mAdView;


    //plus
    int plusIDX = -1;
    double plusResult = 0,plusAVtime = 0,plus10Result = 0,plus10AVtime = 0;

    //Sub
    int subIDX = -1;
    double subResult = 0,subAVtime = 0,sub10Result = 0,sub10AVtime = 0;

    //Mul
    int mulIDX = -1;
    double mulResult = 0,mulAVtime = 0,mul10Result = 0,mul10AVtime = 0;

    //Divide
    int divIDX = -1;
    double divResult = 0,divAVtime = 0,div10Result = 0,div10AVtime = 0;

    //Infi Plus
    int infiP6 = -1,infiP7 = -1,infiP8 = -1,infiP13 = -1,infiP16 = -1,infiP17 = -1,infiP6_9 = -1,infiP13_17 = -1,infiP6_17 = -1;
    double infiPR6 = 0,infiPR7 = 0,infiPR8 = 0,infiPR13 = 0,infiPR16 = 0,infiPR17 = 0,infiPR6_9 = 0,infiPR13_17 = 0,infiPR6_17 = 0;
    double infiP10R6 = 0,infiP10R7 = 0,infiP10R8 = 0,infiP10R13 = 0,infiP10R16 = 0,infiP10R17 = 0,infiP10R6_9 = 0,infiP10R13_17 = 0,infiP10R6_17 = 0;

    //Infi minus
    int infiM6 = -1,infiM7 = -1,infiM8 = -1,infiM13 = -1,infiM16 = -1,infiM17 = -1,infiM6_9 = -1,infiM13_17 = -1,infiM6_17 = -1;
    double infiMR6 = 0,infiMR7 = 0,infiMR8 = 0,infiMR13 = 0,infiMR16 = 0,infiMR17 = 0,infiMR6_9 = 0,infiMR13_17 = 0,infiMR6_17 = 0;
    double infiM10R6 = 0,infiM10R7 = 0,infiM10R8 = 0,infiM10R13 = 0,infiM10R16 = 0,infiM10R17 = 0,infiM10R6_9 = 0,infiM10R13_17 = 0,infiM10R6_17 = 0;

    //MaxMin
    int mm1_10 = -1,mm10_20 = -1,mm20_30 = -1;
    double mm1_10R = 0,mm10_20R = 0,mm20_30R = 0;
    double mm1_10T = 0,mm10_20T = 0,mm20_30T = 0;
    double mm1_10R10 = 0,mm10_20R10 = 0,mm20_30R10 = 0;
    double mm1_10T10 = 0,mm10_20T10 = 0,mm20_30T10 = 0;


    //FULL AD

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_statistics);

        //AD
        mAdView = findViewById(R.id.adView13);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //FULL AD


        //DB
        sqLiteDatabase =  init_database();


        //Plus (1)
        TextView plusChallengeText = (TextView) findViewById(R.id.plusChallengeText2);

        load_plus();

        if(plusIDX == -1){
            plusChallengeText.setText("전체 정답률 : 정보 없음\n전체 평균 시간 : 정보 없음\n최근 10회 정답률 : 정보 없음\n최근 10회 평균 시간 : 정보 없음");
        }
        else if(plusIDX >= 1 && plusIDX <= 10){
            plusChallengeText.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : 정보 부족\n" +
                    "최근 10회 평균 시간 : 정보 부족",(plusResult/(plusIDX*10))*100,plusAVtime/plusIDX));
        }
        else{
            pre_load_plus();
            plusChallengeText.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : %.2f %%\n" +
                    "최근 10회 평균 시간 : %.1f s",(plusResult/(plusIDX*10))*100,plusAVtime/plusIDX,(plus10Result/(10*10))*100,plus10AVtime/10));
        }

        //Minus (2)
        TextView minusChallengeText = (TextView) findViewById(R.id.minusChallengeText2);

        load_sub();

        if(subIDX == -1){
            minusChallengeText.setText("전체 정답률 : 정보 없음\n전체 평균 시간 : 정보 없음\n최근 10회 정답률 : 정보 없음\n최근 10회 평균 시간 : 정보 없음");
        }
        else if(subIDX >= 1 && subIDX <= 10){
            minusChallengeText.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : 정보 부족\n" +
                    "최근 10회 평균 시간 : 정보 부족",(subResult/(subIDX*10))*100,subAVtime/subIDX));
        }
        else{
            pre_load_sub();
            minusChallengeText.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : %.2f %%\n" +
                    "최근 10회 평균 시간 : %.1f s",(subResult/(subIDX*10))*100,subAVtime/subIDX,(sub10Result/(10*10))*100,sub10AVtime/10));
        }

        //Multiplication (3)
        TextView mulChallengeText = (TextView) findViewById(R.id.mulChallengeText2);

        load_mul();

        if(mulIDX == -1){
            mulChallengeText.setText("전체 정답률 : 정보 없음\n전체 평균 시간 : 정보 없음\n최근 10회 정답률 : 정보 없음\n최근 10회 평균 시간 : 정보 없음");
        }
        else if(mulIDX >= 1 && mulIDX <= 10){
            mulChallengeText.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : 정보 부족\n" +
                    "최근 10회 평균 시간 : 정보 부족",(mulResult/(mulIDX*10))*100,mulAVtime/mulIDX));
        }
        else{
            pre_load_mul();
            mulChallengeText.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : %.2f %%\n" +
                    "최근 10회 평균 시간 : %.1f s",(mulResult/(mulIDX*10))*100,mulAVtime/mulIDX,(mul10Result/(10*10))*100,mul10AVtime/10));
        }

        //Divide (4)

        TextView divideChallengeText = (TextView) findViewById(R.id.divideChallengeText2);

        load_div();

        if(divIDX == -1){
            divideChallengeText.setText("전체 정답률 : 정보 없음\n전체 평균 시간 : 정보 없음\n최근 10회 정답률 : 정보 없음\n최근 10회 평균 시간 : 정보 없음");
        }
        else if(divIDX >= 1 && divIDX <= 10){
            divideChallengeText.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : 정보 부족\n" +
                    "최근 10회 평균 시간 : 정보 부족",(divResult/(divIDX*10))*100,divAVtime/divIDX));
        }
        else{
            pre_load_div();
            divideChallengeText.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : %.2f %%\n" +
                    "최근 10회 평균 시간 : %.1f s",(divResult/(divIDX*10))*100,divAVtime/divIDX,(div10Result/(10*10))*100,div10AVtime/10));
        }

        //Infi Plus 6

        TextView infiChallengeP6Text = (TextView)findViewById(R.id.infiChallengeP6Text2);

        load_InfiP6();
        if(infiP6 == -1){
            infiChallengeP6Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiP6 >= 1 && infiP6 <= 10){
            infiChallengeP6Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiPR6/infiP6));
        }
        else{
            pre_load_InfiP6();
            infiChallengeP6Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiPR6/infiP6 , infiP10R6/10));
        }

        //Infi Plus 7
        TextView infiChallengeP7Text = (TextView)findViewById(R.id.infiChallengeP7Text2);

        load_InfiP7();
        if(infiP7 == -1){
            infiChallengeP7Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiP7 >= 1 && infiP7 <= 10){
            infiChallengeP7Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiPR7/infiP7));
        }
        else{
            pre_load_InfiP7();
            infiChallengeP7Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiPR7/infiP7 , infiP10R7/10));
        }

        //Infi Plus 8
        TextView infiChallengeP8Text = (TextView)findViewById(R.id.infiChallengeP8Text2);

        load_InfiP8();
        if(infiP8 == -1){
            infiChallengeP8Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiP8 >= 1 && infiP8 <= 10){
            infiChallengeP8Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiPR8/infiP8));
        }
        else{
            pre_load_InfiP8();
            infiChallengeP8Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiPR8/infiP8 , infiP10R8/10));
        }

        //Infi Plus 13
        TextView infiChallengeP13Text = (TextView)findViewById(R.id.infiChallengeP13Text2);

        load_InfiP13();
        if(infiP13 == -1){
            infiChallengeP13Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiP13 >= 1 && infiP13 <= 10){
            infiChallengeP13Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiPR13/infiP13));
        }
        else{
            pre_load_InfiP13();
            infiChallengeP13Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiPR13/infiP13 , infiP10R13/10));
        }

        //Infi Plus 16
        TextView infiChallengeP16Text = (TextView)findViewById(R.id.infiChallengeP16Text2);

        load_InfiP16();
        if(infiP16 == -1){
            infiChallengeP16Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiP16 >= 1 && infiP16 <= 10){
            infiChallengeP16Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiPR16/infiP16));
        }
        else{
            pre_load_InfiP16();
            infiChallengeP16Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiPR16/infiP16 , infiP10R16/10));
        }

        //Infi Plus 17
        TextView infiChallengeP17Text = (TextView)findViewById(R.id.infiChallengeP17Text2);

        load_InfiP17();
        if(infiP17 == -1){
            infiChallengeP17Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiP17 >= 1 && infiP17 <= 10){
            infiChallengeP17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiPR17/infiP17));
        }
        else{
            pre_load_InfiP17();
            infiChallengeP17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiPR17/infiP17 , infiP10R17/10));
        }

        //Infi Plus 6_9
        TextView infiChallengeP6_9Text = (TextView)findViewById(R.id.infiChallengeP6_9Text2);

        load_InfiP6_9();
        if(infiP6_9 == -1){
            infiChallengeP6_9Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiP6_9 >= 1 && infiP6_9 <= 10){
            infiChallengeP6_9Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiPR6_9/infiP6_9));
        }
        else{
            pre_load_InfiP6_9();
            infiChallengeP6_9Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiPR6_9/infiP6_9 , infiP10R6_9/10));
        }

        //Infi Plus 13_17
        TextView infiChallengeP13_17Text = (TextView)findViewById(R.id.infiChallengeP13_17Text2);

        load_InfiP13_17();
        if(infiP13_17 == -1){
            infiChallengeP13_17Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiP13_17 >= 1 && infiP13_17 <= 10){
            infiChallengeP13_17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiPR13_17/infiP13_17));
        }
        else{
            pre_load_InfiP13_17();
            infiChallengeP13_17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiPR13_17/infiP13_17 , infiP10R13_17/10));
        }

        //Infi Plus 6_17
        TextView infiChallengeP6_17Text = (TextView)findViewById(R.id.infiChallengeP6_17Text2);

        load_InfiP6_17();
        if(infiP6_17 == -1){
            infiChallengeP6_17Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiP6_17 >= 1 && infiP6_17 <= 10){
            infiChallengeP6_17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiPR6_17/infiP6_17));
        }
        else{
            pre_load_InfiP6_17();
            infiChallengeP6_17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiPR6_17/infiP6_17 , infiP10R6_17/10));
        }


        //Infi Minus 6
        TextView infiChallengeM6Text = (TextView)findViewById(R.id.infiChallengeM6Text2);

        load_InfiM6();
        if(infiM6 == -1){
            infiChallengeM6Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiM6 >= 1 && infiM6 <= 10){
            infiChallengeM6Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiMR6/infiM6));
        }
        else{
            pre_load_InfiM6();
            infiChallengeM6Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiMR6/infiM6 , infiM10R6/10));
        }

        //Infi Minus 7
        TextView infiChallengeM7Text = (TextView)findViewById(R.id.infiChallengeM7Text2);

        load_InfiM7();
        if(infiM7 == -1){
            infiChallengeM7Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiM7 >= 1 && infiM7 <= 10){
            infiChallengeM7Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiMR7/infiM7));
        }
        else{
            pre_load_InfiM7();
            infiChallengeM7Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiMR7/infiM7 , infiM10R7/10));
        }

        //Infi Minus 8
        TextView infiChallengeM8Text = (TextView)findViewById(R.id.infiChallengeM8Text2);

        load_InfiM8();
        if(infiM8 == -1){
            infiChallengeM8Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiM8 >= 1 && infiM8 <= 10){
            infiChallengeM8Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiMR8/infiM8));
        }
        else{
            pre_load_InfiM8();
            infiChallengeM8Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiMR8/infiM8 , infiM10R8/10));
        }

        //Infi Minus 13
        TextView infiChallengeM13Text = (TextView)findViewById(R.id.infiChallengeM13Text2);

        load_InfiM13();
        if(infiM13 == -1){
            infiChallengeM13Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiM13 >= 1 && infiM13 <= 10){
            infiChallengeM13Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiMR13/infiM13));
        }
        else{
            pre_load_InfiM13();
            infiChallengeM13Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiMR13/infiM13 , infiM10R13/10));
        }

        //Infi Minus 16
        TextView infiChallengeM16Text = (TextView)findViewById(R.id.infiChallengeM16Text2);

        load_InfiM16();
        if(infiM16 == -1){
            infiChallengeM16Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiM16 >= 1 && infiM16 <= 10){
            infiChallengeM16Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiMR16/infiM16));
        }
        else{
            pre_load_InfiM16();
            infiChallengeM16Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiMR16/infiM16 , infiM10R16/10));
        }

        //Infi Minus 17
        TextView infiChallengeM17Text = (TextView)findViewById(R.id.infiChallengeM17Text2);

        load_InfiM17();
        if(infiM17 == -1){
            infiChallengeM17Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiM17 >= 1 && infiM17 <= 10){
            infiChallengeM17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiMR17/infiM17));
        }
        else{
            pre_load_InfiM17();
            infiChallengeM17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiMR17/infiM17 , infiM10R17/10));
        }

        //Infi Minus 6_9
        TextView infiChallengeM6_9Text = (TextView)findViewById(R.id.infiChallengeM6_9Text2);

        load_InfiMR6_9();
        if(infiM6_9 == -1){
            infiChallengeM6_9Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiM6_9 >= 1 && infiM6_9 <= 10){
            infiChallengeM13Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiMR6_9/infiM6_9));
        }
        else{
            pre_load_InfiMR6_9();
            infiChallengeM6_9Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiMR6_9/infiM6_9 , infiM10R6_9/10));
        }

        //Infi Minus 13_17
        TextView infiChallengeM13_17Text = (TextView)findViewById(R.id.infiChallengeM13_17Text2);

        load_InfiMR13_17();
        if(infiM13_17 == -1){
            infiChallengeM13_17Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiM13_17 >= 1 && infiM13_17 <= 10){
            infiChallengeM13_17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiMR13_17/infiM13_17));
        }
        else{
            pre_load_InfiMR13_17();
            infiChallengeM13_17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiMR13_17/infiM13_17 , infiM10R13_17/10));
        }

        //Infi Minus 6_17
        TextView infiChallengeM6_17Text = (TextView)findViewById(R.id.infiChallengeM6_17Text2);

        load_InfiMR6_17();
        if(infiM6_17 == -1){
            infiChallengeM6_17Text.setText("전체 평균 정답 개수 : 정보 없음\n최근 10회 평균 정답 개수: 정보 없음");
        }
        else if(infiM6_17 >= 1 && infiM6_17 <= 10){
            infiChallengeM6_17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : 정보 부족",infiMR6_17/infiM6_17));
        }
        else{
            pre_load_InfiMR6_17();
            infiChallengeM6_17Text.setText(String.format(Locale.getDefault(),"전체 평균 정답 개수 : %.1f 개\n" +
                    "최근 10회 평균 정답 개수 : %.1f 개",infiMR6_17/infiM6_17 , infiM10R6_17/10));
        }

        //MaxMin 1_10
        TextView MaxMin1_10Text = (TextView) findViewById(R.id.MaxMin1_10Text2);

        load_mm1_10();

        if(mm1_10 == -1){
            MaxMin1_10Text.setText("전체 정답률 : 정보 없음\n전체 평균 시간 : 정보 없음\n최근 10회 정답률 : 정보 없음\n최근 10회 평균 시간 : 정보 없음");
        }
        else if(mm1_10 >= 1 && mm1_10 <= 10){
            MaxMin1_10Text.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : 정보 부족\n" +
                    "최근 10회 평균 시간 : 정보 부족",(mm1_10R/(mm1_10*5))*100,mm1_10T/mm1_10));
        }
        else{
            pre_load_mm1_10();
            MaxMin1_10Text.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : %.2f %%\n" +
                    "최근 10회 평균 시간 : %.1f s",(mm1_10R/(mm1_10*5))*100,mm1_10T/mm1_10,(mm1_10R10/(10*5))*100,mm1_10T10/10));
        }

        //MaxMin 10_20
        TextView MaxMin10_20Text = (TextView) findViewById(R.id.MaxMin10_20Text2);

        load_mm10_20();

        if(mm10_20 == -1){
            MaxMin10_20Text.setText("전체 정답률 : 정보 없음\n전체 평균 시간 : 정보 없음\n최근 10회 정답률 : 정보 없음\n최근 10회 평균 시간 : 정보 없음");
        }
        else if(mm10_20 >= 1 && mm10_20 <= 10){
            MaxMin10_20Text.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : 정보 부족\n" +
                    "최근 10회 평균 시간 : 정보 부족",(mm10_20R/(mm10_20*5))*100,mm10_20T/mm10_20));
        }
        else{
            pre_load_mm10_20();
            MaxMin10_20Text.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : %.2f %%\n" +
                    "최근 10회 평균 시간 : %.1f s",(mm10_20R/(mm10_20*5))*100,mm10_20T/mm10_20,(mm10_20R10/(10*5))*100,mm10_20T10/10));
        }

        //MaxMin 20_30
        TextView MaxMin20_30Text = (TextView) findViewById(R.id.MaxMin20_30Text2);

        load_mm20_30();

        if(mm20_30 == -1){
            MaxMin20_30Text.setText("전체 정답률 : 정보 없음\n전체 평균 시간 : 정보 없음\n최근 10회 정답률 : 정보 없음\n최근 10회 평균 시간 : 정보 없음");
        }
        else if(mm20_30 >= 1 && mm20_30 <= 10){
            MaxMin20_30Text.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : 정보 부족\n" +
                    "최근 10회 평균 시간 : 정보 부족",(mm20_30R/(mm20_30*5))*100,mm20_30T/mm20_30));
        }
        else{
            pre_load_mm20_30();
            MaxMin20_30Text.setText(String.format(Locale.getDefault(),"전체 정답률 : %.2f %%\n" +
                    "전체 평균 시간 : %.1f s\n" +
                    "최근 10회 정답률 : %.2f %%\n" +
                    "최근 10회 평균 시간 : %.1f s",(mm20_30R/(mm20_30*5))*100,mm20_30T/mm20_30,(mm20_30R10/(10*5))*100,mm20_30T10/10));
        }
    }



    //DB
    private SQLiteDatabase init_database() {

        SQLiteDatabase db = null ;
        // File file = getDatabasePath("contact.db") ;
        File file = new File(getFilesDir(), "contact.db") ;

        System.out.println("PATH : " + file.toString()) ;
        try {
            db = SQLiteDatabase.openOrCreateDatabase(file, null) ;
        } catch (SQLiteException e) {
            e.printStackTrace() ;
        }

        if (db == null) {
            System.out.println("DB creation failed. " + file.getAbsolutePath()) ;
        }

        return db ;
    }

    //plus
    private void load_plus(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM ChAdd";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                //if (cursor.moveToNext())
                do {
                    plusIDX = cursor.getInt(0);
                    plusResult += cursor.getInt(1);
                    plusAVtime += cursor.getDouble(2);

                    System.out.println("TEST " + plusIDX + " " + plusResult + " " + plusAVtime);
                }while(cursor.moveToNext());
            }
        }
    }

    private void pre_load_plus(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM ChAdd";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;


                    plus10Result += cursor.getInt(1);
                    plus10AVtime += cursor.getDouble(2);

                    System.out.println("10 TEST "+plus10Result + " "+plus10AVtime + "check "+check);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    //Minus
    private void load_sub(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM ChSub";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                //if (cursor.moveToNext())
                do {
                    subIDX = cursor.getInt(0);
                    subResult += cursor.getInt(1);
                    subAVtime += cursor.getDouble(2);

                    System.out.println("TEST " + subIDX + " " + subResult + " " + subAVtime);
                }while(cursor.moveToNext());
            }
        }
    }

    private void pre_load_sub(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM ChSub";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;


                    sub10Result += cursor.getInt(1);
                    sub10AVtime += cursor.getDouble(2);

                    System.out.println("10 TEST "+sub10Result + " "+sub10AVtime + "check "+check);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    //Multiplication
    private void load_mul(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM ChMul";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    mulIDX = cursor.getInt(0);
                    mulResult += cursor.getInt(1);
                    mulAVtime += cursor.getDouble(2);

                    System.out.println("TEST " + mulIDX + " " + mulResult + " " + mulAVtime);
                }while(cursor.moveToNext());
            }
        }
    }

    private void pre_load_mul(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM ChMul";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;


                    mul10Result += cursor.getInt(1);
                    mul10AVtime += cursor.getDouble(2);

                    System.out.println("10 TEST "+mul10Result + " "+mul10AVtime + "check "+check);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    //Divide
    private void load_div(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM ChDiv";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    divIDX = cursor.getInt(0);
                    divResult += cursor.getInt(1);
                    divAVtime += cursor.getDouble(2);

                    System.out.println("TEST " + divIDX + " " + divResult + " " + divAVtime);
                }while(cursor.moveToNext());
            }
        }
    }

    private void pre_load_div(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM ChDiv";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;


                    div10Result += cursor.getInt(1);
                    div10AVtime += cursor.getDouble(2);

                    System.out.println("10 TEST "+div10Result + " "+div10AVtime + "check "+check);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    //Infi Plus
    private void load_InfiP6(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM InfiChP6";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    infiP6 = cursor.getInt(0);
                    infiPR6 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiP6(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChP6";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    infiP10R6 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiP7(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM InfiChP7";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    infiP7 = cursor.getInt(0);
                    infiPR7 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiP7(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChP7";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    infiP10R7 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiP8(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM InfiChP8";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    infiP8 = cursor.getInt(0);
                    infiPR8 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiP8(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChP8";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    infiP10R8 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiP13(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM InfiChP13";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    infiP13 = cursor.getInt(0);
                    infiPR13 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiP13(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChP13";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    infiP10R13 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiP16(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM InfiChP16";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    infiP16 = cursor.getInt(0);
                    infiPR16 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiP16(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChP16";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    infiP10R16 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiP17(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM InfiChP17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    infiP17 = cursor.getInt(0);
                    infiPR17 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiP17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChP17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    infiP10R17 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiP6_9(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM InfiChPR6_9";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    infiP6_9 = cursor.getInt(0);
                    infiPR6_9 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiP6_9(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChPR6_9";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    infiP10R6_9 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiP13_17(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM InfiChPR13_17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    infiP13_17 = cursor.getInt(0);
                    infiPR13_17 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiP13_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChPR13_17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    infiP10R13_17 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiP6_17(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM InfiChPR6_17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    infiP6_17 = cursor.getInt(0);
                    infiPR6_17 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiP6_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChPR6_17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    infiP10R6_17 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiM6(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM6";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToFirst()){
                do{
                    infiM6 = cursor.getInt(0);
                    infiMR6 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiM6(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM6";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do{
                    check++;

                    infiM10R6 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiM7(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM7";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToFirst()){
                do{
                    infiM7 = cursor.getInt(0);
                    infiMR7 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiM7(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM7";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do{
                    check++;

                    infiM10R7 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiM8(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM8";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToFirst()){
                do{
                    infiM8 = cursor.getInt(0);
                    infiMR8 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiM8(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM8";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do{
                    check++;

                    infiM10R8 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiM13(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM13";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToFirst()){
                do{
                    infiM13 = cursor.getInt(0);
                    infiMR13 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiM13(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM13";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do{
                    check++;

                    infiM10R13 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiM16(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM16";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToFirst()){
                do{
                    infiM16 = cursor.getInt(0);
                    infiMR16 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiM16(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM16";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do{
                    check++;

                    infiM10R16 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiM17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToFirst()){
                do{
                    infiM17 = cursor.getInt(0);
                    infiMR17 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiM17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChM17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do{
                    check++;

                    infiM10R17 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiMR6_9(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChMR6_9";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToFirst()){
                do{
                    infiM6_9 = cursor.getInt(0);
                    infiMR6_9 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiMR6_9(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChMR6_9";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do{
                    check++;

                    infiM10R6_9 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiMR13_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChMR13_17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToFirst()){
                do{
                    infiM13_17 = cursor.getInt(0);
                    infiMR13_17 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiMR13_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChMR13_17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do{
                    check++;

                    infiM10R13_17 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_InfiMR6_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChMR6_17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToFirst()){
                do{
                    infiM6_17 = cursor.getInt(0);
                    infiMR6_17 += cursor.getInt(1);
                }while(cursor.moveToNext());
            }
        }
    }
    private void pre_load_InfiMR6_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM InfiChMR6_17";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do{
                    check++;

                    infiM10R6_17 += cursor.getInt(1);
                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_mm1_10(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM MaxMin1_10";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    mm1_10 = cursor.getInt(0);
                    mm1_10R += cursor.getInt(1);
                    mm1_10T += cursor.getDouble(2);
                }while(cursor.moveToNext());
            }
        }
    }

    private void pre_load_mm1_10(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM MaxMin1_10";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    mm1_10R10 += cursor.getInt(1);
                    mm1_10T10 += cursor.getDouble(2);

                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_mm10_20(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM MaxMin10_20";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    mm10_20 = cursor.getInt(0);
                    mm10_20R += cursor.getInt(1);
                    mm10_20T += cursor.getDouble(2);
                }while(cursor.moveToNext());
            }
        }
    }

    private void pre_load_mm10_20(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM MaxMin10_20";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    mm10_20R10 += cursor.getInt(1);
                    mm10_20T10 += cursor.getDouble(2);

                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
    }

    private void load_mm20_30(){
        if(sqLiteDatabase != null) {
            String sqlQuery = "SELECT * FROM MaxMin20_30";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    mm20_30 = cursor.getInt(0);
                    mm20_30R += cursor.getInt(1);
                    mm20_30T += cursor.getDouble(2);
                }while(cursor.moveToNext());
            }
        }
    }

    private void pre_load_mm20_30(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM MaxMin20_30";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            int check = 0;
            if(cursor.moveToLast()){
                do {
                    check++;

                    mm20_30R10 += cursor.getInt(1);
                    mm20_30T10 += cursor.getDouble(2);

                    if(check == 10)
                        break;
                }while(cursor.moveToPrevious());
            }
        }
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
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
