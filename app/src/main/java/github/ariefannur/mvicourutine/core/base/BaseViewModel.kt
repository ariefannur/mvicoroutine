package github.ariefannur.mvicourutine.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel(){

    var job: Job = Job()
    var uiDispatcher: CoroutineDispatcher = Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}