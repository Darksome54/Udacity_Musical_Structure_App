package com.example.android.musicalstructure;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Allows for custom AppBar/ Status Bar implemented in main_screen_menu.xml
        //must be called before setContentView(...)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        // Set the content of the activity to use the activity_main1.xmll layout file
        setContentView(R.layout.main_screen_menu);

        // Find the View that shows the artists category
        TextView artists = findViewById(R.id.main_screen_artists);

        // Set a click listener on that View
        artists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the ArtistsActivity
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);

                // Start the new activity
                startActivity(artistsIntent);
            }
        });

        //Find the View that shows the albums category
        TextView albums = findViewById(R.id.main_screen_albums);

        //Set a click listener on that View
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the AlbumsActivity
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);

                //Start the new activity
                startActivity(albumsIntent);
            }
        });

        //Find the View that shows the songs category
        TextView songs = findViewById(R.id.main_screen_songs);

        //Set a click listener on that View
        songs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the SongsActivity
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);

                //Start the new activity
                startActivity(songsIntent);
            }
        });

        // Find the View that shows the artists category
        TextView nowPlaying = findViewById(R.id.main_screen_now_playing);

        // Set a click listener on that View
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Now Playing View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the NowPlayingActivity
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);

                // Start the new activity
                startActivity(nowPlayingIntent);
            }
        });

    }
}