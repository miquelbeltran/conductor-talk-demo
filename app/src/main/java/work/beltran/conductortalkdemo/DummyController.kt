package work.beltran.conductortalkdemo

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.controller_dummy.view.*

class DummyController : Controller() {

    // Warning! this will leak on onDestroyView
    lateinit var textView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_dummy, container, false)

        // Store a reference to the textView for later
        textView = view.textView

        return view
    }

    @Suppress("unused")
    fun changeText(text: String) {
        // Accessing views in a Controller with Kotlin

        // Option 1 (correct)
        // Access through the view property, which can be nullable
        view?.textView?.text = text

        // Problem: Multiple calls generate multiple findViewById in Java
        // See Bytecode -> Decompile
        view?.textView?.setTextColor(Color.BLUE)
        view?.textView?.textSize = 16.0f

        // Option 2 (may leak)
        // Access to the stored textView
        textView.text = text
    }

    @Suppress("RedundantOverride")
    override fun onDestroyView(view: View) {
        // With Butterknife on Java: call to unbind here
        // With Kotlin you cannot do
        // textView = null
        super.onDestroyView(view)
    }
}