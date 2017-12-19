package work.beltran.conductortalkdemo.arch

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.controller_dummy.view.*
import work.beltran.conductortalkdemo.R

class ViewModelOwnerController : ViewModelProviderController() {

    lateinit var model: MyViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_dummy, container, false)

        model = viewModelProvider.get(MyViewModel::class.java)
        model.getTime().observe(this, Observer<String> {
            view.textView.text = "Time is $it"
        })

        return view
    }
}

