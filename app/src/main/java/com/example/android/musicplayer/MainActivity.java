package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.musicplayer.R.layout.music_item;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(music_item);

        TextView songPlay = (TextView) findViewById(R.id.songs);
        songPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent musicIntent = new Intent(MainActivity.this,NowPlaying.class);

                // Start the new activity
                startActivity(musicIntent);
            }
        });


    }

}
