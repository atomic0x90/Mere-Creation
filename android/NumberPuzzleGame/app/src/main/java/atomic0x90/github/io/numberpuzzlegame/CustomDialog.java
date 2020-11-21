package atomic0x90.github.io.numberpuzzlegame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog{
    private Context mContext;

    public CustomDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }
    //Sound
    SoundPool soundPool;
    int soundID;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog1);

        DisplayMetrics dm = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int) (dm.widthPixels*0.9);
        lp.height = (int) (dm.heightPixels*0.3);

        getWindow().setAttributes(lp);


        //Sound
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(getContext(),R.raw.click_sound,1);

        Button costomButton = (Button) findViewById(R.id.costomDialogButton);
        costomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(soundID,1f,1f,0,0,1f);

                CustomDialog.this.dismiss();
                ((Activity)mContext).finish();
            }
        });
    }
}
