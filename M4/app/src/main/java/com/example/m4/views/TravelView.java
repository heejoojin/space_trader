package com.example.m4.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.m4.model.Universe;
import com.example.m4.repository.Repository;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.m4.R;

import java.text.DecimalFormat;

public class TravelView extends AppCompatActivity implements View.OnClickListener {

    private TextView travelMessage;
    private TextView region_display_textview;
    private Button nextButton;
    private Button backButton;
    private DecimalFormat formatter = new DecimalFormat("#,###,###");
    String region_display_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        travelMessage = findViewById(R.id.travel_message);

        nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(this);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);

        region_display_textview = findViewById(R.id.region_display_view);
        String fuel_initial = formatter.format(Repository.playerClass.getFuel());

        region_display_message = "You are in " + Repository.regionClass.getRegionName().toString() + "\n" + Repository.playerClass.getShip() + " | Fuel "  +
                fuel_initial + " L available";
        region_display_textview.setText(region_display_message);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next_button) {
            startActivity(new Intent(this, PlanetsView.class));
        } else if (view.getId() == R.id.back_button) {
            startActivity(new Intent(this, UniverseView.class));
        }
    }
}
