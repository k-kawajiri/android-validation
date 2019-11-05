package com.k.k.validation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.k.k.validation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.apply {
            viewModel = mainViewModel
            lifecycleOwner = this@MainActivity
        }
    }


}
