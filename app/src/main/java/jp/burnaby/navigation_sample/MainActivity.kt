package jp.burnaby.navigation_sample

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import jp.burnaby.navigation_sample.databinding.ActivityMainBinding
import jp.burnaby.navigation_sample.ext.dataBinding

class MainActivity : DaggerAppCompatActivity(R.layout.activity_main) {

  private val binding: ActivityMainBinding by dataBinding()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setSupportActionBar(binding.toolbar)
    val navController = findNavController(R.id.nav_host_fragment)
    binding.bottomNavView.setupWithNavController(navController)

    val appBarConfiguration = AppBarConfiguration(
      topLevelDestinationIds = setOf(
        R.id.navigation_tab1,
        R.id.navigation_tab2,
        R.id.navigation_tab3
      )
    )
    setupActionBarWithNavController(navController, appBarConfiguration)
  }

  override fun onSupportNavigateUp(): Boolean =
    findNavController(R.id.nav_host_fragment).navigateUp()
}
