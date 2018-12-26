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
import com.lennertbontinck.carmeetsandroidapp.constants.FRAGTAG_ACCOUNT
import com.lennertbontinck.carmeetsandroidapp.constants.FRAGTAG_FAVOURITES_LIST
import com.lennertbontinck.carmeetsandroidapp.constants.FRAGTAG_MEETING_LIST
import com.lennertbontinck.carmeetsandroidapp.databinding.ActivityMainBinding
import com.lennertbontinck.carmeetsandroidapp.enums.ListDesignEnum
import com.lennertbontinck.carmeetsandroidapp.fragments.AccountFragment
import com.lennertbontinck.carmeetsandroidapp.fragments.FavouritesListFragment
import com.lennertbontinck.carmeetsandroidapp.fragments.MeetinglistFragment
import com.lennertbontinck.carmeetsandroidapp.utils.FragmentUtil
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.partial_empty_list.*
import kotlinx.android.synthetic.main.partial_error_with_show_cache.*

/**
 * De *mainactivity* van de applicatie. Er is maar 1 activity doorheen de app.
 */
class MainActivity : AppCompatActivity() {

    /**
     * [MeetingViewModel] met de data over alle meetings
     */
    private lateinit var meetingViewModel: MeetingViewModel

    /**
     * [AccountViewModel] met de data over account
     */
    private lateinit var accountViewModel: AccountViewModel

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
        super.onCreate(savedInstanceState)

        //de viewmodels instantieren
        meetingViewModel = ViewModelProviders.of(this).get(MeetingViewModel::class.java)
        guiViewModel = ViewModelProviders.of(this).get(GuiViewModel::class.java)
        accountViewModel = ViewModelProviders.of(this).get(AccountViewModel::class.java)

        //main activity binden
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.guiViewModel = guiViewModel
        binding.meetingViewModel = meetingViewModel
        binding.accountViewModel = accountViewModel
        binding.setLifecycleOwner(this)

        //supportbar instellen zodat hij menu_toolbar gebruikt
        setSupportActionBar(menu_main_toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menu van de menu_toolbar instellen
        menuInflater.inflate(R.menu.menu_toolbar, menu)

        updateNotificationAmount()

        //listener voor het klikken op noticaties uit de actionbar
        //we kunnen niet onOptionsItemSelected gebruiken aangezien deze een click op de actionLayout niet registreerd.
        //We kunnen dit niet instantieren bij onstart aangezien de onCreateOptionsMenu nog na de onstart wordt uitgvoerd
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
        return when (item?.itemId) {
            R.id.ab_options_big -> {
                guiViewModel.listDesign.value = ListDesignEnum.BIG
                super.onOptionsItemSelected(item)
            }

            R.id.ab_options_small -> {
                guiViewModel.listDesign.value = ListDesignEnum.SMALL
                super.onOptionsItemSelected(item)
            }

            //default
            else -> super.onOptionsItemSelected(item)
        }
    }

    //fysieke back button ingedruk
    override fun onBackPressed() {
        when {
            //gebruiker mag teruggaan dus popt backstack
            guiViewModel.isBackButtonVisible.value!! -> super.onBackPressed()
            //gebruiker wilt app sluiten en heeft dat bevestigd
            backClickedOnce -> {
                finish()
            }
            //gebruiker wilt app sluiten, er wordt om bevestiging gevraagd
            else -> {
                backClickedOnce = true
                MessageUtil.showToast(getString(R.string.question_exit_app), Toast.LENGTH_SHORT)
                //indien binnen de 2 sec niet nogmaals geklikt
                Handler().postDelayed({ backClickedOnce = false }, 2000)
            }
        }
    }

