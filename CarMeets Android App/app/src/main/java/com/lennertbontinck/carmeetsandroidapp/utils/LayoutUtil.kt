package com.lennertbontinck.carmeetsandroidapp.utils


import android.support.v7.app.AppCompatActivity
import com.lennertbontinck.carmeetsandroidapp.R
import kotlinx.android.synthetic.main.activity_main.*

object LayoutUtil {

    @JvmStatic
    fun setMainLayout(parentActivity: AppCompatActivity, titel : String, subtitel : String, listLayoutOptiesVisible: Boolean, bottomNavId: Int) {
        parentActivity.supportActionBar?.title =  titel
        parentActivity.supportActionBar?.subtitle = subtitel

        parentActivity.toolbar.menu.findItem(R.id.ab_opties_klein)?.isVisible = listLayoutOptiesVisible
        parentActivity.toolbar.menu.findItem(R.id.ab_opties_groot)?.isVisible = listLayoutOptiesVisible

        if (parentActivity.bottom_navigation.selectedItemId != bottomNavId) {
            parentActivity.bottom_navigation.selectedItemId = bottomNavId
        }
    }

    @JvmStatic
    fun setActionBar(parentActivity: AppCompatActivity, titel : String, subtitel : String) {
        parentActivity.supportActionBar?.title =  titel
        parentActivity.supportActionBar?.subtitle = subtitel
    }
}