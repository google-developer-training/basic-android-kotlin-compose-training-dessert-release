/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.dessertrelease.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dessertrelease.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/*
 * View model of Dessert Release components
 */
class DessertReleaseViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(DessertReleaseUiState())

    // UI states access for various [DessertReleaseUiState]
    val uiState: StateFlow<DessertReleaseUiState> = _uiState

    /*
     * [selectLayout] change the layout and icons accordingly and
     * save the selection in DataStore through [userPreferencesRepository]
     */
    fun selectLayout(isLinearLayout: Boolean) {
        _uiState.value = DessertReleaseUiState(isLinearLayout)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                DessertReleaseViewModel()
            }
        }
    }
}

/*
 * Data class containing various UI States for Dessert Release screens
 */
data class DessertReleaseUiState(
    val isLinearLayout: Boolean = true,
    val toggleContentDescription: Int =
        if (isLinearLayout) R.string.grid_layout_toggle else R.string.linear_layout_toggle,
    val toggleIcon: Int =
        if (isLinearLayout) R.drawable.ic_grid_layout else R.drawable.ic_linear_layout
)
