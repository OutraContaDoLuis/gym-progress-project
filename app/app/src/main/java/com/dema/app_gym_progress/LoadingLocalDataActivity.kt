package com.dema.app_gym_progress

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoadingLocalDataActivity : AppCompatActivity() {

    private lateinit var sharedPreferences : SharedPreferences

    private var username = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_loading_local_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferences = getSharedPreferences(getString(R.string.file_user_data), MODE_PRIVATE)

        username = sharedPreferences.getString("username", "").toString()
        password = sharedPreferences.getString("password", "").toString()
    }

    override fun onStart() {
        super.onStart()
        goToNextActivity()
    }

    private fun goToNextActivity() {
        val userIsAlreadyLogged = checkIfUserIsAlreadyLogged()

        val intent = if (userIsAlreadyLogged) {
            Intent(this@LoadingLocalDataActivity, HomeActivity::class.java)
        } else {
            Intent(this@LoadingLocalDataActivity, AuthActivity::class.java)
        }

        startActivity(intent)
        finish()
    }

    private fun checkIfUserIsAlreadyLogged() : Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }
}