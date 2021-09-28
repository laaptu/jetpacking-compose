package com.deputy.android.ds.utils

import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty

internal class PropertyDelegate<T>(private val delegate: KMutableProperty<T>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return delegate.getter.call()
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        delegate.setter.call(value)
    }
}
