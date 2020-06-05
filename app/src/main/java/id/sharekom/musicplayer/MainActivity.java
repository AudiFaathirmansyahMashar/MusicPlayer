package id.sharekom.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button play, pause, stop, setTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        setTime = findViewById(R.id.setTime);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicMedia.getInstance().getPlay(getApplicationContext());
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicMedia.getInstance().getPause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicMedia.getInstance().stopPlayer();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MusicMedia.getInstance().stopPlayer();
    }
}