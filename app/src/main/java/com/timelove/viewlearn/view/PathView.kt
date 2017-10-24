package com.timelove.viewlearn.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.16 15:43
 * description: PathView
 */
class PathView : View {

    var paint: Paint = Paint()

    var path: Path = Path()

    public constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {}

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * 不是所有的子图形都需要使用 close() 来封闭。当需要填充图形时
         * （即 Paint.Style 为 FILL 或  FILL_AND_STROKE），Path 会自动封闭子图形。
         */
        paint.style = Paint.Style.STROKE
        path.lineTo(100f, 100f)
        path.rLineTo(100f, 0f)
        path.arcTo(100f, 100f, 300f, 300f, -90f, 90f, true)
//        path.close()

        canvas?.drawPath(path, paint)
    }
}