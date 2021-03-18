package com.example.destini;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTopButton;
    private Button mBottomButton;
    private TextView mStoryTextView;
    private int mIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTopButton = findViewById(R.id.topButton);
        mBottomButton = findViewById(R.id.bottomButton);
        mStoryTextView = findViewById(R.id.storyTextView);

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndex == 1){
                    mStoryTextView.setText(R.string.T3_Story);
                    mTopButton.setText(R.string.T3_Ans1);
                    mBottomButton.setText(R.string.T3_Ans2);
                    mIndex = 3;
                }else if(mIndex == 3){
                    mStoryTextView.setText(R.string.T6_End);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                    restart();


                }else if(mIndex == 2){
                    mStoryTextView.setText(R.string.T3_Story);
                    mTopButton.setText(R.string.T3_Ans1);
                    mBottomButton.setText(R.string.T3_Ans2);
                    mIndex = 3;

                }else{
                    Toast.makeText(getApplicationContext(),"Somthing went Wrong", Toast.LENGTH_SHORT).show();

                }
            }
        });

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndex == 1){
                    mStoryTextView.setText(R.string.T2_Story);
                    mTopButton.setText(R.string.T2_Ans1);
                    mBottomButton.setText(R.string.T2_Ans2);
                    mIndex = 2;
                }else if(mIndex == 3){
                    mStoryTextView.setText(R.string.T5_End);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                    restart();

                }else if(mIndex == 2){
                    mStoryTextView.setText(R.string.T4_End);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                    restart();


                }else{
                    Toast.makeText(getApplicationContext(),"Somthing went Wrong", Toast.LENGTH_SHORT).show();

                }
            }
        });




    }

    public void restart(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this).setTitle("End of Story")
                .setMessage("Try again for a different ending!")
                .setCancelable(false)
                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                playAgain();


            }
        }).setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        alert.show();
    }

    public void playAgain(){
        mStoryTextView.setText(R.string.T1_Story);
        mTopButton.setText(R.string.T1_Ans1);
        mTopButton.setVisibility(View.VISIBLE);
        mBottomButton.setText(R.string.T1_Ans2);
        mBottomButton.setVisibility(View.VISIBLE);
        mIndex = 1;

    }
}
