package atomic0x90.github.io.jujeop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JJGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_j_game);

        final TextView textView = (TextView)findViewById(R.id.inputText);

        Button textButton1 = (Button)findViewById(R.id.TextButton1);
        textButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmpString = (String) textView.getText();
                tmpString += "test";
                textView.setText(tmpString);
            }
        });
    }

    // 마지막으로 뒤로 가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    private Toast toast;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        // 2500 milliseconds = 2.5 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 메인 화면으로 이동합니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            System.exit(0);
            startActivity(intent);
        }
    }
}
