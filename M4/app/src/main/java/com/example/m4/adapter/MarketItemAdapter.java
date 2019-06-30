package com.example.m4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.m4.R;
import com.example.m4.model.Item;

import java.util.List;

public class MarketItemAdapter extends ArrayAdapter<Item> {

    private List<Item> list;
    private Context context;

    TextView currentItemName,
            selectedItemNum,
            quantityLeftText,
            currentPrice;

    Button addItem,
            subtractItem;

    public MarketItemAdapter(Context context, List<Item> myOrders) {
        super(context, 0, myOrders);
        this.list = myOrders;
        this.context = context;
    }


    public View getView(final int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.content_sellbuycargo,parent,false
            );
        }

        final Item currentItem = getItem(position);

        currentItemName = (TextView)listItemView.findViewById(R.id.selected_item_name);
        quantityLeftText = (TextView)listItemView.findViewById(R.id.quantity_left);
        subtractItem = (Button)listItemView.findViewById(R.id.minus_item_button);
        selectedItemNum = (TextView)listItemView.findViewById(R.id.selected_item_amount);
        addItem = (Button)listItemView.findViewById(R.id.plus_item_button);
        currentPrice = (TextView)listItemView.findViewById(R.id.selected_item_price);

        //Set the text of the meal, amount and quantity
        currentItemName.setText(currentItem.getName());
        currentPrice.setText("$ " + currentItem.getPrice());
        quantityLeftText.setText("" + currentItem.getQuantityLeft());
        selectedItemNum.setText(""+ currentItem.getQuantityChange());

        //OnClick listeners for all the buttons on the ListView Item
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // buy items
                currentItem.removeFromQuantity();
                quantityLeftText.setText("" + currentItem.getQuantityLeft());
                //currentCost.setText("GH"+"\u20B5"+" "+ (currentFood.getmAmount() * currentFood.getmQuantity()));
                notifyDataSetChanged();
            }
        });

        subtractItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // sell items
                currentItem.addToQuantity();

                quantityLeftText.setText("" + currentItem.getQuantityLeft());
                //currentCost.setText("GH"+"\u20B5"+" "+ (currentFood.getmAmount() * currentFood.getmQuantity()));
                notifyDataSetChanged();
            }
        });

//        removeMeal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                list.remove(position);
//                notifyDataSetChanged();
//            }
//        });

        return listItemView;
    }

}
