package xyz.mobcoder.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import org.joda.time.DateTime
import java.util.*

class DataReceiver : BroadcastReceiver() {



    override fun onReceive(context: Context?, intent: Intent?) {

        val d1 = DateTime(Prefs(context!!).getTime())
        val d2 = DateTime(intent!!.getLongExtra("Time",0L))
        Log.d("TIME", "Receive: ${d2.toLocalTime()}")
        val diffInMillis = (d2.millis - d1.millis)
        var data = intent.getStringExtra("KeyName")
        var data2 = intent.getByteArrayExtra("Array")
        Toast.makeText(context,"$diffInMillis миллисекунд",Toast.LENGTH_LONG).show()
    }
}