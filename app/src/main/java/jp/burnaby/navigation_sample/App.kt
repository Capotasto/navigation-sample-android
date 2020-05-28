package jp.burnaby.navigation_sample

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import jp.burnaby.navigation_sample.di.DaggerAppComponent

class App: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}