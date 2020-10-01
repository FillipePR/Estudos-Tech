package com.fillipepr.celleptech_curso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

            //habilitando a leitura e execução de codigos JS
        wbvWeb.settings.javaScriptEnabled = true
            //carregando um endereço web para a webview
        wbvWeb.loadUrl("http://br.cellep.com/estacaohack/")

            //definindo o webview como o web client padrão
        wbvWeb.webViewClient = WebViewClient()
    }
}