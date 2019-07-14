package com.example.m4.adapter;
import com.example.m4.R;
import com.example.m4.model.Ship;
import com.example.m4.repository.Repository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ShipAdapter extends ArrayAdapter<Ship>{

    private List<Ship> list;
    private Context context;

    public static int checkpoint;


    private TextView currentItemName,
            selectedItemNum,
            quantityLeftinHold,
            currentPrice,
            quantityLeftinMarket;

    private Button addItem, subtractItem;

    public ShipAdapter(Context context, List<Ship> myOrders) {
        super(context, 0, myOrders);
        this.list = myOrders;
        this.context = context;
        this.checkpoint = Repository.playerClass.getCredits();
    }

    public View getView(final int position, final View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.content_shipyard, parent,false
            );
        }

        final Ship currentItem = getItem(position);

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
        quantityLeftinHold.setText("" + currentItem.getQuantityOwned());
        selectedItemNum.setText(""+ currentItem.getQuantityChange());
        quantityLeftinMarket.setText("" + currentItem.getQuantityInMarket());


        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Repository.isitBuying) {

                    if (checkpoint >= 0 && currentItem.getQuantityInMarket() > 0) {
                        if ( (checkpoint - currentItem.getPrice()) >= 0 ) {
                            currentItem.addToQuantityChange();
                            currentItem.addToQuanitiyinHold();
                            currentItem.removeFromQuantityinMarket();
                            checkpoint -= (currentItem.getPrice());

                            System.out.println(checkpoint);
                        }
                    }

                } else if (!Repository.isitBuying) {
                    // selling
                    if (currentItem.getQuantityOwned() > 0 && currentItem.getQuantityChange() < currentItem.getQuantityOwned()) {
                        currentItem.addToQuantityChange();
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
                        currentItem.removeFromQuantityChange();
                        currentItem.removeFromQuantityinHold();
                        currentItem.addToQuantityinMarket();
                        checkpoint += (currentItem.getPrice());

                        System.out.println(checkpoint);
                    }
                } else {
                    // selling
                    if (currentItem.getQuantityChange() != 0) {
                        currentItem.removeFromQuantityChange();
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
