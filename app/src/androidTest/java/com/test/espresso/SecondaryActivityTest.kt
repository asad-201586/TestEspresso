package com.test.espresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest{

    @get: Rule
    val activityRule:ActivityScenarioRule<SecondaryActivity> = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(SecondaryActivity::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.secondary_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_visibility_title_previousButton() {
        val activityScenario = ActivityScenario.launch(SecondaryActivity::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.text_secondary_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.button_previous))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun test_titleString() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.text_secondary_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Second Activity")))
    }

}