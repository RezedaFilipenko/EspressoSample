package com.example.espressosample.pageobject

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.isoron.uhabits.R

class DetailedHabitAfterCreationScreen {

    val editId = R.id.action_edit_habit
    val questionTextId = R.id.questionLabel

    val textExport = "Export"
    val textDelete = "Delete"
    val textDialogNO = "NO"
    val textDialogYES = "YES"


    fun tapThreeDotButton(){
        onView(
            allOf(
                isDescendantOfA(withId(R.id.toolbar)),
                hasSibling(withId(R.id.action_edit_habit)),
            )
        ).perform(click())
    }

    fun tapButton(id: Int){
        onView(
            withId(id)
        ).perform(click())

    }

    fun checkQuestionIsShown(id: Int, text: String){
        onView(
            allOf(
                withId(id),
                withText(text)
            )
        ).check(matches(isDisplayed()))
    }

    fun tapBackButton(text: String){//в переменной text нужно передать имя привычки после редактирования
        onView(
            allOf(
                isDescendantOfA(withId(R.id.toolbar)),
                hasSibling(withText(text)),
                hasSibling(withChild(withId(R.id.action_edit_habit)))
            )
        ).perform(click())
    }

    fun tapRightMenuButton(text: String){
        onView(
            withText(text)
        ).perform(click())
    }

    fun tapButtonInDialog(text: String){
        onView(
            allOf(
                isDescendantOfA(withId(R.id.buttonPanel)),
                withText(text)
            )
        ).perform(click())
    }
}