package com.example.m4.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m4.R;
import com.example.m4.model.Colors;
import com.example.m4.model.Planet;
import com.example.m4.model.Region;
import com.example.m4.repository.Repository;

/**
 * Creates a grid that will depict all the regions
 */
@SuppressWarnings("ALL")
public class MapView extends AppCompatActivity implements View.OnClickListener {

    final static int HEIGHT = 150;
    final static int WIDTH = 100;
    int tileSize;
    private Context context;

    private ImageView[][] mapGrid = new ImageView[HEIGHT][WIDTH];
    private Button backButton;
    private LinearLayout grid;
    private Drawable tilePaint;
    private Drawable orangePaint;
    private Drawable bluePaint;
    private Drawable burgundyPaint;
    private Drawable darkgreenPaint;
    private Drawable greenPaint;
    private Drawable greyPaint;
    private Drawable lightorangePaint;
    private Drawable navyPaint;
    private Drawable purplePaint;
    private Drawable redPaint;
    private Drawable whitePaint;
    private Drawable yellowPaint;

    /**
     * Overridden onCreate method initialize activity
     * @param savedInstanceState saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        context = this.getApplicationContext();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        tileSize = displayMetrics.widthPixels / WIDTH;

        tilePaint = context.getResources().getDrawable(R.drawable.cell);
        orangePaint = context.getResources().getDrawable(R.drawable.orange);
        bluePaint = context.getResources().getDrawable(R.drawable.blue);
        burgundyPaint = context.getResources().getDrawable(R.drawable.burgundy);
        darkgreenPaint = context.getResources().getDrawable(R.drawable.darkgreen);
        greenPaint = context.getResources().getDrawable(R.drawable.green);
        greyPaint = context.getResources().getDrawable(R.drawable.grey);
        lightorangePaint = context.getResources().getDrawable(R.drawable.lightorange);
        navyPaint = context.getResources().getDrawable(R.drawable.navy);
        purplePaint = context.getResources().getDrawable(R.drawable.purple);
        redPaint = context.getResources().getDrawable(R.drawable.red);
        whitePaint = context.getResources().getDrawable(R.drawable.white);
        yellowPaint = context.getResources().getDrawable(R.drawable.yellow);

        backButton = findViewById(R.id.map_back_button);
        backButton.setOnClickListener(this);
        grid = findViewById(R.id.mapSquare);
        layTiles(grid);

    }

    private void layTiles(LinearLayout grid) {
        LinearLayout.LayoutParams rows = new LinearLayout.LayoutParams(tileSize*WIDTH, tileSize);
        LinearLayout.LayoutParams tile = new LinearLayout.LayoutParams(tileSize, tileSize);
        boolean isPlanet = false;

        for (int y = 0; y < HEIGHT; y++) {

            LinearLayout row = new LinearLayout(context);

            for (int x = 0; x < WIDTH; x++) {
                mapGrid[y][x] = new ImageView(context);

                isPlanet = false;
                Planet currentPlanet = null;

                for (Region region: Repository.universeClass.getRegions()) {
                    for (Planet planet: region.getPlanetList()) {
                        if (planet.getyLocation() == y && planet.getxLocation() == x) {
                            isPlanet = true;
                            currentPlanet = planet;
                        }
                    }
                }

                if (isPlanet) {
                    if (currentPlanet.getColor() == Colors.BLUE) {
                        mapGrid[y][x].setBackground(bluePaint);
                    } else if (currentPlanet.getColor() == Colors.BURGUNDY) {
                        mapGrid[y][x].setBackground(burgundyPaint);
                    } else if (currentPlanet.getColor() == Colors.DARK_GREEN) {
                        mapGrid[y][x].setBackground(darkgreenPaint);
                    } else if (currentPlanet.getColor() == Colors.GREEN) {
                        mapGrid[y][x].setBackground(greenPaint);
                    } else if (currentPlanet.getColor() == Colors.GREY) {
                        mapGrid[y][x].setBackground(greyPaint);
                    } else if (currentPlanet.getColor() == Colors.LIGHT_ORANGE) {
                        mapGrid[y][x].setBackground(lightorangePaint);
                    } else if (currentPlanet.getColor() == Colors.NAVY) {
                        mapGrid[y][x].setBackground(navyPaint);
                    } else if (currentPlanet.getColor() == Colors.ORANGE) {
                        mapGrid[y][x].setBackground(orangePaint);
                    } else if (currentPlanet.getColor() == Colors.PURPLE) {
                        mapGrid[y][x].setBackground(purplePaint);
                    } else if (currentPlanet.getColor() == Colors.RED) {
                        mapGrid[y][x].setBackground(redPaint);
                    } else if (currentPlanet.getColor() == Colors.WHITE) {
                        mapGrid[y][x].setBackground(whitePaint);
                    } else {
                        mapGrid[y][x].setBackground(yellowPaint);
                    }
                } else {
                    mapGrid[y][x].setBackground(tilePaint);
                }
                row.addView(mapGrid[y][x], tile);
            }
            grid.addView(row, rows);

        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.map_back_button) {
            startActivity(new Intent(this, UniverseView.class));
        }
    }


}