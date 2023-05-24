package in.kalpesh.homeworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class foodActivityDetail extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);



        textView=findViewById(R.id.text);

        String dstory=getIntent().getStringExtra("story");
        textView.setText(dstory);
    }

    public void goBackFromFoodDetail(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}