package atomic0x90.github.io.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import static android.content.Intent.FLAG_ACTIVITY_NO_USER_ACTION;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqliteDB ;

    int loadBGMi = 0;

    private static MediaPlayer bgm;
    //private int bgmSet = 0;

    //

    ImageView imageView = null;
    //
    private boolean mIsBound;
    private BGMService.ReturnBinder mBGMService;

    private final ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try{
            mBGMService = ((BGMService.ReturnBinder)service).getService();
            Toast.makeText(MainActivity.this,"service connected",Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(MainActivity.this,"IBinder error",Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(MainActivity.this,"service disconnected",Toast.LENGTH_SHORT).show();
        }
    };

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //DB
        sqliteDB = init_database() ;
        init_tables();

        loadBGM();

        if(loadBGMi == 0)
            mIsBound = bindService(new Intent(MainActivity.this,BGMService.class),mConnection, Context.BIND_AUTO_CREATE);


        ImageButton sound = (ImageButton) findViewById(R.id.soundSetButton);
        imageView = (ImageView) findViewById(R.id.soundSetButton);

        if(loadBGMi == 0){
            //on
            imageView.setImageResource(R.drawable.sound_on);
        }
        else{
            //off
            imageView.setImageResource(R.drawable.sound_off);
        }

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("onclick 0 " + loadBGMi);
                if(loadBGMi == 0){
                    System.out.println("onclick 1 "+loadBGMi);
                    updateBGMstart();
                    loadBGM();
                    unbindService(mConnection);
                    mIsBound = false;

                    imageView.setImageResource(R.drawable.sound_off);
                }
                else {
                    System.out.println("onclick 2 " + loadBGMi);
                    updateBGMstop();
                    loadBGM();
                    loadBGMi = 0;
                    mIsBound = bindService(new Intent(MainActivity.this, BGMService.class), mConnection, Context.BIND_AUTO_CREATE);

                    imageView.setImageResource(R.drawable.sound_on);
                }
            }
        });

        Button developerInformation = (Button) findViewById(R.id.button2);
        developerInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeveloperInformation.class);
                intent.addFlags(FLAG_ACTIVITY_NO_USER_ACTION);
                startActivity(intent);
            }
        });

        Button gameStartButton = (Button) findViewById(R.id.GameStartButton);
        gameStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StepSelection.class);
                startActivity(intent);
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
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM BGM";
            Cursor cursor = null;

            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor != null && cursor.moveToNext()){
                System.out.println("BGM cursor "+cursor.getInt(0)+" "+loadBGMi);

                loadBGMi = cursor.getInt(0);
            }

            System.out.println("load BGM1 " + loadBGMi);
        }
        System.out.println("load BGM2 " + loadBGMi);
    }

    private void updateBGMstart(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE BGM SET BGM = " + 1;
            sqliteDB.execSQL(sqlQuery);
            loadBGMi = 1;

            System.out.println("update BGM start " + loadBGMi);
            Toast.makeText(this,"update BGM start",Toast.LENGTH_SHORT).show();
        }
    }

    private void updateBGMstop(){
        if(sqliteDB != null){
            String sqlQuery = "UPDATE BGM SET BGM = " + 0;
            sqliteDB.execSQL(sqlQuery);
            loadBGMi = 0;

            System.out.println("update BGM stop " + loadBGMi);
            Toast.makeText(this,"update BGM stop",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onUserLeaveHint(){
        //홈버튼
        super.onUserLeaveHint();
        if(mIsBound){
            unbindService(mConnection);
            mIsBound = false;
        }
        Toast.makeText(this,"홈버튼",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onResume(){
        //
        super.onResume();
        System.out.println("onResume "+loadBGMi);
        if(loadBGMi == 0)
            mIsBound = bindService(new Intent(MainActivity.this,BGMService.class),mConnection, Context.BIND_AUTO_CREATE);

        Toast.makeText(this,"resume",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(mIsBound){
            unbindService(mConnection);
            mIsBound = false;

        }

        Toast.makeText(this,"디스트로이",Toast.LENGTH_SHORT).show();
    }


}
