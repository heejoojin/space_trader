package com.example.m4.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.m4.R;
import com.example.m4.repository.Repository;
import com.example.m4.viewmodels.RandomEventViewModel;

import java.util.Random;

/**
 * View class that shows random events occurring when traveling between regions
 */

@SuppressWarnings("CyclicClassDependency")
public class RandomEventView extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomevent);

        TextView travelMessage = findViewById(R.id.travel_message);

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);

        RandomEventViewModel viewModel = ViewModelProviders.of(this).get(RandomEventViewModel.class);
        int randomElement = viewModel.getRandomElement();
        boolean isitaddingCredits = viewModel.chanceGettingCredits();

        if (randomElement == 0) {
            travelMessage.setText("After an eventful trip," +
                    "\nyou couldn't arrive at your destination :(\n\nTry again");
        } else {
            if (isitaddingCredits) {
                travelMessage.setText("After an eventful trip," +
                        "\nyou couldn't arrive at your destination :(\n" +
                        "but you just found " + randomElement + "credits! Congrats!" +
                        "\n\nTry again to travel to your destination");

                Repository.playerClass.setCredits(Repository.playerClass.getCredits() + randomElement);

            } else {
                travelMessage.setText("After an eventful trip," +
                        "\nyou couldn't arrive at your destination :(\n" +
                        "and you just got robbed of " + randomElement + "credits" +
                        "\n\nTry again to travel to your destination");

                Repository.playerClass.setCredits(Repository.playerClass.getCredits() - randomElement);
            }
        }


    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            startActivity(new Intent(this, UniverseView.class));
        }

    }

}
