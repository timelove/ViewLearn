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

class PracticeShaderActivity : AppCompatActivity() {

    var pageModels: ArrayList<PageModel>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_view)

        pageModels?.add(PageModel(R.layout.sample_linear_gradient, R.string.title_linear_gradient, R.layout.practice_linear_gradient))
        pageModels?.add(PageModel(R.layout.sample_radial_gradient, R.string.title_radial_gradient, R.layout.practice_radial_gradient))
        pageModels?.add(PageModel(R.layout.sample_sweep_gradient, R.string.title_sweep_gradient, R.layout.practice_sweep_gradient))
        pageModels?.add(PageModel(R.layout.sample_bitmap_shader, R.string.title_bitmap_shader, R.layout.practice_bitmap_shader))
        pageModels?.add(PageModel(R.layout.sample_compose_shader, R.string.title_compose_shader, R.layout.practice_compose_shader))
        pageModels?.add(PageModel(R.layout.sample_lighting_color_filter, R.string.title_lighting_color_filter, R.layout.practice_lighting_color_filter))
        pageModels?.add(PageModel(R.layout.sample_color_mask_color_filter, R.string.title_color_matrix_color_filter, R.layout.practice_color_matrix_color_filter))
        pageModels?.add(PageModel(R.layout.sample_xfermode, R.string.title_xfermode, R.layout.practice_xfermode))
        pageModels?.add(PageModel(R.layout.sample_stroke_cap, R.string.title_stroke_cap, R.layout.practice_stroke_cap))
        pageModels?.add(PageModel(R.layout.sample_stroke_join, R.string.title_stroke_join, R.layout.practice_stroke_join))
        pageModels?.add(PageModel(R.layout.sample_stroke_miter, R.string.title_stroke_miter, R.layout.practice_stroke_miter))
        pageModels?.add(PageModel(R.layout.sample_path_effect, R.string.title_path_effect, R.layout.practice_path_effect))
        pageModels?.add(PageModel(R.layout.sample_shadow_layer, R.string.title_shader_layer, R.layout.practice_shadow_layer))
        pageModels?.add(PageModel(R.layout.sample_mask_filter, R.string.title_mask_filter, R.layout.practice_mask_filter))
        pageModels?.add(PageModel(R.layout.sample_fill_path, R.string.title_fill_path, R.layout.practice_fill_path))
        pageModels?.add(PageModel(R.layout.sample_text_path, R.string.title_text_path, R.layout.practice_text_path))

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
