package com.timelove.viewlearn.fragment

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import com.timelove.viewlearn.R

/**
 * author： bw
 * data：  2017.10.17 10:59
 * description: PageFragment
 */
class PageFragment : Fragment() {

    private var contentView: View? = null//初始化,这里变量不再是空安全的

     var sampleLayoutRes: Int? = null
     var practiceLayoutRes: Int? = null


    object Singele {
        fun getInstance(@LayoutRes sampleLayoutRes: Int, @LayoutRes practiceLayoutRes: Int): Fragment {
            val fragment: PageFragment = PageFragment()
            val args: Bundle = Bundle()
            args.putInt("sampleLayoutRes", sampleLayoutRes)
            args.putInt("practiceLayoutRes", practiceLayoutRes)

            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        contentView = inflater?.inflate(R.layout.fragment_page, container, false)

        val sampleStub = contentView?.findViewById(R.id.sampleStub) as ViewStub
        sampleStub.layoutResource = sampleLayoutRes as Int
        sampleStub.inflate()

        val practiceStub = contentView?.findViewById(R.id.practiceStub) as ViewStub
        practiceStub.layoutResource = practiceLayoutRes as Int
        practiceStub.inflate()

        return contentView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args : Bundle = arguments

        sampleLayoutRes = args.getInt("sampleLayoutRes")
        practiceLayoutRes = args.getInt("practiceLayoutRes")

    }
}