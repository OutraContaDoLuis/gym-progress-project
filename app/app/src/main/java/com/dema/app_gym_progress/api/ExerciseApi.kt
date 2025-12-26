package com.dema.app_gym_progress.api

import com.dema.app_gym_progress.models.ExerciseModel
import retrofit2.Call
import retrofit2.http.GET

interface ExerciseApi {

    @GET("/exercise/get_all")
    fun getAllExercises(): Call<ArrayList<ExerciseModel?>>
}