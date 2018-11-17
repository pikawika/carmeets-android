package com.lennertbontinck.carmeetsandroidapp.utils


import android.support.v7.app.AppCompatActivity
import com.lennertbontinck.carmeetsandroidapp.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Een util om je te helpen met het instellen van de *layout*
 */
object LayoutUtil {

    /**
     * Stelt de actionbar zijn titel en subtitel in, of de listlayoutopties al dan niet zichtbaar zijn en stel de selected bottomnav in
     *
     * @param[parentActivity] De parentactivity waarin de actionbar zicht bevind. Required of type AppCompatActivity
     *
     * @param[titel] De titel die in de actionbar moet komen. Required of type String
     *
     * @param[subtitel] De titel die in de actionbar moet komen. Required of type String
     *
     * @param[listLayoutOptiesVisible] Of layoutopties voor de lijst al dan niet moeten weergegeven worden. Required of type Boolean
     *
     * @param[bottomNavId] De id van het menuitem dat geselecteerd moet zijn in de bottomnavigation. Required of type Int
     *
     */
    @JvmStatic
    fun setMainLayout(parentActivity: AppCompatActivity, titel : String, subtitel : String, listLayoutOptiesVisible: Boolean, bottomNavId: Int) {
        parentActivity.supportActionBar?.title =  titel
        parentActivity.supportActionBar?.subtitle = subtitel

        parentActivity.menu_main_toolbar.menu.findItem(R.id.ab_opties_klein)?.isVisible = listLayoutOptiesVisible
        parentActivity.menu_main_toolbar.menu.findItem(R.id.ab_opties_groot)?.isVisible = listLayoutOptiesVisible

        if (parentActivity.menu_main_bottomnavigation.selectedItemId != bottomNavId) {
            parentActivity.menu_main_bottomnavigation.selectedItemId = bottomNavId
        }
    }

    /**
     * Stelt de actionbar zijn titel en subtitel in
     *
     * @param[parentActivity] De parentactivity waarin de actionbar zicht bevind. Required of type AppCompatActivity
     *
     * @param[titel] De titel die in de actionbar moet komen. Required of type String
     *
     * @param[subtitel] De titel die in de actionbar moet komen. Required of type String
     *
     */
    @JvmStatic
    fun setActionBar(parentActivity: AppCompatActivity, titel : String, subtitel : String) {
        parentActivity.supportActionBar?.title =  titel
        parentActivity.supportActionBar?.subtitle = subtitel
    }
}