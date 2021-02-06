package com.senix22.pattern.CreationalPatterns

object Singleton {
    var message = "PARIMATCH"

    fun showMessage() {
        println(message)
    }
}

class Test {
    init {
        Singleton.showMessage()
    }
}

fun main() {
    Singleton.showMessage()
    Singleton.message = "Tech"

    val test = Test()
}