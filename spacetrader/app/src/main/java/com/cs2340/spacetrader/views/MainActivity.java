package com.cs2340.spacetrader.views;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.graphics.Paint;

import com.cs2340.spacetrader.R;
import com.cs2340.spacetrader.repository.Repository;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import com.google.android.gms.tasks.OnFailureListener;
import androidx.annotation.NonNull;


/**
 * The main activity view which contains the start and exit button as well as mini games
 */
//@SuppressWarnings("ChainedMethodCall")
@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements OnClickListener {

    //private final Player player = new Player("", 0, 0, 0, 0);
    private MediaPlayer mySong;
    private StorageReference storage = FirebaseStorage.getInstance().
            getReferenceFromUrl("gs://cs2340-d0e6c.appspot.com/");
    private UploadTask uploadTask;
    private ImageView image;
    private boolean isitPaused;
    private Button music;

    /**
     * Overridden onCreate method initialize activity
     * @param savedInstanceState saved instance state
     */
    @SuppressLint("WrongThread")
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

        Button save = findViewById(R.id.button);
        save.setOnClickListener(this);

        Button video = findViewById(R.id.video_button);
        video.setOnClickListener(this);

        music = findViewById(R.id.music_button);
        music.setOnClickListener(this);

        image = findViewById(R.id.imageView1);
        image.setDrawingCacheEnabled(true);
        image.buildDrawingCache();

        mySong = MediaPlayer.create(MainActivity.this, R.raw.song);
        mySong.start();

//        Resources res = getResources();
//        Drawable drawable = res.getDrawable(R.drawable.rocket);


    }

    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.main_start_button) {
            mySong.pause();
            if (Repository.playerClass == null) {
                Repository.saveItemMap();
                Repository.saveMercenaryMap();
                startActivity(new Intent(MainActivity.this, ConfigurationView.class));
            } else {
                startActivity(new Intent(MainActivity.this, PlayerView.class));
            }
        } else if (v.getId() == R.id.main_exit_button) {
            mySong.pause();
            finish();
        } else if (v.getId() == R.id.mini_game_button) {
            mySong.pause();
            startActivity(new Intent(MainActivity.this, MiniGameView.class));
        } else if (v.getId() == R.id.button) {

            // save image
            // extra credit - google cloud storage

            Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] data = baos.toByteArray();

            StorageReference childStr = storage.child("images/rocket.png");
            uploadTask = childStr.putBytes(data);
            uploadTask.addOnFailureListener(new OnFailureListener() {

                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploads
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                    // ...
                }
            });
        } else if (v.getId() == R.id.music_button) {
            if (!isitPaused) {
                isitPaused = true;
                music.setText("Play Music");
                mySong.pause();
            } else {
                isitPaused = false;
                music.setText("Pause Music");
                mySong.start();
            }
        } else if (v.getId() == R.id.video_button) {
            mySong.pause();
            startActivity(new Intent(MainActivity.this, VideoView.class));
        }
    }

}