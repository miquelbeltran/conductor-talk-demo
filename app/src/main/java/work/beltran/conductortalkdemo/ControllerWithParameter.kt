package work.beltran.conductortalkdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.controller_dummy.view.*

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

        view.text.text = "My favorite city is $parameter"

        return view
    }
}

/**
 * Correct way of passing parameters to a Controller
 *
 * The primary constructor takes a Bundle object, passes it to the Controller constructor
 * We will not use that constructor directly, instead we will use the secondary
 *
 * The secondary constructor is a convenience constructor that creates a Bundle with our params
 */
class ControllerWithParameter(bundle: Bundle) : Controller(bundle) {

    constructor(parameter: String) : this(Bundle().apply {
        putString(EXTRA_PARAMETER, parameter)
    })

    // Access arguments like class properties
    private val parameter
        get() = args[EXTRA_PARAMETER]

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_dummy, container, false)

        view.text.text = "My favorite city is $parameter"

        return view
    }

    companion object {
        private const val EXTRA_PARAMETER = "EXTRA_PARAMETER"
    }
}