package thanhdat.sict.project.videosapp

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_videos.view.*

class VideosAdapter(arrVideos : ArrayList<VideosModel>) : RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {

    var arrVideosModel : ArrayList<VideosModel> = arrVideos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        return VideosViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_videos,parent, false))
    }

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        holder.setVideoData(arrVideosModel[position])
    }

    override fun getItemCount(): Int {
        return arrVideosModel.size
    }

    class VideosViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun setVideoData(videosModel: VideosModel){

            itemView.tv_title.text = videosModel.videosTitle
            itemView.tv_desc.text = videosModel.videosDesc

            itemView.videosView.setVideoPath(videosModel.videosUrl)
            itemView.videosView.setOnPreparedListener(object : MediaPlayer.OnPreparedListener{
                override fun onPrepared(mp: MediaPlayer) {
                    itemView.progressBar.visibility = View.GONE
                    mp.start()

                    val videos = mp.videoWidth.toFloat() / mp.videoHeight.toFloat()
                    val screen = itemView.videosView.width.toFloat() / itemView.videosView.height.toFloat()

                    val scale = videos / screen
                    if (scale > 1f){
                        itemView.videosView.scaleX = scale
                    }else{
                        itemView.videosView.scaleY = (1 / scale)
                    }

                }
            })

            itemView.videosView.setOnCompletionListener { object : MediaPlayer.OnCompletionListener{
                override fun onCompletion(mp: MediaPlayer) {
                    mp.start()
                }
            } }
        }
    }
}