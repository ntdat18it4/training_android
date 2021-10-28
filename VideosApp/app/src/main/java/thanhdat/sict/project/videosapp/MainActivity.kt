package thanhdat.sict.project.videosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var arrVideosModel = ArrayList<VideosModel>()
    var videosAdapter : VideosAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrVideosModel.add(VideosModel("https://www.youtube.com/watch?v=pay2NLpVhMw", "Douyin", "Tiktok video douyin"))
        arrVideosModel.add(VideosModel("https://www.youtube.com/watch?v=kBr9sEXxfmY", "Douyin", "Tiktok video douyin"))
        arrVideosModel.add(VideosModel("https://www.youtube.com/watch?v=C7Fgp7B7BWg", "Douyin", "Tiktok video douyin"))
        arrVideosModel.add(VideosModel("https://www.youtube.com/watch?v=UmLBMe-qf6w", "Douyin", "Tiktok video douyin"))
        arrVideosModel.add(VideosModel("https://www.youtube.com/watch?v=4kXAMb1uNkA", "Douyin", "Tiktok video douyin"))
        arrVideosModel.add(VideosModel("https://www.youtube.com/watch?v=4iahfllG5iQ", "Douyin", "Tiktok video douyin"))

        videosAdapter = VideosAdapter(arrVideosModel)
        viewPager.adapter = videosAdapter

    }
}