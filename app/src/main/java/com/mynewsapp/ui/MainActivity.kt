package com.mynewsapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mynewsapp.NewsViewModelFactory
import com.mynewsapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, NewsViewModelFactory()).get(NewsViewModel::class.java)

        viewModel..observe(this, Observer { t -> showToast(t) }
        )
    }

    private fun showToast(t: String?) {
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show()
    }
}