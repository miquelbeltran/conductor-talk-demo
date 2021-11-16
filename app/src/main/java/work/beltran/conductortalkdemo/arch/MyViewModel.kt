package work.beltran.conductortalkdemo.arch

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MyViewModel : ViewModel() {

    private val liveData = MutableLiveData<String>()

    init {
        liveData.value = Date().toString()
    }

    fun getTime(): LiveData<String> = liveData

}