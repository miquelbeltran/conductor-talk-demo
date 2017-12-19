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
import work.beltran.conductortalkdemo.arch.ViewModelController
import work.beltran.conductortalkdemo.arch.ViewModelControllerLifecycle
import work.beltran.conductortalkdemo.arch.ViewModelOwnerController
import work.beltran.conductortalkdemo.dagger.MyDaggerController
import work.beltran.conductortalkdemo.parameters.ControllerWithParameter
import work.beltran.conductortalkdemo.parameters.ControllerWithParameterWrong

class MainController : Controller() {
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
                5 -> daggerController()
                6 -> viewModelController()
                7 -> viewModelControllerLifecycle()
                8 -> viewModelOwnerController()
            }
        }
    }

    private fun viewModelOwnerController() {
        router.pushController(RouterTransaction.with(ViewModelOwnerController()))
    }

    private fun viewModelController() {
        router.pushController(RouterTransaction.with(ViewModelController()))
    }

    private fun viewModelControllerLifecycle() {
        router.pushController(RouterTransaction.with(ViewModelControllerLifecycle()))
    }

    private fun daggerController() {
        router.pushController(RouterTransaction.with(MyDaggerController()))
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
                "Custom Transition",
                "Dagger Controller",
                "ViewModel Controller",
                "ViewModel Controller with Lifecycle",
                "ViewModel Controller with Own Store"
        )
    }
}

