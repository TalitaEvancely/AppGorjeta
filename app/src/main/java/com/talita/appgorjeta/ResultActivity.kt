package com.talita.appgorjeta

import android.os.Build
import android.os.Bundle
import android.text.Html
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

    val totalTable = intent.getFloatExtra("totalTable", 0.0f)
    val numPeople = intent.getIntExtra("numPeople", 0)
    val percentage = intent.getIntExtra("percentage",0)
    val totalAmount = intent.getFloatExtra("totalAmount", 0.0f)



        binding.tvPercentage.text = percentage.toString()
        binding.tvTotalAmount.text = totalAmount.toString()
        binding.tvTotalTable.text = totalTable.toString()
        binding.tvTotalNumberPeople.text = numPeople.toString()


        binding.btnRefresh.setOnClickListener {

            finish()
        }


    }

}