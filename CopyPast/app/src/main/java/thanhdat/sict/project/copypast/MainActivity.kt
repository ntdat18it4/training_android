package thanhdat.sict.project.copypast

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private var myClipboard: ClipboardManager? = null
//    private var myClip: ClipData? = null

    private fun copyTextToClipboard() {
        val textToCopy = et_copy_text.text
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", textToCopy)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_LONG).show()
    }

    private fun pasteTextFromClipboard() {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        tv_text_paste.text = clipboardManager.primaryClip?.getItemAt(0)?.text

        Toast.makeText(this, "Text past", Toast.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_copy.setOnClickListener {
            copyTextToClipboard()
        }
        btn_paste.setOnClickListener {
            pasteTextFromClipboard()
        }

//        myClipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?;

    }

//    // on click copy button
//    fun copyText(view: View) {
//        myClip = ClipData.newPlainText("text", et_copy_text.text);
//        myClipboard?.setPrimaryClip(myClip);
//
//        Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();
//    }
//
//    // on click paste button
//    fun pasteText(view: View) {
//        val abc = myClipboard?.getPrimaryClip()
//        val item = abc?.getItemAt(0)
//
//        tv_text_paste.text = item?.text.toString()
//
//        Toast.makeText(applicationContext, "Text Pasted", Toast.LENGTH_SHORT).show()
//    }
}