package atomic0x90.github.io.numberpuzzlegame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;

import java.io.File;

public class CustomDialog extends Dialog{
    private Context mContext;

    public CustomDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }


    //DB
    SQLiteDatabase sqLiteDatabase;

    int adCheck;
    //Sound
    SoundPool soundPool;
    int soundID;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog1);

        DisplayMetrics dm = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int) (dm.widthPixels*0.9);
        lp.height = (int) (dm.heightPixels*0.3);

        getWindow().setAttributes(lp);

        sqLiteDatabase = init_database();
        updateAdCheck();

        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(getContext(),R.raw.click_sound,1);

        Button costomButton = (Button) findViewById(R.id.costomDialogButton);
        costomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(soundID,1f,1f,0,0,1f);

                CustomDialog.this.dismiss();
                ((Activity)mContext).finish();
                if(adCheck % 5 == 0){
                    Intent intent = new Intent(getContext(),SplashScreen.class);
                    getContext().startActivity(intent);
                }
            }
        });
    }

    //DB
    private SQLiteDatabase init_database() {

        SQLiteDatabase db = null ;
        // File file = getDatabasePath("contact.db") ;
        File file = new File(getContext().getFilesDir(), "contact.db") ;

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


    private void load_AdCheck(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM AdCheck";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()) {
                adCheck = cursor.getInt(0);
            }
        }
    }

    private void updateAdCheck(){
        if(sqLiteDatabase != null){
            load_AdCheck();
            adCheck += 1;
            String sqlUpdateCoin = "UPDATE AdCheck SET adCheck=" + adCheck;
            sqLiteDatabase.execSQL(sqlUpdateCoin);
        }
    }
}
