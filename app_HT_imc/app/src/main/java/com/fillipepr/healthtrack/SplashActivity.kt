package com.fillipepr.healthtrack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    //Transição da activity com contador
    Handler(Looper.getMainLooper()).postDelayed({
        val nIntent = Intent(this, MainActivity::class.java)
        startActivity(nIntent)
        finish()

    },2500)


    }
}