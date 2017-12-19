package work.beltran.conductortalkdemo.dagger

import dagger.Module
import dagger.Provides

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