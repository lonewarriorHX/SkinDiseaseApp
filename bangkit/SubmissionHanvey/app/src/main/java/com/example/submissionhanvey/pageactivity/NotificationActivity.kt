package com.example.submissionhanvey.pageactivity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submissionhanvey.R
import com.example.submissionhanvey.pageactivity.reminder.Reminder
import kotlinx.android.synthetic.main.notification.*

class NotificationActivity : AppCompatActivity() {
    private lateinit var rem: Reminder
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification)

        rem = Reminder()
        sharedPref = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
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
            saveSwitchState(isChecked)
        }
    }

    private fun saveSwitchState(state: Boolean) {
        val prefEditor = sharedPref.edit()
        prefEditor.putBoolean(STATE, state)
        prefEditor.apply()
    }

    companion object {
        const val PREFERENCES = "Reminder Setting"
        private const val STATE = "state"
    }
}