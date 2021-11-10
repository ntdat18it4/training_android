package thanhdat.sict.project.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.currrentNumber.observe(this, Observer {
            tv_textView.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            tv_boolenText.text = it.toString()
        })

        incrementText()

    }

    private fun incrementText(){

        btn_button.setOnClickListener {
            viewModel.currrentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
        }

    }
}