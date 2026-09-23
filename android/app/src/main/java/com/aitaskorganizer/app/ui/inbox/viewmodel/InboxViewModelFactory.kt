package com.aitaskorganizer.app.ui.inbox.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aitaskorganizer.app.data.repository.SourceRepository

class InboxViewModelFactory(private val repository: SourceRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InboxViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InboxViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
