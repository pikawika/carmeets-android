package com.lennertbontinck.carmeetsandroidapp.utils


import android.support.v7.app.AppCompatActivity
import com.lennertbontinck.carmeetsandroidapp.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Een util om je te helpen met het instellen van de *layout*
 */
object LayoutUtil {
    /**
     * Stelt de bottom navigation in op het gewenste item
     *
     * @param parentActivity : de parentactivity waarin de actionbar zicht bevind. Required of type [AppCompatActivity].
     *
     * @param bottomNavId : de id van het menuitem dat geselecteerd moet zijn in de bottomnavigation. Required of type [Int].
     *
     */
    @JvmStatic
    fun setBottomNavigation(parentActivity: AppCompatActivity, bottomNavId: Int) {
        //Indien niets in backstack mag het aangepast worden zodat listener de juiste fragment laad.
        if (parentActivity.menu_main_bottomnavigation.selectedItemId != bottomNavId
            || parentActivity.supportFragmentManager.backStackEntryCount <= 1
        ) {
            parentActivity.menu_main_bottomnavigation.selectedItemId = bottomNavId
        }
    }

    /**
     * zet de toolbar options menu items met betrekking tot de weergave opties van de lijst in
     *
     * @param parentActivity : de parentactivity waarin de actionbar zicht bevind. Required of type [AppCompatActivity].
     *
     * @param isVisible : of de items al dan niet moeten zichtbaar zijn. Required of type [Boolean]
     */
    @JvmStatic
    fun setListDesignOptionsVisibiltiy(parentActivity: AppCompatActivity, isVisible: Boolean) {
        parentActivity.menu_main_toolbar.menu.findItem(R.id.ab_options_big)?.isVisible = isVisible
        parentActivity.menu_main_toolbar.menu.findItem(R.id.ab_options_small)?.isVisible = isVisible
    }
}