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

class AddHabitsYesOrNoTest {
    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(ListHabitsActivity::class.java)

    val onboardingPage = OnboardingPage()
    val mainScreen = MainScreen()
    val chooseTypeOfHabitScreen = ChooseTypeOfHabitScreen()
    val createHabitYeaOrNoScreen = CreateHabitYeaOrNoScreen()
    val dialogFrequencyScreen = DialogFrequencyScreen()

    val textName = "Gym"
    val textNameZero = ""
    val textQuestion = "Did you go to the gym?"
    val textQuestionFor2Test = "Did you do your English lesson?"
    val textNotes = "run, jump, sit-ups"
    val textNotesFor2Test = "one lesson in Duolingo"
    val textXTimes = "15"
    val textInYDays = "31"
    val textTimesPerWeek = "5"



    @Test
    fun createYesOrNoHabit(){
        onboardingPage.tapButton(onboardingPage.skipId)
        mainScreen.tapButton(mainScreen.menuCreateHabitId)
        chooseTypeOfHabitScreen.tapButton(chooseTypeOfHabitScreen.yesOrNoId)
        with(createHabitYeaOrNoScreen){
            enterText(nameId, textName)
            enterText(questionId, textQuestion )
            tapButton(frequencyId)
        }
        with(dialogFrequencyScreen){
            tapRadioButton(xTimesPerYDaysButtonId)
            enterAmountOfDays(xTimesPerYDaysXText1FieldId, textXTimes)
            enterAmountOfDays(xTimesPerYDaysYText2FieldId, textInYDays )
            tapSave()
        }
        with(createHabitYeaOrNoScreen){
            enterText(notesId,textNotes )
            tapButton(saveCreateHabitYeaOrNoId)
        }
        mainScreen.checkHabit(textName)
    }

    @Test
    fun enterIncorrectValues(){
        onboardingPage.tapButton(onboardingPage.skipId)
        mainScreen.tapButton(mainScreen.menuCreateHabitId)
        chooseTypeOfHabitScreen.tapButton(chooseTypeOfHabitScreen.yesOrNoId)
        with(createHabitYeaOrNoScreen){
            enterText(nameId, textNameZero)
            enterText(questionId, textQuestionFor2Test )
            tapButton(frequencyId)
        }
        with(dialogFrequencyScreen){
            tapRadioButton(xTimesPerWeekButtonId)
            enterAmountOfDays(xTimesPerWeekButtonId, textTimesPerWeek)
            tapSave()
        }
        with(createHabitYeaOrNoScreen){
            enterText(notesId,textNotesFor2Test )
            tapButton(saveCreateHabitYeaOrNoId)
            checkScreenIsOpen()
        }
    }


}