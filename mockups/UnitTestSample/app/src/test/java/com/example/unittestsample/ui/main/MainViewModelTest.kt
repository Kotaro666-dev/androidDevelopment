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
        val result = viewModel.isCurrentDateInRange("20210115")
        assertThat(result).isTrue()
    }

    @Test
    fun `Return false when date is 5th`() {
        val result = viewModel.isCurrentDateInRange("20210105")
        assertThat(result).isFalse()
    }

    @Test
    fun `Return true when date is 10th`() {
        val result = viewModel.isCurrentDateInRange("20210110")
        assertThat(result).isTrue()
    }

    @Test
    fun `Return true when date is 20th`() {
        val result = viewModel.isCurrentDateInRange("20210120")
        assertThat(result).isTrue()
    }

    @Test
    fun `Return false when date is 9th`() {
        val result = viewModel.isCurrentDateInRange("20210109")
        assertThat(result).isFalse()
    }

    @Test
    fun `Return false when date is 21th`() {
        val result = viewModel.isCurrentDateInRange("20210109")
        assertThat(result).isFalse()
    }

    @Test
    fun `Return false when date is empty string`() {
        val result = viewModel.isCurrentDateInRange("")
        assertThat(result).isFalse()
    }
}