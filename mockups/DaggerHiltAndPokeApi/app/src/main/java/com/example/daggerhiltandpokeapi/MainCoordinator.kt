package com.example.daggerhiltandpokeapi

import androidx.fragment.app.FragmentManager
import com.example.daggerhiltandpokeapi.fragment.DialogIndicatorFragment
import javax.inject.Inject

class MainCoordinator @Inject constructor() {

    private lateinit var dialogIndicatorFragment: DialogIndicatorFragment

    fun displayDialogIndicator(fragmentManager: FragmentManager) {
        dialogIndicatorFragment = DialogIndicatorFragment.show(fragmentManager)
    }

    fun dismissDialogIndicator() {
        dialogIndicatorFragment.dismiss()
    }
}