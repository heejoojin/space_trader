package com.example.m4.views;

import android.content.Intent;
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
import android.widget.Button;

import com.example.m4.model.TechLevel;
import com.example.m4.model.Resource;
import com.example.m4.model.Region;
import android.view.View.OnClickListener;

public class UniverseView extends AppCompatActivity implements OnClickListener {

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

    private Button next_button;

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

        next_button = findViewById(R.id.next_button_1);
        next_button.setOnClickListener(this);


        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, regionName.values());

        UniversegridView.setAdapter(adapter);

        UniversegridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub

                String itemName = "" + adapter.getItem(position);
                String value = itemName + "has been selected";
                /* Display the Toast */
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

                region_text.setText(itemName);
                planets_text.setText(planetName.getRandom().toString() + " & " + itemName);
                techlevel_text.setText(techLevel.getRandom().toString());
                resource_text.setText(resource.getRandom().toString());

            }
        });
    }

    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.next_button_1) {
            startActivity(new Intent(this, GameView.class));
        }
    }
}
