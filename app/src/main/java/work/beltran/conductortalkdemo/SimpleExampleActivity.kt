package work.beltran.conductortalkdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import kotlinx.android.synthetic.main.activity_simple_example.*
import kotlinx.android.synthetic.main.controller_simple.view.*


class SimpleExampleActivity : AppCompatActivity() {

    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_example)

        // Create or reuse a Router if available on savedInstanceState
        router = Conductor.attachRouter(this, controller_container, savedInstanceState)

        // If the Router is empty
        if (!router.hasRootController()) {
            // add a root
            router.setRoot(RouterTransaction.with(SimpleController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}

class SimpleController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_simple, container, false)
        view.button.setOnClickListener {
            router.pushController(RouterTransaction.with(OtherSimpleController()))
        }
        return view
    }
}

class OtherSimpleController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_simple_other, container, false)
    }
}
