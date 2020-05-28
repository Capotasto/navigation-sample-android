package jp.burnaby.navigation_sample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.burnaby.navigation_sample.MainActivity

@Suppress("unused")
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [
        FragmentModule::class
    ])
    abstract fun contributeMainActivity(): MainActivity

}
