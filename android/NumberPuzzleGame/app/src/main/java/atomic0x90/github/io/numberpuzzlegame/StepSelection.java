package atomic0x90.github.io.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StepSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_selection);


        Button Step1Button = (Button) findViewById(R.id.Step1Button);
        final Button Step2Button = (Button) findViewById(R.id.Step2Button);
        Step1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(Step2Button.getVisibility() == View.GONE)
                    Step2Button.setVisibility(View.VISIBLE);
                else
                    Step2Button.setVisibility(View.GONE);
            }
        });
    }
}
