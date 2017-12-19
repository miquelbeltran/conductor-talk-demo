package work.beltran.conductortalkdemo.simple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import kotlinx.android.synthetic.main.controller_simple.view.*
import work.beltran.conductortalkdemo.R

class SimpleController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_simple, container, false)
        view.button.setOnClickListener {
            router.pushController(RouterTransaction.with(OtherSimpleController()))
        }
        return view
    }
}