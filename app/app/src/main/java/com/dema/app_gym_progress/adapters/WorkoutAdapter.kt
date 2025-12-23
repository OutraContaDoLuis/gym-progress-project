package com.dema.app_gym_progress.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.dema.app_gym_progress.CustomDialogs
import com.dema.app_gym_progress.R
import com.dema.app_gym_progress.activitys.HomeActivity
import com.dema.app_gym_progress.models.WorkoutModel

internal class WorkoutAdapter(context: Context, workoutList: ArrayList<WorkoutModel?>)
    : RecyclerView.Adapter<WorkoutAdapter.MyViewHolder>() {

    private var context: Context? = null
    private var workoutList: ArrayList<WorkoutModel?> = ArrayList()

    init {
        this.context = context
        this.workoutList = workoutList
    }

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var img: ImageView = view.findViewById(R.id.img)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.workout_item, parent, false)

        return MyViewHolder(viewItem)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val workoutModel = workoutList[position]
        holder.title.text = workoutModel?.nameWorkout

        val imageResource = if (workoutModel != null && workoutModel.addWorkout) {
            R.drawable.ic_baseline_add_24
        } else {
            R.drawable.ic_baseline_arrow_forward_ios_24
        }

        holder.img.setImageResource(imageResource)

        holder.itemView.setOnClickListener {
            if (workoutModel != null && workoutModel.addWorkout) {
                val customDialog = CustomDialogs()
                customDialog.showDialogToAddWorkout(context)
            } else {
                //call workout activity
            }
        }
    }

    override fun getItemCount(): Int {
        return workoutList.size
    }
}