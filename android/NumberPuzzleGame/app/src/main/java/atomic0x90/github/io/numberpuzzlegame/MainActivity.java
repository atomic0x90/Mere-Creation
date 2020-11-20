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

        Button developerInformation = (Button) findViewById(R.id.developerButton);
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

            //Game Lock table 1-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock1_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock1_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock1_1" + "(Lock)" + "VALUES (" + 0 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 1-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock1_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock1_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock1_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 1-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock1_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock1_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock1_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 1-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock1_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock1_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock1_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 1-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock1_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock1_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock1_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 1-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock1_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock1_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock1_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 1-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock1_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock1_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock1_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 1-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock1_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock1_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock1_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 2-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock2_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock2_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock2_1" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 2-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock2_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock2_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock2_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 2-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock2_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock2_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock2_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 2-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock2_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock2_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock2_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 2-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock2_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock2_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock2_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 2-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock2_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock2_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock2_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 2-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock2_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock2_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock2_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 2-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock2_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock2_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock2_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 3-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock3_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock3_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock3_1" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 3-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock3_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock3_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock3_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 3-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock3_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock3_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock3_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 3-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock3_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock3_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock3_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 3-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock3_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock3_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock3_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 3-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock3_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock3_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock3_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 3-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock3_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock3_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock3_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 3-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock3_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock3_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock3_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 4-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_1" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 4-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock4_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_1" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 5-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock5_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock5_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock5_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 6-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock6_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock6_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock6_1" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 6-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock6_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock6_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock6_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 6-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock6_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock6_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock6_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 6-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock6_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock6_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock6_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 6-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock6_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock6_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock6_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 6-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock6_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock6_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock6_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 6-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock6_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock6_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock6_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 6-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock6_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock6_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock6_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 7-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock7_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock7_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock7_1" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 7-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock7_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock7_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock7_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 7-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock7_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock7_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock7_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 7-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock7_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock7_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock7_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 7-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock7_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock7_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock7_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 7-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock7_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock7_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock7_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 7-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock7_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock7_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock7_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 7-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock7_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock7_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock7_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }

            //Game Lock table 8-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock8_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock8_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock8_1" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 8-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock8_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock8_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock8_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 8-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock8_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock8_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock8_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 8-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock8_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock8_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock8_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 8-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock8_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock8_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock8_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 8-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock8_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock8_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock8_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 8-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock8_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock8_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock8_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 8-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock8_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock8_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock8_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 9-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock9_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock9_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock9_1" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 9-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock9_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock9_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock9_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 9-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock9_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock9_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock9_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 9-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock9_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock9_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock9_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 9-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock9_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock9_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock9_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 9-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock9_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock9_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock9_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 9-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock9_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock9_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock9_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 9-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock9_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock9_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock9_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 10-1
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock10_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock10_1";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock10_1" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 10-2
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock10_2 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock10_2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock10_2" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 10-3
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock10_3 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock10_3";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock10_3" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 10-4
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock10_4 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock10_4";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock10_4" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 10-5
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock10_5 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock10_5";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock10_5" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 10-6
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock10_6 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock10_6";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock10_6" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 10-7
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock10_7 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock10_7";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock10_7" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }


            //Game Lock table 10-8
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock10_8 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            sqlQuery = "SELECT * FROM GameLock10_8";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);

            try{
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock10_8" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
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
