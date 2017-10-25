package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.timelove.viewlearn.R

/**
 * author： bw
 * data：  2017.10.25 15:05
 * description: Practice06LightingColorFilterView
 */
class Practice06LightingColorFilterView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    val colorFilter: ColorFilter = LightingColorFilter(0x00ffff, 0x000000)

    val colorFilterT: ColorFilter = LightingColorFilter(0xffffff, 0x003000)
    val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.colorFilter = colorFilter
        canvas?.drawBitmap(bitmap, 0f, 0f, paint)

        paint.setColorFilter(colorFilterT)
        canvas?.drawBitmap(bitmap, bitmap.width + 100f, 0f, paint)
    }
}