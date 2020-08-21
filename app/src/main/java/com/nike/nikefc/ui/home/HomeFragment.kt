package com.nike.nikefc.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nike.nikefc.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NewsAdapter()
        newsFeed.adapter = adapter
        newsFeed.layoutManager = LinearLayoutManager(context)
    }
}


class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        var image = itemView.findViewById<ImageView>(R.id.newsImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // Inflate the custom layout

        // Inflate the custom layout
        val newsView: View =
            inflater.inflate(R.layout.layout_news, parent, false)

        return ViewHolder(newsView)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (position) {
            0 -> holder.image.setImageResource(R.drawable.news1)
            1 -> holder.image.setImageResource(R.drawable.news2)
            2 -> holder.image.setImageResource(R.drawable.news3)
            3 -> holder.image.setImageResource(R.drawable.news4)
            4 -> holder.image.setImageResource(R.drawable.news5)
            else -> holder.image.setImageResource(R.drawable.news1)
        }
    }
}