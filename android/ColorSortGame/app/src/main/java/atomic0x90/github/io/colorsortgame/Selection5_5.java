package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.widget.Button;

import java.io.File;

public class Selection5_5 extends AppCompatActivity {
    int standardSize_X, standardSize_Y;
    float density;

    SQLiteDatabase sqliteDB;

    int lock1 = -1;
    int lock2 = -1;
    int lock3 = -1;
    int lock4 = -1;
    int lock5 = -1;
    int lock6 = -1;
    int lock7 = -1;
    int lock8 = -1;
    int lock9 = -1;
    int lock10 = -1;
    int lock11 = -1;
    int lock12 = -1;
    int lock13 = -1;
    int lock14 = -1;
    int lock15 = -1;
    int lock16 = -1;
    int lock17 = -1;
    int lock18 = -1;
    int lock19 = -1;
    int lock20 = -1;
    int lock21 = -1;
    int lock22 = -1;
    int lock23 = -1;
    int lock24 = -1;
    int lock25 = -1;
    int lock26 = -1;
    int lock27 = -1;
    int lock28 = -1;
    int lock29 = -1;
    int lock30 = -1;
    int lock31 = -1;
    int lock32 = -1;
    int lock33 = -1;
    int lock34 = -1;
    int lock35 = -1;
    int lock36 = -1;
    int lock37 = -1;
    int lock38 = -1;
    int lock39 = -1;
    int lock40 = -1;
    int lock41 = -1;
    int lock42 = -1;
    int lock43 = -1;
    int lock44 = -1;
    int lock45 = -1;
    int lock46 = -1;
    int lock47 = -1;
    int lock48 = -1;
    int lock49 = -1;
    int lock50 = -1;
    public Point getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size;
    }

    public void getStandardSize() {
        Point ScreenSize = getScreenSize(this);
        density = getResources().getDisplayMetrics().density;

        standardSize_X = (int) (ScreenSize.x);
        standardSize_Y = (int) (ScreenSize.y);
    }

    @Override
    protected void onStart(){
        super.onStart();

        final Button button1 = (Button) findViewById(R.id.selection5_5_1);
        final Button button2 = (Button) findViewById(R.id.selection5_5_2);
        final Button button3 = (Button) findViewById(R.id.selection5_5_3);
        final Button button4 = (Button) findViewById(R.id.selection5_5_4);
        final Button button5 = (Button) findViewById(R.id.selection5_5_5);
        final Button button6 = (Button) findViewById(R.id.selection5_5_6);
        final Button button7 = (Button) findViewById(R.id.selection5_5_7);
        final Button button8 = (Button) findViewById(R.id.selection5_5_8);
        final Button button9 = (Button) findViewById(R.id.selection5_5_9);
        final Button button10 = (Button) findViewById(R.id.selection5_5_10);
        final Button button11 = (Button) findViewById(R.id.selection5_5_11);
        final Button button12 = (Button) findViewById(R.id.selection5_5_12);
        final Button button13 = (Button) findViewById(R.id.selection5_5_13);
        final Button button14 = (Button) findViewById(R.id.selection5_5_14);
        final Button button15 = (Button) findViewById(R.id.selection5_5_15);
        final Button button16 = (Button) findViewById(R.id.selection5_5_16);
        final Button button17 = (Button) findViewById(R.id.selection5_5_17);
        final Button button18 = (Button) findViewById(R.id.selection5_5_18);
        final Button button19 = (Button) findViewById(R.id.selection5_5_19);
        final Button button20 = (Button) findViewById(R.id.selection5_5_20);
        final Button button21 = (Button) findViewById(R.id.selection5_5_21);
        final Button button22 = (Button) findViewById(R.id.selection5_5_22);
        final Button button23 = (Button) findViewById(R.id.selection5_5_23);
        final Button button24 = (Button) findViewById(R.id.selection5_5_24);
        final Button button25 = (Button) findViewById(R.id.selection5_5_25);
        final Button button26 = (Button) findViewById(R.id.selection5_5_26);
        final Button button27 = (Button) findViewById(R.id.selection5_5_27);
        final Button button28 = (Button) findViewById(R.id.selection5_5_28);
        final Button button29 = (Button) findViewById(R.id.selection5_5_29);
        final Button button30 = (Button) findViewById(R.id.selection5_5_30);
        final Button button31 = (Button) findViewById(R.id.selection5_5_31);
        final Button button32 = (Button) findViewById(R.id.selection5_5_32);
        final Button button33 = (Button) findViewById(R.id.selection5_5_33);
        final Button button34 = (Button) findViewById(R.id.selection5_5_34);
        final Button button35 = (Button) findViewById(R.id.selection5_5_35);
        final Button button36 = (Button) findViewById(R.id.selection5_5_36);
        final Button button37 = (Button) findViewById(R.id.selection5_5_37);
        final Button button38 = (Button) findViewById(R.id.selection5_5_38);
        final Button button39 = (Button) findViewById(R.id.selection5_5_39);
        final Button button40 = (Button) findViewById(R.id.selection5_5_40);
        final Button button41 = (Button) findViewById(R.id.selection5_5_41);
        final Button button42 = (Button) findViewById(R.id.selection5_5_42);
        final Button button43 = (Button) findViewById(R.id.selection5_5_43);
        final Button button44 = (Button) findViewById(R.id.selection5_5_44);
        final Button button45 = (Button) findViewById(R.id.selection5_5_45);
        final Button button46 = (Button) findViewById(R.id.selection5_5_46);
        final Button button47 = (Button) findViewById(R.id.selection5_5_47);
        final Button button48 = (Button) findViewById(R.id.selection5_5_48);
        final Button button49 = (Button) findViewById(R.id.selection5_5_49);
        final Button button50 = (Button) findViewById(R.id.selection5_5_50);

        button1.setWidth(standardSize_X/4);
        button2.setWidth(standardSize_X/4);
        button3.setWidth(standardSize_X/4);
        button4.setWidth(standardSize_X/4);
        button5.setWidth(standardSize_X/4);
        button6.setWidth(standardSize_X/4);
        button7.setWidth(standardSize_X/4);
        button8.setWidth(standardSize_X/4);
        button9.setWidth(standardSize_X/4);
        button10.setWidth(standardSize_X/4);
        button11.setWidth(standardSize_X/4);
        button12.setWidth(standardSize_X/4);
        button13.setWidth(standardSize_X/4);
        button14.setWidth(standardSize_X/4);
        button15.setWidth(standardSize_X/4);
        button16.setWidth(standardSize_X/4);
        button17.setWidth(standardSize_X/4);
        button18.setWidth(standardSize_X/4);
        button19.setWidth(standardSize_X/4);
        button20.setWidth(standardSize_X/4);
        button21.setWidth(standardSize_X/4);
        button22.setWidth(standardSize_X/4);
        button23.setWidth(standardSize_X/4);
        button24.setWidth(standardSize_X/4);
        button25.setWidth(standardSize_X/4);
        button26.setWidth(standardSize_X/4);
        button27.setWidth(standardSize_X/4);
        button28.setWidth(standardSize_X/4);
        button29.setWidth(standardSize_X/4);
        button30.setWidth(standardSize_X/4);
        button31.setWidth(standardSize_X/4);
        button32.setWidth(standardSize_X/4);
        button33.setWidth(standardSize_X/4);
        button34.setWidth(standardSize_X/4);
        button35.setWidth(standardSize_X/4);
        button36.setWidth(standardSize_X/4);
        button37.setWidth(standardSize_X/4);
        button38.setWidth(standardSize_X/4);
        button39.setWidth(standardSize_X/4);
        button40.setWidth(standardSize_X/4);
        button41.setWidth(standardSize_X/4);
        button42.setWidth(standardSize_X/4);
        button43.setWidth(standardSize_X/4);
        button44.setWidth(standardSize_X/4);
        button45.setWidth(standardSize_X/4);
        button46.setWidth(standardSize_X/4);
        button47.setWidth(standardSize_X/4);
        button48.setWidth(standardSize_X/4);
        button49.setWidth(standardSize_X/4);
        button50.setWidth(standardSize_X/4);

        button1.setHeight(standardSize_X/4);
        button2.setHeight(standardSize_X/4);
        button3.setHeight(standardSize_X/4);
        button4.setHeight(standardSize_X/4);
        button5.setHeight(standardSize_X/4);
        button6.setHeight(standardSize_X/4);
        button7.setHeight(standardSize_X/4);
        button8.setHeight(standardSize_X/4);
        button9.setHeight(standardSize_X/4);
        button10.setHeight(standardSize_X/4);
        button11.setHeight(standardSize_X/4);
        button12.setHeight(standardSize_X/4);
        button13.setHeight(standardSize_X/4);
        button14.setHeight(standardSize_X/4);
        button15.setHeight(standardSize_X/4);
        button16.setHeight(standardSize_X/4);
        button17.setHeight(standardSize_X/4);
        button18.setHeight(standardSize_X/4);
        button19.setHeight(standardSize_X/4);
        button20.setHeight(standardSize_X/4);
        button21.setHeight(standardSize_X/4);
        button22.setHeight(standardSize_X/4);
        button23.setHeight(standardSize_X/4);
        button24.setHeight(standardSize_X/4);
        button25.setHeight(standardSize_X/4);
        button26.setHeight(standardSize_X/4);
        button27.setHeight(standardSize_X/4);
        button28.setHeight(standardSize_X/4);
        button29.setHeight(standardSize_X/4);
        button30.setHeight(standardSize_X/4);
        button31.setHeight(standardSize_X/4);
        button32.setHeight(standardSize_X/4);
        button33.setHeight(standardSize_X/4);
        button34.setHeight(standardSize_X/4);
        button35.setHeight(standardSize_X/4);
        button36.setHeight(standardSize_X/4);
        button37.setHeight(standardSize_X/4);
        button38.setHeight(standardSize_X/4);
        button39.setHeight(standardSize_X/4);
        button40.setHeight(standardSize_X/4);
        button41.setHeight(standardSize_X/4);
        button42.setHeight(standardSize_X/4);
        button43.setHeight(standardSize_X/4);
        button44.setHeight(standardSize_X/4);
        button45.setHeight(standardSize_X/4);
        button46.setHeight(standardSize_X/4);
        button47.setHeight(standardSize_X/4);
        button48.setHeight(standardSize_X/4);
        button49.setHeight(standardSize_X/4);
        button50.setHeight(standardSize_X/4);

        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
        button10.setEnabled(false);
        button11.setEnabled(false);
        button12.setEnabled(false);
        button13.setEnabled(false);
        button14.setEnabled(false);
        button15.setEnabled(false);
        button16.setEnabled(false);
        button17.setEnabled(false);
        button18.setEnabled(false);
        button19.setEnabled(false);
        button20.setEnabled(false);
        button21.setEnabled(false);
        button22.setEnabled(false);
        button23.setEnabled(false);
        button24.setEnabled(false);
        button25.setEnabled(false);
        button26.setEnabled(false);
        button27.setEnabled(false);
        button28.setEnabled(false);
        button29.setEnabled(false);
        button30.setEnabled(false);
        button31.setEnabled(false);
        button32.setEnabled(false);
        button33.setEnabled(false);
        button34.setEnabled(false);
        button35.setEnabled(false);
        button36.setEnabled(false);
        button37.setEnabled(false);
        button38.setEnabled(false);
        button39.setEnabled(false);
        button40.setEnabled(false);
        button41.setEnabled(false);
        button42.setEnabled(false);
        button43.setEnabled(false);
        button44.setEnabled(false);
        button45.setEnabled(false);
        button46.setEnabled(false);
        button47.setEnabled(false);
        button48.setEnabled(false);
        button49.setEnabled(false);
        button50.setEnabled(false);

        class startHandler implements Runnable{

            public void run(){
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button5.setEnabled(true);
                button6.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                button9.setEnabled(true);
                button10.setEnabled(true);
                button11.setEnabled(true);
                button12.setEnabled(true);
                button13.setEnabled(true);
                button14.setEnabled(true);
                button15.setEnabled(true);
                button16.setEnabled(true);
                button17.setEnabled(true);
                button18.setEnabled(true);
                button19.setEnabled(true);
                button20.setEnabled(true);
                button21.setEnabled(true);
                button22.setEnabled(true);
                button23.setEnabled(true);
                button24.setEnabled(true);
                button25.setEnabled(true);
                button26.setEnabled(true);
                button27.setEnabled(true);
                button28.setEnabled(true);
                button29.setEnabled(true);
                button30.setEnabled(true);
                button31.setEnabled(true);
                button32.setEnabled(true);
                button33.setEnabled(true);
                button34.setEnabled(true);
                button35.setEnabled(true);
                button36.setEnabled(true);
                button37.setEnabled(true);
                button38.setEnabled(true);
                button39.setEnabled(true);
                button40.setEnabled(true);
                button41.setEnabled(true);
                button42.setEnabled(true);
                button43.setEnabled(true);
                button44.setEnabled(true);
                button45.setEnabled(true);
                button46.setEnabled(true);
                button47.setEnabled(true);
                button48.setEnabled(true);
                button49.setEnabled(true);
                button50.setEnabled(true);
            }
        }

        Handler h = new Handler();
        h.postDelayed(new startHandler(),250);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection5_5);

        getStandardSize();

        sqliteDB = init_database();
        loadGameLock1();
        loadGameLock2();
        loadGameLock3();
        loadGameLock4();
        loadGameLock5();
        loadGameLock6();
        loadGameLock7();
        loadGameLock8();
        loadGameLock9();
        loadGameLock10();
        loadGameLock11();
        loadGameLock12();
        loadGameLock13();
        loadGameLock14();
        loadGameLock15();
        loadGameLock16();
        loadGameLock17();
        loadGameLock18();
        loadGameLock19();
        loadGameLock20();
        loadGameLock21();
        loadGameLock22();
        loadGameLock23();
        loadGameLock24();
        loadGameLock25();
        loadGameLock26();
        loadGameLock27();
        loadGameLock28();
        loadGameLock29();
        loadGameLock30();
        loadGameLock31();
        loadGameLock32();
        loadGameLock33();
        loadGameLock34();
        loadGameLock35();
        loadGameLock36();
        loadGameLock37();
        loadGameLock38();
        loadGameLock39();
        loadGameLock40();
        loadGameLock41();
        loadGameLock42();
        loadGameLock43();
        loadGameLock44();
        loadGameLock45();
        loadGameLock46();
        loadGameLock47();
        loadGameLock48();
        loadGameLock49();
        loadGameLock50();
    }

    @Override
    protected void onUserLeaveHint(){
        super.onUserLeaveHint();
        finish();
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
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
    private void loadGameLock1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock9(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_9";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock10(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_10";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock11(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_11";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock11 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock12(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_12";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock12 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock13(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_13";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock13 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock14(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_14";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock14 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock15(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_15";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock15 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock16(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_16";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock16 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock17(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_17";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock17 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock18(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_18";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock18 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock19(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_19";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock19 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock20(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_20";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock20 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock21(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_21";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock21 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock22(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_22";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock22 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock23(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_23";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock23 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock24(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_24";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock24 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock25(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_25";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock25 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock26(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_26";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock26 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock27(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_27";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock27 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock28(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_28";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock28 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock29(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_29";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock29 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock30(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_30";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock30 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock31(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_31";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock31 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock32(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_32";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock32 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock33(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_33";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock33 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock34(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_34";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock34 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock35(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_35";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock35 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock36(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_36";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock36 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock37(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_37";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock37 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock38(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_38";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock38 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock39(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_39";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock39 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock40(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_40";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock40 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock41(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_41";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock41 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock42(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_42";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock42 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock43(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_43";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock43 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock44(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_44";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock44 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock45(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_45";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock45 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock46(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_46";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock46 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock47(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_47";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock47 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock48(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_48";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock48 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock49(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_49";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock49 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock50(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5_50";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock50 = cursor.getInt(0);
            }
        }
    }

}
