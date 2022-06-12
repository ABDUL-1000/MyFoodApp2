package com.example.myfoodapp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfoodapp2.databinding.FoodActivityBinding

class FoodActivity : AppCompatActivity() {
    companion object {
        const val NAME = "name"
        const val IMAGE = "image"
        const val DETAILS = "detail"
        const val PRICE = "price"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FoodActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpFoodDetails(binding)
    }

    private fun setUpFoodDetails(binding: FoodActivityBinding) {
        val name = intent.getStringExtra(NAME)
        val imageRes = intent.getIntExtra(IMAGE, R.drawable.akpu)
        val detailsRes = intent.getIntExtra(DETAILS, R.string.Akpu_detail)
        val price = intent.getStringExtra(PRICE)

        binding.apply {
            nameOfTheFood.text = name
            price2.text = price
            foodDetailImage.setImageResource(imageRes)
            foodDetails.text = getString(detailsRes)
        }

    }
}