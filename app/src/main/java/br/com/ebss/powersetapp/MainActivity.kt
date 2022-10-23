package br.com.ebss.powersetapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.ebss.powersetapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var set = mutableSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupViews()
    }

    private fun setupViews() {
        binding.btnNewSet.setOnClickListener {
            set = mutableSetOf()
            val setSize = Random.nextInt(0, 5)
            for (i in 1..setSize) {
                set.add(i)
            }
            binding.textInitialSet.text = set.toString()
        }
        binding.btnGetPowerSet.setOnClickListener {
            binding.textResultSet.text = "Set: $set"
            binding.textResultPowerSet.text = "Result: ${set.powerSet()}"
        }
    }
}