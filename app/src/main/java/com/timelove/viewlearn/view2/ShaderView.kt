package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.timelove.viewlearn.R

/**
 * author： bw
 * data：  2017.10.16 15:00
 * description: ArcView
 */
class ShaderView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    private var shader: Shader? = null

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

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
        shader = LinearGradient(100f, 100f, 200f, 200f, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP)
        paint.setShader(shader)
        paint.style = Paint.Style.FILL //设置 画线、填充（默认）

        canvas?.drawCircle(100f, 100f, 100f, paint)
        //RadialGradient 辐射渐变
        shader = RadialGradient(300f, 100f, 100f, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP)
        paint.setShader(shader)

        canvas?.drawCircle(300f, 100f, 100f, paint)


        // SweepGradient 扫描渐变
        shader = SweepGradient(500f, 100f, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"))
        paint.setShader(shader)

        canvas?.drawCircle(500f, 100f, 100f, paint)

        // BitmapShader
        /**
         * bitmap：用来做模板的 Bitmap 对象
         *tileX：横向的 TileMode
         *tileY：纵向的 TileMode。
         *
         * 这里图片会显示不全，是因为图片的bitmap 是以画布为大小的，在混合shader 里面单独介绍
         */
        val bitmap: Bitmap = BitmapFactory.decodeResource(resources,
                R.drawable.ic_lufei)
        shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.setShader(shader)

        canvas?.drawCircle(800f, 100f, 100f, paint)

    }

}