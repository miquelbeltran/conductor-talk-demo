package work.beltran.conductortalkdemo.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import kotlinx.android.synthetic.main.activity_main.*
import work.beltran.conductortalkdemo.R

class TestRouterActivity: AppCompatActivity() {

    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router = Conductor.attachRouter(this, controller_container, savedInstanceState)
    }
}