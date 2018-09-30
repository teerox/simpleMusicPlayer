package com.example.android.musicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NowPlaying extends AppCompatActivity {
    private ArrayList<Music> arrayList;
    private MusicAdapter adapter;
    private ListView songList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Music(getString(R.string.song_name_one), getString(R.string.artist_name_one), R.raw.change));
        arrayList.add(new Music(getString(R.string.song_name_two), getString(R.string.artist_name_two), R.raw.done));
        arrayList.add(new Music(getString(R.string.song_name_three), getString(R.string.artist_name_three), R.raw.way));

        adapter= new MusicAdapter(this, R.layout.now_playing,arrayList);

        songList.setAdapter(adapter);


    }
}