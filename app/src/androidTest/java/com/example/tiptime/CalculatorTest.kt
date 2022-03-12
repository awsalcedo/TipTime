package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.hamcrest.Matchers.containsString
import org.junit.runner.RunWith

/****
 * Project: Tip Time
 * From: com.example.tiptime
 * Created by Alex Salcedo Silva on 12/3/22 at 07:22
 * All rights reserve 2022.
 ***/

@RunWith(AndroidJUnit4::class)
class CalculatorTest {
    //Para interactuar con la ativity primero se debe inciarla
    //@get: Rule() especifica que la linea posterior en este caso
    //iniciar una actividad, se debe ejecutar antes de cada
    //prueba de la clase
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_default_tip() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))

        onView(withId(R.id.calculate_button)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("$10.00"))))

    }

}