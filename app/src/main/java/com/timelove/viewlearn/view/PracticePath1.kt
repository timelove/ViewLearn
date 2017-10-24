package com.timelove.viewlearn.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.support.annotation.LayoutRes
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.17 9:17
 * description: PracticePath1
 */
class PracticePath1 : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var path: Path = Path()

    public constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {}

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        paint.isAntiAlias = true

        path.addCircle(300f,300f,200f,Path.Direction.CW)
        path.addCircle(300f,300f,100f,Path.Direction.CCW)
        canvas?.drawPath(path,paint)

        path.reset()
        paint.reset()
        path.addCircle(800f,300f,200f,Path.Direction.CW)
        paint.color=Color.RED
        canvas?.drawPath(path,paint)

    }
}