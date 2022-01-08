package com.example.bottomnavigationbar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationbar.databinding.FragmentViewBinding

class ViewFragment : Fragment() {

    companion object {
        private const val TITLE_DIALOG = "表示画面"
        private const val MESSAGE_DIALOG = "表示画面が表示されています。"
        private const val TAG_DIALOG = TITLE_DIALOG
    }

    private lateinit var binding: FragmentViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)
        if (menuVisible) {
            displayDialog()
        }
    }

    private fun displayDialog() {
        val fragmentManager = this.requireActivity().supportFragmentManager
        CustomDialog(
            title = TITLE_DIALOG,
            message = MESSAGE_DIALOG
        ).show(fragmentManager, TAG_DIALOG)
    }
}