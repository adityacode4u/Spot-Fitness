package com.example.spotfitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val homeFragment = HomeFragment()
        createFragment(homeFragment)
        //for the bottom navigation bar
        bottomNavigationView.background = null
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.home_icon ->{
                    Toast.makeText(this, "home selected", Toast.LENGTH_SHORT).show()
                }
                R.id.nutrition_icon ->{
                    Toast.makeText(this, "nutrition_icon selected", Toast.LENGTH_SHORT).show()
                }
                R.id.exercises_icon ->{
                    Toast.makeText(this, "exercises_icon selected", Toast.LENGTH_SHORT).show()
                }
                R.id.history_icon ->{
                    Toast.makeText(this, "history_icon selected", Toast.LENGTH_SHORT).show()
                }
                R.id.bmi_icon ->{
                    Toast.makeText(this, "bmi_icon selected", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }



    private fun createFragment(item: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_Fragment, item)
            commit()
        }
    }
}