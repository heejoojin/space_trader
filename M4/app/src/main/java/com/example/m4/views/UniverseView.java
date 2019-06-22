package com.example.m4.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.m4.model.PlanetName;
import com.example.m4.model.RegionName;
import android.widget.AdapterView;
import android.view.View;
import com.example.m4.R;
import android.widget.Toast;

import com.example.m4.model.TechLevel;
import com.example.m4.model.Resource;
import com.example.m4.model.Region;

public class UniverseView extends AppCompatActivity {

    private GridView UniversegridView;
    // TextView textView;
    private RegionName regionName;
    private TechLevel techLevel;
    private Resource resource;
    private Region region;
    private PlanetName planetName;

    private TextView region_text;
    private TextView planets_text;
    private TextView techlevel_text;
    private TextView resource_text;
    private TextView location_text;

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



        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, regionName.values());

        UniversegridView.setAdapter(adapter);

        UniversegridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub

                /* appending I Love with car brand names */
                String itemName = "" + adapter.getItem(position);
                String value = itemName + "has been selected";
                /* Display the Toast */
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

                region_text.setText(itemName);
                planets_text.setText(planetName.getRandom().toString() + " & " + itemName);
                techlevel_text.setText(techLevel.getRandom().toString());
                resource_text.setText(resource.getRandom().toString());
                //location_text.setText(region.getxLoc());

            }
        });
    }
}
