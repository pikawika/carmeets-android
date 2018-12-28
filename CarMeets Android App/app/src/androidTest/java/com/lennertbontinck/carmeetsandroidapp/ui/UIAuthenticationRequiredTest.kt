package com.lennertbontinck.carmeetsandroidapp.ui

import android.os.SystemClock
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.RootMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.utils.PreferenceUtil
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UIAuthenticationRequiredTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun beforeTests() {
        //verwijder shared preferences
        PreferenceUtil.deletePreferences()


        //wacht even voor het laden van de data
        //server zou actief moeten zijn vooraleer testen uitgevoerd worden om onnodig lange wachttijden te vermijden
        SystemClock.sleep(1000)
    }

    @After
    fun afterTests() {
        PreferenceUtil.deletePreferences()
    }

    @Test
    fun accountPage_showLoginIfNotSignedIn() {
        //klik nav
        onView(withId(R.id.nav_account)).perform(click())
        //kijk login zichtbaar
        onView(withId(R.id.fragment_login)).check(matches(isDisplayed()))
    }

    @Test
    fun notification_showLoginDialogForNotSignedIn_goToLoginOnAccept() {
        //klik notifi
        onView(withId(R.id.image_partial_notification_bell)).perform(click())

        //kijk dialog en klik
        onView(withText(R.string.txt_login_required_for_this_function)).inRoot(RootMatchers.isDialog())
            .check(matches(isDisplayed()))
        onView(withText(R.string.txt_login_required_for_this_function)).inRoot(RootMatchers.isDialog())
        onView(withText(R.string.txt_login)).inRoot(RootMatchers.isDialog()).perform(click())

        //kijk login fragment zichtbaar
        onView(withId(R.id.fragment_login)).check(matches(isDisplayed()))
    }

    @Test
    fun meetingDetails_like_showLoginDialogForNotSignedIn_cancel() {
        //klik eerste item lijst
        onView(withId(R.id.recycler_meeting_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        //klik like
        onView(withId(R.id.image_meeting_details_like)).perform(click())

        //kijk login popup en klik cancel
        onView(withText(R.string.txt_login_required_for_this_function)).inRoot(RootMatchers.isDialog())
            .check(matches(isDisplayed()))
        onView(withText(R.string.txt_login_required_for_this_function)).inRoot(RootMatchers.isDialog())
        onView(withText(R.string.txt_cancel)).inRoot(RootMatchers.isDialog()).perform(click())

        //kijk of like knop nog altijd zichtbaar na cancel
        onView(withId(R.id.image_meeting_details_like)).check(matches(isDisplayed()))
    }

    @Test
    fun meetingDetails_going_showLoginDialogForNotSignedIn_goToLoginOnAccept() {
        //klik eerste item lijst
        onView(withId(R.id.recycler_meeting_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        //klik going
        onView(withId(R.id.image_meeting_details_going)).perform(click())

        //kijk login popup en klik login
        onView(withText(R.string.txt_login_required_for_this_function)).inRoot(RootMatchers.isDialog())
            .check(matches(isDisplayed()))
        onView(withText(R.string.txt_login_required_for_this_function)).inRoot(RootMatchers.isDialog())
        onView(withText(R.string.txt_login)).inRoot(RootMatchers.isDialog()).perform(click())

        //kijk login fragment zichtbaar
        onView(withId(R.id.fragment_login)).check(matches(isDisplayed()))
    }


}
