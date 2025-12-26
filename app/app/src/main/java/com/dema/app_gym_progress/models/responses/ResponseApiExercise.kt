package com.dema.app_gym_progress.models.responses

import com.dema.app_gym_progress.models.ExerciseModel

data class ResponseApiExercise(
    var code: Int = -1,
    var error: Boolean = false,
    var errorMessage: String = "",
    var exercises: ArrayList<ExerciseModel?> = ArrayList()
)
