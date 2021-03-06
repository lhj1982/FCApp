package com.nike.nikefc.ui.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nike.nikefc.R

class TrainingFragment : Fragment() {

    private lateinit var trainingViewModel: TrainingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        trainingViewModel =
                ViewModelProviders.of(this).get(TrainingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_training, container, false)
        return root
    }
}