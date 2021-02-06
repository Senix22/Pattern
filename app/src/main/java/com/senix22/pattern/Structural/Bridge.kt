package com.senix22.pattern

open class Shape1(private val color:Color1){
    open fun getShapeColor() = color.getColor()
}
open class Rect(color1: Color1) : Shape1(color1){
    override fun getShapeColor(): String {
        return "${super.getShapeColor()} rect"
    }
}

open class Oval(color: Color1):Shape1(color){
    override fun getShapeColor(): String {
        return "Oval"
    }
}


interface Color1{
    fun getColor():String
}

class Red(): Color1{
    override fun getColor(): String {
        return "Red"
    }
}
class Blue() : Color1{
    override fun getColor(): String {
        return "Blue"
    }

}

fun main(){
    val rect = Rect(Red())
    println(rect.getShapeColor())

}
