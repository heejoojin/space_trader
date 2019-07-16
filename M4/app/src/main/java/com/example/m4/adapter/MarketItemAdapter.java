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
import com.example.m4.repository.Repository;

import java.util.List;

/**
 * class MarketItemAdapter
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class MarketItemAdapter extends ArrayAdapter<Item>{

    private final List<Item> list;
    private final Context context;

    public static int checkpoint;

    private int count = 5;


    private TextView currentItemName,
            selectedItemNum,
            quantityLeftinHold,
            currentPrice,
            quantityLeftinMarket;

    private Button addItem, subtractItem;

    /**
     * Default ArrayAdapter constructor
     * @param context context
     * @param myOrders list of Item objects
     */
    public MarketItemAdapter(Context context, List<Item> myOrders) {
        super(context, 0, myOrders);
        this.list = myOrders;
        this.context = context;
        checkpoint = Repository.playerClass.getCredits();
    }

    /**
     * getView method, overridden
     * @param position position
     * @param convertView a view
     * @param parent a viewGroup
     */
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.content_market, parent,false
            );
        }

        final Item currentItem = getItem(position);

        currentItemName = listItemView.findViewById(R.id.selected_item_name);
        quantityLeftinHold = listItemView.findViewById(R.id.quantityowned_left_num);
        subtractItem = listItemView.findViewById(R.id.minus_item_button);
        selectedItemNum = listItemView.findViewById(R.id.selected_item_amount);
        addItem = listItemView.findViewById(R.id.hire_fire_button);
        currentPrice = listItemView.findViewById(R.id.selected_item_price);
        quantityLeftinMarket = listItemView.findViewById(R.id.quantity_leftinmarket_num);


        //Set the text of the meal, amount and quantity
        currentItemName.setText(currentItem.getName());
        String m1 = "$ " + currentItem.getPrice();
        currentPrice.setText(m1);
        String m2 = "" + currentItem.getQuantityOwned();
        quantityLeftinHold.setText(m2);
        String m3 = ""+ currentItem.getQuantityChange();
        selectedItemNum.setText(m3);
        String m4 = "" + currentItem.getQuantityInMarket();
        quantityLeftinMarket.setText(m4);


        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Repository.isitBuying) {

                    if (checkpoint >= 0 && currentItem.getQuantityInMarket() > 0) {
                        if ( (checkpoint - currentItem.getPrice()) >= 0 && count > 0) {

                            count--;

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
