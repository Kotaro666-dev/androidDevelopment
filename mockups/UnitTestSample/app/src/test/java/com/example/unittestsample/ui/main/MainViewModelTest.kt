package com.example.unittestsample.ui.main

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun `Return true when date is 15th`() {
        val result = viewModel.isCurrentDateInRange("20220115")
        assertThat(result).isTrue()
    }

    @Test
    fun `Return false when date is 5th`() {
        val result = viewModel.isCurrentDateInRange("20220105")
        assertThat(result).isFalse()
    }

    @Test
    fun `Return true when date is 10th`() {
        val result = viewModel.isCurrentDateInRange("20220110")
        assertThat(result).isTrue()
    }

    @Test
    fun `Return true when date is 20th`() {
        val result = viewModel.isCurrentDateInRange("20220120")
        assertThat(result).isTrue()
    }

    @Test
    fun `Return false when date is 9th`() {
        val result = viewModel.isCurrentDateInRange("20220109")
        assertThat(result).isFalse()
    }

    @Test
    fun `Return false when date is 21th`() {
        val result = viewModel.isCurrentDateInRange("20220109")
        assertThat(result).isFalse()
    }

    /**
     * 想定外の入力値
     */

    @Test
    fun `Return false when date is empty string`() {
        val result = viewModel.isCurrentDateInRange("")
        assertThat(result).isFalse()
    }

    @Test
    fun `Return false when date's format is unexpected`() {
        val result = viewModel.isCurrentDateInRange("2022/01/15")
        assertThat(result).isFalse()
    }
}