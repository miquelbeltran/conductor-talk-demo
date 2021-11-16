package work.beltran.conductortalkdemo.arch

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
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