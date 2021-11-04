package thanhdat.sict.project.sharefiles

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import thanhdat.sict.project.sharefiles.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.net.URI

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var imageUri : Uri? = null

    private var textToShare = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.img.setOnClickListener {
            pickImage()

        }

        binding.shareTextbtn.setOnClickListener {

            textToShare = binding.textEt.text.toString().trim()

            if (textToShare.isEmpty()){
                showToast("Enter text")
            }else{
                shareText()
            }
        }

        binding.shareImagebtn.setOnClickListener {

            if (imageUri == null){
                showToast("Pic Image")
            }else{
                shareImage()
            }

        }

        binding.shareBothbtn.setOnClickListener {

            textToShare = binding.textEt.text.toString().trim()

            if (textToShare.isEmpty()){
                showToast("Enter text")
            }else if (imageUri == null){
                showToast("Pick Image")
            }else{
                shareBoth()
            }

        }
    }

    private fun pickImage(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryActivityResluts.launch(intent)
    }

    private var galleryActivityResluts = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> { result ->

            if (result.resultCode == Activity.RESULT_OK){

                showToast("Image ok")

                val intent = result.data
                imageUri = intent!!.data
                binding.img.setImageURI(imageUri)
            }else{
                showToast("canled")
            }

        }
    )

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun shareText(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
        intent.putExtra(Intent.EXTRA_TEXT, textToShare)
        startActivity(Intent.createChooser(intent, "Share Via"))

    }

    private fun shareImage(){
        val contentUri = getContentUri()
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/png"
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
        intent.putExtra(Intent.EXTRA_STREAM, contentUri)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(intent, "Share Via"))

    }

    private fun shareBoth(){
        val contentUri = getContentUri()
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/png"
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
        intent.putExtra(Intent.EXTRA_TEXT, textToShare)
        intent.putExtra(Intent.EXTRA_STREAM, contentUri)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(intent, "Share Via"))

    }

    private fun getContentUri(): Uri?{

        val bitmap : Bitmap

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
            val source = ImageDecoder.createSource(contentResolver, imageUri!!)
            bitmap = ImageDecoder.decodeBitmap(source)
        }else{
            bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
        }

        val imageFolder = File(cacheDir, "images")
        var contentUri : Uri? = null
        try {
            imageFolder.mkdirs()
            val file = File(imageFolder, "share_image.png")
            val stream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, stream)
            stream.flush()
            stream.close()
            contentUri = FileProvider.getUriForFile(this, "thanhdat.sict.project.sharefiles ", file)

        }catch (e: Exception){
            showToast("${e.message}")
        }

        return contentUri
    }

}