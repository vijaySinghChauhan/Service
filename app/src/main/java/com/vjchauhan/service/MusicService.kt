package com.vjchauhan.service

// MusicService.kt
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.m) // Replace music_file with your actual music file in raw resources
        mediaPlayer.isLooping = true // Loop the music
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start() // Start playing the music
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop() // Stop the music
        mediaPlayer.release() // Release the MediaPlayer resources
    }
}
