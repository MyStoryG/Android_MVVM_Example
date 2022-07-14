package com.mvvm.example.model

class CafeLatte : Beverage(2500) {
    override fun add() {
        ++quantity
    }

    override fun delete() {
        --quantity
        if (quantity < 0) {
            quantity = 0
        }
    }
}