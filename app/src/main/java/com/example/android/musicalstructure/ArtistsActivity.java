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

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Custom ToolBar
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.category_artists);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        class Play {
            private String mArtistName;
            private int mImageResourceId;


            public Play(String artistName, int imageResourceId) {
                mArtistName = artistName;
                mImageResourceId = imageResourceId;
            }


            public String getArtistName() {
                return mArtistName;
            }

            public int getImageResourceId() {
                return mImageResourceId;
            }

        }

        //Create an ArrayList for Artists and Album Art
        ArrayList<Play> music = new ArrayList<>();

        music.add(new Play("Power Glove", R.drawable.power_glove));
        music.add(new Play("Misfits", R.drawable.misfits));
        music.add(new Play("Kiesza", R.drawable.kiesza));
        music.add(new Play("Editors", R.drawable.in_dream));

        //Sorts Artists alphabetically
        Collections.sort(music, (o1, o2) -> o1.getArtistName().compareTo(o2.getArtistName()));

        /**Original Code for Sorting Names
         Collections.sort(music, new Comparator<Play>() {
        @Override public int compare(Play o1, Play o2) {
        return o1.getArtistName().compareTo(o2.getArtistName());
        }
        });**/

        class PlayAdapter extends ArrayAdapter<Play> {
            public PlayAdapter(Activity context, ArrayList<Play> words) {
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
                            R.layout.artists, parent, false);
                }

                // Get the object position in the list
                Play currentPlay = getItem(position);

                // Find the TextView in the activity_main.xml layout with the ID
                TextView artistTextView = listItemView.findViewById(R.id.artist_text_view);
                // Get the version name from the current AndroidFlavor object and
                // set this text on the name TextView
                artistTextView.setText(currentPlay.getArtistName());

                // Find the ImageView in the activity_main.xml layout with the ID
                ImageView iconView = listItemView.findViewById(R.id.album_cover);
                // Get the image resource ID from the current AndroidFlavor object and
                // set the image to iconView
                iconView.setImageResource(currentPlay.getImageResourceId());

                // Return activity_main.xml layout (1 TextView and 1 ImageView)
                // so that it can be shown in the ListView
                return listItemView;
            }
        }

        ListView listView = findViewById(R.id.list);
        PlayAdapter adapter = new PlayAdapter(this, music);
        listView.setAdapter(adapter);
    }
}