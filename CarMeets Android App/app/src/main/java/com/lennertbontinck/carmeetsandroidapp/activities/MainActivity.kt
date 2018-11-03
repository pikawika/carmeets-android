package com.lennertbontinck.carmeetsandroidapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
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

    private fun initApp() {
        setSupportActionBar(toolbar)

        //initieel is meetinglijst geselecteerd
        bottom_navigation.selectedItemId = R.id.nav_meetings

        //initieel meetinglijst fragment tonen
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MeetinglijstFragment())
            .commit()

        //initieele titel van toolbar instellen
        supportActionBar?.title = "Meetings"
        supportActionBar?.subtitle = "Alle meetings"
    }

    private fun initListeners() {
        toolbar.setNavigationOnClickListener {
            supportFragmentManager.popBackStack()
            supportActionBar?.title = getString(R.string.app_name)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }

        bottom_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        supportFragmentManager.popBackStack()
        when (item.itemId) {
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
                supportActionBar?.subtitle = "Meetings waarin je geïnteresseerd bent"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FavorietenlijstFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            //account geselecteerd
            R.id.nav_account -> {
                supportActionBar?.title = "Account"
                supportActionBar?.subtitle = "Beheer je instellingen"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AccountFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
