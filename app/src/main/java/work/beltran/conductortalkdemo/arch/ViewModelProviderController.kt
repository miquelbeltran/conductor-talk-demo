package work.beltran.conductortalkdemo.arch

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.lifecycle.ViewModelStore
import com.bluelinelabs.conductor.archlifecycle.LifecycleController

abstract class ViewModelProviderController : LifecycleController() {

    internal val viewModelProvider : ViewModelProvider by lazy {
        ViewModelProvider(ViewModelStore(), ViewModelProviders.DefaultFactory(activity!!.application))
    }
}