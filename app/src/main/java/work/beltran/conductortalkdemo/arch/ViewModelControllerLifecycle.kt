package work.beltran.conductortalkdemo.arch

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.archlifecycle.LifecycleController
import kotlinx.android.synthetic.main.controller_dummy.view.*
import work.beltran.conductortalkdemo.R

class ViewModelControllerLifecycle : LifecycleController() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_dummy, container, false)

        // This ViewModel is owned by the MainActivity.
        // Because of that, it will live as long as the Activity lives!
        // It will *not* be destroyed when the Controller gets destroyed
        val model = ViewModelProviders.of(activity as AppCompatActivity).get(MyViewModel::class.java)

        // The owner is now the Controller, not its Activity
        model.getTime().observe(this, Observer<String> {
            view.textView.text = "Time is $it"
        })

        return view
    }
}

