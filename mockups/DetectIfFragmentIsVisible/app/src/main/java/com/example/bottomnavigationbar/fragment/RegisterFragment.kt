package com.example.bottomnavigationbar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationbar.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    companion object {
        private const val TITLE_DIALOG = "登録画面"
        private const val MESSAGE_DIALOG = "登録画面が表示されています。"
        private const val TAG_DIALOG = TITLE_DIALOG
    }

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)

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