package work.beltran.conductortalkdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller

class DummyController : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_dummy, container, false)
    }
}