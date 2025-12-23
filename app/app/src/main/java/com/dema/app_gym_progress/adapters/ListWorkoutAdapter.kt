package com.dema.app_gym_progress.adapters

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.models.WorkoutModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListWorkoutAdapter(context: Context, listWorkout: ArrayList<WorkoutModel?>)
    : ArrayAdapter<WorkoutModel>(context, R.layout.workout_item, listWorkout) {

    private var context: Context? = null
    private var listWorkout: ArrayList<WorkoutModel?> = ArrayList()

    init {
        this.context = context
        this.listWorkout = listWorkout
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listItem = getItem(position)

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.workout_item, parent, false)
        }

        var txtWorkoutName = view.findViewById<TextView>(R.id.txt_workout_name)
        txtWorkoutName.text = listItem?.nameWorkout.toString()

        return view!!
    }
}