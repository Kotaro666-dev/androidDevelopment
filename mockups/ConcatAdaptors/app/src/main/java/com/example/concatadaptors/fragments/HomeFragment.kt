package com.example.concatadaptors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadaptors.helpers.CustomRecyclerAdapter
import com.example.concatadaptors.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root

        val itemsList = initializeItemsList()

        viewAdapter = CustomRecyclerAdapter(itemsList)
        viewManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView = binding.recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        recyclerView.adapter = null
    }

    private fun initializeItemsList(): List<String> {
        val itemsList = mutableListOf<String>()
        for (i in 1..100) {
            itemsList.add("item $i")
        }
        return itemsList
    }
}