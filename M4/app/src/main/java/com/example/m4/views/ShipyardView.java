package com.example.m4.views;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m4.R;
import com.example.m4.adapter.ShipAdapter;
import com.example.m4.model.Ship;
import com.example.m4.repository.Repository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * View representing the shipyard, another version of the market that instead sells ships
 */
@SuppressWarnings({"FieldCanBeLocal", "WeakerAccess"})
public class ShipyardView extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Ship> orders;
    private TextView shipDescription;

    private Button toMarketButton, doneButton;

    private TextView selectedPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipyard);

        selectedPlanet = findViewById(R.id.selected_planet_view);
        String planet_text = "You are in " + Repository.planetClass.getPlanetName().toString() + " Planet";
        selectedPlanet.setText(planet_text);

        shipDescription = findViewById(R.id.ship_description);
        String m = "Your current ship is\n" + Repository.playerClass.getShip() + " spaceship";
        shipDescription.setText(m);

        toMarketButton = findViewById(R.id.market_button);
        toMarketButton.setOnClickListener(this);

        doneButton = findViewById(R.id.done_button);
        doneButton.setOnClickListener(this);

        final ListView shipList = findViewById(R.id.selected_ship_list);

        orders = getListItemData();
        Repository.setShipList(orders);
        ShipAdapter adapter = new ShipAdapter(this, orders);
        shipList.setAdapter(adapter);
        adapter.registerDataSetObserver(observer);

    }

    /**
     * Displays the description of each ship's equipments
     */
    private void setShip() {

        if (Repository.shipClass != null) {
            if (Repository.shipClass.getName().equals(Repository.playerClass.getShip())) {
                String m = "You already have " + Repository.playerClass.getShip() + " spaceship\nSelect a different ship!";
                shipDescription.setText(m);
            } else {
                Repository.playerClass.setShip(Repository.shipClass.getName());
                String equipment = String.format("%s,\n%s, %s, %s, and %s",
                        Repository.shipClass.getWeapon(),
                        Repository.shipClass.getShield(),
                        Repository.shipClass.getGadget(),
                        Repository.shipClass.getEscapePod(),
                        Repository.shipClass.getInsurance());
                String m = "You now have " + Repository.shipClass.getName() + " spaceship with " + equipment;
                shipDescription.setText(m);
            }
        }
    }

    final DataSetObserver observer = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            setShip();
        }
    };

    /**
     * Creates and returns a list of Ship objects to use in ShipAdapter Class
     * @return a list of Ship objects
     */
    private ArrayList<Ship> getListItemData(){
        ArrayList<Ship> listViewShips = new ArrayList<>();
        ArrayList<String> shipName = new ArrayList<>(Arrays.asList("Flea", "Gnat", "Firefly", "Mosquito", "Bumblebee", "Beetle", "Hornet", "Grasshopper", "Termite", "Wasp"));
        int i = 0;
        while (i < 10) {
            listViewShips.add(new Ship(shipName.get(i)));
            i++;
        }
        return listViewShips;
    }


    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.market_button){
            startActivity(new Intent(this, MarketView.class));
        }
        else if (v.getId() == R.id.done_button) {
            startActivity(new Intent(this, PlanetsView.class));
        }
    }
}
