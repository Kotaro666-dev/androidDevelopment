package com.example.dialogs.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.dialogs.R

class BasicAlertDialogClass: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.dialogMessage)
                .setPositiveButton(
                    R.string.okButtonTitle,
                    DialogInterface.OnClickListener { dialog, id ->
                        // はいの導線に遷移
                    })
                .setNegativeButton(R.string.noButtonTitle,
                    DialogInterface.OnClickListener { dialog, id ->
                        // Popするだけ
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}