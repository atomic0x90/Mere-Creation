package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.Locale;

public class CustomDialog extends AppCompatActivity {

    int saveCoin,rewardCoin;

    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        Intent intent = getIntent();

        String DataType = intent.getStringExtra("Result_type");
        double avtime = intent.getDoubleExtra("Average_time",0);
        final int answer = intent.getIntExtra("Answer_num",0);

        sqLiteDatabase = init_database();

        TextView answerText = (TextView)findViewById(R.id.answerText);
        TextView avtimeText = (TextView)findViewById(R.id.AVtimeText);
        TextView coinText = (TextView)findViewById(R.id.CoinText);


        if(DataType.equals("Add") || DataType.equals("Minus") || DataType.equals("Divide") || DataType.equals("Multiple"))
            answerText.setText(String.format(Locale.getDefault(),"%d / 10",answer));
        else
            answerText.setText(String.format(Locale.getDefault(),"%d / 5",answer));
        avtimeText.setText(String.format(Locale.getDefault(),"%.1f s",avtime));
        coinText.setText(String.format(Locale.getDefault()," %d",answer*10));


        Button RewardButton = (Button)findViewById(R.id.RewardButton);
        Button AddRewardButton = (Button)findViewById(R.id.AddRewardButton);

        RewardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rewardCoin = answer*10;
                UpdateCoin();
                Intent intent = new Intent(CustomDialog.this, MainActivity.class);
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

    private void UpdateCoin(){
        if(sqLiteDatabase != null){
            load_coin();
            System.out.println(rewardCoin+" "+saveCoin);
            saveCoin += rewardCoin;
            String sqlUpdateCoin = "UPDATE Coin SET coin=" + saveCoin;
            sqLiteDatabase.execSQL(sqlUpdateCoin);
        }
    }

    private void load_coin(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM Coin";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()) {
                saveCoin = cursor.getInt(0);
            }
        }
    }

    //화면 밖 touch 막음
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_OUTSIDE)
            return false;
        return true;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
