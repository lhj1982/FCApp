package com.nike.nikefc.ui.events.fragment

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nike.nikefc.R
import kotlinx.android.synthetic.main.team_list_fragment.*


class FindATeamFragment : Fragment() {

    companion object {
        fun newInstance() = FindATeamFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.team_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            activity?.finish()
        }

        val adapter = TeamAdapter()
        teamlist.adapter = adapter
        teamlist.layoutManager = LinearLayoutManager(context)

        teamlist.addOnItemTouchListener(object :  RecyclerView.OnItemTouchListener {
            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
            }

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                activity?.supportFragmentManager?.let {
                    it.beginTransaction()
                        .replace(R.id.container, TeamDetailFragment.newInstance())
                        .commitNow()
                }
                return true
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
            }
        })
    }
}

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        var title = itemView.findViewById<TextView>(R.id.tvTitle)
        var image = itemView.findViewById<ImageView>(R.id.ivEventImage)
        var owner = itemView.findViewById<TextView>(R.id.tvTeamManager)
        var detail = itemView.findViewById<TextView>(R.id.tvTeamDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // Inflate the custom layout

        // Inflate the custom layout
        val teamView: View =
            inflater.inflate(R.layout.layout_team_entry, parent, false)

        return ViewHolder(teamView)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (position) {
            0 -> {
                holder.title.text = "Shanghai Lions"
                holder.image.setImageResource(R.drawable.team1)
                holder.owner.text = "Olli Weaver"
                holder.detail.text = "11-a-side\nTraining every wednesday\nPlays in SLP League\nMatches every Sunday"
            }
            1 -> {
                holder.title.text = "Shanghai Bulls"
                holder.image.setImageResource(R.drawable.team2)
                holder.owner.text = "Shannon Prentice"
                holder.detail.text = "7-a-side\nPlays in ASUS League 1\nMatches Most Weekends"
            }
            else -> {
                holder.title.text = "Super 48"
                holder.image.setImageResource(R.drawable.team3)
                holder.owner.text = "Sam Guest"
                holder.detail.text = "7-a-side\nPlays in ASUS League 2\nMatches Most Weekends"
            }
        }
    }
}