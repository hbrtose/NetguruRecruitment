package com.eniro.netgururecruitment.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.eniro.netgururecruitment.data.ListItemData
import com.eniro.netgururecruitment.databinding.ItemListBinding

class ListRecycler(liveData: LiveData<List<ListItemData>>,
                   owner: LifecycleOwner,
                   private val onItemClicked: (ListItemData) -> Unit): RecyclerView.Adapter<ListRecycler.ItemHolder>() {

    private val items = mutableListOf<ListItemData>()

    init {
        liveData.observe(owner, Observer {
            items.clear()
            items.addAll(it)
            notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(items[position], onItemClicked)
    }

    class ItemHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: ListItemData, listener: (ListItemData) -> Unit) {
            binding.tvItem.text = item.name
            binding.tvItem.setTextColor(item.color)
            binding.root.setOnClickListener { listener(item) }
        }
    }
}