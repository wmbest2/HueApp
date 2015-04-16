package com.wmbest.traits

trait Animal {
    val sound: String
    fun speak() {
        println(sound)
    }   
}

trait Swimmer {
    fun swim() {
        println("Splash splash splash")
    }
}

class Duck(): Animal, Swimmer {
    override val sound: String = "Quack"
}
