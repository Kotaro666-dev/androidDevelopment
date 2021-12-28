package com.example.daggerhiltandpokeapi.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.daggerhiltandpokeapi.R

class DialogIndicatorFragment : DialogFragment() {
    companion object {
        private const val TAG = "Dialog Indicator"

        private val dialog = DialogIndicatorFragment()

        fun show(supportFragmentManager: FragmentManager): DialogIndicatorFragment {
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, TAG)
            return dialog
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return super.onCreateView(inflater, container, savedInstanceState)

        // make white background transparent
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return requireActivity().layoutInflater.inflate(R.layout.dialog_indicator, container)
    }

    override fun onStart() {
        super.onStart()

        // remove black outer overlay, or change opacity
        dialog?.window?.also { window ->
            window.attributes?.also { attributes ->
                attributes.dimAmount = 0.1f
                window.attributes = attributes
            }
        }
    }
}