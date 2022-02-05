package com.example.islamiproject

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.islamiproject.ConstantKeys.Constant
import com.example.islamiproject.databinding.ActivitySuraContentBinding

class SuraContent : AppCompatActivity() {
    lateinit var titleTextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_content);
        setSupportActionBar(findViewById(R.id.sura_content_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        titleTextView=findViewById(R.id.sura_content_title)
        titleTextView.setText(intent.getStringExtra(Constant.sura_name))
    }

}