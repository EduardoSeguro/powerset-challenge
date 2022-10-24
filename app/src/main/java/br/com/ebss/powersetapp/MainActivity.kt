package br.com.ebss.powersetapp

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
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
        binding.textResultPowerSet.movementMethod = ScrollingMovementMethod()
        binding.btnNewSet.setOnClickListener {
            createRandomSet()
            binding.textInitialSet.text = set.toString()
        }
        binding.btnGetPowerSet.setOnClickListener {
            binding.textResultSet.text = getString(R.string.current_set, set.toString())
            binding.textResultPowerSet.text =
                getString(R.string.result_powerset, set.powerSet().toString())
        }
    }

    private fun createRandomSet() {
        set = mutableSetOf()
        val setSize = Random.nextInt(0, 10)
        for (i in 1..setSize) {
            set.add(i)
        }
    }
}