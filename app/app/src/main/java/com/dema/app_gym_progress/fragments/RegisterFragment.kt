package com.dema.app_gym_progress.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.activitys.AuthActivity

class RegisterFragment : Fragment() {

    private lateinit var txtChangeToLogin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        txtChangeToLogin = view.findViewById(R.id.txt_change_to_login)
        txtChangeToLogin.setOnClickListener {
            (requireContext() as? AuthActivity)?.changeFragment(LoginFragment())
        }

        return view
    }
}