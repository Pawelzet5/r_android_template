package com.example.r_android_template.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.r_android_template.databinding.ActivityMainBinding
import com.example.r_android_template.service.EstateRepository


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: RecyclerView.LayoutManager
    private var listOfEstates: EstateRepository = EstateRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listOfEstates.parseJSON()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            adapter = EstateListAdapter(listOfEstates.estateList){
                estate -> Save(estate.estateNo)

            }
            layoutManager = manager
            var itemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(itemDecoration)
        }


    }

    fun showEstateNumber(v: View){
        val sharedPreferences = getSharedPreferences("EstateNumber",Context.MODE_PRIVATE)
        var theNumber = sharedPreferences.getString("theNumber", null)
        Toast.makeText(this, theNumber, Toast.LENGTH_SHORT).show()
    }

    fun Save(Number: String){
        val sharedPreferences = getSharedPreferences("EstateNumber", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("theNumber", Number)
        }.apply()
        Toast.makeText(this, sharedPreferences.getString("theNumber", null), Toast.LENGTH_SHORT).show()
    }
}