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
import com.example.m4.model.Item;
import com.example.m4.model.Mercenary;
import com.example.m4.repository.Repository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * View representing the mercenary market, another version of the market that has mercenaries instead
 */
@SuppressWarnings("ALL")
public class MercenaryView extends AppCompatActivity implements View.OnClickListener {

    private TextView itemTotaltoEditText, itemTotalView;
    private TextView creditTotaltoEditText;
    private TextView marketMode;
    private ArrayList<Mercenary> orders;

    private MercenaryAdapter setadpater;

    private Button switchButton;
    private Button buyorsellButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercenary);

        TextView selectedPlanet = findViewById(R.id.selected_planet_view);
        String planet_text = "You are in " + Repository.planetClass.getPlanetName().toString() + " Planet";
        selectedPlanet.setText(planet_text);

        marketMode = findViewById(R.id.market_mode_view);

        switchButton = findViewById(R.id.switch_button);
        switchButton.setOnClickListener(this);

        buyorsellButton = findViewById(R.id.make_item_change_button);
        buyorsellButton.setOnClickListener(this);

        Button toShipYardButton = findViewById(R.id.shipyard_button);
        toShipYardButton.setOnClickListener(this);

        Button doneButton = findViewById(R.id.done_button);
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

    /**
     * Calculates the total price of selected mercenaries
     */
    public int calculateItemTotal(){
        int itemTotal = 0;
        for (Mercenary order : orders){
            itemTotal += order.getPrice() * order.getQuantityChange();
        }
        return itemTotal;
    }

    /**
     * Calculates the total credits that the player owns
     */
    public int calculateCreditTotal(){

        if (Repository.isitBuying) {
            return Integer.parseInt((String)creditTotaltoEditText.getText()) - calculateItemTotal();
        } else {
            return Integer.parseInt((String)creditTotaltoEditText.getText()) + calculateItemTotal();
        }
    }

    /**
     * Displays the calculated total price of selected mercenaries
     */
    public void setItemTotal(){
        itemTotaltoEditText.setText("" + calculateItemTotal());
    }

    /**
     * Displays the total credits that the player owns
     */
    public void setCreditTotal() {creditTotaltoEditText.setText("" + calculateCreditTotal());}

    /**
     * Resets all the expenses amount to zero after purchasing or selling
     */
    public void resetItemTotal() {
        for (Mercenary order : orders) {
            order.setQuantityChange(0);
        }
        itemTotaltoEditText.setText("0");
    }

    final DataSetObserver observer = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            setItemTotal();
            //setCreditTotal();
        }
    };

    /**
     * Creates and returns a list of Mercenary objects to use in MercenaryAdapter
     * @return a list of Mercenary objects
     */
    private ArrayList<Mercenary> getListItemData(){
        ArrayList<Mercenary> listViewMercs = new ArrayList<>(); //todo: update arraylist type
        ArrayList<String> itemName = new ArrayList<>(Arrays.asList("Red", "Heejoo", "Nina", "Brian", "Kunhyuk", "John", "Spock", "Jango Fett", "Deadpool", "Boba Fett"));
        ArrayList<Integer> itemPrice = new ArrayList<>(Arrays.asList(30, 250, 100, 350, 250, 1250, 650, 900, 3500, 5000));
        int i = 0;
        while (i < 10) {
            String name = itemName.get(i);
            listViewMercs.add(new Mercenary(name, itemPrice.get(i),
                    Repository.mercenaryMap.get(name)));
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
                resetItemTotal();
                setadpater.notifyDataSetChanged();


            } else {
                switchButton.setText("Switch to Fire");
                itemTotalView.setText("Total Expense   ");
                marketMode.setText("Hire a New Mercenary");

                Repository.isitBuying = true;
                resetItemTotal();
                setadpater.notifyDataSetChanged();
            }

        } else if (v.getId() == R.id.make_item_change_button) {
            if (Repository.isitBuying) {
                if (Integer.parseInt((String) creditTotaltoEditText.getText()) >= calculateItemTotal()) {
                    if (calculateItemTotal() == 0) {
                        String m = "You didn't select a mercenary to hire";
                        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                    } else {
                        Repository.setTransactionHistory(true);
                        String m = "You successfully hired the mercenary(s)";
                        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                        setCreditTotal();
                        resetItemTotal();
                        setadpater.notifyDataSetChanged();

                    }
                }
            } else {
                // selling
                if (Integer.parseInt((String) itemTotaltoEditText.getText()) > 0) {
                    String m = "You successfully fired your mercenary";
                    Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                    setCreditTotal();
                    resetItemTotal();
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
