package com.example.m4.views;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.m4.adapter.MarketItemAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.m4.model.Item;
import com.example.m4.R;
import android.widget.Button;

public class SellBuyCargoView extends AppCompatActivity {

    TextView itemTotalText;
    ArrayList<Item> orders;

    Button switchButton, buyorsellButton, toMarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellbuycargo);

        switchButton = findViewById(R.id.switch_button);
        //switchButton.setOnClickListener(this);

        buyorsellButton = findViewById(R.id.make_item_change_button);
        //buyorsellButton.setOnClickListener(this);

        toMarket = findViewById(R.id.back_to_market_button);
        //toMarket.setOnClickListener(this);

        itemTotalText = (TextView)findViewById(R.id.total_num_view);

        ListView storedOrders = (ListView)findViewById(R.id.selected_item_list);

        orders = getListItemData();
        MarketItemAdapter adapter = new MarketItemAdapter(this, orders);
        storedOrders.setAdapter(adapter);
        adapter.registerDataSetObserver(observer);
    }

    public int calculateMealTotal(){
        int mealTotal = 0;
        for (Item order : orders){
            mealTotal += order.getPrice() * order.getQuantityChange();
        }
        return mealTotal;
    }

    DataSetObserver observer = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            setMealTotal();
        }
    };

    private ArrayList<Item> getListItemData(){
        ArrayList<Item> listViewItems = new ArrayList<Item>();
        ArrayList<String> itemName = new ArrayList<>(Arrays.asList("Water", "Furs", "Food", "Ore", "Games", "Firearms", "Medicine", "Machines", "Narcotics", "Robots"));
        ArrayList<Integer> itemPrice = new ArrayList<>(Arrays.asList(30, 250, 100, 350, 250, 1250, 650, 900, 3500, 5000));
        int i = 0;
        while (i < 10) {
            int quantity_random_generator = 5 + (int)(Math.random() * (51 - 5));
            int price_multiplier_random_generator = 1 + (int)(Math.random() * (3 - 1));
            listViewItems.add(new Item(itemName.get(i), quantity_random_generator, itemPrice.get(i) * price_multiplier_random_generator));
            i++;
        }
        return listViewItems;
    }

    public void setMealTotal(){
        itemTotalText.setText(""+calculateMealTotal());
    }

//    @Override
//    public void onClick (View v) {
//        if (v.getId() == R.id.switch_button) {
//            switchButton.setText("Swith to Buy");
//            buyorsellButton.setText("Sell");
//        } else if (v.getId() == R.id.make_item_change_button) {
//
//        } else if (v.getId() == R.id.back_to_market_button) {
//            startActivity(new Intent(this, MarketView.class));
//        }
//
//    }
}
