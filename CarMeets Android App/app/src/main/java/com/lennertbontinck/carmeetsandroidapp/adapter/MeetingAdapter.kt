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
import kotlinx.android.synthetic.main.item_meeting_groot.view.*

class MeetingAdapter(
    private val parentActivity: MainActivity, private val lijst: List<Meeting>, private val lijstDesgin: String, val isTablet : Boolean
) :
    RecyclerView.Adapter<MeetingAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as Meeting
            val detailFragment = MeetingDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MeetingDetailFragment.ARG_MEETING_TAG, item)
                }
            }

            if (isTablet){
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_meeting_detail, detailFragment)
                    .addToBackStack(parentActivity.getString(R.string.fragtag_meetingdetail))
                    .commit()
            }
            else {
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
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
        Glide.with(parentActivity).load(item.afbeeldingNaam).into(holder.afbeeldingView)
        holder.titelView.text = item.titel
        holder.subtitelView.text = item.subtitel
        holder.locatieView.text = item.postcode + ", " + item.gemeente

        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = lijst.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val afbeeldingView: ImageView = view.item_meeting_afbeelding
        val titelView: TextView = view.item_meeting_titel
        val subtitelView: TextView = view.item_meeting_subtitel
        val locatieView: TextView = view.item_meeting_locatie
    }
}
