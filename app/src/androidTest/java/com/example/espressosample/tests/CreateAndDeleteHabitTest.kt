package com.example.espressosample.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.espressosample.pageobject.*
import org.isoron.page_object.*
import org.isoron.uhabits.activities.habits.list.ListHabitsActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)

class CreateAndDeleteHabitTest {
    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(ListHabitsActivity::class.java)

    val onboardingPage = OnboardingPage()
    val mainScreen = MainScreen()
    val chooseTypeOfHabitScreen = ChooseTypeOfHabitScreen()
    val createHabitYeaOrNoScreen = CreateHabitYeaOrNoScreen()
    val detailedHabitAfterCreationScreen = DetailedHabitAfterCreationScreen()

    val textName = "walk"
    val textQuestion = "did you walk"
    val textNotes = "after work 1 hour"

    @Test
    fun createAndDeleteHabit() {

        onboardingPage.tapButton(onboardingPage.skipId)
        mainScreen.tapButton(mainScreen.menuCreateHabitId)
        chooseTypeOfHabitScreen.tapButton(chooseTypeOfHabitScreen.yesOrNoId)
        with(createHabitYeaOrNoScreen){
            enterText(nameId, textName)
            enterText(questionId, textQuestion)
            enterText(notesId,textNotes)
            tapButton(saveCreateHabitYeaOrNoId)
        }
        with(mainScreen){
            checkHabit(textName)
            tapHabit(textName)
        }
        with(detailedHabitAfterCreationScreen){
            tapThreeDotButton()
            tapRightMenuButton(textDelete)
            tapButtonInDialog(textDialogYES)
        }
        mainScreen.checkHabitIsNotShown(textName)
    }
}