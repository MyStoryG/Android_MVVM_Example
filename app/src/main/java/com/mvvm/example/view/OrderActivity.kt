package com.mvvm.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mvvm.example.R
import com.mvvm.example.databinding.ActivityOrderBinding
import com.mvvm.example.viewmodel.OrderViewModel

class OrderActivity : AppCompatActivity() {
    private val viewModel: OrderViewModel = OrderViewModel()
    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order)
        setAmericanoQtyObserver()
        setTotalPriceObserver()
        setAddButtonClickListener()
        setDelButtonClickListener()
    }

    private fun setAmericanoQtyObserver() {
        viewModel.americanoQty.observe(this) {
            binding.americanoCountText.text = it
        }
    }

    private fun setTotalPriceObserver() {
        viewModel.totalPrice.observe(this) {
            binding.totalPriceText.text = it
        }
    }

    private fun setAddButtonClickListener() {
        binding.americanoAddButton.setOnClickListener {
            viewModel.addAmericano()
        }
    }

    private fun setDelButtonClickListener() {
        binding.americanoDeleteButton.setOnClickListener {
            viewModel.delAmericano()
        }
    }
}