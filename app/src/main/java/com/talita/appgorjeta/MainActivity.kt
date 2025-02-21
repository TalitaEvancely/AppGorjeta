package com.talita.appgorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.talita.appgorjeta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /* valor total da conta
     numero de pessoas
     porcentagem da gorgeta
     10%, 15% ou 20 %
     botão calcular e limpar

     Recuperar as Views do layout
      - view binding

      -recuperar as radios buttons
      - calcular as porcetagens
      - mostrar resultado na tela
     */

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var porcentage: Int = 0

        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
        if (isChecked)
        porcentage = 10
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
        if (isChecked)
        porcentage = 15

        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
        if (isChecked)
        porcentage = 20

        }
        binding.btnClean.setOnClickListener{
            println("talita 1" + binding.tieTotal.text)
            println("talita 1" + binding.tieNumPeople.text)

        }

        binding.btnDone.setOnClickListener{
            val totalTabletemp = binding.tieTotal.text
            val NPeopletemp = binding.tieNumPeople.text

            if (totalTabletemp?.isEmpty() ==true ||
                NPeopletemp?.isEmpty()==true){
                Snackbar
                    .make(binding.tieTotal, "preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            }
            else{
                val Totaltable: Float = totalTabletemp.toString().toFloat()
                val nPeople: Int = NPeopletemp.toString().toInt()

                val TotalTemp = Totaltable / nPeople
                val Tips = TotalTemp * porcentage /100
                val TotalWithTips = TotalTemp + Tips

                binding.tvResult.text = "conta com gorgeta : $TotalWithTips"
            }
            binding.btnClean.setOnClickListener{
                binding.tvResult.text = ""
                binding.tieTotal.setText ("")
                binding.tieNumPeople.setText ("")
                binding.rbOptionOne.isChecked = false
                binding.rbOptionTwo.isChecked = false
                binding.rbOptionThree.isChecked = false

            }


        }
    }
}