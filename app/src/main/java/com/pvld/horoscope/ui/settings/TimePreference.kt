package com.pvld.horoscope.ui.settings


import android.content.Context
import android.content.res.TypedArray
import android.text.TextUtils
import android.text.format.DateFormat
import android.util.AttributeSet
import androidx.preference.DialogPreference
import com.pvld.horoscope.R
import java.util.*


open class TimePreference(
    context: Context?,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : DialogPreference(context, attrs, defStyleAttr, defStyleRes) {

    var time: Int = 0
        set(time) {
            field = time
            persistInt(time) // Save to SharedPreference
            notifyChanged()
        }

    constructor(context: Context?) : this(context, null) {  }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        R.attr.preferenceStyle
    ) { }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        defStyleAttr
    ) { }

    override fun getDialogLayoutResource(): Int {
        return R.layout.preference_dialog_time
    }

    override fun onGetDefaultValue(a: TypedArray, index: Int): Any {
        return a.getInt(index, 0)
    }

    override fun onSetInitialValue(restorePersistedValue: Boolean, defaultValue: Any? ) {
        time = if (restorePersistedValue) getPersistedInt(time) else defaultValue as Int
    }

    override fun getSummary(): CharSequence {
        val prefix = if (TextUtils.isEmpty(super.getSummary())) "" else super.getSummary().toString() + "\n\n"
        return prefix + formatTime()
    }

    private fun formatTime(): String {
        return DateFormat.getTimeFormat(context).format(Date(0, 0, 0, time / 60, time % 60))
    }
}
