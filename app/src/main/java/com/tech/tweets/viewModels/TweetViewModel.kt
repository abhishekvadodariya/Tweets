package com.tech.tweets.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.tweets.models.TweetListItem
import com.tech.tweets.repository.tweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetViewModel @Inject constructor(private val repository: tweetRepository,
    private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val tweets : StateFlow<List<TweetListItem>>
        get() = repository.tweet

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "motivational_tweets"
            repository.getTweets(category)
        }
    }

}