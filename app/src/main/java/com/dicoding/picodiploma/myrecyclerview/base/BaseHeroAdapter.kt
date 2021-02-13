package com.dicoding.picodiploma.myrecyclerview.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.myrecyclerview.visitors.VisitorElement

class BaseHeroAdapter (
        private val adapterTypeFactory: VisitorElement,
        private val items: ArrayList<VisitorUIModel> = arrayListOf()
): RecyclerView.Adapter<AbstractViewHolder<VisitorUIModel>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder<VisitorUIModel> {
        val view = inflateItem(parent, viewType)
        return adapterTypeFactory.createViewHolder(view, viewType) as AbstractViewHolder<VisitorUIModel>
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AbstractViewHolder<VisitorUIModel>, position: Int) {
        holder.bind(items[position])
    }

    private fun inflateItem(viewGroup: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(viewGroup.context).inflate(viewType, viewGroup, false)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type(adapterTypeFactory)
    }

    fun addItem(items: List<VisitorUIModel>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun removeItem(item: VisitorUIModel) {
        this.items.remove(item)
        notifyDataSetChanged()
    }

}