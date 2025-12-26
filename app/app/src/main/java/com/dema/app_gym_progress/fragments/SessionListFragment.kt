package com.dema.app_gym_progress.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.models.SessionModel

class SessionListFragment(listSessionModel: ArrayList<SessionModel?>) : Fragment() {

    private lateinit var listSession: ListView

    private var listSessionModel: ArrayList<SessionModel?> = ArrayList()

    init {
        this.listSessionModel = listSessionModel
    }

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

        return view
    }
}