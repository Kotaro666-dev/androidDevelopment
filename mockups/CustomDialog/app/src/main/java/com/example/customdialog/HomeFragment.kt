package com.example.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        binding.button.setOnClickListener { onClickButton(view) }
        return view
    }

    private fun onClickButton(view: View) {
        Toast.makeText(view.context, "カスタムダイアログを開く", Toast.LENGTH_SHORT).show()
    }
}