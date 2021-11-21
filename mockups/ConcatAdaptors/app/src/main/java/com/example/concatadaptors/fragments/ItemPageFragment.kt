package com.example.concatadaptors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.concatadaptors.R
import com.example.concatadaptors.databinding.FragmentItemPageBinding
import com.example.concatadaptors.helpers.EXTRA_ITEM_TEXT


class ItemPageFragment : Fragment() {
    private var _binding: FragmentItemPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemPageBinding.inflate(layoutInflater)
        val view = binding.root

        val intent = activity?.intent
        if (intent != null) {
            val itemText = intent.getStringExtra(EXTRA_ITEM_TEXT)
            binding.itemImageView.setImageResource(R.mipmap.ic_launcher)
            binding.itemTextView.text = itemText
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}