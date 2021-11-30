package com.example.yourtimetable

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.yourtimetable.fragments.Settingsfr
import com.example.yourtimetable.fragments.Week
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val bottomnav = findViewById<BottomNavigationView>(R.id.nav)
        val settingsfrFragment = Settingsfr()
        makeCurrentFragment(settingsfrFragment)

        bottomnav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.ic_baseline_arrow_left_24 -> {
                    val window = Intent(this@Settings, MainActivity::class.java)
                    window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(window)
                }
                R.id.ic_baseline_settings_24 -> {
                    val window = Intent(this@Settings, Settings::class.java)
                    window.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(window)
                }
            }
            true
        }
    }

    @SuppressWarnings("deprecation")
    fun changeLanguage(view: View){
        if (findViewById<TextView>(R.id.textView3).text.toString() == "You can change the language by clicking on the button below") {
            val locale = Locale("RU")
            Locale.setDefault(locale)
            val resources: Resources = this.resources
            val config: Configuration = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
            this.recreate()
        }
        else
        {
            val locale = Locale("EN")
            Locale.setDefault(locale)
            val resources: Resources = this.resources
            val config: Configuration = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
            this.recreate()
        }
    }
    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper2, fragment)
            commit()
        }
    }
    }