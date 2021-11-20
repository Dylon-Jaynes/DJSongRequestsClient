package com.example.djsongrequestsclient.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.djsongrequestsclient.R

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_DJSongRequestsClient)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}