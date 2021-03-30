package com.cs2340.spacetrader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.spacetrader.R;
import com.cs2340.spacetrader.model.Mercenary;
import com.cs2340.spacetrader.repository.Repository;

import java.util.List;


/**
class MercenaryAdapter
 */
@SuppressWarnings({"FieldCanBeLocal", "WeakerAccess",
        "SetTextI18n", "unused", "FeatureEnvy",
        "ChainedMethodCall", "PublicField",
        "AssignmentOrReturnOfFieldWithMutableType",
        "AssignmentToStaticFieldFromInstanceMethod",
        "NullableProblems"})

public class MercenaryAdapter extends ArrayAdapter<Mercenary>{

    private final List<Mercenary> list;
    private final Context context;

    public static int checkpoint;

    private TextView currentItemName;
    private TextView hired;
    private TextView weapon;
    private TextView currentPrice;

    private Button hireFireMerc;

    /**
     * Default ArrayAdapter constructor
     * @param context context
     * @param myOrders list of Mercenary objects
     */
    public MercenaryAdapter(Context context, List<Mercenary> myOrders) {
        super(context, 0 ,myOrders);
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
                    R.layout.content_mercenary, parent,false
            );
        }

        final Mercenary currentItem = getItem(position);

        currentItemName = listItemView.findViewById(R.id.selected_item_name);
        hireFireMerc = listItemView.findViewById(R.id.hire_fire_button);
        currentPrice = listItemView.findViewById(R.id.selected_item_price);
        hired = listItemView.findViewById(R.id.hired);
        weapon = listItemView.findViewById(R.id.weapon_equipped);


        //Set the text of the meal, amount and quantity
        assert currentItem != null;
        currentItemName.setText(currentItem.getName());
        if (currentItem.getHired()) {
            hired.setText("HIRED");

        } else {
            hired.setText("NOT HIRED");
        }
        weapon.setText(currentItem.getWeapon());
        currentPrice.setText("$ " + currentItem.getPrice());


        hireFireMerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Repository.isitBuying) {

                    if (checkpoint >= 0) {
                        if (((checkpoint - currentItem.getPrice()) >= 0) &&
                                !currentItem.getHired()) {

                            currentItem.setHired(true);
                            hired.setText("HIRED");
                            currentItem.setQuantityChange(1);

                            checkpoint -= currentItem.getPrice();

                            Repository.playerClass.setCredits(checkpoint);

                            //System.out.println(checkpoint);
                        }
                    }

                } else {
                    // selling
                    if (currentItem.getHired()) {
                        currentItem.setQuantityChange(1);
                        currentItem.setHired(false);
                        hired.setText("NOT HIRED");
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
