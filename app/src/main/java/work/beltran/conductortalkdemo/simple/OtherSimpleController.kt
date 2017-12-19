package work.beltran.conductortalkdemo.simple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import work.beltran.conductortalkdemo.R

class OtherSimpleController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_simple_other, container, false)
    }
}