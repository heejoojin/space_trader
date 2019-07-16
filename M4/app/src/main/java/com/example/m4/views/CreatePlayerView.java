package com.example.m4.views;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;

import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import com.example.m4.R;
import com.example.m4.repository.Repository;

/**
 * Create player view that sets up the UI for the player creation
 */

@SuppressWarnings({"FeatureEnvy", "ChainedMethodCall"})
public class CreatePlayerView extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createplayer);
//        ConfigurationViewModel viewModel =
//        ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        TextView name = findViewById(R.id.player_name);
        TextView difficulty = findViewById(R.id.player_difficulty);
        TextView ship = findViewById(R.id.player_ship);
        TextView credit = findViewById(R.id.player_credit);

        TextView pilot = findViewById(R.id.player_pilot);
        TextView fighter = findViewById(R.id.player_fighter);
        TextView trader = findViewById(R.id.player_trader);
        TextView engineer = findViewById(R.id.player_engineer);

        name.setText(Repository.playerClass.getName());
        difficulty.setText(Repository.playerClass.getDifficulty().toString());
        ship.setText(Repository.playerClass.getShip());
        credit.setText(String.valueOf(Repository.playerClass.getCredits()));

        pilot.setText(String.valueOf(Repository.playerClass.getPilotPoints()));
        fighter.setText(String.valueOf(Repository.playerClass.getFighterPoints()));
        trader.setText(String.valueOf(Repository.playerClass.getTraderPoints()));
        engineer.setText(String.valueOf(Repository.playerClass.getEngineerPoints()));

        Button create_universe = findViewById(R.id.create_universe_button);
        create_universe.setOnClickListener(this);

    }

    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.create_universe_button) {

            startActivity(new Intent(this, UniverseView.class));
        }
    }
}
