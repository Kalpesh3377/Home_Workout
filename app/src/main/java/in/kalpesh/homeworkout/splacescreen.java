package in.kalpesh.homeworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splacescreen extends AppCompatActivity {

    TextView tx1,tx2;
    ImageView imageView;
    Animation up,down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splacescreen);

        tx1=findViewById(R.id.appName);
        down= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        tx1.setAnimation(down);
        tx2=findViewById(R.id.appName2);
        tx2.setAnimation(down);
        imageView=findViewById(R.id.splash);
        up= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        imageView.setAnimation(up);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },3500);

    }
}