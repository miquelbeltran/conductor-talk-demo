package work.beltran.conductortalkdemo.arch

import android.annotation.SuppressLint
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.controller_dummy.view.*
import work.beltran.conductortalkdemo.R

class ViewModelActivityController : Controller() {

    lateinit var model: MyViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_dummy, container, false)

        // This ViewModel is owned by the MainActivity.
        // Because of that, it will live as long as the Activity lives!
        // It will *not* be cleared when the Controller gets destroyed
        model = ViewModelProviders.of(activity as AppCompatActivity).get(MyViewModel::class.java)
        model.getTime().observe(activity as AppCompatActivity, {
            view.textView.text = "Time is $it"
        })

        return view
    }
}

