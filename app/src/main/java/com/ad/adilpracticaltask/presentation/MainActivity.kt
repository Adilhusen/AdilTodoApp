package com.ad.adilpracticaltask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ad.adilpracticaltask.R
import com.ad.adilpracticaltask.base.BaseActivity
import com.ad.adilpracticaltask.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}