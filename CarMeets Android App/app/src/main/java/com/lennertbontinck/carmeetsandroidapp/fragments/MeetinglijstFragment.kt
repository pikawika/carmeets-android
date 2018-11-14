package com.lennertbontinck.carmeetsandroidapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.adapter.MeetingAdapter
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import kotlinx.android.synthetic.main.fragment_meetinglijst.view.*
import java.sql.Date
import java.util.*

class MeetinglijstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_meetinglijst, container, false)

        val meetings = dummyDataMeetingLijst()

        var lijstDesgin = "klein"

        //set action bar and bottom nav bar
        var parentActivity = (activity as AppCompatActivity)
        LayoutUtil.setMainLayout(parentActivity, getString(R.string.ab_meetings_titel), getString(R.string.ab_meetings_subtitel), true, R.id.nav_meetings)

        when (arguments?.getString("lijstDesgin")) {
            "groot" -> lijstDesgin = "groot"
        }

        rootView.meeting_lijst.adapter = MeetingAdapter(this.requireActivity() as MainActivity, meetings, lijstDesgin)

        return rootView
    }

    //TIJDELIJK: deze methode maakt dummy data aan om de recyclerview te vullen
    private fun dummyDataMeetingLijst(): List<Meeting> {
        return listOf(
            Meeting(
                meetingId = "5bbd254ba1468a0013f104c6",
                titel = "Meet the 106",
                subtitel = "Lennert's car is finally done!",
                beschrijving = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempus, enim eget gravida " +
                        "eleifend, enim nisl tempor sem, quis tempor libero quam eu nunc. Integer a egestas nibh. " +
                        "Suspendisse malesuada sollicitudin pretium. Class aptent taciti sociosqu ad litora torquent " +
                        "per conubia nostra, per inceptos himenaeos. Duis malesuada non nibh quis gravida. Donec in mi " +
                        "quis tortor pretium fringilla. Aenean vehicula ullamcorper elementum. Praesent pellentesque " +
                        "lacinia urna, ultrices fermentum leo luctus sed. Mauris at egestas nibh, in ultrices eros. " +
                        "Etiam interdum porta elementum. Mauris vitae sem elit. Sed convallis dolor ligula, sagittis " +
                        "volutpat est mattis a. Quisque finibus rhoncus eleifend. Duis sed justo eget lorem pharetra " +
                        "sagittis. Integer accumsan rutrum dolor, viverra mollis sapien semper volutpat.",
                categorien = listOf("French", "Daily", "Hatchbacks", "Lowered", "Sportcars", "Tuning"),
                gebruikerIdsGoing = listOf("5bba46fc491b8c00139709ee"),
                gebruikerIdsLiked = listOf(),
                datum = Date(2018, 12, 23),
                gemeente = "Schellebelle",
                postcode = "9260",
                straatnaam = "Dendermondsesteenweg",
                straatnr = "92",
                afbeeldingNaam = R.drawable.auto,
                site = "https://www.lennertbontinck.com/"

            ),
            Meeting(
                meetingId = "5bbd254ba1468a0013f104c6",
                titel = "Meet the 106",
                subtitel = "Lennert's car is finally done!",
                beschrijving = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempus, enim eget gravida " +
                        "eleifend, enim nisl tempor sem, quis tempor libero quam eu nunc. Integer a egestas nibh. " +
                        "Suspendisse malesuada sollicitudin pretium. Class aptent taciti sociosqu ad litora torquent " +
                        "per conubia nostra, per inceptos himenaeos. Duis malesuada non nibh quis gravida. Donec in mi " +
                        "quis tortor pretium fringilla. Aenean vehicula ullamcorper elementum. Praesent pellentesque " +
                        "lacinia urna, ultrices fermentum leo luctus sed. Mauris at egestas nibh, in ultrices eros. " +
                        "Etiam interdum porta elementum. Mauris vitae sem elit. Sed convallis dolor ligula, sagittis " +
                        "volutpat est mattis a. Quisque finibus rhoncus eleifend. Duis sed justo eget lorem pharetra " +
                        "sagittis. Integer accumsan rutrum dolor, viverra mollis sapien semper volutpat.",
                categorien = listOf("French", "Daily", "Hatchbacks", "Lowered", "Sportcars", "Tuning"),
                gebruikerIdsGoing = listOf("5bba46fc491b8c00139709ee"),
                gebruikerIdsLiked = listOf(),
                datum = Date(2018, 12, 23),
                gemeente = "Schellebelle",
                postcode = "9260",
                straatnaam = "Dendermondsesteenweg",
                straatnr = "92",
                afbeeldingNaam = R.drawable.auto,
                site = "https://www.lennertbontinck.com/"

            ),
            Meeting(
                meetingId = "5bbd254ba1468a0013f104c6",
                titel = "Meet the 106",
                subtitel = "Lennert's car is finally done!",
                beschrijving = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempus, enim eget gravida " +
                        "eleifend, enim nisl tempor sem, quis tempor libero quam eu nunc. Integer a egestas nibh. " +
                        "Suspendisse malesuada sollicitudin pretium. Class aptent taciti sociosqu ad litora torquent " +
                        "per conubia nostra, per inceptos himenaeos. Duis malesuada non nibh quis gravida. Donec in mi " +
                        "quis tortor pretium fringilla. Aenean vehicula ullamcorper elementum. Praesent pellentesque " +
                        "lacinia urna, ultrices fermentum leo luctus sed. Mauris at egestas nibh, in ultrices eros. " +
                        "Etiam interdum porta elementum. Mauris vitae sem elit. Sed convallis dolor ligula, sagittis " +
                        "volutpat est mattis a. Quisque finibus rhoncus eleifend. Duis sed justo eget lorem pharetra " +
                        "sagittis. Integer accumsan rutrum dolor, viverra mollis sapien semper volutpat.",
                categorien = listOf("French", "Daily", "Hatchbacks", "Lowered", "Sportcars", "Tuning"),
                gebruikerIdsGoing = listOf("5bba46fc491b8c00139709ee"),
                gebruikerIdsLiked = listOf(),
                datum = Date(2018, 12, 23),
                gemeente = "Schellebelle",
                postcode = "9260",
                straatnaam = "Dendermondsesteenweg",
                straatnr = "92",
                afbeeldingNaam = R.drawable.auto,
                site = "https://www.lennertbontinck.com/"

            ),
            Meeting(
                meetingId = "5bbd254ba1468a0013f104c6",
                titel = "Meet the 106",
                subtitel = "Lennert's car is finally done!",
                beschrijving = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempus, enim eget gravida " +
                        "eleifend, enim nisl tempor sem, quis tempor libero quam eu nunc. Integer a egestas nibh. " +
                        "Suspendisse malesuada sollicitudin pretium. Class aptent taciti sociosqu ad litora torquent " +
                        "per conubia nostra, per inceptos himenaeos. Duis malesuada non nibh quis gravida. Donec in mi " +
                        "quis tortor pretium fringilla. Aenean vehicula ullamcorper elementum. Praesent pellentesque " +
                        "lacinia urna, ultrices fermentum leo luctus sed. Mauris at egestas nibh, in ultrices eros. " +
                        "Etiam interdum porta elementum. Mauris vitae sem elit. Sed convallis dolor ligula, sagittis " +
                        "volutpat est mattis a. Quisque finibus rhoncus eleifend. Duis sed justo eget lorem pharetra " +
                        "sagittis. Integer accumsan rutrum dolor, viverra mollis sapien semper volutpat.",
                categorien = listOf("French", "Daily", "Hatchbacks", "Lowered", "Sportcars", "Tuning"),
                gebruikerIdsGoing = listOf("5bba46fc491b8c00139709ee"),
                gebruikerIdsLiked = listOf(),
                datum = Date(2018, 12, 23),
                gemeente = "Schellebelle",
                postcode = "9260",
                straatnaam = "Dendermondsesteenweg",
                straatnr = "92",
                afbeeldingNaam = R.drawable.auto,
                site = "https://www.lennertbontinck.com/"

            ),
            Meeting(
                meetingId = "5bbd254ba1468a0013f104c6",
                titel = "Meet the 106",
                subtitel = "Lennert's car is finally done!",
                beschrijving = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempus, enim eget gravida " +
                        "eleifend, enim nisl tempor sem, quis tempor libero quam eu nunc. Integer a egestas nibh. " +
                        "Suspendisse malesuada sollicitudin pretium. Class aptent taciti sociosqu ad litora torquent " +
                        "per conubia nostra, per inceptos himenaeos. Duis malesuada non nibh quis gravida. Donec in mi " +
                        "quis tortor pretium fringilla. Aenean vehicula ullamcorper elementum. Praesent pellentesque " +
                        "lacinia urna, ultrices fermentum leo luctus sed. Mauris at egestas nibh, in ultrices eros. " +
                        "Etiam interdum porta elementum. Mauris vitae sem elit. Sed convallis dolor ligula, sagittis " +
                        "volutpat est mattis a. Quisque finibus rhoncus eleifend. Duis sed justo eget lorem pharetra " +
                        "sagittis. Integer accumsan rutrum dolor, viverra mollis sapien semper volutpat.",
                categorien = listOf("French", "Daily", "Hatchbacks", "Lowered", "Sportcars", "Tuning"),
                gebruikerIdsGoing = listOf("5bba46fc491b8c00139709ee"),
                gebruikerIdsLiked = listOf(),
                datum = Date(2018, 12, 23),
                gemeente = "Schellebelle",
                postcode = "9260",
                straatnaam = "Dendermondsesteenweg",
                straatnr = "92",
                afbeeldingNaam = R.drawable.auto,
                site = "https://www.lennertbontinck.com/"

            ),
            Meeting(
                meetingId = "5bbd254ba1468a0013f104c6",
                titel = "Meet the 106",
                subtitel = "Lennert's car is finally done!",
                beschrijving = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempus, enim eget gravida " +
                        "eleifend, enim nisl tempor sem, quis tempor libero quam eu nunc. Integer a egestas nibh. " +
                        "Suspendisse malesuada sollicitudin pretium. Class aptent taciti sociosqu ad litora torquent " +
                        "per conubia nostra, per inceptos himenaeos. Duis malesuada non nibh quis gravida. Donec in mi " +
                        "quis tortor pretium fringilla. Aenean vehicula ullamcorper elementum. Praesent pellentesque " +
                        "lacinia urna, ultrices fermentum leo luctus sed. Mauris at egestas nibh, in ultrices eros. " +
                        "Etiam interdum porta elementum. Mauris vitae sem elit. Sed convallis dolor ligula, sagittis " +
                        "volutpat est mattis a. Quisque finibus rhoncus eleifend. Duis sed justo eget lorem pharetra " +
                        "sagittis. Integer accumsan rutrum dolor, viverra mollis sapien semper volutpat.",
                categorien = listOf("French", "Daily", "Hatchbacks", "Lowered", "Sportcars", "Tuning"),
                gebruikerIdsGoing = listOf("5bba46fc491b8c00139709ee"),
                gebruikerIdsLiked = listOf(),
                datum = Date(2018, 12, 23),
                gemeente = "Schellebelle",
                postcode = "9260",
                straatnaam = "Dendermondsesteenweg",
                straatnr = "92",
                afbeeldingNaam = R.drawable.auto,
                site = "https://www.lennertbontinck.com/"

            ),
            Meeting(
                meetingId = "5bbd254ba1468a0013f104c6",
                titel = "Meet the 106",
                subtitel = "Lennert's car is finally done!",
                beschrijving = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempus, enim eget gravida " +
                        "eleifend, enim nisl tempor sem, quis tempor libero quam eu nunc. Integer a egestas nibh. " +
                        "Suspendisse malesuada sollicitudin pretium. Class aptent taciti sociosqu ad litora torquent " +
                        "per conubia nostra, per inceptos himenaeos. Duis malesuada non nibh quis gravida. Donec in mi " +
                        "quis tortor pretium fringilla. Aenean vehicula ullamcorper elementum. Praesent pellentesque " +
                        "lacinia urna, ultrices fermentum leo luctus sed. Mauris at egestas nibh, in ultrices eros. " +
                        "Etiam interdum porta elementum. Mauris vitae sem elit. Sed convallis dolor ligula, sagittis " +
                        "volutpat est mattis a. Quisque finibus rhoncus eleifend. Duis sed justo eget lorem pharetra " +
                        "sagittis. Integer accumsan rutrum dolor, viverra mollis sapien semper volutpat.",
                categorien = listOf("French", "Daily", "Hatchbacks", "Lowered", "Sportcars", "Tuning"),
                gebruikerIdsGoing = listOf("5bba46fc491b8c00139709ee"),
                gebruikerIdsLiked = listOf(),
                datum = Date(2018, 12, 23),
                gemeente = "Schellebelle",
                postcode = "9260",
                straatnaam = "Dendermondsesteenweg",
                straatnr = "92",
                afbeeldingNaam = R.drawable.auto,
                site = "https://www.lennertbontinck.com/"

            ),
            Meeting(
                meetingId = "5bbd254ba1468a0013f104c6",
                titel = "Meet the 106",
                subtitel = "Lennert's car is finally done!",
                beschrijving = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempus, enim eget gravida " +
                        "eleifend, enim nisl tempor sem, quis tempor libero quam eu nunc. Integer a egestas nibh. " +
                        "Suspendisse malesuada sollicitudin pretium. Class aptent taciti sociosqu ad litora torquent " +
                        "per conubia nostra, per inceptos himenaeos. Duis malesuada non nibh quis gravida. Donec in mi " +
                        "quis tortor pretium fringilla. Aenean vehicula ullamcorper elementum. Praesent pellentesque " +
                        "lacinia urna, ultrices fermentum leo luctus sed. Mauris at egestas nibh, in ultrices eros. " +
                        "Etiam interdum porta elementum. Mauris vitae sem elit. Sed convallis dolor ligula, sagittis " +
                        "volutpat est mattis a. Quisque finibus rhoncus eleifend. Duis sed justo eget lorem pharetra " +
                        "sagittis. Integer accumsan rutrum dolor, viverra mollis sapien semper volutpat.",
                categorien = listOf("French", "Daily", "Hatchbacks", "Lowered", "Sportcars", "Tuning"),
                gebruikerIdsGoing = listOf("5bba46fc491b8c00139709ee"),
                gebruikerIdsLiked = listOf(),
                datum = Date(2018, 12, 23),
                gemeente = "Schellebelle",
                postcode = "9260",
                straatnaam = "Dendermondsesteenweg",
                straatnr = "92",
                afbeeldingNaam = R.drawable.auto,
                site = "https://www.lennertbontinck.com/"

            )
        )
    }

    companion object {
        fun newInstance(design: String): MeetinglijstFragment {
            val args = Bundle()
            args.putString("lijstDesgin", design)
            val fragment = MeetinglijstFragment()
            fragment.arguments = args
            return fragment
        }
    }

}