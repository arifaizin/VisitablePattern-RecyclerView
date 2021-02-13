package com.dicoding.picodiploma.myrecyclerview.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.myrecyclerview.R
import com.dicoding.picodiploma.myrecyclerview.base.AbstractViewHolder
import com.dicoding.picodiploma.myrecyclerview.databinding.ItemGridHeroBinding
import com.dicoding.picodiploma.myrecyclerview.model.GridHero

/**
 * Created by sidiqpermana on 10/29/16.
 */

class GridHeroViewHolder(view: View) : AbstractViewHolder<GridHero>(view) {

    private val binding = ItemGridHeroBinding.bind(view)

    override fun bind(hero: GridHero) {
        with(binding) {
            Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(imgItemPhoto)
        }
    }

    companion object {
        const val LAYOUT = R.layout.item_grid_hero
    }
}
