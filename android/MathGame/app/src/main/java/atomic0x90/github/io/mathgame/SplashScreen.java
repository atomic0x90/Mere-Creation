package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private InterstitialAd interstitialAd;

    private Timer waitTimer;


    private boolean interstitialCanceled = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/8691691433");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                if(!interstitialCanceled) {
                    waitTimer.cancel();
                    interstitialAd.show();
                }
            }
            @Override
            public void onAdFailedToLoad(int errorCode) {
                startUserStatistics();
            }
            @Override
            public void onAdClosed(){
                startUserStatistics();
                finish();
            }
        });



        waitTimer = new Timer();
        waitTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                interstitialCanceled = true;
                SplashScreen.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startUserStatistics();
                    }
                });
            }
        }, 5000);



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
            startUserStatistics();
        }
    }

    private void startUserStatistics() {
        Intent intent = new Intent(this, UserStatistics.class);
        startActivity(intent);
        finish();
    }

}
