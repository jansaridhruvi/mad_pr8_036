package com.example.mad_pr8_036

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReciever : BroadcastReceiver() {
companion object{
    val ALARMKEY="alarm"
    val alarm_stop="stop"
    val alarm_start="start"
}
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
      val data=intent.getStringExtra(ALARMKEY)
        val intent_service=Intent(context,AlarmService::class.java)
        if(data== alarm_start)
        {
            context.startService(intent_service)
        }
        else if (data== alarm_stop)
        {
            context.stopService(intent_service)
        }
    }
}