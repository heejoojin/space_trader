package com.example.m4.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m4.R;

public class TravelView extends AppCompatActivity implements View.OnClickListener {

    private TextView travelMessage;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        travelMessage = findViewById(R.id.travel_message);
        nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {}
}
