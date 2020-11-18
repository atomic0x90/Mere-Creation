package atomic0x90.github.io.numberpuzzlegame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CostomDialog extends Dialog{
    private Context mContext;

    public CostomDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costom_dialog);

        Button costomButton = (Button) findViewById(R.id.costomDialogButton);
        costomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CostomDialog.this.dismiss();
                ((Activity)mContext).finish();
            }
        });
    }
}
