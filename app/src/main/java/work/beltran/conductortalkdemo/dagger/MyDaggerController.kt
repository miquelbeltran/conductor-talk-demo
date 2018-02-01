package work.beltran.conductortalkdemo.dagger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.controller_dummy.view.*
import work.beltran.conductortalkdemo.App
import work.beltran.conductortalkdemo.R
import javax.inject.Inject

class MyDaggerController : Controller() {

    @Inject
    lateinit var value: String

    // Option 3: init the dependency when needed by lazy
//    val value: String by lazy {
//        (activity!!.application as App).component.string()
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_dummy, container, false)

        // Option 1: Always inject on onCreateView
        // On config changes (screen rotation) it will be injected each time
        // but it's not necessary, because value already was injected
        (activity!!.application as App).component.inject(this)

        // Option 2: Check if value was already injected
        // This allows the injected dependencies to survive config-changes
        // Don't do this for dependencies that use the host Activity context! as it will be destroyed
        if (!::value.isInitialized) {
            (activity!!.application as App).component.inject(this)
        }

        view.textView.text = value
        return view
    }

}