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
import android.widget.Toast;

import java.io.File;

public class JJLvMenu extends AppCompatActivity {

    Toast toast;

    //DB
    SQLiteDatabase sqLiteDatabase;
    int lock2 = 0;

    //Double click check
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_j_lv_menu);

        //DB
        sqLiteDatabase = init_database();
        load_lock2();

        Button lv1Button = (Button)findViewById(R.id.jjLV1Button);
        lv1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                Intent intent = new Intent(JJLvMenu.this, JJGame.class);
                intent.putExtra("LV",1);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        Button lv2Button = (Button)findViewById(R.id.jjLV2Button);
        lv2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                System.out.println("TTTTTTTTTTTTTTTTTTTTTTTT" + lock2);
                if(lock2 == 1){
                    toast = Toast.makeText(getApplicationContext(),"이전 단계를 완료하세요",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Intent intent = new Intent(JJLvMenu.this, JJGame.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });
    }

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

    private void load_lock2(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM jj2";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToFirst()){
                lock2 = cursor.getInt(0);
            }

            System.out.println("AAAAAAAAAAAAAAAAAAAA" + lock2);
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
