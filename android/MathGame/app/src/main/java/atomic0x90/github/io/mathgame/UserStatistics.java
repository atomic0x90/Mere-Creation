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
import java.sql.BatchUpdateException;
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
