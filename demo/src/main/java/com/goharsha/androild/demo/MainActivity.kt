package com.goharsha.androild.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.goharsha.androild.core.AndroILD
import com.goharsha.androild.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AndroILD.newRequest()
            .load(R.drawable.logo)
            .into(binding.localImageView)

        AndroILD.newRequest()
            .load("https://github.com/sriharshachilakapati/AndroILD/raw/main/AndroILD.png")
            .into(binding.remoteImageView)

        AndroILD.newRequest()
            .load("https://github.com/sriharshachilakapati/AndroILD/raw/main/AndroILD.png")
            .resize(300, 300)
            .into(binding.resizedRemoteImageView)
    }
}