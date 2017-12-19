package work.beltran.conductortalkdemo

import junit.framework.Assert.assertTrue
import org.junit.Test
import work.beltran.conductortalkdemo.test.TestableController

class TestableControllerTest {

    @Test
    fun `let's test a Controller`() {

        // Create an instance of the Controller
        val controller = TestableController()

        // Run methods on it
        controller.onClickDoAction()

        // Assert outputs (not views)
        assertTrue(controller.getActionResult())
    }
}