package com.example.m4.views;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import com.example.m4.R;
import com.example.m4.adapter.MarketItemAdapter;
import com.example.m4.model.Planet;
import com.example.m4.repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * View that shows all the planets within the region
 */
public class PlanetsView extends AppCompatActivity implements View.OnClickListener {

    private TextView planet_name_text;
    private TextView planet_location_text;

    private List<String> planets = new ArrayList<>();
    private boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        TextView selectedRegion = findViewById(R.id.selected_region_view);
        String region_title = "You are in " + Repository.toTravelRegionName.toString() + " Region" + "\n";
        selectedRegion.setText(region_title);

        GridView planetsView = findViewById(R.id.planets_gridView);

        planet_name_text = findViewById(R.id.single_planet_selected);
        planet_location_text = findViewById(R.id.single_planet_location_selected);

        Button enterMarket = findViewById(R.id.enter_market_button);
        enterMarket.setOnClickListener(this);

        Button enterMercenariesMarket = findViewById(R.id.enter_mercenary_button);
        enterMercenariesMarket.setOnClickListener(this);

        Button travelTonewRegion = findViewById(R.id.travel_region_button);
        travelTonewRegion.setOnClickListener(this);

        for (Planet planet : Repository.toTravelPlanets) {
            planets.add(planet.getPlanetName().toString());
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, planets);
        planetsView.setAdapter(adapter);

        planetsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                clicked = true;

                String message = adapter.getItem(position) + " has been selected";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                for (Planet planet : Repository.toTravelPlanets) {

                    String pl_name = planet.getPlanetName().toString();

                    if (pl_name.equals(adapter.getItem(position))) {

                        Repository.setPlanetClass(planet);

                        planet_name_text.setText(pl_name);
                        String planet_loc = "(" + planet.getxLocation()
                                + ", " + planet.getyLocation() + ")";
                        planet_location_text.setText(planet_loc);
                    }
                }
            }
        });

    }
    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.travel_region_button) {
            startActivity(new Intent(this, UniverseView.class));
        }

        if (v.getId() == R.id.enter_market_button) {
            if (clicked) {
                startActivity(new Intent(this, MarketView.class));
                MarketItemAdapter.checkpoint = 1000;
                Repository.isitBuying = true;
            } else {
                Toast.makeText(getApplicationContext(), "You have to select a planet", Toast.LENGTH_SHORT).show();
            }
        }

        if (v.getId() == R.id.enter_mercenary_button) {
            if (clicked) {
                startActivity(new Intent(this, MercenaryView.class));
                MarketItemAdapter.checkpoint = 1000;
                Repository.isitBuying = true;
            } else {
                Toast.makeText(getApplicationContext(), "You have to select a planet", Toast.LENGTH_SHORT).show();
            }
        }

    }
}