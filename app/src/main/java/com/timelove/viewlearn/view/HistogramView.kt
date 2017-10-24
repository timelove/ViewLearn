package com.timelove.viewlearn.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.24 11:04
 * description: HeadView 直方图
 */
class HistogramView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿
    private var paintD: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var rect: Rect = Rect()

    private val strs: Array<String> = arrayOf("Froya", "Bayern", "Robben", "Kaka", "Hello", "Shine", "Moon")
    private val ints: IntArray = intArrayOf(10, 40, 35, 20, 60, 80, 35)

    private var path: Path = Path()

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.WHITE
        paint.strokeWidth = 3f
        val floats: FloatArray = floatArrayOf(100f, 50f, 100f, 500f, 100f, 500f, 950f, 500f)

        canvas?.drawLines(floats, paint)//先画直线

//        paint.isAntiAlias = true //动态设置抗锯齿

        paint.textSize = 30f
        paint.textAlign = Paint.Align.CENTER
        paintD.color = Color.GREEN

        var startTextX = 170f
        var startBoxX = 125
        var i = 0

        for (s in strs) {
            canvas?.drawText(s, startTextX, 530f, paint)

            rect.set(startBoxX, 500 - ints[i] * 5, startBoxX + 100, 500)

            canvas?.drawRect(rect, paintD)

            startTextX += 120f
            startBoxX += 120
            i++
        }

        paint.textSize = 47f
        canvas?.drawText("直方图", 512f, 650f, paint)

    }
}