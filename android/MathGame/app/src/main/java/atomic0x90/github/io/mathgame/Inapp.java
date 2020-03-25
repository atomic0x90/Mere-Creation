package atomic0x90.github.io.mathgame;


import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.Constants;
import com.anjlab.android.iab.v3.TransactionDetails;

import java.io.File;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Inapp extends Activity implements BillingProcessor.IBillingHandler{
    BillingProcessor bp;

    //Double click check
    private long mLastClickTime = 0;

    //Sound
    SoundPool soundPool;
    int soundID;


    //Coin
    int nowCoin = 0;
    int nowUpDateCoin = 0;

    //DB
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inapp);

        //DB
        sqLiteDatabase = init_database();

        //Coin
        TextView coinNowText = (TextView) findViewById(R.id.InappNowCoinText);
        load_coin();
        coinNowText.setText(String.valueOf(nowCoin));


        //
        AccountManager am = AccountManager.get(this); // "this" references the current Context

        String tmpAccount = null;
        Account[] accounts = am.getAccountsByType("com.google");
        for (Account account : accounts) {
            String accountName = account.name;
            String accountType = account.type;

            Log.d(TAG, "Account Name: " + accountName);
            Log.d(TAG, "Account Type: " + accountType);
            tmpAccount = accountName;
        }



        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound01,1);

        //
        bp = new BillingProcessor(this, getResources().getString(R.string.Google_Play_Console_License_Key), this);
        bp.initialize();
        // or bp = BillingProcessor.newBillingProcessor(this, "YOUR LICENSE KEY FROM GOOGLE PLAY CONSOLE HERE", this);
        // See below on why this is a useful alternative

        //final Bundle extraParams = new Bundle();
        //extraParams.putString(tmpAccount,getResources().getString(R.string.My_account_id));
        //bp.purchase(Inapp.this, "coin_1000", null /*or developer payload*/, extraParams);


        Button getCoin1000 = (Button)findViewById(R.id.getCoin1000);
        Button getCoin3000 = (Button)findViewById(R.id.getCoin3000);
        Button getCoin10000 = (Button)findViewById(R.id.getCoin10000);
        Button getCoin30000 = (Button)findViewById(R.id.getCoin30000);

        getCoin1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);
                //boolean isAvailable = BillingProcessor.isIabServiceAvailable(Inapp.this);
                //if(!isAvailable) {
                    // continue
                    //bp.purchase(Inapp.this, "coin_1000", null /*or developer payload*/, extraParams);

                    nowUpDateCoin = 1000;
                    System.out.println("111111111111111111");
                    bp.purchase(Inapp.this,"coin_1000");
                    System.out.println("222222222222222222");
                    // System.out.println("TESTESTETSETSETSET");
                     //bp.consumePurchase("coin_1000");
                     //bp.loadOwnedPurchasesFromGoogle();

                //}
            }
        });

        getCoin3000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                nowUpDateCoin = 3000;

                bp.purchase(Inapp.this,"coin_3000");

            }
        });

        getCoin10000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                nowUpDateCoin = 10000;

                bp.purchase(Inapp.this,"coin_10000");
            }
        });

        getCoin30000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mis-clicking prevention, using threshold of 1000 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                soundPool.play(soundID,1f,1f,0,0,1f);

                nowUpDateCoin = 30000;

                bp.purchase(Inapp.this,"coin_30000");
            }
        });

    }

    // IBillingHandler implementation

    @Override
    public void onBillingInitialized() {
        /*
         * Called when BillingProcessor was initialized and it's ready to purchase
         */
    }

    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {
        /*
         * Called when requested PRODUCT ID was successfully purchased
         */
        String type = null;
        if(nowUpDateCoin == 1000)
            type = "coin_1000";
        else if(nowUpDateCoin == 3000)
            type = "coin_3000";
        else if(nowUpDateCoin == 10000)
            type = "coin_10000";
        else if(nowUpDateCoin == 30000)
            type = "coin_30000";

        bp.consumePurchase(type);
        bp.loadOwnedPurchasesFromGoogle();
        UpdateCoin();
        Toast.makeText(Inapp.this, "결제 완료", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Inapp.this,Inapp.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {
        /*
         * Called when some error occurred. See Constants class for more details
         *
         * Note - this includes handling the case where the user canceled the buy dialog:
         * errorCode = Constants.BILLING_RESPONSE_RESULT_USER_CANCELED
         */
        // 결제 실패시 호출되며 Constants.BILLING_RESPONSE_RESULT_USER_CANCELED는 사용자가 취소한 것이므로 이외의 경우에 토스트를 띄운다.
        if (errorCode != Constants.BILLING_RESPONSE_RESULT_USER_CANCELED)
        {
            Toast.makeText(Inapp.this, "결제 실패", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPurchaseHistoryRestored() {
        /*
         * Called when purchase history was restored and the list of all owned PRODUCT ID's
         * was loaded from Google Play
         */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onDestroy() {
        if (bp != null) {
            bp.release();
        }
        super.onDestroy();
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

    private void load_coin(){
        if(sqLiteDatabase != null){
            String sqlQuery = "SELECT * FROM Coin";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQuery,null);

            if(cursor.moveToNext()){
                nowCoin = cursor.getInt(0);
            }
        }
    }

    private void UpdateCoin(){
        if(sqLiteDatabase != null){
            nowCoin += nowUpDateCoin;
            String sqlUpdateCoin = "UPDATE Coin SET coin=" + nowCoin;
            sqLiteDatabase.execSQL(sqlUpdateCoin);
        }
    }

    // 마지막으로 뒤로 가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    private Toast toast;


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        // 2500 milliseconds = 2.5 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 메인 화면으로 이동합니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
