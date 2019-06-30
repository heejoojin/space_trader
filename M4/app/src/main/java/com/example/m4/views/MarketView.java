package com.example.m4.views;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.m4.adapter.MarketItemAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.m4.model.Item;
import com.example.m4.R;
import com.example.m4.repository.Repository;

import android.widget.Button;

public class MarketView extends AppCompatActivity implements OnClickListener {

    TextView itemTotalText, itemTotalView;
    TextView creditTotalText;
    ArrayList<Item> orders;

    Button switchButton, buyorsellButton, toMarket;

    TextView selectedPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        selectedPlanet = findViewById(R.id.selected_planet_view);
        String planet_text = "You are in " + Repository.planetClass.getPlanetName().toString() + " Planet";
        selectedPlanet.setText(planet_text);

        switchButton = findViewById(R.id.switch_button);
        switchButton.setOnClickListener(this);

        buyorsellButton = findViewById(R.id.make_item_change_button);
        buyorsellButton.setOnClickListener(this);

        toMarket = findViewById(R.id.back_to_market_button);
        toMarket.setOnClickListener(this);

        itemTotalText = (TextView)findViewById(R.id.total_num_view);
        creditTotalText = (TextView)findViewById(R.id.credit_num_view);

        itemTotalView = (TextView)findViewById(R.id.item_total);

        ListView storedOrders = (ListView)findViewById(R.id.selected_item_list);

        orders = getListItemData();
        Repository.setItemsList(orders);
        MarketItemAdapter adapter = new MarketItemAdapter(this, orders);
        storedOrders.setAdapter(adapter);
        adapter.registerDataSetObserver(observer);
    }

    public int calculateItemTotal(){
        int itemTotal = 0;
        for (Item order : orders){
            itemTotal += order.getPrice() * order.getQuantityChange();
        }
        return itemTotal;
    }

    public int calculateCreditTotal(){

        if (Repository.isitBuying) {
            return Integer.parseInt((String)creditTotalText.getText()) - calculateItemTotal();
        } else {
            return Integer.parseInt((String)creditTotalText.getText()) + calculateItemTotal();
        }
    }

    public void setItemTotal(){
        itemTotalText.setText("" + calculateItemTotal());
    }
    public void setCreditTotal() {creditTotalText.setText("" + calculateCreditTotal());}

    public void resetItemTotal() {
        for (Item order : orders) {
            order.setQuantityChange(0);
        }
        itemTotalText.setText("0");
    }

    DataSetObserver observer = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            setItemTotal();
            //setCreditTotal();
        }
    };

    private ArrayList<Item> getListItemData(){
        ArrayList<Item> listViewItems = new ArrayList<Item>();
        ArrayList<String> itemName = new ArrayList<>(Arrays.asList("Water", "Furs", "Food", "Ore", "Games", "Firearms", "Medicine", "Machines", "Narcotics", "Robots"));
        ArrayList<Integer> itemPrice = new ArrayList<>(Arrays.asList(30, 250, 100, 350, 250, 1250, 650, 900, 3500, 5000));
        int i = 0;
        while (i < 10) {
            int price_random_generator = (int)(Math.random() * (6 - 1));
            listViewItems.add(new Item(itemName.get(i), itemPrice.get(i) * price_random_generator));
            i++;
        }
        return listViewItems;
    }

    public boolean calcualteNuminCargo(int input) {
        boolean result = false;

        if (input > Integer.parseInt((String)creditTotalText.getText())) {
            result = true;
        }
        return result;
    }

    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.switch_button) {

            if (Repository.isitBuying) {
                switchButton.setText("Swith to Buy");
                buyorsellButton.setText("Sell");
                itemTotalView.setText("Total Sale   ");
                Repository.isitBuying = false;

                resetItemTotal();

            } else {
                switchButton.setText("Swith to Sell");
                buyorsellButton.setText("Buy");
                itemTotalView.setText("Total Expense   ");
                Repository.isitBuying = true;

                resetItemTotal();
            }

        } else if (v.getId() == R.id.make_item_change_button) {
            if (Repository.isitBuying) {
                if (Integer.parseInt((String) creditTotalText.getText()) < calculateItemTotal()) {

                    String m = "You don't have enough credits";
                    Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();


                } else if (Integer.parseInt((String) creditTotalText.getText()) >= calculateItemTotal()) {
                    if (calculateItemTotal() == 0) {
                        String m = "You didn't select any items";
                        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                    } else {
                        String m = "You successfully purchased the items";
                        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                        setCreditTotal();
                        resetItemTotal();
                    }
                }
            } else {
                // selling
                if (Integer.parseInt((String) itemTotalText.getText()) > 0) {
                    String m = "You successfully sold your items";
                    Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                    setCreditTotal();
                    resetItemTotal();
                }
                if (calculateItemTotal() == 0) {
                    String m = "You didn't select any items";
                    Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                }
            }
        }
//        } else if (v.getId() == R.id.back_to_market_button) {
//                startActivity(new Intent(this, MarketView.class));
//        }

    }
}