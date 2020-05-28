package jp.burnaby.navigation_sample.ui.tab1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import jp.burnaby.navigation_sample.common.Event
import jp.burnaby.navigation_sample.repository.ListItemRepository
import javax.inject.Inject

class Tab1ViewModel @Inject constructor(
    private val listItemRepository: ListItemRepository
) : ViewModel() {

    private val _items = mutableListOf<String>()

    private val _showDetailScreen = MutableLiveData<Event<String>>()
    val showDetailScreen: LiveData<Event<String>>
        get() = _showDetailScreen

    private val onClickItem: (position: Int) -> Unit = { position ->
        _showDetailScreen.value = Event(_items[position])
    }

    var adapter: ItemListAdapter = ItemListAdapter(this.onClickItem)

    init {
        getItems()
    }

    private fun getItems() {
        listItemRepository.getListItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { items ->
                    _items.addAll(items)
                    adapter.submitList(items)
                },
                onError = { w ->
                    Log.w(Tab1ViewModel::class.java.simpleName, w)
                }
            ).addTo(CompositeDisposable())
    }

}
