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
        notificaties?.findViewById<TextView>(R.id.nav_notificatiebel_aantal)?.setOnClickListener({ notificatiesClicked() })

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

    private fun initApp() {
        setSupportActionBar(toolbar)


        //initieel is meetinglijst geselecteerd
        bottom_navigation.selectedItemId = R.id.nav_meetings

        //initieel meetinglijst fragment tonen
        supportActionBar?.title = "Meetings"
        supportActionBar?.subtitle = "Alle meetings"
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MeetinglijstFragment())
            .commit()

    }

    private fun initListeners() {
        bottom_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    }

    private fun notificatiesClicked() {
        //POC dat je aantal kan aanpassen, +1 op click
        val notificatieAantal = toolbar.menu.findItem(R.id.nav_notificaties)?.actionView?.findViewById<TextView>(R.id.nav_notificatiebel_aantal)

        notificatieAantal?.text = (notificatieAantal?.text.toString().toInt() + 1).toString()


        supportActionBar?.title = "Favorieten"
        supportActionBar?.subtitle = "Liked en going meetings"
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FavorietenlijstFragment())
            .commit()
        bottom_navigation.selectedItemId = R.id.nav_favorieten
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item?.itemId) {
            //meetinglijst geselecteerd
            R.id.nav_meetings -> {
                supportActionBar?.title = "Meetings"
                supportActionBar?.subtitle = "Alle meetings"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MeetinglijstFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            //favorieten geselecteerd
            R.id.nav_favorieten -> {
                supportActionBar?.title = "Favorieten"
                supportActionBar?.subtitle = "Liked en going meetings"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FavorietenlijstFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            //account geselecteerd
            R.id.nav_account -> {
                supportActionBar?.title = "Account"
                supportActionBar?.subtitle = "Instellingen aanpassen"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AccountFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
