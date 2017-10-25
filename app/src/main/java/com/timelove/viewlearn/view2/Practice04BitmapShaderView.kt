package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.timelove.viewlearn.R

/**
 * author： bw
 * data：  2017.10.16 15:00
 * description: BitmapShader
 */
class Practice04BitmapShaderView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    private var shader: Shader? = null

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        // BitmapShader
        /**
         * bitmap：用来做模板的 Bitmap 对象
         *tileX：横向的 TileMode
         *tileY：纵向的 TileMode。
         *
         * 这里图片会显示不全，是因为图片的bitmap 是以画布为大小的，在混合shader 里面单独介绍
         */
        val bitmap: Bitmap = BitmapFactory.decodeResource(resources,
                R.drawable.batman)
        shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.setShader(shader)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(200f, 200f, 200f, paint)

    }

}