package github.ariefannur.mvicourutine.core.utils

import kotlinx.coroutines.*
import java.io.IOException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun GlobalScope.launchSafely(context: CoroutineContext = EmptyCoroutineContext, errorFunc: ((error:Throwable?) -> Unit)? = null, func: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(context = context) {
        try {
            func.invoke(this)
        } catch (e : IOException){
            delay(1000)
            GlobalScope.launchSafely(context,errorFunc,func)

        } catch (e: Exception) {
            try {
                errorFunc?.invoke(Throwable(e.message))
            } catch (e: Exception) {
            }
            this.cancel()
        }
    }
}