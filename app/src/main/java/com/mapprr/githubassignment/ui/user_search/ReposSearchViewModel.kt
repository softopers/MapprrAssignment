package com.mapprr.githubassignment.ui.user_search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.mapprr.githubassignment.repository.RepoRepository
import com.mapprr.githubassignment.util.AbsentLiveData
import com.mapprr.githubassignment.vo.Repo
import com.mapprr.githubassignment.vo.Resource
import java.util.*
import javax.inject.Inject

//@OpenForTesting
class ReposSearchViewModel @Inject constructor(repoRepository: RepoRepository) : ViewModel() {

    private val _query = MutableLiveData<String>()

    val query: LiveData<String> = _query

    val results: LiveData<Resource<List<Repo>>> = _query.switchMap { search ->
        if (search.isBlank()) {
            AbsentLiveData.create()
        } else {
            repoRepository.search(search)
        }
    }

    fun setQuery(originalInput: String) {
        val input = originalInput.toLowerCase(Locale.getDefault()).trim()
        if (input == _query.value) {
            return
        }
        _query.value = input
    }

    fun refresh() {
        _query.value?.let {
            _query.value = it
        }
    }
}
