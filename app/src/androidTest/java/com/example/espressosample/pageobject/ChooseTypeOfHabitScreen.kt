package com.example.espressosample.pageobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.isoron.uhabits.R

class ChooseTypeOfHabitScreen {
    val yesOrNoId = R.id.buttonYesNo
    val measurable = R.id.buttonMeasurable

    fun tapButton(id: Int){
        onView(
            withId(id)
        ).perform(click())
    }
}