package com.example.m4.views;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import com.example.m4.R;
import com.example.m4.model.Difficulty;
import com.example.m4.viewmodels.ConfigurationViewModel;
import com.example.m4.model.Player;
import com.example.m4.repository.Repository;

/**
 * Configuration view setting up the UI for the inital screen the user will encounter when starting
 * a new game
 */
public class ConfigurationView extends AppCompatActivity implements OnClickListener {

    private ConfigurationViewModel viewModel;

    private Player player = new Player("", 0, 0, 0, 0);


    private EditText name;

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

    private Button exit;
    private Button okay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        name = findViewById(R.id.name_input);

        difficultySpinner = findViewById(R.id.difficulty_spinner);

        ArrayAdapter<Difficulty> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Difficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);

        score = findViewById(R.id.skill_points_number);

        pilot_points = findViewById(R.id.pilot_points);
        fighter_points = findViewById(R.id.fighter_points);
        trader_points = findViewById(R.id.trader_points);
        engineer_points = findViewById(R.id.engineer_points);

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

        exit = findViewById(R.id.exit_button);
        exit.setOnClickListener(this);

        okay = findViewById(R.id.okay_button);
        okay.setOnClickListener(this);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
    }

    @Override
    public void onClick (View v) {

        if (v.getId() == R.id.exit_button) {
            System.exit(0);
        }

        if (viewModel.getScore() <= 16 && viewModel.getScore() >= 0) {

            if (v.getId() == R.id.pilot_plus ||
                    v.getId() == R.id.fighter_plus ||
                    v.getId() == R.id.trader_plus ||
                    v.getId() == R.id.engineer_plus) {

                if (viewModel.getScore() != 0 &&
                        player.getPilotPoints() < 16 &&
                        player.getFighterPoints() < 16 &&
                        player.getTraderPoints() < 16 &&
                        player.getEngineerPoints() < 16) {

                    viewModel.setScore(viewModel.getScore() - 1);
                    score.setText(String.valueOf(viewModel.getScore()));

                    if (v.getId() == R.id.pilot_plus) {
                        player.setPilotPoints(player.getPilotPoints() + 1);
                        pilot_points.setText(String.valueOf(player.getPilotPoints()));

                    } else if (v.getId() == R.id.fighter_plus) {
                        player.setFighterPoints(player.getFighterPoints() + 1);
                        fighter_points.setText(String.valueOf(player.getFighterPoints()));

                    } else if (v.getId() == R.id.trader_plus) {
                        player.setTraderPoints(player.getTraderPoints() + 1);
                        trader_points.setText(String.valueOf(player.getTraderPoints()));

                    } else if (v.getId() == R.id.engineer_plus) {
                        player.setEngineerPoints(player.getEngineerPoints() + 1);
                        engineer_points.setText(String.valueOf(player.getEngineerPoints()));
                    }
                }

//                if (viewModel.getScore() == 0) {
//                    String m = "You have used all of your points";
//                    Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
//                    Toast toast = new Toast(getApplicationContext());
//                    TextView tv = new TextView(this);
//                    tv.setT;
//                    Typeface t = Typeface.create("work_sans", Typeface.NORMAL);
//
//                            Toast.makeText(, m, Toast.LENGTH_SHORT);
//                }
            }
            if (v.getId() == R.id.pilot_minus ||
                    v.getId() == R.id.fighter_minus ||
                    v.getId() == R.id.trader_minus ||
                    v.getId() == R.id.engineer_minus) {

                if (viewModel.getScore() != 16) {

                    if (v.getId() == R.id.pilot_minus && player.getPilotPoints() > 0) {

                        player.setPilotPoints(player.getPilotPoints() - 1);
                        pilot_points.setText(String.valueOf(player.getPilotPoints()));

                        viewModel.setScore(viewModel.getScore() + 1);
                        score.setText(String.valueOf(viewModel.getScore()));

                    } else if (v.getId() == R.id.fighter_minus && player.getFighterPoints() > 0) {

                        player.setFighterPoints(player.getFighterPoints() - 1);
                        fighter_points.setText(String.valueOf(player.getFighterPoints()));

                        viewModel.setScore(viewModel.getScore() + 1);
                        score.setText(String.valueOf(viewModel.getScore()));

                    } else if (v.getId() == R.id.trader_minus && player.getTraderPoints() > 0) {

                        player.setTraderPoints(player.getTraderPoints() - 1);
                        trader_points.setText(String.valueOf(player.getTraderPoints()));

                        viewModel.setScore(viewModel.getScore() + 1);
                        score.setText(String.valueOf(viewModel.getScore()));

                    } else if (v.getId() == R.id.engineer_minus && player.getEngineerPoints() > 0){

                        player.setEngineerPoints(player.getEngineerPoints() - 1);
                        engineer_points.setText(String.valueOf(player.getEngineerPoints()));

                        viewModel.setScore(viewModel.getScore() + 1);
                        score.setText(String.valueOf(viewModel.getScore()));
                    }
                }
            }

        }

        if (v.getId() == R.id.okay_button) {
            if (viewModel.getScore() != 0) {
                startActivity(new Intent(ConfigurationView.this, ErrorView.class));
            } else if (viewModel.getScore() == 0) {

                player.setDifficulty((Difficulty) difficultySpinner.getSelectedItem());
                player.setName(name.getText().toString());

                Repository.setPlayerClass(player);

                startActivity(new Intent(ConfigurationView.this, CreatePlayerView.class));
            }
        }
    }
}
