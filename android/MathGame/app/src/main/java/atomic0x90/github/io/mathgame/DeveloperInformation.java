package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;


public class DeveloperInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_information);

        TextView emailText = (TextView)findViewById(R.id.DeveloperEmailadd);
        Linkify.addLinks(emailText,Linkify.EMAIL_ADDRESSES);

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
