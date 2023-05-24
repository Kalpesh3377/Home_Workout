package in.kalpesh.homeworkout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn1=findViewById(R.id.activity1);
        btn2=findViewById(R.id.activity2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,secondActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,secondActivity2.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.privacy){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://pages.flycricket.io/home-workout-6/privacy.html"));
            startActivity(intent);
            return true;
        }if(id==R.id.term){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://pages.flycricket.io/home-workout-6/privacy.html"));
            startActivity(intent);
            return true;
        }if(id==R.id.rate){
            try{
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id="+getPackageName())));
            }
            catch (Exception e){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));

            }
            return true;
        }if(id==R.id.apps){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName()));
            startActivity(intent);
            return true;
        }if(id==R.id.share){

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareBody="This is the best app for daily workout \n By this app you maintain your figure\n"+"https://play.google.com/store/apps/details?id="+getPackageName()+"&h1=en";
            String sharehub="Home Workout";
            intent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            intent.putExtra(Intent.EXTRA_TEXT,shareBody);
            startActivity(Intent.createChooser(intent,"share using"));
            return true;
        }
        return true;
    }

    public void beforeage18(View view) {
        Intent intent=new Intent(MainActivity.this,secondActivity.class);
        startActivity(intent);
    }

    public void afterage18(View view) {
        Intent intent=new Intent(MainActivity.this,secondActivity2.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent=new Intent(MainActivity.this,foodActivity.class);
        startActivity(intent);
    }
}