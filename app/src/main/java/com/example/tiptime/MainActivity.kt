package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    fun calculateTip(){
        val stringInViewField=binding.costOfService.text.toString()
        val cost=stringInViewField.toDouble()
        val selectId=binding.tipOptions.checkedRadioButtonId
        val tipPercentage=when(selectId){
            R.id.option_twenty_percent->0.20
            R.id.option_eighteen_percent->0.18
            else->0.15
        }
        var tip=tipPercentage*cost
        val roundUp=binding.roundUpSwitch.isChecked
        if (roundUp){
            tip=kotlin.math.ceil(tip)
        }
    }
}