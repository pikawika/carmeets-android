package com.lennertbontinck.carmeetsandroidapp.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import com.lennertbontinck.carmeetsandroidapp.enums.ListDesignEnum
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum

class GuiViewModel : ViewModel() {
    /**
     * De titel die in de actionbar moet ingesteld worden.
     */
    val actionBarTitle = MutableLiveData<String>()

    /**
     * De subtitel die in de actionbar moet ingesteld worden.
     */
    val actionBarSubTitle = MutableLiveData<String>()

    /**
     * Of de backbutton al dan niet moet zichtbaar zijn
     */
    val isBackButtonVisible = MutableLiveData<Boolean>()

    /**
     * Of de huidige omgeving al dan niet two pane is
     */
    val isTwoPaneEnvironment = MutableLiveData<Boolean>()

    /**
     * Of de huidige omgeving al dan niet two pane is
     */
    val isListDesignOptionsVisible = MutableLiveData<Boolean>()

    /**
     * Het huidige door de gebruiker geselecteerde design van lijstitems.
     */
    val listDesign = MutableLiveData<ListDesignEnum>()

    /**
     * Het huidige door de gebruiker geselecteerde menu item.
     */
    var activeMenuItem = MutableLiveData<MenuItemEnum>()
        private set

    init {
        //initieel is titel de app naam
        actionBarTitle.value = CarMeetsApplication.getContext().getString(R.string.app_name)
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
        actionBarTitle.value = CarMeetsApplication.getContext().getString(R.string.app_name)
        //initieel is subtitel leeg
        actionBarSubTitle.value = ""
        //initieel is backbutton niet zichtbaar
        isBackButtonVisible.value = false
        //initieel zijn de opties voor lijst design niet zichtbaar
        isListDesignOptionsVisible.value = false
    }
}