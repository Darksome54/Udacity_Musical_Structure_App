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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class AlbumsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.grid_view);

        //Custom ToolBar
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.category_albums);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        class Albums {
            private String mAlbumName1;
            private String mArtistName1;
            private int mImageResourceId1;

            public Albums(String albumName1, String artistName1, int imageResourceId1) {
                mAlbumName1 = albumName1;
                mArtistName1 = artistName1;
                mImageResourceId1 = imageResourceId1;
            }

            public String getAlbumName1() {
                return mAlbumName1;
            }

            public String getArtistName1() {
                return mArtistName1;
            }

            public int getImageResourceId1() {
                return mImageResourceId1;
            }
        }

        //Create an ArrayList for Albums, Artists, and Album Art
        ArrayList<Albums> music = new ArrayList<>();

        music.add(new Albums("So Bad", "Power Glove", R.drawable.power_glove));
        music.add(new Albums("Famous Monsters", "Misfits", R.drawable.misfits));
        music.add(new Albums("Sound of a Woman", "Kiesza", R.drawable.kiesza));
        music.add(new Albums("In Dream", "Editors", R.drawable.in_dream));

        //Sorts Albums alphabetically
        Collections.sort(music, (o1, o2) -> o1.getAlbumName1().compareTo(o2.getAlbumName1()));

        class AlbumsAdapter extends ArrayAdapter<Albums> {
            public AlbumsAdapter(Activity context, ArrayList<Albums> words) {
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
                View gridItemView = convertView;
                if (gridItemView == null) {
                    gridItemView = LayoutInflater.from(getContext()).inflate(
                            R.layout.albums, parent, false);
                }

                // Get the object position in the list
                Albums currentPlay = getItem(position);

                // Find the TextView in the albums.xml layout with the ID
                TextView albumTextView = gridItemView.findViewById(R.id.album_text_view1);
                // Get the version number from the current AndroidFlavor object and
                // set this text on the number TextView
                albumTextView.setText(currentPlay.getAlbumName1());

                // Find the TextView in the albums.xml layout with the ID
                TextView artistTextView = gridItemView.findViewById(R.id.artist_text_view1);
                // Get the version name from the current AndroidFlavor object and
                // set this text on the name TextView
                artistTextView.setText(currentPlay.getArtistName1());


                // Find the ImageView in the albums.xml layout with the ID
                ImageView iconView = gridItemView.findViewById(R.id.album_cover1);
                // Get the image resource ID from the current AndroidFlavor object and
                // set the image to iconView
                iconView.setImageResource(currentPlay.getImageResourceId1());


                // Return the grid view layout (2 TextViews and an ImageView)
                // so that it can be shown in the GridView
                return gridItemView;
            }

        }


        AlbumsAdapter adapter = new AlbumsAdapter(this, music);
        GridView gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
    }
}