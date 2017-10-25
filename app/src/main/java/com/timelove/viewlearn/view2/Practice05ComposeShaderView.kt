package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.timelove.viewlearn.R

/**
 * author： bw
 * data：  2017.10.25 15:05
 * description: Practice05ComposeShaderView
 */
class Practice05ComposeShaderView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿


    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)

        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val shader: Shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.MIRROR)

        val bitmapT: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        val shaderT: Shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.MIRROR)

        paint.setShader(ComposeShader(shader, shaderT, PorterDuff.Mode.DST_ATOP))
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(200f, 200f, 200f, paint)
    }

}