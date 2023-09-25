package com.example.mad_pr8_036
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun set_alarm(militime:Long,action:String)
    {
        val intent_alarm=Intent(applicationContext,AlarmBroadcastReciever::class.java)
        intent_alarm.putExtra(AlarmBroadcastReciever.ALARMKEY)
        val pendingintent=PendingIntent.getBroadcast(applicationContext,3103,intent_alarm,PendingIntent)
        val manager=getSystemService(ALARM_SERVICE) as AlarmManager
        if(action==AlarmBroadcastReciever.alarm_stop)
        {
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingintent)
        }

    }
}