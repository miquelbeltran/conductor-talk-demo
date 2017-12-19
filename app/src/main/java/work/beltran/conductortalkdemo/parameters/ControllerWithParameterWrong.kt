package work.beltran.conductortalkdemo.parameters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.controller_dummy.view.*
import work.beltran.conductortalkdemo.R

/**
 * Wrong way of passing parameters to a Controller
 *
 * It will work until the Controller is destroyed and recreated, then the parameter will be lost
 *
 * Enable "Don't keep Activities" to see the effect
 */
class ControllerWithParameterWrong(val parameter: String) : Controller() {

    // Mandatory empty constructor.
    // What should be "parameter", then?
    constructor() : this("???")

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_dummy, container, false)

        view.textView.text = "My favorite city is $parameter"

        return view
    }
}