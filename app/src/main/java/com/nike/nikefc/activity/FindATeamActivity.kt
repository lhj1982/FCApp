package com.nike.nikefc.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nike.nikefc.R
import com.nike.nikefc.ui.events.fragment.FindATeamFragment

class FindATeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.find_a_team_activity)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FindATeamFragment.newInstance())
                .commitNow()
        }
    }
}