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
public class MarketItemAdapter extends ArrayAdapter<Item>{

    private List<Item> list;
    private Context context;

    public static int checkpoint;

    public int count = 5;


    TextView currentItemName,
            selectedItemNum,
            quantityLeftinHold,
            currentPrice,
            quantityLeftinMarket;

    Button addItem, subtractItem;

    /**
     * Default ArrayAdapter constructor
     * @param context context
     * @param myOrders list of Item objects
     */
    public MarketItemAdapter(Context context, List<Item> myOrders) {
        super(context, 0, myOrders);
        this.list = myOrders;
        this.context = context;
        this.checkpoint = Repository.playerClass.getCredits();
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

        currentItemName = (TextView)listItemView.findViewById(R.id.selected_item_name);
        quantityLeftinHold = (TextView)listItemView.findViewById(R.id.quantityowned_left_num);
        subtractItem = (Button)listItemView.findViewById(R.id.minus_item_button);
        selectedItemNum = (TextView)listItemView.findViewById(R.id.selected_item_amount);
        addItem = (Button)listItemView.findViewById(R.id.hire_fire_button);
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
