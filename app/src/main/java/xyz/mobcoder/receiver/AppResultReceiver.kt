package xyz.mobcoder.receiver

import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver


class AppResultReceiver : ResultReceiver {
    constructor(handler: Handler?) : super(handler)


    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
        super.onReceiveResult(resultCode, resultData)

    }
}