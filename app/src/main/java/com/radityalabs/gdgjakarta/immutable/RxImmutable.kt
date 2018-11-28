package com.radityalabs.gdgjakarta.immutable

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.functions.Function3
import io.reactivex.subjects.BehaviorSubject
import kotlin.properties.Delegates

class RxImmutable {
    private val _signalA = BehaviorSubject.createDefault(0)
    private val _signalB = BehaviorSubject.createDefault(0)
    private val _signalC = BehaviorSubject.createDefault(0)

    val signalA: Observable<Int> by lazy { _signalA.hide() }
    val signalB: Observable<Int> by lazy { _signalB.hide() }
    val signalC: Observable<Int> by lazy { _signalC.hide() }

    var number: Int by Delegates.vetoable(0) { _, oldValue, newValue ->
        val greater = newValue > oldValue
        if (greater) {
            _signalA.onNext(newValue)
        }
        greater
    }
}

class RxWrapping {
    val rxImmutable by lazy { RxImmutable() }

    val isSatisfy: Observable<Int>
        get() = BehaviorSubject.combineLatest(
            rxImmutable.signalA,
            rxImmutable.signalB,
            rxImmutable.signalC, Function3 { a, b, c ->
                a + b + c
            }
        )
}

@SuppressLint("CheckResult")
fun main() {
    val rx = RxWrapping()
    rx.isSatisfy.subscribe {
        println(it)
    }
    rx.rxImmutable.number = 2
}