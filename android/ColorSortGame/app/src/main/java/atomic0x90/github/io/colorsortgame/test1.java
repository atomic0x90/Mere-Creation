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

    float oldXvalue,oldYvalue;
    int standardSize_X, standardSize_Y;
    float density;
    float saveX = -1;
    float saveY = -1;

    float saveLastLine;
    float midleX,midleY;
    float[] buttonLayoutX = new float[5];
    float[] buttonLayoutY = new float[5];
    int[] buttonOrder = {0,1,2,3,4};
    float buttonLength;

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

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);

        getStandardSize();

        buttonLength = standardSize_X/4;
        saveLastLine = standardSize_X/4;

        button1.setWidth((int)buttonLength);
        button1.setHeight((int)buttonLength);

        button2.setWidth((int)buttonLength);
        button2.setHeight((int)buttonLength);

        button3.setWidth((int)buttonLength);
        button3.setHeight((int)buttonLength);

        button4.setWidth((int)buttonLength);
        button4.setHeight((int)buttonLength);

        button1.setX(0);
        button1.setY(0);
        for(int i = 1;i <= 4;i++){
            if(i >= 1 && i <= 4)
                buttonLayoutY[i] = 0;
            else
                buttonLayoutY[i] = buttonLength;

            buttonLayoutX[i] = buttonLength * (i-1);
        }

        button2.setX((int)buttonLength);
        button2.setY(0);

        button3.setX(((int)buttonLength)*2);
        button3.setY(0);

        button4.setX(((int)buttonLength)*3);
        button4.setY(0);


        button1.setOnTouchListener(this);
        button2.setOnTouchListener(this);
        button3.setOnTouchListener(this);
        button4.setOnTouchListener(this);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event){

        int parentWidth = ((ViewGroup)v.getParent()).getWidth();    // 부모 View 의 Width
        int parentHeight = ((ViewGroup)v.getParent()).getHeight();    // 부모 View 의 Height

        if(saveX == -1)
            saveX = v.getX();
        if(saveY == -1)
            saveY = v.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            // 뷰 누름
            oldXvalue = event.getX();
            oldYvalue = event.getY();
            Log.d("viewTest", "oldXvalue : "+ oldXvalue + " oldYvalue : " + oldYvalue);    // View 내부에서 터치한 지점의 상대 좌표값.
            Log.d("viewTest", "v.getX() : "+v.getX());    // View 의 좌측 상단이 되는 지점의 절대 좌표값.
            Log.d("viewTest", "RawX : " + event.getRawX() +" RawY : " + event.getRawY());    // View 를 터치한 지점의 절대 좌표값.
            Log.d("viewTest", "v.getHeight : " + v.getHeight() + " v.getWidth : " + v.getWidth());    // View 의 Width, Height


        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            // 뷰 이동 중
            v.setX(v.getX() + (event.getX()) - (v.getWidth()/2));
            v.setY(v.getY() + (event.getY()) - (v.getHeight()/2));
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            // 뷰에서 손을 뗌
/*
            if(v.getX() < 0){
                v.setX(0);
            }else if((v.getX() + v.getWidth()) > parentWidth){
                v.setX(parentWidth - v.getWidth());
            }

            if(v.getY() < 0){
                v.setY(0);
            }else if((v.getY() + v.getHeight()) > parentHeight){
                v.setY(parentHeight - v.getHeight());
            }
*/

            if(v.getY() > saveLastLine) {
                v.setX(saveX);
                v.setY(saveY);
                saveX = saveY = -1;
                return true;
            }

            if(buttonLayoutX[1] <= v.getX() && v.getX() < buttonLayoutX[1] + buttonLength && buttonLayoutY[1] <= v.getY() && v.getY() < buttonLayoutY[1] + buttonLength){
                v.setX(buttonLayoutX[1]);
                v.setY(buttonLayoutY[1]);
                Button button;
                if(buttonOrder[1] == 1) {
                    button = (Button) findViewById(R.id.button1);
                    button.setX(saveX);
                    button.setY(saveY);
                }

                int check = -1;
                for(int i = 1;i <= 4;i++){
                    if(buttonLayoutX[i] == saveX && buttonLayoutY[i] == saveY){
                        check = i;
                        break;
                    }

                    Log.d("check","buttonX "+i+": " + buttonLayoutX[i] + " buttonY "+i+": "+buttonLayoutY[i]);
                }
                Log.d("Touch finish","saveX : "+saveX + " saveY : "+ saveY);

                //v.setX(buttonLayoutX[check]);
                //v.setY(buttonLayoutY[check]);

                float tmpX,tmpY;
                tmpX = buttonLayoutX[check];
                tmpY = buttonLayoutY[check];
                buttonLayoutX[check] = saveX;
                buttonLayoutY[check] = saveY;

                buttonLayoutX[1] = tmpX;
                buttonLayoutY[1] = tmpY;


                saveX = saveY = -1;
            }
            else{
                v.setX(saveX);
                v.setY(saveY);
                saveX = saveY = -1;
            }
        }
        return true;
    }


}