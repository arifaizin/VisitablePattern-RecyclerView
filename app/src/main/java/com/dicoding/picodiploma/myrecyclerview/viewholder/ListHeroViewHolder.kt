package com.dicoding.picodiploma.myrecyclerview.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.myrecyclerview.R
import com.dicoding.picodiploma.myrecyclerview.base.AbstractViewHolder
import com.dicoding.picodiploma.myrecyclerview.databinding.ItemRowHeroBinding
import com.dicoding.picodiploma.myrecyclerview.model.Hero

/**
 * Created by sidiqpermana on 10/28/16.
 */

class ListHeroViewHolder(view: View, val onClick: (Hero) -> Unit) : AbstractViewHolder<Hero>(view) {

    private val binding = ItemRowHeroBinding.bind(view)

    override fun bind(hero: Hero) {
        with(binding) {
            Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(imgItemPhoto)

            tvItemName.text = hero.name
            tvItemDescription.text = hero.description

            itemView.setOnClickListener { onClick(hero) }
        }
    }

    companion object {
        val LAYOUT = R.layout.item_row_hero
    }
}
