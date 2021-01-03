package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private InterstitialAd interstitialAd;

    private Timer waitTimer;

    private Timer infiTimer;

    String Ac;

    private boolean interstitialCanceled = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Intent Setintent = getIntent();
        final String goActivity = Setintent.getStringExtra("Text");



        Ac = goActivity;

        TextView textView = (TextView)findViewById(R.id.middleText);

        if(goActivity.equals("Statistics"))
            textView.setText("통계 집계 중");
        else if(goActivity.equals("multiTable") || goActivity.equals("CustomDialog"))
            textView.setText("");

        waitTimer = new Timer();
        waitTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                interstitialCanceled = true;
                SplashScreen.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(goActivity.equals("Statistics"))
                            startUserStatistics();
                        else if(goActivity.equals("multiTable"))
                            startMultiTable();
                        else if(goActivity.equals("CustomDialog"))
                            startMain();
                        finish();
                    }
                });
            }
        }, 5000);


        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.TEST_AD_FULL_ID));
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                if(!interstitialCanceled) {
                    waitTimer.cancel();
                    interstitialAd.show();
/*
                    if(goActivity.equals("Statistics")){
                        startUserStatistics();
                        finish();
                    }*/
                }
            }
            @Override
            public void onAdFailedToLoad(int errorCode) {
                if(goActivity.equals("Statistics"))
                    startUserStatistics();
                else if(goActivity.equals("multiTable"))
                    startMultiTable();
                else if(goActivity.equals("CustomDialog"))
                    startMain();

                finish();

            }
            @Override
            public void onAdClosed(){
                if(goActivity.equals("Statistics"))
                    startUserStatistics();
                else if(goActivity.equals("multiTable"))
                    startMultiTable();
                else if(goActivity.equals("CustomDialog"))
                    startMain();
                finish();
            }
        });

    }
    @Override
    public void onPause() {
        waitTimer.cancel();
        interstitialCanceled = true;
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else if (interstitialCanceled) {
            if(Ac.equals("Statistics"))
                startUserStatistics();
            else if(Ac.equals("multiTable"))
                startMultiTable();
            else if(Ac.equals("CustomDialog"))
                startMain();
        }
    }

    private void startUserStatistics() {
        Intent intent = new Intent(this, UserStatistics.class);
        startActivity(intent);
        finish();
    }

    private void startMultiTable(){
        Intent intent = new Intent(this,Multiplication_table.class);
        startActivity(intent);
        finish();
    }

    private void startMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }


}