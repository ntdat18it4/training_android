package thanhdat.sict.project.animations

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.splash_screen.*

class SplashScreen : AppCompatActivity() {

    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)

        val middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation)

        val bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        top_tv.startAnimation(topAnimation)

        middle_tv.startAnimation(middleAnimation)

        bottom_tv.startAnimation(bottomAnimation)

        val splashScreenTimeOut = 4000

        val intent = Intent(this@SplashScreen, MainActivity::class.java)

        handler = Handler()
        handler.postDelayed({
            startActivity(intent)
            finish()
        }, splashScreenTimeOut.toLong())
    }

}