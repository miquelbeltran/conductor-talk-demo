package work.beltran.conductortalkdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.controller_demo.view.*

class DemoController : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_demo, container, false)
        initList(view.list)
        return view
    }

    private fun initList(list: ListView) = with(list) {
        list.adapter = ArrayAdapter<String>(list.context, android.R.layout.simple_list_item_1, ITEMS)
        list.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> horizontalTransition()
                1 -> fadeTransition()
                2 -> constructorParameter()
                3 -> constructorParameterWrong()
                4 -> customTransition()
            }
        }
    }

    private fun customTransition() {
        router.pushController(RouterTransaction.with(DummyController())
                .pushChangeHandler(CustomChangeHandler()))
    }

    private fun horizontalTransition() {
        router.pushController(RouterTransaction.with(DummyController())
                .popChangeHandler(HorizontalChangeHandler())
                .pushChangeHandler(HorizontalChangeHandler()))
    }

    private fun fadeTransition() {
        router.pushController(RouterTransaction.with(DummyController())
                .popChangeHandler(FadeChangeHandler())
                .pushChangeHandler(FadeChangeHandler()))
    }

    private fun constructorParameter() {
        router.pushController(RouterTransaction.with(ControllerWithParameter("Tokyo")))
    }

    private fun constructorParameterWrong() {
        router.pushController(RouterTransaction.with(ControllerWithParameterWrong("Tokyo")))
    }

    companion object {
        val ITEMS = arrayOf(
                "Horizontal Transition",
                "Fade Transition",
                "Constructor Parameter Good",
                "Constructor Parameter Bad",
                "Custom Transition"
        )
    }
}

