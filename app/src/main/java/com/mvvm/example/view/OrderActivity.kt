package com.mvvm.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mvvm.example.R
import com.mvvm.example.databinding.ActivityOrderBinding
import com.mvvm.example.viewmodel.OrderViewModel

class OrderActivity : AppCompatActivity() {
    private lateinit var viewModel: OrderViewModel
    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order)
        binding.lifecycleOwner = this
        binding.counter = viewModel
    }
}