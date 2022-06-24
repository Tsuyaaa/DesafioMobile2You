package com.mobile2you.moviedbmobile2you

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobile2you.moviedbmobile2you.api.RetrofitInstance
import com.mobile2you.moviedbmobile2you.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(2000)

        setTheme(R.style.Theme_MovieDBMobile2You)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()


    }
}