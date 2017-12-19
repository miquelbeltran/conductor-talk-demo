package work.beltran.conductortalkdemo.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import kotlinx.android.synthetic.main.activity_main.*
import work.beltran.conductortalkdemo.R


class SimpleExampleActivity : AppCompatActivity() {

    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

