package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Selection4_4 extends AppCompatActivity {
    @Override
    protected void onStart(){
        super.onStart();

        final Button button1 = (Button) findViewById(R.id.selection4_4_1);
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
        setContentView(R.layout.activity_selection4_4);

        Button button1 = (Button) findViewById(R.id.selection4_4_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection4_4.this,Game_4_4.class);
                intent.putExtra("LV",1);
                startActivity(intent);
            }
        });
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
