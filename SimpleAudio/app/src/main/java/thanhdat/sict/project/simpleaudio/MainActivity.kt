package thanhdat.sict.project.simpleaudio

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var runnable: Runnable
    private  var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaplayer = MediaPlayer.create(this, R.raw.music)

        seekbar.progress = 0
        seekbar.max = mediaplayer.duration

        btn_play.setOnClickListener {

            if (!mediaplayer.isPlaying){

                mediaplayer.start()

                btn_play.setImageResource(R.drawable.ic_baseline_pause_24)

            }else{

                mediaplayer.pause()
                btn_play.setImageResource(R.drawable.ic_baseline_play_arrow_24)

            }

        }

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(p0: SeekBar?, position: Int, changed: Boolean) {

                if (changed){
                    mediaplayer.seekTo(position)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        } )

        runnable = Runnable {

            seekbar.progress = mediaplayer.currentPosition
            handler.postDelayed(runnable, 1000)

        }

        handler.postDelayed(runnable, 1000)

        mediaplayer.setOnCompletionListener {
            btn_play.setImageResource(R.drawable.ic_baseline_navigate_next_24)
            seekbar.progress = 0
        }

    }
}