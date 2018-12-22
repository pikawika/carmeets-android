package com.lennertbontinck.carmeetsandroidapp.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.context.App
import com.lennertbontinck.carmeetsandroidapp.enums.ListDesignEnum
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum

class GuiViewModel : ViewModel() {
    /**
     * De titel die in de actionbar moet ingesteld worden.
     */
    var actionBarTitle = MutableLiveData<String>()
        private set

    /**
     * De subtitel die in de actionbar moet ingesteld worden.
     */
    var actionBarSubTitle = MutableLiveData<String>()
        private set

    /**
     * Of de backbutton al dan niet moet zichtbaar zijn
     */
    var isBackButtonVisible = MutableLiveData<Boolean>()
        private set

    /**
     * Of de huidige omgeving al dan niet two pane is
     */
    var isTwoPaneEnvironment = MutableLiveData<Boolean>()
        private set

    /**
     * Of de huidige omgeving al dan niet two pane is
     */
    var isListDesignOptionsVisible = MutableLiveData<Boolean>()
        private set

    /**
     * Het huidige door de gebruiker geselecteerde design van lijstitems.
     */
    var listDesign = MutableLiveData<ListDesignEnum>()
        private set

    /**
     * Het huidige door de gebruiker geselecteerde menu item.
     */
    var activeMenuItem = MutableLiveData<MenuItemEnum>()
        private set

    init {
        //initieel is titel de app naam
        actionBarTitle.value = App.getContext().getString(R.string.app_name)
        //initieel is subtitel leeg
        actionBarSubTitle.value = ""
        //initieel is backbutton niet zichtbaar
        isBackButtonVisible.value = false
        //initieel is omgeving niet two pane
        isTwoPaneEnvironment.value = false
        //initieel zijn de opties voor lijst design niet zichtbaar
        isListDesignOptionsVisible.value = false
        //initieel is layout klein
        listDesign.value = ListDesignEnum.SMALL
        //initieel is actieve menu item de lijst van meetings
        activeMenuItem.value = MenuItemEnum.MEETINGS
    }

    fun resetLayout() {
        //initieel is titel de app naam
        actionBarTitle.value = App.getContext().getString(R.string.app_name)
        //initieel is subtitel leeg
        actionBarSubTitle.value = ""
        //initieel is backbutton niet zichtbaar
        isBackButtonVisible.value = false
        //initieel zijn de opties voor lijst design niet zichtbaar
        isListDesignOptionsVisible.value = false
        //initieel is omgeving niet two pane
        isTwoPaneEnvironment.value = false
    }
}