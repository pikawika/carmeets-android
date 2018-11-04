package com.lennertbontinck.carmeetsandroidapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.fragments.AccountFragment
import com.lennertbontinck.carmeetsandroidapp.fragments.FavorietenlijstFragment
import com.lennertbontinck.carmeetsandroidapp.fragments.MeetinglijstFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initApp()
    }

    override fun onStart() {
        super.onStart()

        initListeners()
    }

    //bel en zoek toevoegen aan app bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)

        //manueel listener event voor notificatiebel met badge adhv actionLayout
        val notificaties = menu?.findItem(R.id.nav_notificaties)?.actionView
        notificaties?.findViewById<ImageView>(R.id.nav_notificatiebel)?.setOnClickListener({ notificatiesClicked() })
        notificaties?.findViewById<TextView>(R.id.nav_notificatiebel_aantal)
            ?.setOnClickListener({ notificatiesClicked() })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            //bel icoon ga naar liked meetings
            R.id.nav_notificaties -> {
                notificatiesClicked()
                return super.onOptionsItemSelected(item)
            }

            R.id.nav_zoek -> {
                Toast.makeText(this, "Er is op zoeken geklikt", Toast.LENGTH_SHORT).show()
                return super.onOptionsItemSelected(item)
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    //fysieke back button ingedruk
    override fun onBackPressed() {
        super.onBackPressed()

        var index = supportFragmentManager.backStackEntryCount - 1

        if (index >= 0) {
            val huidigFragmentType = supportFragmentManager.getBackStackEntryAt(index).name
            when (huidigFragmentType) {
                getString(R.string.fragtag_meetinglijst) -> setLayoutVoorMeetinglijst()
                getString(R.string.fragtag_favorietenlijst)-> setLayoutVoorFavorietenlijst()
                getString(R.string.fragtag_account) -> setLayoutVoorAccount()
            }
        }
        //indien er geen items meer zijn in stack en je bent al op home moet de app gesloten worden
        else if (index == -1 && bottom_navigation.selectedItemId == R.id.nav_meetings) finish()
        else setLayoutVoorMeetinglijst()
    }

    private fun initApp() {
        setSupportActionBar(toolbar)
        //initieel is er geen back knop
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        //initieel meetinglijst fragment tonen
        supportActionBar?.title = getString(R.string.toolbar_meetings_titel)
        supportActionBar?.subtitle = getString(R.string.toolbar_meetings_subtitel)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MeetinglijstFragment())
            .addToBackStack(getString(R.string.fragtag_meetinglijst))
            .commit()

    }


    private fun initListeners() {
        bottom_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.addOnBackStackChangedListener { onBackStackChangedListener() }

        //toolbar back button ingedrukt
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun notificatiesClicked() {
        //POC dat je aantal kan aanpassen, +1 op click
        val notificatieAantal = toolbar.menu.findItem(R.id.nav_notificaties)
            ?.actionView?.findViewById<TextView>(R.id.nav_notificatiebel_aantal)

        notificatieAantal?.text = (notificatieAantal?.text.toString().toInt() + 1).toString()

        setLayoutVoorFavorietenlijst()
    }

    private fun setLayoutVoorMeetinglijst(isNietNavClick: Boolean = true) {
        supportActionBar?.title = getString(R.string.toolbar_meetings_titel)
        supportActionBar?.subtitle = getString(R.string.toolbar_meetings_subtitel)
        if (isNietNavClick) {
            bottom_navigation.selectedItemId = R.id.nav_meetings
        }
    }

    private fun setLayoutVoorFavorietenlijst(isNietNavClick: Boolean = true) {
        supportActionBar?.title = getString(R.string.toolbar_favorieten_titel)
        supportActionBar?.subtitle = getString(R.string.toolbar_favorieten_subtitel)
        if (isNietNavClick) {
            bottom_navigation.selectedItemId = R.id.nav_favorieten
        }
    }

    private fun setLayoutVoorAccount(isNietNavClick: Boolean = true) {
        supportActionBar?.title = getString(R.string.toolbar_account_titel)
        supportActionBar?.subtitle = getString(R.string.toolbar_account_subtitel)
        if (isNietNavClick) {
            bottom_navigation.selectedItemId = R.id.nav_account
        }
    }

    private fun checkFragmentEqualsNavItem(item: MenuItem?): Boolean {
        var index = supportFragmentManager.backStackEntryCount - 1
        if (index >= 0) {
            val huidigFragmentType = supportFragmentManager.getBackStackEntryAt(index).name
            when (huidigFragmentType) {
                getString(R.string.fragtag_meetinglijst) -> if (item?.itemId == R.id.nav_meetings) return true
                getString(R.string.fragtag_favorietenlijst) -> if (item?.itemId == R.id.nav_favorieten) return true
                getString(R.string.fragtag_account) -> if (item?.itemId == R.id.nav_account) return true
            }
        }
        //het is nooit gelijk geweest
        return false
    }

    private fun onBackStackChangedListener() {
        //indien nog 1 open staat is het de initiele fragment en moet er softwarematisch niet meer op back geduwd worden
        if (supportFragmentManager.backStackEntryCount <= 1) {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        } else supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        //indien zelfde nav item geselecteerd als het reeds is, doe niets.
        if (checkFragmentEqualsNavItem(item)) return@OnNavigationItemSelectedListener true

        when (item?.itemId) {
            //meetinglijst geselecteerd
            R.id.nav_meetings -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MeetinglijstFragment())
                    .addToBackStack(getString(R.string.fragtag_meetinglijst))
                    .commit()
                setLayoutVoorMeetinglijst(false)
                return@OnNavigationItemSelectedListener true
            }
            //favorieten geselecteerd
            R.id.nav_favorieten -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FavorietenlijstFragment())
                    .addToBackStack(getString(R.string.fragtag_favorietenlijst))
                    .commit()
                setLayoutVoorFavorietenlijst(false)
                return@OnNavigationItemSelectedListener true
            }
            //account geselecteerd
            R.id.nav_account -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AccountFragment())
                    .addToBackStack(getString(R.string.fragtag_account))
                    .commit()
                setLayoutVoorAccount(false)
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false
    }

}
