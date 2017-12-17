package work.beltran.conductortalkdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.controller_dummy.view.*
import javax.inject.Inject

class MyDaggerController : Controller() {

    @Inject
    lateinit var value: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_dummy, container, false)

        // Option 1: Always inject on onCreateView
        (activity!!.application as App).component.inject(this)


        view.text.text = value

        return view
    }

}