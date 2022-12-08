package com.example.espressosample.pageobject

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.isoron.uhabits.R

class SettingsScreen {
    fun tapSwitcherButtonRecycler(i: Int){
        onView(
            withId(R.id.recycler_view),
        ).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(i, click()))
    }

    fun checkToggle(){

    }

}