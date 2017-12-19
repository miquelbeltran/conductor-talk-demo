package work.beltran.conductortalkdemo.arch

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.lifecycle.ViewModelStore
import com.bluelinelabs.conductor.archlifecycle.LifecycleController

abstract class BaseViewModelController : LifecycleController() {

    // This Controller instance has its own ViewModelStore
    private val viewModelStore = ViewModelStore()

    // A custom Factory can be provided
    fun viewModelProvider(factory: ViewModelProvider.NewInstanceFactory = defaultFactory()): ViewModelProvider {
        return ViewModelProvider(viewModelStore, factory)
    }

    private fun defaultFactory() = ViewModelProviders.DefaultFactory(activity!!.application)
}