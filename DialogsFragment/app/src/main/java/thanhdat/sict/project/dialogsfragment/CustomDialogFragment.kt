package thanhdat.sict.project.dialogsfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_custom_dialog.*
import kotlinx.android.synthetic.main.fragment_custom_dialog.view.*

class CustomDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView : View = inflater.inflate(R.layout.fragment_custom_dialog, container, false)

        rootView.cancelbtn.setOnClickListener {
            dismiss()
        }

        rootView.submitlbtn.setOnClickListener {

            var selectedID = clickRadioGroup.checkedRadioButtonId
            val radio = rootView.findViewById<RadioButton>(selectedID)

            var clickResult = radio.text.toString()

            Toast.makeText(context, "You click : $clickResult", Toast.LENGTH_LONG).show()

            dismiss()
        }

        return rootView
    }
}