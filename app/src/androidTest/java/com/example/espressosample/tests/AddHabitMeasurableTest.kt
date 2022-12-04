package com.example.espressosample.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.espressosample.pageobject.ChooseTypeOfHabitScreen
import com.example.espressosample.pageobject.CreateHabitMeasurableScreen
import com.example.espressosample.pageobject.MainScreen
import com.example.espressosample.pageobject.OnboardingPage

import org.isoron.uhabits.activities.habits.list.ListHabitsActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)

class AddHabitMeasurableTest {
    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(ListHabitsActivity::class.java)

    val onboardingPage = OnboardingPage()
    val mainScreen = MainScreen()
    val chooseTypeOfHabitScreen = ChooseTypeOfHabitScreen()
    val createHabitMeasurableScreen = CreateHabitMeasurableScreen()

    val textName1 = "English"
    val textQuestion1 = "Did you do your lesson?"
    val textUnit1 = "minutes"
    val textTarget1 = "15"
    val textNotes1 = "one in Duolingo"


    @Test
    fun createMeasurableHabit(){
        onboardingPage.tapButton(onboardingPage.skipId)
        mainScreen.tapButton(mainScreen.menuCreateHabitId)
        chooseTypeOfHabitScreen.tapButton(chooseTypeOfHabitScreen.measurable)
        with(createHabitMeasurableScreen){
            enterText(nameMeasurableScreenId, textName1)
            enterText(questionMeasurableScreenID, textQuestion1)
            enterText(unitMeasurableScreenId,textUnit1 )
            enterText(targetMeasurableScreenId, textTarget1)
            tapButton(frequencyMeasurableScreenId)
            tapPicker(testFrequencyEveryDay)
            tapButton(targetTypeMeasurableScreenId)
            tapPicker(textAtLeast)
            enterText(notesMeasurableScreenId, textNotes1)
            tapButton(saveMeasurableScreenId)
        }
        mainScreen.checkHabit(textName1)
    }


}