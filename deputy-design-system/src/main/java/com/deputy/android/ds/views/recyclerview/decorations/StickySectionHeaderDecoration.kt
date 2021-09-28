package com.deputy.android.ds.views.recyclerview.decorations

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deputy.android.ds.R

abstract class StickySectionHeaderDecoration(
    protected val context: Context
) : StickyHeaderDecoration() {

    protected val view: View = LayoutInflater.from(context).inflate(
        R.layout.view_list_section_header,
        null,
        false
    )

    private val text: TextView

    init {
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        text = view.findViewById(R.id.txt_section_header)
    }

    override fun headerHeightFor(adapterIndex: Int, recyclerViewWidth: Int, recyclerViewHeight: Int): Int {
        updateViewToDraw(getStringForIndex(adapterIndex), recyclerViewWidth, recyclerViewHeight)
        return view.measuredHeight
    }

    override fun getHeaderView(adapterIndex: Int, parent: RecyclerView): View? {
        return if ((0 until parent.adapter!!.itemCount).contains(adapterIndex)) {
            updateViewToDraw(getStringForIndex(adapterIndex), parent.width, parent.height)
            view
        } else {
            null
        }
    }

    abstract fun getStringForIndex(index: Int): String

    private fun updateViewToDraw(dateText: String, recyclerViewWidth: Int, recyclerViewHeight: Int) {
        val widthSpec = View.MeasureSpec.makeMeasureSpec(recyclerViewWidth, View.MeasureSpec.EXACTLY)
        val heightSpec = View.MeasureSpec.makeMeasureSpec(recyclerViewHeight, View.MeasureSpec.AT_MOST)
        text.text = dateText
        view.measure(widthSpec, heightSpec)
        view.layout(0, 0, recyclerViewWidth, view.measuredHeight)
    }
}
