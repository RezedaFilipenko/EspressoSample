package com.example.espressosample.pageobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.isoron.uhabits.R

class DialogFrequencyScreen {
    val everyDayButtonId = R.id.everyDayRadioButton
    val everyXDaysButtonId = R.id.everyXDaysRadioButton
    val xTimesPerWeekButtonId = R.id.xTimesPerWeekRadioButton
    val xTimesPerMonthButtonId = R.id.xTimesPerMonthRadioButton
    val xTimesPerYDaysButtonId = R.id.xTimesPerYDaysRadioButton
    val everyXDaysTextFieldId = R.id.everyXDaysTextView
    val xTimesPerWeekTextFieldId = R.id.xTimesPerWeekTextView
    val xTimesPerMonthTextFieldId = R.id.xTimesPerMonthTextView
    val xTimesPerYDaysXText1FieldId = R.id.xTimesPerYDaysXTextView
    val xTimesPerYDaysYText2FieldId= R.id.xTimesPerYDaysYTextView

    fun tapRadioButton(id: Int){
        onView(
            withId(id)
        ).perform(click())
    }

    fun enterAmountOfDays(id: Int, text: String){
        onView(
            withId(id)
        ).perform(replaceText(text))
    }

    fun tapSave(){
        onView(
            allOf(
                withText("Save"),
                isDescendantOfA(withId(R.id.buttonPanel))
            )
        ).perform(click())
    }



}