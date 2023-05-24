package in.kalpesh.homeworkout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class secondActivity2 extends AppCompatActivity {
    int[] array;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        array=new int[]{
                R.id.pose,R.id.pose2,R.id.pose3,R.id.pose4,R.id.pose5,R.id.pose6,R.id.pose7,R.id.pose8,R.id.pose9,R.id.pose10,R.id.pose11,R.id.pose12,R.id.pose13,R.id.pose14,R.id.pose15
        };
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

    public void imageButton(View view) {
        for(int i=0;i<array.length;i++){
            if(view.getId()==array[i]){
                int value=i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent=new Intent(secondActivity2.this, thirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }
    }
}