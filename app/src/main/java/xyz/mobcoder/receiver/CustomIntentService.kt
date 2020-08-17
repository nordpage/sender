package xyz.mobcoder.receiver

import android.app.IntentService
import android.content.Intent
import android.os.Bundle

class CustomIntentService: IntentService {
    constructor(name: String?) : super(name)


    companion object {
        const val STATUS_RUNNING = 0
        const val STATUS_FINISHED = 1
        const val STATUS_ERROR = 2
    }
    override fun onHandleIntent(intent: Intent?) {
        val receiver: AppResultReceiver = intent!!.getParcelableExtra("receiver")
        val b = Bundle()
        receiver.send(STATUS_FINISHED,b)
    }
}