package com.pvld.horoscope.customviews

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.animation.DecelerateInterpolator
import com.pvld.horoscope.R


class CustomCircleProgressBar(context: Context?, attrs: AttributeSet) : View(context, attrs) {

    private var value = DEFAULT_VALUE
    private var mainColor = DEFAULT_MAIN_COLOR
    private var ringColor = DEFAULT_DECOR_RING_COLOR
    private var textSize = DEFAULT_TEXT_SIZE_SP
    private var textColor = DEFAULT_TEXT_COLOR
    private lateinit var mainPaint: Paint
    private lateinit var ringPaint: Paint
    private lateinit var textPaint: Paint
    private lateinit var mainBounds: RectF
    private lateinit var ringBounds: RectF

    init {
        isSaveEnabled = true
        initAttrs(attrs)
        initVars()
    }

    private fun initAttrs(attrs: AttributeSet) {
        val array = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomCircleProgressBar,
            0, 0
        )
        try {
            val dm = resources.displayMetrics
            value = array.getFloat(
                R.styleable.CustomCircleProgressBar_value,
                DEFAULT_VALUE
            )
            textSize = array.getDimensionPixelSize(
                R.styleable.CustomCircleProgressBar_textSize, TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_SP,
                    DEFAULT_TEXT_SIZE_SP.toFloat(),
                    dm
                ).toInt()
            )
            textColor = array.getColor(
                R.styleable.CustomCircleProgressBar_textColor,
                DEFAULT_TEXT_COLOR
            )
            ringColor = array.getColor(
                R.styleable.CustomCircleProgressBar_ringColor,
                DEFAULT_DECOR_RING_COLOR
            )
            mainColor = array.getColor(
                R.styleable.CustomCircleProgressBar_mainColor,
                DEFAULT_MAIN_COLOR
            )
        } finally {
            array.recycle()
        }
    }

    private fun initVars() {
        mainPaint = Paint()
        mainPaint.isAntiAlias = true
        mainPaint.isDither = true
        mainPaint.style = Paint.Style.FILL
        mainPaint.color = mainColor

        ringPaint = Paint()
        ringPaint.isAntiAlias = true
        ringPaint.isDither = true
        ringPaint.style = Paint.Style.STROKE
        ringPaint.color = ringColor
        ringPaint.alpha = 64

        textPaint = Paint()
        textPaint.isAntiAlias = true
        textPaint.isDither = true
        textPaint.color = textColor
        textPaint.textSize = textSize.toFloat()

        mainBounds = RectF()
        ringBounds = RectF()

        setAnimation()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = suggestedMinimumWidth + paddingLeft + paddingRight
        val desiredHeight = suggestedMinimumHeight + paddingTop + paddingBottom

        val resolveWidth = resolveSize(desiredWidth, widthMeasureSpec)
        val resolveHeight = resolveSize(desiredHeight, heightMeasureSpec)

        val min = Math.min(resolveWidth, resolveHeight)
        setMeasuredDimension(min, min)

        mainBounds[0f, 0f, min.toFloat()] = min.toFloat()
        ringBounds[0 + min / 20f, 0 + min / 20f, min - min / 20f] = min - min / 20f
    }

    override fun onDraw(canvas: Canvas) {
        val min = Math.min(width, height)

        // draw main body
        canvas.drawArc(mainBounds, START_ANGLE, value, true, mainPaint)

        // draw decor ring
        ringPaint.strokeWidth = min / 10.0f
        canvas.drawOval(ringBounds, ringPaint)

        // draw value
        val valueToDraw: String = ((value / 360 * 100).toInt()).toString()
        val bounds = Rect()
        textPaint.getTextBounds(valueToDraw, 0, valueToDraw.length, bounds)
        val xPos = min / 2 - bounds.width() / 2
        val yPos = (min / 2 - (textPaint.descent() + textPaint.ascent()) / 2).toInt()
        canvas.drawText(valueToDraw, xPos.toFloat(), yPos.toFloat(), textPaint)
    }

    fun setValue(value: Float) {
        this.value = value
        invalidate()
    }

    fun setValueWithAnimation(value: Float) {
        ObjectAnimator.ofFloat(this, "value", this.value, value)
            .apply {
                duration = 1500
                interpolator = DecelerateInterpolator()
                start()
            }
    }

    private fun setAnimation() {
        ObjectAnimator.ofFloat(this, "value", value)
            .apply {
                duration = 1500
                interpolator = DecelerateInterpolator()
                start()
            }
    }

    fun setTextSize(textSize: Int) {
        val dm = resources.displayMetrics
        this.textSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, textSize.toFloat(), dm
        ).toInt()
        textPaint.textSize = this.textSize.toFloat()
        invalidate()
    }

    fun setTextColor(textColor: Int) {
        this.textColor = textColor
        textPaint.color = this.textColor
        invalidate()
    }

    fun setMainColor(mainColor: Int) {
        this.mainColor = mainColor
        mainPaint.color = this.mainColor
        invalidate()
    }

    fun setRingColor(ringColor: Int) {
        this.ringColor = ringColor
        ringPaint.color = this.ringColor
        ringPaint.alpha = 64
        invalidate()
    }

    public override fun onSaveInstanceState(): Parcelable? {
        val superState = super.onSaveInstanceState()
        val ss = superState?.let { SavedState(it) }
        if (ss != null) {
            ss.value = value
            ss.textSize = textSize
            ss.textColor = textColor
            ss.mainColor = mainColor
            ss.ringColor = ringColor
        }
        return ss
    }

    public override fun onRestoreInstanceState(state: Parcelable) {
        val ss = state as SavedState
        super.onRestoreInstanceState(ss.superState)
        value = ss.value
        textSize = ss.textSize
        textColor = ss.textColor
        mainColor = ss.mainColor
        ringColor = ss.ringColor
        initVars()
    }

    internal class SavedState : BaseSavedState {
        var value: Float = 0f
        var textSize: Int = 0
        var textColor: Int = 0
        var mainColor: Int = 0
        var ringColor: Int = 0

        constructor(source: Parcel) : super(source) {
            value = source.readFloat()
            textSize = source.readInt()
            textColor = source.readInt()
            mainColor = source.readInt()
            ringColor = source.readInt()
        }

        constructor(superState: Parcelable) : super(superState)

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeFloat(value)
            out.writeInt(textSize)
            out.writeInt(textColor)
            out.writeInt(mainColor)
            out.writeInt(ringColor)
        }

        companion object CREATOR : Parcelable.Creator<SavedState> {

            override fun createFromParcel(parcel: Parcel): SavedState {
                return SavedState(parcel)
            }

            override fun newArray(size: Int): Array<SavedState?> {
                return arrayOfNulls(size)
            }
        }

    }

    companion object {
        private const val START_ANGLE = 270f
        private const val DEFAULT_VALUE = 270f
        private const val DEFAULT_TEXT_SIZE_SP = 12
        private val DEFAULT_TEXT_COLOR = Color.parseColor("#3700B3")
        private val DEFAULT_DECOR_RING_COLOR = Color.parseColor("#3700B3")
        private val DEFAULT_MAIN_COLOR = Color.parseColor("#6200EE")
    }

}