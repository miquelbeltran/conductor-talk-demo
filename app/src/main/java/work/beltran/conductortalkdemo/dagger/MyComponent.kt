package work.beltran.conductortalkdemo.dagger

import dagger.Component


@Component(modules = [(MyModule::class)])
interface MyComponent {
    // to inject in onCreateView
    fun inject(controller: MyDaggerController)

    // to use with lazy init
    fun string(): String
}

