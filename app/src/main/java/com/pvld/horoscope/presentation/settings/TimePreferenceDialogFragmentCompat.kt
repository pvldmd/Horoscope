package com.pvld.horoscope.presentation.settings


import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.view.View
import android.widget.TimePicker
import androidx.preference.DialogPreference
import androidx.preference.PreferenceDialogFragmentCompat
import com.pvld.horoscope.R


class TimePreferenceDialogFragmentCompat : PreferenceDialogFragmentCompat() {

    private lateinit var timePicker: TimePicker

    override fun onBindDialogView(view: View) {
        super.onBindDialogView(view)
        timePicker = view.findViewById(R.id.time_picker)

        // Get the time from the related Preference
        var minutesAfterMidnight: Int? = null
        val preference: DialogPreference = preference
        if (preference is TimePreference) {
            minutesAfterMidnight = (preference as TimePreference).time
        }

        // Set the time to the TimePicker
        if (minutesAfterMidnight != null) {
            val hours = minutesAfterMidnight / 60
            val minutes = minutesAfterMidnight % 60
            val is24hour: Boolean = DateFormat.is24HourFormat(context)
            timePicker.setIs24HourView(is24hour)
            timePicker.currentHour = hours
            timePicker.currentMinute = minutes
        }
    }

    override fun onDialogClosed(positiveResult: Boolean) {
        if (positiveResult) { // Get the current values from the TimePicker
            val hours: Int
            val minutes: Int
            if (Build.VERSION.SDK_INT >= 23) {
                hours = timePicker.hour
                minutes = timePicker.minute
            } else {
                hours = timePicker.currentHour
                minutes = timePicker.currentMinute
            }

            // Generate value to save
            val minutesAfterMidnight = hours * 60 + minutes

            // Save the value
            val preference: DialogPreference = preference
            if (preference is TimePreference) {
                val timePreference = preference as TimePreference
                if (timePreference.callChangeListener(minutesAfterMidnight)) {
                    timePreference.time = minutesAfterMidnight
                }
            }
        }
    }

    companion object {
        fun newInstance(key: String?): TimePreferenceDialogFragmentCompat {
            val fragment = TimePreferenceDialogFragmentCompat()
            val b = Bundle(1)
            b.putString(ARG_KEY, key)
            fragment.arguments = b
            return fragment
        }
    }

}
