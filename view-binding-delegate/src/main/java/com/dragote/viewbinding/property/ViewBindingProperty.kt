package com.dragote.viewbinding.property

import android.view.View
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KProperty

open class ViewBindingProperty<B : ViewBinding>(
    private val viewProvider: () -> View,
    private val viewBindingFactory: (View) -> B,
) {

    private var _viewBinding: B? = null

    open val viewBinding: B
        get() = _viewBinding ?: createViewBinding().also { viewBinding ->
            _viewBinding = viewBinding
        }

    private fun createViewBinding(): B = viewProvider().let(viewBindingFactory)

    operator fun getValue(thisRef: Any, property: KProperty<*>): B = viewBinding

    protected fun clearBinding() {
        _viewBinding = null
    }
}