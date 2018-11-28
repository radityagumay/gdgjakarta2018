package com.radityalabs.gdgjakarta.nullability

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.BehaviorSubject

class Live {
    private val _numbers = mutableListOf(1, 23, 4, 5, 56)
    val number: List<Int>
        get() = _numbers
}

class Signal {
    private val signalA by lazy { BehaviorSubject.createDefault(false).hide() }
    private val signalB by lazy { BehaviorSubject.createDefault(true).hide() }

    val isSatisfy: Observable<Boolean>
        get() = BehaviorSubject.combineLatest(
            signalA,
            signalB, BiFunction { a, b ->
                a and b
            }
        )
}

@SuppressLint("CheckResult")
fun main(args: Array<String>) {
    val signal = Signal()

    signal.isSatisfy.subscribe {
        print(it)
    }
}