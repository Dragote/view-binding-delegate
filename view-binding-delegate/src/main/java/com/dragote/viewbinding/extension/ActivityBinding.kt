package com.dragote.viewbinding.extension

import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.viewbinding.ViewBinding
import com.dragote.viewbinding.property.LifecycleViewBindingProperty

fun <B : ViewBinding> ComponentActivity.viewBinding(
    viewBindingFactory: (View) -> B,
): LifecycleViewBindingProperty<B> =
    LifecycleViewBindingProperty(
        lifecycleProvider = { lifecycle },
        viewProvider = ::requireView,
        viewBindingFactory = viewBindingFactory,
    )

private fun ComponentActivity.requireView(): View =
    findViewById<ViewGroup>(android.R.id.content).getChildAt(0)