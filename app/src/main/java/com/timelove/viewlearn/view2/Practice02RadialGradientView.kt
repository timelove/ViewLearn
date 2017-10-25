package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.16 15:00
 * description: Practice02RadialGradientView
 */
class Practice02RadialGradientView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    private var shader: Shader? = null

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        //RadialGradient 辐射渐变
        shader = RadialGradient(300f, 300f, 200f, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP)
        paint.setShader(shader)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(300f, 300f, 200f, paint)


    }

}