package com.senix22.pattern.Behavioral

import kotlin.properties.Delegates


interface  ValueChangeListener{
    fun onValueChanged(newValue:String)
}

class PrintingTextChangeListener : ValueChangeListener {
    override fun onValueChanged(newValue: String) {
        println("Text was changed to : $newValue" )
    }
}

class Observer(listener: ValueChangeListener) {
        var text : String by Delegates.observable(
            initialValue = "",
            onChange = {
                    _, _, newValue ->
                listener.onValueChanged(newValue)
            }
        )
}
fun main(array: Array<String>){
    val observableObject = Observer(PrintingTextChangeListener())
    observableObject.text = "Hello"
}