package com.lennertbontinck.carmeetsandroidapp.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.databinding.ActivityMainBinding
import com.lennertbontinck.carmeetsandroidapp.enums.ListDesignEnum
import com.lennertbontinck.carmeetsandroidapp.fragments.AccountFragment
import com.lennertbontinck.carmeetsandroidapp.fragments.FavouritesListFragment
import com.lennertbontinck.carmeetsandroidapp.fragments.MeetinglistFragment
import com.lennertbontinck.carmeetsandroidapp.utils.FragmentUtil
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * De *mainactivity* van de applicatie. Er is maar 1 activity doorheen de app.
 */
class MainActivity : AppCompatActivity() {

    /**
     * [MeetingViewModel] met de data over alle meetings
     */
    private lateinit var meetingViewModel: MeetingViewModel

    /**
     * [GuiViewModel] met de data over de GUI instellingen
     */
    private lateinit var guiViewModel: GuiViewModel

    /**
     * De [ActivityMainBinding] dat we gebruiken voor de effeciteve databinding
     */
    private lateinit var binding: ActivityMainBinding

    /**
     * [Boolean] of backknop al dan niet al is ingedrukt.
     */
    private var backClickedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        //bij het laden van de app de mainactivity instellen
        super.onCreate(savedInstanceState)

        //de viewmodels instantieren
        meetingViewModel = ViewModelProviders.of(this).get(MeetingViewModel::class.java)
        guiViewModel = ViewModelProviders.of(this).get(GuiViewModel::class.java)

        //main activity binden
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.guiViewModel = guiViewModel
        binding.setLifecycleOwner(this)

        //supportbar instellen zodat hij menu_toolbar gebruikt
        setSupportActionBar(menu_main_toolbar)

        //initieel wordt meetinglijst weergegeven
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main_fragmentcontainer, MeetinglistFragment())
            .addToBackStack(getString(R.string.fragtag_meetinglist))
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menu van de menu_toolbar instellen
        menuInflater.inflate(R.menu.menu_toolbar, menu)

        //listener voor het klikken op noticaties uit de actionbar
        val notifications = menu?.findItem(R.id.nav_notifications)?.actionView
        notifications?.findViewById<ImageView>(R.id.image_partialnotification_bell)
            ?.setOnClickListener { notificationsClicked() }
        notifications?.findViewById<TextView>(R.id.text_partialnotification_amount)
            ?.setOnClickListener { notificationsClicked() }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //het item dat gelklikt is uit de menu_toolbar
        //dit id moet in theorie altijd ingevuld zijn want enkel dan weet je wat aangeduid en kan je bijhorende actie uitvoeren
        when (item?.itemId) {
            R.id.nav_notifications -> {
                notificationsClicked()
                return super.onOptionsItemSelected(item)
            }

            R.id.nav_search -> {
                MessageUtil.showToast("Er is op zoeken geklikt")
                return super.onOptionsItemSelected(item)
            }

            R.id.ab_options_small -> {
                guiViewModel.listDesign.value = ListDesignEnum.SMALL
                return super.onOptionsItemSelected(item)
            }

            R.id.ab_options_big -> {
                guiViewModel.listDesign.value = ListDesignEnum.BIG
                return super.onOptionsItemSelected(item)
            }

            //default
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //fysieke back button ingedruk
    override fun onBackPressed() {
        if (guiViewModel.isBackButtonVisible.value!!)
            super.onBackPressed()
        else if (backClickedOnce) {
                finish()
                return
            }
        else {
            backClickedOnce = true
            MessageUtil.showToast(getString(R.string.question_exit_app), Toast.LENGTH_SHORT)
            //indien binnen de 2 sec niet nogmaals geklikt
            Handler().postDelayed({ backClickedOnce = false }, 2000)
        }






    }

    /**
     * *POC* functie dat toont dat je een onclick van notificatiebel kan vastleggen en dat je het aantal kan aanpassen.
     *
     * Verhoogt het aantal naast het notificatie icoon met 1 per klik.
     */
    private fun notificationsClicked() {
        val notificationAmount = menu_main_toolbar.menu.findItem(R.id.nav_notifications)
            ?.actionView?.findViewById<TextView>(R.id.text_partialnotification_amount)

        notificationAmount?.text = (notificationAmount?.text.toString().toInt() + 1).toString()
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
                item,
                supportFragmentManager
            )
        ) return@OnNavigationItemSelectedListener true

        //afhankelijk van geselecteerde nav item actie uitvoeren
        when (item.itemId) {
            R.id.nav_meetings -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, MeetinglistFragment())
                    .addToBackStack(getString(R.string.fragtag_meetinglist))
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_favourites -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, FavouritesListFragment())
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

    /**
     * Functie voor het instantiëren van de listeners.
     */
    private fun initListeners() {
        //listener op de bottomnav
        menu_main_bottomnavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        //listener wanneer back button uit de menu_toolbar -> zelfde functie als hardware back button
        menu_main_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        guiViewModel.isListDesignOptionsVisible.observe(this, Observer {
            LayoutUtil.setListDesignOptionsVisibiltiy(this, guiViewModel.isListDesignOptionsVisible.value!!)
        })

        guiViewModel.activeMenuItem.observe(this, Observer {
            LayoutUtil.setBottomNavigation(this, guiViewModel.activeMenuItem.value!!.menuId)
        })

        guiViewModel.isBackButtonVisible.observe(this, Observer {
            supportActionBar?.setDisplayHomeAsUpEnabled(guiViewModel.isBackButtonVisible.value!!)
        })
    }

    /**
     * Functie voor het stoppen van de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        //listener op de bottomnav
        menu_main_bottomnavigation.setOnNavigationItemSelectedListener(null)

        //listener wanneer back button uit de menu_toolbar -> zelfde functie als hardware back button
        menu_main_toolbar.setNavigationOnClickListener { null }

        guiViewModel.isListDesignOptionsVisible.removeObservers(this)

        guiViewModel.activeMenuItem.removeObservers(this)

        guiViewModel.isBackButtonVisible.removeObservers(this)
    }

    override fun onStart() {
        super.onStart()
        initListeners()
    }

    override fun onStop() {
        super.onStop()
        stopListeners()
    }
}
