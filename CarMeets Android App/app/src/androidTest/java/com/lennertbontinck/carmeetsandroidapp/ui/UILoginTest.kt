package com.lennertbontinck.carmeetsandroidapp.ui

import android.os.SystemClock
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.utils.PreferenceUtil
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UILoginTest {

    private val username = "androidtestuser"
    private val email = "androidtestuser@lennertbontinck.com"
    private val password = "Password123"

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Before
    fun beforeTests() {
        //verwijder shared preferences
        PreferenceUtil.deletePreferences()

        mActivityTestRule.launchActivity(null)
        //wacht even voor het laden van de data
        //server zou actief moeten zijn vooraleer testen uitgevoerd worden om onnodig lange wachttijden te vermijden
        SystemClock.sleep(1000)

        //klik account
        onView(withId(R.id.nav_account)).perform(click())
        //kijk login zichtbaar
        onView(withId(R.id.fragment_login)).check(matches(isDisplayed()))
    }

    @After
    fun afterTests() {
        PreferenceUtil.deletePreferences()
    }

    @Test
    fun login_bothFieldsEmpty_showToastEmptyFields() {
        //druk direct op aanmelden
        onView(withId(R.id.button_login_confirm)).perform(click())
        //kijk empty fields toast
        onView(withText(R.string.warning_empty_fields)).inRoot(
            RootMatchers.withDecorView(
                CoreMatchers.not(
                    CoreMatchers.`is`(
                        mActivityTestRule.activity.window.decorView
                    )
                )
            )
        ).check(matches(isDisplayed()))
    }

    @Test
    fun login_usernameFieldsEmpty_showToastEmptyFields() {
        //vul password in
        onView(withId(R.id.text_login_password)).perform(ViewActions.typeText(password))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //druk op aanmelden
        onView(withId(R.id.button_login_confirm)).perform(click())
        //kijk empty fields toast
        onView(withText(R.string.warning_empty_fields)).inRoot(
            RootMatchers.withDecorView(
                CoreMatchers.not(
                    CoreMatchers.`is`(
                        mActivityTestRule.activity.window.decorView
                    )
                )
            )
        ).check(matches(isDisplayed()))
    }

    @Test
    fun login_passwordFieldsEmpty_showToastEmptyFields() {
        //vul username in
        onView(withId(R.id.text_login_username)).perform(ViewActions.typeText(username))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //druk op aanmelden
        onView(withId(R.id.button_login_confirm)).perform(click())
        //kijk empty fields toast
        onView(withText(R.string.warning_empty_fields)).inRoot(
            RootMatchers.withDecorView(
                CoreMatchers.not(
                    CoreMatchers.`is`(
                        mActivityTestRule.activity.window.decorView
                    )
                )
            )
        ).check(matches(isDisplayed()))
    }

    @Test
    fun login_correctInfo_logInWithUsername_userLogsIn() {
        //vul username in
        onView(withId(R.id.text_login_username)).perform(ViewActions.typeText(username))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul password in
        onView(withId(R.id.text_login_password)).perform(ViewActions.typeText(password))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //druk op aanmelden
        onView(withId(R.id.button_login_confirm)).perform(click())
        //username op account pagina
        onView(withId(R.id.text_account_username)).check(matches(withText(username)))
    }

    @Test
    fun login_correctInfo_logInWithEmail_userLogsIn() {
        //vul email in
        onView(withId(R.id.text_login_username)).perform(ViewActions.typeText(email))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul password in
        onView(withId(R.id.text_login_password)).perform(ViewActions.typeText(password))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //druk op aanmelden
        onView(withId(R.id.button_login_confirm)).perform(click())
        //wacht even voor server
        SystemClock.sleep(1000)
        //username op account pagina
        onView(withId(R.id.text_account_username)).check(matches(withText(username)))
    }

}
