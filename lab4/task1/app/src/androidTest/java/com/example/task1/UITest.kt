package com.example.task1

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith (AndroidJUnit4::class)
class UITest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkButton() {
        onView(withId(R.id.button1))
            .check(matches(withText(R.string.button)))
            .perform(click())
            .check(matches(withText(R.string.button_text)))
            .perform(click())
            .check(matches(withText(R.string.button_text)))

        activityRule.scenario.recreate()

        onView(withId(R.id.button1))
            .check(matches(withText(R.string.button)))
            .perform(click())
            .check(matches(withText(R.string.button_text)))
            .perform(click())
            .check(matches(withText(R.string.button_text)))
    }

    @Test
    fun checkEditText() {
        val testString = "Test input"
        onView(withId(R.id.editText))
            .check(matches(withText("")))
            .perform(typeText(testString))

        activityRule.scenario.recreate()

        onView(withId(R.id.editText))
            .check(matches(withText(testString)))
    }
}