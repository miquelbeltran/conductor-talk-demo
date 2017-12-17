package work.beltran.conductortalkdemo.dagger

import dagger.Component
import dagger.Module
import dagger.Provides
import work.beltran.conductortalkdemo.MyDaggerController


@Component(modules = [(MyModule::class)])
interface MyComponent {
    fun inject(controller: MyDaggerController)
}

@Module
class MyModule {

    var count = 0

    @Provides
    fun provideString(): String {
        // Increment the counter each time is injected for demo purposes
        count++
        return "Hello Dagger! count: $count"
    }

}

