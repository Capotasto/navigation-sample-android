package jp.burnaby.navigation_sample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.burnaby.navigation_sample.ui.tab1.DetailFragment
import jp.burnaby.navigation_sample.ui.tab1.Tab1Fragment
import jp.burnaby.navigation_sample.ui.tab2.Tab2Fragment
import jp.burnaby.navigation_sample.ui.tab3.Tab3Fragment

@Suppress("unused")
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeTab1Fragment(): Tab1Fragment

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment

    @ContributesAndroidInjector
    abstract fun contributeTab2Fragment(): Tab2Fragment

    @ContributesAndroidInjector
    abstract fun contributeTab3Fragment(): Tab3Fragment

}
