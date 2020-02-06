package com.mapprr.githubassignment.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.mapprr.githubassignment.vo.Contributor
import com.mapprr.githubassignment.vo.Repo
import com.mapprr.githubassignment.vo.RepoSearchResult
import com.mapprr.githubassignment.vo.User

/**
 * Main database description.
 */
@Database(
    entities = [
        User::class,
        Repo::class,
        Contributor::class,
        RepoSearchResult::class],
    version = 1,
    exportSchema = false
)
abstract class GithubDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun repoDao(): RepoDao
}
