package com.dema.app_gym_progress.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.adapters.ListWorkoutAdapter
import com.dema.app_gym_progress.models.WorkoutModel

class WorkoutListFragment(listWorkoutModel: ArrayList<WorkoutModel?>) : Fragment() {

    private var listWorkoutModel: ArrayList<WorkoutModel?> = ArrayList()

    init {
        this.listWorkoutModel = listWorkoutModel
    }

    private lateinit var listWorkout: ListView

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

        return view
    }
}