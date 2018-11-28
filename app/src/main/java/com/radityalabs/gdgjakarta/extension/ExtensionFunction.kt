package com.radityalabs.gdgjakarta.extension

/*fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main(args: Array<String>) {
    val l = mutableListOf(1, 2, 3)
    l.swap(0, 2)
    print(l)
}*/

fun main() {
    val p = Price(20)
    val r = p + Price(2)
    print(r.money)
}

data class Price(val money: Int) {
    operator fun plus(other: Price): Price {
        return Price(money + other.money)
    }
}

