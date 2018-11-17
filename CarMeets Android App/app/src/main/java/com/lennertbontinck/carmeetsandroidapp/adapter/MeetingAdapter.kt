package com.lennertbontinck.carmeetsandroidapp.adapter

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.fragments.MeetingDetailFragment
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import kotlinx.android.synthetic.main.item_meeting_klein.view.*

class MeetingAdapter(
    private val parentActivity: MainActivity, private val lijst: List<Meeting>, private val lijstDesgin: String, val isTablet : Boolean
) :
    RecyclerView.Adapter<MeetingAdapter.ViewHolder>() {

    //click listener wanneer bepaalde item van lijst geslecteerd wordt
    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            //geselecteerde meeting meegeven aan detail pagina als parcable tag
            val item = v.tag as Meeting
            val detailFragment = MeetingDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MeetingDetailFragment.ARG_MEETING_TAG, item)
                }
            }

            //indien tablet moet het in in de voorziene detailframe binnen de fragment
            //anders gewoon naar de mainactivity zijn container
            if (isTablet){
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_meetinglijst_meetingdetailcontainer, detailFragment)
                    .commit()
            }
            else {
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, detailFragment)
                    .addToBackStack(parentActivity.getString(R.string.fragtag_meetingdetail))
                    .commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //default een kleine lijstDesign
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meeting_klein, parent, false)

        //kijken of ander, kon bool maar indien er nog derde design komt beter string en onderstaand
        when (lijstDesgin) {
            "groot" -> view = LayoutInflater.from(parent.context).inflate(R.layout.item_meeting_groot, parent, false)
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lijst[position]
        Glide.with(parentActivity).load(item.afbeeldingNaam).into(holder.afbeelding)
        holder.titel.text = item.titel
        holder.subtitel.text = item.subtitel
        holder.locatie.text = item.postcode + ", " + item.gemeente

        with(holder.itemView) {
            //item instellen als tag en clicklistener instellen die deze tag meegeeft aan detail
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = lijst.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val afbeelding: ImageView = view.image_itemmeeting
        val titel: TextView = view.text_itemmeeting_titel
        val subtitel: TextView = view.text_itemmeeting_subtitel
        val locatie: TextView = view.text_itemmeeting_locatie
    }
}
