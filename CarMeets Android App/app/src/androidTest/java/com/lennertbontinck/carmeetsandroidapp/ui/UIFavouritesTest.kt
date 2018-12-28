package com.lennertbontinck.carmeetsandroidapp.ui

import android.os.SystemClock
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import org.junit.Assert.assertEquals
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.v4.widget.ImageViewCompat
import android.support.v7.widget.RecyclerView
import android.widget.TextView
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
class UIFavouritesTest {

    private val username = "androidtestuser"
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
        //vul email in
        onView(withId(R.id.text_login_username)).perform(ViewActions.typeText(username))
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
        //klik meetings
        onView(withId(R.id.nav_meetings)).perform(click())
        //kijk meetings zichtbaar
        onView(withId(R.id.fragment_meeting_list)).check(matches(isDisplayed()))
    }

    @After
    fun afterTests() {
        PreferenceUtil.deletePreferences()
    }

    @Test
    fun meetingDetails_toggleGoing_isSavedOnServerAndCorrectTint() {
        //klik eerste item lijst
        onView(withId(R.id.recycler_meeting_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        //al going (colorPrimary)
        if (ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_going))!!.defaultColor == -1566883){
            //klik going
            onView(withId(R.id.image_meeting_details_going)).perform(click())
            //wacht even voor server
            SystemClock.sleep(1000)
            //nu black want niet meer going
            assertEquals(-16777216, ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_going))!!.defaultColor)
        } else {
            //klik going
            onView(withId(R.id.image_meeting_details_going)).perform(click())
            //wacht even voor server
            SystemClock.sleep(1000)
            //nu colorPrimary want nu going
            assertEquals(-1566883, ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_going))!!.defaultColor)
        }
    }

    @Test
    fun meetingDetails_toggleLiked_isSavedOnServerAndCorrectTint() {
        //klik eerste item lijst
        onView(withId(R.id.recycler_meeting_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        //al liked (colorPrimary)
        if (ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_like))!!.defaultColor == -1566883){
            //klik like
            onView(withId(R.id.image_meeting_details_like)).perform(click())
            //wacht even voor server
            SystemClock.sleep(1000)
            //nu black want niet meer liked
            assertEquals(-16777216, ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_like))!!.defaultColor)
        } else {
            //klik like
            onView(withId(R.id.image_meeting_details_like)).perform(click())
            //wacht even voor server
            SystemClock.sleep(1000)
            //nu colorPrimary want nu liked
            assertEquals(-1566883, ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_like))!!.defaultColor)
        }
    }

    @Test
    fun favouritesList_likeFirstMeetingOfList_isInFavouritesList() {
        //klik eerste item lijst
        onView(withId(R.id.recycler_meeting_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))


        val subTitle : String = mActivityTestRule.activity.findViewById<TextView>(R.id.text_meeting_details_subtitle)!!.text.toString()

        //al going (colorPrimary)
        if (ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_going))!!.defaultColor == -1566883){
            //klik going
            onView(withId(R.id.image_meeting_details_going)).perform(click())
            //wacht even voor server
            SystemClock.sleep(1000)
            //nu black want niet meer going
            assertEquals(-16777216, ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_going))!!.defaultColor)
        }

        //nog niet geliked (colorPrimary)
        if (ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_like))!!.defaultColor != -1566883){
            //klik like
            onView(withId(R.id.image_meeting_details_like)).perform(click())
            //wacht even voor server
            SystemClock.sleep(1000)
            //nu colorPrimary want nu liked
            assertEquals(-1566883, ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_like))!!.defaultColor)
        }

        //klik favourites
        onView(withId(R.id.nav_favourites)).perform(click())

        //kijk of net gelikete meeting nu in favourites staat
        onView(withId(R.id.recycler_meeting_list)).check(matches(hasDescendant(withText(subTitle))))
    }

    @Test
    fun favouritesList_goingFirstMeetingOfList_isInFavouritesList() {
        //klik eerste item lijst
        onView(withId(R.id.recycler_meeting_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))


        val subTitle : String = mActivityTestRule.activity.findViewById<TextView>(R.id.text_meeting_details_subtitle)!!.text.toString()

        //al liked (colorPrimary)
        if (ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_like))!!.defaultColor == -1566883){
            //klik like
            onView(withId(R.id.image_meeting_details_like)).perform(click())
            //wacht even voor server
            SystemClock.sleep(1000)
            //nu black want niet meer liked
            assertEquals(-16777216, ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_like))!!.defaultColor)
        }

        //nog niet going (colorPrimary)
        if (ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_going))!!.defaultColor != -1566883){
            //klik going
            onView(withId(R.id.image_meeting_details_going)).perform(click())
            //wacht even voor server
            SystemClock.sleep(1000)
            //nu colorPrimary want nu going
            assertEquals(-1566883, ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_going))!!.defaultColor)
        }

        //klik favourites
        onView(withId(R.id.nav_favourites)).perform(click())

        //kijk of net gelikete meeting nu in favourites staat
        onView(withId(R.id.recycler_meeting_list)).check(matches(hasDescendant(withText(subTitle))))
    }

    @Test
    fun favouritesList_likedAndGoingFirstMeetingOfList_isInFavouritesList() {
        //klik eerste item lijst
        onView(withId(R.id.recycler_meeting_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))


        val subTitle : String = mActivityTestRule.activity.findViewById<TextView>(R.id.text_meeting_details_subtitle)!!.text.toString()

        //nog niet geliked (colorPrimary)
        if (ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_like))!!.defaultColor != -1566883){
            //klik like
            onView(withId(R.id.image_meeting_details_like)).perform(click())
            //wacht even voor server
            SystemClock.sleep(1000)
            //nu colorPrimary want nu liked
            assertEquals(-1566883, ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_like))!!.defaultColor)
        }

        //nog niet going (colorPrimary)
        if (ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_going))!!.defaultColor != -1566883){
            //klik going
            onView(withId(R.id.image_meeting_details_going)).perform(click())
            //wacht even voor server
            SystemClock.sleep(1000)
            //nu colorPrimary want nu going
            assertEquals(-1566883, ImageViewCompat.getImageTintList(mActivityTestRule.activity.findViewById(R.id.image_meeting_details_going))!!.defaultColor)
        }

        //klik favourites
        onView(withId(R.id.nav_favourites)).perform(click())

        //kijk of net gelikete meeting nu in favourites staat
        onView(withId(R.id.recycler_meeting_list)).check(matches(hasDescendant(withText(subTitle))))
    }




}
