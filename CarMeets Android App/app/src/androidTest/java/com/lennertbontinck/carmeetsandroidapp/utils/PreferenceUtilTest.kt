package com.lennertbontinck.carmeetsandroidapp.utils

import android.support.test.rule.ActivityTestRule
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.enums.ListDesignEnum
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum
import org.junit.*


class PreferenceUtilTest {
    private val token1 : String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1YmRlZjlmOTFmNTlhMDAwMTMwMmY1YmUiLCJ1c2VybmFtZSI6InNuZWxsZW5lZGR5Iiwicm9sZSI6InN0YW5kYWFyZCIsImV4cCI6MjQwOTk5OTY5NiwiaWF0IjoxNTQ1OTk5Njk2fQ.3J6g0ccP9l8EiHsFfKtGDTvlxc0HY15WXBX30J7Jw4g"

    private val meetingPage = MenuItemEnum.MEETINGS
    private val favouritesPage = MenuItemEnum.FAVOURITES
    private val accountPage = MenuItemEnum.ACCOUNT

    private val smallListDesign = ListDesignEnum.SMALL
    private val bigListDesign = ListDesignEnum.BIG

    private val noToken = ""
    private val defaultBootPage = MenuItemEnum.MEETINGS
    private val defaultListLayout = ListDesignEnum.SMALL

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun beforeTests() {
        PreferenceUtil.deletePreferences()
    }

    @After
    fun afterTests() {
        PreferenceUtil.deletePreferences()
    }

    @Test
    fun preferenceUtil_setAndGetToken_isCorrect() {
        PreferenceUtil.setToken(token1)

        Assert.assertEquals(token1, PreferenceUtil.getToken())
    }

    @Test
    fun preferenceUtil_setAndGetBootPage_isMeetingPageCorrect() {
        PreferenceUtil.setDefaultBootPage(meetingPage)

        Assert.assertEquals(meetingPage, PreferenceUtil.getDefaultBootPage())
    }

    @Test
    fun preferenceUtil_setAndGetBootPage_isFavouritesPageCorrect() {
        PreferenceUtil.setDefaultBootPage(favouritesPage)

        Assert.assertEquals(favouritesPage, PreferenceUtil.getDefaultBootPage())
    }

    @Test
    fun preferenceUtil_setAndGetBootPage_isAccountPageCorrect() {
        PreferenceUtil.setDefaultBootPage(accountPage)

        Assert.assertEquals(accountPage, PreferenceUtil.getDefaultBootPage())
    }

    @Test
    fun preferenceUtil_setAndGetDefaultList_isSmallCorrect() {
        PreferenceUtil.setDefaultListLayout(smallListDesign)

        Assert.assertEquals(smallListDesign, PreferenceUtil.getDefaultListLayout())
    }

    @Test
    fun preferenceUtil_setAndGetDefaultList_isBigCorrect() {
        PreferenceUtil.setDefaultListLayout(bigListDesign)

        Assert.assertEquals(bigListDesign, PreferenceUtil.getDefaultListLayout())
    }

    @Test
    fun preferenceUtil_deletePreferences_isCorrect() {
        PreferenceUtil.deletePreferences()

        Assert.assertEquals(noToken, PreferenceUtil.getToken())
        Assert.assertEquals(defaultBootPage, PreferenceUtil.getDefaultBootPage())
        Assert.assertEquals(defaultListLayout, PreferenceUtil.getDefaultListLayout())
    }
}
