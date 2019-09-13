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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class SongsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Custom ToolBar
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.category_songs);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        class Songs {
            private String mSongTitle2;
            private String mArtistName2;
            private int mImageResourceId2;


            public Songs(String songTitle2, String artistName2, int imageResourceId2) {
                mSongTitle2 = songTitle2;
                mArtistName2 = artistName2;
                mImageResourceId2 = imageResourceId2;

            }

            public String getSongTitle2() {
                return mSongTitle2;
            }

            public String getArtistName2() {
                return mArtistName2;
            }

            public int getImageResourceId2() {
                return mImageResourceId2;
            }

        }

        //Create an ArrayList of Songs, Artists, and Album Art
        ArrayList<Songs> music = new ArrayList<>();

        music.add(new Songs("Streets of 2043", "Power Glove", R.drawable.power_glove));
        music.add(new Songs("Maximum Potential", "Power Glove", R.drawable.power_glove));
        music.add(new Songs("Night Force", "Power Glove", R.drawable.power_glove));
        music.add(new Songs("Fantastic Lover", "Power Glove", R.drawable.power_glove));
        music.add(new Songs("Scream!", "Misfits", R.drawable.misfits));
        music.add(new Songs("Kong At The Gates", "Misfits", R.drawable.misfits));
        music.add(new Songs("The Forbidden Zone", "Misfits", R.drawable.misfits));
        music.add(new Songs("Lost In Space", "Misfits", R.drawable.misfits));
        music.add(new Songs("Hideaway", "Kiesza", R.drawable.kiesza));
        music.add(new Songs("No Enemiesz", "Kiesza", R.drawable.kiesza));
        music.add(new Songs("Losin' My mind", "Kiesza", R.drawable.kiesza));
        music.add(new Songs("So Deep", "Kiesza", R.drawable.kiesza));
        music.add(new Songs("No Harm", "Editors", R.drawable.in_dream));
        music.add(new Songs("Ocean Of Night", "Editors", R.drawable.in_dream));
        music.add(new Songs("Forgiveness", "Editors", R.drawable.in_dream));
        music.add(new Songs("Salvation", "Editors", R.drawable.in_dream));

        //Sorts Songs and Artists alphabetically
        Collections.sort(music, (o1, o2) -> o1.getSongTitle2().compareTo(o2.getSongTitle2()));
        Collections.sort(music, (o1, o2) -> o1.getArtistName2().compareTo(o2.getArtistName2()));

        class SongsAdapter extends ArrayAdapter<Songs> {
            public SongsAdapter(Activity context, ArrayList<Songs> words) {
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
                            R.layout.songs, parent, false);
                }

                // Get the {@link AndroidFlavor} object located at this position in the list
                Songs currentPlay = getItem(position);

                // Find the TextView in the activity_main.xml layout with the ID
                TextView songTextView = listItemView.findViewById(R.id.song_text_view2);
                // Get the version number from the current AndroidFlavor object and
                // set this text on the number TextView
                songTextView.setText(currentPlay.getSongTitle2());

                // Find the TextView in the activity_main.xml layout with the ID
                TextView artistTextView = listItemView.findViewById(R.id.artist_text_view2);
                // Get the version name from the current AndroidFlavor object and
                // set this text on the name TextView
                artistTextView.setText(currentPlay.getArtistName2());

                // Find the ImageView in the activity_main.xml layout with the ID
                ImageView iconView = listItemView.findViewById(R.id.album_cover2);
                // Get the image resource ID from the current AndroidFlavor object and
                // set the image to iconView
                iconView.setImageResource(currentPlay.getImageResourceId2());

                // Return the activity_main.xml layout (2 TextViews and 1 ImageView)
                // so that it can be shown in the ListView
                return listItemView;
            }
        }

        SongsAdapter adapter = new SongsAdapter(this, music);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }


}
