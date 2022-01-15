package com.example.unittestsample.ui.main

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

@RunWith(Enclosed::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    inner class IsDateInRange() {
        @Test
        fun `Return true when date is 15th`() {
            val result = viewModel.isDateInRange("20220115")
            assertThat(result).isTrue()
        }

        @Test
        fun `Return false when date is 5th`() {
            val result = viewModel.isDateInRange("20220105")
            assertThat(result).isFalse()
        }

        @Test
        fun `Return true when date is 10th`() {
            val result = viewModel.isDateInRange("20220110")
            assertThat(result).isTrue()
        }

        @Test
        fun `Return true when date is 20th`() {
            val result = viewModel.isDateInRange("20220120")
            assertThat(result).isTrue()
        }

        @Test
        fun `Return false when date is 9th`() {
            val result = viewModel.isDateInRange("20220109")
            assertThat(result).isFalse()
        }

        @Test
        fun `Return false when date is 21th`() {
            val result = viewModel.isDateInRange("20220109")
            assertThat(result).isFalse()
        }

        /**
         * 想定外の入力値
         */

        @Test
        fun `Return false when date is empty string`() {
            val result = viewModel.isDateInRange("")
            assertThat(result).isFalse()
        }

        @Test
        fun `Return false when date's format is unexpected`() {
            val result = viewModel.isDateInRange("2022/01/15")
            assertThat(result).isFalse()
        }
    }

    inner class SecondTest() {

    }

    inner class ThirdTest() {

    }

    inner class FourthTest() {

    }
}