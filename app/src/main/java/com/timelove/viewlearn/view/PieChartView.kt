package com.timelove.viewlearn.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
/**
 * author： bw
 * data：  2017.10.13 15:44
 * description: PieChartView  扇形图
 */
class PieChartView : View {

    private var radius: Float? = null
    private var datas: Array<Data>? = null
    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿
    private var rectF: RectF = RectF()
    private var total: Float? = null
    private var max: Float? = null

    var startAngle = 0f // 开始的角度
    var sweepAngle: Float? = null //扫过的角度
    var lineAngle: Float? = null //当前扇形一半的角度，用来画线

    var lineStartX = 0f //画线的开始，结束的点
    var lineStartY = 0f
    var lineEndX = 0f
    var lineEndY = 0f

    private fun init() {
        radius = 300f

        datas = arrayOf(Data("Gingerbread", 10.0f, Color.WHITE),
                Data("Ice Cream Sandwich", 18.0f, Color.MAGENTA),
                Data("Jelly Bean", 22.0f, Color.GRAY),
                Data("KitKat", 27.0f, Color.GREEN),
                Data("Lollipop", 40.0f, Color.BLUE),
                Data("Marshmallow", 60.0f, Color.RED),
                Data("Nougat", 33.5f, Color.YELLOW))

        total = 0f

        max = Float.MIN_VALUE

        for (i in datas!!.indices) {
            total = total!! + datas!![i].number

            max = Math.max(max!!, datas!![i].number)
        }

        paint.setStrokeWidth(2f)
        paint.setTextSize(30f)
        rectF = RectF(-300f, -300f, 300f, 300f)
    }

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 将画布(0，0)坐标点移到画布的中心
        canvas?.translate(canvas.width / 2f, canvas.height / 2f)
        startAngle = 0f
        for (i in datas!!.indices) {
            val dataT: Data = datas!![i]

            paint.style = Paint.Style.FILL
            paint.color = dataT.color

            sweepAngle = dataT.number / (total as Float) * 360f
            lineAngle = startAngle + sweepAngle!! / 2;

            //计算画线的坐标点
            lineStartX = radius!! * (Math.cos(lineAngle!! / 180 * Math.PI).toFloat())
            lineStartY = radius!! * (Math.sin(lineAngle!! / 180 * Math.PI).toFloat())
            lineEndX = (radius!! + 30f) * (Math.cos(lineAngle!! / 180 * Math.PI).toFloat())
            lineEndY = (30f + radius!!) * (Math.sin(lineAngle!! / 180 * Math.PI).toFloat())

            if (max == dataT.number) {
                canvas?.save()
                canvas?.translate(lineStartX * 0.1f, lineStartY * 0.1f)
                canvas?.drawArc(rectF, startAngle, sweepAngle!!, true, paint)
            } else {
                //此处为不是最大扇形，控制-1f，控制扇形间距
                canvas?.drawArc(rectF, startAngle - 1f, sweepAngle!! - 1f, true, paint)
            }

            paint.color = Color.WHITE
            paint.style = Paint.Style.STROKE
            canvas?.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, paint)

            if (lineAngle!! > 90f && lineAngle!! < 270f) {
                canvas?.drawLine(lineEndX, lineEndY, lineEndX - 50f, lineEndY, paint)
                paint.style = Paint.Style.FILL
                canvas?.drawText(dataT.name, lineEndX - 50f - 10f - paint.measureText(dataT.name), lineEndY, paint)
            } else {
                canvas?.drawLine(lineEndX, lineEndY, lineEndX + 50f, lineEndY, paint)
                paint.style = Paint.Style.FILL
                canvas?.drawText(dataT.name, lineEndX + 50f + 10f, lineEndY, paint)
            }

            if (max == dataT.number) {
                canvas?.restore()
            }

            startAngle += sweepAngle!!
        }

    }

    data class Data(var name: String, var number: Float, var color: Int)
}