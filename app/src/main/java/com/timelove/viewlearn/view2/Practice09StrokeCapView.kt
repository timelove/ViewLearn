package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.25 15:06
 * description: Practice09StrokeCapView
 */
class Practice09StrokeCapView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿


    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        paint.strokeWidth = 40f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.strokeCap = Paint.Cap.BUTT
        canvas?.drawLine(50f, 50f, 500f, 50f, paint)

        paint.strokeCap = Paint.Cap.ROUND
        canvas?.drawLine(50f, 150f, 500f, 150f, paint)

        paint.strokeCap = Paint.Cap.SQUARE
        canvas?.drawLine(50f, 200f, 500f, 200f, paint)

    }
}