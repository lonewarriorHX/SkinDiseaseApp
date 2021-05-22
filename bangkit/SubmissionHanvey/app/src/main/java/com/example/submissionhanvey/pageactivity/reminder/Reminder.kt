package com.example.submissionhanvey.pageactivity.reminder

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.submissionhanvey.MainActivity
import com.example.submissionhanvey.R
import java.util.*

class Reminder : BroadcastReceiver() {

    companion object {
        const val TYPE_REPEAT = "Daily Reminder"
        const val TYPE_MSG = "message"
        const val TYPE_EXTRA = "type"

        private const val ID_REPEAT = 101
    }

    override fun onReceive(p0: Context, p1: Intent) {
        val message = p1.getStringExtra(TYPE_MSG)

        if (message != null) {
            showReminderNotification(p0, message)
        }
    }

    private fun showReminderNotification(context: Context, message: String) {
        val chId = "Channel 1"
        val chName = "Daily Reminder Channel"

        val mIntent = Intent(context, MainActivity::class.java)
        mIntent.flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
        val pIntent = PendingIntent.getActivity(context, 0, mIntent, 0)

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = NotificationCompat.Builder(context, chId)
            .setSmallIcon(R.drawable.ic_baseline_alarm)
            .setContentIntent(pIntent)
            .setContentTitle(context.getString(R.string.app_name))
            .setContentText(message)
            .setColor(ContextCompat.getColor(context, android.R.color.transparent))
            .setAutoCancel(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val ch = NotificationChannel(chId, chName, NotificationManager.IMPORTANCE_DEFAULT)
            ch.enableVibration(false)
            builder.setChannelId(chId)
            notificationManager.createNotificationChannel(ch)
        }

        val notification = builder.build()
        notificationManager.notify(ID_REPEAT, notification)
    }

    fun setReminder(context: Context, type: String, message: String) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val mIntent = Intent(context, Reminder::class.java)
        mIntent.putExtra(TYPE_MSG, message)
        mIntent.putExtra(TYPE_EXTRA, type)

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 9)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)

        val pIntent =
            PendingIntent.getBroadcast(context, ID_REPEAT, mIntent, 0)
        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pIntent
        )
        Toast.makeText(context, R.string.reminder_active, Toast.LENGTH_SHORT).show()
    }

    fun deactivateReminder(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val mIntent = Intent(context, Reminder::class.java)
        val requestCode = ID_REPEAT
        val pIntent = PendingIntent.getBroadcast(context, requestCode, mIntent, 0)
        pIntent.cancel()
        alarmManager.cancel(pIntent)
        Toast.makeText(context, R.string.reminder_inactive, Toast.LENGTH_SHORT).show()
    }
    
}