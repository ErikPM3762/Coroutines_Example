package com.example.coroutines_example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main () {
    val time = measureTimeMillis {
        for (i in 1..100) {
            Thread {
                Thread.sleep(1)
            }.run()
        }
    }
    println("Tiempo transcurrido $time")
}
// Esta funcion se ejecuta sin corrutinas directamente en el hilo principal

/*fun main () {
    val time = measureTimeMillis {
        runBlocking {
            for (i in 1..100) {
                launch {
                    delay(1)
                }
            }
        }
    }
    println("Tiempo transcurrido $time")
}*/
// Esta funcion se ejecuta con corrutinas la cual trabaja de manera asincrona