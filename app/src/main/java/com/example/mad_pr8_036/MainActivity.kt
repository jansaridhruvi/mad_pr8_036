package com.example.mad_pr8_036
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextClock
import android.widget.Toast
import com.example.mad_pr8_036.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textClock: TextClock = findViewById<TextClock>(R.id.Textclock)
        var btn: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btn1)
        btn.setOnClickListener()
        {

        }
        textClock.setOnClickListener()
        {
            val d = textClock.text
            Toast.makeText(this, d, Toast.LENGTH_LONG).show()
        }
        fun set_alarm(militime: Long, action: String) {
            val intent_alarm = Intent(applicationContext, AlarmBroadcastReciever::class.java)
            intent_alarm.putExtra(AlarmBroadcastReciever.ALARMKEY, action)
            val pendingintent = PendingIntent.getBroadcast(applicationContext, 3103, intent_alarm,pendingintent)
            val manager = getSystemService(ALARM_SERVICE) as AlarmManager
            if (action == AlarmBroadcastReciever.alarm_stop) {
                manager.setExact(AlarmManager.RTC_WAKEUP, militime, pendingintent)
            }
        }
    }
}