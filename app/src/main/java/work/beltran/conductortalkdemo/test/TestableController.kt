package work.beltran.conductortalkdemo.test

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.controller_dummy.view.*
import work.beltran.conductortalkdemo.R

class TestableController: Controller() {

    private var aValue = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_dummy, container, false)
    }

    @SuppressLint("SetTextI18n")
    fun onClickDoAction() {
        // view is null during Unit Tests, nothing happens
        view?.textView?.text = "Test is running"

        // The value gets updated
        aValue = true
    }

    fun getActionResult(): Boolean {
        return aValue
    }

}