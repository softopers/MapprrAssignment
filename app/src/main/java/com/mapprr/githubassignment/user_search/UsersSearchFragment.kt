package com.mapprr.githubassignment.user_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mapprr.githubassignment.R


class UsersSearchFragment : Fragment() {

    companion object {
        fun newInstance() =
            UsersSearchFragment()
    }

    private lateinit var viewModel: UsersSearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.users_search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UsersSearchViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
