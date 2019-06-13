package com.example.m4.views;

// import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
// import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import com.example.m4.R;

import org.w3c.dom.Text;
// import com.example.m4.viewmodels.ConfigurationViewModel;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    // private ConfigurationViewModel viewModel;

    private Spinner difficultySpinner;
    private TextView score;

    private Button pilot_plus;
    private Button pilot_minus;
    private Button fighter_plus;
    private Button fighter_minus;
    private Button trader_plus;
    private Button trader_minus;
    private Button engineer_plus;
    private Button engineer_minus;

    private TextView pilot_points;
    private TextView fighter_points;
    private TextView trader_points;
    private TextView engineer_points;


    int int_score = 16;

    int pilot = 0;
    int fighter = 0;
    int trader = 0;
    int engineer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        difficultySpinner = findViewById(R.id.difficulty_spinner);
        String[] list = new String[]{"Beginner", "Easy", "Normal", "Hard", "Impossible"};

        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);

        score = findViewById(R.id.skill_points_number);

        pilot_points = findViewById(R.id.pilot_points);
        fighter_points = findViewById(R.id.fighter_points);
        trader_points = findViewById(R.id.trader_points);
        engineer_points = findViewById(R.id.engineer_points);


        // viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        pilot_plus = findViewById(R.id.pilot_plus);
        pilot_plus.setOnClickListener(this);

        pilot_minus = findViewById(R.id.pilot_minus);
        pilot_minus.setOnClickListener(this);

        fighter_plus = findViewById(R.id.fighter_plus);
        fighter_plus.setOnClickListener(this);

        fighter_minus = findViewById(R.id.fighter_minus);
        fighter_minus.setOnClickListener(this);

        trader_plus = findViewById(R.id.trader_plus);
        trader_plus.setOnClickListener(this);

        trader_minus = findViewById(R.id.trader_minus);
        trader_minus.setOnClickListener(this);

        engineer_plus = findViewById(R.id.engineer_plus);
        engineer_plus.setOnClickListener(this);

        engineer_minus = findViewById(R.id.engineer_minus);
        engineer_minus.setOnClickListener(this);

    }

    @Override
    public void onClick (View v) {

        if (int_score <= 16 && int_score >= 0) {

            if (v.getId() == R.id.pilot_plus ||
                    v.getId() == R.id.fighter_plus ||
                    v.getId() == R.id.trader_plus ||
                    v.getId() == R.id.engineer_plus) {
                if (int_score != 0) {

                    if (v.getId() == R.id.pilot_plus && pilot < 16) {
                        pilot++;
                        pilot_points.setText(String.valueOf(pilot));
                        int_score--;
                        score.setText(String.valueOf(int_score));

                    } else if (v.getId() == R.id.fighter_plus && fighter < 16) {
                        fighter++;
                        fighter_points.setText(String.valueOf(fighter));
                        int_score--;
                        score.setText(String.valueOf(int_score));

                    } else if (v.getId() == R.id.trader_plus && trader < 16) {
                        trader++;
                        trader_points.setText(String.valueOf(trader));
                        int_score--;
                        score.setText(String.valueOf(int_score));

                    } else if (v.getId() == R.id.engineer_plus && engineer < 16) {
                        engineer++;
                        engineer_points.setText(String.valueOf(engineer));
                        int_score--;
                        score.setText(String.valueOf(int_score));

                    }
                }
            }
            if (v.getId() == R.id.pilot_minus ||
                    v.getId() == R.id.fighter_minus ||
                    v.getId() == R.id.trader_minus ||
                    v.getId() == R.id.engineer_minus) {
                if (int_score != 16) {

                    if (v.getId() == R.id.pilot_minus && pilot > 0) {
                        pilot--;
                        pilot_points.setText(String.valueOf(pilot));
                        int_score++;
                        score.setText(String.valueOf(int_score));

                    } else if (v.getId() == R.id.fighter_minus && fighter > 0) {
                        fighter--;
                        fighter_points.setText(String.valueOf(fighter));
                        int_score++;
                        score.setText(String.valueOf(int_score));

                    } else if (v.getId() == R.id.trader_minus && trader > 0) {
                        trader--;
                        trader_points.setText(String.valueOf(trader));
                        int_score++;
                        score.setText(String.valueOf(int_score));

                    } else if (v.getId() == R.id.engineer_minus && engineer > 0){
                        engineer--;
                        engineer_points.setText(String.valueOf(engineer));
                        int_score++;
                        score.setText(String.valueOf(int_score));

                    }
                }
            }
        }
    }

}