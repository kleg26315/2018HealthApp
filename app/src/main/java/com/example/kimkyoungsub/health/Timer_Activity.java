package com.example.kimkyoungsub.health;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Timer_Activity extends Activity{

    EditText edit1;
    Button button1,button2,musicOn,musicOff;
    int m=0;
    TextView countTxt;
    RadioGroup radioGroup1;
    MediaPlayer mp;
    boolean isPlaying = false;
    RadioButton rd1,rd2,rd3;
    String remain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_layout);
        edit1 = (EditText) findViewById(R.id.edit1);
        radioGroup1 = (RadioGroup)findViewById(R.id.raidoGroup1);
        rd1 = (RadioButton)findViewById(R.id.radio0);
        rd2=(RadioButton)findViewById(R.id.radio1);
        rd3=(RadioButton)findViewById(R.id.radio2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        musicOn=(Button)findViewById(R.id.musicOn);
        musicOff=(Button)findViewById(R.id.musicOff);
        final RadioGroup rg = (RadioGroup)findViewById(R.id.raidoGroup1);

        Button.OnClickListener listener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.edit1);
                m = Integer.parseInt("" + edit1.getText());
                countTxt = (TextView)findViewById(R.id.count_txt);
                countDownTimer();
                countDownTimer.start();

            }
        };

        button1.setOnClickListener(listener);
        button2.setOnClickListener(stoplistener);



        musicOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rg.getCheckedRadioButtonId()==R.id.radio0){
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.sugarcut);
                    mp.setLooping(true);
                    mp.start();
                }
                else if(rg.getCheckedRadioButtonId()==R.id.radio1){
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.havanacut);
                    mp.setLooping(true);
                    mp.start();
                }
                else if(rg.getCheckedRadioButtonId()==R.id.radio2){
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.thundercut);
                    mp.setLooping(true);
                    mp.start();
                }
            }
        });
        musicOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPlaying = false;
                mp.stop();
                mp.release();
            }
        });
    }


    int count = m;
    private CountDownTimer countDownTimer;
    public void countDownTimer () {
        countDownTimer = new CountDownTimer(m*1000,1000) {
            public void onTick(long millisUntilFinished) {
                if (m>0) {
                    countTxt.setText(String.valueOf(m));
                    m--;
                }
                else{
                    onFinish();
                }
            }
            public void onFinish() {
                countTxt.setText(String.valueOf("Finish"));
                Toast.makeText(getApplicationContext(),"타이머가 종료되었습니다!",Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
        try {
            countDownTimer.cancel();
            String remain = Integer.toString(m+1);
            edit1.setText(remain);
        } catch (Exception e) {
        }
        countDownTimer = null;
    }

    Button.OnClickListener stoplistener = new Button.OnClickListener() {
        public void onClick(View v) {
            onDestroy();
        }
    };
}


