package com.lennertbontinck.carmeetsandroidapp.adapters

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.constants.IMG_URL_BACKEND
import com.lennertbontinck.carmeetsandroidapp.fragments.MeetingDetailFragment
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.LocationUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.item_meeting_small.view.*

/**
 * De *adapter* voor een het vullen van een recyclerview met een meegegeven list van meetings ahdv een meegegeven stijl. Al dan niet een twopane design.
 *
 * @param[parentActivity] De parentactivity waarin de supportfragmentmanager zit en dat gebruikt wordt voor glide. Required of type AppCompatActivity
 */
class MeetingAdapter(private val parentActivity: AppCompatActivity) :
    RecyclerView.Adapter<MeetingAdapter.ViewHolder>() {

    /**
     * [MeetingViewModel] met de data over account
     */
    //Globaal ter beschikking gesteld aangezien het mogeiljks later nog in andere functie dan onCreateView wenst te worden
    private var meetingViewModel: MeetingViewModel = ViewModelProviders.of(parentActivity).get(MeetingViewModel::class.java)


    //click listener wanneer bepaalde item van list geslecteerd wordt
    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            //selected meeting instellen in vm
            val selectedMeeting = v.tag as Meeting
            meetingViewModel.setSelectedMeeting(selectedMeeting.meetingId)

            //indien tablet moet het in in de voorziene detailframe binnen de fragment
            //anders gewoon naar de mainactivity zijn container
            if (meetingViewModel.getIsTwoPane().value!!) {
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_meetinglist_meetingdetailcontainer, MeetingDetailFragment())
                    .commit()
            } else {
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, MeetingDetailFragment())
                    .addToBackStack(parentActivity.getString(R.string.fragtag_meetingdetail))
                    .commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Stelt de juiste lijstdesign in
        val view = LayoutInflater.from(MainActivity.getContext())
            .inflate(meetingViewModel.listDesign.value!!.layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = meetingViewModel.getMeetings().value!![position]
        Glide.with(parentActivity).load(IMG_URL_BACKEND + item.imageName).into(holder.image)
        holder.title.text = item.title
        holder.subtitle.text = item.subtitle
        holder.location.text = LocationUtil.getCityNotation(item.location)

        with(holder.itemView) {
            //item instellen als tag en clicklistener instellen die deze tag meegeeft aan detail
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = meetingViewModel.getMeetings().value!!.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.image_itemmeeting
        val title: TextView = view.text_itemmeeting_title
        val subtitle: TextView = view.text_itemmeeting_subtitle
        val location: TextView = view.text_itemmeeting_location
    }
}
