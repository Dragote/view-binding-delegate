package com.dragote.viewbinding.extension

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.dragote.viewbinding.property.LifecycleViewBindingProperty

fun <B : ViewBinding> Fragment.viewBinding(
    viewBindingFactory: (View) -> B,
): LifecycleViewBindingProperty<B> =
    LifecycleViewBindingProperty(
        lifecycleProvider = { viewLifecycleOwner.lifecycle },
        viewProvider = ::requireView,
        viewBindingFactory = viewBindingFactory,
    )