package com.timelove.viewlearn.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.16 14:00
 * description: RoundRect 圆角矩形
 */
class RoundRectView : View {

    public constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {

    }


    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var rectF: RectF = RectF(100f, 100f, 300f, 250f) //定义 左，上，右，下参数，其实就是左上角的坐标点，和右下角的坐标点

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        canvas?.drawRoundRect(rectF, 50f, 50f, paint)

    }
}