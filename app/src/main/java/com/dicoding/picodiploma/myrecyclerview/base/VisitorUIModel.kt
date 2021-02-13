package com.dicoding.picodiploma.myrecyclerview.base

import com.dicoding.picodiploma.myrecyclerview.visitors.VisitorElement

abstract class VisitorUIModel {
    abstract fun type(typeFactory: VisitorElement): Int
}