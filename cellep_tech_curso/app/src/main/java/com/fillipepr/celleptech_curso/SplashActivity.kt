package com.fillipepr.celleptech_curso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //criando um tempo de espera antes de iniciar a tela login;

        Handler(Looper.getMainLooper()).postDelayed({
            //Criando a intent de transitar para uma proxima tela
            val nIntent = Intent(this, LoginActivity::class.java /*aqui define que está abrindo uma nova tela*/)
            startActivity(nIntent) /*chamando a intent de nova tela*/
            finish() /* encerrando a tela splash*/
        },2000)

    }
}