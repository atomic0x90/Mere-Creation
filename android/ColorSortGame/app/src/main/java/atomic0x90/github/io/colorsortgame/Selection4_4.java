package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class Selection4_4 extends AppCompatActivity {

    int standardSize_X, standardSize_Y;
    float density;

    public Point getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size;
    }

    public void getStandardSize() {
        Point ScreenSize = getScreenSize(this);
        density = getResources().getDisplayMetrics().density;

        standardSize_X = (int) (ScreenSize.x / density);
        standardSize_Y = (int) (ScreenSize.y / density);
    }
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

        getStandardSize();

        ScrollView scrollView = (ScrollView) findViewById(R.id.selection4_4ScrollView);

        scrollView.setX(0);
        scrollView.setY(100);
        scrollView.setMinimumWidth(standardSize_X);
        scrollView.setMinimumHeight(standardSize_Y-100);

        Button button1 = (Button) findViewById(R.id.selection4_4_1);
        Button button2 = (Button) findViewById(R.id.selection4_4_2);
        Button button3 = (Button) findViewById(R.id.selection4_4_3);
        Button button4 = (Button) findViewById(R.id.selection4_4_4);

        button1.setWidth(standardSize_X/4);
        button2.setWidth(standardSize_X/4);
        button3.setWidth(standardSize_X/4);
        button4.setWidth(standardSize_X/4);

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
