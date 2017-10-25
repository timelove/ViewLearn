package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.25 15:06
 * description: Practice10StrokeJoinView
 */
class Practice10StrokeJoinView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    private var path: Path = Path()

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        paint.strokeWidth = 40f
        paint.style = Paint.Style.STROKE

        path.rLineTo(200f, 0f)
        path.rLineTo(-160f, 120f)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()

        canvas?.translate(100f, 100f)
        paint.strokeJoin = Paint.Join.BEVEL
        canvas?.drawPath(path, paint)

        canvas?.translate(300f, 0f)
        paint.strokeJoin = Paint.Join.MITER
        canvas?.drawPath(path, paint)

        canvas?.translate(300f, 0f)
        paint.strokeJoin = Paint.Join.ROUND
        canvas?.drawPath(path, paint)

        canvas?.restore()
    }
}