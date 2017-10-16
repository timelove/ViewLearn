package com.timelove.viewlearn.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.13 15:44
 * description: FirstView
 */
class CircleView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        paint.color = Color.RED
        paint.style = Paint.Style.STROKE //设置 画线、填充（默认）
        paint.strokeWidth = 2f  //设置边缘线宽度
        paint.isAntiAlias = true //动态设置抗锯齿
        canvas?.drawCircle(200f, 100f, 100f, paint) // 园心 坐标，半径
    }

}