package in.kalpesh.homeworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class foodActivity extends AppCompatActivity {
    ListView listView;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        String[] tstory=getResources().getStringArray(R.array.title_list);
        final String[] dstory=getResources().getStringArray(R.array.detailed_tip);
        listView=findViewById(R.id.list);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.row,R.id.rowtext,tstory);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String t=dstory[position];
                Intent intent =new Intent(foodActivity.this,foodActivityDetail.class);
                intent.putExtra("story",t);
                startActivity(intent);
            }
        });
    }



    public void goBackFromFood(View view) {
//        Intent intent=new Intent(foodActivity.this,MainActivity.class);
//        startActivity(intent);
//        finish();
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
//        Intent intent=new Intent(foodActivity.this,MainActivity.class);
//        startActivity(intent);
//        finish();
        super.onBackPressed();
    }
}