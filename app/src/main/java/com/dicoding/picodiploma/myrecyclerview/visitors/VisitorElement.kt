package com.dicoding.picodiploma.myrecyclerview.visitors

import android.view.View
import com.dicoding.picodiploma.myrecyclerview.base.AbstractViewHolder
import com.dicoding.picodiploma.myrecyclerview.model.CardHero
import com.dicoding.picodiploma.myrecyclerview.model.GridHero
import com.dicoding.picodiploma.myrecyclerview.model.Hero

interface VisitorElement {
    fun type(typeFactory: Hero): Int
    fun type(typeFactory: GridHero): Int
    fun type(typeFactory: CardHero): Int

    fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*>
}