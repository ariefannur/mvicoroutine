package github.ariefannur.mvicourutine.feature.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import github.ariefannur.mvicourutine.R
import github.ariefannur.mvicourutine.core.base.BaseActivity
import github.ariefannur.mvicourutine.core.data.viewmodel.MovieViewModel
import github.ariefannur.mvicourutine.core.domain.model.Movie
import github.ariefannur.mvicourutine.core.utils.display
import github.ariefannur.mvicourutine.core.utils.displayThumbnail
import kotlinx.android.synthetic.main.detail_activity.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity(){

    companion object{
        fun previewDetail(context: Context, id:Int){
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("id", id)
            }
            context.startActivity(intent)
        }
    }
    private val movieViewModel: MovieViewModel by viewModel()

    override fun getLayout(): Int = R.layout.detail_activity

    private val id by lazy {
        intent.getIntExtra("id", 0)
    }

    var listImage = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieViewModel.getDetailMovie(id).observe(this, Observer {
            it.movies?.let {
                render(it)
            }
        })

    }

    private fun render (it: Movie) {

        img_bg_poster.display(it.backdropPath)
        collapsing.title = it.title

        collapsing.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.white))
        collapsing.setExpandedTitleTextAppearance(R.style.expand_title_style)

        tv_overview.text = it.overview
        rv_image.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        listImage.add(it.posterPath)
        listImage.add(it.backdropPath)
        if(it.collection != null) {
            listImage.add(it.collection.backdropPath)
            listImage.add(it.collection.posterPath)
        }
        rv_image.adapter = Adapter()
    }




    inner class Adapter : RecyclerView.Adapter<ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_image, null, false))
        }

        override fun getItemCount(): Int = listImage.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindIt(listImage[position])
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       private val imgPoster by lazy {
            itemView.findViewById(R.id.img_poster) as ImageView
        }

        fun bindIt(img:String?){
            imgPoster.displayThumbnail(img)
        }
    }
}