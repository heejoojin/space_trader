package com.example.m4.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m4.R;
import com.example.m4.model.Player;
import com.example.m4.model.Region;
import com.example.m4.model.Universe;
import com.example.m4.model.Planet;

import java.util.ArrayList;
import java.util.List;

public class GameView extends AppCompatActivity {

    private TextView selectedRegion;
    private GridView planetsView;
    private String region_title;

    private List<String> planets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        selectedRegion = findViewById(R.id.selected_region_view);
        region_title = "You are in " + Player.repo.get("Region") + "\n" + "Select a Planet";
        selectedRegion.setText(region_title);

        planetsView = findViewById(R.id.planets_gridView);

        for (Planet r : Universe.temp_planets) {
            planets.add(r.getPlanetName().toString());
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, planets);
        planetsView.setAdapter(adapter);
        planetsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub

                String message = "";
                message = adapter.getItem(position) + " has been selected";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

            }
        });

    }
}