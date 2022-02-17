package com.example.movieapp.presention.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.contract.ChangingData
import com.example.movieapp.contract.MovieCallback
import com.example.movieapp.data.network.models.MovieDto
import com.example.movieapp.data.network.models.Result
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.presention.detail.DetailMovieFragment
import com.example.movieapp.presention.home.adapter.MovieAdapter


class HomeFragment : Fragment(), ChangingData, MovieCallback {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private val viewModel: HomeViewModel by viewModels()

    var adapter: MovieAdapter? = null
    private var movieResponseObserver: Observer<MovieDto>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initAdapter()
    }

    fun initAdapter() {
        adapter = MovieAdapter()
        adapter?.callback = this
        binding?.recyclerViewHome?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerViewHome?.adapter = adapter
    }

    override fun setData(data: List<Result>) {
        adapter?.setData(data)
    }

    override fun replaceData(data: List<Result>) {
        adapter?.replaceList(data)
    }

    override fun openFragment(result: Result) {
        val fragment = DetailMovieFragment()
        val bundle = Bundle()
        bundle.putParcelable("key", result)
        fragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onStart() {
        viewModel.getMovie()
        movieResponseObserver = Observer {
            adapter?.setData(it.results)
        }
        movieResponseObserver?.let { viewModel.getMovieResponse.observe(this, it) }

        super.onStart()
    }

    override fun onStop() {
        movieResponseObserver?.let { viewModel.getMovieResponse.removeObserver(it) }
        super.onStop()
    }
}
