package com.radityalabs.gdgjakarta.immutable

private val _list = mutableListOf(1, 2, 3, 5, 6)
val list: List<Int>
    get() = _list

fun main() {
    print(list)
    _list.add(10)
    print(list)
}


/*
data class Foo(
    val name: String,
    val address: String
)

fun main() {
    val foo = Foo("raditya", "jakarta")
    val bar = foo.copy(name = "foo-bar")
    print(bar)
}*/
