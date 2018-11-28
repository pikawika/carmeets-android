package com.lennertbontinck.carmeetsandroidapp.adapters

import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.constants.IMG_URL_BACKEND
import com.lennertbontinck.carmeetsandroidapp.enums.ListDesignEnum
import com.lennertbontinck.carmeetsandroidapp.fragments.MeetingDetailFragment
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import kotlinx.android.synthetic.main.item_meeting_small.view.*

/**
 * De *adapter* voor een het vullen van een recyclerview met een meegegeven list van meetings ahdv een meegegeven stijl. Al dan niet een twopane design.
 *
 * @param[parentActivity] De parentactivity waarin de supportfragmentmanager zit en dat gebruikt wordt voor glide. Required of type AppCompatActivity
 *
 * @param[list] De list van meetings die de adapter moet verwerken. Required of type MutableLiveData<List<Meeting>>
 *
 * @param[listDesignEnum] De stijl waarin de list weergegeven moet worden. Required of enum type ListDesignEnum
 *
 * @param[isTablet] Of de layout al dan niet tablet is (TwoPane). Required of type Boolean
 */
class MeetingAdapter(
    private val parentActivity: AppCompatActivity,
    private val list: MutableLiveData<List<Meeting>>,
    private val listDesignEnum: MutableLiveData<ListDesignEnum>,
    private val isTablet: Boolean
) :
    RecyclerView.Adapter<MeetingAdapter.ViewHolder>() {

    //click listener wanneer bepaalde item van list geslecteerd wordt
    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            //geselecteerde meeting meegeven aan detail pagina als parcable tag
            //istablet meegeven als boolean
            val item = v.tag as Meeting
            val detailFragment = MeetingDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MeetingDetailFragment.ARG_MEETING_TAG, item)
                    putBoolean(MeetingDetailFragment.IS_TABLET, isTablet)
                }
            }

            //indien tablet moet het in in de voorziene detailframe binnen de fragment
            //anders gewoon naar de mainactivity zijn container
            if (isTablet) {
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_meetinglist_meetingdetailcontainer, detailFragment)
                    .commit()
            } else {
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, detailFragment)
                    .addToBackStack(parentActivity.getString(R.string.fragtag_meetingdetail))
                    .commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Stelt de juiste lijstdesign in
        val view = LayoutInflater.from(parent.context)
            .inflate(listDesignEnum.value!!.layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list.value!![position]
        Glide.with(parentActivity).load(IMG_URL_BACKEND + item.afbeeldingNaam).into(holder.image)
        holder.title.text = item.title
        holder.subtitle.text = item.subtitle
        val location = item.postcode + ", " + item.gemeente
        holder.location.text = location

        with(holder.itemView) {
            //item instellen als tag en clicklistener instellen die deze tag meegeeft aan detail
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = list.value!!.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.image_itemmeeting
        val title: TextView = view.text_itemmeeting_title
        val subtitle: TextView = view.text_itemmeeting_subtitle
        val location: TextView = view.text_itemmeeting_location
    }
}
