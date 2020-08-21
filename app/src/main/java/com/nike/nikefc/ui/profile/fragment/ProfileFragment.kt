package com.nike.nikefc.ui.profile.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.nike.nikefc.R
import com.nike.nikefc.activity.FindATeamActivity
import com.nike.nikefc.activity.TrainingHistoryActivity
import com.nike.nikefc.api.model.Data
import com.nike.nikefc.api.model.Developments
import com.nike.nikefc.api.model.Friends
import com.nike.nikefc.ui.profile.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.stats
import kotlinx.android.synthetic.main.fragment_training_history.*
import org.w3c.dom.Text

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    private lateinit var profile : Data


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        profileViewModel.profileLiveData.observe(viewLifecycleOwner, Observer<Data> {

            profile = it
            Log.d("data", it.toString())
            Glide.with(this).load("https://cdn.jpegmini.com/user/images/slider_puffin_before_mobile.jpg").into(stats)
            username.text = "${it.firstName} ${it.lastName}"
            age.text = it.age.toString()
            foot.text = it.preferFoot
            position.text = it.position
            height.text = "${it.height} cm"
            weight.text = "${it.weight} kg"
            format.text = "${it.format}-a-side"

            it.friends.forEach { friend ->
                addFriend(friend)
            }

        })

        return root
    }

    private fun addFriend(friend : Friends) {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_team_mates, null)
        view.findViewById<TextView>(R.id.username_friend).text = "${friend.firstName} ${friend.lastName}"
        team_mates.addView(view)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel.getProfile("5f3cba29de53ce6d0c7e9104")

        historybtn.setOnClickListener {
            val intent = Intent(context, TrainingHistoryActivity::class.java)
            val arrayList = ArrayList<Developments>(profile.developments)
            intent.putExtra("data", arrayList)
            startActivity(intent)
        }
    }
}