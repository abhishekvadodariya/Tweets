package com.tech.tweets.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.tweets.repository.tweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: tweetRepository) : ViewModel() {

    val cetegories : StateFlow<List<String>>
        get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }

}