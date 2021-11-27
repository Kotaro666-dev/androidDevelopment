package com.example.practiceviewmodelandlivedata.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.practiceviewmodelandlivedata.R
import com.example.practiceviewmodelandlivedata.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        // HomeViewModelのインスタンス化
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        // インスタンス化したHomeViewModelを、View側の変数に参照させる
        binding.homeViewModel = viewModel
        // Sets the LifecycleOwner that should be used for observing changes of LiveData in this binding.
        // If a LiveData is in one of the binding expressions and no LifecycleOwner is set,
        // the LiveData will not be observed and updates to it will not be propagated to the UI.
        // 以下の処理を行わないと、LiveData が View に反映されない
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.isMilestone.observe(viewLifecycleOwner, Observer { isMilestone ->
            if (isMilestone) {
                announceMileStone()
            }
        })

        return binding.root
    }

    private fun announceMileStone() {
        Toast.makeText(activity, "You Reached to ${viewModel.score.value}", Toast.LENGTH_SHORT)
            .show()
        viewModel.resetMileStone()
    }
}