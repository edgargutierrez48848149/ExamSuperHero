package com.gentera.yastas.sdk.myapplication.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class VhAdapter<T>(view:View):RecyclerView.ViewHolder(view) {
    abstract fun bind(view: T)
}