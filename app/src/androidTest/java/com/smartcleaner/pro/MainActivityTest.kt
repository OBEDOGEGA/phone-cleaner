package com.smartcleaner.pro

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun `main activity launches and shows bottom navigation`() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun `main activity displays nav host fragment`() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withId(R.id.nav_host_fragment)).check(matches(isDisplayed()))
        }
    }
}