package com.example.modalbottomsheet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.modalbottomsheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        binding.displayBottomSheetButton.setOnClickListener { onClickDisplayBottomSheetButton() }

        setContentView(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun onClickDisplayBottomSheetButton() {
        supportFragmentManager.let {
            MyBottomSheetDialogFragment.newInstance(Bundle()).apply {
                show(it, tag)
            }
        }
    }
}