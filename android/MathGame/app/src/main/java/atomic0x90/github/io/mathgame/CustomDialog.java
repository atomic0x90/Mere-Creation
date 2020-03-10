package atomic0x90.github.io.mathgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.io.File;
import java.util.Locale;

public class CustomDialog extends AppCompatActivity {

    int saveCoin,rewardCoin,insertResult;
    double insertAVtime;

    //Sound
    SoundPool soundPool;
    int soundID;

    //DB
    SQLiteDatabase sqLiteDatabase;

    //Double click check
    private long mLastClickTime;

    //Reward AD
    private RewardedAd rewardedAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound01,1);

        //Reward AD

        rewardedAd = new RewardedAd(this,"ca-app-pub-3940256099942544/5224354917");
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
                System.out.println("AD successfully");
            }

            @Override
            public void onRewardedAdFailedToLoad(int errorCode) {
                // Ad failed to load.
                System.out.println("AD failed");
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);

        //
        Intent intent = getIntent();

        final String DataType = intent.getStringExtra("Result_type");
        double avtime = intent.getDoubleExtra("Average_time",0);
        final int answer = intent.getIntExtra("Answer_num",0);

        insertResult = answer;
        insertAVtime = avtime;

        sqLiteDatabase = init_database();

        TextView titleText = (TextView)findViewById(R.id.DialogTitle);
        TextView answerText = (TextView)findViewById(R.id.answerText);
        TextView avtimeText = (TextView)findViewById(R.id.AVtimeText);
        TextView coinText = (TextView)findViewById(R.id.CoinText);

        if(DataType.equals("Add") || DataType.equals("Sub") || DataType.equals("Divide") || DataType.equals("Multipl")) {
            if (answer == 10) {
                if (avtime <= 2.0)
                    titleText.setText("결과 : SSS\n우와~ 최고예요!");
                else if (avtime <= 3.0)
                    titleText.setText("결과 : SS\n엄청 대단해요!");
                else if (avtime <= 4.0)
                    titleText.setText("결과 : S\n대단해요!");
                else
                    titleText.setText("결과 : A+\n굉장해요!");
            } else if (answer < 10 && answer >= 7) {
                if (avtime <= 5.0)
                    titleText.setText("결과 : A\n잘했어요!");
                else
                    titleText.setText("결과 : B+\n잘했어요! 더 침착하게 해볼까요?");
            } else {
                if(avtime >= 1.0)
                    titleText.setText("결과 : B\n괜찮아요 계속 연습하면 잘할 거예요!");
                else
                    titleText.setText("결과 : C\n천천히 풀어봐요!");
            }
        }
        else{

        }


        if(DataType.equals("Add") || DataType.equals("Sub") || DataType.equals("Divide") || DataType.equals("Multipl"))
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
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                rewardCoin = answer*10;
                UpdateCoin();
                if(DataType.equals("Add"))
                    insertChAdd();
                else if(DataType.equals("Sub"))
                    insertChSub();
                else if(DataType.equals("Multipl"))
                    insertChMul();
                else if(DataType.equals("Divide"))
                    insertChDiv();

                Toast.makeText(getApplicationContext(),"보상 획득",Toast.LENGTH_LONG).show();

                soundPool.play(soundID,1f,1f,0,0,1f);

                Intent intent = new Intent(CustomDialog.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        //rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
        AddRewardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(soundID,1f,1f,0,0,1f);
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (rewardedAd.isLoaded()) {
                    Activity activityContext = CustomDialog.this;
                    RewardedAdCallback adCallback = new RewardedAdCallback() {
                        @Override
                        public void onUserEarnedReward(@NonNull com.google.android.gms.ads.rewarded.RewardItem rewardItem) {
                            // User earned reward.
                            rewardCoin = answer*10*2;
                            UpdateCoin();
                            if(DataType.equals("Add"))
                                insertChAdd();
                            else if(DataType.equals("Sub"))
                                insertChSub();
                            else if(DataType.equals("Multipl"))
                                insertChMul();
                            else if(DataType.equals("Divide"))
                                insertChDiv();

                            Toast.makeText(getApplicationContext(),"보상X2 획득",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(CustomDialog.this,MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                            startActivity(intent);
                        }

                        public void onRewardedAdFailedToShow(int errcode){
                            // Ad failed to display
                            rewardCoin = answer*10;
                            UpdateCoin();
                            if(DataType.equals("Add"))
                                insertChAdd();
                            else if(DataType.equals("Sub"))
                                insertChSub();
                            else if(DataType.equals("Multipl"))
                                insertChMul();
                            else if(DataType.equals("Divide"))
                                insertChDiv();

                            Toast.makeText(getApplicationContext(),"보상 획득, 영상이 준비되지 않음. 나중에 다시 시도하세요.",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(CustomDialog.this,MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }

                        public void onRewardedAdOpened(){
                            // Ad opened.
                        }

                        public void onRewardedAdClosed(){
                            // Ad closed.
                        }
                    };
                    rewardedAd.show(activityContext, adCallback);

                } else {
                    rewardCoin = answer*10;
                    UpdateCoin();
                    if(DataType.equals("Add"))
                        insertChAdd();
                    else if(DataType.equals("Sub"))
                        insertChSub();
                    else if(DataType.equals("Multipl"))
                        insertChMul();
                    else if(DataType.equals("Divide"))
                        insertChDiv();

                    Toast.makeText(getApplicationContext(),"보상 획득, 영상이 준비되지 않음. 나중에 다시 시도하세요.",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CustomDialog.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    Log.d("TAG", "The rewarded ad wasn't loaded yet.");
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

    private void insertChAdd(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO ChAdd" + "(result,AVtime)" + "VALUES (" + insertResult +"," + insertAVtime +");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertChSub(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO ChSub" + "(result,AVtime)" + "VALUES (" + insertResult + "," + insertAVtime +");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertChMul(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO ChMul" + "(result,AVtime)" + "VALUES (" + insertResult + "," + insertAVtime +");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertChDiv(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO ChDiv" + "(result,AVtime)" + "VALUES (" + insertResult + "," + insertAVtime +");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    //AD
    public RewardedAd createAndLoadRewardedAd() {
        RewardedAd rewardedAd = new RewardedAd(this, "");
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(int errorCode) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
        return rewardedAd;
    }

    public void onRewardedAdClosed() {
        this.rewardedAd = createAndLoadRewardedAd();
    }

    //Touch
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
