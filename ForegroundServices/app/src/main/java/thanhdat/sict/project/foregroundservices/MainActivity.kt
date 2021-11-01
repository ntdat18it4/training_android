package thanhdat.sict.project.foregroundservices

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import thanhdat.sict.project.foregroundservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var biding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

        biding.btnService.setOnClickListener {
            startStopService()
        }
    }

    private fun startStopService(){
        if (isMyServiceRunning(Service::class.java)){

            Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show()

            stopService(Intent(this, Service::class.java))

        }else{
            Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()

            startService(Intent(this, Service::class.java))
        }
    }

    private fun isMyServiceRunning(mClass : Class<Service>) : Boolean {

        val manager : ActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service : ActivityManager.RunningServiceInfo in manager.getRunningServices(Integer.MAX_VALUE)){

            if (mClass.name.equals(service.service.className)){
                return true
            }
        }
        return false

    }

}