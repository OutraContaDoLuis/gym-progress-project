package com.dema.app_gym_progress.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.activitys.WorkoutActivity
import com.dema.app_gym_progress.adapters.ListWorkoutAdapter
import com.dema.app_gym_progress.models.WorkoutModel

class WorkoutListFragment(listWorkoutModel: ArrayList<WorkoutModel?>) : Fragment() {

    private lateinit var listWorkout: ListView

    private var listWorkoutModel: ArrayList<WorkoutModel?> = ArrayList()

    init {
        this.listWorkoutModel = listWorkoutModel
    }

    private val tag = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_workout_list, container, false)

        listWorkout = view.findViewById(R.id.list_workout)

        val listWorkoutAdapter = ListWorkoutAdapter(requireContext(), listWorkoutModel)
        listWorkout.adapter = listWorkoutAdapter
        listWorkout.onItemClickListener = AdapterView.OnItemClickListener { _, _, i, _ ->
            Log.v(tag, "clicked")
            val intent = Intent(requireContext(), WorkoutActivity::class.java)
            intent.putExtra("workoutName", listWorkoutModel[i]?.nameWorkout)
            startActivity(intent)
        }

        return view
    }
}