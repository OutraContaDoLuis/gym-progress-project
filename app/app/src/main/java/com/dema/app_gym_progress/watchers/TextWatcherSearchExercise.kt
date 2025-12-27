package com.dema.app_gym_progress.watchers

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import com.dema.app_gym_progress.activitys.SessionActivity

class TextWatcherSearchExercise(context: Context?) : TextWatcher {

    private var context: Context? = null

    init {
        this.context = context
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(
        s: CharSequence?,
        start: Int,
        count: Int,
        after: Int
    ) {
    }

    override fun onTextChanged(
        s: CharSequence?,
        start: Int,
        before: Int,
        count: Int
    ) {
        if (context == null)
            return

        (context as SessionActivity).filterTheListOfExercises(s.toString())
    }
}