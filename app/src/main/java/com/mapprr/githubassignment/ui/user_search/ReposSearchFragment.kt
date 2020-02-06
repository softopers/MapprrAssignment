package com.mapprr.githubassignment.ui.user_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.mapprr.githubassignment.R
import com.mapprr.githubassignment.binding.FragmentDataBindingComponent
import com.mapprr.githubassignment.databinding.ReposSearchFragmentBinding
import com.mapprr.githubassignment.di.Injectable
import com.mapprr.githubassignment.util.autoCleared
import javax.inject.Inject


class ReposSearchFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    var binding by autoCleared<ReposSearchFragmentBinding>()

    val reposSearchViewModel: ReposSearchViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.repos_search_fragment,
            container,
            false,
            dataBindingComponent
        )

        return binding.root
    }
}
