package com.example.m4.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.m4.R;
import com.example.m4.model.Player;
import com.example.m4.viewmodels.ConfigurationViewModel;


public class CreatePlayerView extends AppCompatActivity {

    private ConfigurationViewModel viewModel;

    private TextView name;
    private TextView difficulty;
    private TextView ship;
    private TextView credit;


    private TextView pilot;
    private TextView fighter;
    private TextView trader;
    private TextView engineer;



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

        name.setText(Player.repo.get(0));
        difficulty.setText(Player.repo.get(1));
        ship.setText(Player.repo.get(2));
        credit.setText(Player.repo.get(3));

        pilot.setText(Player.repo.get(4));
        fighter.setText(Player.repo.get(5));
        trader.setText(Player.repo.get(6));
        engineer.setText(Player.repo.get(7));

    }
}
