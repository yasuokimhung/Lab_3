package com.example.lab3

import java.text.NumberFormat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.caculateButton.setOnClickListener { caculateTip() }
    }
    fun caculateTip(){
        val stringIntextField = binding.costOfService.text.toString();
        val cost = stringIntextField.toDoubleOrNull();
        if (cost == null || cost == 0.0){
            binding.tipResult.text = ""
            return
        }
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId){
            R.id.option_eighteen_percent -> 0.18
            R.id.option_fifteen_percent -> 0.15
            else -> 0.20
        }
        var tip = tipPercentage*cost;
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)

    }
}