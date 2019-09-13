package com.example.android.musicalstructure;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class NowPlayingActivity extends AppCompatActivity {
    SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Custom ToolBar
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.category_now_playing);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        class NowPlaying {
            private String mSongTitle3;
            private String mArtistName3;
            private int mImageResourceId3;

            public NowPlaying(String songTitle3, String artistName3, int imageResourceId3) {
                mSongTitle3 = songTitle3;
                mArtistName3 = artistName3;
                mImageResourceId3 = imageResourceId3;

            }

            public String getSongTitle3() {
                return mSongTitle3;
            }

            public String getArtistName3() {
                return mArtistName3;
            }

            public int getImageResourceId3() {
                return mImageResourceId3;
            }
        }

        //Create an ArrayList for Songs, Artists, and Album Art
        ArrayList<NowPlaying> playing = new ArrayList<>();

        playing.add(new NowPlaying("Streets of 2043", "Power Glove", R.drawable.power_glove));

        class NowPlayingAdapter extends ArrayAdapter<NowPlaying> {
            public NowPlayingAdapter(Activity context, ArrayList<NowPlaying> words) {
                // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
                // the second argument is used when the ArrayAdapter is populating a single TextView.
                // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
                // going to use this second argument, so it can be any value. Here, we used 0.
                super(context, 0, words);
            }

            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Check if the existing view is being reused, otherwise inflate the view
                View listItemView = convertView;
                if (listItemView == null) {
                    listItemView = LayoutInflater.from(getContext()).inflate(
                            R.layout.now_playing, parent, false);
                }

                // Get the {@link AndroidFlavor} object located at this position in the list
                NowPlaying currentPlay = getItem(position);

                // Find the TextView in the activity_main.xml layout with the ID
                TextView songTextView = listItemView.findViewById(R.id.now_playing_song);
                // Get the version number from the current AndroidFlavor object and
                // set this text on the number TextView
                songTextView.setText(currentPlay.getSongTitle3());

                // Find the TextView in the activity_main.xml layout with the ID
                TextView artistTextView = listItemView.findViewById(R.id.now_playing_song_artist);
                // Get the version name from the current AndroidFlavor object and
                // set this text on the name TextView
                artistTextView.setText(currentPlay.getArtistName3());

                // Find the ImageView in the activity_main.xml layout with the ID list_item_icon
                ImageView iconView = listItemView.findViewById(R.id.now_playing_album_cover);
                // Get the image resource ID from the current AndroidFlavor object and
                // set the image to iconView
                iconView.setImageResource(currentPlay.getImageResourceId3());

                // Return the activity_main.xml layout (2 TextViews and 1 ImageView)
                // so that it can be shown in the ListView
                return listItemView;
            }
        }

        NowPlayingAdapter adapter = new NowPlayingAdapter(this, playing);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}