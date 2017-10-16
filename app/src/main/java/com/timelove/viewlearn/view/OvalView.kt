package com.timelove.viewlearn.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.16 14:53
 * description: OvalView 椭圆
 */
class OvalView : View {

    public constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {}

    var paint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.FILL_AND_STROKE
        canvas?.drawOval(100f, 100f, 350f, 200f, paint)
    }

}