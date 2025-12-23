package com.dema.app_gym_progress

import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import android.widget.Button
import com.dema.app_gym_progress.activitys.HomeActivity
import com.dema.app_gym_progress.models.WorkoutModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CustomDialogs() {

    fun showDialogToAddWorkout(context: Context?) {
        if (context != null) {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.modal_add_workout)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

            dialog.setCancelable(false)

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

}