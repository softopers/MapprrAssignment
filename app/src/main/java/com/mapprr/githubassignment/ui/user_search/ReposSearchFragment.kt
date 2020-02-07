package com.mapprr.githubassignment.ui.user_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mapprr.githubassignment.AppExecutors
import com.mapprr.githubassignment.R
import com.mapprr.githubassignment.binding.FragmentDataBindingComponent
import com.mapprr.githubassignment.databinding.ReposSearchFragmentBinding
import com.mapprr.githubassignment.di.Injectable
import com.mapprr.githubassignment.ui.common.RepoListAdapter
import com.mapprr.githubassignment.ui.common.RetryCallback
import com.mapprr.githubassignment.util.autoCleared
import javax.inject.Inject


class ReposSearchFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    var binding by autoCleared<ReposSearchFragmentBinding>()

    var adapter by autoCleared<RepoListAdapter>()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        initRecyclerView()
        val rvAdapter = RepoListAdapter(
            dataBindingComponent = dataBindingComponent,
            appExecutors = appExecutors,
            showFullName = true
        ) { repo ->
            //            findNavController().navigate(
//                SearchFragmentDirections.showRepo(repo.owner.login, repo.name)
//            )
        }
        binding.query = reposSearchViewModel.query
        binding.recyclerViewRepoList.adapter = rvAdapter
        adapter = rvAdapter

        initSearchInputListener()

        binding.callback = object : RetryCallback {
            override fun retry() {
                reposSearchViewModel.refresh()
            }
        }
    }

    private fun initSearchInputListener() {
        binding.searchViewRepos.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    doSearch(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

    }

    private fun doSearch(query: String) {
        reposSearchViewModel.setQuery(query)
    }

    private fun initRecyclerView() {
        binding.searchResult = reposSearchViewModel.results
        reposSearchViewModel.results.observe(viewLifecycleOwner, Observer { result ->
            adapter.submitList(result?.data)
        })
    }
}
