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
import com.dema.app_gym_progress.adapters.ListSessionAdapter
import com.dema.app_gym_progress.adapters.ListWorkoutAdapter
import com.dema.app_gym_progress.models.SessionModel

class SessionListFragment(listSessionModel: ArrayList<SessionModel?>) : Fragment() {

    private lateinit var listSession: ListView

    private var listSessionModel: ArrayList<SessionModel?> = ArrayList()

    init {
        this.listSessionModel = listSessionModel
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
        val view = inflater.inflate(R.layout.fragment_session_list, container, false)

        listSession = view.findViewById(R.id.list_session)
        val listSessionAdapter = ListSessionAdapter(requireContext(), listSessionModel)
        listSession.adapter = listSessionAdapter

        return view
    }
}