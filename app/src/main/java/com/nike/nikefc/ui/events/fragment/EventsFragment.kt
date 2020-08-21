package com.nike.nikefc.ui.events.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nike.nikefc.R
import com.nike.nikefc.activity.FindATeamActivity

import kotlinx.android.synthetic.main.fragment_events.*

class EventsFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        find_a_team_card.setOnClickListener {
            val intent = Intent(context, FindATeamActivity::class.java)
            startActivity(intent)
        }
    }
}