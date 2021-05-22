package com.example.bangkitsubmissionhanvey.setting

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bangkitsubmissionhanvey.R
import com.example.bangkitsubmissionhanvey.data.Reminder
import kotlinx.android.synthetic.main.activity_setting.*

/*class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
    }
}*/
class Setting : AppCompatActivity() {

    private lateinit var rem: Reminder
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        rem = Reminder()
        sharedPref = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        reminder.isChecked = sharedPref.getBoolean(STATE, false)

        reminder.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> rem.setReminder(
                    this,
                    Reminder.TYPE_REPEAT,
                    getString(R.string.reminder_notification)
                )
                false -> rem.deactivateReminder(this)
            }
            saveChanges(isChecked)
        }
    }

    private fun saveChanges(state: Boolean) {
        val prefEditor = sharedPref.edit()
        prefEditor.putBoolean(STATE, state)
        prefEditor.apply()
    }

    companion object {
        const val PREFS = "Reminder Setting"
        private const val STATE = "state"
    }
}