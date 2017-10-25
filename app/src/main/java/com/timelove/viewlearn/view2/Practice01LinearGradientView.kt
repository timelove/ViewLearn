package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.16 15:00
 * description: Practice01LinearGradientView
 */
class Practice01LinearGradientView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    private var shader: Shader? = null


    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        /**
         * 构造方法：
        LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, Shader.TileMode tile)
        参数：
        x0 y0 x1 y1：渐变的两个端点的位置
        color0 color1 是端点的颜色
        tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选： CLAMP, MIRROR 和  REPEAT。
        CLAMP （夹子模式？？？算了这个词我不会翻）会在端点之外延续端点处的颜色；MIRROR 是镜像模式；REPEAT 是重复模式。
        具体的看一下例子就明白。
         */

        //在设置了 Shader 的情况下， Paint.setColor/ARGB() 所设置的颜色就不再起作用
        //LinearGradient 线性渐变
        shader = LinearGradient(100f, 100f, 500f, 500f, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP)
        paint.setShader(shader)
        paint.style = Paint.Style.FILL //设置 画线、填充（默认）
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(300f, 300f, 200f, paint)


    }

}