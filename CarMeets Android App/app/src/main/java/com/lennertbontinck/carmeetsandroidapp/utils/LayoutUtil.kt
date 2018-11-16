package com.lennertbontinck.carmeetsandroidapp.utils


import android.support.v7.app.AppCompatActivity
import com.lennertbontinck.carmeetsandroidapp.R
import kotlinx.android.synthetic.main.activity_main.*

object LayoutUtil {

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

    @JvmStatic
    fun setActionBar(parentActivity: AppCompatActivity, titel : String, subtitel : String) {
        parentActivity.supportActionBar?.title =  titel
        parentActivity.supportActionBar?.subtitle = subtitel
    }
}