package atomic0x90.github.io.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;

public class StepSelection extends AppCompatActivity {

    SQLiteDatabase sqliteDB ;

    int lock1_1 = -1;
    int lock1_2 = -1;
    int lock1_3 = -1;
    int lock1_4 = -1;
    int lock1_5 = -1;
    int lock1_6 = -1;
    int lock1_7 = -1;
    int lock1_8 = -1;

    int lock2_1 = -1;
    int lock2_2 = -1;
    int lock2_3 = -1;
    int lock2_4 = -1;
    int lock2_5 = -1;
    int lock2_6 = -1;
    int lock2_7 = -1;
    int lock2_8 = -1;

    int lock3_1 = -1;
    int lock3_2 = -1;
    int lock3_3 = -1;
    int lock3_4 = -1;
    int lock3_5 = -1;
    int lock3_6 = -1;
    int lock3_7 = -1;
    int lock3_8 = -1;

    int lock4_1 = -1;
    int lock4_2 = -1;
    int lock4_3 = -1;
    int lock4_4 = -1;
    int lock4_5 = -1;
    int lock4_6 = -1;
    int lock4_7 = -1;
    int lock4_8 = -1;

    int lock5_1 = -1;
    int lock5_2 = -1;
    int lock5_3 = -1;
    int lock5_4 = -1;
    int lock5_5 = -1;
    int lock5_6 = -1;
    int lock5_7 = -1;
    int lock5_8 = -1;

    int lock6_1 = -1;
    int lock6_2 = -1;
    int lock6_3 = -1;
    int lock6_4 = -1;
    int lock6_5 = -1;
    int lock6_6 = -1;
    int lock6_7 = -1;
    int lock6_8 = -1;

    int lock7_1 = -1;
    int lock7_2 = -1;
    int lock7_3 = -1;
    int lock7_4 = -1;
    int lock7_5 = -1;
    int lock7_6 = -1;
    int lock7_7 = -1;
    int lock7_8 = -1;

    int lock8_1 = -1;
    int lock8_2 = -1;
    int lock8_3 = -1;
    int lock8_4 = -1;
    int lock8_5 = -1;
    int lock8_6 = -1;
    int lock8_7 = -1;
    int lock8_8 = -1;

    int lock9_1 = -1;
    int lock9_2 = -1;
    int lock9_3 = -1;
    int lock9_4 = -1;
    int lock9_5 = -1;
    int lock9_6 = -1;
    int lock9_7 = -1;
    int lock9_8 = -1;

    int lock10_1 = -1;
    int lock10_2 = -1;
    int lock10_3 = -1;
    int lock10_4 = -1;
    int lock10_5 = -1;
    int lock10_6 = -1;
    int lock10_7 = -1;
    int lock10_8 = -1;

