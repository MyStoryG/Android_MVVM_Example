package com.mvvm.example.model

class Americano : Beverage(1500) {
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