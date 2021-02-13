package com.dicoding.picodiploma.myrecyclerview.model

import android.os.Parcelable
import com.dicoding.picodiploma.myrecyclerview.visitors.VisitorElement
import com.dicoding.picodiploma.myrecyclerview.base.VisitorUIModel
import kotlinx.android.parcel.Parcelize

/**
 * Created by sidiqpermana on 10/29/16.
 */

@Parcelize
data class GridHero(
        var name: String,
        var description: String,
        var photo: String
) : VisitorUIModel(), Parcelable {
    override fun type(typeFactory: VisitorElement): Int {
        return typeFactory.type(this)
    }
}
