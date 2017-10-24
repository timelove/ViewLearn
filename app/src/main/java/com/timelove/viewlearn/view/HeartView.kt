package com.timelove.viewlearn.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.24 11:04
 * description: HeadView 心形图
 */
class HeartView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    private var path: Path = Path()

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.RED
        paint.style = Paint.Style.FILL //设置 画线、填充（默认）
//        paint.isAntiAlias = true //动态设置抗锯齿

        path.setLastPoint(317f, 353f)//设置终点 重置最后一个点的位置

        path.lineTo(500f, 550f)
        path.lineTo(683f, 353f)
        path.arcTo(500f, 200f, 700f, 400f, 30f, -210f, false)
        path.arcTo(300f, 200f, 500f, 400f, 0f, -210f, false)


        canvas?.drawPath(path, paint)
    }
}