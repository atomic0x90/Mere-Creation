package atomic0x90.github.io.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqliteDB ;

    SQLiteDatabase sqLiteDatabase;
    int loadBGM = 0;

    private static MediaPlayer bgm;
    //private int bgmSet = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DB
        sqliteDB = init_database() ;
        init_tables();

        loadBGM();
        bgm = MediaPlayer.create(this,R.raw.bgm);

        System.out.println(loadBGM);

        if(loadBGM == 1) {
            bgm.setLooping(true);
            bgm.start();
        }
        else {

            System.out.println(loadBGM + " " + bgm.isPlaying());
            if(bgm.isPlaying()){
                bgm.pause();
                bgm.seekTo(0);
            }
        }

        System.out.println(loadBGM);
        Button sound = (Button) findViewById(R.id.button);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loadBGM == 0) {
                    updateBGMstart();
                    try {
                        bgm.start();
                    }catch (Exception e){
                        System.out.println("aaaaaaaa "+e);
                    };
                    System.out.println(loadBGM + "a");
                }
                else {
                    updateBGMstop();
                    bgm.pause();
                    bgm.seekTo(0);
                    System.out.println(loadBGM + "b");
                }
            }
        });
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
    private void init_tables() {

        if (sqliteDB != null) {
            //Sound table   1이면 노래 0이면 끔
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS BGM (" +
                    "BGM "           + "INTEGER NOT NULL," +
                    "date_time "         + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));" ;

            System.out.println(sqlCreateTbl) ;

            sqliteDB.execSQL(sqlCreateTbl) ;

            String sqlQuery = "SELECT * FROM BGM";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //bgm 값이 없는 경우
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO BGM " + "(BGM)" + "VALUES (" + 1 +");";
                    System.out.println("TEST Insert : " + sqlInsert);
                    sqliteDB.execSQL(sqlInsert);
                }}catch (Exception e){
                System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFF "+e);
            }

            //Ads free table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS AdsFree (" +
                    "AdsState " + "INTEGER PRIMARY KEY," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')));";
            System.out.println(sqlCreateTbl);

            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM AdsFree";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                //lock 값이 없는 경우     //0이면 광고 있음 1이면 광고 없음
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO AdsFree " + "(AdsState)" + "VALUES (" + 0 +");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }
            catch (Exception e){
                System.out.println("AdsFree table : "+e);
            }

        }
    }

    private void loadBGM(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM BGM";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                loadBGM = cursor.getInt(0);
            }
        }
    }

    private void updateBGMstart(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE BGM SET BGM = " + 1;
            sqLiteDatabase.execSQL(sqlQuery);
            loadBGM = 1;
        }
    }

    private void updateBGMstop(){
        if(sqLiteDatabase != null){
            String sqlQuery = "UPDATE BGM SET BGM = " + 0;
            sqLiteDatabase.execSQL(sqlQuery);
            loadBGM = 0;
        }
    }

    @Override
    protected void onUserLeaveHint(){
        //홈버튼
        bgm.pause();
        super.onUserLeaveHint();
    }

    @Override
    public void onResume(){
        //
        bgm.start();
        super.onResume();
    }

    @Override
    public void onDestroy(){
        bgm.stop();
        super.onDestroy();
    }


}
