package com.mvvm.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mvvm.example.R
import com.mvvm.example.viewmodel.OrderViewModel

class OrderActivity : AppCompatActivity() {
    private val viewModel: OrderViewModel = OrderViewModel()
    private lateinit var addButton: Button
    private lateinit var delButton: Button
    private lateinit var americanoCountText: TextView
    private lateinit var totalPriceText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        addButton = findViewById(R.id.americanoAddButton)
        delButton = findViewById(R.id.americanoDeleteButton)
        americanoCountText = findViewById<Button>(R.id.americanoCountText)
        totalPriceText = findViewById<Button>(R.id.totalPriceText)
        setAmericanoQtyObserver()
        setTotalPriceObserver()
        setAddButtonClickListener()
        setDelButtonClickListener()
    }

    private fun setAmericanoQtyObserver() {
        viewModel.americanoQty.observe(this) {
            americanoCountText.text = it
        }
    }

    private fun setTotalPriceObserver() {
        viewModel.totalPrice.observe(this) {
            totalPriceText.text = it
        }
    }

    private fun setAddButtonClickListener() {
        addButton.setOnClickListener {
            viewModel.addAmericano()
        }
    }

    private fun setDelButtonClickListener() {
        delButton.setOnClickListener {
            viewModel.delAmericano()
        }
    }
}