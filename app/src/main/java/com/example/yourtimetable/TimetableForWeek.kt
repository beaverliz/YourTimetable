package com.example.yourtimetable

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.yourtimetable.fragments.Week
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class TimetableForWeek : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_for_week)
        val bottomnav = findViewById<BottomNavigationView>(R.id.nav)
        val weekFragment = Week()
        makeCurrentFragment(weekFragment)

        bottomnav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.ic_baseline_arrow_left_24 -> {
                    val window = Intent(this@TimetableForWeek, MainActivity::class.java)
                    window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(window)
                }
                R.id.ic_baseline_settings_24 -> {
                    val window = Intent(this@TimetableForWeek, Settings::class.java)
                    window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(window)
                }
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }



}
