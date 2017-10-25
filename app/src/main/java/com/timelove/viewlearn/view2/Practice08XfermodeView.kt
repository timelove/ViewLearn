package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.timelove.viewlearn.R

/**
 * author： bw
 * data：  2017.10.25 15:06
 * description: Practice08XfermodeView
 */
class Practice08XfermodeView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿


    val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    val bitmapT: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)

    val xfermode1: Xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
    val xfermode2: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    val xfermode3: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val saved: Int? = canvas?.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)

        canvas?.drawBitmap(bitmap, 0f, 0f, paint)
        paint.xfermode = xfermode1
        canvas?.drawBitmap(bitmapT, 0f, 0f, paint)

        paint.xfermode = null
        canvas?.drawBitmap(bitmap, bitmap.width + 100f, 0f, paint)
        paint.xfermode = xfermode2
        canvas?.drawBitmap(bitmapT, bitmapT.width + 100f, 0f, paint)
        paint.xfermode = null

        canvas?.drawBitmap(bitmap, bitmap.width + 100f, bitmap.height + 100f, paint)
        paint.xfermode = xfermode3
        canvas?.drawBitmap(bitmapT, bitmapT.width + 100f, bitmapT.height + 20f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(saved!!.toInt())
    }
}