    /**
     * *POC* functie dat toont dat je een onclick van notificatiebel kan vastleggen en dat je het aantal kan aanpassen.
     *
     * Verhoogt het aantal naast het notificatie icoon met 1 per klik.
     */
    private fun notificationsClicked() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main_fragmentcontainer, FavouritesListFragment())
            .addToBackStack(FRAGTAG_FAVOURITES_LIST)
            .commit()
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
                    .addToBackStack(FRAGTAG_MEETING_LIST)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_favourites -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, FavouritesListFragment())
                    .addToBackStack(FRAGTAG_FAVOURITES_LIST)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_account -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, AccountFragment())
                    .addToBackStack(FRAGTAG_ACCOUNT)
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

        btn_partial_error_with_show_cache_show_cache.setOnClickListener {
            meetingViewModel.isLocalRoomDatabaseUsedAsSource.value = true
            meetingViewModel.isErrorPageWithRoomOptionVisible.value = false
        }

        btn_partial_error_with_show_cache_try_again.setOnClickListener {
            meetingViewModel.refreshMeetingList()
            meetingViewModel.isErrorPageWithRoomOptionVisible.value = false
        }

        btn_partial_empty_list_refresh.setOnClickListener {
            meetingViewModel.refreshMeetingList()
            guiViewModel.isEmptyListVisible.value = false
        }

        guiViewModel.isListDesignOptionsVisible.observe(this, Observer {
            LayoutUtil.setListDesignOptionsVisibiltiy(this, guiViewModel.isListDesignOptionsVisible.value!!)
        })

        guiViewModel.isBackButtonVisible.observe(this, Observer {
            supportActionBar?.setDisplayHomeAsUpEnabled(guiViewModel.isBackButtonVisible.value!!)
        })

        //Bij de init van de viewmodel wordt deze waarde ingesteld uit de shared pref
        //En opent dus de pagina die door de gebruiker ingesteld is als default boot page
        guiViewModel.activeMenuItem.observe(this, Observer {
            LayoutUtil.setBottomNavigation(this, guiViewModel.activeMenuItem.value!!.menuId)
        })

        //indien meetinglijst update moet je notificatiehoeveelheid opnieuw bepalen
        meetingViewModel.meetingList.observe(this, Observer {
            updateNotificationAmount()
        })

        //indien afgemeld/aangemeld opnieuw notificatie aantal bepalen
        accountViewModel.isLoggedIn.observe(this, Observer {
            updateNotificationAmount()
        })

        //indien de room items ingeladen zijn en er is voor gekozen de lokale room items te gebruiken als bron
        //stel deze dan in als bron!
        meetingViewModel.roomMeetingList.observe(this, Observer {
            if (meetingViewModel.roomMeetingList.value != null && meetingViewModel.isLocalRoomDatabaseUsedAsSource.value!!) {
                meetingViewModel.meetingList.value = meetingViewModel.roomMeetingList.value
            }
        })

        //indien gekozen voor room als meeting items kijken of de lijst niet null is en ze toekennen
        meetingViewModel.isLocalRoomDatabaseUsedAsSource.observe(this, Observer {
            if (meetingViewModel.roomMeetingList.value != null && meetingViewModel.isLocalRoomDatabaseUsedAsSource.value!!) {
                meetingViewModel.meetingList.value = meetingViewModel.roomMeetingList.value
            }
        })
    }

    /**
     * Synct de notification amount uit de [MeetingViewModel.getLikedGoingAmountNext7Days] met die uit de actionbar.
     *
     * Dit kan niet gebind worden aangezien kotlin nog niet ondersteund om menu items te databinden.
     */
    private fun updateNotificationAmount() {
        val notificationAmount = menu_main_toolbar.menu.findItem(R.id.nav_notifications)
            ?.actionView?.findViewById<TextView>(R.id.text_partialnotification_amount)

        notificationAmount?.text = meetingViewModel.getLikedGoingAmountNext7Days().toString()
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

        btn_partial_error_with_show_cache_show_cache.setOnClickListener { null }

        btn_partial_error_with_show_cache_try_again.setOnClickListener { null }

        btn_partial_empty_list_refresh.setOnClickListener { null }

        guiViewModel.isListDesignOptionsVisible.removeObservers(this)

        guiViewModel.activeMenuItem.removeObservers(this)

        guiViewModel.isBackButtonVisible.removeObservers(this)

        meetingViewModel.meetingList.removeObservers(this)

        accountViewModel.isLoggedIn.removeObservers(this)

        meetingViewModel.roomMeetingList.removeObservers(this)

        meetingViewModel.isLocalRoomDatabaseUsedAsSource.removeObservers(this)
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
