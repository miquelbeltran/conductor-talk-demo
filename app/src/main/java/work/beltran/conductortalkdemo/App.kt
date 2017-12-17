package work.beltran.conductortalkdemo

import android.app.Application
import work.beltran.conductortalkdemo.dagger.DaggerMyComponent
import work.beltran.conductortalkdemo.dagger.MyComponent


class App: Application() {

    lateinit var component: MyComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerMyComponent.create()
    }

}

