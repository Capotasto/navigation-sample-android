package jp.burnaby.navigation_sample.ui.tab1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jp.burnaby.navigation_sample.R
import jp.burnaby.navigation_sample.databinding.ItemSampleBinding
import kotlinx.android.synthetic.main.item_sample.view.*

class ItemListAdapter constructor(
    private val onClickItem: (position: Int) -> Unit
) : ListAdapter<String, ItemListAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<String> =
            object : DiffUtil.ItemCallback<String>() {

                override fun areItemsTheSame(
                    oldItem: String,
                    newItem: String
                ): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(
                    oldItem: String,
                    newItem: String
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemSampleBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_sample,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
        holder.itemView.item_root.setOnClickListener {
            onClickItem.invoke(position)
        }
    }

    inner class ViewHolder(
        private val binding: ItemSampleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: String) {
            binding.title = item
            binding.executePendingBindings()
        }
    }
}