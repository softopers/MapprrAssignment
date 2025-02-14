package com.mapprr.githubassignment.vo

import androidx.room.Entity
import androidx.room.TypeConverters
import com.mapprr.githubassignment.db.GithubTypeConverters

@Entity(primaryKeys = ["query"])
@TypeConverters(GithubTypeConverters::class)
data class RepoSearchResult(
    val query: String,
    val repoIds: List<Int>,
    val totalCount: Int
)
