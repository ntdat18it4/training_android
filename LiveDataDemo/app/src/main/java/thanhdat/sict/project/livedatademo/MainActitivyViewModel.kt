package thanhdat.sict.project.livedatademo

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActitivyViewModel : ViewModel() {

    private lateinit var timer : CountDownTimer

    var timerValue = MutableLiveData<Long>()

    var finished = MutableLiveData<Boolean>()

    private val _seconds = MutableLiveData<Int>()
    fun seconds(): LiveData<Int>{
        return _seconds
    }

    fun startTimer(){
        timer = object  : CountDownTimer(timerValue.value!!.toLong() , 1000){

            override fun onFinish() {
                finished.value = true

            }

            override fun onTick(p0: Long) {
                val timeLeft = p0/1000
                _seconds.value = timeLeft.toInt()
            }

        }.start()

    }

    fun stopTimer(){
        timer.cancel()
    }

}