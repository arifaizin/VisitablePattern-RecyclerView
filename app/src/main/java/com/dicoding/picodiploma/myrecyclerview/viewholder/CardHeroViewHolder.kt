package com.dicoding.picodiploma.myrecyclerview.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.myrecyclerview.R
import com.dicoding.picodiploma.myrecyclerview.base.AbstractViewHolder
import com.dicoding.picodiploma.myrecyclerview.databinding.ItemCardviewHeroBinding
import com.dicoding.picodiploma.myrecyclerview.databinding.ItemGridHeroBinding
import com.dicoding.picodiploma.myrecyclerview.model.CardHero
import com.dicoding.picodiploma.myrecyclerview.model.GridHero
import com.dicoding.picodiploma.myrecyclerview.model.Hero
import java.util.*

/**
 * Created by sidiqpermana on 10/29/16.
 */

class CardHeroViewHolder(view: View) : AbstractViewHolder<CardHero>(view) {

    private val binding = ItemCardviewHeroBinding.bind(view)

    override fun bind(hero: CardHero) {
        with(binding) {
            Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(imgItemPhoto)

            tvItemName.text = hero.name
            tvItemDescription.text = hero.description

            btnSetFavorite.setOnClickListener { Toast.makeText(itemView.context, "Favorite ${hero.name}", Toast.LENGTH_SHORT).show() }

            btnSetShare.setOnClickListener { Toast.makeText(itemView.context, "Share ${hero.name}", Toast.LENGTH_SHORT).show() }

            itemView.setOnClickListener { Toast.makeText(itemView.context, "Kamu memilih ${hero.name}", Toast.LENGTH_SHORT).show() }
        }
    }

    companion object {
        const val LAYOUT = R.layout.item_cardview_hero
    }
}
