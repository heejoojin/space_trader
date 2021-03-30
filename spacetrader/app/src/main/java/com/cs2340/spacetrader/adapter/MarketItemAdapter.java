package com.cs2340.spacetrader.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.cs2340.spacetrader.R;
import com.cs2340.spacetrader.model.Item;
import com.cs2340.spacetrader.repository.Repository;

import java.util.List;

/**
 * class MarketItemAdapter
 */
@SuppressWarnings({"FieldCanBeLocal", "unused", "FeatureEnvy",
        "PublicField", "AssignmentOrReturnOfFieldWithMutableType",
        "AssignmentToStaticFieldFromInstanceMethod", "NullableProblems"})
public class MarketItemAdapter extends ArrayAdapter<Item>{

    private final List<Item> list;
    private final Context context;

    public static int checkpoint;


    private TextView currentItemName;
    private TextView selectedItemNum;

    private TextView quantityLeftinHold;
    private TextView currentPrice;
    private TextView quantityLeftinMarket;

    private Button addItem;
    private Button subtractItem;

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
    @SuppressWarnings("ChainedMethodCall")
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
        quantityLeftinHold = listItemView.findViewById(R.id.quantity_owned_left_num);
        subtractItem = listItemView.findViewById(R.id.minus_item_button);
        selectedItemNum = listItemView.findViewById(R.id.selected_item_amount);
        addItem = listItemView.findViewById(R.id.hire_fire_button);
        currentPrice = listItemView.findViewById(R.id.selected_item_price);
        quantityLeftinMarket = listItemView.findViewById(R.id.quantity_left_in_market_num);


        assert currentItem != null;
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

                    if ((checkpoint >= 0) && (currentItem.getQuantityInMarket() > 0)) {
                        if (((checkpoint - currentItem.getPrice()) >= 0)) {

                            currentItem.addToQuantityChange();
                            currentItem.addToQuantityInHold();

                            currentItem.removeFromQuantityInMarket();
                            checkpoint -= (currentItem.getPrice());

                            Repository.playerClass.setCredits(checkpoint);

                            //System.out.println(checkpoint);
                        }
                    }

                } else {
                    // selling
                    if ((currentItem.getQuantityOwned() > 0) &&
                            (currentItem.getQuantityChange() < currentItem.getQuantityOwned())) {
                        currentItem.addToQuantityChange();
                        currentItem.removeFromQuantityInHold();
                        currentItem.addToQuantityInMarket();

                        checkpoint += (currentItem.getPrice());

                        Repository.playerClass.setCredits(checkpoint);

                        //System.out.println(checkpoint);
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
                        currentItem.removeFromQuantityInHold();
                        currentItem.addToQuantityInMarket();

                        checkpoint += (currentItem.getPrice());

                        Repository.playerClass.setCredits(checkpoint);

                        //System.out.println(checkpoint);
                    }
                } else {
                    // selling
                    if (currentItem.getQuantityChange() != 0) {
                        currentItem.removeFromQuantityChange();
                        currentItem.addToQuantityInHold();
                        currentItem.removeFromQuantityInMarket();

                        checkpoint -= (currentItem.getPrice());

                        Repository.playerClass.setCredits(checkpoint);

                        //System.out.println(checkpoint);
                    }
                }
                notifyDataSetChanged();
            }
        });

        return listItemView;
    }
}
