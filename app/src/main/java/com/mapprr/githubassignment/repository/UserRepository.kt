package com.mapprr.githubassignment.repository

import androidx.lifecycle.LiveData
import com.mapprr.githubassignment.AppExecutors
import com.mapprr.githubassignment.api.GithubService
import com.mapprr.githubassignment.db.UserDao
import com.mapprr.githubassignment.vo.Resource
import com.mapprr.githubassignment.vo.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository that handles User objects.
 */
//@OpenForTesting
@Singleton
class UserRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val userDao: UserDao,
    private val githubService: GithubService
) {

    fun loadUser(login: String): LiveData<Resource<User>> {
        return object : NetworkBoundResource<User, User>(appExecutors) {
            override fun saveCallResult(item: User) {
                userDao.insert(item)
            }

            override fun shouldFetch(data: User?) = data == null

            override fun loadFromDb() = userDao.findByLogin(login)

            override fun createCall() = githubService.getUser(login)
        }.asLiveData()
    }
}
