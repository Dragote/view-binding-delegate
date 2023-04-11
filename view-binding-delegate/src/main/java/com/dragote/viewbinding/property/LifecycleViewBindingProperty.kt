package com.dragote.viewbinding.property

import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding

class LifecycleViewBindingProperty<B : ViewBinding>(
    private val lifecycleProvider: () -> Lifecycle,
    viewProvider: () -> View,
    viewBindingFactory: (View) -> B,
) : DefaultLifecycleObserver, ViewBindingProperty<B>(viewProvider, viewBindingFactory) {

    override val viewBinding: B
        get() = super.viewBinding.also {
            lifecycleProvider().addObserver(this)
        }

    override fun onDestroy(owner: LifecycleOwner) {
        clearBinding()
    }
}