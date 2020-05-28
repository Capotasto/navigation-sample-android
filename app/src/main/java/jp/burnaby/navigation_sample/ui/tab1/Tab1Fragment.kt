package jp.burnaby.navigation_sample.ui.tab1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import jp.burnaby.navigation_sample.R
import jp.burnaby.navigation_sample.databinding.FragmentTab1Binding
import jp.burnaby.navigation_sample.ext.dataBinding
import javax.inject.Inject


class Tab1Fragment : DaggerFragment(R.layout.fragment_tab1) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: Tab1ViewModel by viewModels {
        viewModelFactory
    }

    private val binding: FragmentTab1Binding by dataBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listView.apply {
            adapter = viewModel.adapter
            addItemDecoration(DividerItemDecoration(binding.listView.context, LinearLayoutManager.VERTICAL))
        }

        viewModel.showDetailScreen.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { item->
                showDetailScreen(item)
            }
        })
    }

    private fun showDetailScreen(item: String) {
        val action = Tab1FragmentDirections.actionNavigationTab1ToDetailFragment(item)
        findNavController().navigate(action)
    }
}
