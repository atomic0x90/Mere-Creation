package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class test1 extends AppCompatActivity implements View.OnTouchListener {


    private final int START_DRAG = 0;
    private final int END_DRAG = 1;
    private int isMoving;
    private float offset_x, offset_y;
    private boolean start_yn = true;

    private float dx, dy;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        Button button = (Button) findViewById(R.id.button3);
        Button button1 = (Button) findViewById(R.id.button4);

        getStandardSize();

        button.setWidth(standardSize_X / 2);
        button.setHeight(standardSize_Y / 2);
        button1.setWidth(standardSize_X / 2);
        button1.setHeight(standardSize_Y / 2);

        button.setOnTouchListener(this);
        button1.setOnTouchListener(this);


        /*
        DisplayMetrics dm = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int) (dm.widthPixels*0.8);
        lp.height = (int) (dm.heightPixels*0.7);



        button.setOnTouchListener(this);
*/
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                offset_x = event.getX();
                offset_y = event.getY();
                dx = offset_x - v.getX();
                dy = offset_y - v.getY();
            }
            break;
            case MotionEvent.ACTION_MOVE: {
                v.setX(event.getX() - dx);
                v.setY(event.getY() - dy);
            }
            break;
            case MotionEvent.ACTION_UP: {
                //your stuff
            }
        //    return true;
        }
        return true;
    }
/*
    @Override
    public boolean onTouch(View v,MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(start_yn){
                offset_x = event.getRawX();
                offset_y = event.getRawY();
                start_yn = false;
                //1
                System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDd");
            }
            isMoving = START_DRAG;
        }
        else if(event.getAction() == MotionEvent.ACTION_UP){
            isMoving = END_DRAG;
            //3
            System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUu");
        }
        else if(event.getAction() == MotionEvent.ACTION_MOVE){
            if(isMoving == START_DRAG){
                v.setX(event.getRawX()-offset_x);
                v.setY(event.getRawY()-offset_y);
                //2

                System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            }
        }

        return false;
    }
*/


}