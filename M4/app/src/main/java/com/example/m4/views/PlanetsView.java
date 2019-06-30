package com.example.m4.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import com.example.m4.R;
import com.example.m4.adapter.MarketItemAdapter;
import com.example.m4.model.Market;
import com.example.m4.model.Planet;
import com.example.m4.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class PlanetsView extends AppCompatActivity implements View.OnClickListener {

    private TextView selectedRegion;
    private GridView planetsView;
    private String region_title;

    private TextView planet_name_text;
    private TextView planet_location_text;

    private List<String> planets = new ArrayList<>();
    private boolean clicked = false;

    private Button enterMarket;
    private Button travelTonewRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        selectedRegion = findViewById(R.id.selected_region_view);
        region_title = "You are in " + Repository.regionClass.getRegionName() + " Region" + "\n";
        selectedRegion.setText(region_title);

        planetsView = findViewById(R.id.planets_gridView);

        planet_name_text = findViewById(R.id.single_planet_selected);
        planet_location_text = findViewById(R.id.single_planet_location_selected);

        enterMarket = findViewById(R.id.enter_market_button);
        enterMarket.setOnClickListener(this);

        travelTonewRegion = findViewById(R.id.travel_region_button);
        enterMarket.setOnClickListener(this);

        for (Planet planet : Repository.regionClass.getPlanetList()) {
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

                String message = "";
                message = adapter.getItem(position) + " has been selected";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                for (Planet planet : Repository.regionClass.getPlanetList()) {

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
        if (v.getId() == R.id.enter_market_button) {
            if (clicked) {
                startActivity(new Intent(this, MarketView.class));
                MarketItemAdapter.checkpoint = 1000;
                Repository.isitBuying = true;
            }
        } else if (v.getId() == R.id.travel_region_button) {
            startActivity(new Intent(this, UniverseView.class));
        }
    }
}