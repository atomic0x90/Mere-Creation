package atomic0x90.github.io.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class StepSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_selection);


        final Button Step1Button = (Button) findViewById(R.id.Step1Button);
        final Button Step2Button = (Button) findViewById(R.id.Step2Button);

        Button Step1_1Button = (Button) findViewById(R.id.Step1_1);
        Button Step1_2Button = (Button) findViewById(R.id.Step1_2);
        Button Step1_3Button = (Button) findViewById(R.id.Step1_3);
        Button Step1_4Button = (Button) findViewById(R.id.Step1_4);
        Button Step1_5Button = (Button) findViewById(R.id.Step1_5);
        Button Step1_6Button = (Button) findViewById(R.id.Step1_6);
        Button Step1_7Button = (Button) findViewById(R.id.Step1_7);
        Button Step1_8Button = (Button) findViewById(R.id.Step1_8);

        final LinearLayout Step1Ver = (LinearLayout) findViewById(R.id.Step1Ver);

        Step1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step1Ver.getVisibility() == View.GONE)
                    Step1Ver.setVisibility(View.VISIBLE);
                else
                    Step1Ver.setVisibility(View.GONE);
            }
        });


        Step1_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StepSelection.this,GameLine2.class);
                startActivity(intent);
            }
        });
    }
}
