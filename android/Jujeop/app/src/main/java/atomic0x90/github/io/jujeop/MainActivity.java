package atomic0x90.github.io.jujeop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    //DB
    SQLiteDatabase sqliteDB;

    //Double click check
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DB
        sqliteDB = init_database() ;
        init_tables();

        Button menuButton = (Button)findViewById(R.id.jjgoButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                Intent intent = new Intent(MainActivity.this,JJLvMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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

    //lock : 1, unlock : 0
    private void init_tables() {

        if (sqliteDB != null) {
            //Ads table
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS Ads (" +
                    "state " + "INTEGER NOT NULL," +
                    "date_time " + "TIMESTAMP NOT NULL default (datetime('now','localtime')" + "));";

            System.out.println(sqlCreateTbl);

            sqliteDB.execSQL(sqlCreateTbl);

            String sqlQuery = "SELECT * FROM Ads";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery, null);

            try {
                //Ads 값이 없는 경우
                if (!cursor.moveToNext()) {
                    String sqlInsert = "INSERT INTO Ads " + "(state)" + "VALUES (" + 0 + ");";
                    System.out.println("TEST Insert : " + sqlInsert);
                    sqliteDB.execSQL(sqlInsert);
                }
            } catch (Exception e) {
                System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFF " + e);
            }

            //jj2 table
            sqlCreateTbl = "CREATE TABLE IF NOT EXISTS jj2 (" +
                    "lock " + "INTEGER NOT NULL" + ");";

            sqliteDB.execSQL(sqlCreateTbl);
            System.out.println(sqlCreateTbl);

            sqlQuery = "SELECT * FROM jj2";
            cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery, null);

            try {
                //lock 값이 없는 경우
                if (!cursor.moveToNext()) {
                    String sqlInsert = "INSERT INTO jj2 " + "(lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            } catch (Exception e) {
                System.out.println("INSERT ERROR " + e);
            }
        }
    }
}
