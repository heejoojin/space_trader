package com.example.m4.views;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.graphics.*;

import com.example.m4.R;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button open;
    private Button exit;
    private Button minigame;

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open = findViewById(R.id.main_start_button);
        open.setOnClickListener(this);

        exit = findViewById(R.id.main_exit_button);
        exit.setOnClickListener(this);

        title = findViewById(R.id.game_title_view);

        title.getPaint().setStrokeWidth(5);
        title.getPaint().setStyle(Paint.Style.STROKE);

        minigame = findViewById(R.id.minigame_button);
        minigame.setOnClickListener(this);
    }


    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.main_start_button) {
            startActivity(new Intent(MainActivity.this, ConfigurationView.class));
        } else if (v.getId() == R.id.main_exit_button) {
            System.exit(0);
        } else if (v.getId() == R.id.minigame_button) {
            startActivity(new Intent(MainActivity.this, MiniGameView.class));
        }
    }
}