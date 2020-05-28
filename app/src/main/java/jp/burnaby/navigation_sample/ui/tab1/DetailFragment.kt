package jp.burnaby.navigation_sample.ui.tab1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment
import jp.burnaby.navigation_sample.R
import jp.burnaby.navigation_sample.databinding.FragmentDetailBinding
import jp.burnaby.navigation_sample.ext.dataBinding
import javax.inject.Inject

class DetailFragment : DaggerFragment(R.layout.fragment_detail) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: DetailViewModel by viewModels {
        viewModelFactory
    }

    private val args: DetailFragmentArgs by navArgs()

    private val binding: FragmentDetailBinding by dataBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title = args.title
    }
}
