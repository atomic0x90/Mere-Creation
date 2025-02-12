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
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.io.File;
import java.util.Locale;

public class CustomDialog extends AppCompatActivity {

    int adCheck;
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
    //AD
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound01,1);

        //AD
        //mAdView = findViewById(R.id.adView11);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        //Reward AD

        rewardedAd = new RewardedAd(this,getResources().getString(R.string.TEST_AD_REWARD_ID));

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
        updateAdCheck();

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
                    titleText.setText("결과 : B+\n잘했어요!\n더 침착하게 해볼까요?");
            } else {
                if(avtime >= 1.0)
                    titleText.setText("결과 : B\n괜찮아요 계속 연습하면\n잘할 거예요!");
                else
                    titleText.setText("결과 : C\n천천히 풀어봐요!");
            }
        }
        else if(DataType.equals("MaxMin1_10") || DataType.equals("MaxMin10_20") || DataType.equals("MaxMin20_30")){
            if(answer == 5){
                if(avtime <= 15.0)
                    titleText.setText("결과 : SSS\n우와~ 최고예요!");
                else if (avtime <= 25.0)
                    titleText.setText("결과 : SS\n엄청 대단해요!");
                else if (avtime <= 35.0)
                    titleText.setText("결과 : S\n대단해요!");
                else
                    titleText.setText("결과 : A+\n굉장해요!");
            }
            else if(answer >= 3){
                if (avtime <= 35.0)
                    titleText.setText("결과 : A\n잘했어요!");
                else
                    titleText.setText("결과 : B+\n잘했어요!\n더 침착하게 해볼까요?");
            }
            else{
                if(avtime >= 1.0)
                    titleText.setText("결과 : B\n괜찮아요 계속 연습하면\n잘할 거예요!");
                else
                    titleText.setText("결과 : C\n천천히 풀어봐요!");
            }
        }
        else{
            if(answer <= 5)
                titleText.setText("결과 : C\n천천히 풀어봐요!");
            else if(answer <= 10)
                titleText.setText("결과 : B\n잘했어요!\n더 침착하게 해볼까요?");
            else if(answer <= 20)
                titleText.setText("결과 : A\n잘했어요!!");
            else
                titleText.setText("결과 : S\n엄청 대단해요!!");
        }


        if(DataType.equals("Add") || DataType.equals("Sub") || DataType.equals("Divide") || DataType.equals("Multipl")) {
            answerText.setText(String.format(Locale.getDefault(), "%d / 10", answer));
            avtimeText.setText(String.format(Locale.getDefault(),"%.1f s",avtime));
        }
        else if(DataType.equals("MaxMin1_10") || DataType.equals("MaxMin10_20") || DataType.equals("MaxMin20_30")){
            answerText.setText(String.format(Locale.getDefault(),"%d / 5",answer));
            avtimeText.setText(String.format(Locale.getDefault(),"%.1f s",avtime));
        }
        else {
            answerText.setText(String.format(Locale.getDefault(), "%d", answer));
            avtimeText.setText(String.format(Locale.getDefault(),""));
            TextView Textavtime = (TextView)findViewById(R.id.AVtime);
            Textavtime.setText(String.format(Locale.getDefault(),""));
        }
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
                else if(DataType.equals("InfiP6"))
                    insertInfiChP6();
                else if(DataType.equals("InfiP7"))
                    insertInfiChP7();
                else if(DataType.equals("InfiP8"))
                    insertInfiChP8();
                else if(DataType.equals("InfiP13"))
                    insertInfiChP13();
                else if(DataType.equals("InfiP16"))
                    insertInfiChP16();
                else if(DataType.equals("InfiP17"))
                    insertInfiChP17();
                else if(DataType.equals("InfiP6_9"))
                    insertInfiChP6_9();
                else if(DataType.equals("InfiP13_17"))
                    insertInfiChP13_17();
                else if(DataType.equals("InfiP6_17"))
                    insertInfiChP6_17();
                else if(DataType.equals("InfiM6"))
                    insertInfiChM6();
                else if(DataType.equals("InfiM7"))
                    insertInfiChM7();
                else if(DataType.equals("InfiM8"))
                    insertInfiChM8();
                else if(DataType.equals("InfiM13"))
                    insertInfiChM13();
                else if(DataType.equals("InfiM16"))
                    insertInfiChM16();
                else if(DataType.equals("InfiM17"))
                    insertInfiChM17();
                else if(DataType.equals("InfiM6_9"))
                    insertInfiChM6_9();
                else if(DataType.equals("InfiM13_17"))
                    insertInfiChM13_17();
                else if(DataType.equals("InfiM6_17"))
                    insertInfiChM6_17();
                else if(DataType.equals("MaxMin1_10"))
                    insertMaxMin1_10();
                else if(DataType.equals("MaxMin10_20"))
                    insertMaxMin10_20();
                else if(DataType.equals("MaxMin20_30"))
                    insertMaxMin20_30();

                Toast.makeText(getApplicationContext(),"보상 획득",Toast.LENGTH_SHORT).show();

                soundPool.play(soundID,1f,1f,0,0,1f);

                if(adCheck % 5 == 0) {
                    Intent intent = new Intent(CustomDialog.this, SplashScreen.class);
                    intent.putExtra("Text", "CustomDialog");
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(CustomDialog.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
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
                            else if(DataType.equals("InfiP6"))
                                insertInfiChP6();
                            else if(DataType.equals("InfiP7"))
                                insertInfiChP7();
                            else if(DataType.equals("InfiP8"))
                                insertInfiChP8();
                            else if(DataType.equals("InfiP13"))
                                insertInfiChP13();
                            else if(DataType.equals("InfiP16"))
                                insertInfiChP16();
                            else if(DataType.equals("InfiP17"))
                                insertInfiChP17();
                            else if(DataType.equals("InfiP6_9"))
                                insertInfiChP6_9();
                            else if(DataType.equals("InfiP13_17"))
                                insertInfiChP13_17();
                            else if(DataType.equals("InfiP6_17"))
                                insertInfiChP6_17();
                            else if(DataType.equals("InfiM6"))
                                insertInfiChM6();
                            else if(DataType.equals("InfiM7"))
                                insertInfiChM7();
                            else if(DataType.equals("InfiM8"))
                                insertInfiChM8();
                            else if(DataType.equals("InfiM13"))
                                insertInfiChM13();
                            else if(DataType.equals("InfiM16"))
                                insertInfiChM16();
                            else if(DataType.equals("InfiM17"))
                                insertInfiChM17();
                            else if(DataType.equals("InfiM6_9"))
                                insertInfiChM6_9();
                            else if(DataType.equals("InfiM13_17"))
                                insertInfiChM13_17();
                            else if(DataType.equals("InfiM6_17"))
                                insertInfiChM6_17();
                            else if(DataType.equals("MaxMin1_10"))
                                insertMaxMin1_10();
                            else if(DataType.equals("MaxMin10_20"))
                                insertMaxMin10_20();
                            else if(DataType.equals("MaxMin20_30"))
                                insertMaxMin20_30();

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
                            else if(DataType.equals("InfiP6"))
                                insertInfiChP6();
                            else if(DataType.equals("InfiP7"))
                                insertInfiChP7();
                            else if(DataType.equals("InfiP8"))
                                insertInfiChP8();
                            else if(DataType.equals("InfiP13"))
                                insertInfiChP13();
                            else if(DataType.equals("InfiP16"))
                                insertInfiChP16();
                            else if(DataType.equals("InfiP17"))
                                insertInfiChP17();
                            else if(DataType.equals("InfiP6_9"))
                                insertInfiChP6_9();
                            else if(DataType.equals("InfiP13_17"))
                                insertInfiChP13_17();
                            else if(DataType.equals("InfiP6_17"))
                                insertInfiChP6_17();
                            else if(DataType.equals("InfiM6"))
                                insertInfiChM6();
                            else if(DataType.equals("InfiM7"))
                                insertInfiChM7();
                            else if(DataType.equals("InfiM8"))
                                insertInfiChM8();
                            else if(DataType.equals("InfiM13"))
                                insertInfiChM13();
                            else if(DataType.equals("InfiM16"))
                                insertInfiChM16();
                            else if(DataType.equals("InfiM17"))
                                insertInfiChM17();
                            else if(DataType.equals("InfiM6_9"))
                                insertInfiChM6_9();
                            else if(DataType.equals("InfiM13_17"))
                                insertInfiChM13_17();
                            else if(DataType.equals("InfiM6_17"))
                                insertInfiChM6_17();
                            else if(DataType.equals("MaxMin1_10"))
                                insertMaxMin1_10();
                            else if(DataType.equals("MaxMin10_20"))
                                insertMaxMin10_20();
                            else if(DataType.equals("MaxMin20_30"))
                                insertMaxMin20_30();

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
                    Toast.makeText(getApplicationContext(),"영상이 준비되지 않음. 잠시(3초) 후에 다시 시도하세요.",Toast.LENGTH_LONG).show();
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
            System.out.println("ADCHECKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK " +adCheck);
            adCheck += 1;
            String sqlUpdateCoin = "UPDATE AdCheck SET adCheck=" + adCheck;
            sqLiteDatabase.execSQL(sqlUpdateCoin);
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

    private void insertInfiChP6(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChP6" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChP7(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChP7" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChP8(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChP8" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChP13(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChP13" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChP16(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChP16" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChP17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChP17" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChP6_9(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChPR6_9" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChP13_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChPR13_17" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChP6_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChPR6_17" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChM6(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChM6" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChM7(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChM7" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChM8(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChM8" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChM13(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChM13" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChM16(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChM16" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChM17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChM17" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChM6_9(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChMR6_9" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChM13_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChMR13_17" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertInfiChM6_17(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO InfiChMR6_17" + "(result)" + "VALUES (" + insertResult + ");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertMaxMin1_10(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO MaxMin1_10" + "(result,AVtime)" + "VALUES (" + insertResult + "," + insertAVtime +");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertMaxMin10_20(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO MaxMin10_20" + "(result,AVtime)" + "VALUES (" + insertResult + "," + insertAVtime +");";
            sqLiteDatabase.execSQL(sqlQuery);
        }
    }

    private void insertMaxMin20_30(){
        if(sqLiteDatabase != null){
            String sqlQuery = "INSERT INTO MaxMin20_30" + "(result,AVtime)" + "VALUES (" + insertResult + "," + insertAVtime +");";
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
