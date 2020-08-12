package atomic0x90.github.io.numberpuzzlegame;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeveloperInformation extends AppCompatActivity {

    SQLiteDatabase sqliteDB ;

    SQLiteDatabase sqLiteDatabase;
    int loadBGM = 0;

    //
    private boolean mIsBound;
    private BGMService.ReturnBinder mBGMService;

    private final ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try{
                mBGMService = ((BGMService.ReturnBinder)service).getService();
                Toast.makeText(DeveloperInformation.this,"service connected",Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(DeveloperInformation.this,"IBinder error",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(DeveloperInformation.this,"service disconnected",Toast.LENGTH_LONG).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_information);
        loadBGM();
        if(loadBGM == 1)
            mIsBound = bindService(new Intent(DeveloperInformation.this,BGMService.class),mConnection, Context.BIND_AUTO_CREATE);

    }


    private void loadBGM(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM BGM";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);
            System.out.println("BGM cursor "+cursor.getInt(0)+" "+loadBGM);
            if(cursor.moveToNext()){
                loadBGM = cursor.getInt(0);


            }
        }
    }

}
