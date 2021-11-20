package com.example.layoutpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.layoutpractice.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.outlinedButton.setOnClickListener { onClickOutlinedButton() }
        binding.filledButton.setOnClickListener { onClickFilledButton() }
        binding.textButton.setOnClickListener { onClickTextButton() }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClickOutlinedButton() {
        Toast.makeText(context, "onClickOutlinedButton", Toast.LENGTH_SHORT).show()
    }

    private fun onClickFilledButton() {
        Toast.makeText(context, "onClickFilledButton", Toast.LENGTH_SHORT).show()
    }

    private fun onClickTextButton() {
        Toast.makeText(context, "onClickTextButton", Toast.LENGTH_SHORT).show()
    }
}