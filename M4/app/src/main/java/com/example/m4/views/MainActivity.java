package com.example.m4.views;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.m4.R;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button openM4;
    private Button exitM4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openM4 = findViewById(R.id.main_button);
        openM4.setOnClickListener(this);

        exitM4 = findViewById(R.id.exitM4_button);
        exitM4.setOnClickListener(this);

    }

    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.main_button) {
            startActivity(new Intent(MainActivity.this, ConfigurationView.class));
        } else if (v.getId() == R.id.exitM4_button) {
            System.exit(0);
        }
    }
}