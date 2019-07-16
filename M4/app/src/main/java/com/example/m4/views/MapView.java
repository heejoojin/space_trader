package com.example.m4.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m4.R;

/**
 * Creates a grid that will depict all the regions
 */
public class MapView extends AppCompatActivity implements View.OnClickListener {

    final static int HEIGHT = 150;
    final static int WIDTH = 100;
    int tileSize;
    private Context context;

    private ImageView[][] mapGrid = new ImageView[HEIGHT][WIDTH];
    private Drawable tilePaint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        context = this.getApplicationContext();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        tileSize = displayMetrics.widthPixels / WIDTH;

        tilePaint = context.getResources().getDrawable(R.drawable.cell);

        Button backButton = findViewById(R.id.map_back_button);
        LinearLayout grid = findViewById(R.id.mapSquare);
        layTiles(grid);

    }

    private void layTiles(LinearLayout grid) {
        LinearLayout.LayoutParams rows = new LinearLayout.LayoutParams(tileSize*WIDTH, tileSize);
        LinearLayout.LayoutParams tile = new LinearLayout.LayoutParams(tileSize, tileSize);

        for (int i = 0; i < HEIGHT; i++) {

            LinearLayout row = new LinearLayout(context);

            for (int j = 0; j < WIDTH; j++) {
                mapGrid[i][j] = new ImageView(context);
                mapGrid[i][j].setBackground(tilePaint);
                row.addView(mapGrid[i][j], tile);
            }
            grid.addView(row, rows);

        }
    }

    @Override
    public void onClick(View view) {}


}
