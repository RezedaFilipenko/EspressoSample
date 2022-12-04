package com.example.espressosample.pageobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.isoron.uhabits.R


class CreateHabitYeaOrNoScreen {
//не будет тестироваться поле reminder и time picker, который открывается на нажатию на это поле ,
// тк этот элемент невозможно автоматизировать средствами espresso

    val nameId = R.id.nameInput
    val questionId = R.id.questionInput
    val frequencyId = R.id.boolean_frequency_picker
    val reminderId = R.id.reminderTimePicker
    val notesId = R.id.notesInput
    val colorId = R.id.colorButton
    val saveCreateHabitYeaOrNoId = R.id.buttonSave

    fun enterText(id: Int, text: String){
        onView(
            withId(id)
        ).perform(replaceText(text))
    }

    fun tapButton(id: Int){
        onView(
            withId(id)
        ).perform(click())
    }

    fun checkScreenIsOpen(){
        onView(
            allOf(
                withParent(withId(R.id.toolbar)),
                withText("Create habit")
            )
        ).check(matches(isDisplayed()))
    }


}