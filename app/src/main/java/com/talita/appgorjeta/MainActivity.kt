
package com.talita.appgorjeta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.talita.appgorjeta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("totalConta", Totaltable)
                intent.putExtra("numeroPessoas", nPeople)
                intent.putExtra("porcentagem", porcentage)

                startActivity(intent)
            }
            binding.btnClean.setOnClickListener{
                binding.tieTotal.setText ("")
                binding.tieNumPeople.setText ("")
                binding.rbOptionOne.isChecked = false
                binding.rbOptionTwo.isChecked = false
                binding.rbOptionThree.isChecked = false

            }


        }
    }
}
