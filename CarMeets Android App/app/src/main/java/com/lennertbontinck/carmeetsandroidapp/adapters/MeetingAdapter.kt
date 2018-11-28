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
import com.lennertbontinck.carmeetsandroidapp.enums.LijstDesignEnum
import com.lennertbontinck.carmeetsandroidapp.fragments.MeetingDetailFragment
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import kotlinx.android.synthetic.main.item_meeting_small.view.*

/**
 * De *adapter* voor een het vullen van een recyclerview met een meegegeven lijst van meetings ahdv een meegegeven stijl. Al dan niet een twopane design.
 *
 * @param[parentActivity] De parentactivity waarin de supportfragmentmanager zit en dat gebruikt wordt voor glide. Required of type AppCompatActivity
 *
 * @param[lijst] De lijst van meetings die de adapter moet verwerken. Required of type MutableLiveData<List<Meeting>>
 *
 * @param[lijstDesginEnum] De stijl waarin de lijst weergegeven moet worden. Required of enum type LijstDesignEnum
 *
 * @param[isTablet] Of de layout al dan niet tablet is (TwoPane). Required of type Boolean
 */
class MeetingAdapter(
    private val parentActivity: AppCompatActivity,
    private val lijst: MutableLiveData<List<Meeting>>,
    private val lijstDesginEnum: MutableLiveData<LijstDesignEnum>,
    private val isTablet: Boolean
) :
    RecyclerView.Adapter<MeetingAdapter.ViewHolder>() {

    //click listener wanneer bepaalde item van lijst geslecteerd wordt
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
                    .replace(R.id.frame_meetinglijst_meetingdetailcontainer, detailFragment)
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
            .inflate(lijstDesginEnum.value!!.layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lijst.value!![position]
        Glide.with(parentActivity).load(IMG_URL_BACKEND + item.afbeeldingNaam).into(holder.afbeelding)
        holder.titel.text = item.title
        holder.subtitel.text = item.subtitle
        val locatie = item.postcode + ", " + item.gemeente
        holder.locatie.text = locatie

        with(holder.itemView) {
            //item instellen als tag en clicklistener instellen die deze tag meegeeft aan detail
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = lijst.value!!.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val afbeelding: ImageView = view.image_itemmeeting
        val titel: TextView = view.text_itemmeeting_titel
        val subtitel: TextView = view.text_itemmeeting_subtitel
        val locatie: TextView = view.text_itemmeeting_locatie
    }
}
