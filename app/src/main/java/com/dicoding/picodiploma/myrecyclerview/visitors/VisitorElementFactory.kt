package com.dicoding.picodiploma.myrecyclerview.visitors

import android.view.View
import com.dicoding.picodiploma.myrecyclerview.base.AbstractViewHolder
import com.dicoding.picodiploma.myrecyclerview.viewholder.CardHeroViewHolder
import com.dicoding.picodiploma.myrecyclerview.viewholder.GridHeroViewHolder
import com.dicoding.picodiploma.myrecyclerview.viewholder.ListHeroViewHolder
import com.dicoding.picodiploma.myrecyclerview.model.CardHero
import com.dicoding.picodiploma.myrecyclerview.model.GridHero
import com.dicoding.picodiploma.myrecyclerview.model.Hero

class VisitorElementFactory(
        private val onClick:(Hero) -> Unit
): VisitorElement {

    override fun type(typeFactory: Hero): Int = ListHeroViewHolder.LAYOUT
    override fun type(typeFactory: GridHero): Int = GridHeroViewHolder.LAYOUT
    override fun type(typeFactory: CardHero): Int = CardHeroViewHolder.LAYOUT

    override fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*> {
        return when(type) {
            ListHeroViewHolder.LAYOUT -> ListHeroViewHolder(parent, onClick)
            GridHeroViewHolder.LAYOUT -> GridHeroViewHolder(parent)
            CardHeroViewHolder.LAYOUT -> CardHeroViewHolder(parent)
            else -> createViewHolder(parent, type)
        }
    }

}