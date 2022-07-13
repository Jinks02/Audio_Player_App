package com.example.audioplayer1

import androidx.appcompat.app.AppCompatActivity
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.audioplayer1.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var play: Button? = null
    var pause: Button? = null
    var stop: Button? = null
    var mediaPlayer: MediaPlayer? = null
    var pauseCurrentPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        play = findViewById<View>(R.id.btn_play) as Button
        pause = findViewById<View>(R.id.btn_pause) as Button
        stop = findViewById<View>(R.id.btn_stop) as Button
        play!!.setOnClickListener(this)
        pause!!.setOnClickListener(this)
        stop!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_play -> if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(applicationContext, R.raw.music)
                mediaPlayer!!.start()
            } else if (!mediaPlayer!!.isPlaying) {
                mediaPlayer!!.seekTo(pauseCurrentPosition)
                mediaPlayer!!.start()
            }
            R.id.btn_pause -> if (mediaPlayer != null) {
                mediaPlayer!!.pause()
                pauseCurrentPosition = mediaPlayer!!.currentPosition
            }
            R.id.btn_stop -> if (mediaPlayer != null) {
                mediaPlayer!!.stop()
                mediaPlayer = null
            }
        }
    }
}