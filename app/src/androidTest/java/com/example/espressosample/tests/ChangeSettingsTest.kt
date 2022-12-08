package com.example.espressosample.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.espressosample.pageobject.MainScreen
import com.example.espressosample.pageobject.OnboardingPage
import com.example.espressosample.pageobject.SettingsScreen
import org.isoron.page_object.*
import org.isoron.uhabits.activities.habits.list.ListHabitsActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)

class ChangeSettingsTest {
    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(ListHabitsActivity::class.java)

    val onboardingPage = OnboardingPage()
    val mainScreen = MainScreen()
    val settingsScreen = SettingsScreen()

    @Test
    fun changeSettingsTest(){
        onboardingPage.tapButton(onboardingPage.skipId)
        with(mainScreen){
            tapThreeDotButton()
            tapButtonInDialog(textSettings)
        }
        settingsScreen.tapSwitcherButtonRecycler(1)
    }


}