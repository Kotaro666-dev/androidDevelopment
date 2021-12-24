package com.example.bottomnavigationbar.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CustomDialog(
    private val title: String,
    private val message: String,
) : DialogFragment() {
    companion object {
        const val TITLE_POSITIVE_BUTTON = "OK"
        const val TAG = "CustomDialog"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(TITLE_POSITIVE_BUTTON) { _, _ -> }
            .create()
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }
}