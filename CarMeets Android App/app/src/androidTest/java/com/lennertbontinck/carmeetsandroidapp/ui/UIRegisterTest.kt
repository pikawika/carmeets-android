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
import java.util.*



@RunWith(JUnit4::class)
class UIRegisterTest {

    private var username = "androidtestuser"
    private var tokenUsername = "admin"
    private var email = "androidtestuser@lennertbontinck.com"
    private var tokenEmail = "info@lennertbontinck.com"
    private var password = "Password123"

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

        val uuid = UUID.randomUUID()
        username = uuid.toString()
        email = uuid.toString() + "@lennertbontinck.com"

        //klik account
        onView(withId(R.id.nav_account)).perform(click())
        //kijk login fragment zichtbaar
        onView(withId(R.id.fragment_login)).check(matches(isDisplayed()))
        //klik op register
        onView(withId(R.id.button_login_register)).perform(click())
        //kijk register fragment zichtbaar
        onView(withId(R.id.fragment_register)).check(matches(isDisplayed()))
    }

    @After
    fun afterTests() {
        PreferenceUtil.deletePreferences()
    }

    @Test
    fun register_allFieldsEmpty_showToastEmptyFields() {
        //druk direct op registreer
        onView(withId(R.id.button_register_confirm)).perform(click())
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
    fun register_someFieldsEmpty_showToastEmptyFields() {
        //vul email in
        onView(withId(R.id.text_register_email)).perform(ViewActions.typeText(email))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul username in
        onView(withId(R.id.text_register_username)).perform(ViewActions.typeText(username))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //druk op registreer
        onView(withId(R.id.button_register_confirm)).perform(click())
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
    fun register_passwordsDoNotMatch_showToastPasswordsNotEqual() {
        //vul email in
        onView(withId(R.id.text_register_email)).perform(ViewActions.typeText(email))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul username in
        onView(withId(R.id.text_register_username)).perform(ViewActions.typeText(username))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul ww in
        onView(withId(R.id.text_register_password)).perform(ViewActions.typeText(password))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul confirm ww in
        onView(withId(R.id.text_register_confirm_password)).perform(ViewActions.typeText(password + "notEqual"))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //druk op registreer
        onView(withId(R.id.button_register_confirm)).perform(click())
        //kijk password not equal toast
        onView(withText(R.string.warning_passwords_not_equal)).inRoot(
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
    fun register_existingUsername_doesNotRegister() {
        //vul email in
        onView(withId(R.id.text_register_email)).perform(ViewActions.typeText(email))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul username in
        onView(withId(R.id.text_register_username)).perform(ViewActions.typeText(tokenUsername))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul ww in
        onView(withId(R.id.text_register_password)).perform(ViewActions.typeText(password))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul confirm ww in
        onView(withId(R.id.text_register_confirm_password)).perform(ViewActions.typeText(password))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //druk op registreer
        onView(withId(R.id.button_register_confirm)).perform(click())
        //kijk register fragment zichtbaar (toast komt van server)
        onView(withId(R.id.fragment_register)).check(matches(isDisplayed()))
    }

    @Test
    fun register_existingEmail_doesNotRegister() {
        //vul email in
        onView(withId(R.id.text_register_email)).perform(ViewActions.typeText(tokenEmail))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul username in
        onView(withId(R.id.text_register_username)).perform(ViewActions.typeText(username))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul ww in
        onView(withId(R.id.text_register_password)).perform(ViewActions.typeText(password))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul confirm ww in
        onView(withId(R.id.text_register_confirm_password)).perform(ViewActions.typeText(password))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //druk op registreer
        onView(withId(R.id.button_register_confirm)).perform(click())
        //kijk register fragment zichtbaar (toast komt van server)
        onView(withId(R.id.fragment_register)).check(matches(isDisplayed()))
    }

    @Test
    fun register_correctInfo_registerAndCorrectUsername() {
        //vul email in
        onView(withId(R.id.text_register_email)).perform(ViewActions.typeText(email))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul username in
        onView(withId(R.id.text_register_username)).perform(ViewActions.typeText(username))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul ww in
        onView(withId(R.id.text_register_password)).perform(ViewActions.typeText(password))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //vul confirm ww in
        onView(withId(R.id.text_register_confirm_password)).perform(ViewActions.typeText(password))
        android.support.test.espresso.Espresso.closeSoftKeyboard()
        //druk op registreer
        onView(withId(R.id.button_register_confirm)).perform(click())
        //wacht even voor server
        SystemClock.sleep(1000)
        //username op account pagina
        onView(withId(R.id.text_account_username)).check(matches(withText(username)))
    }
}
