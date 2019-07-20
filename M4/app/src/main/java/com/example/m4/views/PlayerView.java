package com.example.m4.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m4.R;
import com.example.m4.repository.Repository;

public class PlayerView extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        TextView name = findViewById(R.id.player_name);
        TextView difficulty = findViewById(R.id.player_difficulty);
        TextView ship = findViewById(R.id.player_ship);
        TextView credit = findViewById(R.id.player_credit);

        TextView pilot = findViewById(R.id.player_pilot);
        TextView fighter = findViewById(R.id.player_fighter);
        TextView trader = findViewById(R.id.player_trader);
        TextView engineer = findViewById(R.id.player_engineer);

        TextView region = findViewById(R.id.player_region);
        TextView planet = findViewById(R.id.player_planet);
        TextView weapon = findViewById(R.id.player_weapon);

        name.setText(Repository.playerClass.getName());
        difficulty.setText(Repository.playerClass.getDifficulty().toString());
        ship.setText(Repository.playerClass.getShip());
        credit.setText(String.valueOf(Repository.playerClass.getCredits()));

        pilot.setText(String.valueOf(Repository.playerClass.getPilotPoints()));
        fighter.setText(String.valueOf(Repository.playerClass.getFighterPoints()));
        trader.setText(String.valueOf(Repository.playerClass.getTraderPoints()));
        engineer.setText(String.valueOf(Repository.playerClass.getEngineerPoints()));

        if (Repository.toTravelRegionName != null) {
            region.setText(Repository.toTravelRegionName.toString());
        } else {
            region.setText("Earth");
        }

        if (Repository.planetClass != null) {
            planet.setText(Repository.planetClass.getPlanetName().toString());
        } else {
            planet.setText("None");
        }

        weapon.setText(Repository.playerClass.getWeapons());

        Button next = findViewById(R.id.next_button);
        next.setOnClickListener(this);

    }
    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.next_button) {

            startActivity(new Intent(this, UniverseView.class));
        }
    }
}
