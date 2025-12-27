package com.dema.app_gym_progress.api

import android.content.Context
import android.util.Log
import com.dema.app_gym_progress.activitys.SessionActivity
import com.dema.app_gym_progress.models.ExerciseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class ExerciseApiService {

    private val tag = "ExerciseApiService"

    fun getAllExercises(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val retrofitClient = NetworkUtils().getRetrofitInstance("http://192.168.0.16:8080/")
                val endpointExercise = retrofitClient.create(ExerciseApi::class.java)
                val callback = endpointExercise.getAllExercises()
                callback.enqueue(object: Callback<ArrayList<ExerciseModel?>> {
                    override fun onResponse(
                        call: Call<ArrayList<ExerciseModel?>?>,
                        response: Response<ArrayList<ExerciseModel?>?>
                    ) {
                        val responseCode = response.code()

                        when (responseCode) {
                            200 -> {
                                val exercises = response.body()

                                Log.v(tag, "success to get all the exercises")
                                Log.v(tag, "exercises: $exercises")

                                (context as? SessionActivity)?.setTheListSearchExercises(exercises)
                            }
                            400 -> {
                                Log.v(tag, "error to get all the exercises (error 400/Bad Request)")
                            }
                        }
                    }

                    override fun onFailure(
                        call: Call<ArrayList<ExerciseModel?>?>,
                        t: Throwable
                    ) {
                        Log.v(tag, "error to get all the exercises (error)")
                        throw t
                    }

                })
            } catch (ex: Exception) {

            }
        }
    }

}