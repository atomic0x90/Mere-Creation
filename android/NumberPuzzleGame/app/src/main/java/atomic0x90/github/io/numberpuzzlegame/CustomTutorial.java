package atomic0x90.github.io.numberpuzzlegame;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomTutorial extends AppCompatActivity {
    //Sound
    SoundPool soundPool;
    int soundID;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_tutorial);
//Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,R.raw.click_sound,1);

        TextView TutorialTopExplain = (TextView) findViewById(R.id.TutorialTopExplain);
        TextView TutorialMiddleExplain = (TextView) findViewById(R.id.TutorialMiddleExplain);
        TextView TutorialBottomExplain = (TextView) findViewById(R.id.TutorialBottomExplain);
        TextView TutorialAllExplain = (TextView) findViewById(R.id.TutorialAllExplain);

        TutorialTopExplain.setBackgroundColor(Color.TRANSPARENT);
        TutorialMiddleExplain.setBackgroundColor(Color.TRANSPARENT);
        TutorialBottomExplain.setBackgroundColor(Color.TRANSPARENT);
        TutorialAllExplain.setBackgroundColor(Color.TRANSPARENT);

        TutorialTopExplain.setText(
                "위에 버튼에서 숫자를 내려보내면 됩니다.\n" +
                "위에 버튼의 숫자는 차례대로 증가합니다.");

        TutorialMiddleExplain.setText(
                "숫자는 반드시 가운데 버튼을 지나서\n아래 버튼으로 내려갑니다."
        );

        TutorialBottomExplain.setText(
                "아래 버튼의 숫자 순서대로\n숫자를 내려보내면 됩니다."
        );

        TutorialAllExplain.setText(
                "내려간 숫자는 올라갈 수 없습니다.\n가운데 버튼끼리 숫자 이동은 안됩니다.\n가운데에서 내려보내려는 숫자가\n다음 차례의 숫자가 아니면 안 내려갑니다."
        );

        Button OKButton = (Button) findViewById(R.id.TutorialOKButton);
        OKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(soundID,1f,1f,0,0,1f);

                finish();
            }
        });

    }
    @Override
    public void onBackPressed(){
        //super.onBackPressed();
    }
}
