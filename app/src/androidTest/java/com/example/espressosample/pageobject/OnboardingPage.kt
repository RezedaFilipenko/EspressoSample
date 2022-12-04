package com.example.espressosample.pageobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.isoron.uhabits.R

class OnboardingPage {
    val skipId = R.id.skip
    val doneId = R.id.done

    fun tapButton(id: Int){
        onView(
            withId(id)
        ).perform(click())
    }
}