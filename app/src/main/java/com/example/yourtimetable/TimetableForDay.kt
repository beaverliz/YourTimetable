package com.example.yourtimetable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class TimetableForDay : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var lesson1: TextView
    lateinit var lesson2: TextView
    lateinit var lesson3: TextView
    lateinit var lesson4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_for_day)
        val bottomnav = findViewById<BottomNavigationView>(R.id.nav)

        textView = findViewById(R.id.Monday)
        lesson1= findViewById(R.id.lesson1)
        lesson2= findViewById(R.id.lesson2)
        lesson3= findViewById(R.id.lesson3)
        lesson4= findViewById(R.id.lesson4)
        var day = intent.getSerializableExtra("day") as TimetableForWeek.Day
        textView.setText(day.getDay())
        when(day.getLessons().size){
            1 -> {
                lesson1.setText(day.getLessons().get(0))
            }
            2 -> {
                lesson1.setText(day.getLessons().get(0))
                lesson2.setText(day.getLessons().get(1))
            }
            3 -> {
                lesson1.setText(day.getLessons().get(0))
                lesson2.setText(day.getLessons().get(1))
                lesson3.setText(day.getLessons().get(2))
            }
            4 -> {
                lesson1.setText(day.getLessons().get(0))
                lesson2.setText(day.getLessons().get(1))
                lesson3.setText(day.getLessons().get(2))
                lesson4.setText(day.getLessons().get(3))
            }
        }





        bottomnav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.ic_baseline_arrow_left_24 -> {
                    val window = Intent(this@TimetableForDay, TimetableForWeek::class.java)
                    window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(window)
                }
                R.id.ic_baseline_settings_24 -> {
                    val window = Intent(this@TimetableForDay, Settings::class.java)
                    window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(window)
                }
            }
            true
        }
    }





}