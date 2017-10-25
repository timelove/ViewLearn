package com.timelove.viewlearn.view2

import android.content.Context
import android.graphics.Paint
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

/**
 * author： bw
 * data：  2017.10.25 15:08
 * description: Practice15FillPathView
 */
class Practice15FillPathView : View {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) //ANTI_ALIAS_FLAG 抗锯齿

    private var shader: Shader? = null

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }
}