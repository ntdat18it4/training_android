package thanhdat.sict.project.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import thanhdat.sict.project.roomdatabase.db.UserEntity

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_save.setOnClickListener {
            val userEntity = UserEntity(name = et_entersomethings.text.toString())
            viewModel.insertRecord(userEntity)
            et_entersomethings.setText("")
        }
        initVM()
    }

    private fun initVM() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecordsObserver().observe(this, object : Observer<List<UserEntity>>{
            override fun onChanged(t: List<UserEntity>?) {
                tv_reslut.setText("")
                t?.forEach{
                    tv_reslut.append(it.name + "\n")
                }
            }

        })
    }
}