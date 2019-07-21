package com.example.m4.views;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.graphics.Paint;

import com.example.m4.R;
import com.example.m4.model.Player;
import com.example.m4.repository.Repository;

/**
 * The main activity view which contains the start and exit button as well as mini games
 */
@SuppressWarnings("ChainedMethodCall")
public class MainActivity extends AppCompatActivity implements OnClickListener {

    //private final Player player = new Player("", 0, 0, 0, 0);


    /**
     * Overridden onCreate method initialize activity
     * @param savedInstanceState saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button open = findViewById(R.id.main_start_button);
        open.setOnClickListener(this);

        Button exit = findViewById(R.id.main_exit_button);
        exit.setOnClickListener(this);

        TextView title = findViewById(R.id.game_title_view);

        title.getPaint().setStrokeWidth(5);
        title.getPaint().setStyle(Paint.Style.STROKE);

        Button minigame = findViewById(R.id.mini_game_button);
        minigame.setOnClickListener(this);

    }


    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.main_start_button) {
            if (Repository.playerClass == null) {
                Repository.saveItemMap();
                Repository.saveMercenaryMap();
                startActivity(new Intent(MainActivity.this, ConfigurationView.class));
            } else {
                startActivity(new Intent(MainActivity.this, PlayerView.class));
            }
        } else if (v.getId() == R.id.main_exit_button) {
            finish();
        } else if (v.getId() == R.id.mini_game_button) {
            startActivity(new Intent(MainActivity.this, MiniGameView.class));
        }
    }
}