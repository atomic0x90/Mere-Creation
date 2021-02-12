package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class Selection5_5 extends AppCompatActivity {
    @Override
    protected void onStart(){
        super.onStart();

        final Button button1 = (Button) findViewById(R.id.selection5_5_1);
        button1.setEnabled(false);
        class startHandler implements Runnable{

            public void run(){
                button1.setEnabled(true);
            }
        }

        Handler h = new Handler();
        h.postDelayed(new startHandler(),250);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection5_5);
    }

    @Override
    protected void onUserLeaveHint(){
        super.onUserLeaveHint();
        finish();
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
