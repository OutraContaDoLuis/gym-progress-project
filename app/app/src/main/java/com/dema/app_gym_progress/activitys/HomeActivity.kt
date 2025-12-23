package com.dema.app_gym_progress.activitys

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dema.app_gym_progress.CustomDialogs
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.adapters.ListWorkoutAdapter
import com.dema.app_gym_progress.models.WorkoutModel

class HomeActivity : AppCompatActivity() {

    private var workoutModelList: ArrayList<WorkoutModel?> = ArrayList()

    private lateinit var listWorkout : ListView
    private lateinit var btnAddWorkout : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listWorkout = findViewById(R.id.list_workout)
        btnAddWorkout = findViewById(R.id.btn_add_workout)

        btnAddWorkout.setOnClickListener { addWorkoutToTheWorkoutModelList() }
    }

    override fun onStart() {
        super.onStart()
        setTheInitialWorkoutList()
    }

    private fun setTheInitialWorkoutList() {
        val listWorkoutAdapter = ListWorkoutAdapter(this@HomeActivity, workoutModelList)
        listWorkout.adapter = listWorkoutAdapter
    }

    fun putTheCurrentWorkoutList(workoutModel: WorkoutModel) {
        workoutModelList.add(workoutModel)

        val listWorkoutAdapter = ListWorkoutAdapter(this@HomeActivity, workoutModelList)
        listWorkout.adapter = listWorkoutAdapter
    }

    private fun addWorkoutToTheWorkoutModelList() {
        val customDialogs = CustomDialogs()
        customDialogs.showDialogToAddWorkout(this@HomeActivity)
    }
}