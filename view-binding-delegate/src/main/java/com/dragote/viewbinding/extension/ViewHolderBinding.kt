package com.dragote.viewbinding.extension

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.dragote.viewbinding.property.ViewBindingProperty

fun <B : ViewBinding> RecyclerView.ViewHolder.viewBinding(
    viewBindingFactory: (View) -> B,
): ViewBindingProperty<B> =
    ViewBindingProperty(
        viewProvider = ::itemView,
        viewBindingFactory = viewBindingFactory,
    )