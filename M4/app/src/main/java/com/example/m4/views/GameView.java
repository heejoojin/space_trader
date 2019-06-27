package com.example.m4.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.m4.R;
import com.example.m4.model.Player;

public class GameView extends AppCompatActivity {

    private TextView selectedRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        selectedRegion = findViewById(R.id.selected_region_view);
        selectedRegion.setText(Player.repo.get("Region"));

    }
}
