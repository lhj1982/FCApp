package com.nike.nikefc.ui.profile.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nike.nikefc.R
import com.nike.nikefc.api.model.Developments
import kotlinx.android.synthetic.main.fragment_training_history.*

class TrainingHistoryFragment : Fragment() {

    companion object {
        fun newInstance(developments: ArrayList<Developments>) : TrainingHistoryFragment {
            val frag = TrainingHistoryFragment()
            val bundle = Bundle()
            bundle.putSerializable("data", developments)
            frag.arguments = bundle
            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_training_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.get("data") as ArrayList<Developments>
        data.reverse()
        data.forEach {
            //generateHistory(it)
        }
    }

    private fun generateHistory(development : Developments) {
        val view = LayoutInflater.from(context).inflate(R.layout.training_history_entry, null)
        val dateTV = view.findViewById<TextView>(R.id.training_date)
        dateTV.text = "${development.date} - Stats Change"
        linearLayout.addView(view)
    }


}