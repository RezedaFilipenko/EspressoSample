package com.example.espressosample.pageobject

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.isoron.uhabits.R

class CreateHabitMeasurableScreen {
    val nameMeasurableScreenId = R.id.nameInput
    val questionMeasurableScreenID = R.id.questionInput
    val unitMeasurableScreenId = R.id.unitInput
    val targetMeasurableScreenId = R.id.targetInput
    val frequencyMeasurableScreenId = R.id.targetInput
    val targetTypeMeasurableScreenId = R.id.targetTypePicker
    val reminderMeasurableScreenId = R.id.reminderTimePicker
    val notesMeasurableScreenId = R.id.notesInput
    val colorMeasurableScreenId = R.id.colorButton
    val saveMeasurableScreenId = R.id.buttonSave
    val textAtLeast = "At least"
    val textAtMost = "At most"
    val testFrequencyEveryDay = "Every day"
    val testFrequencyEveryWeek = "Every week"
    val testFrequencyEveryMonth = "Every month"

    fun tapButton(id: Int){
        onView(
            withId(id)
        ).perform(click())
    }
    fun enterText(id: Int, text: String){
        onView(
            withId(id)
        ).perform(replaceText(text))
    }
    fun tapPicker(text: String){
        onView(
            allOf(
                withParent(withId(R.id.select_dialog_listview)),
                withText(text)
            )
        ).perform(click())
    }
    fun checkScreenIsOpen(){
        onView(
            allOf(
                withParent(withId(R.id.toolbar)),
                withText("Create habit")
            )
        ).check(ViewAssertions.matches(isDisplayed()))
    }

}