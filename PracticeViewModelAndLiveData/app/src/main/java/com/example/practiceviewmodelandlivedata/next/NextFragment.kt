package com.example.practiceviewmodelandlivedata.next

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.practiceviewmodelandlivedata.R
import com.example.practiceviewmodelandlivedata.databinding.FragmentNextBinding

class NextFragment : Fragment() {
    private lateinit var binding: FragmentNextBinding
    private lateinit var viewModel: NextViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_next, container, false)
        return binding.root
    }
}