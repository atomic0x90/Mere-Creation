package atomic0x90.github.io.numberpuzzlegame;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.IBinder;
import android.text.util.Linkify;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class DeveloperInformation extends AppCompatActivity {

    private boolean mIsBound;
    private BGMService.ReturnBinder mBGMService;

    SQLiteDatabase sqliteDB ;

    int loadBGMi = 0;

    private final ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try{
                mBGMService = ((BGMService.ReturnBinder)service).getService();
                Toast.makeText(DeveloperInformation.this,"service connected De",Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(DeveloperInformation.this,"IBinder error De",Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(DeveloperInformation.this,"service disconnected De",Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_information);

        sqliteDB = init_database();
        loadBGM();
        if(loadBGMi == 0)
            mIsBound = bindService(new Intent(DeveloperInformation.this,BGMService.class),mConnection, Context.BIND_AUTO_CREATE);

        TextView emailText = (TextView)findViewById(R.id.DeveloperEmailadd);
        Linkify.addLinks(emailText,Linkify.EMAIL_ADDRESSES);
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

    @Override
    protected void onUserLeaveHint(){
        //홈버튼
        super.onUserLeaveHint();

        System.out.println("홈 버튼 de");
        Toast.makeText(this,"홈버튼 De "+mIsBound,Toast.LENGTH_SHORT).show();
        if(mIsBound){
            //onUnbind(mIsBound);
        }
    }
    @Override
    public void onPause(){
        super.onPause();
        System.out.println("de pause");

    }


    @Override
    public void onResume(){
        //
        super.onResume();
        System.out.println("onResume ");

        Toast.makeText(this,"resume De",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        Toast.makeText(this,"디스트로이 De",Toast.LENGTH_SHORT).show();
    }


}
