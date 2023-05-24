package in.kalpesh.homeworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class thirdActivity2 extends AppCompatActivity {
    String buttonSelect;
    Button startbtn;
    private CountDownTimer countDownTimer;
    TextView mTextview;
    private boolean MRunningTime;
    private long MleftTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);

        Intent intent =getIntent();
        buttonSelect=intent.getStringExtra("value");
        int value=Integer.valueOf(buttonSelect);

        switch (value){
            case 1:
                setContentView(R.layout.activity_pose_2);
                break;
            case 2:
                setContentView(R.layout.activity_pose2_2);
                break;
            case 3:
                setContentView(R.layout.activity_pose3_2);
                break;
            case 4:
                setContentView(R.layout.activity_pose4_2);
                break;
            case 5:
                setContentView(R.layout.activity_pose5_2);
                break;
            case 6:
                setContentView(R.layout.activity_pose6_2);
                break;
            case 7:
                setContentView(R.layout.activity_pose7_2);
                break;
            case 8:
                setContentView(R.layout.activity_pose8_2);
                break;
            case 9:
                setContentView(R.layout.activity_pose9_2);
                break;
            case 10:
                setContentView(R.layout.activity_pose10_2);
                break;
            case 11:
                setContentView(R.layout.activity_pose11_2);
                break;
            case 12:
                setContentView(R.layout.activity_pose12_2);
                break;
            case 13:
                setContentView(R.layout.activity_pose13_2);
                break;
            case 14:
                setContentView(R.layout.activity_pose14_2);
                break;
            case 15:
                setContentView(R.layout.activity_pose15_2);
                break;
        }
        startbtn =findViewById(R.id.startButton);
        mTextview=findViewById(R.id.time);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MRunningTime){
                    stopTimer();
                }
                else{
                    startTimer();
                }
            }
        });
    }
    private void stopTimer(){
        countDownTimer.cancel();
        MRunningTime=false;
        startbtn.setText("START");

    }
    private void startTimer(){
        final CharSequence value1=mTextview.getText();
        String num1=value1.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);

        final int number=Integer.valueOf(num2)*60+Integer.valueOf(num3);
        MleftTime=number*1000;
        countDownTimer =new CountDownTimer(MleftTime,1000) {
            @Override
            public void onTick(long l) {
                MleftTime=l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                int newval=Integer.valueOf(buttonSelect)+1;
                if(newval<=7){
                    Intent intent=new Intent(thirdActivity2.this,thirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newval));
                    startActivity(intent);
                }
                else{
                    newval=1;
                    Intent intent=new Intent(thirdActivity2.this,thirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newval));
                    startActivity(intent);
                }
            }
        }.start();
        startbtn.setText("Pause");
        MRunningTime=true;
    }
    private void updateTimer(){
        int minutes=(int) MleftTime/60000;
        int seconds=(int) MleftTime%60000/1000;
        String timelefttext="";
        if(minutes<10){
            timelefttext="0";
        }
        timelefttext=timelefttext+minutes+":";
        if(seconds<10)
            timelefttext+="0";
        timelefttext+=seconds;
        mTextview.setText(timelefttext);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}