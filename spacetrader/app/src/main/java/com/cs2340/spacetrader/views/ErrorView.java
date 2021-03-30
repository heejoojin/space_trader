package com.cs2340.spacetrader.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cs2340.spacetrader.R;

/**
 * Shown if an error with the configuration is encountered,
 * such as incorrect amount of points allocated
 */
public class ErrorView extends AppCompatActivity {

    /**
     * Overridden onCreate method initialize activity
     * @param savedInstanceState saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

    }
}

