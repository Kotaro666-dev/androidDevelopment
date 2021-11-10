package com.example.jetpacknavigationwithfragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpacknavigationwithfragments.R

class FragmentFirst : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val navigateToFragmentSecondButton =
            view.findViewById<Button>(R.id.fragment_fragment_navigate_to_fragment_second)
        val navigateToFragmentThirdButton =
            view.findViewById<Button>(R.id.fragment_fragment_navigate_to_fragment_third)

        navigateToFragmentSecondButton.setOnClickListener {
            onClickNavigateToFragmentSecondButton(
                view
            )
        }
        navigateToFragmentThirdButton.setOnClickListener { onClickNavigateToFragmentThirdButton(view) }
        return view
    }

    private fun onClickNavigateToFragmentSecondButton(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_fragmentFirst_to_fragmentSecond)
    }

    private fun onClickNavigateToFragmentThirdButton(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_fragmentFirst_to_fragmentThird)
    }
}