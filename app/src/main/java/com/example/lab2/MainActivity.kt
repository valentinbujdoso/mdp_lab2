package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mutableList = mutableListOf<String>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.guessbtn.setOnClickListener {
            if (mutableList.size > 0) {

                val randomIndex = Random.nextInt(mutableList.size);
                val randomElement = mutableList[randomIndex]
                val input = binding.guess.text.toString().lowercase()

                if (randomElement.equals(input)) {
                    binding.msg.text =
                        "Congratulations! You guessed it right. It was " + randomElement + "."
                } else {
                    binding.msg.text =
                        "Sorry wrong guess. The correct answer was " + randomElement + "."
                }
            } else {
                binding.msg.text = "There is no added chemical!"
            }
        }

        binding.addbtn.setOnClickListener {
            val input = binding.chemical.text.toString().lowercase()
            if (mutableList.contains(input)) {
                binding.msg.text = "Chemical '" + input +"' is already available."
            } else {
                binding.msg.text = "Chemical '" + input +"' added successfully."
                mutableList.add(input)
            }

        }
    }
}

//super.onCreate(savedInstanceState)
//binding = ActivityMainBinding.inflate(layoutInflater)
//setContentView(binding.root)
//binding.button.setOnClickListener {
//    // Change the Label Text
//    binding.msg.text = "Happy BirthDay Dear ${binding.name.text}!"
//    // Change the ImageView dynamically
//    binding.image.setImageResource(R.drawable.gift)
//}


//binding.button.setOnClickListener {
//    // Change the Label Text
//    binding.msg.text = "Happy BirthDay Dear ${binding.name.text}!"
//    // Change the ImageView dynamically
//    binding.image.setImageResource(R.drawable.gift)
//}