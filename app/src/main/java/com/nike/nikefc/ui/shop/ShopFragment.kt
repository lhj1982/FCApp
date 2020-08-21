package com.nike.nikefc.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.nike.nikefc.R

class ShopFragment : Fragment() {

    private lateinit var shopViewModel: ShopViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        shopViewModel =
                ViewModelProviders.of(this).get(ShopViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_shop, container, false)
        return root
    }
}