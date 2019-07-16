package com.example.m4.views;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProviders;

import com.example.m4.model.PlanetName;
import com.example.m4.model.RegionName;
import com.example.m4.model.Region;
import android.widget.AdapterView;
import android.view.View;
import com.example.m4.R;

import android.widget.Button;
import com.example.m4.model.Planet;

import com.example.m4.model.Universe;
import com.example.m4.repository.Repository;
import com.example.m4.viewmodels.TravelViewModel;

import android.view.View.OnClickListener;
import android.widget.Toast;

import java.lang.String;
import java.text.DecimalFormat;

/**
 * View that will depict our entire universe along with its regions/planets
 */
@SuppressWarnings({"FieldCanBeLocal", "unused", "AccessStaticViaInstance", "unchecked"})
public class UniverseView extends AppCompatActivity implements OnClickListener {

    private GridView UniversegridView;
    private RegionName regionName;
    private PlanetName planetName;
    private Universe universe;

    private TextView region_display_textview;

    private TextView region_text;
    private TextView planets_text;
    private TextView techlevel_text;
    private TextView resource_text;
    private TextView location_text;
    private TextView color_text;
    private TextView fuel_text;

    private Button travel_between_region_button;
    private Button save_next_button;
    private Button map_button;

    private Boolean clicked = false;
    private static Boolean travelled = false;
    private TravelViewModel viewModel;

    private final DecimalFormat formatter = new DecimalFormat("#,###,###");
    private String region_display_message;

    private String randomElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);
        GridView UniversegridView = findViewById(R.id.universe_gridView);

        region_display_textview = findViewById(R.id.region_display_view);
        String fuel_initial = formatter.format(Repository.playerClass.getFuel());

        viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);
        randomElement = viewModel.getRandomElement();

        if (Repository.toTravelRegionName != null) {

            region_display_message = "You are in " + Repository.toTravelRegionName.toString() + "\n" + Repository.playerClass.getShip() + " | Fuel "  +
                    fuel_initial + " L available";

        } else {
            region_display_message = "You are in Earth \n" + Repository.playerClass.getShip() + " | Fuel "  +
                    fuel_initial + " L available";
        }
        region_display_textview.setText(region_display_message);
        region_text = findViewById(R.id.region_selected);
        planets_text = findViewById(R.id.planet_selected);
        techlevel_text = findViewById(R.id.techlevel_selected);
        resource_text = findViewById(R.id.resource_selected);
        location_text = findViewById(R.id.location_selected);
        color_text = findViewById(R.id.color_selected);
        fuel_text = findViewById(R.id.fuel_needed_selected);

        travel_between_region_button = findViewById(R.id.travel_between_region_button);
        travel_between_region_button.setOnClickListener(this);

        save_next_button = findViewById(R.id.save_next_button);
        save_next_button.setOnClickListener(this);
        map_button = findViewById(R.id.map_button);
        map_button.setOnClickListener(this);


        if (!travelled) {
            save_next_button.setVisibility(View.GONE);
        } else {
            save_next_button.setVisibility(View.VISIBLE);
        }

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


                for (Region region: Repository.universeClass.getRegions()) {

                    if (region.getRegionName().equals(adapter.getItem(position))) {
                        clicked = true;

                        Repository.setRegionClass(region);

                        region_text.setText(region.getRegionName().toString());
                        techlevel_text.setText(region.getTechLevel().toString());
                        resource_text.setText(region.getSpecialResource().toString());
                        color_text.setText(region.getColor().toString());
                        String region_loc = "(" + region.getxLoc()
                                + ", " + region.getyLoc() + ")";
                        location_text.setText(region_loc);
                        String fuel_formatted = formatter.format(region.getFuelneededtoTravel());
                        String fuel_needed = "" + fuel_formatted + " L required";
                        fuel_text.setText(fuel_needed);

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

        if (v.getId() == R.id.map_button) {
            startActivity(new Intent(this, MapView.class));
        }

        if (v.getId() == R.id.save_next_button) {
            startActivity(new Intent(this, PlanetsView.class));
        }

        if (v.getId() == R.id.travel_between_region_button) {

            if (!clicked) {
                Toast.makeText(getApplicationContext(), "You have to select a region to travel", Toast.LENGTH_SHORT).show();
            } else {
                if (Repository.regionClass.getRegionName().equals(Repository.toTravelRegionName)) {
                    String same_region = "You are already in " + Repository.regionClass.getRegionName().toString();
                    Toast.makeText(getApplicationContext(), same_region, Toast.LENGTH_SHORT).show();
                } else {
                    int fuel_left = Repository.playerClass.getFuel() - Repository.regionClass.getFuelneededtoTravel();

                    if (fuel_left < 0) {
                        Toast.makeText(getApplicationContext(), "You don't have enough fuel to travel", Toast.LENGTH_SHORT).show();

                    } else {

                        if (randomElement.equals("Random Event")) {
                            startActivity(new Intent(this, RandomEventView.class));

                        } else {
                            travelled = true;

                            Repository.playerClass.setFuel(fuel_left);
                            System.out.println(Repository.playerClass.getFuel());

                            Repository.setToTravelRegionName(Repository.regionClass.getRegionName());
                            Repository.setToTravelPlanets(Repository.regionClass.getPlanetList());

                            startActivity(new Intent(this, TravelView.class));

                        }
                    }
                }
            }
        }
    }
}