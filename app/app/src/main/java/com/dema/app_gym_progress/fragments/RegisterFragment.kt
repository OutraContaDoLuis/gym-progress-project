package com.dema.app_gym_progress.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.Validations
import com.dema.app_gym_progress.activitys.AuthActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterFragment : Fragment() {

    private lateinit var txtInputUsername: TextInputLayout
    private lateinit var txtEditUsername: TextInputEditText
    private lateinit var txtInputPassword: TextInputLayout
    private lateinit var txtEditPassword: TextInputEditText
    private lateinit var txtInputConfirmPassword: TextInputLayout
    private lateinit var txtEditConfirmPassword: TextInputEditText
    private lateinit var btnRegister: Button
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

        txtInputUsername = view.findViewById(R.id.txt_input_username)
        txtEditUsername = view.findViewById(R.id.txt_edit_username)
        txtInputPassword = view.findViewById(R.id.txt_input_password)
        txtEditPassword = view.findViewById(R.id.txt_edit_password)
        txtInputConfirmPassword = view.findViewById(R.id.txt_input_confirm_password)
        txtEditConfirmPassword = view.findViewById(R.id.txt_edit_confirm_password)
        btnRegister = view.findViewById(R.id.btn_register)
        txtChangeToLogin = view.findViewById(R.id.txt_change_to_login)

        btnRegister.setOnClickListener {
            validationForms()
        }

        txtChangeToLogin.setOnClickListener {
            (requireContext() as? AuthActivity)?.changeFragment(LoginFragment())
        }

        return view
    }

    private fun validationForms() {
        txtInputUsername.isErrorEnabled = false
        txtInputPassword.isErrorEnabled = false
        txtInputConfirmPassword.isErrorEnabled = false

        var formsIsValid = true
        val username = txtEditUsername.text.toString()
        val password = txtEditPassword.text.toString()
        val confirmPassword = txtEditConfirmPassword.text.toString()

        if (username.isEmpty()) {
            txtInputUsername.error = "Insira um nome para o seu usuario"
            formsIsValid = false
        }

        val validations = Validations()
        val passwordValidate = validations.validatePassword(password)
        txtInputPassword.error = passwordValidate

        if (passwordValidate != "") {
            formsIsValid = false
        }

        val confirmPasswordValidate = validations.validateConfirmPassword(password, confirmPassword)
        txtInputConfirmPassword.error =
            validations.validateConfirmPassword(password, confirmPassword)

        if (confirmPasswordValidate != "") {
            formsIsValid = false
        }

        if (!formsIsValid)
            return

        (requireContext() as? AuthActivity)?.register()
    }
}