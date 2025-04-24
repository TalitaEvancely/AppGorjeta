package com.talita.appgorjeta

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.talita.appgorjeta.databinding.ActivityMainBinding
import com.talita.appgorjeta.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val valorTotalConta = intent.getFloatExtra("totalConta", 0f)
        val nPessoas = intent.getIntExtra("numeroPessoas", 1)
        val porcentagem = intent.getIntExtra("porcentagem", 0)

        val contaPorPessoa = valorTotalConta / nPessoas
        val valorGorjeta = contaPorPessoa * porcentagem / 100
        val totalComGorjeta = contaPorPessoa + valorGorjeta

        val mensagem = "Sua conta de R$ $valorTotalConta com gorjeta de $porcentagem %,\n" +
                "dividida por $nPessoas pessoas,\n" +
                "ficará em R$ $totalComGorjeta por pessoa."


        binding.tvResultMessage.text = mensagem

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

}