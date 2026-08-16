package br.com.projeto01.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var campoLogin: TextInputEditText
    private lateinit var campoSenha: TextInputEditText
    private lateinit var botaoEntrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        campoLogin = findViewById(R.id.tieLogin)
        campoSenha = findViewById(R.id.tieSenha)
        botaoEntrar = findViewById(R.id.btnEntrar)

        botaoEntrar.setOnClickListener {
            validarLogin()
        }
    }

    override fun onResume() {
        super.onResume()

        campoLogin.text?.clear()
        campoSenha.text?.clear()
    }

    private fun validarLogin() {

        val login = campoLogin.text.toString()
        val senha = campoSenha.text.toString()

        if (login.isEmpty()) {

            campoLogin.error = "Digite seu login"

        } else if (senha.isEmpty()) {

            campoSenha.error = "Digite sua senha"

        } else if (login == "admin" && senha == "1234") {

            val intent = Intent(this, HomeActivity::class.java)

            intent.putExtra("LOGIN_USUARIO", login)

            startActivity(intent)

        } else {

            Toast.makeText(
                this,
                "Login ou senha incorretos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}