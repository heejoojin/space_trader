package com.example.m4.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.m4.R;
import com.example.m4.model.Item;
import com.example.m4.repository.Repository;

import java.util.List;

public class MarketItemAdapter extends ArrayAdapter<Item>{

    private List<Item> list;
    private Context context;

    private static int checkpoint = 1000;


    TextView currentItemName,
            selectedItemNum,
            quantityLeftText,
            currentPrice;

    Button addItem, subtractItem;


    public MarketItemAdapter(Context context, List<Item> myOrders) {
        super(context, 0, myOrders);
        this.list = myOrders;
        this.context = context;
    }


    public View getView(final int position, final View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.content_market,parent,false
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


        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Repository.isitBuying) {

                    if (checkpoint >= 0) {
                        if ( (checkpoint - currentItem.getPrice()) >= 0 ) {
                            currentItem.addToQuantity();
                            currentItem.addToCargo();
                            //credit -= currentItem.getQuantityChange() * currentItem.getPrice();
                            checkpoint -= (currentItem.getPrice());
                            Log.d("check", String.valueOf(checkpoint));
                        }
                    }

                } else {
                    // selling
                    if (currentItem.getQuantityLeft() > 0) {
                        currentItem.addToQuantity();
                        currentItem.removeFromCargo();
                    }
                }
                notifyDataSetChanged();

            }
        });
        subtractItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Repository.isitBuying) {
                    if (currentItem.getQuantityChange() != 0) {
                        currentItem.removeFromQuantity();
                        currentItem.removeFromCargo();
                        quantityLeftText.setText("" + currentItem.getQuantityLeft());
                    }
                } else {
                    if (currentItem.getQuantityChange() != 0) {
                        currentItem.removeFromQuantity();
                        currentItem.addToCargo();
                    }
                }
                notifyDataSetChanged();
            }
        });

        return listItemView;
    }

}
