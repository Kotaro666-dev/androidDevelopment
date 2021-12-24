package com.example.bottomnavigationbar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationbar.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {

    companion object {
        private const val TITLE_DIALOG = "マイページ画面"
        private const val MESSAGE_DIALOG = "マイページ画面が表示されています。"
        private const val TAG_DIALOG = TITLE_DIALOG
    }

    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyPageBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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