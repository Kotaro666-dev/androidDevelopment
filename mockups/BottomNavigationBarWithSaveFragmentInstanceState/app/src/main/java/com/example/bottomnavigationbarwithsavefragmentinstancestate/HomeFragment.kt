package com.example.bottomnavigationbarwithsavefragmentinstancestate

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bottomnavigationbarwithsavefragmentinstancestate.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("HomeFragment", "Initialize Fragment")
        if (savedInstanceState != null) {
            //Restore the fragment's state here
            Log.i("HomeFragment", "Restore fragment's state")

            val data = savedInstanceState.getString("HOME")
            Toast.makeText(context, data, Toast.LENGTH_SHORT).show()
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //Save the fragment's state here
        Log.i("HomeFragment", "Saving fragment's state")

        outState.putString("HOME", "This is Home")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("HomeFragment", "Destroy Fragment")
        _binding = null
    }
}