package com.dema.app_gym_progress.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.activitys.WorkoutActivity
import com.dema.app_gym_progress.models.SessionModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListSessionAdapter(context: Context, listSession: ArrayList<SessionModel?>)
    : ArrayAdapter<SessionModel>(context, R.layout.session_item, listSession) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listItem = getItem(position)

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.session_item, parent, false)
        }

        val txtWorkoutName = view.findViewById<TextView>(R.id.txt_session_name)
        txtWorkoutName.text = listItem?.sessionName.toString()

        val btnDeleteSession = view.findViewById<FloatingActionButton>(R.id.btn_delete_session)
        btnDeleteSession.setOnClickListener {
            Log.v("ListSessionAdapter", "click to delete item in list of sessions")
            (context as? WorkoutActivity)?.deleteItemFromTheCurrentSessionList(position)
        }

        val btnEditSession = view.findViewById<FloatingActionButton>(R.id.btn_edit_session)
        btnEditSession.setOnClickListener {
            (context as? WorkoutActivity)?.editItemFromTheCurrentSessionList(position)
        }

        val btnGoToSession = view.findViewById<FloatingActionButton>(R.id.btn_go_to_session)
        btnGoToSession.setOnClickListener {
            (context as? WorkoutActivity)?.goToSessionActivity(position)
        }

        return view
    }
}