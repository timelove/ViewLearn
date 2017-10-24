package com.timelove.viewlearn.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.timelove.viewlearn.R
import com.timelove.viewlearn.fragment.PageFragment
import kotlinx.android.synthetic.main.activity_first_view.*

class FirstViewActivity : AppCompatActivity() {

    var pageModels: ArrayList<PageModel>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_view)

        pageModels?.add(PageModel(R.layout.sample_color, R.string.title_draw_color, R.layout.practice_color))
        pageModels?.add(PageModel(R.layout.sample_circle, R.string.title_draw_circle, R.layout.practice_circle))
        pageModels?.add(PageModel(R.layout.sample_rect, R.string.title_draw_rect, R.layout.practice_rect))
        pageModels?.add(PageModel(R.layout.sample_point, R.string.title_draw_point, R.layout.practice_point))
        pageModels?.add(PageModel(R.layout.sample_oval, R.string.title_draw_oval, R.layout.practice_oval))
        pageModels?.add(PageModel(R.layout.sample_line, R.string.title_draw_line, R.layout.practice_line))
        pageModels?.add(PageModel(R.layout.sample_round_rect, R.string.title_draw_round_rect, R.layout.practice_round_rect))
        pageModels?.add(PageModel(R.layout.sample_arc, R.string.title_draw_arc, R.layout.practice_arc))
        pageModels?.add(PageModel(R.layout.sample_path, R.string.title_draw_path, R.layout.practice_path))
        pageModels?.add(PageModel(R.layout.sample_histogram, R.string.title_draw_histogram, R.layout.practice_histogram))
        pageModels?.add(PageModel(R.layout.sample_pie_chart, R.string.title_draw_pie_chart, R.layout.practice_pie_chart))

        pager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int): Fragment {
                val pageModel: PageModel = pageModels!!.get(position)

                return PageFragment.Singele.getInstance(pageModel.sampleLayoutRes,
                        pageModel.practiceLayoutRes)
            }

            override fun getItemPosition(`object`: Any?): Int {
                return super.getItemPosition(`object`)
            }

            override fun getCount(): Int {
                return pageModels?.size as Int
            }

            override fun getPageTitle(position: Int): CharSequence {
                return getString(pageModels!!.get(position).titleRes)

            }
        }

        tabLayout.setupWithViewPager(pager)

    }

    data class PageModel(@LayoutRes val sampleLayoutRes: Int,
                         @StringRes val titleRes: Int,
                         @LayoutRes val practiceLayoutRes: Int)

}
