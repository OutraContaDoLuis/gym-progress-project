package com.dema.app_gym_progress

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    private lateinit var txtInputUsername : TextInputLayout
    private lateinit var txtEditUsername : TextInputEditText
    private lateinit var txtInputPassword : TextInputLayout
    private lateinit var txtEditPassword : TextInputEditText
    private lateinit var btnLogin : Button

    private var context : Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        txtInputUsername = view.findViewById(R.id.txt_input_username)
        txtEditUsername = view.findViewById(R.id.txt_edit_username)
        txtInputPassword = view.findViewById(R.id.txt_input_password)
        txtEditPassword = view.findViewById(R.id.txt_edit_password)
        btnLogin = view.findViewById(R.id.btn_login)

        btnLogin.setOnClickListener { validationForms() }

        context = requireContext()

        return view
    }

    private fun validationForms() {
        txtInputUsername.isErrorEnabled = false
        txtInputPassword.isErrorEnabled = false

        var formsIsValid = true
        val username = txtEditUsername.text.toString()
        val password = txtEditPassword.text.toString()

        if (username.isEmpty()) {
            formsIsValid = false
            txtInputUsername.error = "E preciso inserir um nome de usuario!"
        }

        if (password.isEmpty()) {
            formsIsValid = false
            txtInputPassword.error = "E preciso inserir uma senha!"
        }

        if (!formsIsValid)
            return

        (context as? AuthActivity)?.login(username, password)
    }
}