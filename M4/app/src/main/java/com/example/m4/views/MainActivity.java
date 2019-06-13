package com.example.m4.views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
// import android.widget.EditText;
import android.widget.Spinner;
// import android.widget.TextView;

import com.example.m4.R;
import com.example.m4.viewmodels.ConfigurationViewModel;

public class MainActivity extends AppCompatActivity {

    // private ConfigurationViewModel viewModel;

    private Spinner difficultySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        difficultySpinner = findViewById(R.id.difficulty_spinner);
        String[] list = new String[]{"Beginner", "Easy", "Normal", "Hard", "Impossible"};

        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);

        // viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
    }
}