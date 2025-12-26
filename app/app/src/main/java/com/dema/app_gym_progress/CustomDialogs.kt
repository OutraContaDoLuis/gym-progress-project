package com.dema.app_gym_progress

import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import android.widget.Button
import com.dema.app_gym_progress.activitys.HomeActivity
import com.dema.app_gym_progress.activitys.WorkoutActivity
import com.dema.app_gym_progress.models.SessionModel
import com.dema.app_gym_progress.models.WorkoutModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CustomDialogs() {

    // ------------- DIALOG/MODAL TO ADD WORKOUT -------------

    fun showDialogToAddWorkout(context: Context?) {
        if (context != null) {
            val dialog = createDialog(
                context,
                R.layout.modal_add_workout,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

            val btnExit = dialog.findViewById<Button>(R.id.btn_close)
            btnExit.setOnClickListener {
                dialog.cancel()
            }

            val txtInputNameWorkout =
                dialog.findViewById<TextInputLayout>(R.id.txt_input_workout_name)
            val txtEditNameWorkout =
                dialog.findViewById<TextInputEditText>(R.id.txt_edit_workout_name)

            val btnAddWorkout = dialog.findViewById<Button>(R.id.btn_add_workout)
            btnAddWorkout.setOnClickListener {
                txtInputNameWorkout.isErrorEnabled = false
                val nameWorkout = txtEditNameWorkout.text.toString()
                var formIsValid = true

                if (nameWorkout.isEmpty()) {
                    formIsValid = false
                    txtInputNameWorkout.error = "Adicione um nome para o seu treino!"
                }

                if (!formIsValid)
                    return@setOnClickListener

                val workoutModel = WorkoutModel()
                workoutModel.nameWorkout = nameWorkout

                (context as? HomeActivity)?.putTheCurrentWorkoutList(workoutModel)
                dialog.cancel()
            }

            dialog.show()
        }
    }


    // ------------- DIALOG/MODAL TO ADD SESSION -------------

    fun showDialogToAddSession(context: Context?) {
        if (context != null) {
            val dialog = createDialog(
                context,
                R.layout.modal_add_session,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

            val btnExit = dialog.findViewById<Button>(R.id.btn_close)
            btnExit.setOnClickListener {
                dialog.cancel()
            }

            val txtInputSessionName =
                dialog.findViewById<TextInputLayout>(R.id.txt_input_session_name)
            val txtEditSessionName =
                dialog.findViewById<TextInputEditText>(R.id.txt_edit_session_name)

            val btnAddSession = dialog.findViewById<Button>(R.id.btn_add_session)
            btnAddSession.setOnClickListener {
                txtInputSessionName.isErrorEnabled = false
                val sessionName = txtEditSessionName.text.toString()
                var formIsValid = true

                if (sessionName.isEmpty()) {
                    formIsValid = false
                    txtInputSessionName.error = "Adicione um nome para a sua sessao!"
                }

                if (!formIsValid)
                    return@setOnClickListener

                val sessionModel = SessionModel()
                sessionModel.sessionName = sessionName

                (context as? WorkoutActivity)?.putThe(sessionModel)
                dialog.cancel()
            }

            dialog.show()
        }
    }



    private fun createDialog(context: Context, layout: Int, width: Int, height: Int): Dialog {
        val dialog = Dialog(context)
        dialog.setContentView(layout)
        dialog.window?.setLayout(width, height)

        dialog.setCancelable(false)

        return dialog
    }
}