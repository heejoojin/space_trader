package com.example.m4.views;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m4.R;
import com.example.m4.adapter.MercenaryAdapter;
import com.example.m4.model.Mercenary;
import com.example.m4.repository.Repository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * View representing the mercenary market, another version of the market that has mercenaries instead
 */
public class MercenaryView extends AppCompatActivity implements View.OnClickListener {

    TextView itemTotaltoEditText, itemTotalView;
    TextView creditTotaltoEditText;
    TextView marketMode;
    ArrayList<Mercenary> orders;

    MercenaryAdapter setadpater;

    Button switchButton, buyorsellButton, toShipYardButton, doneButton;

    TextView selectedPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercenary);

        selectedPlanet = findViewById(R.id.selected_planet_view);
        String planet_text = "You are in " + Repository.planetClass.getPlanetName().toString() + " Planet";
        selectedPlanet.setText(planet_text);

        marketMode = findViewById(R.id.market_mode_view);

        switchButton = findViewById(R.id.switch_button);
        switchButton.setOnClickListener(this);

        buyorsellButton = findViewById(R.id.make_item_change_button);
        buyorsellButton.setOnClickListener(this);

        toShipYardButton = findViewById(R.id.shipyard_button);
        toShipYardButton.setOnClickListener(this);

        doneButton = findViewById(R.id.done_button);
        doneButton.setOnClickListener(this);

        itemTotaltoEditText = findViewById(R.id.total_num_view);
        creditTotaltoEditText = findViewById(R.id.credit_num_view);
        creditTotaltoEditText.setText("" + Repository.playerClass.getCredits());

        itemTotalView = findViewById(R.id.item_total);

        ListView storedOrders = findViewById(R.id.selected_item_list);

        orders = getListItemData();
        Repository.setMercenariesList(orders);
        MercenaryAdapter adapter = new MercenaryAdapter(this, orders);
        setadpater = adapter;
        storedOrders.setAdapter(setadpater);
        setadpater.registerDataSetObserver(observer);
    }

    public int calculateItemTotal(){
        int itemTotal = 0;
        for (Mercenary order : orders){
            if (order.getHired()) {
                itemTotal += order.getPrice();
            }
        }
        return itemTotal;
    }

    public int calculateCreditTotal(){

        if (Repository.isitBuying) {
            return Integer.parseInt((String)creditTotaltoEditText.getText()) - calculateItemTotal();
        } else {
            return Integer.parseInt((String)creditTotaltoEditText.getText()) + calculateItemTotal();
        }
    }

    public void setItemTotal(){
        itemTotaltoEditText.setText("" + calculateItemTotal());
    }
    public void setCreditTotal() {creditTotaltoEditText.setText("" + calculateCreditTotal());}

    public void resetItemTotal() {
        for (Mercenary order : orders) {
            //order.setQuantityChange(0); todo
        }
        itemTotaltoEditText.setText("0");
    }

    public void updateIteminCargo() {
        for (Mercenary order : orders) {
            //order.updateQuantity(); todo
        }
    }

    DataSetObserver observer = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            setItemTotal();
            //setCreditTotal();
        }
    };

    private ArrayList<Mercenary> getListItemData(){
        ArrayList<Mercenary> listViewMercs = new ArrayList<>(); //todo: update arraylist type
        ArrayList<String> itemName = new ArrayList<>(Arrays.asList("Red", "Heejoo", "Nina", "Brian", "Kunhyuk", "John", "Spock", "Jango Fett", "Deadpool", "Boba Fett"));
        ArrayList<Integer> itemPrice = new ArrayList<>(Arrays.asList(30, 250, 100, 350, 250, 1250, 650, 900, 3500, 5000));
        int i = 0;
        while (i < 10) {
            listViewMercs.add(new Mercenary(itemName.get(i), itemPrice.get(i)));
            i++;
        }
        return listViewMercs;
    }


    @Override
    public void onClick (View v) {

        if (v.getId() == R.id.switch_button) {

            if (Repository.isitBuying) {

                switchButton.setText("Switch to Hire");
                itemTotalView.setText("Total Sale   ");
                marketMode.setText("Fire Your Mercenary");

                Repository.isitBuying = false;
                //resetItemTotal();
                setadpater.notifyDataSetChanged();


            } else {
                switchButton.setText("Switch to Fire");
                itemTotalView.setText("Total Expense   ");
                marketMode.setText("Hire a New Mercenary");

                Repository.isitBuying = true;
                //resetItemTotal();
                creditTotaltoEditText.setText("0");
                setadpater.notifyDataSetChanged();
            }

        } else if (v.getId() == R.id.make_item_change_button) {
            if (Repository.isitBuying) {
                if (Integer.parseInt((String) creditTotaltoEditText.getText()) >= calculateItemTotal()) {
                    if (calculateItemTotal() == 0) {
                        String m = "You didn't select a mercenary to hire";
                        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                    } else {
                        String m = "You successfully hired the mercenary(s)";
                        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                        setCreditTotal();
                        //creditTotaltoEditText.setText("" + (Repository.playerClass.getCredits() - Integer.parseInt((String)creditTotaltoEditText.getText())));
                        //resetItemTotal();
                        //updateIteminCargo();
                        setadpater.notifyDataSetChanged();

                    }
                }
            } else {
                // selling
                if (Integer.parseInt((String) itemTotaltoEditText.getText()) > 0) {
                    String m = "You successfully fired your mercenary";
                    Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                    setCreditTotal();
                    //resetItemTotal();
                    //updateIteminCargo();
                    setadpater.notifyDataSetChanged();

                } else if (calculateItemTotal() == 0) {
                    String m = "You didn't select a mercenary to fire";
                    Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();

                }
            }
        } else if (v.getId() == R.id.shipyard_button) {
            startActivity(new Intent(this, ShipyardView.class));
        } else if (v.getId() == R.id.done_button) {
            startActivity(new Intent(this, PlanetsView.class));
        }
    }
}
