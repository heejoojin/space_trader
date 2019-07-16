package com.example.m4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.m4.R;
import com.example.m4.model.Mercenary;
import com.example.m4.repository.Repository;

import java.util.List;


/**
class MercenaryAdapter
 */
@SuppressWarnings("FieldCanBeLocal")
public class MercenaryAdapter extends ArrayAdapter<Mercenary>{

    private final List<Mercenary> list;
    private final Context context;

    public static int checkpoint;

    public int count = 5;


    TextView currentItemName,
            hired,
            weapon,
            currentPrice;

    Button hireFireMerc;

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
                        if ( (checkpoint - currentItem.getPrice()) >= 0 && count > 0) {

                            count--;

                            currentItem.setHired(true);
                            hired.setText("HIRED");

                            checkpoint -= currentItem.getPrice();

                            System.out.println(checkpoint);
                        }
                    }

                } else if (!Repository.isitBuying) {
                    // selling
                    if (currentItem.getHired()) {
                        currentItem.setHired(false);
                        hired.setText("NOT HIRED");


                        System.out.println(checkpoint);
                    }
                }
                notifyDataSetChanged();

            }
        });


        return listItemView;
    }
}
