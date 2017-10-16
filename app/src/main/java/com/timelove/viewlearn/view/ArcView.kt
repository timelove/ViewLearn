package com.timelove.viewlearn.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.16 15:00
 * description: ArcView
 */
class ArcView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.RED
        paint.style = Paint.Style.FILL //设置 画线、填充（默认）
//        paint.isAntiAlias = true //动态设置抗锯齿
        /**
         * drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；
         * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针
         * 为负角度），sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就
         * 是弧形，如果连接到圆心，就是扇形。
         */
        canvas?.drawArc(100f, 100f, 300f, 250f, -180f, 120f, true, paint)
    }

}