package com.mapprr.githubassignment.di

import com.mapprr.githubassignment.ui.user_search.ReposSearchFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
//    @ContributesAndroidInjector
//    abstract fun contributeRepoFragment(): RepoFragment
//
//    @ContributesAndroidInjector
//    abstract fun contributeUserFragment(): UserFragment

    @ContributesAndroidInjector
    abstract fun contributeReposSearchFragment(): ReposSearchFragment
}
