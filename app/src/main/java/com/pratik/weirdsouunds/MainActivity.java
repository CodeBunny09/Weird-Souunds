package com.pratik.weirdsouunds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    MediaPlayer player = new MediaPlayer();
    List<MediaPlayer> playing = new ArrayList<>();


    public void playSmallMoan(View view){
        player = MediaPlayer.create(this, R.raw.small_moan);
        playSound(player, "Small Moan");
    }


    public void playLongMoan (View view){
        player = MediaPlayer.create(this, R.raw.long_moan);
        playSound(player, "Long Moan");
    }

    public void playFart1(View view){
        player = MediaPlayer.create(this, R.raw.fart_1);
        playSound(player, "Fart 1");
    }

    public void playFart2 (View view){
        player = MediaPlayer.create(this, R.raw.fart_2);
        playSound(player, "Fart 2");
    }

    public void playKyaLadhaHai (View view){
        player = MediaPlayer.create(this, R.raw.kya_ladka_hai);
        playSound(player, "Kya Ladka Hai");
    }

    public void playRobertBWeide (View view){
        player = MediaPlayer.create(this, R.raw.robert_b_weide);
        playSound(player, "Robert B Weide");
    }

    public void playFuckYou (View view){
        player = MediaPlayer.create(this, R.raw.fuck_you);
        playSound(player, "Fuck You");
    }

    public void playWhatTheFuck(View view){
        player = MediaPlayer.create(this, R.raw.what_the_fuck);
        playSound(player, "What The Fuck");
    }

    public void playChalaJaBhosdike(View view){
        player = MediaPlayer.create(this, R.raw.chala_ja_bhosdike);
        playSound(player, "Chala Ja Bhosdike");
    }

    public void playAnimeMoan(View view){
        player = MediaPlayer.create(this, R.raw.anime_moan);
        playSound(player, "Anime Moan");
    }

    public void stop(View view){
        for(MediaPlayer audio : playing) {
            if(audio.isPlaying()){
                audio.seekTo(audio.getDuration());
            }
        }
    }

    private void playSound(MediaPlayer sound, String name){
        playing.add(sound);
        sound.start();
        Log.i(TAG, "playSound: Sound Started: " + name);
        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                int indexOfSound = playing.indexOf(mediaPlayer);
                playing.remove(indexOfSound);
                mediaPlayer.release();
                Log.i(TAG, "onCompletion: Sound Finished: " + name);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}