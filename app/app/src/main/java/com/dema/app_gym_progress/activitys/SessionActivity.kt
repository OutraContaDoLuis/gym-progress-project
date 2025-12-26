package com.dema.app_gym_progress.activitys

import android.os.Bundle
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dema.app_gym_progress.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SessionActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var txtSessionName: TextView
    private lateinit var txtInputSearchExercise: TextInputLayout
    private lateinit var txtEditSearchExercise: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_session)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.toolbar)
        txtInputSearchExercise = findViewById(R.id.txt_input_search_exercise)
        txtEditSearchExercise = findViewById(R.id.txt_edit_search_exercise)

        toolbar.setNavigationOnClickListener { finish() }
    }
}