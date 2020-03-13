package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.Locale;

public class UserStatistics extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;

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

    //FULL AD

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_statistics);

        //FULL AD


        //DB
        sqLiteDatabase =  init_database();

        //Plus (1)
        Button plusAnswer = (Button)findViewById(R.id.PlusAnswer);
        Button plusTime = (Button)findViewById(R.id.PlusTime);
        Button plus10Answer = (Button)findViewById(R.id.Plus10Answer);
        Button plus10Time = (Button)findViewById(R.id.Plus10Time);
        load_plus();

        if(plusIDX == -1){
            plusAnswer.setText("정보 없음");
            plusTime.setText("정보 없음");
            plus10Answer.setText("정보 없음");
            plus10Time.setText("정보 없음");
        }
        else if(plusIDX >= 1 && plusIDX <= 10){
            plusAnswer.setText(String.format(Locale.getDefault(),"%.2f %%",( plusResult/(plusIDX*10) )*100 ));
            plusTime.setText(String.format(Locale.getDefault(),"%.1f s",plusAVtime/plusIDX));
            plus10Answer.setText("정보 부족");
            plus10Time.setText("정보 부족");
        }
        else{
            pre_load_plus();
            plusAnswer.setText(String.format(Locale.getDefault(),"%.2f %%",( plusResult/(plusIDX*10) )*100 ));
            plusTime.setText(String.format(Locale.getDefault(),"%.1f s",plusAVtime/plusIDX));
            plus10Answer.setText(String.format(Locale.getDefault(),"%.2f %%",(plus10Result/(10*10) )*100 ));
            plus10Time.setText(String.format(Locale.getDefault(),"%.1f s",plus10AVtime/10));
        }

        //Minus(Sub) (2)
        Button subAnswer = (Button)findViewById(R.id.SubAnswer);
        Button subTime = (Button)findViewById(R.id.SubTime);
        Button sub10Answer = (Button)findViewById(R.id.Sub10Answer);
        Button sub10Time = (Button)findViewById(R.id.Sub10Time);
        load_sub();

        if(subIDX == -1){
            subAnswer.setText("정보 없음");
            subTime.setText("정보 없음");
            sub10Answer.setText("정보 없음");
            sub10Time.setText("정보 없음");
        }
        else if(subIDX >= 1 && subIDX <= 10){
            subAnswer.setText(String.format(Locale.getDefault(),"%.2f %%",( subResult/(subIDX*10) )*100 ));
            subTime.setText(String.format(Locale.getDefault(),"%.1f s",subAVtime/subIDX));
            sub10Answer.setText("정보 부족");
            sub10Time.setText("정보 부족");
        }
        else{
            pre_load_sub();
            subAnswer.setText(String.format(Locale.getDefault(),"%.2f %%",( subResult/(subIDX*10) )*100 ));
            subTime.setText(String.format(Locale.getDefault(),"%.1f s",subAVtime/subIDX));
            sub10Answer.setText(String.format(Locale.getDefault(),"%.2f %%",(sub10Result/(10*10) )*100 ));
            sub10Time.setText(String.format(Locale.getDefault(),"%.1f s",sub10AVtime/10));
        }

        //Multiplication (3)
        Button mulAnswer = (Button)findViewById(R.id.MulAnswer);
        Button mulTime = (Button)findViewById(R.id.MulTime);
        Button mul10Answer = (Button)findViewById(R.id.Mul10Answer);
        Button mul10Time = (Button)findViewById(R.id.Mul10Time);
        load_mul();

        if(mulIDX == -1){
            mulAnswer.setText("정보 없음");
            mulTime.setText("정보 없음");
            mul10Answer.setText("정보 없음");
            mul10Time.setText("정보 없음");
        }
        else if(mulIDX >= 1 && mulIDX <= 10){
            mulAnswer.setText(String.format(Locale.getDefault(),"%.2f %%",( mulResult/(mulIDX*10) )*100 ));
            mulTime.setText(String.format(Locale.getDefault(),"%.1f s",mulAVtime/mulIDX));
            mul10Answer.setText("정보 부족");
            mul10Time.setText("정보 부족");
        }
        else{
            pre_load_mul();
            mulAnswer.setText(String.format(Locale.getDefault(),"%.2f %%",( mulResult/(mulIDX*10) )*100 ));
            mulTime.setText(String.format(Locale.getDefault(),"%.1f s",mulAVtime/mulIDX));
            mul10Answer.setText(String.format(Locale.getDefault(),"%.2f %%",(mul10Result/(10*10) )*100 ));
            mul10Time.setText(String.format(Locale.getDefault(),"%.1f s",mul10AVtime/10));
        }

        //Divide (4)

        Button divAnswer = (Button)findViewById(R.id.DivAnswer);
        Button divTime = (Button)findViewById(R.id.DivTime);
        Button div10Answer = (Button)findViewById(R.id.Div10Answer);
        Button div10Time = (Button)findViewById(R.id.Div10Time);
        load_div();

        if(divIDX == -1){
            divAnswer.setText("정보 없음");
            divTime.setText("정보 없음");
            div10Answer.setText("정보 없음");
            div10Time.setText("정보 없음");
        }
        else if(divIDX >= 1 && divIDX <= 10){
            divAnswer.setText(String.format(Locale.getDefault(),"%.2f %%",( divResult/(divIDX*10) )*100 ));
            divTime.setText(String.format(Locale.getDefault(),"%.1f s",divAVtime/divIDX));
            div10Answer.setText("정보 부족");
            div10Time.setText("정보 부족");

        }
        else{
            pre_load_div();
            divAnswer.setText(String.format(Locale.getDefault(),"%.2f %%",( divResult/(divIDX*10) )*100 ));
            divTime.setText(String.format(Locale.getDefault(),"%.1f s",divAVtime/divIDX));
            div10Answer.setText(String.format(Locale.getDefault(),"%.2f %%",(div10Result/(10*10) )*100 ));
            div10Time.setText(String.format(Locale.getDefault(),"%.1f s",div10AVtime/10));
        }

        //Infi Plus

        Button infiP6B = (Button)findViewById(R.id.InfiP6Answer);
        Button infiP7B = (Button)findViewById(R.id.InfiP7Answer);
        Button infiP8B = (Button)findViewById(R.id.InfiP8Answer);
        Button infiP13B = (Button)findViewById(R.id.InfiP13Answer);
        Button infiP16B = (Button)findViewById(R.id.InfiP16Answer);
        Button infiP17B = (Button)findViewById(R.id.InfiP17Answer);
        Button infiP6_9B = (Button)findViewById(R.id.InfiP6_9Answer);
        Button infiP13_17B = (Button)findViewById(R.id.InfiP13_17Answer);
        Button infiP6_17B = (Button)findViewById(R.id.InfiP6_17Answer);

        load_InfiP6();
        load_InfiP7();
        load_InfiP8();
        load_InfiP13();
        load_InfiP16();
        load_InfiP17();
        load_InfiP6_9();
        load_InfiP13_17();
        load_InfiP6_17();

        if(infiP6 == -1)
            infiP6B.setText("정보 없음");
        else
            infiP6B.setText(String.format(Locale.getDefault(),"%.2f",infiPR6/infiP6));

        if(infiP7 == -1)
            infiP7B.setText("정보 없음");
        else
            infiP7B.setText(String.format(Locale.getDefault(),"%.2f",infiPR7/infiP7));

        if(infiP8 == -1)
            infiP8B.setText("정보 없음");
        else
            infiP8B.setText(String.format(Locale.getDefault(),"%.2f",infiPR8/infiP8));

        if(infiP13 == -1)
            infiP13B.setText("정보 없음");
        else
            infiP13B.setText(String.format(Locale.getDefault(),"%.2f",infiPR13/infiP13));

        if(infiP16 == -1)
            infiP16B.setText("정보 없음");
        else
            infiP16B.setText(String.format(Locale.getDefault(),"%.2f",infiPR16/infiP16));

        if(infiP17 == -1)
            infiP17B.setText("정보 없음");
        else
            infiP17B.setText(String.format(Locale.getDefault(),"%.2f",infiPR17/infiP17));

        if(infiP6_9 == -1)
            infiP6_9B.setText("정보 없음");
        else
            infiP6_9B.setText(String.format(Locale.getDefault(),"%.2f",infiPR6_9/infiP6_9));

        if(infiP13_17 == -1)
            infiP13_17B.setText("정보 없음");
        else
            infiP13_17B.setText(String.format(Locale.getDefault(),"%.2f",infiPR13_17/infiP13_17));

        if(infiP6_17 == -1)
            infiP6_17B.setText("정보 없음");
        else
            infiP6_17B.setText(String.format(Locale.getDefault(),"%.2f",infiPR6_17/infiP6_17));




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
