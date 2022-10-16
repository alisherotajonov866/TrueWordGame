package ru.startandroid.truewordgame

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import ru.startandroid.truewordgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val text: Array<String> = arrayOf("Hello", "Friday", "University", "School", "Church")
    private var cnt = 0
    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvWord.text = text[0]

        binding.btnNext.setOnClickListener {

            var inputEntry = binding.etInput.text.toString()

            if (inputEntry == text[number]) {
                cnt++
                number++
                binding.tvScore.text = "Score: $cnt"
                if (number == text.size) {
                    binding.tvWord.text = "O'yin tugadi!"
                    binding.etInput.text = null
                    binding.btnNext.isEnabled = false
                } else {
                    binding.tvWord.text = text[number]
                    binding.etInput.text = null
                }

            } else {
                number++

                if (number == text.size) {
                    binding.tvWord.text = "O'yin tugadi!"
                    binding.etInput.text = null
                    binding.btnNext.isEnabled = false
                } else {
                    binding.tvWord.text = text[number]
                    binding.etInput.text = null
                }
            }

        }

    }

}