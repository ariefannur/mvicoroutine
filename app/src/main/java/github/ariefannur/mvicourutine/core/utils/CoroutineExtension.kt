package github.ariefannur.mvicourutine.core.utils

import android.util.Log
import kotlinx.coroutines.*
import java.io.IOException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun GlobalScope.launchSafely(context: CoroutineContext = EmptyCoroutineContext, errorFunc: (() -> Unit)? = null, func: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(context = context) {
        try {
            func.invoke(this)
        } catch (e : IOException){
            Log.d("AF", "err io ::  ${e.message}")
            delay(1000)
            GlobalScope.launchSafely(context,errorFunc,func)

        } catch (e: Exception) {
            Log.d("AF", "err ::  ${e.message}")
            try {
                errorFunc?.invoke()
            } catch (e: Exception) {
            }
            this.cancel()
        }
    }
}