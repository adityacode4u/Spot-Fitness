package com.example.spotfitness

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.profile_dialog.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_menuBar.setOnClickListener {
            showDialog()

        }
        val homeFragment = HomeFragment()
        createFragment(homeFragment)
        //for the bottom navigation bar
        bottomNavigationView.background = null
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_icon -> {
                    Toast.makeText(this, "home selected", Toast.LENGTH_SHORT).show()
                }
                R.id.nutrition_icon -> {
                    Toast.makeText(this, "nutrition_icon selected", Toast.LENGTH_SHORT).show()
                }
                R.id.exercises_icon -> {
                    Toast.makeText(this, "exercises_icon selected", Toast.LENGTH_SHORT).show()
                }
                R.id.history_icon -> {
                    Toast.makeText(this, "history_icon selected", Toast.LENGTH_SHORT).show()
                }
                R.id.bmi_icon -> {
                    Toast.makeText(this, "bmi_icon selected", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.profile_dialog)
        val profileClose = dialog.findViewById<ImageView>(R.id.profileClose)
        val logout = dialog.findViewById<ImageView>(R.id.logout_btn)
        val editBtnProfile = dialog.findViewById<Button>(R.id.edit_btnProfile)
        val submitBtnProfile = dialog.findViewById<Button>(R.id.submit_btnProfile)
        val lvSavedProfile = dialog.findViewById<LinearLayout>(R.id.lv_savedProfileData)
        val lvEditProfile = dialog.findViewById<LinearLayout>(R.id.lv_editProfileData)
        profileClose.setOnClickListener {
            dialog.dismiss()
        }

        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //animation
        //dialog.window!!.getAttributes().windowAnimations = R.style.CustomDialogAnimation;
        dialog.show()
    }

    private fun createFragment(item: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_Fragment, item)
            commit()
        }
    }
}