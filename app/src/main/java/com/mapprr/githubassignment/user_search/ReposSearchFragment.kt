package com.mapprr.githubassignment.user_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mapprr.githubassignment.R


class ReposSearchFragment : Fragment() {

    companion object {
        fun newInstance() =
            ReposSearchFragment()
    }

    private lateinit var viewModel: ReposSearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.users_search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReposSearchViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
