package com.fillipepr.celleptech_curso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //criando um listner para o botão entrar
        btnLoginLog.setOnClickListener {
            val email:String = edtLoginEmail.text.toString().trim();
            val password:String = edtLoginPassword.text.toString();
            //Validação dos campos
            if (email.isEmpty()) {
                edtLoginEmail.error = "Campo obrigatório";
                edtLoginEmail.requestFocus();
            }else if(password.isEmpty()){
                edtLoginPassword.error =  "Campo obrigatório";
                edtLoginPassword.requestFocus();
            } else {
                if( email == "teste@teste.com" && password == "1234"){
                    //exibindo um alerta sutil ao usuário com toast
                    Toast.makeText(this, "Usuário Logado", Toast.LENGTH_SHORT ).show();
                    val nIntent = Intent(this, MainActivity::class.java)
                    startActivity(nIntent);
                    finish();
                } else {

                    Toast.makeText(this, "Usuário ou Senha inválidos", Toast.LENGTH_LONG).show();
                }
            }
        }
        //criando um listner para o botão de cadastro
        btnLoginSign.setOnClickListener {

            val nIntent = Intent(this, SignupActivity::class.java);
            startActivity(nIntent);

        }
    }
}