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

    public static int checkpoint = 1000;


    TextView currentItemName,
            selectedItemNum,
            quantityLeftinHold,
            currentPrice,
            quantityLeftinMarket;

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
        quantityLeftinHold = (TextView)listItemView.findViewById(R.id.quantityowned_left_num);
        subtractItem = (Button)listItemView.findViewById(R.id.minus_item_button);
        selectedItemNum = (TextView)listItemView.findViewById(R.id.selected_item_amount);
        addItem = (Button)listItemView.findViewById(R.id.plus_item_button);
        currentPrice = (TextView)listItemView.findViewById(R.id.selected_item_price);
        quantityLeftinMarket = (TextView)listItemView.findViewById(R.id.quantity_leftinmarket_num);


        //Set the text of the meal, amount and quantity
        currentItemName.setText(currentItem.getName());
        currentPrice.setText("$ " + currentItem.getPrice());
        quantityLeftinHold.setText("" + currentItem.getQuantityLeft());
        selectedItemNum.setText(""+ currentItem.getQuantityChange());
        quantityLeftinMarket.setText("" + currentItem.getQuantityInMarket());


        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Repository.isitBuying) {

                    if (checkpoint >= 0 && currentItem.getQuantityInMarket() > 0) {
                        if ( (checkpoint - currentItem.getPrice()) >= 0 ) {
                            currentItem.addToQuantity();
                            currentItem.addToQuanitiyinHold();
                            currentItem.removeFromQuantityinMarket();
                            checkpoint -= (currentItem.getPrice());

                            System.out.println(checkpoint);
                        }
                    }

                } else {
                    // selling
                    if (currentItem.getQuantityLeft() > 0) {
                        currentItem.addToQuantity();
                        currentItem.removeFromQuantityinHold();
                        currentItem.addToQuantityinMarket();
                        checkpoint += (currentItem.getPrice());

                        System.out.println(checkpoint);
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
                        currentItem.removeFromQuantityinHold();
                        currentItem.addToQuantityinMarket();
                        checkpoint += (currentItem.getPrice());
                        // quantityLeftText.setText("" + currentItem.getQuantityLeft());

                        System.out.println(checkpoint);
                    }
                } else {
                    // selling
                    if (currentItem.getQuantityChange() != 0) {
                        currentItem.removeFromQuantity();
                        currentItem.addToQuanitiyinHold();
                        currentItem.removeFromQuantityinMarket();
                        checkpoint -= (currentItem.getPrice());

                        System.out.println(checkpoint);
                    }
                }
                notifyDataSetChanged();
            }
        });

        return listItemView;
    }

}
