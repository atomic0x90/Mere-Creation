package atomic0x90.github.io.numberpuzzlegame;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class BGMService extends Service {

    public MediaPlayer mp;
    private final IBinder mBinder = new ReturnBinder();

    public class ReturnBinder extends Binder {
        ReturnBinder getService(){
            return ReturnBinder.this;
        }
    }

    @Override
    public void onCreate(){
        System.out.println("service onCreate");
    }

    @Override
    public boolean onUnbind(Intent intent){
        System.out.println("service unbinded");
        Toast.makeText(this,"service unbinded ",Toast.LENGTH_SHORT).show();
        if(mp.isPlaying())
            mp.stop();
        return true;
    }

    @Override
    public void onDestroy(){

    }
    @Override
    public IBinder onBind(Intent intent){
        Toast.makeText(this,"service binded()",Toast.LENGTH_SHORT).show();
        System.out.println("service binded()");

        // 서비스에서 가장 먼저 호출됨(최초에 한번만)
        Log.d("test", "서비스의 onBind");
        mp = MediaPlayer.create(this, R.raw.bgm);
        mp.setLooping(true); // 반복재생
        mp.start();
        return mBinder;
    }
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.e("Error","onTaskRemoved - 강제 종료 " + rootIntent);
        stopSelf();
    }
}
