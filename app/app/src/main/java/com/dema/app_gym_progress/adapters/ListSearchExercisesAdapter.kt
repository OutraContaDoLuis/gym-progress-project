package com.dema.app_gym_progress.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.models.ExerciseModel

class ListSearchExercisesAdapter(
    context: Context, listExerciseModel: ArrayList<ExerciseModel?>)
    :
    ArrayAdapter<ExerciseModel>(context, R.layout.search_exercise_item, listExerciseModel) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listItem = getItem(position)

        if (view == null) {
            view =
                LayoutInflater.from(context).inflate(R.layout.search_exercise_item, parent, false)
        }

        val txtExerciseName = view.findViewById<TextView>(R.id.txt_exercise_name)
        txtExerciseName.text = listItem?.name

        val txtExerciseType = view.findViewById<TextView>(R.id.txt_exercise_type)
        txtExerciseType.text = buildString {
            append("Musculo alvo: ")
            append(listItem?.type)
        }

        return view
    }
}