package com.abualgait.msayed.wefancyui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Region
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import coil.api.load
import coil.transform.BlurTransformation


class RevesedArcView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        //import coil.api.load
        val view = LayoutInflater.from(context).inflate(R.layout.reversed_arc_view_layout, this, true)

    }


    private val path = Path()

    override fun dispatchDraw(canvas: Canvas?) {
        val count = canvas!!.save()
        //RevesedArcView path
        path.moveTo(0f, canvas.height.toFloat())
        path.lineTo(0f, 300f)
        path.quadTo(canvas.width.toFloat() / 2, 0f, canvas.width.toFloat(), 300f)
        path.lineTo(canvas.width.toFloat(), canvas.height.toFloat())

        canvas.clipPath(path, Region.Op.INTERSECT)
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(count)
    }


}