package com.example.m4.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m4.R;

/**
 * View class that shows random events occurring when traveling between regions
 */

public class RandomEventView extends AppCompatActivity implements View.OnClickListener {

    private TextView travelMessage;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomevent);

        travelMessage = findViewById(R.id.travel_message);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);

        travelMessage.setText("After an eventful trip,\nyou couldn't arrive at your destination :(\n\nTry again");

    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            startActivity(new Intent(this, UniverseView.class));
        }

    }

}
