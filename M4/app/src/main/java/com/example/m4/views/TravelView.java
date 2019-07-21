package com.example.m4.views;
import com.example.m4.repository.Repository;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.example.m4.R;
import com.example.m4.viewmodels.TravelViewModel;

import java.text.DecimalFormat;
import android.annotation.SuppressLint;

/**
 * View that will depict the traveling of our ship. Will also show random events that occur
 */
@SuppressWarnings({"FeatureEnvy", "ChainedMethodCall", "MagicNumber", "CyclicClassDependency"})
@SuppressLint("SetTextI18n")
public class TravelView extends AppCompatActivity implements View.OnClickListener {

    private TextView travelMessage;
    private TextView region_display_textview;
    private Button nextButton;
    private Button backButton;
    private final DecimalFormat formatter = new DecimalFormat("#,###,###");
    private String region_display_message;

    private TravelViewModel viewModel;
    private String creditLeft;
    private String pirateMessage;

    private String[] tradegoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        travelMessage = findViewById(R.id.travel_message);

        nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(this);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);

        region_display_textview = findViewById(R.id.region_display_view);

        viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);
        String randomElement = viewModel.getRandomElement();

        String fuel_initial = formatter.format(Repository.playerClass.getFuel());
        region_display_message = "You are in " + Repository.toTravelRegionName.toString() +
                "\n" + Repository.playerClass.getShip() + " | Fuel "  +
                fuel_initial + " L available";
        region_display_textview.setText(region_display_message);

        // "Trader Encounter", "Pirate Encounter", "Police Encounter", "Safe Travel"

        switch (randomElement) {
            case "Trader Encounter":

                if (!Repository.transactionHistory) {
                    travelMessage.setText("You have encountered a trader!\n" +
                            "\nYou have no items to trade\nGo to the market and buy some goods :)");
                } else {
                    tradegoods = viewModel.tradeGoods();

                    if (tradegoods[0] != null) {
                        travelMessage.setText("You have encountered a trader!\n" +
                                "\nYou have some items available in your cargo\n" +
                                "Do you want to trade some goods?");

                        backButton.setText("Yes");
                        nextButton.setText("No & Move on");
                    }
                }

                break;
            case "Pirate Encounter":
                Repository.playerClass.setCredits(Repository.playerClass.getCredits() - 150);
                creditLeft = String.valueOf(Repository.playerClass.getCredits());
                pirateMessage = "You have encountered a pirate!\n" +
                        "\nThe pirate took 150 credits from you :(\nNow you have " +
                        creditLeft +
                        " credits\n\nIf you fight him,\nyou could get your money back or\n" +
                        "you may lose even more.";
                travelMessage.setText(pirateMessage);

                region_display_textview.setText("");

                backButton.setText("Fight !");
                nextButton.setText("Surrender & Next");

                break;
            case "Police Encounter":

                travelMessage.setText("You have encountered a police!\n" +
                        "\nSince you don't have any illegal goods," +
                        "\nyou don't need to pay any fines :)");

                break;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next_button) {
            startActivity(new Intent(this, PlanetsView.class));

        } else if (view.getId() == R.id.back_button) {
            if (viewModel.getIsItPirate()) {

                backButton.setText("Back");
                nextButton.setText("Next");
                viewModel.setIsItPirate(false);

                String fuel_initial = formatter.format(Repository.playerClass.getFuel());
                region_display_message = "You are in " +
                        Repository.toTravelRegionName.toString() +
                        "\n" + Repository.playerClass.getShip() + " | Fuel "  +
                        fuel_initial + " L available";
                region_display_textview.setText(region_display_message);

                // fight
                if (viewModel.winningChancePirate()) {
                    Repository.playerClass.setCredits(Repository.playerClass.getCredits() + 150);
                    creditLeft = String.valueOf(Repository.playerClass.getCredits());
                    pirateMessage = "You beat the pirate!\n" +
                            "You have collected your 150 credits back :)" +
                            "\nNow you have " + creditLeft + " credits";
                    travelMessage.setText(pirateMessage);

                } else {
                    Repository.playerClass.setCredits(Repository.playerClass.getCredits() - 200);
                    creditLeft = String.valueOf(Repository.playerClass.getCredits());
                    pirateMessage = "You lost!\nThe pirate took 200 more credits from you :(" +
                            "\nNow you have " + creditLeft + " credits";
                    travelMessage.setText(pirateMessage);
                }

            } else if (Repository.transactionHistory && viewModel.getIsItTrader() &&
                    tradegoods[0] != null) {
                // trade
                String[] arr = viewModel.tradeGoods();
                travelMessage.setText("You have traded your " + arr[0] +
                        "\nwith his " + arr[1]);
                backButton.setText("Back");
                nextButton.setText("Next");

            } else {
                startActivity(new Intent(this, UniverseView.class));
            }

        }
    }
}