package github.ariefannur.mvicourutine.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.recyclerview.widget.RecyclerView
import github.ariefannur.mvicourutine.R
import github.ariefannur.mvicourutine.core.domain.model.Movie
import github.ariefannur.mvicourutine.core.utils.displayThumbnail
import github.ariefannur.mvicourutine.feature.detail.DetailActivity

class AdapterPopularMovie(data:List<Movie>, val isSmall:Boolean) : RecyclerView.Adapter<PopularViewHolder>(){
    private var listData:List<Movie>? = null
    init {
        listData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val layout = when(isSmall){
            true -> R.layout.item_small_popular
            else -> R.layout.item_popular
        }
        val view = LayoutInflater.from(parent.context).inflate(layout , null, false)
        return PopularViewHolder(view, isSmall)
    }

    override fun getItemCount(): Int = listData?.size ?: 0

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        listData.let {
            if(it != null) {
                holder.bindIt(it[position])
            }
        }
    }

}

class PopularViewHolder(itemView: View, val isSmall: Boolean) : RecyclerView.ViewHolder(itemView){

    private val tvTitle by lazy {
        itemView.findViewById(R.id.tv_title) as TextView
    }


    private val imgPoster by lazy {
        itemView.findViewById(R.id.img_poster) as ImageView
    }

    private val rating by lazy{
        itemView.findViewById(R.id.rating) as AppCompatRatingBar
    }

    fun bindIt(movie: Movie){
        tvTitle.text = movie.title
        imgPoster.displayThumbnail(movie.posterPath)
        if(isSmall) {
            val tvDesc by lazy {
                itemView.findViewById(R.id.tv_desc) as TextView
            }
            tvDesc.text = movie.overview
        }
        rating.rating = movie.vote

        itemView.setOnClickListener {
            DetailActivity.previewDetail(it.context, movie.id)
        }
    }
}