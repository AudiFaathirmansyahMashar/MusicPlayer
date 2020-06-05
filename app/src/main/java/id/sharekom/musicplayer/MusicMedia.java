package id.sharekom.musicplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.widget.Toast;

public class MusicMedia {
    private MediaPlayer player;
    private static MusicMedia instance;

    public static MusicMedia getInstance(){
        if (instance == null){
            instance = new MusicMedia();
        }

        return instance;
    }

    public MediaPlayer getPlayer(){
        if (player != null){
            return player;
        }else{
            return null;
        }
    }

    public void getPlay(Context context){
        if (player == null){
            player = MediaPlayer.create(context, R.raw.music);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public long getTime(){
        long time = player.getCurrentPosition();
        return time;
    }

    public void getPause(){
        if (player != null){
            player.pause();
        }
    }

    public void stopPlayer(){
        if (player != null){
            player.release();
            player = null;
        }
    }
}
