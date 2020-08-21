package com.nike.nikefc.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nike.nikefc.R
import com.nike.nikefc.api.model.Developments
import com.nike.nikefc.ui.profile.fragment.TrainingHistoryFragment

class TrainingHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.find_a_team_activity)

        val data = intent.getSerializableExtra("data") as ArrayList<Developments>

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TrainingHistoryFragment.newInstance(data))
                .commitNow()
        }
    }
}