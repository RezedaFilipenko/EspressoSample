package com.example.espressosample.pageobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.isoron.uhabits.R

class MainScreen {
    val menuCreateHabitId = R.id.actionCreateHabit
    val actionFilterId = R.id.action_filter


    fun tapButton(id: Int){
        onView(
            withId(id)
        ).perform(click())
    }

    fun tapThreeDotButton(){
        onView(
            allOf(
                isDescendantOfA(withId(R.id.content)),
                hasSibling(withId(R.id.actionCreateHabit)),
                hasSibling(withId(R.id.action_filter))
            )
        ).perform(click())
    }

    fun checkHabit(text: String){
        onView(
            allOf(
                isDescendantOfA(withId(R.id.content)),
                withText(text)
            )
        ).check(matches(isDisplayed()))
    }

}