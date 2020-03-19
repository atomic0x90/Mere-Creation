package atomic0x90.github.io.mathgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class loding_screen extends Activity {

    @Override
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);

        try{
            Thread.sleep(1500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
