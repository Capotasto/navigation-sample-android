package jp.burnaby.navigation_sample.ui.tab3

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import jp.burnaby.navigation_sample.R
import javax.inject.Inject

class Tab3Fragment : DaggerFragment(R.layout.fragment_tab3) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: Tab3ViewModel by viewModels {
        viewModelFactory
    }
}
