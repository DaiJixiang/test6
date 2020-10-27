package hfuu.edu.musicplay;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_main_play;
    private Button btn_main_stop;
    private Button btn_main_pause;
    private Button btn_main_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_main_play=(Button)findViewById(R.id.btn_main_play);
        btn_main_stop=(Button)findViewById(R.id.btn_main_stop);
        btn_main_pause=(Button)findViewById(R.id.btn_main_pause);
        btn_main_exit=(Button)findViewById(R.id.btn_main_exit);

        btn_main_play.setOnClickListener(this);
        btn_main_stop.setOnClickListener(this);
        btn_main_pause.setOnClickListener(this);
        btn_main_exit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==btn_main_play){
            playMusic();

        }else if(view==btn_main_stop){
            stopMusic();

        }else if(view==btn_main_pause){
            pauseMusic();

        }else if(view==btn_main_exit){
            exitPlayer();

        }
    }

    private MediaPlayer player;

    private void exitPlayer() {
        stopMusic();
        finish();
    }

    private void pauseMusic() {
        if(player!=null&&player.isPlaying()){
            player.pause();
        }
    }

    private void stopMusic() {
        if(player!=null){
            player.stop();
            player.reset();
            player.release();
            player=null;
        }
    }
    private void playMusic() {
        if(player==null){
            player= MediaPlayer.create(this,R.raw.promise);
        }
        player.start();
    }


    /*protected void onDestroy() {
        super.onDestroy();
        stopMusic();
    }*/
}