    @Override
    protected void onResume() {
        super.onResume();

        loadGameLockALL();
        Button Step1_1Button = (Button) findViewById(R.id.Step1_1);
        Button Step1_2Button = (Button) findViewById(R.id.Step1_2);
        Button Step1_3Button = (Button) findViewById(R.id.Step1_3);
        Button Step1_4Button = (Button) findViewById(R.id.Step1_4);
        Button Step1_5Button = (Button) findViewById(R.id.Step1_5);
        Button Step1_6Button = (Button) findViewById(R.id.Step1_6);
        Button Step1_7Button = (Button) findViewById(R.id.Step1_7);
        Button Step1_8Button = (Button) findViewById(R.id.Step1_8);

        Button Step2_1Button = (Button) findViewById(R.id.Step2_1);
        Button Step2_2Button = (Button) findViewById(R.id.Step2_2);
        Button Step2_3Button = (Button) findViewById(R.id.Step2_3);
        Button Step2_4Button = (Button) findViewById(R.id.Step2_4);
        Button Step2_5Button = (Button) findViewById(R.id.Step2_5);
        Button Step2_6Button = (Button) findViewById(R.id.Step2_6);
        Button Step2_7Button = (Button) findViewById(R.id.Step2_7);
        Button Step2_8Button = (Button) findViewById(R.id.Step2_8);

        Button Step3_1Button = (Button) findViewById(R.id.Step3_1);
        Button Step3_2Button = (Button) findViewById(R.id.Step3_2);
        Button Step3_3Button = (Button) findViewById(R.id.Step3_3);
        Button Step3_4Button = (Button) findViewById(R.id.Step3_4);
        Button Step3_5Button = (Button) findViewById(R.id.Step3_5);
        Button Step3_6Button = (Button) findViewById(R.id.Step3_6);
        Button Step3_7Button = (Button) findViewById(R.id.Step3_7);
        Button Step3_8Button = (Button) findViewById(R.id.Step3_8);

        Button Step4_1Button = (Button) findViewById(R.id.Step4_1);
        Button Step4_2Button = (Button) findViewById(R.id.Step4_2);
        Button Step4_3Button = (Button) findViewById(R.id.Step4_3);
        Button Step4_4Button = (Button) findViewById(R.id.Step4_4);
        Button Step4_5Button = (Button) findViewById(R.id.Step4_5);
        Button Step4_6Button = (Button) findViewById(R.id.Step4_6);
        Button Step4_7Button = (Button) findViewById(R.id.Step4_7);
        Button Step4_8Button = (Button) findViewById(R.id.Step4_8);

        Button Step5_1Button = (Button) findViewById(R.id.Step5_1);
        Button Step5_2Button = (Button) findViewById(R.id.Step5_2);
        Button Step5_3Button = (Button) findViewById(R.id.Step5_3);
        Button Step5_4Button = (Button) findViewById(R.id.Step5_4);
        Button Step5_5Button = (Button) findViewById(R.id.Step5_5);
        Button Step5_6Button = (Button) findViewById(R.id.Step5_6);
        Button Step5_7Button = (Button) findViewById(R.id.Step5_7);
        Button Step5_8Button = (Button) findViewById(R.id.Step5_8);

        Button Step6_1Button = (Button) findViewById(R.id.Step6_1);
        Button Step6_2Button = (Button) findViewById(R.id.Step6_2);
        Button Step6_3Button = (Button) findViewById(R.id.Step6_3);
        Button Step6_4Button = (Button) findViewById(R.id.Step6_4);
        Button Step6_5Button = (Button) findViewById(R.id.Step6_5);
        Button Step6_6Button = (Button) findViewById(R.id.Step6_6);
        Button Step6_7Button = (Button) findViewById(R.id.Step6_7);
        Button Step6_8Button = (Button) findViewById(R.id.Step6_8);

        Button Step7_1Button = (Button) findViewById(R.id.Step7_1);
        Button Step7_2Button = (Button) findViewById(R.id.Step7_2);
        Button Step7_3Button = (Button) findViewById(R.id.Step7_3);
        Button Step7_4Button = (Button) findViewById(R.id.Step7_4);
        Button Step7_5Button = (Button) findViewById(R.id.Step7_5);
        Button Step7_6Button = (Button) findViewById(R.id.Step7_6);
        Button Step7_7Button = (Button) findViewById(R.id.Step7_7);
        Button Step7_8Button = (Button) findViewById(R.id.Step7_8);

        Button Step8_1Button = (Button) findViewById(R.id.Step8_1);
        Button Step8_2Button = (Button) findViewById(R.id.Step8_2);
        Button Step8_3Button = (Button) findViewById(R.id.Step8_3);
        Button Step8_4Button = (Button) findViewById(R.id.Step8_4);
        Button Step8_5Button = (Button) findViewById(R.id.Step8_5);
        Button Step8_6Button = (Button) findViewById(R.id.Step8_6);
        Button Step8_7Button = (Button) findViewById(R.id.Step8_7);
        Button Step8_8Button = (Button) findViewById(R.id.Step8_8);

        Button Step9_1Button = (Button) findViewById(R.id.Step9_1);
        Button Step9_2Button = (Button) findViewById(R.id.Step9_2);
        Button Step9_3Button = (Button) findViewById(R.id.Step9_3);
        Button Step9_4Button = (Button) findViewById(R.id.Step9_4);
        Button Step9_5Button = (Button) findViewById(R.id.Step9_5);
        Button Step9_6Button = (Button) findViewById(R.id.Step9_6);
        Button Step9_7Button = (Button) findViewById(R.id.Step9_7);
        Button Step9_8Button = (Button) findViewById(R.id.Step9_8);

        Button Step10_1Button = (Button) findViewById(R.id.Step10_1);
        Button Step10_2Button = (Button) findViewById(R.id.Step10_2);
        Button Step10_3Button = (Button) findViewById(R.id.Step10_3);
        Button Step10_4Button = (Button) findViewById(R.id.Step10_4);
        Button Step10_5Button = (Button) findViewById(R.id.Step10_5);
        Button Step10_6Button = (Button) findViewById(R.id.Step10_6);
        Button Step10_7Button = (Button) findViewById(R.id.Step10_7);
        Button Step10_8Button = (Button) findViewById(R.id.Step10_8);
        
        if(lock1_2 == 0){
            Step1_2Button.setBackgroundResource(R.drawable.costom_menu_button1);
        }
        if(lock1_3 == 0){
            Step1_3Button.setBackgroundResource(R.drawable.costom_menu_button1);
        }
        if(lock1_4 == 0){
            Step1_4Button.setBackgroundResource(R.drawable.costom_menu_button1);
        }
        if(lock1_5 == 0){
            Step1_5Button.setBackgroundResource(R.drawable.costom_menu_button1);
        }
        if(lock1_6 == 0){
            Step1_6Button.setBackgroundResource(R.drawable.costom_menu_button1);
        }
        if(lock1_7 == 0){
            Step1_7Button.setBackgroundResource(R.drawable.costom_menu_button1);
        }
        if(lock1_8 == 0){
            Step1_8Button.setBackgroundResource(R.drawable.costom_menu_button1);
        }
        if(lock2_1 == 0){
            Step2_1Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock2_2 == 0){
            Step2_2Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock2_3 == 0){
            Step2_3Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock2_4 == 0){
            Step2_4Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock2_5 == 0){
            Step2_5Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock2_6 == 0){
            Step2_6Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock2_7 == 0){
            Step2_7Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock2_8 == 0){
            Step2_8Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock3_1 == 0){
            Step3_1Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock3_2 == 0){
            Step3_2Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock3_3 == 0){
            Step3_3Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock3_4 == 0){
            Step3_4Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock3_5 == 0){
            Step3_5Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock3_6 == 0){
            Step3_6Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock3_7 == 0){
            Step3_7Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock3_8 == 0){
            Step3_8Button.setBackgroundResource(R.drawable.costom_menu_button2);
        }
        if(lock4_1 == 0){
            Step4_1Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock4_2 == 0){
            Step4_2Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock4_3 == 0){
            Step4_3Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock4_4 == 0){
            Step4_4Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock4_5 == 0){
            Step4_5Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock4_6 == 0){
            Step4_6Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock4_7 == 0){
            Step4_7Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock4_8 == 0){
            Step4_8Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock5_1 == 0){
            Step5_1Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock5_2 == 0){
            Step5_2Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock5_3 == 0){
            Step5_3Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock5_4 == 0){
            Step5_4Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock5_5 == 0){
            Step5_5Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock5_6 == 0){
            Step5_6Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock5_7 == 0){
            Step5_7Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock5_8 == 0){
            Step5_8Button.setBackgroundResource(R.drawable.costom_menu_button3);
        }
        if(lock6_1 == 0){
            Step6_1Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock6_2 == 0){
            Step6_2Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock6_3 == 0){
            Step6_3Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock6_4 == 0){
            Step6_4Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock6_5 == 0){
            Step6_5Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock6_6 == 0){
            Step6_6Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock6_7 == 0){
            Step6_7Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock6_8 == 0){
            Step6_8Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock7_1 == 0){
            Step7_1Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock7_2 == 0){
            Step7_2Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock7_3 == 0){
            Step7_3Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock7_4 == 0){
            Step7_4Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock7_5 == 0){
            Step7_5Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock7_6 == 0){
            Step7_6Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock7_7 == 0){
            Step7_7Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock7_8 == 0){
            Step7_8Button.setBackgroundResource(R.drawable.costom_menu_button4);
        }
        if(lock8_1 == 0){
            Step8_1Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock8_2 == 0){
            Step8_2Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock8_3 == 0){
            Step8_3Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock8_4 == 0){
            Step8_4Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock8_5 == 0){
            Step8_5Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock8_6 == 0){
            Step8_6Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock8_7 == 0){
            Step8_7Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock8_8 == 0){
            Step8_8Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock9_1 == 0){
            Step9_1Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock9_2 == 0){
            Step9_2Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock9_3 == 0){
            Step9_3Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock9_4 == 0){
            Step9_4Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock9_5 == 0){
            Step9_5Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock9_6 == 0){
            Step9_6Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock9_7 == 0){
            Step9_7Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock9_8 == 0){
            Step9_8Button.setBackgroundResource(R.drawable.costom_menu_button5);
        }
        if(lock10_1 == 0){
            Step10_1Button.setBackgroundResource(R.drawable.costom_menu_button6);
        }
        if(lock10_2 == 0){
            Step10_2Button.setBackgroundResource(R.drawable.costom_menu_button6);
        }
        if(lock10_3 == 0){
            Step10_3Button.setBackgroundResource(R.drawable.costom_menu_button6);
        }
        if(lock10_4 == 0){
            Step10_4Button.setBackgroundResource(R.drawable.costom_menu_button6);
        }
        if(lock10_5 == 0){
            Step10_5Button.setBackgroundResource(R.drawable.costom_menu_button6);
        }
        if(lock10_6 == 0){
            Step10_6Button.setBackgroundResource(R.drawable.costom_menu_button6);
        }
        if(lock10_7 == 0){
            Step10_7Button.setBackgroundResource(R.drawable.costom_menu_button6);
        }
        if(lock10_8 == 0){
            Step10_8Button.setBackgroundResource(R.drawable.costom_menu_button6);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_selection);
        sqliteDB = init_database();
        loadGameLockALL();

        final Button Step1Button = (Button) findViewById(R.id.Step1Button);
        final Button Step2Button = (Button) findViewById(R.id.Step2Button);
        final Button Step3Button = (Button) findViewById(R.id.Step3Button);
        final Button Step4Button = (Button) findViewById(R.id.Step4Button);
        final Button Step5Button = (Button) findViewById(R.id.Step5Button);
        final Button Step6Button = (Button) findViewById(R.id.Step6Button);
        final Button Step7Button = (Button) findViewById(R.id.Step7Button);
        final Button Step8Button = (Button) findViewById(R.id.Step8Button);
        final Button Step9Button = (Button) findViewById(R.id.Step9Button);
        final Button Step10Button = (Button) findViewById(R.id.Step10Button);


        Button TutorialButton = (Button) findViewById(R.id.TutorialButton);

        Button Step1_1Button = (Button) findViewById(R.id.Step1_1);
        Button Step1_2Button = (Button) findViewById(R.id.Step1_2);
        Button Step1_3Button = (Button) findViewById(R.id.Step1_3);
        Button Step1_4Button = (Button) findViewById(R.id.Step1_4);
        Button Step1_5Button = (Button) findViewById(R.id.Step1_5);
        Button Step1_6Button = (Button) findViewById(R.id.Step1_6);
        Button Step1_7Button = (Button) findViewById(R.id.Step1_7);
        Button Step1_8Button = (Button) findViewById(R.id.Step1_8);

        Button Step2_1Button = (Button) findViewById(R.id.Step2_1);
        Button Step2_2Button = (Button) findViewById(R.id.Step2_2);
        Button Step2_3Button = (Button) findViewById(R.id.Step2_3);
        Button Step2_4Button = (Button) findViewById(R.id.Step2_4);
        Button Step2_5Button = (Button) findViewById(R.id.Step2_5);
        Button Step2_6Button = (Button) findViewById(R.id.Step2_6);
        Button Step2_7Button = (Button) findViewById(R.id.Step2_7);
        Button Step2_8Button = (Button) findViewById(R.id.Step2_8);

        Button Step3_1Button = (Button) findViewById(R.id.Step3_1);
        Button Step3_2Button = (Button) findViewById(R.id.Step3_2);
        Button Step3_3Button = (Button) findViewById(R.id.Step3_3);
        Button Step3_4Button = (Button) findViewById(R.id.Step3_4);
        Button Step3_5Button = (Button) findViewById(R.id.Step3_5);
        Button Step3_6Button = (Button) findViewById(R.id.Step3_6);
        Button Step3_7Button = (Button) findViewById(R.id.Step3_7);
        Button Step3_8Button = (Button) findViewById(R.id.Step3_8);

        Button Step4_1Button = (Button) findViewById(R.id.Step4_1);
        Button Step4_2Button = (Button) findViewById(R.id.Step4_2);
        Button Step4_3Button = (Button) findViewById(R.id.Step4_3);
        Button Step4_4Button = (Button) findViewById(R.id.Step4_4);
        Button Step4_5Button = (Button) findViewById(R.id.Step4_5);
        Button Step4_6Button = (Button) findViewById(R.id.Step4_6);
        Button Step4_7Button = (Button) findViewById(R.id.Step4_7);
        Button Step4_8Button = (Button) findViewById(R.id.Step4_8);

        Button Step5_1Button = (Button) findViewById(R.id.Step5_1);
        Button Step5_2Button = (Button) findViewById(R.id.Step5_2);
        Button Step5_3Button = (Button) findViewById(R.id.Step5_3);
        Button Step5_4Button = (Button) findViewById(R.id.Step5_4);
        Button Step5_5Button = (Button) findViewById(R.id.Step5_5);
        Button Step5_6Button = (Button) findViewById(R.id.Step5_6);
        Button Step5_7Button = (Button) findViewById(R.id.Step5_7);
        Button Step5_8Button = (Button) findViewById(R.id.Step5_8);

        Button Step6_1Button = (Button) findViewById(R.id.Step6_1);
        Button Step6_2Button = (Button) findViewById(R.id.Step6_2);
        Button Step6_3Button = (Button) findViewById(R.id.Step6_3);
        Button Step6_4Button = (Button) findViewById(R.id.Step6_4);
        Button Step6_5Button = (Button) findViewById(R.id.Step6_5);
        Button Step6_6Button = (Button) findViewById(R.id.Step6_6);
        Button Step6_7Button = (Button) findViewById(R.id.Step6_7);
        Button Step6_8Button = (Button) findViewById(R.id.Step6_8);

        Button Step7_1Button = (Button) findViewById(R.id.Step7_1);
        Button Step7_2Button = (Button) findViewById(R.id.Step7_2);
        Button Step7_3Button = (Button) findViewById(R.id.Step7_3);
        Button Step7_4Button = (Button) findViewById(R.id.Step7_4);
        Button Step7_5Button = (Button) findViewById(R.id.Step7_5);
        Button Step7_6Button = (Button) findViewById(R.id.Step7_6);
        Button Step7_7Button = (Button) findViewById(R.id.Step7_7);
        Button Step7_8Button = (Button) findViewById(R.id.Step7_8);

        Button Step8_1Button = (Button) findViewById(R.id.Step8_1);
        Button Step8_2Button = (Button) findViewById(R.id.Step8_2);
        Button Step8_3Button = (Button) findViewById(R.id.Step8_3);
        Button Step8_4Button = (Button) findViewById(R.id.Step8_4);
        Button Step8_5Button = (Button) findViewById(R.id.Step8_5);
        Button Step8_6Button = (Button) findViewById(R.id.Step8_6);
        Button Step8_7Button = (Button) findViewById(R.id.Step8_7);
        Button Step8_8Button = (Button) findViewById(R.id.Step8_8);

        Button Step9_1Button = (Button) findViewById(R.id.Step9_1);
        Button Step9_2Button = (Button) findViewById(R.id.Step9_2);
        Button Step9_3Button = (Button) findViewById(R.id.Step9_3);
        Button Step9_4Button = (Button) findViewById(R.id.Step9_4);
        Button Step9_5Button = (Button) findViewById(R.id.Step9_5);
        Button Step9_6Button = (Button) findViewById(R.id.Step9_6);
        Button Step9_7Button = (Button) findViewById(R.id.Step9_7);
        Button Step9_8Button = (Button) findViewById(R.id.Step9_8);

        Button Step10_1Button = (Button) findViewById(R.id.Step10_1);
        Button Step10_2Button = (Button) findViewById(R.id.Step10_2);
        Button Step10_3Button = (Button) findViewById(R.id.Step10_3);
        Button Step10_4Button = (Button) findViewById(R.id.Step10_4);
        Button Step10_5Button = (Button) findViewById(R.id.Step10_5);
        Button Step10_6Button = (Button) findViewById(R.id.Step10_6);
        Button Step10_7Button = (Button) findViewById(R.id.Step10_7);
        Button Step10_8Button = (Button) findViewById(R.id.Step10_8);

        if(lock1_2 == 1){
            Step1_2Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock1_3 == 1){
            Step1_3Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock1_4 == 1){
            Step1_4Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock1_5 == 1){
            Step1_5Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock1_6 == 1){
            Step1_6Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock1_7 == 1){
            Step1_7Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock1_8 == 1){
            Step1_8Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock2_1 == 1){
            Step2_1Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock2_2 == 1){
            Step2_2Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock2_3 == 1){
            Step2_3Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock2_4 == 1){
            Step2_4Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock2_5 == 1){
            Step2_5Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock2_6 == 1){
            Step2_6Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock2_7 == 1){
            Step2_7Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock2_8 == 1){
            Step2_8Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock3_1 == 1){
            Step3_1Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock3_2 == 1){
            Step3_2Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock3_3 == 1){
            Step3_3Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock3_4 == 1){
            Step3_4Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock3_5 == 1){
            Step3_5Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock3_6 == 1){
            Step3_6Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock3_7 == 1){
            Step3_7Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock3_8 == 1){
            Step3_8Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock4_1 == 1){
            Step4_1Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock4_2 == 1){
            Step4_2Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock4_3 == 1){
            Step4_3Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock4_4 == 1){
            Step4_4Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock4_5 == 1){
            Step4_5Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock4_6 == 1){
            Step4_6Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock4_7 == 1){
            Step4_7Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock4_8 == 1){
            Step4_8Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock5_1 == 1){
            Step5_1Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock5_2 == 1){
            Step5_2Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock5_3 == 1){
            Step5_3Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock5_4 == 1){
            Step5_4Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock5_5 == 1){
            Step5_5Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock5_6 == 1){
            Step5_6Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock5_7 == 1){
            Step5_7Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock5_8 == 1){
            Step5_8Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock6_1 == 1){
            Step6_1Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock6_2 == 1){
            Step6_2Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock6_3 == 1){
            Step6_3Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock6_4 == 1){
            Step6_4Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock6_5 == 1){
            Step6_5Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock6_6 == 1){
            Step6_6Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock6_7 == 1){
            Step6_7Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock6_8 == 1){
            Step6_8Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock7_1 == 1){
            Step7_1Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock7_2 == 1){
            Step7_2Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock7_3 == 1){
            Step7_3Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock7_4 == 1){
            Step7_4Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock7_5 == 1){
            Step7_5Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock7_6 == 1){
            Step7_6Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock7_7 == 1){
            Step7_7Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock7_8 == 1){
            Step7_8Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock8_1 == 1){
            Step8_1Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock8_2 == 1){
            Step8_2Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock8_3 == 1){
            Step8_3Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock8_4 == 1){
            Step8_4Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock8_5 == 1){
            Step8_5Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock8_6 == 1){
            Step8_6Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock8_7 == 1){
            Step8_7Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock8_8 == 1){
            Step8_8Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock9_1 == 1){
            Step9_1Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock9_2 == 1){
            Step9_2Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock9_3 == 1){
            Step9_3Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock9_4 == 1){
            Step9_4Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock9_5 == 1){
            Step9_5Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock9_6 == 1){
            Step9_6Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock9_7 == 1){
            Step9_7Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock9_8 == 1){
            Step9_8Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock10_1 == 1){
            Step10_1Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock10_2 == 1){
            Step10_2Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock10_3 == 1){
            Step10_3Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock10_4 == 1){
            Step10_4Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock10_5 == 1){
            Step10_5Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock10_6 == 1){
            Step10_6Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock10_7 == 1){
            Step10_7Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }
        if(lock10_8 == 1){
            Step10_8Button.setBackgroundResource(R.drawable.costom_menu_lock);
        }



        final LinearLayout Step1Ver = (LinearLayout) findViewById(R.id.Step1Ver);
        final LinearLayout Step2Ver = (LinearLayout) findViewById(R.id.Step2Ver);
        final LinearLayout Step3Ver = (LinearLayout) findViewById(R.id.Step3Ver);
        final LinearLayout Step4Ver = (LinearLayout) findViewById(R.id.Step4Ver);
        final LinearLayout Step5Ver = (LinearLayout) findViewById(R.id.Step5Ver);
        final LinearLayout Step6Ver = (LinearLayout) findViewById(R.id.Step6Ver);
        final LinearLayout Step7Ver = (LinearLayout) findViewById(R.id.Step7Ver);
        final LinearLayout Step8Ver = (LinearLayout) findViewById(R.id.Step8Ver);
        final LinearLayout Step9Ver = (LinearLayout) findViewById(R.id.Step9Ver);
        final LinearLayout Step10Ver = (LinearLayout) findViewById(R.id.Step10Ver);

        Step1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step1Ver.getVisibility() == View.GONE)
                    Step1Ver.setVisibility(View.VISIBLE);
                else
                    Step1Ver.setVisibility(View.GONE);
            }
        });

        Step2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Step2Ver.getVisibility() == View.GONE)
                    Step2Ver.setVisibility(View.VISIBLE);
                else
                    Step2Ver.setVisibility(View.GONE);
            }
        });
        Step3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step3Ver.getVisibility() == View.GONE)
                    Step3Ver.setVisibility(View.VISIBLE);
                else
                    Step3Ver.setVisibility(View.GONE);
            }
        });
        Step4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step4Ver.getVisibility() == View.GONE)
                    Step4Ver.setVisibility(View.VISIBLE);
                else
                    Step4Ver.setVisibility(View.GONE);
            }
        });
        Step5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step5Ver.getVisibility() == View.GONE)
                    Step5Ver.setVisibility(View.VISIBLE);
                else
                    Step5Ver.setVisibility(View.GONE);
            }
        });
        Step6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step6Ver.getVisibility() == View.GONE)
                    Step6Ver.setVisibility(View.VISIBLE);
                else
                    Step6Ver.setVisibility(View.GONE);
            }
        });
        Step7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step7Ver.getVisibility() == View.GONE)
                    Step7Ver.setVisibility(View.VISIBLE);
                else
                    Step7Ver.setVisibility(View.GONE);
            }
        });
        Step8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step8Ver.getVisibility() == View.GONE)
                    Step8Ver.setVisibility(View.VISIBLE);
                else
                    Step8Ver.setVisibility(View.GONE);
            }
        });
        Step9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step9Ver.getVisibility() == View.GONE)
                    Step9Ver.setVisibility(View.VISIBLE);
                else
                    Step9Ver.setVisibility(View.GONE);
            }
        });
        Step10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step10Ver.getVisibility() == View.GONE)
                    Step10Ver.setVisibility(View.VISIBLE);
                else
                    Step10Ver.setVisibility(View.GONE);
            }
        });

        TutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StepSelection.this,Tutorial.class);
                startActivity(intent);
            }
        });


        Step1_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StepSelection.this,GameLine2.class);
                intent.putExtra("Max",4);
                intent.putExtra("Answer","1_1");
                intent.putExtra("LV","1-1 단계");
                startActivity(intent);
            }
        });

        Step1_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_2");
                    intent.putExtra("LV","1-2 단계");
                    startActivity(intent);
                }
            }
        });

        Step1_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_3");
                    intent.putExtra("LV","1-3 단계");
                    startActivity(intent);
                }
            }
        });

        Step1_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_4");
                    intent.putExtra("LV","1-4 단계");
                    startActivity(intent);
                }
            }
        });

        Step1_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_5");
                    intent.putExtra("LV","1-5 단계");
                    startActivity(intent);
                }
            }
        });

        Step1_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_6");
                    intent.putExtra("LV","1-6 단계");
                    startActivity(intent);
                }
            }
        });

        Step1_7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_7 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_7 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_7");
                    intent.putExtra("LV","1-7 단계");
                    startActivity(intent);
                }
            }
        });

        Step1_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock1_8 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock1_8 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",4);
                    intent.putExtra("Answer","1_8");
                    intent.putExtra("LV","1-8 단계");
                    startActivity(intent);
                }
            }
        });

        Step2_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock2_1 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock2_1 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",5);
                    intent.putExtra("Answer","2_1");
                    intent.putExtra("LV","2-1 단계");
                    startActivity(intent);
                }
            }
        });

        Step2_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock2_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock2_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",5);
                    intent.putExtra("Answer","2_2");
                    intent.putExtra("LV","2-2 단계");
                    startActivity(intent);
                }
            }
        });

        Step2_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock2_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock2_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",5);
                    intent.putExtra("Answer","2_3");
                    intent.putExtra("LV","2-3 단계");
                    startActivity(intent);
                }
            }
        });

        Step2_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock2_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock2_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",5);
                    intent.putExtra("Answer","2_4");
                    intent.putExtra("LV","2-4 단계");
                    startActivity(intent);
                }
            }
        });

        Step2_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock2_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock2_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",5);
                    intent.putExtra("Answer","2_5");
                    intent.putExtra("LV","2-5 단계");
                    startActivity(intent);
                }
            }
        });
        Step2_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock2_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock2_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",5);
                    intent.putExtra("Answer","2_6");
                    intent.putExtra("LV","2-6 단계");
                    startActivity(intent);
                }
            }
        });
        Step2_7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock2_7 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock2_7 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",5);
                    intent.putExtra("Answer","2_7");
                    intent.putExtra("LV","2-7 단계");
                    startActivity(intent);
                }
            }
        });
        Step2_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock2_8 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock2_8 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",5);
                    intent.putExtra("Answer","2_8");
                    intent.putExtra("LV","2-8 단계");
                    startActivity(intent);
                }
            }
        });

        Step3_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock3_1 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock3_1 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",6);
                    intent.putExtra("Answer","3_1");
                    intent.putExtra("LV","3-1 단계");
                    startActivity(intent);
                }
            }
        });

        Step3_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock3_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock3_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",6);
                    intent.putExtra("Answer","3_2");
                    intent.putExtra("LV","3-2 단계");
                    startActivity(intent);
                }
            }
        });

        Step3_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock3_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock3_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",6);
                    intent.putExtra("Answer","3_3");
                    intent.putExtra("LV","3-3 단계");
                    startActivity(intent);
                }
            }
        });
        Step3_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock3_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock3_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",6);
                    intent.putExtra("Answer","3_4");
                    intent.putExtra("LV","3-4 단계");
                    startActivity(intent);
                }
            }
        });
        Step3_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock3_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock3_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",6);
                    intent.putExtra("Answer","3_5");
                    intent.putExtra("LV","3-5 단계");
                    startActivity(intent);
                }
            }
        });
        Step3_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock3_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock3_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",6);
                    intent.putExtra("Answer","3_6");
                    intent.putExtra("LV","3-6 단계");
                    startActivity(intent);
                }
            }
        });
        Step3_7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock3_7 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock3_7 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",6);
                    intent.putExtra("Answer","3_7");
                    intent.putExtra("LV","3-7 단계");
                    startActivity(intent);
                }
            }
        });
        Step3_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock3_8 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock3_8 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",6);
                    intent.putExtra("Answer","3_8");
                    intent.putExtra("LV","3-8 단계");
                    startActivity(intent);
                }
            }
        });

        Step4_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock4_1 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock4_1 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",7);
                    intent.putExtra("Answer","4_1");
                    intent.putExtra("LV","4-1 단계");
                    startActivity(intent);
                }
            }
        });
        Step4_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock4_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock4_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",7);
                    intent.putExtra("Answer","4_2");
                    intent.putExtra("LV","4-2 단계");
                    startActivity(intent);
                }
            }
        });
        Step4_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock4_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock4_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",7);
                    intent.putExtra("Answer","4_3");
                    intent.putExtra("LV","4-3 단계");
                    startActivity(intent);
                }
            }
        });
        Step4_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock4_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock4_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",7);
                    intent.putExtra("Answer","4_4");
                    intent.putExtra("LV","4-4 단계");
                    startActivity(intent);
                }
            }
        });
        Step4_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock4_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock4_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",7);
                    intent.putExtra("Answer","4_5");
                    intent.putExtra("LV","4-5 단계");
                    startActivity(intent);
                }
            }
        });
        Step4_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock4_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock4_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",7);
                    intent.putExtra("Answer","4_6");
                    intent.putExtra("LV","4-6 단계");
                    startActivity(intent);
                }
            }
        });
        Step4_7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock4_7 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock4_7 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",7);
                    intent.putExtra("Answer","4_7");
                    intent.putExtra("LV","4-7 단계");
                    startActivity(intent);
                }
            }
        });
        Step4_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock4_8 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock4_8 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",7);
                    intent.putExtra("Answer","4_8");
                    intent.putExtra("LV","4-8 단계");
                    startActivity(intent);
                }
            }
        });

        Step5_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock5_1 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock5_1 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine2.class);
                    intent.putExtra("Max",8);
                    intent.putExtra("Answer","5_1");
                    intent.putExtra("LV","5-1 단계");
                    startActivity(intent);
                }
            }
        });

        Step5_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock5_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock5_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",8);
                    intent.putExtra("Answer","5_2");
                    intent.putExtra("LV","5-2 단계");
                    startActivity(intent);
                }
            }
        });
        Step5_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock5_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock5_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",8);
                    intent.putExtra("Answer","5_3");
                    intent.putExtra("LV","5-3 단계");
                    startActivity(intent);
                }
            }
        });
        Step5_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock5_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock5_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",8);
                    intent.putExtra("Answer","5_4");
                    intent.putExtra("LV","5-4 단계");
                    startActivity(intent);
                }
            }
        });
        Step5_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock5_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock5_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",8);
                    intent.putExtra("Answer","5_5");
                    intent.putExtra("LV","5-5 단계");
                    startActivity(intent);
                }
            }
        });
        Step5_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock5_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock5_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",8);
                    intent.putExtra("Answer","5_6");
                    intent.putExtra("LV","5-6 단계");
                    startActivity(intent);
                }
            }
        });
        Step5_7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock5_7 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock5_7 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",8);
                    intent.putExtra("Answer","5_7");
                    intent.putExtra("LV","5-7 단계");
                    startActivity(intent);
                }
            }
        });
        Step5_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock5_8 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock5_8 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",8);
                    intent.putExtra("Answer","5_8");
                    intent.putExtra("LV","5-8 단계");
                    startActivity(intent);
                }
            }
        });

        Step6_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock6_1 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock6_1 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",9);
                    intent.putExtra("Answer","6_1");
                    intent.putExtra("LV","6-1 단계");
                    startActivity(intent);
                }
            }
        });
        Step6_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock6_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock6_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",9);
                    intent.putExtra("Answer","6_2");
                    intent.putExtra("LV","6-2 단계");
                    startActivity(intent);
                }
            }
        });
        Step6_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock6_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock6_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",9);
                    intent.putExtra("Answer","6_3");
                    intent.putExtra("LV","6-3 단계");
                    startActivity(intent);
                }
            }
        });
        Step6_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock6_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock6_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",9);
                    intent.putExtra("Answer","6_4");
                    intent.putExtra("LV","6-4 단계");
                    startActivity(intent);
                }
            }
        });
        Step6_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock6_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock6_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",9);
                    intent.putExtra("Answer","6_5");
                    intent.putExtra("LV","6-5 단계");
                    startActivity(intent);
                }
            }
        });
        Step6_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock6_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock6_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",9);
                    intent.putExtra("Answer","6_6");
                    intent.putExtra("LV","6-6 단계");
                    startActivity(intent);
                }
            }
        });
        Step6_7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock6_7 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock6_7 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",9);
                    intent.putExtra("Answer","6_7");
                    intent.putExtra("LV","6-7 단계");
                    startActivity(intent);
                }
            }
        });
        Step6_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock6_8 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock6_8 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine5.class);
                    intent.putExtra("Max",9);
                    intent.putExtra("Answer","6_8");
                    intent.putExtra("LV","6-8 단계");
                    startActivity(intent);
                }
            }
        });

        Step7_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock7_1 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock7_1 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",10);
                    intent.putExtra("Answer","7_1");
                    intent.putExtra("LV","7-1 단계");
                    startActivity(intent);
                }
            }
        });
        Step7_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock7_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock7_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",10);
                    intent.putExtra("Answer","7_2");
                    intent.putExtra("LV","7-2 단계");
                    startActivity(intent);
                }
            }
        });
        Step7_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock7_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock7_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",10);
                    intent.putExtra("Answer","7_3");
                    intent.putExtra("LV","7-3 단계");
                    startActivity(intent);
                }
            }
        });
        Step7_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock7_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock7_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",10);
                    intent.putExtra("Answer","7_4");
                    intent.putExtra("LV","7-4 단계");
                    startActivity(intent);
                }
            }
        });
        Step7_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock7_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock7_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",10);
                    intent.putExtra("Answer","7_5");
                    intent.putExtra("LV","7-5 단계");
                    startActivity(intent);
                }
            }
        });
        Step7_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock7_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock7_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",10);
                    intent.putExtra("Answer","7_6");
                    intent.putExtra("LV","7-6 단계");
                    startActivity(intent);
                }
            }
        });
        Step7_7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock7_7 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock7_7 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",10);
                    intent.putExtra("Answer","7_7");
                    intent.putExtra("LV","7-7 단계");
                    startActivity(intent);
                }
            }
        });
        Step7_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock7_8 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock7_8 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",10);
                    intent.putExtra("Answer","7_8");
                    intent.putExtra("LV","7-8 단계");
                    startActivity(intent);
                }
            }
        });

        Step8_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock8_1 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock8_1 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",11);
                    intent.putExtra("Answer","8_1");
                    intent.putExtra("LV","8-1 단계");
                    startActivity(intent);
                }
            }
        });
        Step8_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock8_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock8_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",11);
                    intent.putExtra("Answer","8_2");
                    intent.putExtra("LV","8-2 단계");
                    startActivity(intent);
                }
            }
        });
        Step8_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock8_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock8_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",11);
                    intent.putExtra("Answer","8_3");
                    intent.putExtra("LV","8-3 단계");
                    startActivity(intent);
                }
            }
        });
        Step8_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock8_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock8_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",11);
                    intent.putExtra("Answer","8_4");
                    intent.putExtra("LV","8-4 단계");
                    startActivity(intent);
                }
            }
        });
        Step8_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock8_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock8_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",11);
                    intent.putExtra("Answer","8_5");
                    intent.putExtra("LV","8-5 단계");
                    startActivity(intent);
                }
            }
        });
        Step8_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock8_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock8_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",11);
                    intent.putExtra("Answer","8_6");
                    intent.putExtra("LV","8-6 단계");
                    startActivity(intent);
                }
            }
        });
        Step8_7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock8_7 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock8_7 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine5.class);
                    intent.putExtra("Max",11);
                    intent.putExtra("Answer","8_5");
                    intent.putExtra("LV","8-5 단계");
                    startActivity(intent);
                }
            }
        });
        Step8_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock8_8 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock8_8 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",11);
                    intent.putExtra("Answer","8_8");
                    intent.putExtra("LV","8-8 단계");
                    startActivity(intent);
                }
            }
        });

        Step9_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock9_1 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock9_1 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",12);
                    intent.putExtra("Answer","9_1");
                    intent.putExtra("LV","9-1 단계");
                    startActivity(intent);
                }
            }
        });
        Step9_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock9_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock9_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",12);
                    intent.putExtra("Answer","9_2");
                    intent.putExtra("LV","9-2 단계");
                    startActivity(intent);
                }
            }
        });
        Step9_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock9_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock9_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",12);
                    intent.putExtra("Answer","9_3");
                    intent.putExtra("LV","9-3 단계");
                    startActivity(intent);
                }
            }
        });
        Step9_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock9_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock9_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",12);
                    intent.putExtra("Answer","9_4");
                    intent.putExtra("LV","9-4 단계");
                    startActivity(intent);
                }
            }
        });
        Step9_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock9_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock9_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",12);
                    intent.putExtra("Answer","9_5");
                    intent.putExtra("LV","9-5 단계");
                    startActivity(intent);
                }
            }
        });
        Step9_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock9_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock9_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",12);
                    intent.putExtra("Answer","9_6");
                    intent.putExtra("LV","9-6 단계");
                    startActivity(intent);
                }
            }
        });
        Step9_7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock9_7 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock9_7 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",12);
                    intent.putExtra("Answer","9_7");
                    intent.putExtra("LV","9-7 단계");
                    startActivity(intent);
                }
            }
        });
        Step9_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock9_8 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock9_8 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine5.class);
                    intent.putExtra("Max",12);
                    intent.putExtra("Answer","9_8");
                    intent.putExtra("LV","9-8 단계");
                    startActivity(intent);
                }
            }
        });

        Step10_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock10_1 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock10_1 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine3.class);
                    intent.putExtra("Max",13);
                    intent.putExtra("Answer","10_1");
                    intent.putExtra("LV","10-1 단계");
                    startActivity(intent);
                }
            }
        });
        Step10_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock10_2 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock10_2 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",13);
                    intent.putExtra("Answer","10_2");
                    intent.putExtra("LV","10-2 단계");
                    startActivity(intent);
                }
            }
        });
        Step10_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock10_3 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock10_3 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",13);
                    intent.putExtra("Answer","10_3");
                    intent.putExtra("LV","10-3 단계");
                    startActivity(intent);
                }
            }
        });
        Step10_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock10_4 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock10_4 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",13);
                    intent.putExtra("Answer","10_4");
                    intent.putExtra("LV","10-4 단계");
                    startActivity(intent);
                }
            }
        });
        Step10_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock10_5 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock10_5 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",13);
                    intent.putExtra("Answer","10_5");
                    intent.putExtra("LV","10-5 단계");
                    startActivity(intent);
                }
            }
        });
        Step10_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock10_6 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock10_6 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",13);
                    intent.putExtra("Answer","10_6");
                    intent.putExtra("LV","10-6 단계");
                    startActivity(intent);
                }
            }
        });
        Step10_7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock10_7 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock10_7 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine4.class);
                    intent.putExtra("Max",13);
                    intent.putExtra("Answer","10_7");
                    intent.putExtra("LV","10-7 단계");
                    startActivity(intent);
                }
            }
        });
        Step10_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lock10_8 == 1){
                    //잠금
                    Toast.makeText(StepSelection.this,"이전 단계를 먼저 성공하세요!",Toast.LENGTH_SHORT).show();
                }
                else if(lock10_8 == 0){
                    //해제
                    Intent intent = new Intent(StepSelection.this,GameLine5.class);
                    intent.putExtra("Max",13);
                    intent.putExtra("Answer","10_8");
                    intent.putExtra("LV","10-8 단계");
                    startActivity(intent);
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

    private void loadGameLockALL(){
        loadGameLock1_1();
        loadGameLock1_2();
        loadGameLock1_3();
        loadGameLock1_4();
        loadGameLock1_5();
        loadGameLock1_6();
        loadGameLock1_7();
        loadGameLock1_8();

        loadGameLock2_1();
        loadGameLock2_2();
        loadGameLock2_3();
        loadGameLock2_4();
        loadGameLock2_5();
        loadGameLock2_6();
        loadGameLock2_7();
        loadGameLock2_8();

        loadGameLock3_1();
        loadGameLock3_2();
        loadGameLock3_3();
        loadGameLock3_4();
        loadGameLock3_5();
        loadGameLock3_6();
        loadGameLock3_7();
        loadGameLock3_8();

        loadGameLock4_1();
        loadGameLock4_2();
        loadGameLock4_3();
        loadGameLock4_4();
        loadGameLock4_5();
        loadGameLock4_6();
        loadGameLock4_7();
        loadGameLock4_8();

        loadGameLock5_1();
        loadGameLock5_2();
        loadGameLock5_3();
        loadGameLock5_4();
        loadGameLock5_5();
        loadGameLock5_6();
        loadGameLock5_7();
        loadGameLock5_8();

        loadGameLock6_1();
        loadGameLock6_2();
        loadGameLock6_3();
        loadGameLock6_4();
        loadGameLock6_5();
        loadGameLock6_6();
        loadGameLock6_7();
        loadGameLock6_8();

        loadGameLock7_1();
        loadGameLock7_2();
        loadGameLock7_3();
        loadGameLock7_4();
        loadGameLock7_5();
        loadGameLock7_6();
        loadGameLock7_7();
        loadGameLock7_8();

        loadGameLock8_1();
        loadGameLock8_2();
        loadGameLock8_3();
        loadGameLock8_4();
        loadGameLock8_5();
        loadGameLock8_6();
        loadGameLock8_7();
        loadGameLock8_8();

        loadGameLock9_1();
        loadGameLock9_2();
        loadGameLock9_3();
        loadGameLock9_4();
        loadGameLock9_5();
        loadGameLock9_6();
        loadGameLock9_7();
        loadGameLock9_8();

        loadGameLock10_1();
        loadGameLock10_2();
        loadGameLock10_3();
        loadGameLock10_4();
        loadGameLock10_5();
        loadGameLock10_6();
        loadGameLock10_7();
        loadGameLock10_8();
    }

    private void loadGameLock1_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock1_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock1_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock1_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock2_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock2_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock2_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock2_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock3_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock3_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock3_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock3_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock4_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock4_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock4_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock4_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock5_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock5_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock5_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock5_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock6_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock6_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock6_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock6_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock7_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock7_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock7_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock7_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock8_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock8_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock8_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock8_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock9_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock9_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock9_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock9_8 = cursor.getInt(0);
            }
        }
    }

    private void loadGameLock10_1(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_1";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_1 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_2(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_2";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_2 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_3(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_3";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_3 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_4(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_4";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_4 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_5(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_5";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_5 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_6(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_6";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_6 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_7(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_7";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_7 = cursor.getInt(0);
            }
        }
    }
    private void loadGameLock10_8(){
        if(sqliteDB != null){
            String sqlQuery = "SELECT * FROM GameLock10_8";
            Cursor cursor = null;
            cursor = sqliteDB.rawQuery(sqlQuery,null);
            if(cursor.moveToNext()){
                lock10_8 = cursor.getInt(0);
            }
        }
    }
}
