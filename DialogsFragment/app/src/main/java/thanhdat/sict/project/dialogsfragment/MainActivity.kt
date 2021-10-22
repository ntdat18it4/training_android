package thanhdat.sict.project.dialogsfragment

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    override fun onBackPressed() {
//
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Are you sure!")
//        builder.setMessage("Do you want to close app?")
//        builder.setPositiveButton("Yes", { dialogInterface: DialogInterface, i: Int ->
//            finish()
//        })
//
//        builder.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int ->
//            builder.show()
//        })
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickMetv.setOnClickListener{

            var dialogs = CustomDialogFragment()

            dialogs.show(supportFragmentManager, "customDialogs")
        }

    }
}