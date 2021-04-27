package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
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

    @Override
    protected void onStart(){
        super.onStart();

        final Button button1 = (Button) findViewById(R.id.selection5_5_1);
        button1.setEnabled(false);
        class startHandler implements Runnable{

            public void run(){
                button1.setEnabled(true);
            }
        }

        Handler h = new Handler();
        h.postDelayed(new startHandler(),250);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection5_5);


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
