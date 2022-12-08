package com.example.espressosample.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.espressosample.pageobject.*

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
    val detailedHabitAfterCreationScreen = DetailedHabitAfterCreationScreen()

    val textName1 = "English"
    val textQuestion1 = "Did you do your lesson?"
    val textUnit1 = "minutes"
    val textTarget1 = "15"
    val textNotes1 = "one in Duolingo"
    val textQuestionPills = "have you taken the pills?"
    val textUnitPills = "Pills"
    val textTargetPills = "1"
    val textNotesPills = "Creon, mesim"
    val textTargetEditAfterCreation = "10"
    val textNameEditAfterCreation1 = "Read book"
    val textQuestionEditAfterCreation = "Did you read the book?"
    val textUnitEditAfterCreation = "page"
    val textNameEditAfterCreation2 = "Read book every day"
    val textNotesEditAfterCreation = "Sunday morning"


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

    @Test
    fun enterEmptyName(){
        onboardingPage.tapButton(onboardingPage.skipId)
        mainScreen.tapButton(mainScreen.menuCreateHabitId)
        chooseTypeOfHabitScreen.tapButton(chooseTypeOfHabitScreen.measurable)
        with(createHabitMeasurableScreen){
            enterText(questionMeasurableScreenID, textQuestionPills)
            enterText(unitMeasurableScreenId,textUnitPills)
            enterText(targetMeasurableScreenId, textTargetPills)
            tapButton(frequencyMeasurableScreenId)
            tapPicker(testFrequencyEveryDay)
            tapButton(targetTypeMeasurableScreenId)
            tapPicker(textAtMost)
            enterText(notesMeasurableScreenId, textNotesPills)
            tapButton(saveMeasurableScreenId)
            checkScreenIsOpen()
        }
    }

    @Test
    fun editHabitAfterCreation(){
        onboardingPage.tapButton(onboardingPage.skipId)
        mainScreen.tapButton(mainScreen.menuCreateHabitId)
        chooseTypeOfHabitScreen.tapButton(chooseTypeOfHabitScreen.measurable)
        with(createHabitMeasurableScreen){
            enterText(nameMeasurableScreenId, textNameEditAfterCreation1)
            enterText(targetMeasurableScreenId, textTargetEditAfterCreation)
            tapButton(saveMeasurableScreenId)
        }
        with(mainScreen){
            checkHabit(textNameEditAfterCreation1)
            tapHabit(textNameEditAfterCreation1)
        }
        detailedHabitAfterCreationScreen.tapButton(detailedHabitAfterCreationScreen.editId)
        with(createHabitMeasurableScreen){
            enterText(nameMeasurableScreenId,textNameEditAfterCreation2 )
            enterText(questionMeasurableScreenID, textQuestionEditAfterCreation)
            enterText(unitMeasurableScreenId, textUnitEditAfterCreation)
            enterText(targetMeasurableScreenId, textTargetEditAfterCreation)
            tapButton(frequencyMeasurableScreenId)
            tapPicker(testFrequencyEveryWeek)
            tapButton(targetTypeMeasurableScreenId)
            tapPicker(textAtMost)
            enterText(notesMeasurableScreenId, textNotesEditAfterCreation)
            tapButton(saveMeasurableScreenId)
        }
        with(detailedHabitAfterCreationScreen){
            checkQuestionIsShown(questionTextId,textQuestionEditAfterCreation)
            tapBackButton(textNameEditAfterCreation2)
        }
        mainScreen.checkHabit(textNameEditAfterCreation2)

    }


}