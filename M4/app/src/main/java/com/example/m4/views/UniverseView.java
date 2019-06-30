package com.example.m4.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.m4.model.PlanetName;
import com.example.m4.model.RegionName;
import android.widget.AdapterView;
import android.view.View;
import com.example.m4.R;

import android.widget.Button;

import com.example.m4.model.TechLevel;
import com.example.m4.model.Resource;
import com.example.m4.model.Region;
import com.example.m4.model.Planet;
import com.example.m4.model.Universe;
import com.example.m4.model.Player;
import com.example.m4.repository.Repository;

import android.view.View.OnClickListener;
import java.lang.String;

public class UniverseView extends AppCompatActivity implements OnClickListener {

    private GridView UniversegridView;
    // TextView textView;
    private RegionName regionName;
    private TechLevel techLevel;
    private Resource resource;
    private Region region;
    private PlanetName planetName;
    private Universe universe;

    private TextView region_text;
    private TextView planets_text;
    private TextView techlevel_text;
    private TextView resource_text;
    private TextView location_text;
    private TextView color_text;

    private Button next_button;
    private Player player;

    private Boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);
        UniversegridView = (GridView)findViewById(R.id.universe_gridView);

        region_text = findViewById(R.id.region_selected);
        planets_text = findViewById(R.id.planet_selected);
        techlevel_text = findViewById(R.id.techlevel_selected);
        resource_text = findViewById(R.id.resource_selected);
        location_text = findViewById(R.id.location_selected);
        color_text = findViewById(R.id.color_selected);

        next_button = findViewById(R.id.next_button_1);
        next_button.setOnClickListener(this);

        universe = new Universe(12, 30);
        universe.populate();
        String string = universe.toString();
        Log.d("Universe", string);
        Repository.setUniverseClass(universe);


        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, regionName.values());

        UniversegridView.setAdapter(adapter);

        UniversegridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub

                // String itemName = "" + adapter.getItem(position);
                // String value = itemName + " has been selected";
                /* Display the Toast */
                // Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

                String planet_details = "";
                clicked = true;
                // planets_text.setText(planetName.getRandom().toString() + " & " + itemName);

                for (Region region: universe.getRegions()) {
                    if (region.getRegionName().equals(adapter.getItem(position))) {

                        Repository.setRegionClass(region);

                        region_text.setText(region.getRegionName().toString());
                        techlevel_text.setText(region.getTechLevel().toString());
                        resource_text.setText(region.getSpecialResource().toString());
                        color_text.setText(region.getColor().toString());
                        String region_loc = "(" + region.getxLoc()
                                + ", " + region.getyLoc() + ")";
                        location_text.setText(region_loc);

                        for (Planet planet : region.getPlanetList()) {

                            planet_details += planet.getPlanetName() + ", (" + planet.getxLocation()
                                    + ", " + planet.getyLocation() + ")\n";
                        }
                        planets_text.setText(planet_details);
                    }
                }
            }
        });

    }
    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.next_button_1) {
            if (clicked) {
                startActivity(new Intent(this, PlanetsView.class));
            }

        }
    }
}
