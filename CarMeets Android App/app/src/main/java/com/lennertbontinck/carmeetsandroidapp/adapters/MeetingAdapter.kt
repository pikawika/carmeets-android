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
import com.lennertbontinck.carmeetsandroidapp.constants.BASE_URL_BACKEND_IMAGES
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import com.lennertbontinck.carmeetsandroidapp.fragments.MeetingDetailFragment
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.LocationUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.item_meeting_small.view.*

/**
 * [RecyclerView.Adapter] voor het vullen van een recyclerview met meeting items. Gebruikt hiervoor de
 * [MeetingViewModel.meetingList] en [GuiViewModel.listDesign] ingesteld in de [MeetingViewModel].
 *
 * @param parentActivity : de actieve activity. Required of type AppCompatActivity.
 */
class MeetingAdapter(private val parentActivity: AppCompatActivity) :
    RecyclerView.Adapter<MeetingAdapter.ViewHolder>() {

    /**
     * [MeetingViewModel] met de data over alle meetings
     */
    private var meetingViewModel: MeetingViewModel =
        ViewModelProviders.of(parentActivity).get(MeetingViewModel::class.java)

    /**
     * [GuiViewModel] met de data over de GUI instellingen
     */
    private var guiViewModel: GuiViewModel = ViewModelProviders.of(parentActivity).get(GuiViewModel::class.java)


    //click listener wanneer bepaalde item van list geslecteerd wordt
    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            //selected meeting instellen in vm
            val selectedMeeting = v.tag as Meeting
            meetingViewModel.setSelectedMeeting(selectedMeeting.meetingId)

            //indien tablet moet het in in de voorziene detailframe binnen de fragment
            //anders gewoon naar de mainactivity zijn container
            if (guiViewModel.isTwoPaneEnvironment.value!!) {
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_meetinglist_meetingdetailcontainer, MeetingDetailFragment())
                    .addToBackStack(parentActivity.getString(R.string.fragtag_meetingdetail))
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
        val view = LayoutInflater.from(CarMeetsApplication.getContext())
            .inflate(guiViewModel.listDesign.value!!.layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = meetingViewModel.meetingList.value!![position]
        Glide.with(parentActivity).load(BASE_URL_BACKEND_IMAGES + item.imageName).into(holder.image)
        holder.title.text = item.title
        holder.subtitle.text = item.subtitle
        holder.location.text = LocationUtil.getCityNotation(item.location)

        with(holder.itemView) {
            //item instellen als tag en clicklistener instellen die deze tag meegeeft aan detail
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = meetingViewModel.meetingList.value!!.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.image_itemmeeting
        val title: TextView = view.text_itemmeeting_title
        val subtitle: TextView = view.text_itemmeeting_subtitle
        val location: TextView = view.text_itemmeeting_location
    }
}
