package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.25 15:07
 * description: Practice11StrokeMiterView
 */
class Practice11StrokeMiterView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿


    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
      paint.strokeWidth = 40f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}