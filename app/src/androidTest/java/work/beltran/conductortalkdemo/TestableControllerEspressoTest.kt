package work.beltran.conductortalkdemo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.bluelinelabs.conductor.RouterTransaction
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import work.beltran.conductortalkdemo.test.TestRouterActivity
import work.beltran.conductortalkdemo.test.TestableController

@RunWith(AndroidJUnit4::class)
class TestableControllerEspressoTest {

    @get:Rule
    val activity = ActivityTestRule<TestRouterActivity>(TestRouterActivity::class.java)

    val controller = TestableController()

    @Before
    fun setUp() {
        activity.runOnUiThread {
            activity.activity.router.setRoot(RouterTransaction.with(controller))
        }
    }

    @Test
    fun test_a_click_action() {
        // Call to Controller methods directly
        activity.runOnUiThread {
            controller.onClickDoAction()
        }

        // Check views
        onView(withId(R.id.textView)).check(matches(withText("Test is running")))
    }

}