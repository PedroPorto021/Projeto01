package br.com.projeto01.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textoBoasVindas =
            findViewById<TextView>(R.id.txtBoasVindas)

        val botaoSair =
            findViewById<Button>(R.id.btnSair)

        val botaoMensagem = findViewById<Button>(R.id.btnMensagem)

        val loginRecebido =
            intent.getStringExtra("LOGIN_USUARIO")

        textoBoasVindas.text = "Bem-vindo, $loginRecebido!"

        botaoSair.setOnClickListener {
            finish()
        }

        botaoMensagem.setOnClickListener {
            Toast.makeText(
                this,
                "Você está na tela inicial",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}