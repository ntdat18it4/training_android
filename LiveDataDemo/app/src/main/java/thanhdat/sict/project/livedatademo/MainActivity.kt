package thanhdat.sict.project.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainActitivyViewModel::class.java)

        viewModel.seconds().observe(this, Observer {
            tv_number.text = it.toString()
        })

        viewModel.finished.observe(this, Observer {
            if (it){
                Toast.makeText(this, "Finished!", Toast.LENGTH_SHORT).show()
            }
        })

        btn_start.setOnClickListener {
            if (input_number.text.isEmpty() || input_number.text.length < 4){
                Toast.makeText(this, "Invalid Number!", Toast.LENGTH_SHORT).show()
            }
            else{
                viewModel.timerValue.value = input_number.text.toString().toLong()
                viewModel.startTimer()
            }

        }
        btn_stop.setOnClickListener {
//            tv_number.text = "0"
            viewModel.stopTimer()
        }
    }
}