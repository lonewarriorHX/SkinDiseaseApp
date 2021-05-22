package com.example.submission3jetpackhanvey.utility

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DecorationItem(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                top = spaceHeight
            }
            bottom = spaceHeight
        }
    }
}