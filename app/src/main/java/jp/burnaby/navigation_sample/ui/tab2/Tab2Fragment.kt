package jp.burnaby.navigation_sample.ui.tab2

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import jp.burnaby.navigation_sample.R
import javax.inject.Inject

class Tab2Fragment : DaggerFragment(R.layout.fragment_tab2) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: Tab2ViewModel by viewModels {
       viewModelFactory
    }
}
