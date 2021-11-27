package com.example.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.customdialog.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root
        binding.button.setOnClickListener { onClickButton() }
        return view
    }

    private fun onClickButton() {
        displayCustomDialog()
    }

    private fun displayCustomDialog() {
        val dialog = CustomDialogFragment()
        dialog.show(childFragmentManager, "Custom Dialog")
    }
}