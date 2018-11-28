package com.lennertbontinck.carmeetsandroidapp.activities

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.enums.LijstDesignEnum
import com.lennertbontinck.carmeetsandroidapp.fragments.AccountFragment
import com.lennertbontinck.carmeetsandroidapp.fragments.FavorietenlijstFragment
import com.lennertbontinck.carmeetsandroidapp.fragments.MeetinglijstFragment
import com.lennertbontinck.carmeetsandroidapp.utils.FragmentUtil
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * De *mainactivity* van de applicatie. Er is maar 1 activity doorheen de app.
 */
class MainActivity : AppCompatActivity() {

    //veiwmodel var instellen zodat deze doorheen de mainactivity aanspreekbaar is
    private lateinit var meetingViewModel: MeetingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        //bij het laden van de app de mainactivity instellen
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //de viewmodel eenmalig instellen mits die meermalig in activty gebruikt zal worden
        meetingViewModel = ViewModelProviders.of(this).get(MeetingViewModel::class.java)

        //supportbar instellen zodat hij toolbar gebruikt
        setSupportActionBar(menu_main_toolbar)

        //initieel is er geen back knop
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        //initieel wordt meetinglijst weergegeven
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main_fragmentcontainer, MeetinglijstFragment())
            .addToBackStack(getString(R.string.fragtag_meetinglist))
            .commit()
    }

    override fun onStart() {
        super.onStart()

        //listener op de bottomnav
        menu_main_bottomnavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        //listener op de backstack voor
        supportFragmentManager.addOnBackStackChangedListener { onBackStackChangedListener() }

        //listener wanneer back button uit de toolbar -> zelfde functie als hardware back button
        menu_main_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menu van de toolbar instellen
        menuInflater.inflate(R.menu.toolbar, menu)

        //listener voor het klikken op noticaties uit de actionbar
        val Notifications = menu?.findItem(R.id.nav_notificaties)?.actionView
        Notifications?.findViewById<ImageView>(R.id.image_partialnotificaties_bel)
            ?.setOnClickListener { notificatiesClicked() }
        Notifications?.findViewById<TextView>(R.id.text_partialnotificaties_aantal)
            ?.setOnClickListener { notificatiesClicked() }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //het item dat gelklikt is uit de toolbar
        //dit id moet in theorie altijd ingevuld zijn want enkel dan weet je wat aangeduid en kan je bijhorende actie uitvoeren
        when (item?.itemId) {
            R.id.nav_notificaties -> {
                notificatiesClicked()
                return super.onOptionsItemSelected(item)
            }

            R.id.nav_zoek -> {
                MessageUtil.toonToast(this, "Er is op zoeken geklikt")
                return super.onOptionsItemSelected(item)
            }

            R.id.ab_opties_klein -> {
                meetingViewModel.setLijstDesign(LijstDesignEnum.KLEIN)
                return super.onOptionsItemSelected(item)
            }

            R.id.ab_opties_groot -> {
                meetingViewModel.setLijstDesign(LijstDesignEnum.GROOT)
                return super.onOptionsItemSelected(item)
            }

            //default
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //fysieke back button ingedruk
    override fun onBackPressed() {
        super.onBackPressed()

        //indien er geen items meer zijn in stack mag je afsluiten
        //manueel anders gaat hij eerts ook de initiele fragmentinlading ongedaan maken wat niet moet
        if (supportFragmentManager.backStackEntryCount == 0) finish()
    }

    /**
     * *POC* functie dat toont dat je een onclick van notificatiebel kan vastleggen en dat je het aantal kan aanpassen.
     *
     * Verhoogt het aantal naast het notificatie icoon met 1 per klik.
     */
    private fun notificatiesClicked() {
        val notificatieAantal = menu_main_toolbar.menu.findItem(R.id.nav_notificaties)
            ?.actionView?.findViewById<TextView>(R.id.text_partialnotificaties_aantal)

        notificatieAantal?.text = (notificatieAantal?.text.toString().toInt() + 1).toString()
    }

    /**
     * methode voor de *backstack* changes in de gaten te houden.
     *
     * zorgt er voor dat de back toest verdwijnd zodra op back geklikt wordt
     */
    private fun onBackStackChangedListener() {
        //indien je op initieel fragment zit geen back knop tonen
        if (supportFragmentManager.backStackEntryCount <= 1) {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        } else supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * methode voor de *bottom navigation* in de gaten te houden.
     *
     * zorgt er voor dat bij het selecteren van een bottom navigation item gecontroleerd wordt of
     */
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        //indien zelfde nav item geselecteerd als het reeds is, doe niets.
        //vermijd loops en spam clicks
        if (FragmentUtil.checkFragmentEqualsNavItem(
                this,
                item,
                supportFragmentManager
            )
        ) return@OnNavigationItemSelectedListener true

        //afhankelijk van geselecteerde nav item actie uitvoeren
        when (item.itemId) {
            R.id.nav_meetings -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, MeetinglijstFragment())
                    .addToBackStack(getString(R.string.fragtag_meetinglist))
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_favorieten -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, FavorietenlijstFragment())
                    .addToBackStack(getString(R.string.fragtag_favouriteslist))
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_account -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, AccountFragment())
                    .addToBackStack(getString(R.string.fragtag_account))
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false
    }
}
