package com.dema.app_gym_progress.adapters

import android.content.Context
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.activitys.HomeActivity
import com.dema.app_gym_progress.models.WorkoutModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListWorkoutAdapter(context: Context, listWorkout: ArrayList<WorkoutModel?>)
    : ArrayAdapter<WorkoutModel>(context, R.layout.workout_item, listWorkout) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listItem = getItem(position)

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.workout_item, parent, false)
        }

        val txtWorkoutName = view.findViewById<TextView>(R.id.txt_workout_name)
        txtWorkoutName.text = listItem?.nameWorkout.toString()

        val btnDeleteWorkout = view.findViewById<FloatingActionButton>(R.id.btn_delete_workout)
        btnDeleteWorkout.setOnClickListener {
            Log.v("ListWorkoutAdapter", "click to delete item in list of workouts")
            (context as? HomeActivity)?.deleteItemFromTheCurrentWorkoutList(position)
        }

        val btnEditWorkout = view.findViewById<FloatingActionButton>(R.id.btn_edit_workout)
        btnEditWorkout.setOnClickListener {
            (context as? HomeActivity)?.editItemFromTheCurrentWorkoutList(position)
        }

        val btnGoToWorkout = view.findViewById<FloatingActionButton>(R.id.btn_go_to_workout)
        btnGoToWorkout.setOnClickListener {
            (context as? HomeActivity)?.goToWorkoutActivity(position)
        }

        return view
    }
}