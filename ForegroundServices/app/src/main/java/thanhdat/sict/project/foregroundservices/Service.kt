package thanhdat.sict.project.foregroundservices

import android.app.*
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder

import thanhdat.sict.project.foregroundservices.Constants.CHANNEL_ID
import thanhdat.sict.project.foregroundservices.Constants.MUSIC_NOTIFICATION_ID

class Service : Service() {

    private lateinit var musicPlayer : MediaPlayer

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        initMusic()
        createNotificationChannel()
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPlayer.stop()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        showNotification()
        if (musicPlayer.isPlaying){
            musicPlayer.stop()
        }else{
            musicPlayer.start()
        }

        return START_STICKY
    }

    private fun showNotification(){

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,0)
        val notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification
                .Builder(this, CHANNEL_ID)
                .setContentText("Music Player")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .build()
        } else {
            TODO("VERSION.SDK_INT < O")
        }

        startForeground(MUSIC_NOTIFICATION_ID, notification)
    }

    private fun createNotificationChannel(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val serviceChannel = NotificationChannel(
                CHANNEL_ID, "My Service",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            val manager = getSystemService(
                NotificationManager::class.java
            )

            manager.createNotificationChannel(serviceChannel)
        }

    }

    private fun initMusic(){

        musicPlayer = MediaPlayer.create(this, R.raw.music)
        musicPlayer.isLooping = true
        musicPlayer.setVolume(100F, 100F)

    }

}