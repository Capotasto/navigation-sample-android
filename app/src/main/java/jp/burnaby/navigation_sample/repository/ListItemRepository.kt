package jp.burnaby.navigation_sample.repository

import io.reactivex.Single
import javax.inject.Inject

class ListItemRepository @Inject constructor() {

    fun getListItems(): Single<List<String>> {
        return Single.create { emitter ->
            emitter.onSuccess(getItems())
        }
    }

    private fun getItems(): List<String> {
        val result = mutableListOf<String>()
        for (i in 1 until 100) {
            result.add("item $i")
        }
        return result
    }
}