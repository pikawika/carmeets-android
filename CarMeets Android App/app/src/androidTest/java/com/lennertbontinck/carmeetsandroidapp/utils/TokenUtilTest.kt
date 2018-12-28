package com.lennertbontinck.carmeetsandroidapp.utils

import android.support.test.rule.ActivityTestRule
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TokenUtilTest {

    private val token1 : String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1YmRlZjlmOTFmNTlhMDAwMTMwMmY1YmUiLCJ1c2VybmFtZSI6InNuZWxsZW5lZGR5Iiwicm9sZSI6InN0YW5kYWFyZCIsImV4cCI6MjQwOTk5OTY5NiwiaWF0IjoxNTQ1OTk5Njk2fQ.3J6g0ccP9l8EiHsFfKtGDTvlxc0HY15WXBX30J7Jw4g"
    private val token1Id : String = "5bdef9f91f59a0001302f5be"
    private val token1Username : String = "snelleneddy"
    private val token1Role : String = "standaard"

    private val emptyToken : String = ""
    private val wrongToken : String = "BrokenString"

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun beforeTests() {
        mockkObject(PreferenceUtil)
    }

    @After
    fun afterTests() {
        unmockkAll()
    }

    @Test
    fun tokenUtil_getTokenContent_isCorrect() {
        every { PreferenceUtil.getToken() } returns token1

        val tokenContent = TokenUtil.getTokenContent()

        Assert.assertEquals(token1Id, tokenContent!!._id)
        Assert.assertEquals(token1Username, tokenContent.username)
        Assert.assertEquals(token1Role, tokenContent.role)
    }

    @Test
    fun tokenUtil_getTokenContent_isEmpty() {
        every { PreferenceUtil.getToken() } returns emptyToken

        val tokenContent = TokenUtil.getTokenContent()

        Assert.assertEquals(null, tokenContent)
    }

    @Test
    fun tokenUtil_getTokenContent_isWrongToken() {
        every { PreferenceUtil.getToken() } returns wrongToken

        val tokenContent = TokenUtil.getTokenContent()

        Assert.assertEquals(null, tokenContent)
    }
}
