package atomic0x90.github.io.numberpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GameLine2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_line2);


        final Button TopButton = (Button) findViewById(R.id.Line2TopButton);
        Button MiddleButton1 = (Button) findViewById(R.id.Line2MiddleButton1);
        Button MiddleButton2 = (Button) findViewById(R.id.Line2MiddleButton2);
        Button BottomButton = (Button) findViewById(R.id.Line2BottomButton);

        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TopButton.isSelected()) //선택 안됐을 때
                {
                    //TopButton.setPressed(true);
                    TopButton.setSelected(true);
                }
                else
                    TopButton.setSelected(false);
                    //TopButton.setPressed(false);
            }
        });
    }
}
