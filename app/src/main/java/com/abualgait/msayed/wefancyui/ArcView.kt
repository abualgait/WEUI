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


class ArcView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.arc_view_layout, this, true)
        view.findViewById<ImageView>(R.id.imageView7).load(R.drawable.cairo) {
            this.transformations(BlurTransformation(context))
        }
    }


    private val path = Path()

    override fun dispatchDraw(canvas: Canvas?) {
        val count = canvas!!.save()
        //arc path
        path.moveTo(0f, 0f)
        path.lineTo(0f, canvas.height.toFloat() - 300f)
        path.quadTo(
            canvas.width.toFloat() / 2, canvas.height.toFloat(),
            canvas.width.toFloat(), canvas.height.toFloat() - 300f
        )
        path.lineTo(canvas.width.toFloat(), 0f)

        canvas.clipPath(path, Region.Op.INTERSECT)
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(count)
    }


}