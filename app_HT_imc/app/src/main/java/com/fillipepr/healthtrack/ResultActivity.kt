package com.fillipepr.healthtrack

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //recuperando valor do IMC
        val imcR = intent.getStringExtra("INTENT_IMC")
        val sheredPrefs =  getSharedPreferences("user_$imcR", Context.MODE_PRIVATE)//not sure why

        //definindo alerta
        fun msgAviso(imc:String): String {
            val imcF = imc.toFloat()
            return if (imcF < 17){
                "ATENÇÃO, muito abaixo do peso!"
            }else if (imcF<=18.49){
                "Cuidado, está abaixo do peso."
            }else if (imcF< 24.99){
                "Muito bem, peso normal."
            }else if (imcF< 29.99){
                "Opa... você está acima do peso."
            }else if (imcF<34.99){
                "Muito cuidado! Você está entrando na obesidade"
            }else if (imcF<40){
                "Obesidade SEVERA, procure auxílio médico."
            }else "OBESIDADE MÓRBIDA"

        }

        val aviso:String = msgAviso(imcR.toString())

        Toast.makeText(this, aviso, Toast.LENGTH_LONG ).show();

        txvResultResult.text = imcR.toString()



    }
}