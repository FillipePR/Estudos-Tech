package com.fillipepr.celleptech_curso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        
        //criando opções para o spinner
        
        val genderList = arrayListOf("selecione um gênero", "Feminino", "Masculino", "Não binário",
        "Prefiro não declarar")

        //criando um adaptador para implementar o spinner

        val genderAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            genderList
        )

        //inserindo adaptador no spinner
        spnSignupGender.adapter = genderAdapter

        //criando listner do cadastro
        btnSignupSubmit.setOnClickListener {

            //obtendo os dados digitados pelo user
            val nome = edtSignupName.text.toString().trim();
            val sobrenome = edtSignupSurename.text.toString().trim();
            val email = edtSignupEmail.text.toString().trim();
            val senha = edtSignupPassword.text.toString().trim();
            val genero = spnSignupGender.selectedItem.toString();

            //validação dos campos

            if(nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()
                || genero == genderList[0]) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else {
                    //criar/acessar p arquivo shared preferences
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                    //editar arquivo
                val editPrefs = sharedPrefs.edit()

                    //add modificações para editPrefs
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("GENERO", genero)

                    //aplicando as alterações no shaed preferences
                editPrefs.apply()

                    //abrir "próxima" tela (main
                val nIntent = Intent(this, MainActivity::class.java)

                    //garantir a troca de dados com a póxima tela
                nIntent.putExtra("INTENT_EMAIL", email)

                startActivity(nIntent)

                finishAffinity()

        }

        }

    }
}