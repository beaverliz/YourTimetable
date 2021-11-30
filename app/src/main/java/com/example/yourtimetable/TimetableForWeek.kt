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
import java.io.Serializable
import android.content.SharedPreferences
import android.os.Parcel
import android.os.Parcelable
import kotlin.collections.ArrayList

class TimetableForWeek : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_for_week)
        val bottomnav = findViewById<BottomNavigationView>(R.id.nav)
        val weekFragment = Week()
        //makeCurrentFragment(weekFragment)

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

    /*

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
    *
     */

     fun onSelectDay(view: View){
        when(view?.id){
            R.id.Monday1 -> {
                val window = Intent(this@TimetableForWeek, TimetableForDay::class.java)
                window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                val b =  Bundle()
                val day= Day()
                val lessons = ArrayList<String>()
                lessons.add("educational practice")
                lessons.add("educational practice")
                lessons.add("educational practice")
                lessons.add("educational practice")
                day.setDay("Monday")
                day.setLesson(lessons)
                b.putSerializable("day", day)
                window.putExtras(b)
                startActivity(window)

            }
            R.id.Tuesday2 -> {
                val window = Intent(this@TimetableForWeek, TimetableForDay::class.java)
                window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                val b =  Bundle()
                val day= Day()
                val lessons = ArrayList<String>()
                lessons.add("web programming")
                lessons.add("information networks")
                lessons.add("decision analysis")
                day.setDay("Tuesday")
                day.setLesson(lessons)
                b.putSerializable("day", day)
                window.putExtras(b)
                startActivity(window)
            }
            R.id.Wednesday3 -> {
                val window = Intent(this@TimetableForWeek, TimetableForDay::class.java)
                window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                val b =  Bundle()
                val day= Day()
                val lessons = ArrayList<String>()
                lessons.add("web programming")
                lessons.add("information networks")
                lessons.add("decision analysis")
                day.setDay("Wednesday")
                day.setLesson(lessons)
                b.putSerializable("day", day)
                window.putExtras(b)
                startActivity(window)
            }
            R.id.Thursday4 -> {
                val window = Intent(this@TimetableForWeek, TimetableForDay::class.java)
                window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                val b = Bundle()
                val day= Day()
                val lessons = ArrayList<String>()
                lessons.add("mobile application development technologies")
                lessons.add("information systems design")
                lessons.add("educational practice")
                lessons.add("educational practice")
                day.setDay("Thursday")
                day.setLesson(lessons)
                b.putSerializable("day", day)
                window.putExtras(b)
                startActivity(window)
            }
            R.id.Friday5 -> {
                val window = Intent(this@TimetableForWeek, TimetableForDay::class.java)
                window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                val b = Bundle()
                val day= Day()
                val lessons = ArrayList<String>()
                lessons.add("web programming")
                lessons.add("information systems design")
                lessons.add("educational practice")
                lessons.add("educational practice")
                day.setDay("Friday")
                day.setLesson(lessons)
                b.putSerializable("day", day)
                window.putExtras(b)
                startActivity(window)
            }
            R.id.Saturday6 -> {
                val window = Intent(this@TimetableForWeek, TimetableForDay::class.java)
                window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                val b = Bundle()
                val day= Day()
                val lessons = ArrayList<String>()
                lessons.add("NoSQL")
                lessons.add("NoSQL")
                lessons.add("educational practice")
                day.setDay("Saturday")
                day.setLesson(lessons)
                b.putSerializable("day", day)
                window.putExtras(b)
                startActivity(window)
            }
        }
    }
class Day() : Serializable {
    lateinit var day : String
    lateinit var lessons: ArrayList<String>
    @JvmName("getDay1")
    fun getDay(): String {
        return day
    }
    @JvmName("setDay1")
    fun setDay(day: String){
        this.day=day
    }
    @JvmName("getLessons1")
    fun getLessons():ArrayList<String>{
        return lessons
    }
    fun setLesson(lessons:ArrayList<String>){
        this.lessons=lessons
    }



}

}



