package jp.burnaby.navigation_sample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import jp.burnaby.navigation_sample.ui.tab1.DetailViewModel
import jp.burnaby.navigation_sample.ui.tab1.Tab1ViewModel
import jp.burnaby.navigation_sample.ui.tab2.Tab2ViewModel
import jp.burnaby.navigation_sample.ui.tab3.Tab3ViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(Tab1ViewModel::class)
    abstract fun bindTab1ViewModel(viewModel: Tab1ViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(Tab2ViewModel::class)
    abstract fun bindTab2ViewModel(viewModel: Tab2ViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(Tab3ViewModel::class)
    abstract fun bindTab3ViewModel(viewModel: Tab3ViewModel): ViewModel


}
