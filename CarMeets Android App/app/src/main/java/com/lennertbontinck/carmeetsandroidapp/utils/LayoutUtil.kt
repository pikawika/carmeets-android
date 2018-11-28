package com.lennertbontinck.carmeetsandroidapp.utils


import android.support.v7.app.AppCompatActivity
import com.lennertbontinck.carmeetsandroidapp.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Een util om je te helpen met het instellen van de *layout*
 */
object LayoutUtil {
    /**
     * Stelt de actionbar zijn title en subtitle in
     *
     * @param[parentActivity] De parentactivity waarin de actionbar zicht bevind. Required of type AppCompatActivity
     *
     * @param[titel] De title die in de actionbar moet komen. Required of type String
     *
     * @param[subtitel] De title die in de actionbar moet komen. Required of type String
     *
     */
    @JvmStatic
    fun setActionBar(parentActivity: AppCompatActivity, titel : String, subtitel : String) {
        parentActivity.supportActionBar?.title =  titel
        parentActivity.supportActionBar?.subtitle = subtitel
    }

    /**
     * Stelt de bottom navigation in op het juiste item
     *
     * @param[parentActivity] De parentactivity waarin de actionbar zicht bevind. Required of type AppCompatActivity
     *
     * @param[bottomNavId] De id van het menuitem dat geselecteerd moet zijn in de bottomnavigation. Required of type Int
     *
     */
    @JvmStatic
    fun setBottomNavigation(parentActivity: AppCompatActivity, bottomNavId: Int) {
        if (parentActivity.menu_main_bottomnavigation.selectedItemId != bottomNavId) {
            parentActivity.menu_main_bottomnavigation.selectedItemId = bottomNavId
        }
    }

    /**
     * zet alle toolbar optionsmenu items op visble false
     */
    @JvmStatic
    fun clearActionBarOptions(parentActivity: AppCompatActivity) {
        parentActivity.menu_main_toolbar.menu.findItem(R.id.ab_options_small)?.isVisible = false
        parentActivity.menu_main_toolbar.menu.findItem(R.id.ab_options_big)?.isVisible = false
    }

    /**
     * zet de toolbar options menu items met betrekking tot de weergave opties van de lijst op visble true
     */
    @JvmStatic
    fun showListLayoutOpties(parentActivity: AppCompatActivity) {
        parentActivity.menu_main_toolbar.menu.findItem(R.id.ab_options_small)?.isVisible = true
        parentActivity.menu_main_toolbar.menu.findItem(R.id.ab_options_big)?.isVisible = true
    }
}