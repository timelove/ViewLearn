package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.timelove.viewlearn.R

/**
 * author： bw
 * data：  2017.10.25 15:05
 * description: Practice07ColorMatrixColorFilterView
 */
class Practice07ColorMatrixColorFilterView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val colorMatrix: ColorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)
        val colorFilter: ColorFilter = ColorMatrixColorFilter(colorMatrix)
        paint.colorFilter = colorFilter
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawBitmap(bitmap, 0f, 0f, paint)
    }
}