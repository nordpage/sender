package xyz.mobcoder.receiver

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.StatsLog.logEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.joda.time.DateTime
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bytes = ByteArray(20)
        var randInt: ByteArray? = byteArrayOf()
        Log.d("Main1", String(bytes))
        Log.d("Main2", String(randInt!!))

        sendText.setOnClickListener{
            randInt = Random(500000).nextBytes(500000)
            val time = System.currentTimeMillis()
            Prefs(this).saveTime(time)
            val d1 = DateTime(time)
            Log.d("TIME", "Send: ${d1.toLocalTime()}")
            val intent = Intent()
            intent.setClassName("xyz.mobcoder.child", "xyz.mobcoder.child.MyBroadcastReceiver")
            intent.action = "xyz.mobcoder.child.MyBroadcastReceiver"
            intent.putExtra("Time", time)
            intent.putExtra("KeyName",  randInt)
            sendBroadcast(intent)

//            val request = Request.Builder().url("http://ya.ru").build()
//            Observable.fromCallable{request}
//                .map { map -> OkHttpClient().newCall(map).execute() }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    Log.d("Receiver", "code $it")
//                    val intent = Intent()
//                    intent.setClassName("xyz.mobcoder.child", "xyz.mobcoder.child.MyBroadcastReceiver")
//                    intent.action = "xyz.mobcoder.child.MyBroadcastReceiver"
//
//                    intent.putExtra("KeyName", "${it.code()} : ${it.request().url()}")
//                    sendBroadcast(intent)
//                },{
//                    Log.e("Error", "Receiver error", it)
//                })



        }



    }



}