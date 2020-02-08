package com.mapprr.githubassignment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mapprr.githubassignment.ui.repo.RepoViewModel
import com.mapprr.githubassignment.ui.user.UserViewModel
import com.mapprr.githubassignment.ui.user_search.ReposSearchViewModel
import com.mapprr.githubassignment.viewmodel.GithubViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReposSearchViewModel::class)
    abstract fun bindReposSearchViewModel(reposSearchViewModel: ReposSearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel::class)
    abstract fun bindRepoViewModel(repoViewModel: RepoViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: GithubViewModelFactory): ViewModelProvider.Factory
}
