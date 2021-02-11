package atomic0x90.github.io.colorsortgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Game_4_4.class);
                startActivity(intent);
            }
        });

        Button button1 = (Button) findViewById(R.id.button17);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Game_5_5.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.GameStartButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StepSelection.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_bottom,R.anim.slide_out_top);
            }
        });
    }
}
