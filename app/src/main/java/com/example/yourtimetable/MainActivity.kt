package com.example.yourtimetable

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.yourtimetable.fragments.First
import com.example.yourtimetable.fragments.Settingsfr
import com.example.yourtimetable.fragments.Week
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = First()
        makeCurrentFragment(firstFragment)

    }

    fun toTimetableForWeek(view: View) {
        val window = Intent(this@MainActivity, TimetableForWeek::class.java)
        window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(window)
    }
    fun toSettings (view: View) {
        val window = Intent(this@MainActivity, Settings::class.java)
        window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(window)
    }
    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper1, fragment)
            commit()
        }
    }
}