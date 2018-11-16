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

        setSupportActionBar(menu_main_toolbar)

        //initieel is er geen back knop
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        //initieel meeting lijst
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main_fragmentcontainer, MeetinglijstFragment())
            .addToBackStack(getString(R.string.fragtag_meetinglijst))
            .commit()
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
        notificaties?.findViewById<ImageView>(R.id.image_partialnotificaties_bel)?.setOnClickListener({ notificatiesClicked() })
        notificaties?.findViewById<TextView>(R.id.text_partialnotificaties_aantal)
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

            R.id.ab_opties_groot -> {
                setLayoutLijstDesgin("groot")
                return super.onOptionsItemSelected(item)
            }

            R.id.ab_opties_klein -> {
                setLayoutLijstDesgin("klein")
                return super.onOptionsItemSelected(item)
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    //fysieke back button ingedruk
    override fun onBackPressed() {
        super.onBackPressed()

        var index = supportFragmentManager.backStackEntryCount - 1

        //indien er geen items meer zijn in stack en je bent al op home moet de app gesloten worden
        if (index == -1 && menu_main_bottomnavigation.selectedItemId == R.id.nav_meetings) finish()
    }

    private fun initListeners() {
        menu_main_bottomnavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.addOnBackStackChangedListener { onBackStackChangedListener() }

        //toolbar back button ingedrukt
        menu_main_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun notificatiesClicked() {
        //POC dat je aantal kan aanpassen, +1 op click
        val notificatieAantal = menu_main_toolbar.menu.findItem(R.id.nav_notificaties)
            ?.actionView?.findViewById<TextView>(R.id.text_partialnotificaties_aantal)

        notificatieAantal?.text = (notificatieAantal?.text.toString().toInt() + 1).toString()
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

    private fun setLayoutLijstDesgin(lijstDesgin : String ) {
        var index = supportFragmentManager.backStackEntryCount - 1

        if (index >= 0) {
            val huidigFragmentType = supportFragmentManager.getBackStackEntryAt(index).name
            when (huidigFragmentType) {
                getString(R.string.fragtag_favorietenlijst)-> {
                    var fragment = FavorietenlijstFragment.newInstance(lijstDesgin)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_main_fragmentcontainer, fragment)
                        .addToBackStack(getString(R.string.fragtag_favorietenlijst))
                        .commit()
                }
                getString(R.string.fragtag_meetinglijst)-> {
                    var fragment = MeetinglijstFragment.newInstance(lijstDesgin)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_main_fragmentcontainer, fragment)
                        .addToBackStack(getString(R.string.fragtag_meetinglijst))
                        .commit()
                }
            }
        }
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
                    .replace(R.id.frame_main_fragmentcontainer, MeetinglijstFragment())
                    .addToBackStack(getString(R.string.fragtag_meetinglijst))
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            //favorieten geselecteerd
            R.id.nav_favorieten -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, FavorietenlijstFragment())
                    .addToBackStack(getString(R.string.fragtag_favorietenlijst))
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            //account geselecteerd
            R.id.nav_account -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, AccountFragment())
                    .addToBackStack(getString(R.string.fragtag_account))
                    .commit()
                Toast.makeText(this, "Er is op zoeken geklikt", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false
    }
}
