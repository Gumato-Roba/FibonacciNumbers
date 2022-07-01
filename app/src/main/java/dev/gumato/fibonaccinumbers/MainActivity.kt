package dev.gumato.fibonaccinumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import dev.gumato.fibonaccinumbers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayNumbers()

    }
    fun displayNumbers(){
        var numbersList = numbers(100)
        val numbersAdapter = NumberRecyclerViewAdapter(numbersList)

        binding.rvNumbers.layoutManager = LinearLayoutManager(this)
        binding.rvNumbers.adapter = numbersAdapter
    }
    fun numbers(args:Int):List<Int>{
        val list = ArrayList<Int> ()
        var num1 = 0
        var num2 = 1
        for (i in 1..args){
            var sum = num1 + num2
            num1 = num2
            num2 = sum
            list +=sum
        }
        return list
    }
}