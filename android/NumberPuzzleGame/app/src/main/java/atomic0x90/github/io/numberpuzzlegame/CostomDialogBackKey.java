package atomic0x90.github.io.numberpuzzlegame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CostomDialogBackKey extends Dialog {
    private Context mContext;

    public CostomDialogBackKey(@NonNull Context context) {
        super(context);
        mContext = context;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costom_dialog_back_key);


//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        DisplayMetrics dm = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int) (dm.widthPixels*0.9);
        lp.height = (int) (dm.heightPixels*0.3);

        getWindow().setAttributes(lp);

        Button costomButtonPositive = (Button) findViewById(R.id.costomDialogBackKeyPositiveButton);
        Button costomButtonNegative = (Button) findViewById(R.id.costomDialogBackKeyNegativeButton);

        costomButtonPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CostomDialogBackKey.this.dismiss();
                ((Activity)mContext).finish();
            }
        });
        costomButtonNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CostomDialogBackKey.this.dismiss();
            }
        });
    }
}
