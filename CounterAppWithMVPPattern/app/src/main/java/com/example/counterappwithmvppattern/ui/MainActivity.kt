package com.example.counterappwithmvppattern.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.counterappwithmvppattern.databinding.ActivityMainBinding
import com.example.counterappwithmvppattern.presenter.CounterPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: CounterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.updateCounterView()

        binding.incrementButton.setOnClickListener {
            println("Increment button clicked")
            presenter.onIncrementButtonClicked()
        }

        binding.decrementButton.setOnClickListener {
            println("Decrement button clicked")
            presenter.onDecrementButtonClicked()
        }
    }

    override fun showCount(count: Int) {
        binding.counterValue.text = count.toString()
    }
}