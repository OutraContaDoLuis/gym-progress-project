package com.dema.app_gym_progress.activitys

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnClickListener
import android.widget.ListView
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.adapters.ListSearchExercisesAdapter
import com.dema.app_gym_progress.api.ExerciseApiService
import com.dema.app_gym_progress.models.ExerciseModel
import com.dema.app_gym_progress.watchers.TextWatcherSearchExercise
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SessionActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var txtSessionName: TextView
    private lateinit var txtInputSearchExercise: TextInputLayout
    private lateinit var txtEditSearchExercise: TextInputEditText
    private lateinit var listSearchExercises: ListView

    private var listOfExercisesModel: ArrayList<ExerciseModel?> = ArrayList()

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
        listSearchExercises = findViewById(R.id.list_search_exercises)

        toolbar.setNavigationOnClickListener { finish() }
        txtEditSearchExercise.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                Log.v("SessionActivity", "clicked")
                getAllExercises()
            }
        }

        txtEditSearchExercise.addTextChangedListener(TextWatcherSearchExercise(this))
    }

    private fun getAllExercises() {
        val exerciseApiService = ExerciseApiService()
        exerciseApiService.getAllExercises(this@SessionActivity)
    }

    private fun activeListSearchExercises() {
        listSearchExercises.isEnabled = true
        val listSearchExercisesAdapter = ListSearchExercisesAdapter(this, listOfExercisesModel)
        listSearchExercises.adapter = listSearchExercisesAdapter
    }

    private fun disableListSearchExercises() {
        listSearchExercises.isEnabled = false
    }

    fun setTheListSearchExercises(exercises: ArrayList<ExerciseModel?>?) {
        if (exercises != null) {
            listOfExercisesModel = exercises
        }
    }

    fun disableListSearchExercisesPublicFunction() {
        disableListSearchExercises()
    }

    private fun setNewListBySearch(list: ArrayList<ExerciseModel?>) {
        val listSearchExercisesAdapter = ListSearchExercisesAdapter(this, list)
        listSearchExercises.adapter = listSearchExercisesAdapter
    }

    fun filterTheListOfExercises(search: String) {
        var list = ArrayList<ExerciseModel?>()

        listOfExercisesModel.forEach { it ->
            if (it?.name != null && it.name.startsWith(search)) {
                list.add(it)
            }
        }

        Log.v("SessionActivity", "list of exercises filtered: $list")
        setNewListBySearch(list)
    }
}