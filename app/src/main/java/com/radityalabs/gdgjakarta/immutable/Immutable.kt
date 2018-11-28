package com.radityalabs.gdgjakarta.immutable

class Immutable {
    private val _list = mutableListOf(1, 2, 3, 5, 6)
    val list: List<Int>
        get() = _list

    fun add(number: Int) {
        _list.add(number)
    }
}

fun main() {
    val imm = Immutable()
    print(imm.list)
    imm.add(10)
    print(imm.list)
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
}
*/
