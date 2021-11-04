package com.test.espresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest : TestCase(){

//    @Test
//    fun test_navSecondaryActivity(){
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//
//        onView(withId(R.id.button_next)).perform(ViewActions.click())
//        onView(withId(R.id.secondary_main)).check(matches(isDisplayed()))
//    }

    @Test
    fun test_backPress_toMainActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next)).perform(ViewActions.click())
        onView(withId(R.id.secondary_main)).check(matches(isDisplayed()))
        onView(withId(R.id.button_previous)).perform(ViewActions.click()) // method 1
        //pressBack() // method 2
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    /*@Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title_nextButton() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.button_next)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun test_titleString() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.text_title)).check(matches(withText("First Activity")))
    }*/
}