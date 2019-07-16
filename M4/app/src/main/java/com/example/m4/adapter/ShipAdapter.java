package com.example.m4.adapter;
import com.example.m4.R;
import com.example.m4.model.Ship;
import com.example.m4.repository.Repository;

import android.graphics.Color;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

/**
 * class ShipAdapter
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class ShipAdapter extends ArrayAdapter<Ship> {

    private final List<Ship> list;
    private final Context context;

    /**
     * Default ArrayAdapter constructor
     * @param context context
     * @param myOrders list of Ship objects
     */
    public ShipAdapter(Context context, List<Ship> myOrders) {
        super(context, 0, myOrders);
        this.list = myOrders;
        this.context = context;
    }

    /**
     * getView method, overridden
     * @param position position
     * @param convertView a view
     * @param parent a viewGroup
     */
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View listShipView = convertView;
        if (listShipView == null) {
            listShipView = LayoutInflater.from(getContext()).inflate(
                    R.layout.content_shipyard, parent, false
            );
        }
        final Ship currentShip = getItem(position);
        TextView currentShipName = listShipView.findViewById(R.id.selected_ship_name);
        TextView shipEquipment = listShipView.findViewById(R.id.selected_ship_cap);

        currentShipName.setText(currentShip.getName());
        String equipment = String.format("has %s, %s, %s, %s, %s",
                currentShip.getWeapon(),
                currentShip.getShield(),
                currentShip.getGadget(),
                currentShip.getEscapePod(),
                currentShip.getInsurance());
        shipEquipment.setText(equipment);

        listShipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View currentview = view;
                currentview.setBackgroundColor(Color.parseColor("#e8dae8"));
                currentview.postDelayed(new Runnable() {

                    public void run() {
                        currentview.setBackgroundColor(Color.parseColor("#fafafa"));
                    }
                }, 1000);
                Repository.setShipClass(currentShip);
                notifyDataSetChanged();
            }

        });

        return listShipView;
    }
}
