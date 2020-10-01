package com.fillipepr.celleptech_curso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

           //recuperando email
        val email = intent.getStringExtra("INTENT_EMAIL")

            //acessando o arquivo de Shared Preferences
        val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)
            //recuperando os dados do arquivo de Shared Preferences
        val nome = sharedPrefs.getString("NOME", "")
        val sobrenome = sharedPrefs.getString("SOBRENOME", "")
        val genero = sharedPrefs.getString("GENERO", "")

            // exibindo os textos recuperados nos textviews
        txvMainName.text = "$nome $sobrenome"
        txvMainEmail.text = email
        txvMainEmail.text = genero

            //criando listner dos botoes
        btnMainSite.setOnClickListener {
            val nIntent = Intent(this, WebActivity::class.java)
            startActivity(nIntent)
        }
        btnMainClose.setOnClickListener {

            val alert = AlertDialog.Builder(this)
                //configurando o alert dialog
            alert.setTitle("Atenção")
            alert.setMessage("Deseja mesmo sair?") //texto da msg
            alert.setPositiveButton("sair"){ dialog, which ->
                val nIntent = Intent(this, LoginActivity::class.java)
                startActivity(nIntent)
                finishAffinity()
            }
            alert.setNeutralButton("cancelar"){dialog, which -> }


            alert.setCancelable(false) //obrigando o uso do alert para sair ou permanecer

            alert.show()

        }

    }
}