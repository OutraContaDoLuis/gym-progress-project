package com.dema.app_gym_progress

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dema.app_gym_progress.adapters.WorkoutAdapter
import com.dema.app_gym_progress.models.WorkoutModel

class HomeActivity : AppCompatActivity() {

    private var workoutList: ArrayList<WorkoutModel?> = ArrayList()

    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recycler_view)
    }

    override fun onStart() {
        super.onStart()
        setTheInitialWorkoutList()
    }

    private fun setTheInitialWorkoutList() {
        val addWorkoutModel = WorkoutModel()
        addWorkoutModel.addWorkout = true
        workoutList.add(addWorkoutModel)

        val layoutManager = LinearLayoutManager(applicationContext)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager
        val workoutAdapter = WorkoutAdapter(workoutList)
        recyclerView.adapter = workoutAdapter
    }

    fun putTheCurrentWorkoutList(workoutModel: WorkoutModel) {

    }
}