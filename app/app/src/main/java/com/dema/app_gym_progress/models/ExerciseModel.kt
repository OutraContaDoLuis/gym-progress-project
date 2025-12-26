package com.dema.app_gym_progress.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ExerciseModel(
    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String

) : Serializable
