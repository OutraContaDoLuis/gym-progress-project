package com.dema.app_gym_progress.activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dema.app_gym_progress.CustomDialogs
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.activitys.HomeActivity
import com.dema.app_gym_progress.fragments.NoSessionsFoundedFragment
import com.dema.app_gym_progress.fragments.SessionListFragment
import com.dema.app_gym_progress.models.SessionModel

class WorkoutActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var txtWorkoutName: TextView
    private lateinit var btnAddSession: Button

    private var sessionModelList: ArrayList<SessionModel?> = ArrayList()

    private var workoutName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_workout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.toolbar)
        txtWorkoutName = findViewById(R.id.txt_workout_name)
        btnAddSession = findViewById(R.id.btn_add_session)

        val thisIntent = this.intent
        workoutName = thisIntent.getStringExtra("workoutName").toString()

        toolbar.setNavigationOnClickListener { finish() }
        txtWorkoutName.text = workoutName
        btnAddSession.setOnClickListener { addSessionToTheSessionModelList() }
    }

    override fun onStart() {
        super.onStart()
        setTheInitialFragmentSession()
    }

    private fun setTheInitialFragmentSession() {
        setTheFragmentSession()
    }

    fun putTheCurrentSessionList(sessionModel: SessionModel) {
        sessionModelList.add(sessionModel)

        setTheFragmentSession()
    }

    fun deleteItemFromTheCurrentSessionList(position: Int) {
        sessionModelList.removeAt(position)

        setTheFragmentSession()
    }

    fun editItemFromTheCurrentSessionList(position: Int) {
        setTheFragmentSession()
    }

    fun goToSessionActivity(position: Int) {
        val intent = Intent(this, SessionActivity::class.java)
        startActivity(intent)
    }

    private fun setTheFragmentSession() {
        val fragment = if (sessionModelList.isEmpty()) {
            NoSessionsFoundedFragment()
        } else {
            SessionListFragment(sessionModelList)
        }

        supportFragmentManager.beginTransaction().replace(R.id.session_fragment, fragment).commit()
    }

    private fun addSessionToTheSessionModelList() {
        val customDialogs = CustomDialogs()
        customDialogs.showDialogToAddSession(this@WorkoutActivity)
    }
}