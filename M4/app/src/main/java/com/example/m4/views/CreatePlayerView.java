package com.example.m4.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;

import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import com.example.m4.R;
import com.example.m4.model.Universe;
import com.example.m4.viewmodels.ConfigurationViewModel;
import com.example.m4.model.Player;


public class CreatePlayerView extends AppCompatActivity implements OnClickListener {

    private ConfigurationViewModel viewModel;

    private TextView name;
    private TextView difficulty;
    private TextView ship;
    private TextView credit;


    private TextView pilot;
    private TextView fighter;
    private TextView trader;
    private TextView engineer;

    private Button create_universe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createplayer);
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        name = findViewById(R.id.player_name);
        difficulty = findViewById(R.id.player_difficulty);
        ship = findViewById(R.id.player_ship);
        credit = findViewById(R.id.player_credit);

        pilot = findViewById(R.id.player_pilot);
        fighter = findViewById(R.id.player_fighter);
        trader = findViewById(R.id.player_trader);
        engineer = findViewById(R.id.player_engineer);

        name.setText(Player.repo.get("Name"));
        difficulty.setText(Player.repo.get("Difficulty"));
        ship.setText(Player.repo.get("Ship"));
        credit.setText(Player.repo.get("Credits"));

        pilot.setText(Player.repo.get("Pilot Points"));
        fighter.setText(Player.repo.get("Fighter Points"));
        trader.setText(Player.repo.get("Trader Points"));
        engineer.setText(Player.repo.get("Engineer Points"));

        create_universe = findViewById(R.id.create_universe_button);
        create_universe.setOnClickListener(this);

    }

    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.create_universe_button) {
            startActivity(new Intent(this, UniverseView.class));
        }
    }
}
