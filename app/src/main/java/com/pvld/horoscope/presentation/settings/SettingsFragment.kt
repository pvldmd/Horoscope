package com.pvld.horoscope.presentation.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.pvld.horoscope.R


class SettingsFragment : PreferenceFragmentCompat()  {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onDisplayPreferenceDialog(preference: Preference) {
        if (preference is TimePreference) {
            val fragment: DialogFragment =
                TimePreferenceDialogFragmentCompat.newInstance(
                    preference.getKey()
                )
            fragment.setTargetFragment(this, 0)
            getFragmentManager()?.let {
                fragment.show(
                    it,
                    "TimePreferenceDialogFragment"
                )
            }
        } else {
            super.onDisplayPreferenceDialog(preference)
        }
    }

}
