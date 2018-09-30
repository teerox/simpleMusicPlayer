package com.example.android.musicplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.musicplayer.R.id.songName;

public class MusicAdapter extends ArrayAdapter<Music> {
    private Context context;
    private int layout;
    private ArrayList<Music> arrayList;
    private MediaPlayer mediaPlayer;
    private Boolean flag = true;

    MusicAdapter(Context context, int layout, ArrayList<Music> arrayList) {
        super(context, layout,arrayList);
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Music getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView songName, songSinger;
        ImageView musicPlay, musicStop;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);
            viewHolder.songName = (TextView) convertView.findViewById(songName);
            viewHolder.songSinger = (TextView) convertView.findViewById(R.id.songSinger);
            viewHolder.musicPlay = (ImageView) convertView.findViewById(R.id.musicPlay);
            viewHolder.musicStop = (ImageView) convertView.findViewById(R.id.musicStop);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Music music = arrayList.get(position);

        viewHolder.songName.setText(music.getName());
        viewHolder.songSinger.setText(music.getSinger());

        // play music
        viewHolder.musicPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    mediaPlayer = MediaPlayer.create(context, music.getSong());
                    flag = false;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    viewHolder.musicPlay.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    viewHolder.musicStop.setImageResource(R.drawable.pause);
                }
            }
        });

        // stop
        viewHolder.musicStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag = true;
                }
                viewHolder.musicPlay.setImageResource(R.drawable.play);
            }
        });

        return convertView;
    }
}

