package atomic0x90.github.io.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

public class Multiplication_table extends AppCompatActivity {

    //AD
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_table);

        //AD

        mAdView = findViewById(R.id.adView12);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        TextView t1 = (TextView) findViewById(R.id.mulTable1);
        TextView t2 = (TextView) findViewById(R.id.mulTable2);
        TextView t3 = (TextView) findViewById(R.id.mulTable3);
        TextView t4 = (TextView) findViewById(R.id.mulTable4);
        TextView t5 = (TextView) findViewById(R.id.mulTable5);
        TextView t6 = (TextView) findViewById(R.id.mulTable6);
        TextView t7 = (TextView) findViewById(R.id.mulTable7);
        TextView t8 = (TextView) findViewById(R.id.mulTable8);
        TextView t9 = (TextView) findViewById(R.id.mulTable9);
        TextView t10 = (TextView) findViewById(R.id.mulTable10);
        TextView t11 = (TextView) findViewById(R.id.mulTable11);
        TextView t12 = (TextView) findViewById(R.id.mulTable12);
        TextView t13 = (TextView) findViewById(R.id.mulTable13);
        TextView t14 = (TextView) findViewById(R.id.mulTable14);
        TextView t15 = (TextView) findViewById(R.id.mulTable15);
        TextView t16 = (TextView) findViewById(R.id.mulTable16);
        TextView t17 = (TextView) findViewById(R.id.mulTable17);
        TextView t18 = (TextView) findViewById(R.id.mulTable18);
        TextView t19 = (TextView) findViewById(R.id.mulTable19);

        t1.setText("1단");
        t2.setText("2단");
        t3.setText("3단");
        t4.setText("4단");
        t5.setText("5단");
        t6.setText("6단");
        t7.setText("7단");
        t8.setText("8단");
        t9.setText("9단");
        t10.setText("10단");
        t11.setText("11단");
        t12.setText("12단");
        t13.setText("13단");
        t14.setText("14단");
        t15.setText("15단");
        t16.setText("16단");
        t17.setText("17단");
        t18.setText("18단");
        t19.setText("19단");

        TextView a1 = (TextView) findViewById(R.id.tableAnswer1);
        TextView a2 = (TextView) findViewById(R.id.tableAnswer2);
        TextView a3 = (TextView) findViewById(R.id.tableAnswer3);
        TextView a4 = (TextView) findViewById(R.id.tableAnswer4);
        TextView a5 = (TextView) findViewById(R.id.tableAnswer5);
        TextView a6 = (TextView) findViewById(R.id.tableAnswer6);
        TextView a7 = (TextView) findViewById(R.id.tableAnswer7);
        TextView a8 = (TextView) findViewById(R.id.tableAnswer8);
        TextView a9 = (TextView) findViewById(R.id.tableAnswer9);
        TextView a10 = (TextView) findViewById(R.id.tableAnswer10);
        TextView a11 = (TextView) findViewById(R.id.tableAnswer11);
        TextView a12 = (TextView) findViewById(R.id.tableAnswer12);
        TextView a13 = (TextView) findViewById(R.id.tableAnswer13);
        TextView a14 = (TextView) findViewById(R.id.tableAnswer14);
        TextView a15 = (TextView) findViewById(R.id.tableAnswer15);
        TextView a16 = (TextView) findViewById(R.id.tableAnswer16);
        TextView a17 = (TextView) findViewById(R.id.tableAnswer17);
        TextView a18 = (TextView) findViewById(R.id.tableAnswer18);
        TextView a19 = (TextView) findViewById(R.id.tableAnswer19);

        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String s8 = "";
        String s9 = "";
        String s10 = "";
        String s11 = "";
        String s12 = "";
        String s13 = "";
        String s14 = "";
        String s15 = "";
        String s16 = "";
        String s17 = "";
        String s18 = "";
        String s19 = "";

        for(int i = 1;i < 20;i++)
            s1 += 1+" X "+i+" = "+1*i+"\n";
        for(int i = 1;i < 20;i++)
            s2 += 2+" X "+i+" = "+2*i+"\n";
        for(int i = 1;i < 20;i++)
            s3 += 3+" X "+i+" = "+3*i+"\n";
        for(int i = 1;i < 20;i++)
            s4 += 4+" X "+i+" = "+4*i+"\n";
        for(int i = 1;i < 20;i++)
            s5 += 5+" X "+i+" = "+5*i+"\n";
        for(int i = 1;i < 20;i++)
            s6 += 6+" X "+i+" = "+6*i+"\n";
        for(int i = 1;i < 20;i++)
            s7 += 7+" X "+i+" = "+7*i+"\n";
        for(int i = 1;i < 20;i++)
            s8 += 8+" X "+i+" = "+8*i+"\n";
        for(int i = 1;i < 20;i++)
            s9 += 9+" X "+i+" = "+9*i+"\n";
        for(int i = 1;i < 20;i++)
            s10 += 10+" X "+i+" = "+10*i+"\n";
        for(int i = 1;i < 20;i++)
            s11 += 11+" X "+i+" = "+11*i+"\n";
        for(int i = 1;i < 20;i++)
            s12 += 12+" X "+i+" = "+12*i+"\n";
        for(int i = 1;i < 20;i++)
            s13 += 13+" X "+i+" = "+13*i+"\n";
        for(int i = 1;i < 20;i++)
            s14 += 14+" X "+i+" = "+14*i+"\n";
        for(int i = 1;i < 20;i++)
            s15 += 15+" X "+i+" = "+15*i+"\n";
        for(int i = 1;i < 20;i++)
            s16 += 16+" X "+i+" = "+16*i+"\n";
        for(int i = 1;i < 20;i++)
            s17 += 17+" X "+i+" = "+17*i+"\n";
        for(int i = 1;i < 20;i++)
            s18 += 18+" X "+i+" = "+18*i+"\n";
        for(int i = 1;i < 20;i++)
            s19 += 19+" X "+i+" = "+19*i+"\n";


        a1.setText(s1);
        a2.setText(s2);
        a3.setText(s3);
        a4.setText(s4);
        a5.setText(s5);
        a6.setText(s6);
        a7.setText(s7);
        a8.setText(s8);
        a9.setText(s9);
        a10.setText(s10);
        a11.setText(s11);
        a12.setText(s12);
        a13.setText(s13);
        a14.setText(s14);
        a15.setText(s15);
        a16.setText(s16);
        a17.setText(s17);
        a18.setText(s18);
        a19.setText(s19);

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
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
