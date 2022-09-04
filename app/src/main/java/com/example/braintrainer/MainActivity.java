package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int localOfCorrectAnswer;
    Button gobutton;
    TextView SumtextView1;
    ArrayList<Integer> ans=new ArrayList<Integer>();
    TextView result;
    int score=0;
    int numberOfQuestion;
    TextView scoreText;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView timer;
    Button playagain;

    public void playAgain(View view){
        score=0;
        numberOfQuestion=0;
        timer.setText("30s");
        scoreText.setText(Integer.toString(score)+"/"+ Integer.toString(numberOfQuestion));
        newQuestion();
        playagain.setVisibility(View.INVISIBLE);

        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                result.setText("Done!");
                playagain.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void start(View view){

        gobutton.setVisibility(View.INVISIBLE);
    }

    public void newQuestion(){
        Random rand=new Random();

        int a= rand.nextInt(21);
        int b= rand.nextInt(21);

        SumtextView1.setText(Integer.toString(a)+" + "+Integer.toString(b));

        localOfCorrectAnswer= rand.nextInt(4);

        ans.clear();

        for(int i=0;i<4;i++){
            if(i==localOfCorrectAnswer){
                ans.add(a+b);
            }else{
                int wrongAnswer= rand.nextInt(41);

                while (wrongAnswer==(a+b)) {
                    ans.add(rand.nextInt(21));
                }
                ans.add(wrongAnswer);
            }

        }
        button1.setText(Integer.toString(ans.get(0)));
        button2.setText(Integer.toString(ans.get(1)));
        button3.setText(Integer.toString(ans.get(2)));
        button4.setText(Integer.toString(ans.get(3)));

    }

    public void chooseAnswer(View view){
        if(Integer.toString(localOfCorrectAnswer).equals(view.getTag().toString())){
            result.setText("Correct");
            score++;
        }else{
            result.setText("Wrong");
        }
        numberOfQuestion++;
        scoreText.setText(Integer.toString(score)+"/"+ Integer.toString(numberOfQuestion));
        newQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gobutton=findViewById(R.id.button);
        SumtextView1=findViewById(R.id.textView3);
         button1=findViewById(R.id.button2);
         button2=findViewById(R.id.button3);
         button3=findViewById(R.id.button4);
         button4=findViewById(R.id.button5);
        result=findViewById(R.id.textView4);
        scoreText=findViewById(R.id.textView2);
        timer=findViewById(R.id.textView);
        playagain=findViewById(R.id.button6);

        playAgain(findViewById(R.id.textView));




    }
}