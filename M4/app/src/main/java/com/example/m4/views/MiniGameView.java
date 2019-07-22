package com.example.m4.views;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.m4.R;

/**
 * Minigame view that will depict the minigame we are playing
 */
public class MiniGameView extends AppCompatActivity implements View.OnClickListener {

    ImageView input, output;
    Button terran, protoss, zerg;
    int[] images = new int[]{
            R.mipmap.terran,
            R.mipmap.protoss,
            R.mipmap.zerg
    };
    int userInput = 0;
    private int winCount;
    private int loseCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minigame);

        input = (ImageView) findViewById(R.id.iv_input);
        output = (ImageView) findViewById(R.id.iv_output);
        terran = (Button) findViewById(R.id.btn_terran);
        protoss = (Button) findViewById(R.id.btn_protoss);
        zerg = (Button) findViewById(R.id.btn_zerg);

        terran.setOnClickListener(this);
        protoss.setOnClickListener(this);
        zerg.setOnClickListener(this);
        winCount = 0;
        loseCount = 0;



    }

    @Override
    public void onClick (View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_terran:
                if (loseCount != 5) {
                    userInput = 1;
                    input.setBackgroundResource(R.mipmap.terran);
                    setOutput();
                } else {
                    userInput = 1;
                    input.setBackgroundResource(R.mipmap.terran1);
                    setOutput();
                }
                break;
            case R.id.btn_protoss:
                if (loseCount != 5) {
                    userInput = 2;
                    input.setBackgroundResource(R.mipmap.protoss);
                    setOutput();
                } else {
                    userInput = 2;
                    input.setBackgroundResource(R.mipmap.protoss1);
                    setOutput();
                }
                break;
            case R.id.btn_zerg:
                if (loseCount != 5) {
                    userInput = 3;
                    input.setBackgroundResource(R.mipmap.zerg);
                    setOutput();
                } else {
                    userInput = 3;
                    input.setBackgroundResource(R.mipmap.zerg1);
                    setOutput();
                }
                break;
        }

    }

    private void setOutput() {
        int i = (int) (Math.random() * images.length);
        output.setBackgroundResource(images[i]);
        checkResult(i);
    }

    private void checkResult(int i) {
        if (userInput == 1 && i == 0) {
            showResult(2);
        } else if (userInput == 1 && i == 1) {
            showResult(0);
        } else if (userInput == 1 && i == 2) {
            showResult(1);
        } else if (userInput == 2 && i == 0) {
            showResult(1);
        } else if (userInput == 2 && i == 1) {
            showResult(2);
        } else if (userInput == 2 && i == 2) {
            showResult(0);
        } else if (userInput == 3 && i == 0) {
            showResult(0);
        } else if (userInput == 3 && i == 1) {
            showResult(1);
        } else if (userInput == 3 && i == 2) {
            showResult(2);
        }
    }

    private void showResult(int result) {
        if (result == 0) {
            if (loseCount != 5) {
                Toast.makeText(getApplicationContext(), "You Lost", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "You Lost 5 five times :(", Toast.LENGTH_SHORT).show();
                loseCount = 0;
            }
        } else if (result == 1) {
            if (winCount != 5) {
                Toast.makeText(getApplicationContext(), "You Won!", Toast.LENGTH_SHORT).show();
                winCount ++;
            } else {
                Toast.makeText(getApplicationContext(), "Great job, You won 5 times! :D", Toast.LENGTH_SHORT).show();
                winCount = 0;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Tie", Toast.LENGTH_SHORT).show();
        }
    }
}
