package ru.omsu.imit.androidtasks

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about_passenger.*

class AboutPassengerActivity : AppCompatActivity() {
    private var isPlays = false
    private lateinit var mPlayer: MediaPlayer

    private fun stopPlay() {
        with(mPlayer) {
            stop()
            prepare()
            seekTo(0)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_passenger)

        mPlayer = MediaPlayer.create(this, R.raw.the_passenger).apply {
            setOnCompletionListener { stopPlay() }
        }

        playSoundImageButton.setOnClickListener {
            if (isPlays) {
                mPlayer.pause()

                isPlays = false
                playSoundImageButton.setImageResource(android.R.drawable.ic_media_play)
            } else {
                mPlayer.start()

                isPlays = true
                playSoundImageButton.setImageResource(android.R.drawable.ic_media_pause)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (isPlays) {
            stopPlay()
        }
    }
}