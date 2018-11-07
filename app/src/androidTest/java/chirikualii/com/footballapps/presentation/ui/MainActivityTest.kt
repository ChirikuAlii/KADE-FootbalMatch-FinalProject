package chirikualii.com.footballapps.presentation.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import chirikualii.com.footballapps.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test

@LargeTest

class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {

        /**skenario
         * menampilkan main activity
         * click teams
         * click favorite
         * click teams
         * click detail team
         * is position 1 is diplayed
         */
        delay()
        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.item_team), withContentDescription("Teams"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navbar),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())
        delay()
        val bottomNavigationItemView2 = onView(
            allOf(
                withId(R.id.item_favorite), withContentDescription("Favorite"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navbar),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(click())
        delay()
        val bottomNavigationItemView3 = onView(
            allOf(
                withId(R.id.item_team), withContentDescription("Teams"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navbar),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView3.perform(click())
        delay()
        val constraintLayout = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.recyclerViewMatch),
                        childAtPosition(
                            withClassName(`is`("android.widget.FrameLayout")),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        constraintLayout.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

    private fun delay() {
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
