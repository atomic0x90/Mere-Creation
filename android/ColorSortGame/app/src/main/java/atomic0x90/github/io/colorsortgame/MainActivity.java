package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqliteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Game_X.class);
                startActivity(intent);
            }
        });

        Button button1 = (Button) findViewById(R.id.button17);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Game_5_5.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.GameStartButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StepSelection.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
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
        if(sqliteDB != null){
            //Game Lock table 4-4-1
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS GameLock4_4_1 (" +
                    "Lock " + "INTEGER NOT NULL)";
            sqliteDB.execSQL(sqlCreateTbl);

            String sqlQuery = "SELECT * FROM GameLock4_4_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            try {
                if(!cursor.moveToNext()){
                    String sqlInsert = "INSERT INTO GameLock4_4_1" + "(Lock)" + "VALUES (" + 1 + ");";
                    sqliteDB.execSQL(sqlInsert);
                }
            }catch (Exception e){
                System.out.println("Error GameLock tbl : " + e);
            }
        }
    }
}
