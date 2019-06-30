package com.example.m4.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import com.example.m4.R;
import com.example.m4.repository.Repository;

public class MarketView extends AppCompatActivity implements View.OnClickListener {

    private TextView selectedPlanet;

    private Button buyCargo;
    private Button sellCargo;
    private Button shipyard;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        selectedPlanet = findViewById(R.id.selected_planet_view);
        String planet_text = "You are in " + Repository.planetClass.getPlanetName().toString() + " Planet";
        selectedPlanet.setText(planet_text);

        buyCargo = findViewById(R.id.buy_cargo_button);
        buyCargo.setOnClickListener(this);
        sellCargo = findViewById(R.id.sell_cargo_button);
        sellCargo.setOnClickListener(this);
        shipyard = findViewById(R.id.shipyard_button);
        shipyard.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.buy_cargo_button) {

            startActivity(new Intent(this, SellBuyCargoView.class));

        } else if (v.getId() == R.id.sell_cargo_button) {

            startActivity(new Intent(this, SellBuyCargoView.class));

        } else if (v.getId() == R.id.shipyard_button) {


        }
    }
}
